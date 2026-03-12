/*Слушает поле Баланс и вызывает функцию budgetForToday, а после записывает результат в Бюджет на сегодня*/


package com.example.expenses.listener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.example.expenses.service.BudgetForToday;
import javax.swing.*;

public class BalanceFieldListener implements ActionListener {
    private final JTextField balanceField; // <- отсюда читаем
    private final JLabel budgetLabel; // <- сюда записываем

    public BalanceFieldListener(JTextField balanceField, JLabel budgetLabel) {
        this.balanceField = balanceField;
        this.budgetLabel = budgetLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String text = balanceField.getText().trim(); // читаем введенное, удаляем проблемы
            if (text.isEmpty()) {
                budgetLabel.setText("Бюджет на сегодня: — р."); // если пусто
                return;
            }
            float budget = Float.parseFloat(text); // приводим к числу
            float dailyBudget = BudgetForToday.budgetForToday(budget); // вызываем budgetForToday

            budgetLabel.setText("Бюджет на сегодня: " + String.format("%.2f", dailyBudget) + " р."); // результат
        } catch (NumberFormatException ex) {
            budgetLabel.setText("Бюджет на сегодня: ошибка!");
        }
    }




}
