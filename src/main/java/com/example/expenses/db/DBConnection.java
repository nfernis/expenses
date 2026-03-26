/*Класс для создания соединения с БД.
Методы:
getConnection() - открыть соединение
closeConnection() - прервать соединение
isConnected() - проверить состояние соединения
*/
package com.example.expenses.db;
import com.example.expenses.utils.CustomLevel;

import java.sql.*;
import java.util.logging.Logger;

public class DBConnection {
    private static final Logger LOGGER = Logger.getLogger(DBConnection.class.getName());

    private static final String URL = "jdbc:postgresql://aws-1-eu-central-1.pooler.supabase.com:6543/postgres";
    private static final String USER = "postgres.znfdtsteycufrmpvlkbf";
    private static final String PASSWORD = "18012001Ujl.16042000Ujl.";

                     /*ОТКРЫТЬ СОЕДИНЕНИЕ*/
    private static Connection connection = null;
    public static Connection getConnection() throws SQLException {
                    /*ЕСЛИ СОЕДИНЕНИЕ ЗАКРЫТО ИЛИ НУЛЬ, ТО ОТКРЫТЬ*/
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                LOGGER.log(CustomLevel.TEST,"Подключение к БД установлено");
            } catch (ClassNotFoundException e) {
                LOGGER.log(CustomLevel.TEST,"Драйвер не найден: " + e.getMessage());
                throw new SQLException("Драйвер PostgreSQL отсутствует", e);
            }
        }
        return connection;
    }

                    /*ЗАКРЫТЬ ОТКРЫТОЕ СОЕДИНЕНИЕ*/
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                LOGGER.log(CustomLevel.TEST,"Соединение закрыто");
            } catch (SQLException e) {
                LOGGER.warning("Ошибка при закрытии: " + e.getMessage());
            }
        }
    }

                     /*ПРОВЕРИТЬ ЕСТЬ СОЕДИНЕНИЕ ИЛИ НЕТ*/
    public static boolean isConnected() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
}

