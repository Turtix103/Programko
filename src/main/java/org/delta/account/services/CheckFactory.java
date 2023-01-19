package org.delta.account.services;

import org.delta.account.BaseAccount;

import javax.inject.Singleton;

@Singleton
public class CheckFactory {

    public Check createCheck(BaseAccount sourceAcc, String checkN) {
        return new Check(sourceAcc, checkN);
    }
}