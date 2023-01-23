/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author mathe
 */
public class SemanticTableObject {

    private String lexema;
    private String token;
    private String categoria;
    private String tipo;
    private String valor;
    private Boolean utilizada;
    private Integer endRelativo;

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Boolean getUtilizada() {
        return utilizada;
    }

    public void setUtilizada(Boolean utilizada) {
        this.utilizada = utilizada;
    }

    public Integer getEndRelativo() {
      return endRelativo;
    }

    public void setEndRelativo(Integer endRelativo) {
      this.endRelativo = endRelativo;
    }

    public SemanticTableObject(String lexema, String token, String categoria, String tipo, String valor, Boolean utilizada, Integer endRelativo) {
        this.lexema = lexema;
        this.token = token;
        this.categoria = categoria;
        this.tipo = tipo;
        this.valor = valor;
        this.utilizada = utilizada;
        this.endRelativo = endRelativo;
    }
    
    
    
}