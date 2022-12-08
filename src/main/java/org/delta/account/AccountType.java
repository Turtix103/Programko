package org.delta.account;

public enum AccountType {
    BASE, STUDENT, SAVING;

    public static AccountType getAccountTypeFromBaseAccount(BaseAccount baseAccount) {
        if (baseAccount instanceof StudentAccount) {
            return STUDENT;
        }

        if (baseAccount instanceof SavingAccount) {
            return SAVING;
        }

        return BASE;
    }
}
