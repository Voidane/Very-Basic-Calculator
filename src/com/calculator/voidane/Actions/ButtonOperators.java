package com.calculator.voidane.Actions;

import com.calculator.voidane.Calculations.Calculations;
import com.calculator.voidane.CalculatorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonOperators implements ActionListener {

    CalculatorFrame frame;

    public ButtonOperators(CalculatorFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equalsIgnoreCase("/"))
            divisionButton();
        else if (e.getActionCommand().equalsIgnoreCase("*"))
            multiplicationButton();
        else if (e.getActionCommand().equalsIgnoreCase("+"))
            additionButtion();
        else if (e.getActionCommand().equalsIgnoreCase("-"))
            subtractionButton();
    }

    public void divisionButton()
    {
        setAndConstraint(frame.getTextField(), frame.getCalculations(), "/");
    }

    public void multiplicationButton()
    {
        setAndConstraint(frame.getTextField(), frame.getCalculations(), "*");
    }

    public void additionButtion()
    {
        setAndConstraint(frame.getTextField(), frame.getCalculations(), "+");
    }

    public void subtractionButton()
    {
        setAndConstraint(frame.getTextField(), frame.getCalculations(), "-");
    }

    private void setAndConstraint(JTextField field, Calculations calculations, String op)
    {
        field = this.frame.getTextField();
        String textField = field.getText();
        int n = textField.length();

        if (n < 1)
            return;

        String num = textField;
        calculations.addOperatorAndValue(num, op);
        calculations.equateValues();
        field.setText("");
    }
}