/*Класс, предназначенный для работы с таблицей balances*/
package com.example.expenses.db;

import com.example.expenses.ui.MainWindow;
import com.example.expenses.utils.CustomLevel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.util.logging.Logger;


public class BalanceDAO {
    private static final Logger LOGGER = Logger.getLogger(BalanceDAO.class.getName());

    // Конструктор принимает уже готовое подключение


    /*получить актуальный баланс на сегодня, который уже был записан в бд*/
    public static float getBalance() throws SQLException {
        String query = "SELECT balance FROM balances \n" +
                "ORDER BY created_at DESC \n" +
                "LIMIT 1;";
        try (Connection conn = DBConnection.getConnection();  // ← открываем "линию"
             Statement stmt = conn.createStatement();          // ← берём "голос"
             ResultSet rs = stmt.executeQuery(query)) {// ← говорим и слушаем
            LOGGER.info( "Подлючились к supabase из getBalance()");
            if (rs.next()) {
                // 2. Забираем значение из колонки "balance" как float
                return rs.getFloat("balance");
            }
        } catch (Exception e) {
            LOGGER.severe("Не удалось подключиться к supabase из getBalance()");
            throw new SQLException(e);
        }
        return 0f;

    }
    /*записать актуальный баланс на сегодня в бд*/
    public static void updateBalance(float balance) throws SQLException {
        String query ="insert into balances(balance)\n" +
                "values (?)";
        Float getBalance = getBalance();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            LOGGER.info( "Подлючились к supabase из updateBalance()");
            BigDecimal bd = new BigDecimal(balance).setScale(2, RoundingMode.HALF_UP);//хуйня для округления
            ps.setBigDecimal(1, bd);
            if(getBalance != null && Math.abs(getBalance - balance) > 0.01f) {
                ps.executeUpdate();
            }
        } catch (Exception e) {
            LOGGER.severe("Не удалось подключиться к supabase из updateBalance()");
            throw new SQLException(e);
        }
    }

    /**/

}
