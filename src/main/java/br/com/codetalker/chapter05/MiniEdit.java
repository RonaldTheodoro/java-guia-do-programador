package br.com.codetalker.chapter05;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MiniEdit extends JFrame {
    private JTextArea taEditor;
    private static String sArquivo[] = {
            "Nome", "new16.gif", "N",
            "Abrir ...", "open16.gif", "A",
            "Salvar", "save16.gif", "S",
            "Salvar como ...", "saveas16.gif", "c",
            null, null, null,
            "Imprimir ...", "print16.git", "I",
            null, null, null,
            "Sair", "blank16.gif", "r",
    };
    private static String sEditar[] = {
            "Recortar", "cut16.gif", "R",
            "Copiar", "copy16.gif", "C",
            "Colar", "paste16.gif", "o",
            null, null, null,
            "Excluir", "delete16.gif", "x",
            "Selecionar tudo", "blank16.gif", "t",
            null, null, null,
    };
    private static String sAjuda[] = {
            "Ajuda", "help16.gif", "A",
            null, null, null,
            "Sobre ...", "about16;gif", "S",
    };

    public MiniEdit() {
        super("Mini Edit");
        JMenuBar mb = new JMenuBar();
        MenuHandler mh = new MenuHandler();
        mb.add(criaMenu("Arquivo", 'A', sArquivo, mh));
        mb.add(criaMenu("Editar", 'E', sEditar, mh));
        mb.add(criaMenu("Ajudar", 'u', sAjuda, mh));
        setJMenuBar(mb);
        JMenu menu = mb.getMenu(1);
        JMenuItem mi = menu.add(new JCheckBoxMenuItem("Quebra de linha"));
        mi.addActionListener(mh);
        JScrollPane sp = new JScrollPane(taEditor = new JTextArea());
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        getContentPane().add(sp);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JMenu criaMenu(
            String nome,
            int acc,
            String itens[],
            ActionListener al) {
        JMenu menu = new JMenu(nome);
        menu.setMnemonic(acc);
        JMenuItem mi;
        for (int i = 0; i < itens.length; i += 3) {
            if (itens[i] != null) {
                if (itens[i + 1] != null) {
                    ImageIcon icon = new ImageIcon("./images/" + itens[i + 1]);
                    mi = new JMenuItem(itens[i], icon);
                } else {
                    mi = new JMenuItem(itens[i]);
                }
                if (itens[i + 2] != null) {
                    mi.setMnemonic(itens[i + 2].charAt(0));
                    mi.addActionListener(al);
                    menu.add(mi);
                } else {
                    menu.addSeparator();
                }
            }
        }
        return menu;
    }

    public static void main(String[] args) {
        new MiniEdit().setVisible(true);
    }

    private class MenuHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String acao = ((JMenuItem) e.getSource()).getText();
            taEditor.append(acao + "\n");
            if (acao.equals(sArquivo[1 * 3])) {
                JFileChooser dialogo = new JFileChooser();
                int resultado = dialogo.showOpenDialog(MiniEdit.this);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File arqEscolhido = dialogo.getSelectedFile();
                    taEditor.append(
                            "Arquivo: " + arqEscolhido.getName() + "\n");
                }
            } else if (acao.equals(sArquivo[7 * 3])) {
                System.exit(0);
            }
        }
    }
}
