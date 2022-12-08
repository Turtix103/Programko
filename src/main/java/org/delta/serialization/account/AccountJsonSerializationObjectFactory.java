package org.delta.serialization.account;

import org.delta.account.AccountType;
import org.delta.account.BaseAccount;
import org.delta.card.serialization.CartJsonSerializationObjectFactory;
import org.delta.serialization.person.PersonJsonSerializationObjectFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AccountJsonSerializationObjectFactory {

    @Inject
    private PersonJsonSerializationObjectFactory personJsonSerializationObjectFactory;

    @Inject
    private CartJsonSerializationObjectFactory cartJsonSerializationObjectFactory;

    public AccountJsonSerializationObject createFromBaseAccount(BaseAccount baseAccount) {
        AccountJsonSerializationObject accountJsonSerializationObject = new AccountJsonSerializationObject();
        accountJsonSerializationObject.accountType = AccountType.getAccountTypeFromBaseAccount(baseAccount);
        accountJsonSerializationObject.accountNumber = baseAccount.getAccountNumber();
        accountJsonSerializationObject.personJsonSerializationObject = this.personJsonSerializationObjectFactory.createFromPerson(baseAccount.getOwner());
        accountJsonSerializationObject.balance = baseAccount.getBalance();
        accountJsonSerializationObject.cartJsonSerializationObjects = this.cartJsonSerializationObjectFactory.createFromBaseAccount(baseAccount);

        return accountJsonSerializationObject;
    }

}
