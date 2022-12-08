package org.delta.ui.cli.action;

import org.delta.person.Person;
import org.delta.person.PersonService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.InputStreamReader;
import java.util.Scanner;

@Singleton
public class CreatePersonAction implements Action {

    @Inject
    private PersonService personService;

    @Override
    public void processAction() {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        System.out.print("ID: ");
        String id = scanner.next();

        System.out.print("Name: ");
        String name = scanner.next();

        System.out.print("Last Name: ");
        String lastName = scanner.next();

        Person person = this.personService.createPerson(id, name, lastName);

        System.out.println("Person " + person.getFullName() + " was created");

    }
}
