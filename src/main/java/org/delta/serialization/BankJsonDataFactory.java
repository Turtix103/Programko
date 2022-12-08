package org.delta.serialization;

import org.delta.account.BaseAccount;
import org.delta.account.services.AccountService;
import org.delta.person.Person;
import org.delta.person.PersonService;
import org.delta.serialization.account.AccountJsonSerializationObject;
import org.delta.serialization.account.AccountJsonSerializationObjectFactory;
import org.delta.serialization.person.PersonJsonSerializationObject;
import org.delta.serialization.person.PersonJsonSerializationObjectFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class BankJsonDataFactory {

    @Inject
    private AccountService accountService;

    @Inject
    private PersonService personService;

    @Inject
    private AccountJsonSerializationObjectFactory accountJsonSerializationObjectFactory;

    @Inject
    private PersonJsonSerializationObjectFactory personJsonSerializationObjectFactory;

    public BankJsonData createBankJsonData() {
        BankJsonData bankJsonData = new BankJsonData();

        bankJsonData.accountJsonSerializationObjects = this.createAccountData();
        bankJsonData.personJsonSerializationObjects = this.createPersonData();

        return bankJsonData;
    }

    private PersonJsonSerializationObject[] createPersonData() {
        List<PersonJsonSerializationObject> personJsonSerializationObjects = new ArrayList<>();

        for (Person person : this.personService.getPersons()) {
            personJsonSerializationObjects.add(this.personJsonSerializationObjectFactory.createFromPerson(person));
        }

        return personJsonSerializationObjects.toArray(new PersonJsonSerializationObject[0]);
    }

    private AccountJsonSerializationObject[] createAccountData() {
        List<AccountJsonSerializationObject> accountJsonSerializationObjects = new ArrayList<>();

        for (BaseAccount account : this.accountService.getAccounts()) {
            accountJsonSerializationObjects.add(this.accountJsonSerializationObjectFactory.createFromBaseAccount(account));
        }

        return accountJsonSerializationObjects.toArray(new AccountJsonSerializationObject[0]);
    }

}
