package br.com.codetalker.chapter05;

import java.io.File;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SwingSplit extends JFrame implements ListSelectionListener {
    private File corrente, dir[];
    private JList<String> listaDir;
    private JTextArea taInfo;

    public SwingSplit() {
        super("Swing SplitPane");
        corrente = new File(".");
        dir = corrente.listFiles();
        String dirInfo[] = new String[dir.length];
        for (int i = 0; i < dir.length; i++) {
            dirInfo[i] = (dir[i].isDirectory() ? "[D]" : "[F]") + dir[i].getName();
        }
        JSplitPane split1 = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT,
                new JLabel(new ImageIcon("images/mini-j.gif")),
                new JScrollPane(listaDir = new JList<>(dirInfo)));
        JSplitPane split2 = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                split1,
                new JScrollPane(taInfo = new JTextArea()));
        getContentPane().add(split2, "Center");
        split1.setDividerLocation(0.75);
        split2.setDividerLocation(275);
        split2.setOneTouchExpandable(true);
        listaDir.addListSelectionListener(this);
        setSize(500, 175);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int i = listaDir.getSelectedIndex();
        if (i == -1) {
            return;
        }
        StringBuffer sb = new StringBuffer("Nome: " + dir[i].getName() + "\n");
        sb.append("Path: " + dir[i].getPath() + "\n");
        sb.append("Abs Path: " + dir[i].getAbsolutePath() + "\n");
        sb.append("Diretório: " + dir[i].isDirectory() + "\n");
        sb.append("Arquivo: " + dir[i].isFile() + "\n");
        sb.append("Oculto: " + dir[i].isHidden() + "\n");
        sb.append("Last Modif: " + new Date(dir[i].lastModified()).toString() + "\n");
        sb.append("Tamanho: " + dir[i].length() + "\n");
        taInfo.setText(sb.toString());
    }

    public static void main(String[] args) {
        new SwingSplit().setVisible(true);
    }
}
