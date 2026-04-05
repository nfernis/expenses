package com.example.expenses.service;

import com.example.expenses.db.BalanceDAO;
import com.example.expenses.utils.CustomLevel;

import javax.swing.*;
import java.util.logging.Logger;

public class EnterExpenses {
    private static final Logger LOGGER = Logger.getLogger(BalanceDAO.class.getName());

    public static void listenerEnterExpenses(JButton enterButton, JTextField[] fields){
        enterButton.addActionListener(e -> {
            for(JTextField i : fields){
                if(!i.getText().isEmpty() && i.getText().matches("\\d+(\\.\\d+)?")){
                    /*метод для записи в БД*/
                    LOGGER.log(CustomLevel.TEST, "Йоу, мы ща все в БД запишем: " + i.getText());

                }
            }

        });



    }
}
