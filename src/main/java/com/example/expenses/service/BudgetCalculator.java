// TODO Сервис для записи в бд новых данных и расчета бюджета на день для кнопки calculateButton
package com.example.expenses.service;

import com.example.expenses.service.DaysToSalary;
import javax.swing.*;

public class BudgetCalculator {



    // Метод для кнопки "Рассчитать" (название и сигнатура не меняются)
    public static void listenerCalculate(JButton calculateButton, JTextField budget, JLabel budgetLabel) {
        calculateButton.addActionListener(e -> {
            calculateBudget(budget, budgetLabel);
        });
    }

    // НОВЫЙ метод для поля ввода (нажатие Enter) — аналогичная логика
    public static void listenerBalanceField(JTextField balanceText, JLabel budgetLabel) {
        balanceText.addActionListener(e -> {
            calculateBudget(balanceText, budgetLabel);
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
        } catch (NumberFormatException ex) {
            budgetLabel.setText("Бюджет на сегодня: ошибка!");
        }
    }
}