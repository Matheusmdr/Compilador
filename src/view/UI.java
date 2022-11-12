/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import LexicalAnalysis.LexicalAnalyzer;
import SintexAnalysis.Parser;
import SintexAnalysis.Tokens;

import java_cup.runtime.Symbol;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import static java.lang.System.exit;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

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

        jMenu2.setText("Executar");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Analisador Léxico");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

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
        this.reloadTable(0);
        jTabbedPane3.setSelectedIndex(0);
        try {
            Reader lector = new StringReader(fonteBox.getText());
            LexicalAnalyzer lexer = new LexicalAnalyzer(lector);

            DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
            dtm.getDataVector().removeAllElements();
            dtm.fireTableDataChanged();

            DefaultTableModel dtmE = (DefaultTableModel) jTable2.getModel();
            dtmE.getDataVector().removeAllElements();
            dtmE.fireTableDataChanged();

            Symbol sym = lexer.next_token();
            do {
                String[] linha = new String[5];

                if (sym.sym == Tokens.ERRO) {
                    linha[0] = lexer.erro;
                    linha[1] = Integer.toString(lexer.line + 1);
                    linha[2] = Integer.toString(lexer.column + 1);

                    dtmE.addRow(linha);
                    jTable2.revalidate();
                    jTable2.repaint();
                } else {

                    linha[0] = lexer.lexema;
                    linha[1] = lexer.token;
                    linha[2] = Integer.toString(lexer.line + 1);
                    linha[3] = Integer.toString(lexer.column + 1);
                    linha[4] = Integer.toString(lexer.endColumn + 1);

                    dtm.addRow(linha);
                    jTable4.revalidate();
                    jTable4.repaint();
                }

                sym = lexer.next_token();
            } while (!lexer.yyatEOF());

        } catch (IOException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        Reader lector = new StringReader(fonteBox.getText());
        LexicalAnalyzer lexer = new LexicalAnalyzer(lector);

        Parser parser = new Parser(lexer);
        parser.Connection(lexer);

        try {
            parser.parse();
            fillTextAreaSintaxe(parser.getListaDeErros());
            jTabbedPane3.setSelectedIndex(2);
        } catch (Exception ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jMenuItem3ActionPerformed
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

    public void reloadTable(int type) {

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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
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
