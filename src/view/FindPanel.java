/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

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

public class FindPanel extends JFrame implements ActionListener {

    private JPanel contentPane;
    JTextPane jTextPane;
    private int findPosn = 0;
    private String findText = null;
    private boolean findCase = true;
    private boolean replaceConfirm = true;
    private JTextField Find_TextField;

    public FindPanel(JTextPane jt) {
        setResizable(false);
        setTitle("Localizar");

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

    public void doFindText(String find) {
        int nextPosn = 0;

        if (!find.equals(findText)) {
            findPosn = 0;
        }
        nextPosn = nextIndex(jTextPane.getText(), find, findPosn, findCase);

        if (nextPosn >= 0) {
            int rowNumber = getLineNumber(jTextPane, nextPosn);
            nextPosn = rowNumber > 1 ? nextPosn - 1 : nextPosn;
            int finalPosn = rowNumber > 1 ? nextPosn + find.length() - rowNumber + 2 : nextPosn + find.length() - rowNumber + 1;
            jTextPane.setSelectionStart(nextPosn);
            jTextPane.setSelectionEnd(finalPosn);
            findPosn = nextPosn + find.length() - 1;
            findText = find;
        } else if (nextPosn == -1) {
            findPosn = nextPosn;
            JOptionPane.showMessageDialog(null, find + " não foi encontrado!");
        } else {
            findPosn = nextPosn;
            JOptionPane.showMessageDialog(null, "Não existem mais ocorrências da palavra " + find + "!");
        }
    }

    public int getLineNumber(JTextPane component, int pos) {
        int posLine;
        int y = 0;

        try {
            Rectangle2D caretCoords = component.modelToView2D(pos);
            y = (int) caretCoords.getY();
        } catch (BadLocationException ex) {
        }

        int lineHeight = component.getFontMetrics(component.getFont()).getHeight();
        posLine = (y / lineHeight) + 1;
        return posLine;
    }

    public int nextIndex(String input, String find, int start, boolean caseSensitive) {
        int textPosn = -1;
        if (input != null && find != null && start < input.length()) {
            if (caseSensitive == true) {
                textPosn = input.indexOf(find, start);
            } else {
                textPosn = input.toLowerCase().indexOf(find.toLowerCase(),
                        start);
            }
        }
        if (start == input.length() - 1) {
            textPosn = -2;
        }
        return textPosn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Cancelar") {
            this.setVisible(false);
            this.dispose();

        } else if (e.getActionCommand() == "Localizar próxima") {
            doFindText(Find_TextField.getText());
        }
    }
}
