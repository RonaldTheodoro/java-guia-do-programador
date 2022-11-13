package br.com.codetalker.chapter05;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class SwingTabs extends JFrame implements ActionListener {
    private JTabbedPane tabs;
    private JButton bAnt, bProx;

    public SwingTabs() {
        super("Swing Tabs");
        tabs = new JTabbedPane();
        ImageIcon icon = new ImageIcon("selected.gif");
        // Aba 01
        JTextArea ta = new JTextArea();
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        tabs.addTab("Aba 01", icon, new JScrollPane(ta), "Primeira Aba");
        // Aba 02
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        tabs.addTab("Aba 02", icon, panel);
        // Aba 03
        panel = new JPanel();
        panel.add(new JLabel("Conteúdo da Aba 03"));
        tabs.addTab("", icon, panel);
        // Aba 04
        tabs.addTab("Aba 04", new JPanel());
        getContentPane().add(tabs, "Center");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel(new GridLayout(1, 2, 5, 5));
        p2.add(bAnt = new JButton("Anterior"));
        p2.add(bProx = new JButton("Próxima"));
        p1.add(p2);
        getContentPane().add(p1, "South");
        bAnt.addActionListener(this);
        bProx.addActionListener(this);
        setSize(400, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = tabs.getSelectedIndex();
        if (e.getSource() == bAnt) {
            tabs.setSelectedIndex(i > 0 ? i - 1 : tabs.getTabCount() - 1);
        } else {
            tabs.setSelectedIndex(i < tabs.getTabCount() - 1 ? i + 1 : 0);
        }
    }

    public static void main(String[] args) {
        new SwingTabs().setVisible(true);
    }
}
