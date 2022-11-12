package br.com.codetalker.chapter04;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Container;

public class FlowDemo extends JFrame {
    public FlowDemo() {
        setTitle("FlowDemo");
        setSize(200, 150);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        for (int i = 0; i < 5; i++) {
            JButton b = new JButton("Botão " + (i + 1));
            b.setBounds(10 + i * 90, 30, 90, 20);
            cp.add(b);
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new FlowDemo().setVisible(true);
    }
}
