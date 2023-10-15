package com.calculator.voidane.Listeners;

import com.calculator.voidane.Actions.ButtonOperators;
import com.calculator.voidane.Calculations.Calculations;
import com.calculator.voidane.CalculatorFrame;
import com.calculator.voidane.CalculatorMain;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextfieldInput implements KeyListener {

    CalculatorFrame mainFrame;
    String specialChar = "/+-.*";

    //Create TextFieldInput with CalculatorFrame for one set of classes.
    public TextfieldInput(CalculatorFrame frame) {
        mainFrame = frame;
    }

    @Override
    public void keyTyped(KeyEvent e) {

        char pressedKey = e.getKeyChar();

        for ( int i = 0 ; i < specialChar.toCharArray().length ; i++ )
        {
            char type = specialChar.charAt(i);

            JTextField field = mainFrame.getTextField();
            String textField = field.getText();
            int n = textField.length();

            // If 1 decimal already exists in the field
            if (textField.contains(".") && e.getKeyChar() == '.')
                e.consume();

            // When an operator is pressed on keyboard
            if (e.getKeyChar() == type)
            {
                ButtonOperators operators = this.mainFrame.getOperators();

                if (e.getKeyChar() == '/')
                    operators.divisionButton();
                else if (e.getKeyChar() == '+')
                    operators.additionButtion();
                else if (e.getKeyChar() == '-')
                    operators.subtractionButton();
                else if (e.getKeyChar() == '*')
                    operators.multiplicationButton();
            }

            // When user types ENTER on keyboard
            if (e.getKeyChar() == KeyEvent.VK_ENTER)
            {
                Calculations calculations = mainFrame.getCalculations();
                calculations.addNewValue();
                calculations.equateValues();
            }
        }

        // If the user pressed a digit
        if (Character.isDigit(e.getKeyChar()))
            return;

        // Delete any other used keys the user may of pressed
        e.consume();
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}