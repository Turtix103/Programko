package org.delta.card;

import org.delta.account.BaseAccount;
import org.delta.utils.CardDataGeneratorService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CreditCardCreatorService {

    @Inject
    private CardFactory cardFactory;

    @Inject
    private CreditCardFactory creditCardFactory;

    @Inject
    private CardDataGeneratorService cardDataGeneratorService;

    public CreditCard createCreditCardAndSetIntoAccount(BaseAccount baseAccount, Integer theLimit) {

        String cardNumber = this.cardDataGeneratorService.generateCardNumber();
        String expiration = this.cardDataGeneratorService.generateExpiration();
        String cvc = this.cardDataGeneratorService.generateCvc();

        CreditCard card = this.creditCardFactory.createCreditCard(baseAccount, cardNumber, expiration, cvc, theLimit);
        baseAccount.addCreditCard(card);
        return card;
    }

    public float useCreditCard(CreditCard card, float ammount) {
        if (ammount <= card.limit) {
            card.limit -= ammount;
            return ammount;
        }
        else {
            ammount = card.limit;
            card.limit -= card.limit;
            System.out.println("karta je na limitu");
            return ammount;
        }
    }
}
