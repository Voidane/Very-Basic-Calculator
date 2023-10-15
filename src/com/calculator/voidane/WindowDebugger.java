package com.calculator.voidane;

import com.calculator.voidane.CalculatorFrame;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WindowDebugger implements MouseListener {

    JFrame frame;
    boolean devModeOn = false;

    public WindowDebugger()
    {
        if (!devModeOn)
            return;

        CalculatorFrame calculatorMainDebugger = new CalculatorFrame();
        frame = calculatorMainDebugger.getFrame();
        frame.setTitle("Developer Calculator");
        frame.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        int x = e.getX(), y = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}