package com.calculator.voidane.Calculations;

import com.calculator.voidane.CalculatorFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Calculations
{

    private CalculatorFrame calculatorFrame;
    private List<Float> digitHolders = new ArrayList<>();
    private String operatorHolder = null;

    public Calculations(CalculatorFrame calculatorFrame) {
        this.calculatorFrame = calculatorFrame;
    }

    public void equateValues()
    {
        JTextField field = calculatorFrame.getTextField();
        String text = field.getText();
        float total = 0;

        if (operatorHolder == null || digitHolders.size() < 2)
            return;

        if (operatorHolder == "/")
            total = (digitHolders.get(0) / digitHolders.get(1));
        else if (operatorHolder == "-")
            total = (digitHolders.get(0) - digitHolders.get(1));
        else if (operatorHolder == "+")
            total = (digitHolders.get(0) + digitHolders.get(1));
        else if (operatorHolder == "*")
            total = ( digitHolders.get(0) * digitHolders.get(1));

        calculatorFrame.setInfoDoc
                (digitHolders.get(0) + " " + this.operatorHolder + " " + digitHolders.get(1) + " = " + total);

        digitHolders.remove(1);
        digitHolders.remove(0);
        operatorHolder = null;
        text = total + "";
        field.setText(text);

    }

    public void addNewValue()
    {
        if (digitHolders.isEmpty())
            return;

        String text = calculatorFrame.getTextField().getText();
        digitHolders.add(Float.parseFloat(text));
        calculatorFrame.getTextField().setText("");
        getAllHolders();
    }

    public void addOperatorAndValue(String field, String op)
    {
        char[] list = field.toCharArray();

        for ( int i = 0 ; i < list.length ; i++ )
        {
            if (Character.isDigit(list[i]))
            {
                operatorHolder = op;
                float num = Float.parseFloat(field);
                digitHolders.add(num);
                getAllHolders();
                return;
            }
        }
    }

    private void getAllHolders()
    {
        String text = "";
        for ( int i = 0 ; i < digitHolders.size() ; i++ )
        {
            text += i + "=" + digitHolders.get(i) + "\n" ;
        }
        text += "OP: " + operatorHolder;
    }

}