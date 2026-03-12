/*Класс для создания меток и полей для ввода текста. Отвечает за создание и форматирование*/

package com.example.expenses.utils;

import javax.swing.*;
import java.awt.*;

public class UIHelper {
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


}
