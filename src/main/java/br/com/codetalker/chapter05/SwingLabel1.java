package br.com.codetalker.chapter05;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingLabel1 extends JFrame {
    public SwingLabel1() {
        super("Swing Labels");
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));
        cp.add(new JLabel("Rótulo à Esquerda"));
        cp.add(new JLabel("Rótulo à Direita", JLabel.RIGHT));
        cp.add(new JLabel("Rótulo Centralizado", JLabel.CENTER));
        cp.add(new JLabel("<html><font color=#FF0000>Swing</font> é <i>diferente</i>!</html>"));
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SwingLabel1().setVisible(true);
    }
}
