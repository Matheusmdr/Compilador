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

public class FindPanel extends JFrame implements ActionListener {

    private JPanel contentPane;
    private boolean checkAux;
    JTextPane jTextPane;
    private int findPosn = 0;
    private String findText = null;
    private boolean findCase = true;
    private boolean replaceConfirm = true;
    private JTextField Find_TextField;

    public FindPanel(JTextPane jt) {
        setResizable(false);
        setTitle("Localizar");
        this.checkAux = false;
        this.jTextPane = jt;
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 215);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton Find = new JButton("Localizar próxima");
        Find.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        Find.setBounds(280, 46, 150, 34);
        contentPane.add(Find);

        JButton Find_Cancel = new JButton("Cancelar");
        Find_Cancel.setBounds(280, 88, 150, 34);
        contentPane.add(Find_Cancel);

        JLabel lblNewLabel = new JLabel("Localizar");
        lblNewLabel.setBounds(10, 54, 75, 23);
        contentPane.add(lblNewLabel);
        Find_TextField = new JTextField();
        Find_TextField.setBounds(73, 48, 183, 34);
        contentPane.add(Find_TextField);
        Find_TextField.setColumns(10);

        Find.addActionListener(this);
        Find_Cancel.addActionListener(this);
    }

    public void findText(JTextComponent component, String patteren) {
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
                    break;
                }
            }
            if (index + find.length() > document.getLength()) {
                if (!this.checkAux) {
                    JOptionPane.showMessageDialog(null, find + " não foi encontrado!");
                    this.findPosn = 0;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Cancelar") {
            this.setVisible(false);
            this.dispose();

        } else if (e.getActionCommand() == "Localizar próxima") {
            findText(jTextPane, Find_TextField.getText());
        }
    }
}
