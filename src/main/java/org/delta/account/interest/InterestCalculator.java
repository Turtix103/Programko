package org.delta.account.interest;

import org.delta.account.AccountWithInterest;
import org.delta.account.BaseAccount;

public class InterestCalculator {

    public float calculateInterest(BaseAccount account) {
        if (!(account instanceof AccountWithInterest)) {
            throw new RuntimeException();
        }

        float interest = ((AccountWithInterest) account).getInterest();
        float balance = account.getBalance();

        return balance / 100 * interest;
    }

}
