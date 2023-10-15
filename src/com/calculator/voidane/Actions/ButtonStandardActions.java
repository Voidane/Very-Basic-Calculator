package com.calculator.voidane.Actions;

import com.calculator.voidane.Calculations.Calculations;
import com.calculator.voidane.CalculatorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonStandardActions implements ActionListener {

    CalculatorFrame mainFrame;

    public ButtonStandardActions(CalculatorFrame frame)
    {
        this.mainFrame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equalsIgnoreCase("DEL"))
            deleteAction();
        else if (e.getActionCommand().equalsIgnoreCase("DEC"))
            decimalAction();
        else if (e.getActionCommand().equalsIgnoreCase("EQU"))
            equalAction();
        else if (e.getActionCommand().equalsIgnoreCase("NEG"))
            negateAction();
    }

    private void deleteAction()
    {
        JTextField field = mainFrame.getTextField();
        int n = field.getText().length();

        if (n == 0)
            return;

        String text = field.getText();
        text = text.substring(0, n-1);
        field.setText(text);
    }

    private void decimalAction()
    {
        JTextField field = mainFrame.getTextField();
        String text = field.getText();
        int n = text.length();

        if (n == 0 || !text.contains("."))
            field.setText(field.getText() + ".");

    }

    private void equalAction()
    {
        Calculations calculations = mainFrame.getCalculations();
        calculations.addNewValue();
        calculations.equateValues();
    }

    private void negateAction()
    {
        JTextField field = mainFrame.getTextField();
        String text = field.getText();

        if ( text.charAt(0) == '-')
            text = text.substring(1);
        else
            text = "-" + text;

        field.setText(text);
    }
}