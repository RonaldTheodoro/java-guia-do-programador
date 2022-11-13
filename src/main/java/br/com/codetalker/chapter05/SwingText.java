package br.com.codetalker.chapter05;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingText extends JFrame implements ActionListener {
    private JLabel lRes;
    private JButton bConv;
    private JTextField tfC;

    public SwingText() {
        setTitle("Conversor C->F");
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2, 1, 1));
        cp.add(tfC = new JTextField());
        cp.add(new JLabel("Celsius", JLabel.RIGHT));
        cp.add(bConv = new JButton("Converter"));
        cp.add(lRes = new JLabel("Fahrenheit", JLabel.RIGHT));
        tfC.addActionListener(this);
        tfC.setToolTipText("Temperatura em Centigrados");
        bConv.addActionListener(this);
        bConv.setToolTipText("Converte temperatura para Fahrenheit");
        getRootPane().setDefaultButton(bConv);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        try {
            float temp = 1.8f * Float.parseFloat(tfC.getText()) + 32;
            lRes.setText(temp + "F");
        } catch (NumberFormatException nfe) {
            lRes.setText("Valor inválido!");
        }
    }

    public static void main(String[] args) {
        new SwingText().setVisible(true);
    }
}
