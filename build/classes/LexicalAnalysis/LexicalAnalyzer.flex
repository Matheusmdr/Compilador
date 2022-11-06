package LexicalAnalysis;
import SintexAnalysis.Tokens;
import java_cup.runtime.Symbol;
%%
%public
%class LexicalAnalyzer
%cup
%line
%column
%unicode
%eofval{
    return new Symbol(Tokens.EOF, "Fim do arquivo");
%eofval}

/* Palavras Reservadas */
RSV_PROGRAMA = "program"
RSV_PROCEDIMENTO = "procedure"
RSV_BEGIN = "begin"
RSV_END = "end"
RSV_IF = "if"
RSV_THEN = "then"
RSV_ELSE = "else"
RSV_WHILE = "while"
RSV_DO = "do"
RSV_READ = "read"
RSV_WRITE = "write"
RSV_VAR = "var"
RSV_TRUE = "true"
RSV_FALSE = "false"

/* Tipos */
TIPO_INT = "int"
TIPO_BOOLEAN = "boolean"

/* Operadores e Simbolos */
OPERADOR_LOGICO_DIFERENCA =  "<>"
OPERADOR_LOGICO_MENOR = "<"
OPERADOR_LOGICO_MENOR_IGUAL = "<="
OPERADOR_LOGICO_MAIOR_IGUAL = ">="
OPERADOR_LOGICO_MAIOR = ">"
OPERADOR_LOGICO_IGUALDADE = "="
OPERADOR_LOGICO_AND = "and"
OPERADOR_LOGICO_OR = "or"
OPERADOR_LOGICO_NOT = "not"
OPERADOR_ARITMETICO_ATRIBUICAO = ":="
OPERADOR_ARITMETICO_ADICAO = "+"
OPERADOR_ARITMETICO_SUBTRACAO = "-"
OPERADOR_ARITMETICO_MULTIPLICACAO = "*"
OPERADOR_ARITMETICO_DIVISAO = "div"
PARENTESES_ESQ = "("
PARENTESES_DIR = ")"
SIMBOLO_DOIS_PONTOS = ":"
SIMBOLO_VIRGULA =  ","
SIMBOLO_PONTO_E_VIRGULA = ";"
SIMBOLO_TERMINACAO = "end."

/* Números e Identificadores */
IDENTIFICADOR = {LETRA}({LETRA}|{DIGITO})* // type String
NUMERO_INTEIRO = {DIGITO}{DIGITO}* // type Integer
LETRA = [_a-zA-Z] // type String
DIGITO = [0-9] // type Integer

/* Comentários */
COMENTARIO_UMA_LINHA = "//"[^\n]*\n?
COMENTARIO_MULT_LINHAS = "{"[^}]*"}"

ERRO_COMENTARIO_MULT_LINHAS_SEM_FECHAR = "{"[^}]*
ERRO_COMENTARIO_MULT_LINHAS_SEM_ABRIR = "}"

/* DELIMITADORES */
DELIMITADOR = [\n| |\t|\r|\r\n]

/* Erros */
ERRO_SIMBOLO_INVALIDO = [^]


%{
    public String token;
    public String lexema;
    public String erro;
    public int line;
    public int column;
    public int endColumn;


    public long getOffset(){
        return this.yychar;
    }
%}
%%
{DELIMITADOR}                               {}
{RSV_PROGRAMA}  		                    {token="RSV_PROGRAMA"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_PROGRAMA, yytext()); /*System.out.println(yytext()+" -> RSV_PROGRAMA");*/}
{RSV_PROCEDIMENTO}	                        {token="RSV_PROCEDIMENTO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_PROCEDIMENTO, yytext()); /*System.out.println(yytext()+" -> RSV_PROCEDIMENTO");*/}
{RSV_BEGIN} 			                    {token="RSV_BEGIN"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_BEGIN, yytext()); /*System.out.println(yytext()+" -> RSV_BEGIN");*/}
{RSV_END}				                    {token="RSV_END"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_END, yytext()); /*System.out.println(yytext()+" -> RSV_END");*/}
{RSV_IF} 				                    {token="RSV_IF"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_IF, yytext()); /*System.out.println(yytext()+" -> RSV_IF");*/}
{RSV_THEN}				                    {token="RSV_THEN"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_THEN, yytext()); /*System.out.println(yytext()+" -> RSV_THEN");*/}
{RSV_ELSE} 				                    {token="RSV_ELSE"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_ELSE, yytext()); /*System.out.println(yytext()+" -> RSV_ELSE");*/}
{RSV_WHILE} 			                    {token="RSV_WHILE"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_WHILE, yytext()); /*System.out.println(yytext()+" -> RSV_WHILE");*/}
{RSV_DO} 				                    {token="RSV_DO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_DO, yytext()); /*System.out.println(yytext()+" -> RSV_DO");*/}
{RSV_READ} 				                    {token="RSV_READ"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_READ, yytext()); /*System.out.println(yytext()+" -> RSV_READ");*/}
{RSV_WRITE} 			                    {token="RSV_WRITE"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_WRITE, yytext()); /*System.out.println(yytext()+" -> RSV_WRITE");*/}
{RSV_VAR} 				                    {token="RSV_VAR"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_DO, yytext()); /*System.out.println(yytext()+" -> RSV_VAR");*/}
{RSV_TRUE} 				                    {token="RSV_TRUE"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_TRUE, yytext()); /*System.out.println(yytext()+" -> RSV_TRUE");*/}
{RSV_FALSE}				                    {token="RSV_FALSE"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_FALSE, yytext()); /*System.out.println(yytext()+" -> RSV_FALSE");*/}
{TIPO_INT}                                  {token="TIPO_INT"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.TIPO_INT, yytext()); /*System.out.println(yytext()+" -> TIPO_INT");*/}
{TIPO_BOOLEAN}                              {token="TIPO_BOOLEAN"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.TIPO_BOOLEAN, yytext()); /*System.out.println(yytext()+" -> TIPO_BOOLEAN");*/}
{OPERADOR_LOGICO_DIFERENCA}                 {token="OPERADOR_LOGICO_DIFERENCA"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_LOGICO_DIFERENCA, yytext()); /*System.out.println(yytext()+" -> OPERADOR_LOGICO_DIFERENCA");*/}
{OPERADOR_LOGICO_MENOR}                     {token="OPERADOR_LOGICO_MENOR"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_LOGICO_MENOR, yytext()); /*System.out.println(yytext()+" -> OPERADOR_LOGICO_MENOR");*/}
{OPERADOR_LOGICO_MENOR_IGUAL}               {token="OPERADOR_LOGICO_MENOR_IGUAL"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_LOGICO_MENOR_IGUAL, yytext()); /*System.out.println(yytext()+" -> OPERADOR_LOGICO_MENOR_IGUAL");*/}
{OPERADOR_LOGICO_MAIOR_IGUAL}               {token="OPERADOR_LOGICO_MAIOR_IGUAL"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_LOGICO_MAIOR_IGUAL, yytext()); /*System.out.println(yytext()+" -> OPERADOR_LOGICO_MAIOR_IGUAL");*/}
{OPERADOR_LOGICO_MAIOR}                     {token="OPERADOR_LOGICO_MAIOR"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_LOGICO_MAIOR, yytext()); /*System.out.println(yytext()+" -> OPERADOR_LOGICO_MAIOR");*/}
{OPERADOR_LOGICO_IGUALDADE}                 {token="OPERADOR_LOGICO_IGUALDADE"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_LOGICO_IGUALDADE, yytext()); /*System.out.println(yytext()+" -> OPERADOR_LOGICO_IGUALDADE");*/}
{OPERADOR_LOGICO_AND}                       {token="OPERADOR_LOGICO_AND"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_LOGICO_AND, yytext()); /*System.out.println(yytext()+" -> OPERADOR_LOGICO_AND");*/}
{OPERADOR_LOGICO_OR}                        {token="OPERADOR_LOGICO_OR"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_LOGICO_OR, yytext()); /*System.out.println(yytext()+" -> OPERADOR_LOGICO_OR");*/}
{OPERADOR_LOGICO_NOT}                       {token="OPERADOR_LOGICO_NOT"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_LOGICO_NOT, yytext()); /*System.out.println(yytext()+" -> OPERADOR_LOGICO_NOT");*/}
{OPERADOR_ARITMETICO_ATRIBUICAO}            {token="OPERADOR_ARITMETICO_ATRIBUICAO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_ARITMETICO_ATRIBUICAO, yytext()); /*System.out.println(yytext()+" -> OPERADOR_ARITMETICO_ATRIBUICAO");*/}
{OPERADOR_ARITMETICO_ADICAO}                {token="OPERADOR_ARITMETICO_ADICAO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_ARITMETICO_ADICAO, yytext()); /*System.out.println(yytext()+" -> OPERADOR_ARITMETICO_ADICAO");*/}
{OPERADOR_ARITMETICO_SUBTRACAO}             {token="OPERADOR_ARITMETICO_SUBTRACAO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_ARITMETICO_SUBTRACAO, yytext()); /*System.out.println(yytext()+" -> OPERADOR_ARITMETICO_SUBTRACAO");*/}
{OPERADOR_ARITMETICO_MULTIPLICACAO}         {token="OPERADOR_ARITMETICO_MULTIPLICACAO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_ARITMETICO_MULTIPLICACAO, yytext()); /*System.out.println(yytext()+" -> OPERADOR_ARITMETICO_MULTIPLICACAO");*/}
{OPERADOR_ARITMETICO_DIVISAO}               {token="OPERADOR_ARITMETICO_DIVISAO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_ARITMETICO_DIVISAO, yytext()); /*System.out.println(yytext()+" -> OPERADOR_ARITMETICO_DIVISAO");*/}
{PARENTESES_ESQ}                            {token="PARENTESES_ESQ"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.PARENTESES_ESQ, yytext()); /*System.out.println(yytext()+" -> PARENTESES_ESQ");*/}
{PARENTESES_DIR}                            {token="PARENTESES_DIR"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.PARENTESES_DIR, yytext()); /*System.out.println(yytext()+" -> PARENTESES_DIR");*/}
{SIMBOLO_DOIS_PONTOS}                       {token="SIMBOLO_DOIS_PONTOS"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.SIMBOLO_DOIS_PONTOS, yytext()); /*System.out.println(yytext()+" -> SIMBOLO_DOIS_PONTOS");*/}
{SIMBOLO_VIRGULA}                           {token="SIMBOLO_VIRGULA"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.SIMBOLO_VIRGULA, yytext()); /*System.out.println(yytext()+" -> SIMBOLO_VIRGULA");*/}
{SIMBOLO_PONTO_E_VIRGULA}                   {token="SIMBOLO_PONTO_E_VIRGULA"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.SIMBOLO_PONTO_E_VIRGULA, yytext()); /*System.out.println(yytext()+" -> SIMBOLO_PONTO_E_VIRGULA");*/}
{SIMBOLO_TERMINACAO}                        {token="SIMBOLO_TERMINACAO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.SIMBOLO_TERMINACAO, yytext()); /*System.out.println(yytext()+" -> SIMBOLO_TERMINACAO");*/}
{IDENTIFICADOR}                             {
                                                if(yylength() <= 15){
                                                    token="IDENTIFICADOR";
                                                    lexema=yytext();
                                                    line=yyline;
                                                    column=yycolumn;
                                                    endColumn=column+yylength()-1;
                                                    return new Symbol(Tokens.IDENTIFICADOR, new String(yytext()));
                                                    /*System.out.println(yytext()+" -> IDENTIFICADOR");*/
                                                }
                                                else{
                                                    token="";
                                                    lexema=yytext();
                                                    line=yyline;
                                                    column=yycolumn;
                                                    endColumn=column+yylength()-1;
                                                    erro="[Tokens.ERRO_TAM_MAX_IDENTIFICADOR] Tamanho máximo para indentificador (15) excedido";
                                                    return new Symbol(Tokens.ERRO_TAM_MAX_IDENTIFICADOR, yytext());
                                                    /*System.out.println(yytext()+" -> Tokens.ERRO_TAM_MAX_IDENTIFICADOR");*/
                                                }
                                            }
{NUMERO_INTEIRO}                            {
                                                if(yylength() <= 8){
                                                    token="NUMERO_INTEIRO";
                                                    lexema=yytext();
                                                    line=yyline;
                                                    column=yycolumn;
                                                    endColumn=column+yylength()-1;
                                                    return new Symbol(Tokens.NUMERO_INTEIRO, Integer.parseInt(yytext()));
                                                    /*System.out.println(yytext()+" -> NUMERO_INTEIRO");*/
                                                }
                                                else{
                                                    token="";
                                                    lexema=yytext();
                                                    line=yyline;
                                                    column=yycolumn;
                                                    endColumn=column+yylength()-1;
                                                    erro="[Tokens.ERRO_TAM_MAX_NUMERO] Tamanho máximo para número inteiro (8) excedido";
                                                    return new Symbol(Tokens.ERRO_TAM_MAX_NUMERO, yytext());
                                                    /*System.out.println(yytext()+" -> Tokens.ERRO_TAM_MAX_NUMERO");*/
                                                }
                                            }
{COMENTARIO_UMA_LINHA}                      {token="COMENTARIO_UMA_LINHA"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.COMENTARIO_UMA_LINHA, yytext()); /*System.out.println(yytext()+" -> COMENTARIO_UMA_LINHA");*/}
{COMENTARIO_MULT_LINHAS}                    {token="COMENTARIO_MULT_LINHAS"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.COMENTARIO_MULT_LINHAS, yytext()); /*System.out.println(yytext()+" -> COMENTARIO_MULT_LINHAS");*/}
{ERRO_COMENTARIO_MULT_LINHAS_SEM_FECHAR}    {token=""; line=yyline; column=yycolumn; endColumn=column+yylength()-1; lexema=yytext(); erro="[ERRO_COMENTARIO_MULT_LINHAS_SEM_FECHAR] O bloco de comentário não foi fechado"; return new Symbol(Tokens.ERRO_COMENTARIO_MULT_LINHAS_SEM_FECHAR, yytext()); /*System.out.println(yytext()+" -> ERRO_COMENTARIO_MULT_LINHAS_SEM_FECHAR");*/}
{ERRO_COMENTARIO_MULT_LINHAS_SEM_ABRIR}     {token=""; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; erro="[ERRO_COMENTARIO_MULT_LINHAS_SEM_ABRIR] O bloco de comentário não foi aberto"; return new Symbol(Tokens.ERRO_COMENTARIO_MULT_LINHAS_SEM_ABRIR, yytext()); /*System.out.println(yytext()+" -> ERRO_COMENTARIO_MULT_LINHAS_SEM_ABRIR");*/}
{ERRO_SIMBOLO_INVALIDO}                     {token=""; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; erro="[ERRO_SIMBOLO_INVALIDO] Simbolo Inválido"; return new Symbol(Tokens.ERRO_SIMBOLO_INVALIDO, yytext()); /*System.out.println(yytext()+" -> ERRO_SIMBOLO_INVALIDO");*/}
