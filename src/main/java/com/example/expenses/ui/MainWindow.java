/*Интерфейс главного и начального экрана. Отвечает только за интерфейс, расположение элементов*/

package com.example.expenses.ui;
import javax.swing.*;

import java.awt.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Logger;

import static com.example.expenses.db.BalanceDAO.getBalance;
import static com.example.expenses.service.BudgetCalculator.calculateBudget;
import static com.example.expenses.ui.showButton.listener;
import static com.example.expenses.utils.UIHelper.*;
import static com.example.expenses.utils.UIHelper.createLabel;

import com.example.expenses.db.DBConnection;
import com.example.expenses.service.BudgetCalculator;
import com.example.expenses.service.DaysToSalary;
import com.example.expenses.utils.UIHelper;

public class MainWindow extends JFrame {
    private static final Logger LOGGER = Logger.getLogger(MainWindow.class.getName());

    public MainWindow() throws SQLException {
        DBConnection.initPool();
        //LOGGER.log(CustomLevel.TEST, "Тестовое сообщение");
                                        /*САМО ОКНО*/
        setTitle("Expenses Tracker");//заголовок

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//при нажатии на крестик приложение закрывается
        setSize(400, 500);
        setLocationRelativeTo(null);//открыть по центру экрана
        setLayout(null);

        setResizable(false);

        /*СОЗДАЕМ ПАНЕЛИ*/
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBounds(0, 0, 380, 460);
        add(leftPanel);
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.RED));

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(400, 0, 400, 460);
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.RED));



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
        balanceText.setText(String.valueOf(getBalance()));
        leftPanel.add(balanceText);


                                        /*БЮДЖЕТ НА СЕГОДНЯ*/
        JLabel budgetLabel = null;
        budgetLabel = createLabel("Бюджет на сегодня: " + "р.");
        budgetLabel.setBounds(50, 170, 300, 25);
        leftPanel.add(budgetLabel);
        calculateBudget(balanceText, budgetLabel);//насильно вызываем метод для значения баланса по умолчанию


        BudgetCalculator.listenerBalanceField(balanceText, budgetLabel);//а тут уже слушаем энтер или кнопку Рассчитать

        JButton calculateButton = createButton("Рассчитать", leftPanel, 50, budgetLabel.getY() + 70, 130, 25);
        //calculateButton.setContentAreaFilled(false);
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