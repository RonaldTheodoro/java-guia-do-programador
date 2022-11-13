package br.com.codetalker.chapter05;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SwingTextArea extends JFrame implements ItemListener {
    private JTextArea textArea;
    private JRadioButton rbNoWrap, rbWordWrap, rbCharWrap;

    public SwingTextArea() {
        super("SwingTextArea");
        Container cp = getContentPane();
        JPanel pTop = new JPanel(new GridLayout(1, 3, 2, 2));
        pTop.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Quebra de Linha"));
        pTop.add(rbNoWrap = new JRadioButton("Sem quebra", true));
        pTop.add(rbWordWrap = new JRadioButton("Palavras"));
        pTop.add(rbCharWrap = new JRadioButton("Caracteres"));
        cp.add(pTop, "North");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbNoWrap);
        bg.add(rbWordWrap);
        bg.add(rbCharWrap);
        rbNoWrap.addItemListener(this);
        rbWordWrap.addItemListener(this);
        rbCharWrap.addItemListener(this);
        JScrollPane sp = new JScrollPane(textArea = new JTextArea());
        sp.setPreferredSize(new Dimension(300, 150));
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        cp.add(sp, "Center");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void itemStateChanged(ItemEvent arg0) {
        textArea.setLineWrap(!rbNoWrap.isSelected());
        textArea.setWrapStyleWord(rbWordWrap.isSelected());
        textArea.repaint();
    }

    public static void main(String[] args) {
        new SwingTextArea().setVisible(true);
    }

}
