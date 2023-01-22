package Interpretador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MEPA {

    private ArrayList<InstructionHandler> C;
    private Stack<Integer> D;
    private String saida;
    private String filePath;
    private int s;
    private int i;

    public MEPA(String filePath) {
        this.C = new ArrayList();
        this.D = new Stack();
        this.s = 0;
        this.i = 0;
        this.filePath = filePath;
    }

    public void interpretar(JTextArea textArea) throws IOException {
        this.leArquivo(this.filePath);
        this.i = 0;
        var aux = false;
        do {
            InstructionHandler instruction = C.get(this.i);
            if (instruction.getInstrucao().equals("PARA")) {
                // chegou no fim do programa, sai do loop
                break;
            } else {
                String valorInstrucao = String.valueOf(instruction.getValor());
                if (valorInstrucao.equals(Integer.MIN_VALUE)) {
                    valorInstrucao = "";
                }
                switch (instruction.getInstrucao()) {
                    case "INPP":
                        this.D = new Stack();
                        this.i = 0;
                        break;
                    case "AMEM":
                        for (int j = 0; j < instruction.getValor(); j++) {
                            this.D.add(0);
                        }
                        break;
                    case "LEIT":
                        int v = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor da variável :"));
                        String textSet = "";
                        if (aux){
                            textSet = textArea.getText() + "\n" + "Input: "+ Integer.toString(v);
                        }
                        else{
                            textSet = "Input: "+ Integer.toString(v);
                        }
                        aux = true;
                        textArea.setText(textSet);
                        this.D.add(v);
                        break;
                    case "IMPR":
                        int vl = this.D.pop();
                        System.out.println("SAIDA:" + vl);
                        this.saida = "\nOutput: " + vl;
                        textArea.setText(textArea.getText() + saida);
                        break;
                    case "DMEM":
                        for (int j = 0; j < instruction.getValor(); j++) {
                            this.D.pop();
                        }
                        break;
                    case "CRCT":
                        this.D.add(instruction.getValor());
                        break;
                    case "CRVL":
                        Integer endereco = instruction.getValor();
                        Integer valor = this.D.get(endereco);
                        this.D.add(valor);
                        break;
                    case "ARMZ":
                        Integer topo = this.D.pop();
                        this.D.set(instruction.getValor(), topo);
                        break;
                    case "SOMA":
                        topo = this.D.pop();
                        Integer penultimo = this.D.pop();
                        this.D.add(penultimo + topo);
                        break;
                    case "SUBT":
                        topo = this.D.pop();
                        penultimo = this.D.pop();
                        this.D.add(penultimo - topo);
                        break;
                    case "MULT":
                        topo = this.D.pop();
                        penultimo = this.D.pop();
                        this.D.add(penultimo * topo);
                        break;
                    case "DIVI":
                        topo = this.D.pop();
                        penultimo = this.D.pop();
                        this.D.add(penultimo / topo);
                        break;
                    case "MODI":
                        topo = this.D.pop();
                        penultimo = this.D.pop();
                        this.D.add(penultimo % topo);
                        break;
                    case "INVR":
                        topo = this.D.pop();
                        this.D.add(-topo);
                        break;
                    case "CONJ":
                        topo = this.D.pop();
                        penultimo = this.D.pop();
                        if (topo == 1 && penultimo == 1) {
                            this.D.add(1);
                        } else {
                            this.D.add(0);
                        }
                        break;
                    case "DISJ":
                        topo = this.D.pop();
                        penultimo = this.D.pop();
                        if (topo == 0 && penultimo == 0) {
                            this.D.add(0);
                        } else {
                            this.D.add(1);
                        }
                        break;
                    case "NEGA":
                        topo = this.D.pop();
                        this.D.add(1 - topo);
                        break;
                    case "CMME":
                        topo = this.D.pop();
                        penultimo = this.D.pop();
                        if (penultimo < topo) {
                            this.D.add(1);
                        } else {
                            this.D.add(0);
                        }
                        break;
                    case "CMMA":
                        topo = this.D.pop();
                        penultimo = this.D.pop();
                        if (penultimo > topo) {
                            this.D.add(1);
                        } else {
                            this.D.add(0);
                        }
                        break;
                    case "CMIG":
                        topo = this.D.pop();
                        penultimo = this.D.pop();
                        if (penultimo == topo) {
                            this.D.add(1);
                        } else {
                            this.D.add(0);
                        }
                        break;
                    case "CMDG":
                        topo = this.D.pop();
                        penultimo = this.D.pop();
                        if (penultimo != topo) {
                            this.D.add(1);
                        } else {
                            this.D.add(0);
                        }
                        break;
                    case "CMAG":
                        topo = this.D.pop();
                        penultimo = this.D.pop();
                        if (penultimo >= topo) {
                            this.D.add(1);
                        } else {
                            this.D.add(0);
                        }
                        break;
                    case "CMEG":
                        topo = this.D.pop();
                        penultimo = this.D.pop();
                        if (penultimo <= topo) {
                            this.D.add(1);
                        } else {
                            this.D.add(0);
                        }
                        break;
                    case "DSVS":
                        this.i = getLinhaDesvio(instruction.getDesvio()) - 1;
                        break;
                    case "DSVF":
                        topo = this.D.pop();
                        if (topo == 0) {
                            this.i = getLinhaDesvio(instruction.getDesvio()) - 1;
                        }
                        break;
                    case "NADA":
                        break;
                    default:
                        System.out.println("Instrução inválida: " + instruction.getInstrucao());
                        break;

                }
                this.i += 1;
            }
        } while (true);
        for(int j = 0; j < this.D.size(); j++){
            System.out.println("Pilha: "+this.D.get(j));
        }
    }

    public void leArquivo(String path) throws FileNotFoundException, IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            linha = buffRead.readLine();
            if (linha != null) {
                String[] arr = linha.split(" ");
                if (arr.length == 1) {
                    this.C.add(new InstructionHandler(arr[0]));
                } else if (arr.length == 2) { 
                    if (linha.contains("NADA")) {
                        InstructionHandler inst = new InstructionHandler(arr[1]);
                        inst.setDesvio(arr[0]);
                        this.C.add(inst);
                    } else {

                        if (linha.contains("DS") || linha.contains("DV")) {
                            InstructionHandler ins = new InstructionHandler(arr[0]);
                            ins.setDesvio(arr[1]);
                            ins.setDeclarouValor(false);
                            this.C.add(ins);
                        } else {
                            InstructionHandler instrucao = new InstructionHandler(arr[0]);
                            instrucao.setValor(Integer.parseInt(arr[1]));
                            instrucao.setDeclarouValor(true);
                            this.C.add(instrucao);
                        }

                    }

                }

            } else {
                break;
            }
        }
        buffRead.close();
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    private int getLinhaDesvio(String rotulo) {
        for (int i = 0; i < this.C.size(); i++) {
            if (this.C.get(i).getDesvio().equals(rotulo) && this.C.get(i).getInstrucao().equals("NADA")) {
                return i;
            }

        }
        return Integer.MIN_VALUE;
    }
}
