package br.com.codetalker.chapter05;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingLabel2 extends JFrame {
    public SwingLabel2() {
        super("Swing Labels com Ícones");
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));
        cp.add(new JLabel("Sem ícone"));
        cp.add(new JLabel(new ImageIcon("meimg/new16.gif")));
        cp.add(new JLabel(new ImageIcon("meimg/print16.gif"), JLabel.RIGHT));
        cp.add(new JLabel("Ajuda", new ImageIcon("meimg/help16.gif"), JLabel.LEFT));
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SwingLabel2().setVisible(true);
    }
}
