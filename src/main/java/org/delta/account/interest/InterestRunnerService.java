package org.delta.account.interest;

import org.delta.account.AccountWithInterest;
import org.delta.account.BaseAccount;
import org.delta.account.services.AccountService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class InterestRunnerService {

    private InterestCalculator interestCalculator;

    @Inject
    private AccountService accountService;

    public InterestRunnerService() {
        this.interestCalculator = new InterestCalculator();
    }

    public void run() {
        for (BaseAccount account : this.accountService.getAccounts()) {

            if (!(account instanceof AccountWithInterest)) {
                continue;
            }

            float interest = this.interestCalculator.calculateInterest(account);
            account.addToBalance(interest);
        }
    }
}
