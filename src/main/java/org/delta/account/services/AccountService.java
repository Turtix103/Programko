package org.delta.account.services;

import com.google.common.eventbus.EventBus;
import org.delta.account.AccountFactory;
import org.delta.account.AccountType;
import org.delta.account.AccountTypeDoesNotExist;
import org.delta.account.BaseAccount;
import org.delta.notification.persons.NotificationData;
import org.delta.notification.persons.NotifyCustomerEvent;
import org.delta.person.Person;
import org.delta.person.PersonService;
import org.delta.serialization.account.AccountJsonSerializationObject;
import org.delta.utils.AccountNumberGeneratorService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class AccountService {

    private final Map<String, BaseAccount> accounts = new HashMap();

    @Inject
    private AccountFactory accountFactory;

    @Inject
    private AccountNumberGeneratorService accountNumberGeneratorService;

    @Inject
    private PersonService personService;

    @Inject
    private EventBus eventBus;

    public void addAccount(BaseAccount account) {
        this.accounts.put(account.getAccountNumber(), account);
    }

    public BaseAccount findByAccountNumber(String accountNumber) {
        return this.accounts.get(accountNumber);
    }

    public BaseAccount createAccount(AccountType accountType, Person person, float balance) throws AccountTypeDoesNotExist {

        String accountNumber = this.accountNumberGeneratorService.generateAccountNumber();

        BaseAccount account = switch (accountType) {
            case BASE -> this.accountFactory.createBaseAccount(accountNumber, person, balance);
            case STUDENT -> this.accountFactory.createStudentAccount(accountNumber, person, balance);
            case SAVING -> this.accountFactory.createSavingAccount(accountNumber, person, balance);
        };

        if (account == null) {
            throw new AccountTypeDoesNotExist();
        }

        this.addAccount(account);

        return account;
    }

    public BaseAccount[] getAccounts() {
        return this.accounts.values().toArray(new BaseAccount[0]);
    }

    public BaseAccount createAccount(AccountJsonSerializationObject accountJsonSerializationObject) throws AccountTypeDoesNotExist {

        Person person = this.personService.findPersonById(accountJsonSerializationObject.personJsonSerializationObject.id);

        System.out.println(person.getId());
        System.out.println(person.getFullName());

        BaseAccount account = switch (accountJsonSerializationObject.accountType) {
            case BASE -> this.accountFactory.createBaseAccount(accountJsonSerializationObject, person);
            case STUDENT -> this.accountFactory.createStudentAccount(accountJsonSerializationObject, person);
            case SAVING -> this.accountFactory.createSavingAccount(accountJsonSerializationObject, person);
        };

        if (account == null) {
            throw new AccountTypeDoesNotExist();
        }

        this.addAccount(account);

        System.out.println("test?");
        this.eventBus.post(new NotifyCustomerEvent(new NotificationData("test")));

        return account;

    }
}
