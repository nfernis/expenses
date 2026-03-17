/*Интерфейс главного и начального экрана. Отвечает только за интерфейс, расположение элементов*/

package com.example.expenses.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.URL;
import java.util.logging.Logger;
import java.util.logging.Level;

import com.example.expenses.listener.BalanceFieldListener;
import com.example.expenses.utils.CustomLevel;

import static com.example.expenses.service.BudgetForToday.budgetForToday;
import static com.example.expenses.utils.UIHelper.*;
import static com.example.expenses.utils.UIHelper.createLabel;

import com.example.expenses.service.DaysToSalary;
import com.example.expenses.utils.UIHelper;

public class MainWindow extends JFrame {
    private static final Logger LOGGER = Logger.getLogger(MainWindow.class.getName());

    public MainWindow() {
        //LOGGER.log(CustomLevel.TEST, "Тестовое сообщение");
                                        /*САМО ОКНО*/
        setTitle("Expenses Tracker");//заголовок

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//при нажатии на крестик приложение закрывается
        setLocationRelativeTo(null);//открыть по центру экрана
        setLayout(null);
        setSize(400, 500);

        /*СОЗДАЕМ ПАНЕЛЬ*/
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        Insets insets = getInsets();
        leftPanel.setBounds(0, insets.top, getWidth(), getHeight() - insets.top);
        add(leftPanel);
        setSize(leftPanel.getWidth(), leftPanel.getHeight());

                                        /*КНОПКА РАСХОДЫ*/
        /*JButton showButton = createButton(".");
        leftPanel.add(showButton);
        scaleForShowButton(leftPanel, showButton);//масштабирование около правого края фрейма

        showButton.addActionListener(e -> {

            JPanel rightPanel = new JPanel();
            rightPanel.setLayout(null);
            rightPanel.setBounds(400, 0, 300, 500);
            add(rightPanel);
            rightPanel.setVisible(true);  // показываем правую часть
            leftPanel.repaint();


                                            /*РАСХОДЫ*//*
            String[] types = {"Аренда", "ЖКХ", "Долг", "Я.Музыка", "Интернет"};
            JTextField[] fields = new JTextField[types.length];

            for (int i = 0; i < types.length; i++) { //Добавляет каждый элемент списка

                JLabel label = createLabel(types[i] + ":");
                label.setBounds(30, 30 + i * 70, 80, 25);
                rightPanel.add(label);

                fields[i] = createTextField();
                fields[i].setBounds(110, 30 + i * 70, 150, 25);
                rightPanel.add(fields[i]);
            }
        });

*/
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.RED));

                                            /*БАЛАНС*/
        JLabel balanceLabel = createLabel("Баланс:");
        balanceLabel.setBounds(50, 30, 150, 25);
        leftPanel.add(balanceLabel);

        JTextField balanceText = createTextField();
        balanceText.setBounds(160, 30, 150, 25);
        leftPanel.add(balanceText);


                                        /*БЮДЖЕТ НА СЕГОДНЯ*/
        JLabel budgetLabel = null;
        budgetLabel = UIHelper.createLabel("Бюджет на сегодня: " + "р.");
        budgetLabel.setBounds(50, 170, 300, 25);
        leftPanel.add(budgetLabel);

        balanceText.addActionListener(new BalanceFieldListener(balanceText, budgetLabel));


                                        /*СКОЛЬКО ДНЕЙ ДО ЗП*/
        JLabel daysToSalary = createLabel("Дней до зарплаты: " + new DaysToSalary().getDaysToSalary());
        daysToSalary.setBounds(50, 100, 300, 25);
        leftPanel.add(daysToSalary);










                                                    /*ИКОНКА*/
        URL iconURL = getClass().getClassLoader().getResource("icons/icon.png");//достаем путь в иконке
        LOGGER.info(String.valueOf(iconURL));
        if (iconURL != null) {
            ImageIcon icon = new ImageIcon(iconURL);
            setIconImage(icon.getImage());
            LOGGER.info("iconURL is not null");
        } else {
            LOGGER.warning("iconURL is null or an unexpected error occurred");
        }


    }

}