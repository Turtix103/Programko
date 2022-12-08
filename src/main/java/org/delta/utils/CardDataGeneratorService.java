package org.delta.utils;

import javax.inject.Singleton;
import java.util.Calendar;
import java.util.Random;

@Singleton
public class CardDataGeneratorService {

    final static int cardNumberPartLength = 4;

    final static int cardNumberCountOfPart = 4;

    final static int cardYearExpiration = 5;

    public String generateCardNumber() {
        StringBuilder accountNumber = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < cardNumberCountOfPart; i++) {
            accountNumber.append(rand.nextInt(9999));

            if (i < (cardNumberCountOfPart - 1)) {
                accountNumber.append("-");
            }
        }

        return accountNumber.toString();
    }

    public String generateCvc() {
        Random rand = new Random();

        return String.valueOf(rand.nextInt(999));
    }

    public String generateExpiration() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, cardYearExpiration);

        String month;
        if (calendar.get(Calendar.MONTH) < 10) {
            month = "0" + String.valueOf(calendar.get(Calendar.MONTH));
        } else {
            month = String.valueOf(calendar.get(Calendar.MONTH));
        }

        return calendar.get(Calendar.YEAR) + "-" + month;
    }
}
