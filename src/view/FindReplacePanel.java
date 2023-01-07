/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

public class FindReplacePanel extends JFrame implements ActionListener {

    private JPanel contentPane;
    JTextPane jTextPane;
    private boolean checkAux;
    private int findPosn = 0;
    private String findText = null;
    private boolean findCase = true;
    private boolean replaceConfirm = true;
    private JTextField Find_TextField;
    private JTextField Replace_TextField;

    public FindReplacePanel(JTextPane jt) {
        setResizable(false);
        setTitle("Localizar e Substituir");
        this.checkAux = false;
        this.jTextPane = jt;
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 215);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton Find = new JButton("Substituir");
        Find.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        Find.setBounds(280, 36, 150, 34);
        contentPane.add(Find);

        JButton FindAll = new JButton("Substituir Todas");
        FindAll.setBounds(280, 66, 150, 34);
        contentPane.add(FindAll);

        JButton Find_Cancel = new JButton("Cancelar");
        Find_Cancel.setBounds(280, 96, 150, 34);
        contentPane.add(Find_Cancel);

        JLabel lblNewLabel = new JLabel("Localizar");
        lblNewLabel.setBounds(10, 54, 75, 23);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabe2 = new JLabel("Substituir");
        lblNewLabe2.setBounds(10, 94, 75, 23);
        contentPane.add(lblNewLabe2);

        Replace_TextField = new JTextField();
        Replace_TextField.setBounds(73, 88, 183, 34);
        contentPane.add(Replace_TextField);
        Replace_TextField.setColumns(10);

        Find_TextField = new JTextField();
        Find_TextField.setBounds(73, 48, 183, 34);
        contentPane.add(Find_TextField);
        Find_TextField.setColumns(10);

        Find.addActionListener(this);
        FindAll.addActionListener(this);
        Find_Cancel.addActionListener(this);

    }

    /*public void doReplaceWords(String find, String replace) {
        int nextPosn = 0;
        if (!find.equals(findText)) {
            findPosn = 0;
        }
        findPosn = 0;
        nextPosn = nextIndex(jTextPane.getText(), find, findPosn, findCase);

        if (nextPosn >= 0) {
            int rowNumber = getLineNumber(jTextPane, nextPosn);
            nextPosn = rowNumber > 1 ? nextPosn - 1 : nextPosn;
            int finalPosn = rowNumber > 1 ? nextPosn + find.length() - rowNumber + 2 : nextPosn + find.length() - rowNumber + 1;
            jTextPane.setSelectionStart(nextPosn);
            jTextPane.setSelectionEnd(finalPosn);
            findPosn = nextPosn + find.length() - 1;
            findText = find;

            int rtn = JOptionPane.YES_OPTION;
            if (replaceConfirm) {
                rtn = JOptionPane.showConfirmDialog(null, "Deseja substituir " + find + " por " + replace + "? ", "Localizar e substituir", JOptionPane.YES_NO_CANCEL_OPTION);
            }
            if (!replaceConfirm || rtn == JOptionPane.YES_OPTION) {
                jTextPane.replaceSelection(replace);
            } else if (rtn == javax.swing.JOptionPane.CANCEL_OPTION) {
                return;
            }
        } else if (nextPosn == -1) {
            findPosn = nextPosn;
            JOptionPane.showMessageDialog(null, find + " não foi encontrado!");
        } else {
            findPosn = nextPosn;
            JOptionPane.showMessageDialog(null, "Não existem mais ocorrências da palavra " + find + "!");
        }
    }*/
    public void findAndReplaceText(JTextComponent component, String patteren, String replace) {
        Document document = component.getDocument();

        try {
            int index = this.findPosn;
            String find = patteren;
            for (; index + find.length() <= document.getLength(); index++) {
                String match = document.getText(index, find.length());
                if (find.equals(match)) {
                    /*javax.swing.text.DefaultHighlighter.DefaultHighlightPainter highlightPainter
                            = new javax.swing.text.DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
                   component.getHighlighter().addHighlight(index, index + find.length(),
                            highlightPainter);*/// Seleciona todos */
                    component.setSelectionStart(index);
                    component.setSelectionEnd(index + find.length());
                    this.findPosn = index + find.length() - 1;
                    this.checkAux = true;
                    int rtn = JOptionPane.YES_OPTION;
                    if (replaceConfirm) {
                        rtn = JOptionPane.showConfirmDialog(null, "Deseja substituir " + find + " por " + replace + "? ", "Localizar e substituir", JOptionPane.YES_NO_CANCEL_OPTION);
                    }
                    if (!replaceConfirm || rtn == JOptionPane.YES_OPTION) {
                        jTextPane.replaceSelection(replace);
                    } else if (rtn == javax.swing.JOptionPane.CANCEL_OPTION) {
                        return;
                    }
                    break;
                }
            }
            if (index + find.length() >= document.getLength()) {
                if (!this.checkAux) {
                    JOptionPane.showMessageDialog(null, find + " não foi encontrado!");
                    this.checkAux = false;
                } else {
                    JOptionPane.showMessageDialog(null, "Não existem mais ocorrências da palavra " + find + "!");
                    this.findPosn = 0;
                    this.checkAux = false;
                }
            }
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    public void findAndReplaceAllText(JTextComponent component, String patteren, String replace) {
        Document document = component.getDocument();

        try {
            int index = this.findPosn;
            String find = patteren;
            for (; index + find.length() <= document.getLength(); index++) {
                String match = document.getText(index, find.length());
                if (find.equals(match)) {
                    javax.swing.text.DefaultHighlighter.DefaultHighlightPainter highlightPainter
                            = new javax.swing.text.DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
                    component.getHighlighter().addHighlight(index, index + find.length(),
                            highlightPainter);
                    // component.setSelectionStart(index);
                    // component.setSelectionEnd(index + find.length());
                    this.findPosn = index + find.length() - 1;
                    this.checkAux = true;
                }
            }
            int rtn = JOptionPane.YES_OPTION;
            if (replaceConfirm) {
                rtn = JOptionPane.showConfirmDialog(null, "Deseja substituir todos " + find + " por " + replace + "? ", "Localizar e substituir", JOptionPane.YES_NO_CANCEL_OPTION);
            }
            if (!replaceConfirm || rtn == JOptionPane.YES_OPTION) {
                jTextPane.setText(jTextPane.getText().replaceAll(find, replace));
                component.getHighlighter().removeAllHighlights();
            } else if (rtn == javax.swing.JOptionPane.CANCEL_OPTION) {
                return;
            }
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Cancelar") {
            this.setVisible(false);
            this.dispose();

        } else if (e.getActionCommand() == "Substituir") {
            findAndReplaceText(jTextPane, Find_TextField.getText(), Replace_TextField.getText());
        } else if (e.getActionCommand() == "Substituir Todas") {
            findAndReplaceAllText(jTextPane, Find_TextField.getText(), Replace_TextField.getText());
        }
    }
}
