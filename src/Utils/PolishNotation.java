/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.Stack;

/**
 *
 * @author mathe
 */
public class PolishNotation {

    public String convertToReversePolish(String exp) {
        if (exp == null) {
            return null;
        }
        String res = "";
        int len = exp.length();
        Stack<Character> operator = new Stack<Character>();
        Stack<String> reversePolish = new Stack<String>();
        //avoid checking empty
        operator.push('#');
        for (int i = 0; i < len;) {
            //deal with space
            while (i < len && exp.charAt(i) == ' ') {
                i++;
            }
            if (i == len) {
                break;
            }
            //if is number
            if (isNum(exp.charAt(i))) {
                String num = "";
                while (i < len && isNum(exp.charAt(i))) {
                    num += exp.charAt(i++);
                }
                reversePolish.push(num);
                //is operator
            } else if (isOperator(exp.charAt(i))) {
                char op = exp.charAt(i);
                switch (op) {
                    case '(':
                        operator.push(op);
                        break;
                    case ')':
                        while (operator.peek() != '(') {
                            reversePolish.push(Character.toString(operator.pop()));
                        }
                        operator.pop();
                        break;
                    case '+':
                    case '-':
                        if (operator.peek() == '(') {
                            operator.push(op);
                        } else {
                            while (operator.peek() != '#' && operator.peek() != '(') {
                                reversePolish.push(Character.toString(operator.pop()));
                            }
                            operator.push(op);
                        }
                        break;
                    case '*':
                    case '/':
                        if (operator.peek() == '(') {
                            operator.push(op);
                        } else {
                            while (operator.peek() != '#' && operator.peek() != '+'
                                    && operator.peek() != '-' && operator.peek() != '(') {
                                reversePolish.push(Character.toString(operator.pop()));
                            }
                            operator.push(op);
                        }
                        break;
                }
                i++;
            }
        }
        while (operator.peek() != '#') {
            reversePolish.push(Character.toString(operator.pop()));
        }
        while (!reversePolish.isEmpty()) {
            res = res.length() == 0 ? reversePolish.pop() + res : reversePolish.pop() + " " + res;
        }
        return res;
    }

    public boolean isOperator(String c) {
        if(c.equals("+") || c.equals("-") || c.equals("*") ||
        c.equals("/") || c.equals("(") || c.equals(")")
        || c.equals("and") || c.equals("or") || c.equals("not")){
             return true;
        }
        return false;
    }

    public boolean isNum(char c) {
        return c - '0' >= 0 && c - '0' <= 9;
    }
}
