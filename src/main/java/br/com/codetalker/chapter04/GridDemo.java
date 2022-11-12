package br.com.codetalker.chapter04;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Container;

public class GridDemo extends JFrame {
    public GridDemo() {
        setTitle("GridDemo");
        setSize(200, 150);
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 3));
        for (int i = 0; i < 5; i++) {
            JButton b = new JButton("Botão " + (i + 1));
            cp.add(b);
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GridDemo().setVisible(true);
    }
}
