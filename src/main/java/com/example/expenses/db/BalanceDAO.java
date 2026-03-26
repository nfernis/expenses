/*Класс, предназначенный для работы с таблицей balances*/
package com.example.expenses.db;

import com.example.expenses.ui.MainWindow;
import com.example.expenses.utils.CustomLevel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;


public class BalanceDAO {
    private static final Logger LOGGER = Logger.getLogger(BalanceDAO.class.getName());
    private final Connection connection;

    // Конструктор принимает уже готовое подключение
    public BalanceDAO(Connection connection) {
        this.connection = connection;
    }

    /*получить актуальный баланс на сегодня, который уже был записан в бд*/
    public static float getBalance() throws SQLException {//TODO void заменить на float
        String query = "SELECT balance FROM balances \n" +
                "ORDER BY created_at DESC \n" +
                "LIMIT 1;";
        try (Connection conn = DBConnection.getConnection();  // ← открываем "линию"
             Statement stmt = conn.createStatement();          // ← берём "голос"
             ResultSet rs = stmt.executeQuery(query)) {        // ← говорим и слушаем
            LOGGER.log(CustomLevel.TEST, "Подлючились к supabase из getBalance()");
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
}
