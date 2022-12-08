package org.delta;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import org.delta.serialization.GsonSerializationService;
import org.delta.serialization.StringSerializationService;
import org.delta.storage.FileSystemStorage;
import org.delta.storage.Storage;
import org.delta.ui.cli.action.*;
import org.delta.ui.cli.menu.MenuChoices;

public class BankInjector extends AbstractModule {

    private EventBus eventBus = new EventBus("Default EventBus");

    @Override
    protected void configure() {
        this.bind(Storage.class).to(FileSystemStorage.class);
        this.bind(StringSerializationService.class).to(GsonSerializationService.class);

        MapBinder<MenuChoices, Action> uriBinder = MapBinder.newMapBinder(binder(), MenuChoices.class, Action.class);
        uriBinder.addBinding(MenuChoices.HELP).to(HelpAction.class);
        uriBinder.addBinding(MenuChoices.CREATE_PERSON).to(CreatePersonAction.class);
        uriBinder.addBinding(MenuChoices.DETAIL).to(DetailAction.class);
        uriBinder.addBinding(MenuChoices.LOAD).to(LoadBankAction.class);
        uriBinder.addBinding(MenuChoices.SAVE).to(SaveBankAction.class);

        this.bind(EventBus.class).toInstance(eventBus);
        bindListener(Matchers.any(), new TypeListener() {
            public <I> void hear(TypeLiteral<I> typeLiteral, TypeEncounter<I> typeEncounter) {
                typeEncounter.register(new InjectionListener<I>() {
                    public void afterInjection(I i) {
                        eventBus.register(i);
                    }
                });
            }
        });
    }
}
