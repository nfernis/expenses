package com.example.expenses.db;

import java.sql.SQLException;

public class TestDB {
    public static void main(String[] args) throws SQLException {
        var conn = DBConnection.getConnection();
        if (conn != null) {
            BalanceDAO.getBalance();

            DBConnection.closeConnection();

        } else {
            System.out.println("Не удалось подключиться");
        }
    }
}
