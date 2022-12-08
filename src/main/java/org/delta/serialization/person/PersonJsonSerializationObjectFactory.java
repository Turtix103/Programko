package org.delta.serialization.person;

import org.delta.person.Person;

import javax.inject.Singleton;

@Singleton
public class PersonJsonSerializationObjectFactory {

    public PersonJsonSerializationObject createFromPerson(Person person) {
        PersonJsonSerializationObject personJsonSerializationObject = new PersonJsonSerializationObject();
        personJsonSerializationObject.id = person.getId();
        personJsonSerializationObject.firstName = person.getFirstName();
        personJsonSerializationObject.lastName = person.getLastName();

        return personJsonSerializationObject;
    }

}
