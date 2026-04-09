/*Класс, предназначенный для работы с таблицей payments*/
package com.example.expenses.db;

import com.example.expenses.ui.MainWindow;
import com.example.expenses.utils.CustomLevel;

import java.sql.*;
import java.util.logging.Logger;


public class PaymentDAO {
    private static final Logger LOGGER = Logger.getLogger(BalanceDAO.class.getName());

    /*Метод для записи платежей в БД*/
    public static void insertPayment(float amount, String type, boolean is_paid) throws SQLException {
        String query ="insert into payments(type, amount, is_paid)\n" +
                "values (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(query);
            LOGGER.info( "Подлючились к supabase из insertPayment()");
            ps.setString(1, type);        // 1-й знак вопроса -> type
            ps.setFloat(2, amount);       // 2-й знак вопроса -> amount
            ps.setBoolean(3, is_paid);    // 3-й знак вопроса -> is_paid
            ps.executeUpdate();
        }catch (Exception e) {
            LOGGER.severe("Не удалось подключиться к supabase из insertPayment()");
            throw new SQLException(e);
        }



    }



}
