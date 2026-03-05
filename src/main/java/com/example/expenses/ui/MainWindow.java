package com.example.expenses.ui;
import javax.swing.*;
import java.net.URL;
import java.util.logging.Logger;
import java.util.logging.Level;
import com.example.expenses.utils.CustomLevel;

public class MainWindow extends JFrame {
    private static final Logger LOGGER = Logger.getLogger(MainWindow.class.getName());

    public MainWindow() {
        LOGGER.log(CustomLevel.TEST, "Тестовое сообщение");
        setTitle("Expenses Tracker");//заголовок
        setSize(800, 600);//размер окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//при нажатии на крестик приложение закрывается
        setLocationRelativeTo(null);//открыть по центру экрана

        URL iconURL = getClass().getClassLoader().getResource("icons/icon.png");//достаем путь в иконке
        LOGGER.info(String.valueOf(iconURL));
        if(iconURL != null){
            ImageIcon icon = new ImageIcon(iconURL);
            setIconImage(icon.getImage());
            LOGGER.info("iconURL is not null");
        }else{
            LOGGER.warning("iconURL is null or an unexpected error occurred");
        }

    }
}