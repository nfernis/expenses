
package com.example.expenses.service;

import com.example.expenses.service.DaysToSalary;
import javax.swing.*;

import java.sql.SQLException;

import static com.example.expenses.db.BalanceDAO.updateBalance;

public class BudgetCalculator {



    // Метод для кнопки "Рассчитать" (название и сигнатура не меняются)
    public static void listenerCalculate(JButton calculateButton, JTextField budget, JLabel budgetLabel) {
        calculateButton.addActionListener(e -> {
            calculateBudget(budget, budgetLabel);
            // а теперь все сохраняем в бд
            try {
                updateBalance(Float.parseFloat(budget.getText()));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    // НОВЫЙ метод для поля ввода (нажатие Enter) — аналогичная логика
    public static void listenerBalanceField(JTextField balanceText, JLabel budgetLabel) {
        balanceText.addActionListener(e -> {
            calculateBudget(balanceText, budgetLabel);
            // а теперь все сохраняем в бд
            try {
                updateBalance(Float.parseFloat(balanceText.getText()));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    // Общая приватная логика расчета (вместо BudgetForToday)
    public static void calculateBudget(JTextField budgetField, JLabel budgetLabel) {
        try {
            String text = budgetField.getText().trim();
            if (text.isEmpty()) {
                budgetLabel.setText("Бюджет на сегодня: — р.");
                return;
            }

            // Встроенная логика из удалённого BudgetForToday
            float balance = Float.parseFloat(text);
            long days = new DaysToSalary().getDaysToSalary();
            float total = balance / days;

            budgetLabel.setText("Бюджет на сегодня: " + String.format("%.2f", total) + " р.");
        } catch (NumberFormatException e) {
            budgetLabel.setText("Бюджет на сегодня: ошибка!");
        }
    }



}