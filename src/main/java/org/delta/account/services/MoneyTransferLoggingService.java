package org.delta.account.services;

import org.delta.account.BaseAccount;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class MoneyTransferLoggingService {

  /*private List<BaseAccount> sourceAccountList = new ArrayList();
    private List<BaseAccount> targetAccountList = new ArrayList();
    private List<Float> amountList = new ArrayList(); */

    private List<TransferLog> transferLogList = new ArrayList();


    public void logTransfer(BaseAccount sourceAccount, BaseAccount targetAccount, float amount) {
        transferLogList.add(new TransferLog(sourceAccount, targetAccount, amount));
        if (transferLogList.size() > 5) {
            transferLogList.remove(0);
        }
    }

    public void printLogs(){
        for (TransferLog transfer : transferLogList) {
            System.out.println(transfer.sourceAccountLog.getOwner().getFullName() + " " + transfer.targetAccountLog.getOwner().getFullName()  + " " + transfer.amountLog);
        }
        
    }
}
