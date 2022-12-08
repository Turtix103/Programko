package org.delta.serialization;

import com.google.gson.annotations.SerializedName;
import org.delta.serialization.account.AccountJsonSerializationObject;
import org.delta.serialization.person.PersonJsonSerializationObject;

public class BankJsonData {

    @SerializedName("accounts")
    public AccountJsonSerializationObject[] accountJsonSerializationObjects;

    @SerializedName("persons")
    public PersonJsonSerializationObject[] personJsonSerializationObjects;

}
