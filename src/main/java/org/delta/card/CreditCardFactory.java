package org.delta.card;

import org.delta.account.BaseAccount;

import javax.inject.Singleton;

@Singleton
public class CreditCardFactory {

    public CreditCard createCreditCard(BaseAccount baseAccount, String cardNumber, String expiration, String cvc, float theLimit) {
        return new CreditCard(baseAccount, cardNumber, expiration, cvc, theLimit);
    }
}
