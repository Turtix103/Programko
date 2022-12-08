package org.delta.card;

public class CardInfoPrinterService {

    public void printBaseInfo(BaseCard card) {
        System.out.println(":: card number: " + card.getCardNumber() + ", expiration: " + card.getExpiration() + ", cvc: " + card.getCvc());
    }
}
