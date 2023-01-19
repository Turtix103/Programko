package org.delta.account.services;

import org.delta.account.BaseAccount;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class CheckService {

    private final Map<String, Check> checks = new HashMap();

    public void addCheck(Check check) {
        this.checks.put(check.checkNumber, check);
    }

    public void removeCheck(Check check) {
        this.checks.remove(check.checkNumber, check);
    }
    @Inject
    private CheckFactory checkFactory;

    public Check createCheckAndSetIntoAccount(BaseAccount sourceAcc, String checkN) {
        Check check = this.checkFactory.createCheck(sourceAcc, checkN);
        sourceAcc.addCheck(check);
        this.addCheck(check);
        return check;
    }
    public void useCheck(Check check) {
        check.account.removeCheck(check);
        this.removeCheck(check);
    }

    public boolean isCheckValid(Check check) {
        if (checks.containsKey(check.checkNumber))
        return true;

        return false;
    }
}
