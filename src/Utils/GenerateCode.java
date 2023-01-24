/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author mathe
 */
public class GenerateCode {
    private String codeMEPA;

    public GenerateCode() {
        this.codeMEPA = "";
    }
    
    public void gerar(String rotulo, String instrucao, String valor){
        this.codeMEPA += rotulo + " " + instrucao + " " + valor + "\n";
        //System.out.println(this.codeMEPA);
    }    
    
    public void gerarArquivo() throws IOException{
        // parent component of the dialog
        JFrame parentFrame = new JFrame();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Arquivo");

        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            Files.write(Paths.get(fileToSave.getAbsolutePath()), codeMEPA.getBytes());
        }
    }
}
