package org.delta.ui.cli.action;

import org.delta.account.BaseAccount;
import org.delta.account.services.AccountInfoPrinterService;
import org.delta.account.services.AccountService;
import org.delta.person.Person;
import org.delta.person.PersonInfoPrintService;
import org.delta.person.PersonService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DetailAction implements Action {

    @Inject
    private PersonService personService;

    @Inject
    private AccountService accountService;
    @Inject
    private AccountInfoPrinterService accountInfoPrinterService;

    @Inject
    private PersonInfoPrintService personInfoPrintService;

    @Override
    public void processAction() {

        System.out.println("Persons: ");
        for (Person person : this.personService.getPersons()) {
            this.personInfoPrintService.printPersonInfo(person);
        }
        System.out.println();

        System.out.println("Accounts: ");
        for (BaseAccount account : this.accountService.getAccounts()) {
            this.accountInfoPrinterService.printAccountInfo(account);
        }
        System.out.println();
    }
}
