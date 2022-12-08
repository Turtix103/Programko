package org.delta;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.delta.account.AccountTypeDoesNotExist;
import org.delta.notification.persons.NotifyCustomerEventListener;

public class Main {

    public static void main(String[] args) throws AccountTypeDoesNotExist {

        Injector injector = Guice.createInjector(new BankInjector());
        Bank bank = injector.getInstance(Bank.class);

        injector.getInstance(NotifyCustomerEventListener.class);

      //  bank.startTerminal();
        bank.example();

    }
}
