package br.com.codetalker.chapter05;

import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class SwingDialog extends JDialog {
    public SwingDialog(Frame prop, boolean modal) {
        super(prop, "Swing Dialog", modal);
        setBounds(300, 50, 200, 100);
        add(new JLabel("Dialogo"));
    }
}
