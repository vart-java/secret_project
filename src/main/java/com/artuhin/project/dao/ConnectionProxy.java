package com.artuhin.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.Connection.TRANSACTION_REPEATABLE_READ;

public class ConnectionProxy implements AutoCloseable {

    private final Connection connection;
    private boolean isTransactionActive;

    public ConnectionProxy(Connection connection) {
        this.connection = connection;
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    public void setAutoCommit(boolean autoCommit) throws SQLException {
        connection.setAutoCommit(autoCommit);
        connection.setTransactionIsolation(TRANSACTION_REPEATABLE_READ);
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }

    @Override
    public void close() throws SQLException {
        if (!isTransactionActive) {
            connection.close();
        }
    }

    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return connection.prepareStatement(sql, autoGeneratedKeys);
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public boolean isTransactionActive() {
        return isTransactionActive;
    }

    public void setTransactionActive(boolean transactionActive) {
        isTransactionActive = transactionActive;
    }
}
