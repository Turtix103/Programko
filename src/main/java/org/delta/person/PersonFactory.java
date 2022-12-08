package org.delta.person;

import org.delta.serialization.person.PersonJsonSerializationObject;

import javax.inject.Singleton;

@Singleton
public class PersonFactory {

    public Person createPerson(String id, String name, String lastName) {
        return new Person(id, name, lastName);
    }

    public Person createPerson(PersonJsonSerializationObject personJsonSerializationObject) {
        return this.createPerson(
                personJsonSerializationObject.id,
                personJsonSerializationObject.firstName,
                personJsonSerializationObject.lastName
        );
    }

}
