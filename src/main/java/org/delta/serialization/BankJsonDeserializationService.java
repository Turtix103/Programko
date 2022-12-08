package org.delta.serialization;

import org.delta.account.AccountTypeDoesNotExist;
import org.delta.account.services.AccountService;
import org.delta.person.PersonService;
import org.delta.serialization.account.AccountJsonSerializationObject;
import org.delta.serialization.person.PersonJsonSerializationObject;
import org.delta.storage.Storage;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BankJsonDeserializationService {

    @Inject
    private Storage storageService;

    @Inject
    private StringSerializationService serializationService;

    @Inject
    private AccountService accountService;

    @Inject
    private PersonService personService;

    public void readBank() throws AccountTypeDoesNotExist {
        String jsonDataWithAccount = this.storageService.read(BankJsonSerializationService.filePath);
        BankJsonData bankJsonData = this.serializationService.deserialization(jsonDataWithAccount, BankJsonData.class);

        for (PersonJsonSerializationObject personJsonSerializationObject : bankJsonData.personJsonSerializationObjects) {
            this.personService.createPerson(personJsonSerializationObject);
        }

        for (AccountJsonSerializationObject accountJsonSerializationObject : bankJsonData.accountJsonSerializationObjects) {
            this.accountService.createAccount(accountJsonSerializationObject);

            // TODO cards
        }
    }
}
