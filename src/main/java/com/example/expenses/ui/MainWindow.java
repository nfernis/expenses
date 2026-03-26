/*Интерфейс главного и начального экрана. Отвечает только за интерфейс, расположение элементов*/

package com.example.expenses.ui;
import javax.swing.*;

import java.net.URL;
import java.util.logging.Logger;

import static com.example.expenses.ui.showButton.listener;
import static com.example.expenses.utils.UIHelper.*;
import static com.example.expenses.utils.UIHelper.createLabel;

import com.example.expenses.service.BudgetCalculator;
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
        setResizable(false);

        /*СОЗДАЕМ ПАНЕЛИ*/
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBounds(0, 0, 380, 460);
        add(leftPanel);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(400, 0, 300, 460);



                                        /*КНОПКА РАСХОДЫ*/
        JButton showButton = createButton("»");
        showButton.setContentAreaFilled(false);   // не заливать фон

        showButton.putClientProperty("JButton.buttonType", "borderless");

        leftPanel.add(showButton);
        scaleForShowButton(leftPanel, showButton);//масштабирование около правого края фрейма
        listener(showButton, this, leftPanel, rightPanel);










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


        BudgetCalculator.listenerBalanceField(balanceText, budgetLabel);

        JButton calculateButton = createButton("Рассчитать");
        //calculateButton.setContentAreaFilled(false);
        calculateButton.putClientProperty("JButton.buttonType", "borderless");
        calculateButton.setBounds(50, budgetLabel.getY() + 70, 130, 25);
        leftPanel.add(calculateButton);
        BudgetCalculator.listenerCalculate(calculateButton, balanceText, budgetLabel);


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