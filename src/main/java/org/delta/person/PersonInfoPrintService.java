package org.delta.person;

import javax.inject.Singleton;

@Singleton
public class PersonInfoPrintService {

    public void printPersonInfo(Person person) {
        System.out.println(person.getFullName());

    }

}
