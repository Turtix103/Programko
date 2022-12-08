package org.delta.account;

import org.delta.person.Person;
import org.delta.serialization.account.AccountJsonSerializationObject;

import javax.inject.Singleton;

@Singleton
public class AccountFactory {

    public BaseAccount createBaseAccount(String accountNumber, Person person, float balance) {
        return new BaseAccount(accountNumber, person, balance);
    }

    public StudentAccount createStudentAccount(String accountNumber, Person person, float balance) {
        return new StudentAccount(accountNumber, person, balance);
    }

    public SavingAccount createSavingAccount(String accountNumber, Person person, float balance) {
        return new SavingAccount(accountNumber, person, balance);
    }

    public BaseAccount createBaseAccount(AccountJsonSerializationObject accountJsonSerializationObject, Person person) {
        return new BaseAccount(accountJsonSerializationObject.accountNumber, person, accountJsonSerializationObject.balance);
    }

    public StudentAccount createStudentAccount(AccountJsonSerializationObject accountJsonSerializationObject, Person person) {
        return new StudentAccount(accountJsonSerializationObject.accountNumber, person, accountJsonSerializationObject.balance);
    }

    public SavingAccount createSavingAccount(AccountJsonSerializationObject accountJsonSerializationObject, Person person) {
        return new SavingAccount(accountJsonSerializationObject.accountNumber, person, accountJsonSerializationObject.balance);
    }
}
