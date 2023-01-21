/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import JavaCC.ParseException;
import JavaCC.Token;
import JavaCC.Scanner_1;
import static JavaCC.Scanner_1Constants.tokenImage;
import Utils.TokenManager;
import java.awt.AWTException;

import java_cup.runtime.Symbol;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import static java.lang.System.exit;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.DocumentFilter;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import jflex.exceptions.SilentExit;

/**
 *
 * @author Matheus
 */
public class UI extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    private int size;

    public UI() {
        initComponents();
        TextLineNumber tln = new TextLineNumber(fonteBox);
        jScrollPane3.setRowHeaderView(tln);
        updateTextStyles();
    }

    private int findLastNonWordChar(String text, int index) {
        while (--index >= 0) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
        }
        return index;
    }

    private int findFirstNonWordChar(String text, int index) {
        while (index < text.length()) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
            index++;
        }
        return index;
    }

    private void updateTextStyles() {
        StyledDocument styledDocument = fonteBox.getStyledDocument();
        StyleContext styleContext = StyleContext.getDefaultStyleContext();
        AttributeSet blueAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
        AttributeSet blackAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
        AttributeSet greenAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, new Color(0, 153, 0));
        AttributeSet redAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.RED);
        AttributeSet pinkAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, new Color(255, 0, 255));
        AttributeSet grayAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.gray);
        styledDocument.setCharacterAttributes(0, fonteBox.getText().length(), blackAttributeSet, true);
        DefaultStyledDocument doc = new DefaultStyledDocument() {
            public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
                super.insertString(offset, str, a);

                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offset);
                if (before < 0) {
                    before = 0;
                }
                int after = findFirstNonWordChar(text, offset + str.length());
                int wordL = before;
                int wordR = before;

                while (wordR <= after) {
                    if (wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")) {
                        if (text.substring(wordL, wordR).matches("(\\W)*(program|procedure|if|then|else|while|do|var|begin|end|false|true|int|boolean|read|write)")) {
                            setCharacterAttributes(wordL, wordR - wordL, blueAttributeSet, true);
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(:|,|;|(:=)|(<>)|<|>|(>=)|(<=)|[\\-]|[\\+]|[\\*])")) {
                            setCharacterAttributes(wordL, wordR - wordL, redAttributeSet, true);
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(div|and|or|not)")) {
                            setCharacterAttributes(wordL, wordR - wordL, blueAttributeSet, true);
                        } else {
                            setCharacterAttributes(wordL, wordR - wordL, blackAttributeSet, true);
                        }
                        wordL = wordR;
                    }
                    wordR++;
                }
            }

            public void remove(int offs, int len) throws BadLocationException {
                super.remove(offs, len);

                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offs);
                if (before < 0) {
                    before = 0;
                }
                int after = findFirstNonWordChar(text, offs);

                if (text.substring(before, after).matches("(\\W)*(program|procedure|if|then|else|while|do|var|begin|end|false|true|int|boolean|read|write)")) {
                    setCharacterAttributes(before, after - before, blueAttributeSet, false);
                } else if (text.substring(before, after).matches("(\\W)*(:|,|;|(:=)|(<>)|<|>|(>=)|(<=)|[\\-]|[\\+]|[\\*])")) {
                    setCharacterAttributes(before, after - before, redAttributeSet, true);
                } else if (text.substring(before, after).matches("(\\W)*(div|and|or|not)")) {
                    setCharacterAttributes(before, after - before, blueAttributeSet, true);
                } else {
                    setCharacterAttributes(before, after - before, blackAttributeSet, false);
                }
            }

        };
        String text = fonteBox.getText();
        fonteBox.setStyledDocument(doc);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        fonteBox = new javax.swing.JTextPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaSintaxe = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IDE");

        fonteBox.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        fonteBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fonteBoxKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fonteBoxKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(fonteBox);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexema", "Tipo", "Linha", "Coluna Inicial", "Coluna Final"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Tokens", jPanel3);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Erro", "Linha", "Coluna"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Erros Léxicos", jPanel4);

        textAreaSintaxe.setColumns(20);
        textAreaSintaxe.setRows(5);
        jScrollPane1.setViewportView(textAreaSintaxe);

        jTabbedPane3.addTab("Erros Sintáticos", jScrollPane1);

        jLabel2.setText("Fonte:");

        jMenu1.setText("File");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Abrir Arquivo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem4.setText("Salvar Arquivo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Editar");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem5.setText("Copiar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem6.setText("Colar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem7.setText("Recortar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem8.setText("Selecionar tudo");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Localizar");

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem9.setText("Localizar");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem10.setText("Localizar e substituir");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Executar");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem1.setText("Analisador Léxico");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jMenuItem3.setText("Analisador Sintático");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane3)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JFileChooser abrir = new JFileChooser();
        abrir.setFileFilter(new FileFilterTXT());
        int opcao;
        opcao = abrir.showOpenDialog(null);
        if (opcao == JFileChooser.APPROVE_OPTION) {
            File f = abrir.getSelectedFile();
            try {
                Scanner s = new Scanner(f);
                String line = "";
                while (s.hasNext()) {
                    line += s.nextLine() + System.lineSeparator();
                }
                fonteBox.setText(line);
            } catch (FileNotFoundException ex) {
                exit(1);
            }
            fonteBox.repaint();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //this.reloadTable(0);
        Map<String, Integer> map = new HashMap<String, Integer>();
        jTabbedPane3.setSelectedIndex(0);
        Reader lector = new StringReader(fonteBox.getText());
        Scanner_1 lexer = new Scanner_1(lector);

        DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
        dtm.getDataVector().removeAllElements();
        dtm.fireTableDataChanged();

        DefaultTableModel dtmE = (DefaultTableModel) jTable2.getModel();
        dtmE.getDataVector().removeAllElements();
        dtmE.fireTableDataChanged();

        Token t = new Token();
        t = lexer.getNextToken();
        do {
            if (t.specialToken != null) {
                if (t.specialToken.kind == 54 || t.specialToken.kind == 53
                        || t.specialToken.kind == 52 || t.specialToken.kind == 51 || t.specialToken.kind == 50) {
                    jTabbedPane3.setSelectedIndex(1);
                    TokenManager tm = new TokenManager(t.specialToken.kind, t.specialToken.image, t.specialToken.beginLine, t.specialToken.endLine, t.specialToken.beginColumn, t.specialToken.endColumn);
                    String[] linha = tm.getStringRowLexicalErrorTable();
                    dtmE.addRow(linha);
                    jTable2.revalidate();
                    jTable2.repaint();
                }

            } else {
                jTabbedPane3.setSelectedIndex(0);
                TokenManager tm = new TokenManager(t.kind, t.image, t.beginLine, t.endLine, t.beginColumn, t.endColumn);
                String[] linha = tm.getStringRowLexicalTable();
                dtm.addRow(linha);
                jTable4.revalidate();
                jTable4.repaint();
            }

            t = lexer.getNextToken();
        } while (t.kind != 0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void fonteBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fonteBoxKeyTyped

    }//GEN-LAST:event_fonteBoxKeyTyped

    private void fonteBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fonteBoxKeyReleased
        int newfontSize = fonteBox.getText().length();
        if (size != newfontSize) {
            size = newfontSize;
        }
        fonteBox.repaint();
    }//GEN-LAST:event_fonteBoxKeyReleased

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
            // TODO add your handling code here:
            salvaArquivo();
        } catch (IOException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed


    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        jTabbedPane3.setSelectedIndex(0);
        Reader lector = new StringReader(fonteBox.getText());
        Scanner_1 lexer = new Scanner_1(lector);

        DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
        dtm.getDataVector().removeAllElements();
        dtm.fireTableDataChanged();

        DefaultTableModel dtmE = (DefaultTableModel) jTable2.getModel();
        dtmE.getDataVector().removeAllElements();
        dtmE.fireTableDataChanged();

        Token t = new Token();
        t = lexer.getNextToken();
        do {
            if (t.specialToken != null) {
                if (t.specialToken.kind == 54 || t.specialToken.kind == 53
                        || t.specialToken.kind == 52 || t.specialToken.kind == 51 || t.specialToken.kind == 50) {
                    jTabbedPane3.setSelectedIndex(1);
                    TokenManager tm = new TokenManager(t.specialToken.kind, t.specialToken.image, t.specialToken.beginLine, t.specialToken.endLine, t.specialToken.beginColumn, t.specialToken.endColumn);
                    String[] linha = tm.getStringRowLexicalErrorTable();
                    dtmE.addRow(linha);
                    jTable2.revalidate();
                    jTable2.repaint();
                }

            } else {
                jTabbedPane3.setSelectedIndex(0);
                TokenManager tm = new TokenManager(t.kind, t.image, t.beginLine, t.endLine, t.beginColumn, t.endColumn);
                String[] linha = tm.getStringRowLexicalTable();
                dtm.addRow(linha);
                jTable4.revalidate();
                jTable4.repaint();
            }

            t = lexer.getNextToken();
        } while (t.kind != 0);

        jTabbedPane3.setSelectedIndex(2);

        Reader lectorParser = new StringReader(fonteBox.getText());
        Scanner_1 parser = new Scanner_1(lectorParser);
        try {
            parser.principal();
            var listaErrosSintax = parser.getListaErrosSintax();
            for (int i = 0; i < listaErrosSintax.size(); i++) {
                textAreaSintaxe.append(listaErrosSintax.get(i));
                textAreaSintaxe.revalidate();
                textAreaSintaxe.repaint();
            }
        } catch (ParseException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        Robot r;
        try {
            r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_A);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_A);
        } catch (AWTException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed


    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        FindPanel fr = new FindPanel(fonteBox);
        fr.setVisible(true);

    }//GEN-LAST:event_jMenuItem9ActionPerformed


    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        FindReplacePanel fr = new FindReplacePanel(fonteBox);
        fr.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        Robot r;
        try {
            r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_C);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_C);
        } catch (AWTException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        Robot r;
        try {
            r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_V);
        } catch (AWTException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        Robot r;
        try {
            r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_X);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_X);
        } catch (AWTException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed
    public void fillTextAreaSintaxe(ArrayList<String> listadeErros) {
        ArrayList<String> fill = listadeErros;
        String text = "";
        if (fill.size() > 0) {
            text = fill.get(2) + ". Na " + fill.get(0) + " e " + fill.get(1);
        }
        textAreaSintaxe.setText(text);

    }

    public void salvaArquivo() throws IOException {
        // parent component of the dialog
        JFrame parentFrame = new JFrame();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Arquivo");

        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            Files.write(Paths.get(fileToSave.getAbsolutePath()), fonteBox.getText().getBytes());

        }
    }

    /**
     * @param args the command line arguments
     * @throws jflex.exceptions.SilentExit
     * @throws java.lang.InterruptedException
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws SilentExit, InterruptedException, IOException, Exception {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        /*String rootPath = Paths.get("").toAbsolutePath().toString();
        String subPath = "\\src\\SintexAnalysis\\";
        String completePath = rootPath + subPath;
        String[] caminhoSintaxe = {"-parser", "Parser", "-symbols", "Tokens", "-destdir", completePath, "-package", "SintexAnalysis", completePath + "parser.cup"};
        String subPathL = "\\src\\LexicalAnalysis\\";
        String completePathL = rootPath + subPathL;
        String[] caminhoLexico = {completePathL + "LexicalAnalyzer.flex"};
        java_cup.Main.main(caminhoSintaxe);
        jflex.Main.generate(caminhoLexico);*/
 /*Runtime r = Runtime.getRuntime();
        Process p;
        p = r.exec(new String[]{"java", "-jar", rootPath+"\\lib\\CopyLibs\\jflex-full-1.8.2.jar", rootPath+"\\src\\LexicalAnalysis\\LexicalAnalyzer.flex"}, null, new File(rootPath+"\\src\\"));
        System.out.println(p.waitFor());
        
        p = r.exec(new String[]{"java", "-jar", rootPath+"\\lib\\CopyLibs\\java-cup-11b.jar", "-parser", rootPath+"\\src\\LexicalAnalysis\\Parser.java", "-symbols", rootPath+"\\src\\LexicalAnalysis\\Tokens.java", rootPath+"\\src\\SintexAnalysis\\parser.cup"}, null, new File(rootPath+"\\src\\"));
        System.out.println(p.waitFor());*/

 /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new UI().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane fonteBox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextArea textAreaSintaxe;
    // End of variables declaration//GEN-END:variables

}
