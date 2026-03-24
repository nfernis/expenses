/*Класс для создания меток и полей для ввода текста. Отвечает за создание и форматирование*/

package com.example.expenses.utils;

import com.example.expenses.ui.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

import static javax.swing.UIManager.getInsets;

public class UIHelper {
    private static final Logger LOGGER = Logger.getLogger(MainWindow.class.getName());
    private static final Font DEFAULT_LABEL_FONT = new Font("Segoe UI", Font.BOLD, 14);
    //private static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 20); — если нужен будет заголовок

    /*СОЗДАЕМ МЕТКУ С УКАЗАННЫМ ВЫШЕ ФОРМАТИРОВАНИЕМ*/
    public static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(DEFAULT_LABEL_FONT);
        return label;
    }
    /*ДЛЯ ПОЛЕЙ ВВОДА ТЕКСТА*/
    public static JTextField createTextField() {
        JTextField field = new JTextField();
        field.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return field;
    }

    public static JCheckBox createCheckBox(String text){
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return checkBox;
    }

    public static JButton createButton(String text){
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return button;
    }





    public static void scaleForShowButton(JPanel panel, JButton button){
        SwingUtilities.invokeLater(() -> {
            int panelWidth = panel.getWidth();
            int panelHeight = panel.getHeight();
            int buttonWidth = 30;
            int buttonX = panelWidth - buttonWidth; // прижимаем к правому краю панели
            int buttonY = 0; // сверху панели
            int buttonHeight = panelHeight; // на всю высоту панели

            button.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);

        });
    }




}


