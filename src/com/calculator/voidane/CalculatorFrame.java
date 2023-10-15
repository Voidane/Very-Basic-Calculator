package com.calculator.voidane;

import com.calculator.voidane.Actions.ButtonDigitActions;
import com.calculator.voidane.Actions.ButtonOperators;
import com.calculator.voidane.Actions.ButtonStandardActions;
import com.calculator.voidane.Calculations.Calculations;
import com.calculator.voidane.Listeners.TextfieldInput;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class CalculatorFrame
{

    JFrame frame;
    JTextField textField, infoDoc;
    JButton[] numbers = new JButton[10];
    List<JButton> functioningButtons = new ArrayList<>();
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, negButton;
    JPanel panel;
    Calculations calculations;
    JTextPane logger;
    ButtonOperators operators;

    public CalculatorFrame() {
        frame = new JFrame("calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        logger = new JTextPane();
        logger.setBounds(400,25,300,300);
        logger.setBackground(Color.cyan);
        logger.setText("Logging Information\n\n");

        createFrameButtonNumbers();
        createOperatorButtons();
        CreateStandardButtons();
        calculations = new Calculations(this);

        frame.setBackground(Color.BLUE);
        frame.add(textField);
        frame.add(logger);

        TextfieldInput input = new TextfieldInput(this);
        textField.addKeyListener(input);
        textField.setFocusable(true);

        frame.setVisible(true);
    }

    public JButton getNumButton(int index)
    {
        return this.numbers[index];
    }

    public JFrame getFrame()
    {
        return frame;
    }

    private void CreateStandardButtons()
    {
        ButtonStandardActions buttonStandardActions = new ButtonStandardActions(this);

        decButton = new JButton(".");
        decButton.setActionCommand("DEC");
        decButton.addActionListener(buttonStandardActions);
        decButton.setBounds(170, 340, 50, 50);
        decButton.setBackground(Color.YELLOW);
        frame.add(decButton);

        equButton = new JButton("=");
        equButton.setActionCommand("EQU");
        equButton.addActionListener(buttonStandardActions);
        equButton.setBounds(230, 340, 50, 50);
        equButton.setBackground(Color.YELLOW);
        frame.add(equButton);

        negButton = new JButton("-/+");
        negButton.setActionCommand("NEG");
        negButton.addActionListener(buttonStandardActions);
        negButton.setBounds(50, 340, 50,50);
        negButton.setBackground(Color.YELLOW);
        frame.add(negButton);

        delButton = new JButton("<-");
        delButton.setActionCommand("DEL");
        delButton.addActionListener(buttonStandardActions);
        delButton.setBounds(290, 100, 50, 50);
        delButton.setBackground(Color.RED);
        frame.add(delButton);
    }

    private void createOperatorButtons()
    {
        operators = new ButtonOperators(this);

        divButton = new JButton("/");
        divButton.setActionCommand("/");
        divButton.addActionListener(operators);
        divButton.setBounds(230, 100, 50, 50);
        divButton.setBackground(Color.CYAN);
        frame.add(divButton);

        mulButton = new JButton("*");
        mulButton.setActionCommand("*");
        mulButton.addActionListener(operators);
        mulButton.setBounds(230, 160, 50,50);
        mulButton.setBackground(Color.CYAN);
        frame.add(mulButton);

        subButton = new JButton("-");
        subButton.setActionCommand("-");
        subButton.addActionListener(operators);
        subButton.setBounds(230, 220, 50,50);
        subButton.setBackground(Color.CYAN);
        frame.add(subButton);

        addButton = new JButton("+");
        addButton.setActionCommand("+");
        addButton.addActionListener(operators);
        addButton.setBounds(230, 280, 50,50);
        addButton.setBackground(Color.CYAN);
        frame.add(addButton);
    }

    private void createFrameButtonNumbers()
    {
        int containerX = 30;
        int containerY = 60;

        for ( int i = 0 ; i < numbers.length ; i++ )
            numbers[i] = new JButton();

        numbers[7].setBounds(20,100,40,40);
        numbers[4].setBounds(20,160,40,40);
        numbers[1].setBounds(20,220,40,40);
        numbers[8].setBounds(80,100,40,40);
        numbers[5].setBounds(80,160,40,40);
        numbers[2].setBounds(80,220,40,40);
        numbers[0].setBounds(80,280,40,40);
        numbers[9].setBounds(140,100,40,40);
        numbers[6].setBounds(140,160,40,40);
        numbers[3].setBounds(140,220,40,40);

        ButtonDigitActions digitActions = new ButtonDigitActions(this);

        for ( int i = 0 ; i < numbers.length ; i++ )
        {
            numbers[i].setActionCommand(i + "");
            numbers[i].setText(i + "");
            numbers[i].setToolTipText("Input " + i);
            numbers[i].setBackground(Color.GREEN);
            numbers[i].setBounds(numbers[i].getX()+containerX, numbers[i].getY()+containerY, 50, 50);
            numbers[i].addActionListener(digitActions);
            this.frame.add(numbers[i]);
        }

        frame.revalidate();
        frame.repaint();
    }

    public JTextField getTextField()
    {
        return textField;
    }

    public Calculations getCalculations()
    {
        return calculations;
    }

    public ButtonOperators getOperators()
    {
        return this.operators;
    }

    public void setInfoDoc(String string)
    {
        this.logger.setText(this.logger.getText() + string + "\n");
    }
}
