/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
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
    strTransformada = strTransformada.replaceAll("(\\snot\\s)|(not\\s)", "!");
    strTransformada = strTransformada.replaceAll("\\sdiv\\s", "/");
    strTransformada = strTransformada.replaceAll(" ", "");
    //Quebrar a string em várias subsstrings
    String[] split = strTransformada.split("(?<=[-+*/()&|!])|(?=[-+*/()&|!])");
    //System.out.println(Arrays.toString(split));
    
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
    
    public static Integer compute(ArrayList<String> expr) throws
            ArithmeticException,
            EmptyStackException {
        Stack<Integer> stack = new Stack<>();
        for (String token : expr) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    Integer divisor = stack.pop();
                    stack.push(Math.round(stack.pop() / divisor));
                    break;
                case "!":
                    stack.push( notOperator(stack.pop()));
                    break;
                case "&":
                    stack.push(andOperator(stack.pop(), stack.pop()));
                    break;
                case "|":
                    stack.push(orOperator(stack.pop(), stack.pop()));
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
    
    
    public static Integer notOperator(Integer number){
        //System.out.println(number);
        String binaryNumber = Integer.toBinaryString(number);
        String notBinaryNumber = "";
        System.out.println(binaryNumber);
        for(int i = 0; i < binaryNumber.length(); i++){
            if(binaryNumber.charAt(i) == '0'){
                notBinaryNumber += '1';
            }
            else{
                 notBinaryNumber += '0';
            } 
        }
        return Integer.parseInt(notBinaryNumber, 2);
    }
    
    public static Integer andOperator(Integer number1, Integer number2){
        String binaryNumber1 = Integer.toBinaryString(number1);
        String binaryNumber2 = Integer.toBinaryString(number2);
        String andBinaryNumber = "";
        if(binaryNumber1.length() > binaryNumber2.length()){
            String concat = "";
            for(int i = 0; i < binaryNumber1.length() - binaryNumber2.length(); i++){
               concat += '0';
            }
            binaryNumber2 = concat + binaryNumber2;
        }
        else if (binaryNumber2.length() > binaryNumber1.length()){
            String concat = "";
            for(int i = 0; i < binaryNumber2.length() - binaryNumber1.length(); i++){
               concat += '0';
            }
            binaryNumber1 = concat + binaryNumber1;
        }
        
        
        for(int i = 0; i < binaryNumber1.length(); i++){
            if(binaryNumber1.charAt(i) == '1' && binaryNumber2.charAt(i) == '1'){
                andBinaryNumber += '1';
            }
            else{
                andBinaryNumber += '0';
            }
        }
        return Integer.parseInt(andBinaryNumber,2);
    }
    
     public static Integer orOperator(Integer number1, Integer number2){
        String binaryNumber1 = Integer.toBinaryString(number1);
        String binaryNumber2 = Integer.toBinaryString(number2);
        String andBinaryNumber = "";
        if(binaryNumber1.length() > binaryNumber2.length()){
            String concat = "";
            for(int i = 0; i < binaryNumber1.length() - binaryNumber2.length(); i++){
               concat += '0';
            }
            binaryNumber2 = concat + binaryNumber2;
        }
        else if (binaryNumber2.length() > binaryNumber1.length()){
            String concat = "";
            for(int i = 0; i < binaryNumber2.length() - binaryNumber1.length(); i++){
               concat += '0';
            }
            binaryNumber1 = concat + binaryNumber1;
        }
        
        
        for(int i = 0; i < binaryNumber1.length(); i++){
            if(binaryNumber1.charAt(i) == '1' || binaryNumber2.charAt(i) == '1'){
                andBinaryNumber += '1';
            }
            else{
                andBinaryNumber += '0';
            }
        }
        return Integer.parseInt(andBinaryNumber,2);
    }
}
    
