package org.delta.account.services;

import org.delta.account.BaseAccount;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MoneyTransferService {
    @Inject
    private BankFeeCalculator bankFeeCalculator;
    @Inject
    private MoneyTransferLoggingService moneyTransferLoggingService;
    @Inject
    private CheckService checkService;

    public MoneyTransferService() {
        this.bankFeeCalculator = new BankFeeCalculator();
    }

    public void transferMoney(BaseAccount sourceAccount, BaseAccount targetAccount, float amount) {

        // log the transfer

        moneyTransferLoggingService.logTransfer(sourceAccount, targetAccount, amount);

        // check

        sourceAccount.subFromBalance(amount);
        targetAccount.addToBalance(amount);

        float transferFee = this.bankFeeCalculator.calculateTransferFee(sourceAccount);
        sourceAccount.subFromBalance(transferFee);
    }

    public void getMoneyWithCheck(Check check, float amount) {

        if (checkService.isCheckValid(check) == false)  {
            System.out.println("tento šek Neexistuje");
            return;
        }

        // log the transfer
     //   moneyTransferLoggingService.logTransfer(sourceAccount, targetAccount, amount);
        // check
        check.account.subFromBalance(amount);

        float transferFee = this.bankFeeCalculator.calculateTransferFee(check.account);
        check.account.subFromBalance(transferFee);
        checkService.useCheck(check);
    }

}
