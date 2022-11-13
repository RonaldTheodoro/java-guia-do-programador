package br.com.codetalker.chapter05;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingFrame2 extends JFrame {
    public SwingFrame2() {
        super("Swing Frame 2");
        setBounds(50, 50, 200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new JLabel("Janela"));
    }

    public static void main(String[] args) {
        SwingFrame2 principal = new SwingFrame2();
        principal.setVisible(true);
        new SwingDialog(principal, true).setVisible(true);
    }
}
