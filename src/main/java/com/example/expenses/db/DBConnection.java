/*Класс для создания соединения с БД.
Методы:
initPool() - Инициализация пула (вызывается при старте приложения)
closePool() - Закрытие пула (при завершении приложения)
getConnection() - Получение соединения из пула

hikari используется, потому что стандартный метод занимал 5000мс
*/

package com.example.expenses.db;
import com.example.expenses.utils.CustomLevel;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;
import java.util.logging.Logger;

public class DBConnection {
    private static final Logger LOGGER = Logger.getLogger(DBConnection.class.getName());
    private static HikariDataSource dataSource;

    private static final String URL = "jdbc:postgresql://aws-1-eu-central-1.pooler.supabase.com:6543/postgres";
    private static final String USER = "postgres.znfdtsteycufrmpvlkbf";
    private static final String PASSWORD = "18012001Ujl.16042000Ujl.";

    // Инициализация пула (вызвать один раз при старте приложения)
    public static void initPool() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.setMaximumPoolSize(5);
        config.setMinimumIdle(1);
        config.setConnectionTimeout(10000);
        config.setIdleTimeout(600000);
        config.setMaxLifetime(1800000);

        dataSource = new HikariDataSource(config);
        LOGGER.info("Пул соединений инициализирован");
    }

    // Получение соединения из пула
    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            initPool();
        }
        return dataSource.getConnection();
    }

    // Закрытие пула (при завершении приложения)
    public static void closePool() {
        if (dataSource != null) {
            dataSource.close();
            LOGGER.info("Пул соединений закрыт");
        }
    }

}

