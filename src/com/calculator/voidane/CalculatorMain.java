package com.calculator.voidane;

import com.calculator.voidane.Actions.ButtonDigitActions;
import com.calculator.voidane.Listeners.TextfieldInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class CalculatorMain {

    public static CalculatorFrame frame;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public static void main(String[] args) {
        frame = new CalculatorFrame();
    }

    public static CalculatorFrame getCalculator()
    {
        return frame;
    }
}