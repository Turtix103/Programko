package org.delta.serialization;

import org.delta.storage.Storage;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BankJsonSerializationService {

    public static final String filePath = "accounts.json";

    @Inject
    private StringSerializationService serializationService;

    @Inject
    private Storage storageService;

    @Inject
    private BankJsonDataFactory bankJsonDataFactory;

    public void saveBank() {
        BankJsonData bankJsonData = this.bankJsonDataFactory.createBankJsonData();
        String serializationString = this.serializationService.serialization(bankJsonData);
        this.storageService.save(serializationString, BankJsonSerializationService.filePath);
    }
}
