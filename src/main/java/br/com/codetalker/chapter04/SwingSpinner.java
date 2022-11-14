package br.com.codetalker.chapter04;

import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SwingSpinner extends JFrame implements ChangeListener {
    private JLabel lAlvo;
    private JSpinner sFontSize;
    private SpinnerNumberModel snm;
    private static String abc = "ABCDEFGHJabcdefghj1234567890";

    public SwingSpinner() {
        super("Swing Spinner");
        Container cp = getContentPane();
        lAlvo = new JLabel(abc);
        cp.add("Center", new JScrollPane(lAlvo));
        snm = new SpinnerNumberModel(lAlvo.getFont().getSize(), 6, 72, 2);
        sFontSize = new JSpinner(snm);
        sFontSize.addChangeListener(this);
        JPanel pAux = new JPanel();
        pAux.add(new JLabel("Tamanho do Fonte"));
        pAux.add(sFontSize);
        cp.add("South", pAux);
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        Font f = lAlvo.getFont(); 
        float valor = snm.getNumber().floatValue();
        lAlvo.setFont(f.deriveFont(valor));
        lAlvo.validate();
    }

    public static void main(String[] args) {
        new SwingSpinner().setVisible(true);
    }
}
