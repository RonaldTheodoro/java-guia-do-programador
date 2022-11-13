package br.com.codetalker.chapter04;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingColorChooser extends JFrame {
    private JButton bFrameBG, bLabelFg;
    private JLabel lText;
    private Container cp;
    public SwingColorChooser() {
        super("Swing Color Chooser");
        cp = getContentPane();
        lText = new JLabel("Java em Ambientes de Rede");
        cp.add("Center", lText);
        bFrameBG = new JButton("Frame Background");
        bLabelFg = new JButton("Label Foreground");
        JPanel aux = new JPanel(new GridLayout(1, 2));
        aux.add(bFrameBG);
        aux.add(bLabelFg);
        cp.add("South", aux);
        bFrameBG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cp.setBackground(
                    JColorChooser.showDialog(
                        SwingColorChooser.this,
                        "Frame Background",
                        cp.getBackground()
                    )
                );
            }
        });
        bLabelFg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lText.setForeground(
                    JColorChooser.showDialog(
                        SwingColorChooser.this,
                        "Label Background",
                        lText.getForeground()
                    )
                );
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        new SwingColorChooser().setVisible(true);
    }
}
