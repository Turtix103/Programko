package org.delta.account.services;

import org.delta.account.BaseAccount;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class TransferLog {

    public BaseAccount sourceAccountLog;
    public BaseAccount targetAccountLog;
    public float amountLog;

    public TransferLog(BaseAccount sourceAcc, BaseAccount targetAcc, float am) {
        sourceAccountLog = sourceAcc;
        targetAccountLog = targetAcc;
        amountLog = am;
    }

}
