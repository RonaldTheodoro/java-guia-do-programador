package br.com.codetalker.chapter05;

import java.awt.GridLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class SwingList extends JFrame
        implements ItemListener, ListSelectionListener {
    private JRadioButton rb[] = new JRadioButton[3];
    private JList<String> lista;
    private JLabel lSel;
    private String opcoes[] = { "Simples", "Intervalo", "Múltipla" };
    private String elem[] = {
            "um",
            "dois",
            "três",
            "quatro",
            "cinco",
            "seis",
            "sete",
            "oito"
    };

    public SwingList() {
        setTitle("Swing List");
        JPanel pRadio = new JPanel(new GridLayout(1, 3));
        ButtonGroup bg = new ButtonGroup();
        for (int i = 0; i < 3; i++) {
            pRadio.add(rb[i] = new JRadioButton(opcoes[i]));
            rb[i].addItemListener(this);
            bg.add(rb[i]);
        }
        getContentPane().add(pRadio, "North");
        getContentPane().add(
                new JScrollPane(lista = new JList<String>(elem)),
                "Center");
        lista.addListSelectionListener(this);
        getContentPane().add(lSel = new JLabel("Sem Seleção"), "South");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rb[0].setSelected(true);
        pack();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == rb[0]) {
            lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } else if (e.getSource() == rb[1]) {
            lista.setSelectionMode(
                    ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        } else {
            lista.setSelectionMode(
                    ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int itens[] = lista.getSelectedIndices();
        StringBuffer sb = new StringBuffer();
        if (itens.length > 0) {
            for (int i = 0; i < itens.length - 1; i++) {
                sb.append(itens[i]);
                sb.append(",");
            }
            sb.append(itens[itens.length - 1]);
            lSel.setText("Seleção: " + sb.toString());
        } else {
            lSel.setText("Sem seleção");
        }
    }

    public static void main(String[] args) {
        new SwingList().setVisible(true);
    }

}
