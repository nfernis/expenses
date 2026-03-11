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
        LOGGER.log(CustomLevel.TEST, "Дата сегодня " + nowDay);
        LocalDate salaryDay;

                                        /*РАСЧЕТ ДАТЫ ЗАРПЛАТЫ*/
        if (nowDay.getDayOfMonth() < 10){ //1-9
            salaryDay = LocalDate.of(nowDay.getYear(), nowDay.getMonthValue(), 10);
            LOGGER.log(CustomLevel.TEST, "День зп if " + salaryDay);
        } else if (nowDay.getDayOfMonth() >= 25) {//25-
            salaryDay = LocalDate.of(nowDay.getYear(), nowDay.getMonthValue(), 10)
                    .plusMonths(1);
            LOGGER.log(CustomLevel.TEST, "День зп else if " + salaryDay);
        }else{//10-24
            salaryDay = LocalDate.of(nowDay.getYear(), nowDay.getMonthValue(), 25);
            LOGGER.log(CustomLevel.TEST, "День зп else " + salaryDay);
        }

                                        /*СКОЛЬКО ДНЕЙ ДО ЗАРПЛАТЫ*/
        long daysUntil = ChronoUnit.DAYS.between(nowDay, salaryDay) + 1;
        return daysUntil;
    }
}
