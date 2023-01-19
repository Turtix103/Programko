package org.delta.card;

import org.delta.account.BaseAccount;

public class CreditCard {

    public BaseAccount baseAccount;

    public String cardNumber;

    public String expiration;

    public String cvc;

    public float limit;

    public CreditCard(BaseAccount baseAccount, String cardNumber, String expiration, String cvc, float theLimit) {
        this.baseAccount = baseAccount;
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.cvc = cvc;
        this.limit = theLimit;

    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpiration() {
        return expiration;
    }

    public String getCvc() {
        return cvc;
    }

}
