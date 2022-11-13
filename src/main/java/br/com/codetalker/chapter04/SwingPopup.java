package br.com.codetalker.chapter04;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SwingPopup extends JFrame implements ActionListener {
    private JTextArea output = new JTextArea();
    private JPopupMenu popup = new JPopupMenu();
    private String menuItems[] = {"Recortar", "Copiar", "Colar"};

    public SwingPopup() {
        super("Swing Popup");
        getContentPane().add(new JScrollPane(output), "Center");

        for (String item : menuItems) {
            JMenuItem mi = new JMenuItem(item);
            mi.addActionListener(this);
            popup.add(mi);
        }

        output.addMouseListener(new PopupHandler());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 260);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String acao = ((JMenuItem) e.getSource()).getText();
        if (acao.equals("Recortar")) {
            output.cut();
        } else if (acao.equals("Copiar")) {
            output.copy();
        } else {
            output.paste();
        }
    }

    public static void main(String[] args) {
        new SwingPopup().setVisible(true);
    }

    private class PopupHandler extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            mouseReleased(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.isPopupTrigger()) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }
}
