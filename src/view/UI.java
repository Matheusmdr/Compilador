/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

//import LexicalAnalysis.LexicalAnalyzer;
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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
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
    private CustomDocumentFilter documentFilter;

    private int size;

    public UI() {
        initComponents();
        documentFilter = new CustomDocumentFilter();
        TextLineNumber tln = new TextLineNumber(fonteBox);
        jScrollPane3.setRowHeaderView(tln);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        fonteBox = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tokens:");

        jLabel2.setText("Fonte:");

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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable2);

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

        jMenu2.setText("Analisador");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Léxico");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
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
            documentFilter.updateTextStyles();
            fonteBox.repaint();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.reloadTable(0);
        /*try {
            Reader lector = new StringReader(fonteBox.getText());
            LexicalAnalyzer lexer = new LexicalAnalyzer(lector);
            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            dtm.getDataVector().removeAllElements();
            dtm.fireTableDataChanged();
            while (true) {
                String[] linha = new String[5];
                Tokens tokens = lexer.yylex();
                if (tokens == null) {
                    break;
                }

                linha[0] = lexer.lexema;
                linha[2] = Integer.toString(lexer.line + 1);
                linha[3] = Integer.toString(lexer.column + 1);
                linha[4] = Integer.toString(lexer.endColumn + 1);
                if (tokens != Tokens.ERRO) {
                    linha[1] = lexer.token;
                } else {
                    linha[1] = lexer.erro;
                }
                dtm.addRow(linha);
                jTable2.revalidate();
                jTable2.repaint();
            }

        } catch (IOException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void fonteBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fonteBoxKeyTyped

    }//GEN-LAST:event_fonteBoxKeyTyped

    private void fonteBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fonteBoxKeyReleased
        int newfontSize = fonteBox.getText().length();
        if (size != newfontSize) {
            size = newfontSize;
        }
        documentFilter.updateTextStyles();
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
        String rootPath = Paths.get("").toAbsolutePath().toString();
        String subPath = "\\src\\SintexAnalysis\\";
        String completePath = rootPath + subPath;
        String[] caminhoSintaxe = {"-parser", "Parser", "-symbols", "Tokens", "-destdir", completePath, "-package", "SintexAnalysis", completePath + "parser.cup"};
        String subPathL = "\\src\\LexicalAnalysis\\";
        String completePathL = rootPath + subPathL;
        String[] caminhoLexico = {completePathL + "LexicalAnalyzer.flex"};
        java_cup.Main.main(caminhoSintaxe);
        jflex.Main.generate(caminhoLexico);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

    private class CustomDocumentFilter extends DocumentFilter {

        private final StyledDocument styledDocument = fonteBox.getStyledDocument();
        private final StyleContext styleContext = StyleContext.getDefaultStyleContext();
        private final AttributeSet blueAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
        private final AttributeSet blackAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
        private final AttributeSet greenAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, new Color(0, 153, 0));
        private final AttributeSet redAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.RED);
        private final AttributeSet pinkAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, new Color(255, 0, 255));
        private final AttributeSet grayAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.gray);

        @Override
        public void insertString(FilterBypass fb, int offset, String text, AttributeSet attributeSet) throws BadLocationException {
            super.insertString(fb, offset, text, attributeSet);

            handleTextChanged();
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            super.remove(fb, offset, length);

            handleTextChanged();
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attributeSet) throws BadLocationException {
            super.replace(fb, offset, length, text, attributeSet);

            handleTextChanged();
        }

        /**
         * Runs your updates later, not during the event notification.
         */
        private void handleTextChanged() {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    updateTextStyles();
                }
            });
        }

        private void updateTextStyles() {

        }

    }
}
