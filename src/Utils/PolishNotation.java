/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author mathe
 */
public class PolishNotation {
    
    public static boolean prioridade(String str, String str2){   //função que avalia a prioridade dos operadores
    int pstr = 0,pstr2 = 0;
    
        if((str.equals("&")) || (str.equals("|")) || (str.equals("!")) ){
            pstr = 3;
        }else if( (str.equals("*")) || (str.equals("/"))){
            pstr = 2;
        }else if( (str.equals("+")) || (str.equals("-"))){
            pstr = 1;
        }

        if((str2.equals("&")) || (str2.equals("|")) || (str2.equals("!")) ){
            pstr2 = 3;
        }else if( (str2.equals("*")) || (str2.equals("/"))){
            pstr2 = 2;
        }else if( (str2.equals("+")) || (str2.equals("-"))){
            pstr2 = 1;
        }else if(str2.equals("(")){
            pstr2 = 0;
        }

        return (pstr > pstr2);
}
    
    public static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean isOperator(String op) {
    	return "+".equals(op) || "-".equals(op) || "*".equals(op) || 
                "/".equals(op) || "(".equals(op) || ")".equals(op) ||
                       "&".equals(op) || "|".equals(op) || "!".equals(op); 
    }
    

    public static ArrayList<String> convertToReversePolish(String exp) {
    //Substituir and,or e not por operadores válidos e aliminar espaços
    String strTransformada = exp.replaceAll("\\sand\\s", "&");
    strTransformada = strTransformada.replaceAll("\\sor\\s", "|");
    strTransformada = strTransformada.replaceAll("\\snot\\s", "!");
    strTransformada = strTransformada.replaceAll("\\sdiv\\s", "/");
    strTransformada = strTransformada.replaceAll(" ", "");
    //Quebrar a string em várias subsstrings
    String[] split = strTransformada.split("(?<=[-+*/()&|!])|(?=[-+*/()&|!])");
    System.out.println(Arrays.toString(split));
    
    //Notação Polonesa Reversa
    int cont,aux,tamListaSplit;
    String str,str2;
    Stack<String> pilhaPolonesa = new Stack<String>();
    ArrayList<String> listaPolonesa = new ArrayList();

    cont = -1;
    tamListaSplit = split.length;
    str = "";
    
    pilhaPolonesa.add("(");

    do{
        cont = cont+1;
        if(cont < tamListaSplit) str = split[cont];
        if ( (str.equals(")")) || (cont >= (tamListaSplit)) ) {   //Se for ')' ou o fim da listaSplit  o conteúdo da pilha é jogado na lista até chegar numa string de conteúdo '('
                    do{
                        str2 = pilhaPolonesa.pop();
                        if(!str2.equals("(")){
                              listaPolonesa.add(str2);
                        }
                    }while(!str2.equals("("));
        }else if ( (tryParseInt(str) == true)){  //Se  for número int, então é adicionado direto na lista
                    listaPolonesa.add(str);
        }else if ( (!tryParseInt(str) == true) && (!isOperator(str) == true)){  //Se  for letra, então é adicionado direto na lista
                    listaPolonesa.add(str);
        }else if(str.equals("(")){    //Se for '(' é adicionado direto na pilha
                    pilhaPolonesa.add(str);
        }else if(isOperator(str) == true) { // Se for operador é verificada a prioridade e então empilhado ou jogado na lista;
               while(true){
                          str2 = pilhaPolonesa.pop();
                          if(prioridade(str,str2)){
                                    pilhaPolonesa.add(str2);
                                    pilhaPolonesa.add(str);
                                    break;
                          }else{
                                   listaPolonesa.add(str2);
                          }
               }
        }
    }while(cont < (tamListaSplit));
    
    return listaPolonesa;
    }

}
    
