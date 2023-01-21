/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author mathe
 */
public class TokenManager {

    private String TokenType;
    private String TokenImage;
    private int beginLine;
    private int endLine;
    private int beginColumn;
    private int endColumn;

    public TokenManager(int kind, String image, int beginLine, int endLine, int beginColumn, int endColumn) {
        this.TokenType = this.getTokenStringType(kind);
        this.TokenImage = image;
        this.beginLine = beginLine;
        this.endLine = endLine;
        this.beginColumn = beginColumn;
        this.endColumn = endColumn;
    }

    private String getTokenStringType(int kind) {
        String typeName = "";
        switch (kind) {
            case 0:
                typeName = "EOF";
                break;
            case 7:
                typeName = "RSV_PROGRAMA";
                break;
            case 8:
                typeName = "RSV_PROCEDIMENTO";
                break;
            case 9:
                typeName = "RSV_BEGIN";
                break;
            case 10:
                typeName = "RSV_END";
                break;
            case 11:
                typeName = "RSV_IF";
                break;
            case 12:
                typeName = "RSV_THEN";
                break;
            case 13:
                typeName = "RSV_ELSE";
                break;
            case 14:
                typeName = "RSV_WHILE";
                break;
            case 15:
                typeName = "RSV_DO";
                break;
            case 16:
                typeName = "RSV_READ";
                break;
            case 17:
                typeName = "RSV_WRITE";
                break;
            case 18:
                typeName = "RSV_VAR";
                break;
            case 19:
                typeName = "RSV_FIM";
                break;
            case 20:
                typeName = "TIPO_INT";
                break;
            case 21:
                typeName = "TIPO_BOOLEAN";
                break;
            case 22:
                typeName = "OPERADOR_LOGICO_DIFERENCA";
                break;
            case 23:
                typeName = "OPERADOR_LOGICO_IGUAL_IGUAL";
                break;
            case 24:
                typeName = "OPERADOR_LOGICO_MENOR";
                break;
            case 25:
                typeName = "OPERADOR_LOGICO_MENOR_IGUAL";
                break;
            case 26:
                typeName = "OPERADOR_LOGICO_MAIOR_IGUAL";
                break;
            case 27:
                typeName = "OPERADOR_LOGICO_MAIOR";
                break;
            case 28:
                typeName = "OPERADOR_LOGICO_IGUALDADE";
                break;
            case 29:
                typeName = "OPERADOR_LOGICO_AND";
                break;
            case 30:
                typeName = "OPERADOR_LOGICO_OR";
                break;
            case 31:
                typeName = "OPERADOR_LOGICO_NOT";
                break;
            case 32:
                typeName = "OPERADOR_ARITMETICO_ATRIBUICAO";
                break;
            case 33:
                typeName = "OPERADOR_ARITMETICO_ADICAO";
                break;
            case 34:
                typeName = "OPERADOR_ARITMETICO_SUBTRACAO";
                break;
            case 35:
                typeName = "OPERADOR_ARITMETICO_MULTIPLICACAO";
                break;
            case 36:
                typeName = "OPERADOR_ARITMETICO_DIVISAO";
                break;
            case 37:
                typeName = "PARENTESES_ESQ";
                break;
            case 38:
                typeName = "PARENTESES_DIR";
                break;
            case 39:
                typeName = "SIMBOLO_DOIS_PONTOS";
                break;
            case 40:
                typeName = "SIMBOLO_VIRGULA";
                break;
            case 41:
                typeName = "SIMBOLO_PONTO_E_VIRGULA";
                break;
            case 42:
                typeName = "SIMBOLO_PONTO";
                break;
            case 43:
                typeName = "IDENTIFICADOR";
                break;
            case 44:
                typeName = "IDENTIFICADOR_CHAMADA_PROCEDIMENTO";
                break;
            case 45:
                typeName = "NUMERO_INTEIRO";
                break;
            case 48:
                typeName = "COMENTARIO_UMA_LINHA";
                break;
            case 49:
                typeName = "COMENTARIO_MULT_LINHAS";
                break;
            case 50:
                typeName = "ERRO_OVERFLOW_INT";
                break;
            case 51:
                typeName = "ERRO_OVERFLOW_IDENTIFICADOR";
                break;
            case 52:
                typeName = "ERRO_COMENTARIO_MULT_LINHAS_SEM_FECHAR";
                break;
            case 53:
                typeName = "ERRO_COMENTARIO_MULT_LINHAS_SEM_ABRIR";
                break;
            case 54:
                typeName = "ERRO_SIMBOLO_INVALIDO";
                break;
        }
        return typeName;
    }

    public String[] getStringRowLexicalTable() {
        String[] row = new String[5];
        row[0] = this.getTokenImage();
        row[1] = this.getTokenType();
        row[2] = Integer.toString(this.beginLine);
        row[3] = Integer.toString(this.beginColumn);
        row[4] = Integer.toString(this.endColumn);
        return row;
    }

    public String[] getStringRowLexicalErrorTable() {
        String[] row = new String[3];
        row[0] = this.getTokenType();
        row[1] = Integer.toString(this.beginLine);
        row[2] = Integer.toString(this.endColumn);
        return row;
    }

    public String getTokenType() {
        return TokenType;
    }

    public String getTokenImage() {
        return TokenImage;
    }

    public int getBeginLine() {
        return beginLine;
    }

    public int getEndLine() {
        return endLine;
    }

    public int getBeginColumn() {
        return beginColumn;
    }

    public int getEndColumn() {
        return endColumn;
    }

}
