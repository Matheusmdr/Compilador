/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LexicalAnalysis;

/**
 *
 * @author mathe
 */
public enum Tokens {
    /* Palavras Reservadas */
    RSV_PROGRAMA,
    RSV_PROCEDIMENTO,
    RSV_BEGIN,
    RSV_END,
    RSV_IF,
    RSV_THEN,
    RSV_ELSE,
    RSV_WHILE,
    RSV_DO,
    RSV_READ,
    RSV_WRITE,
    RSV_VAR,
    RSV_TRUE,
    RSV_FALSE,
    /* Tipos */
    TIPO_INT,
    TIPO_BOOLEAN,
    /* Operadores e Simbolos */
    OPERADOR_LOGICO_DIFERENCA,
    OPERADOR_LOGICO_MENOR,
    OPERADOR_LOGICO_MENOR_IGUAL,
    OPERADOR_LOGICO_MAIOR_IGUAL,
    OPERADOR_LOGICO_MAIOR,
    OPERADOR_LOGICO_IGUALDADE,
    OPERADOR_LOGICO_AND,
    OPERADOR_LOGICO_OR,
    OPERADOR_LOGICO_NOT,
    OPERADOR_ARITMETICO_ATRIBUICAO,
    OPERADOR_ARITMETICO_ADICAO,
    OPERADOR_ARITMETICO_SUBTRACAO,
    OPERADOR_ARITMETICO_MULTIPLICACAO,
    OPERADOR_ARITMETICO_DIVISAO,
    PARENTESES_ESQ,
    PARENTESES_DIR,
    SIMBOLO_DOIS_PONTOS,
    SIMBOLO_VIRGULA,
    SIMBOLO_PONTO_E_VIRGULA,
    SIMBOLO_TERMINACAO,
    /* Números e Identificadores */
    IDENTIFICADOR,
    NUMERO_INTEIRO,
    LETRA,
    DIGITO,
    /* Comentários */
    COMENTARIO_UMA_LINHA,
    COMENTARIO_MULT_LINHAS,
    ERRO_COMENTARIO_MULT_LINHAS_SEM_FECHAR,
    ERRO_COMENTARIO_MULT_LINHAS_SEM_ABRIR,
    /* DELIMITADORES */
    DELIMITADOR,
    /* Erros */
    ERRO_SIMBOLO_INVALIDO,
    ERRO
}
