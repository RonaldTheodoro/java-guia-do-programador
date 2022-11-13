package br.com.codetalker.chapter04;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SwingSlider extends JFrame implements ChangeListener {
    private JLabel lAlvo;
    private JPanel pCenter;
    private JSlider sHoriz, sVert;

    public SwingSlider() {
        super("Swing Slider");
        pCenter = new JPanel(null);
        pCenter.add(lAlvo = new JLabel());
        pCenter.setBackground(Color.white);
        lAlvo.setBorder(BorderFactory.createLineBorder(Color.red, 3));
        sHoriz = new JSlider(JSlider.HORIZONTAL, 20, 200, 20);
        sVert = new JSlider(JSlider.VERTICAL, 20, 140, 20);
        sHoriz.setMinorTickSpacing(20);
        sHoriz.setPaintTicks(true);
        sVert.setMinorTickSpacing(10);
        sVert.setMajorTickSpacing(40);
        sVert.setPaintTicks(true);
        sVert.setPaintLabels(true);
        sVert.setInverted(true);
        sHoriz.addChangeListener(this);
        sVert.addChangeListener(this);
        getContentPane().add(sHoriz, "South");
        getContentPane().add(pCenter, "Center");
        getContentPane().add(sVert, "East");
        setSize(260,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stateChanged(null);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        lAlvo.setSize(sHoriz.getValue(), sVert.getValue());
        setTitle(
                "Swing Slider [" + sHoriz.getValue() + "x" + sVert.getValue() + "]");
        pCenter.doLayout();
    }

    public static void main(String[] args) {
        new SwingSlider().setVisible(true);
    }
}
