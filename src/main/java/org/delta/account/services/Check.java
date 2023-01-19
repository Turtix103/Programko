package org.delta.account.services;

import org.delta.account.BaseAccount;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class Check {

    public BaseAccount account;
    public String checkNumber;

    public Check(BaseAccount sourceAcc, String checkN) {
        account = sourceAcc;
        checkNumber = checkN;
    }

}