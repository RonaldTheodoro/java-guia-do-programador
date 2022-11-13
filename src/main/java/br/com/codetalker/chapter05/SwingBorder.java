package br.com.codetalker.chapter05;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class SwingBorder extends JFrame {
    public SwingBorder() {
        setTitle("Border em Painéis");
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 4, 2, 2));
        JPanel p = new JPanel();
        p.setBorder(BorderFactory.createEtchedBorder());
        cp.add(p);
        p = new JPanel();
        p.setBorder(BorderFactory.createLineBorder(Color.orange, 2));
        cp.add(p);
        p = new JPanel();
        p.setBorder(BorderFactory.createLoweredBevelBorder());
        cp.add(p);
        p = new JPanel();
        p.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 3, Color.blue));
        cp.add(p);
        p = new JPanel();
        p.setBorder(
            BorderFactory.createMatteBorder(
                11,
                11,
                11,
                11,
                new ImageIcon("diam-verm.gif")
            )
        );
        cp.add(p);
        p = new JPanel();
        p.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.green, 2),
                BorderFactory.createEtchedBorder()
            )
        );
        cp.add(p);
        p = new JPanel();
        p.setBorder(BorderFactory.createRaisedBevelBorder());
        cp.add(p);
        p = new JPanel();
        p.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLoweredBevelBorder(),
                "Titulo"
            )
        );
        cp.add(p);
        setSize(410, 140);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SwingBorder().setVisible(true);
    }
}
