package br.com.codetalker.chapter05;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingButton extends JFrame implements ActionListener {
    private JLabel label1;
    private JButton button1;
    private int count = 0;
    private final String msg = "Número de clicks: ";

    public SwingButton() {
        setTitle("Swing Button");
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.setBackground(Color.orange);
        cp.add(button1 = new JButton("Botão Swing"));
        cp.add(label1 = new JLabel(msg + count));
        button1.addActionListener(this);
        button1.setMnemonic('S');
        button1.setToolTipText("Clique aqui para contar.");
        setSize(300, 75);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        ++count;
        label1.setText(msg + count);
    }

    public static void main(String[] args) {
        new SwingButton().setVisible(true);
    }
}
