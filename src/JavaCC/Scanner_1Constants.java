/* Generated By:JavaCC: Do not edit this line. Scanner_1Constants.java */
package JavaCC;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface Scanner_1Constants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int COM = 5;
  /** RegularExpression Id. */
  int NOVA = 6;
  /** RegularExpression Id. */
  int RSV_PROGRAMA = 7;
  /** RegularExpression Id. */
  int RSV_PROCEDIMENTO = 8;
  /** RegularExpression Id. */
  int RSV_BEGIN = 9;
  /** RegularExpression Id. */
  int RSV_END = 10;
  /** RegularExpression Id. */
  int RSV_IF = 11;
  /** RegularExpression Id. */
  int RSV_THEN = 12;
  /** RegularExpression Id. */
  int RSV_ELSE = 13;
  /** RegularExpression Id. */
  int RSV_WHILE = 14;
  /** RegularExpression Id. */
  int RSV_DO = 15;
  /** RegularExpression Id. */
  int RSV_READ = 16;
  /** RegularExpression Id. */
  int RSV_WRITE = 17;
  /** RegularExpression Id. */
  int RSV_VAR = 18;
  /** RegularExpression Id. */
  int RSV_FIM = 19;
  /** RegularExpression Id. */
  int TIPO_INT = 20;
  /** RegularExpression Id. */
  int TIPO_BOOLEAN = 21;
  /** RegularExpression Id. */
  int OPERADOR_LOGICO_DIFERENCA = 22;
  /** RegularExpression Id. */
  int OPERADOR_LOGICO_IGUAL_IGUAL = 23;
  /** RegularExpression Id. */
  int OPERADOR_LOGICO_MENOR = 24;
  /** RegularExpression Id. */
  int OPERADOR_LOGICO_MENOR_IGUAL = 25;
  /** RegularExpression Id. */
  int OPERADOR_LOGICO_MAIOR_IGUAL = 26;
  /** RegularExpression Id. */
  int OPERADOR_LOGICO_MAIOR = 27;
  /** RegularExpression Id. */
  int OPERADOR_LOGICO_IGUALDADE = 28;
  /** RegularExpression Id. */
  int OPERADOR_LOGICO_AND = 29;
  /** RegularExpression Id. */
  int OPERADOR_LOGICO_OR = 30;
  /** RegularExpression Id. */
  int OPERADOR_LOGICO_NOT = 31;
  /** RegularExpression Id. */
  int OPERADOR_ARITMETICO_ATRIBUICAO = 32;
  /** RegularExpression Id. */
  int OPERADOR_ARITMETICO_ADICAO = 33;
  /** RegularExpression Id. */
  int OPERADOR_ARITMETICO_SUBTRACAO = 34;
  /** RegularExpression Id. */
  int OPERADOR_ARITMETICO_MULTIPLICACAO = 35;
  /** RegularExpression Id. */
  int OPERADOR_ARITMETICO_DIVISAO = 36;
  /** RegularExpression Id. */
  int PARENTESES_ESQ = 37;
  /** RegularExpression Id. */
  int PARENTESES_DIR = 38;
  /** RegularExpression Id. */
  int SIMBOLO_DOIS_PONTOS = 39;
  /** RegularExpression Id. */
  int SIMBOLO_VIRGULA = 40;
  /** RegularExpression Id. */
  int SIMBOLO_PONTO_E_VIRGULA = 41;
  /** RegularExpression Id. */
  int SIMBOLO_PONTO = 42;
  /** RegularExpression Id. */
  int IDENTIFICADOR = 43;
  /** RegularExpression Id. */
  int IDENTIFICADOR_CHAMADA_PROCEDIMENTO = 44;
  /** RegularExpression Id. */
  int NUMERO_INTEIRO = 45;
  /** RegularExpression Id. */
  int LETRA = 46;
  /** RegularExpression Id. */
  int DIGITO = 47;
  /** RegularExpression Id. */
  int COMENTARIO_UMA_LINHA = 48;
  /** RegularExpression Id. */
  int COMENTARIO_MULT_LINHAS = 49;
  /** RegularExpression Id. */
  int ERRO_OVERFLOW_INT = 50;
  /** RegularExpression Id. */
  int ERRO_OVERFLOW_IDENTIFICADOR = 51;
  /** RegularExpression Id. */
  int ERRO_COMENTARIO_MULT_LINHAS_SEM_FECHAR = 52;
  /** RegularExpression Id. */
  int ERRO_COMENTARIO_MULT_LINHAS_SEM_ABRIR = 53;
  /** RegularExpression Id. */
  int ERRO_SIMBOLO_INVALIDO = 54;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\r\"",
    "\"\\t\"",
    "\"\\n\"",
    "<COM>",
    "\"nova\"",
    "\"program\"",
    "\"procedure\"",
    "\"begin\"",
    "\"end\"",
    "\"if\"",
    "\"then\"",
    "\"else\"",
    "\"while\"",
    "\"do\"",
    "\"read\"",
    "\"write\"",
    "\"var\"",
    "<RSV_FIM>",
    "\"int\"",
    "\"boolean\"",
    "\"<>\"",
    "\"==\"",
    "\"<\"",
    "\"<=\"",
    "\">=\"",
    "\">\"",
    "\"=\"",
    "\"and\"",
    "\"or\"",
    "\"not\"",
    "\":=\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"div\"",
    "\"(\"",
    "\")\"",
    "\":\"",
    "\",\"",
    "\";\"",
    "\".\"",
    "<IDENTIFICADOR>",
    "<IDENTIFICADOR_CHAMADA_PROCEDIMENTO>",
    "<NUMERO_INTEIRO>",
    "<LETRA>",
    "<DIGITO>",
    "<COMENTARIO_UMA_LINHA>",
    "<COMENTARIO_MULT_LINHAS>",
    "<ERRO_OVERFLOW_INT>",
    "<ERRO_OVERFLOW_IDENTIFICADOR>",
    "<ERRO_COMENTARIO_MULT_LINHAS_SEM_FECHAR>",
    "<ERRO_COMENTARIO_MULT_LINHAS_SEM_ABRIR>",
    "<ERRO_SIMBOLO_INVALIDO>",
  };

}
