package br.com.codetalker.chapter05;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class SwingOptions extends JFrame {
    private JRadioButton rb[] = new JRadioButton[3];
    private JCheckBox cb[] = new JCheckBox[3];
    private JLabel lRadio, lCheck;

    public SwingOptions() {
        setTitle("Swing Option Buttons");
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(1, 2));
        JPanel pRadio = new JPanel(new GridLayout(4, 1));
        pRadio.setBorder(BorderFactory.createEtchedBorder());
        JPanel pCheck = new JPanel(new GridLayout(4, 1));
        pCheck.setBorder(BorderFactory.createEtchedBorder());
        RadioItemListener ril = new RadioItemListener();
        CheckItemListener cil = new CheckItemListener();
        ButtonGroup bg = new ButtonGroup();
        for (int i = 0; i < 3; i++) {
            pRadio.add(rb[i] = new JRadioButton("Alternativa " + (i + 1)));
            rb[i].addItemListener(ril);
            bg.add(rb[i]);
            pCheck.add(cb[i] = new JCheckBox("Alternativa " + (i + 1)));
            cb[i].addItemListener(cil);
        }
        pRadio.add(lRadio = new JLabel("Seleção: "));
        cp.add(pRadio);
        pCheck.add(lCheck = new JLabel("Seleção: "));
        cp.add(pCheck);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    private class RadioItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            JRadioButton rb = (JRadioButton) e.getSource();
            String item = rb.getText();
            lRadio.setText("Seleção: " + item.charAt(item.length() - 1));
        }
    }

    private class CheckItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            StringBuffer items = new StringBuffer("Seleção ");
            for (int i = 0; i < 3; i++) {
                items.append(cb[i].isSelected() ? (i + 1) + " " : "");
            }
            lCheck.setText(items.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingOptions().setVisible(true);
            }
        });
    }
}
