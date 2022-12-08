package org.delta.account.services;

import org.delta.account.BaseAccount;
import org.delta.account.StudentAccount;

public class BankFeeCalculator {

    private static final float FEE_BASE = 5;

    private static final float FEE_STUDENT = 0;

    public float calculateTransferFee(BaseAccount account) {

        if (account instanceof StudentAccount) {
            return FEE_STUDENT;
        }

        return FEE_BASE;
    }
}
