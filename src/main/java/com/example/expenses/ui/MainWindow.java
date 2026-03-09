package com.example.expenses.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.URL;
import java.util.logging.Logger;
import java.util.logging.Level;
import com.example.expenses.utils.CustomLevel;

import static com.example.expenses.service.BudgetForToday.budgetForToday;
import static com.example.expenses.utils.UIHelper.*;

import com.example.expenses.service.DaysToSalary;

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



                                /*СКОЛЬКО ДНЕЙ ДО ЗП*/

        JLabel daysToSalary = createLabel("Дней до зарплаты: " + new DaysToSalary().getDaysToSalary());
        daysToSalary.setBounds(50, 100, 300, 25);
        panel.add(daysToSalary);

                                 /*БЮДЖЕТ НА СЕГОДНЯ*/

        JLabel budgetLabel = createLabel("Бюджет на сегодня: " + "р.");//TODO
        budgetLabel.setBounds(50, 170, 300, 25);
        panel.add(budgetLabel);

        //Слушатель текста
        balanceText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String text = balanceText.getText().trim();//получаем значение, убираем пробелы
                    if (text.isEmpty()) {
                        budgetLabel.setText("Бюджет на сегодня: — р."); //если пустое поле
                        return;
                    }
                    budgetLabel.setText("Бюджет на сегодня: " + String.format(budgetForToday(text) + " р.")); //если не пустое
                } catch (NumberFormatException ex) {
                    budgetLabel.setText("Бюджет на сегодня: ошибка!");
                }
            }
        });




                                    /*ИКОНКА*/
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