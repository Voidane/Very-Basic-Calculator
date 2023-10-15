package com.calculator.voidane.Actions;

import com.calculator.voidane.CalculatorFrame;
import com.calculator.voidane.CalculatorMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDigitActions implements ActionListener {

    CalculatorFrame mainFrame;

    public ButtonDigitActions(CalculatorFrame main)
    {
        mainFrame = main;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField field = mainFrame.getTextField();
        field.setText(field.getText() + e.getActionCommand());
    }

}