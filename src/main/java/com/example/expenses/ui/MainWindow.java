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
        setSize(800, 600);//размер окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//при нажатии на крестик приложение закрывается
        setLocationRelativeTo(null);//открыть по центру экрана
        setLayout(null);


        /*СОЗДАЕМ ПАНЕЛЬ*/
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 800, 600);
        add(panel);


        /*БАЛАНС*/
        JLabel balanceLabel = createLabel("Баланс:");
        balanceLabel.setBounds(50, 30, 150, 25);
        panel.add(balanceLabel);

        JTextField balanceText = createTextField();
        balanceText.setBounds(160, 30, 150, 25);
        panel.add(balanceText);


        /*БЮДЖЕТ НА СЕГОДНЯ*/
        JLabel budgetLabel = null;
        budgetLabel = UIHelper.createLabel("Бюджет на сегодня: " + "р.");
        budgetLabel.setBounds(50, 170, 300, 25);
        panel.add(budgetLabel);

        balanceText.addActionListener(new BalanceFieldListener(balanceText, budgetLabel));


        /*СКОЛЬКО ДНЕЙ ДО ЗП*/

        JLabel daysToSalary = createLabel("Дней до зарплаты: " + new DaysToSalary().getDaysToSalary());
        daysToSalary.setBounds(50, 100, 300, 25);
        panel.add(daysToSalary);



        /*ЧЕК-БОКСЫ ОПЛАЧЕНО ЛИ ЧТО-ТО*/

        JLabel checkBox = createLabel("Отметь то, что ты уже платила:");
        checkBox.setBounds(450, 30, 300, 25);
        panel.add(checkBox);


        //JLabel homeLabel = ;






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