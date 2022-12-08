package org.delta.ui.cli.action;

import org.delta.account.AccountTypeDoesNotExist;
import org.delta.serialization.BankJsonDeserializationService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LoadBankAction implements Action {

    @Inject
    private BankJsonDeserializationService bankJsonDeserializationService;

    @Override
    public void processAction() {
        try {
            this.bankJsonDeserializationService.readBank();
        } catch (AccountTypeDoesNotExist e) {
            throw new RuntimeException(e);
        }
    }
}
