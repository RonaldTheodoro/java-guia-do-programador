package br.com.codetalker.chapter04;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.SystemColor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorderDemo2 extends JFrame {
    private JButton bAbrir, bSalvar, bFechar;
    private JTextArea taEditor;

    public BorderDemo2() {
        super("BorderDemo2");
        setSize(300, 300);
        setBackground(SystemColor.control);
        Container cp = getContentPane();
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        for (int i = 0; i < 3; i++) {
            p1.add(new JLabel(new ImageIcon("selected.gif")));
            p1.add(new JLabel(new ImageIcon("deselected.gif")));
        }

        p1 = new JPanel();

        JPanel p2 = new JPanel(new GridLayout(3, 1, 5, 5));
        p2.add(bAbrir = new JButton("Abrir"));
        p2.add(bSalvar = new JButton("Salvar"));
        p2.add(bFechar = new JButton("Fechar"));
        p1.add(p2);
        cp.add("East", p1);
        cp.add(new JScrollPane(taEditor=new JTextArea()), "Center");
        bFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bFecharClick();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void bFecharClick() {
        System.exit(0);
    }

    public static void main(String[] args) {
        new BorderDemo2().setVisible(true);
    }
}
