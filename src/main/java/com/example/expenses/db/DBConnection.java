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

import javax.sql.DataSource;
import java.sql.*;
import java.util.logging.Logger;

public class DBConnection {
    private static final Logger LOGGER = Logger.getLogger(DBConnection.class.getName());


    private static final String URL = "jdbc:postgresql://aws-1-eu-central-1.pooler.supabase.com:6543/postgres?sslmode=require";
    private static final String USER = "postgres.znfdtsteycufrmpvlkbf";
    private static final String PASSWORD = "18012001Ujl.16042000Ujl.";

    // Инициализация пула (вызвать один раз при старте приложения)
    private static final DataSource dataSource;

    // 🚀 Статический блок инициализации — выполняется один раз при старте приложения
    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);

        // ⚙️ Настройки пула для Supabase
        config.setMaximumPoolSize(5);           // Максимум 5 активных соединений
        config.setMinimumIdle(2);               // Держать минимум 2 "тёплых" соединения
        config.setConnectionTimeout(10_000);    // 10 сек ждать свободное соединение
        config.setMaxLifetime(240_000);         // Закрывать соединение через 4 мин (меньше таймаута Supabase)
        config.setKeepaliveTime(30_000);        // Пинговать каждые 30 сек, чтобы соединение не умерло
        config.setValidationTimeout(5_000);     // 5 сек на проверку "живости" соединения

        // 🧪 Опционально: имя пула для логов
        config.setPoolName("SupabasePool");

        dataSource = new HikariDataSource(config);
        LOGGER.info("Пул соединений инициализирован: " + config.getPoolName());
    }
    // 🔗 Метод получения соединения — используется во всём приложении
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // 🧹 Метод для корректного закрытия пула при выходе из приложения
    public static void shutdown() {
        if (dataSource instanceof HikariDataSource hikari) {
            hikari.close();
            LOGGER.info("Пул соединений закрыт");
        }
    }


}

