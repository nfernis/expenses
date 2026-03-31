/*Класс отвечает за определение дня выплат и количества дней до зарплаты*/

package com.example.expenses.service;

import com.example.expenses.ui.MainWindow;
import com.example.expenses.utils.CustomLevel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;


public class DaysToSalary {
    private static final Logger LOGGER = Logger.getLogger(DaysToSalary.class.getName());

    public long getDaysToSalary(){
        LocalDate nowDay = LocalDate.now();
        LocalDate salaryDay;

                                        /*РАСЧЕТ ДАТЫ ЗАРПЛАТЫ*/
        if (nowDay.getDayOfMonth() < 10){ //1-9
            salaryDay = LocalDate.of(nowDay.getYear(), nowDay.getMonthValue(), 10);
        } else if (nowDay.getDayOfMonth() >= 25) {//25-
            salaryDay = LocalDate.of(nowDay.getYear(), nowDay.getMonthValue(), 10)
                    .plusMonths(1);
        }else{//10-24
            salaryDay = LocalDate.of(nowDay.getYear(), nowDay.getMonthValue(), 25);
        }

                                        /*СКОЛЬКО ДНЕЙ ДО ЗАРПЛАТЫ*/
        long daysUntil = ChronoUnit.DAYS.between(nowDay, salaryDay) + 1;
        return daysUntil;
    }
}
