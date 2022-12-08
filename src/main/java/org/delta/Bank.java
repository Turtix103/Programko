package org.delta;

import org.delta.account.AccountType;
import org.delta.account.AccountTypeDoesNotExist;
import org.delta.account.BaseAccount;
import org.delta.account.services.AccountInfoPrinterService;
import org.delta.account.services.AccountService;
import org.delta.account.services.MoneyTransferService;
import org.delta.person.Person;
import org.delta.person.PersonFactory;
import org.delta.ui.cli.action.ActionProcessService;
import org.delta.ui.cli.menu.Menu;
import org.delta.ui.cli.menu.MenuChoices;

import javax.inject.Inject;

public class Bank {

    @Inject
    private ActionProcessService actionProcessService;

    @Inject
    private QuartzScheduler quartzScheduler;
    @Inject
    private MoneyTransferService moneyTransferService;
    @Inject
    private AccountService accountService;
    @Inject
    private PersonFactory personService;
    @Inject
    private AccountInfoPrinterService accountInfoPrinterService;

    public void startTerminal() {
        System.out.println("Hello from bank application!");

        quartzScheduler.registerJobs();

        Menu menu = new Menu();
        //menu.printMenu();

        while (true) {
            MenuChoices choice = menu.read();
            if (choice == MenuChoices.EXIT) {
                // quartzScheduler.cancel
                break;
            }

            this.actionProcessService.processAction(choice);
        }
    }

    public void example() throws AccountTypeDoesNotExist {
        Person owner = this.personService.createPerson("1", "Tomas", "Pesek");
        BaseAccount accountOne = this.accountService.createAccount(AccountType.BASE, owner, 1000);
        BaseAccount accountTwo = this.accountService.createAccount(AccountType.STUDENT, owner, 5000);

        this.moneyTransferService.transferMoney(accountOne, accountTwo, 20);
        this.moneyTransferService.transferMoney(accountOne, accountTwo, 520);
        this.moneyTransferService.transferMoney(accountOne, accountTwo, 430);
        this.moneyTransferService.transferMoney(accountOne, accountTwo, 824);
        this.moneyTransferService.transferMoney(accountOne, accountTwo, 500);
        this.moneyTransferService.transferMoney(accountOne, accountTwo, 500);
        this.moneyTransferService.transferMoney(accountOne, accountTwo, 651);
        this.moneyTransferService.transferMoney(accountOne, accountTwo, 500);
        this.moneyTransferService.transferMoney(accountOne, accountTwo, 750);
        this.moneyTransferService.transferMoney(accountOne, accountTwo, 500);

        this.accountInfoPrinterService.printAccountInfo(accountOne);
        /*Person owner = this.personService.createPerson("1", "Tomas", "Pesek");

        BaseAccount accountOne = this.accountService.createAccount(AccountType.BASE, owner, 1000);
        BaseAccount accountTwo = this.accountService.createAccount(AccountType.STUDENT, owner, 5000);
        BaseAccount accountThree = this.accountService.createAccount(AccountType.SAVING, owner, 10000);

        this.accountInfoPrinterService.printAccountInfo(accountOne);
        this.accountInfoPrinterService.printAccountInfo(accountTwo);
        this.accountInfoPrinterService.printAccountInfo(accountThree);
        System.out.println();

        this.moneyTransferService.transferMoney(accountOne, accountTwo, 500);

        this.accountInfoPrinterService.printAccountInfo(accountOne);
        this.accountInfoPrinterService.printAccountInfo(accountTwo);
        System.out.println();

        interestRunnerService.run();

        this.accountInfoPrinterService.printAccountInfo(accountOne);
        this.accountInfoPrinterService.printAccountInfo(accountTwo);
        this.accountInfoPrinterService.printAccountInfo(accountThree);
        System.out.println();

        this.cardCreatorService.createCardAndSetIntoAccount(accountOne);
        this.accountInfoPrinterService.printAccountInfo(accountOne);

        this.bankJsonSerializationService.saveBank();*/

    }
}
