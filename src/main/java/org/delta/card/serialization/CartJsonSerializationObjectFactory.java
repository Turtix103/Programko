package org.delta.card.serialization;

import org.delta.account.BaseAccount;
import org.delta.card.BaseCard;

import javax.inject.Singleton;
import java.util.LinkedList;
import java.util.List;

@Singleton
public class CartJsonSerializationObjectFactory {

    public CartJsonSerializationObject createFromCart(BaseCard baseCard) {
        CartJsonSerializationObject cartJsonSerializationObject = new CartJsonSerializationObject();
        cartJsonSerializationObject.cardNumber = baseCard.getCardNumber();

        return cartJsonSerializationObject;
    }

    public CartJsonSerializationObject[] createFromBaseAccount(BaseAccount account) {

        List<CartJsonSerializationObject> cartJsonSerializationObjects = new LinkedList<>();

        for (BaseCard card : account.getCards()) {
            cartJsonSerializationObjects.add(this.createFromCart(card));
        }

        return cartJsonSerializationObjects.toArray(new CartJsonSerializationObject[0]);
    }

}
