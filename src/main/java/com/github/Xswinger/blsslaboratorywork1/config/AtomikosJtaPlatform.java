package com.github.Xswinger.blsslaboratorywork1.config;

import org.hibernate.engine.transaction.jta.platform.internal.AbstractJtaPlatform;

import jakarta.transaction.TransactionManager;
import jakarta.transaction.UserTransaction;

public class AtomikosJtaPlatform extends AbstractJtaPlatform {

    static TransactionManager transactionManager;
    static UserTransaction transaction;

    @Override
    protected TransactionManager locateTransactionManager() {
        return transactionManager;
    }

    @Override
    protected UserTransaction locateUserTransaction() {
        return transaction;
    }
}
