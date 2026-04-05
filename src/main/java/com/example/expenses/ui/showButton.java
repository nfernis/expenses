package com.example.expenses.ui;

import javax.swing.*;

import static com.example.expenses.service.EnterExpenses.listenerEnterExpenses;
import static com.example.expenses.utils.UIHelper.*;

public class showButton {
    public static void listener(JButton showButton, JFrame frame, JPanel leftPanel, JPanel rightPanel) {

        final boolean[] isOpen = {false}; //ну типа состояние правой панели

        showButton.addActionListener(e -> {

                    if (isOpen[0] == false) {
                        isOpen[0] = true;
                        showButton.setText("«");
                        frame.add(rightPanel);
                        frame.setSize(leftPanel.getWidth() + rightPanel.getWidth() + showButton.getWidth()+10, 500);
                        rightPanel.setVisible(true);  // показываем правую часть
                        leftPanel.remove(showButton);
                        rightPanel.add(showButton);

                        scaleForShowButton(rightPanel, showButton);

                        leftPanel.repaint(); //обновить панель




                        /*РАСХОДЫ*/
                        String[] types = {"Аренда", "ЖКХ", "Долг", "Я.Музыка", "Интернет"};
                        JTextField[] fields = new JTextField[types.length];
                        JCheckBox[] checkBoxes = new JCheckBox[types.length];

                        for (int i = 0; i < types.length; i++) { //Добавляет каждый элемент списка

                            JLabel label = createLabel(types[i] + ":");
                            label.setBounds(30, 30 + i * 70, 80, 25);
                            rightPanel.add(label);

                            fields[i] = createTextField();
                            fields[i].setBounds(110, 30 + i * 70, 150, 25);
                            rightPanel.add(fields[i]);

                            checkBoxes[i] = createCheckBox("Оплачено");
                            checkBoxes[i].setBounds(270, 30 + i * 70, 150, 25);
                            rightPanel.add(checkBoxes[i]);

                        }
                        JButton enterButton = createButton("Внести", rightPanel, fields[4].getBounds().x,
                                fields[4].getBounds().y + 70, 150, 25);
                        enterButton.setBounds(fields[4].getBounds().x, fields[4].getBounds().y + 70, 150, 25);
                        enterButton.putClientProperty("JButton.buttonType", "borderless");
                        listenerEnterExpenses(enterButton, fields);
                    }else{
                        isOpen[0] = false;
                        frame.remove(rightPanel);
                        frame.setSize(400, 500);
                        rightPanel.remove(showButton);
                        leftPanel.add(showButton);
                        scaleForShowButton(leftPanel, showButton);
                        showButton.setText("»");


                    }

            });
    }
}


