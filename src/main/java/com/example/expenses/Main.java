package com.example.expenses;
import com.example.expenses.ui.MainWindow;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        /*временно*/
        // Глобальная настройка логирования
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.ALL);
        /**/
        //запуск окна
        MainWindow window = new MainWindow();
        window.setVisible(true);
    }
}