/*Главная функция по расчету бюджета на сегодня*/


package com.example.expenses.service;


import com.example.expenses.ui.MainWindow.*;



import java.util.logging.Logger;

public class BudgetForToday {
    private static final Logger LOGGER = Logger.getLogger(BudgetForToday.class.getName());
    //TODO среднее значение коммуналки пока будет 3500
    public static float budgetForToday(float budget){
        float total = budget / new DaysToSalary().getDaysToSalary();
        return total;
    }

}
