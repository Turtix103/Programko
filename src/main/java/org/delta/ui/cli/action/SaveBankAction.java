package org.delta.ui.cli.action;

import org.delta.serialization.BankJsonSerializationService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SaveBankAction implements Action {
    @Inject
    private BankJsonSerializationService bankJsonSerializationService;

    @Override
    public void processAction() {
        this.bankJsonSerializationService.saveBank();
    }
}
