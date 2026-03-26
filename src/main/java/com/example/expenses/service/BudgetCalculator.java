/*TODO Сервис для записи в бд новых данных и расчета бюджета на день для кнопки calculateButton*/
package com.example.expenses.service;

import com.example.expenses.utils.UIHelper;

import javax.swing.*;

import static com.example.expenses.service.BudgetForToday.budgetForToday;

public class BudgetCalculator {
    public static void listenerCalculate(JButton calculateButton, JTextField budget, JLabel budgetLabel){
        calculateButton.addActionListener(e -> {
            try {
                String text = budget.getText().trim();
                if (text.isEmpty()) {
                    budgetLabel.setText("Бюджет на сегодня: — р.");
                    return;
                }
                float total = budgetForToday(Float.parseFloat(text));
                budgetLabel.setText("Бюджет на сегодня: " + String.format("%.2f", total) + " р.");
            } catch (NumberFormatException ex) {
                budgetLabel.setText("Бюджет на сегодня: ошибка!");
            }
        });


    }
}
