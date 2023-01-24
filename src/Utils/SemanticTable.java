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
public class SemanticTable {
    private ArrayList<SemanticTableObject> table;

    public SemanticTable() {
       table = new ArrayList();
    }
    
    public Boolean searchTableRow (SemanticTableObject row){
        return table.contains(row);
    }
    
    public String searchRowByLexemaTokenAndReturnValue (String lexema, String token){
        ArrayList<SemanticTableObject> table = getTable();
        for(SemanticTableObject linha : table)
          if(linha.getLexema().equals(lexema) && linha.getToken().equals(token))
            return linha.getValor();
        return "";
    }
    
    public Integer searchRowByLexemaTokenAndReturnAddress (String lexema, String token){
        ArrayList<SemanticTableObject> table = getTable();
        for(SemanticTableObject linha : table)
          if(linha.getLexema().equals(lexema) && linha.getToken().equals(token))
            return linha.getEndRelativo();
        return -1;
    }
    
    public SemanticTableObject searchRowByLexemaTokenAndReturnObject (String lexema, String token){
        ArrayList<SemanticTableObject> table = getTable();
        for(SemanticTableObject linha : table)
          if(linha.getLexema().equals(lexema) && linha.getToken().equals(token))
            return linha;
        return null;
    }
    
    public SemanticTableObject searchRowByLexemaAndReturnObject (String lexema){
        ArrayList<SemanticTableObject> table = getTable();
        for(SemanticTableObject linha : table)
          if(linha.getLexema().equals(lexema))
            return linha;
        return null;
    }
    
    public Boolean insertTableRow(SemanticTableObject row){
        if(searchRowByLexemaAndReturnObject(row.getLexema()) == null){
          table.add(row);
          return true;
        }
        return false;
    }
    
    public Boolean updateTableRow(SemanticTableObject row){
        String valor = row.getValor();
        Boolean utilizada = row.getUtilizada();
        int index = table.indexOf(row);
        if(index > -1){
            SemanticTableObject tableRow = table.get(index);
            tableRow.setValor(valor);
            tableRow.setUtilizada(utilizada);
            return true;
        }
        return false;
    }
    
    public void updateRowByLexemaAndToken(String lexema, String token, String valor){
        SemanticTableObject linha = searchRowByLexemaTokenAndReturnObject(lexema, token);
        if(linha != null){
          linha.setValor(valor);
          linha.setUtilizada(true);
          updateTableRow(linha);
        }
    }
    

    public ArrayList<SemanticTableObject> getTable() {
      return table;
    }
    
}
