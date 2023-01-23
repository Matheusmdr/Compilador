/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.ArrayList;

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
    
    public void gerarArquivo(){
        System.out.println("arquivo gerado");
    }
}
