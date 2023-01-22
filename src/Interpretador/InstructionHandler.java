
package Interpretador;

/**
 *
 * @author mathe
 */
public class InstructionHandler {
   private String desvio;
   private String instrucao;
   private Integer valor;
   private boolean declarouValor;

    public InstructionHandler(String instrucao) {
        this.desvio = "";
        this.instrucao = instrucao;
        this.valor = 0;
    }

    public InstructionHandler(String instrucao, Integer valor) {
        this.desvio = "";
        this.instrucao = instrucao;
        this.valor = valor;
    }

    public InstructionHandler(String rotulo, String instrucao, Integer valor) {
        this.desvio = rotulo;
        this.instrucao = instrucao;
        this.valor = valor;
    }

    public String getDesvio() {
        return desvio;
    }

    public void setDesvio(String desvio) {
        this.desvio = desvio;
    }
    
    public String getInstrucao() {
        return instrucao;
    }

    public void setInstrucao(String instrucao) {
        this.instrucao = instrucao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public boolean isDeclarouValor() {
        return declarouValor;
    }

    public void setDeclarouValor(boolean declarouValor) {
        this.declarouValor = declarouValor;
    }
}