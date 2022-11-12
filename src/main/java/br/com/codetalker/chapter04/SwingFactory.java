package br.com.codetalker.chapter04;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingFactory {
    public static JLabel createLabel(String labelName) {
        return new JLabel(labelName);
    }

    public static JTextField createTextField() {
        return new JTextField();
    }

    public static JButton createButton(String btnText, String btnToolTip) {
        JButton btn = new JButton(btnText);
        btn.setToolTipText(btnToolTip);
        return btn;
    }

    public static GridLayout createGridLayout() {
        return new GridLayout(3, 2, 5, 5);
    }
}
