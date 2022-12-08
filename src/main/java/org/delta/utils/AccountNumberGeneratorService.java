package org.delta.utils;

import javax.inject.Singleton;
import java.util.Random;

@Singleton
public class AccountNumberGeneratorService {

    final static int accountNumberLength = 10;

    public String generateAccountNumber() {
        StringBuilder accountNumber = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < accountNumberLength; i++) {
            accountNumber.append(rand.nextInt(9));
        }

        return accountNumber.toString();
    }
}
