package br.com.codetalker.chapter05;

import javax.swing.JFrame;

public class SwingFrame1 extends JFrame {
    public SwingFrame1() {
        super("Swing Frame1");
        setBounds(50, 50, 200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SwingFrame1().setVisible(true);
    }
}