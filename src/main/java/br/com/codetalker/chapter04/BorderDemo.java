package br.com.codetalker.chapter04;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;

public class BorderDemo extends JFrame {
    public BorderDemo() {
        setTitle("BorderDemo");
        setSize(200, 200);
        Container cp = getContentPane();
        cp.add(new JButton("Botão 01"), "North");
        cp.add(new JButton("Botão 02"), "South");
        cp.add(new JButton("Botão 03"), "East");
        cp.add(new JButton("Botão 04"), "West");
        cp.add(new JButton("Botão 05"), "Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new BorderDemo().setVisible(true);
    }
}
