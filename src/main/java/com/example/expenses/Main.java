package com.example.expenses;
import com.example.expenses.ui.MainWindow;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) {
        Logger root = Logger.getLogger(""); //корневой логгер
        ConsoleHandler handler = new ConsoleHandler(); //создаем обработчик логгеров
        for (Handler h : root.getHandlers()) {
            if (h != handler) {
                root.removeHandler(h); //удаляем не свои логи, не обработанные
            }
        }
        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                String color = record.getLevel() == Level.INFO ? "\u001B[32m" : //зеленый
                        (record.getLevel().getName().equals("TEST") ? "\u001B[34m" : "\u001B[0m"); //синий
                return color + record.getLevel() + ": " + formatMessage(record) + "\u001B[0m\n";
            }
        });

        root.setLevel(Level.ALL); // обрабатываем все логги
        root.addHandler(handler); //подключаем обработчик к корневому логгеру
        FlatDarkLaf.setup();
        //запуск окна
        MainWindow window = new MainWindow();
        window.setVisible(true);
    }
}