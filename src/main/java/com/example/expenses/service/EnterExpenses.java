/*Класс, предназначенный для внесения планируемых или уже состоявшихся расходов с правой панели*/
package com.example.expenses.service;

import com.example.expenses.db.BalanceDAO;
import com.example.expenses.utils.CustomLevel;

import javax.swing.*;
import java.sql.SQLException;
import java.util.logging.Logger;

import static com.example.expenses.db.PaymentDAO.insertPayment;

public class EnterExpenses {
    private static final Logger LOGGER = Logger.getLogger(BalanceDAO.class.getName());

    public static void listenerEnterExpenses(JButton enterButton, JTextField[] fields){
        enterButton.addActionListener(e -> {
            for(JTextField i : fields){
                if(!i.getText().isEmpty() && i.getText().matches("\\d+(\\.\\d+)?")){

                    /*метод для записи в БД*/
                    try {
                        insertPayment(100, "Аренда", true);
                        LOGGER.log(CustomLevel.TEST, "Йоу, мы ща все в БД запишем: " + i.getText());
                    }catch(SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }

        });



    }
}
