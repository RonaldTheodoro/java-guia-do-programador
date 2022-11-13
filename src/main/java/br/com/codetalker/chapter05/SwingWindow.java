package br.com.codetalker.chapter05;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class SwingWindow extends JWindow {
    public SwingWindow() {
        setLocation(150, 150);
        JLabel label = new JLabel("<HTML><U>Fechar</U></HTML>", JLabel.RIGHT);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        add("North", label);
        add("Center", new JLabel(new ImageIcon("JGP.png")));
        pack();
    }

    public static void main(String[] args) {
        new SwingWindow().setVisible(true);
    }
}
