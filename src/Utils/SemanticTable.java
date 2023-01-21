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
    
    public void insertTableRow(SemanticTableObject row){
        table.add(row);
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
    
    
}
