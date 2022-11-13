package br.com.codetalker.chapter05;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingCombo extends JFrame implements ActionListener {
    private JComboBox combo;
    private JLabel resultado;
    public static final String exemplosPadrao[] = {
            "dd MMMMM yyyy",
            "dd.MM.yy",
            "MM/dd/yy",
            "yyyy.MM.dd hh:mm:ss z",
            "EEE, MMM d, _yy",
            "h:mm a",
            "H:mm:ss:SSS",
            "K:mm a,z",
            "yyyy.MMMMM.dd GGG hh:mm aaa",
    };

    public SwingCombo() {
        super("Swing Combo");
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(4, 1, 2, 2));
        cp.add(new JLabel("Forneça padrão ou selecionar da lista: "));
        cp.add(combo = new JComboBox<String>(exemplosPadrao));
        combo.setEditable(true);
        combo.setAlignmentX(Component.LEFT_ALIGNMENT);
        combo.addActionListener(this);
        cp.add(new JLabel("Hora de Data Atuais", JLabel.LEFT));
        resultado = new JLabel();
        resultado.setForeground(Color.black);
        resultado.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
            )
        );
        cp.add(resultado);
        reformatar(exemplosPadrao[0]);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        reformatar((String) combo.getSelectedItem());
    }

    public void reformatar(String padrao) {
        SimpleDateFormat sdf = new SimpleDateFormat(padrao);
        try {
            resultado.setForeground(Color.black);
            resultado.setText(sdf.format(new Date()));
        } catch (IllegalArgumentException iae) {
            resultado.setForeground(Color.red);
            resultado.setText("Erro: " + iae.getMessage());
        }
    }

    public static void main(String[] args) {
        new SwingCombo().setVisible(true);
    }
}
