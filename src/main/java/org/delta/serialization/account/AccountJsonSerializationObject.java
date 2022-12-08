package org.delta.serialization.account;

import com.google.gson.annotations.SerializedName;
import org.delta.account.AccountType;
import org.delta.card.serialization.CartJsonSerializationObject;
import org.delta.serialization.person.PersonJsonSerializationObject;

public class AccountJsonSerializationObject {

    public AccountType accountType;

    public String accountNumber;

    @SerializedName("owner")
    public PersonJsonSerializationObject personJsonSerializationObject;

    public float balance;

    @SerializedName("cards")
    public CartJsonSerializationObject[] cartJsonSerializationObjects;
}
