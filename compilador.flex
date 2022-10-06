%%

%standalone
%class Compilador
%type Tokens
%line
%column
%unicode

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
SIMBOLO_PONTO = "."

/* Números e Identificadores */
IDENTIFICADOR = {LETRA}({LETRA}|{DIGITO})*
NUMERO_INTEIRO = {DIGITO}{DIGITO}*
LETRA = [_a-zA-Z]
DIGITO = [0-9]

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
%}
%%
{DELIMITADOR}                               {}
{RSV_PROGRAMA}  		                    {token="RSV_PROGRAMA"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return RSV_PROGRAMA; /*System.out.println(yytext()+" -> RSV_PROGRAMA");*/}
{RSV_PROCEDIMENTO}	                        {token="RSV_PROCEDIMENTO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return RSV_PROCEDIMENTO; /*System.out.println(yytext()+" -> RSV_PROCEDIMENTO");*/}
{RSV_BEGIN} 			                    {token="RSV_BEGIN"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return RSV_BEGIN; /*System.out.println(yytext()+" -> RSV_BEGIN");*/}
{RSV_END}				                    {token="RSV_END"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return RSV_END; /*System.out.println(yytext()+" -> RSV_END");*/}
{RSV_IF} 				                    {token="RSV_IF"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return RSV_IF; /*System.out.println(yytext()+" -> RSV_IF");*/}
{RSV_THEN}				                    {token="RSV_THEN"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return RSV_THEN; /*System.out.println(yytext()+" -> RSV_THEN");*/}
{RSV_ELSE} 				                    {token="RSV_ELSE"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return RSV_ELSE; /*System.out.println(yytext()+" -> RSV_ELSE");*/}
{RSV_WHILE} 			                    {token="RSV_WHILE"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return RSV_WHILE; /*System.out.println(yytext()+" -> RSV_WHILE");*/}
{RSV_DO} 				                    {token="RSV_DO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return RSV_DO; /*System.out.println(yytext()+" -> RSV_DO");*/}
{RSV_READ} 				                    {token="RSV_READ"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return RSV_READ; /*System.out.println(yytext()+" -> RSV_READ");*/}
{RSV_WRITE} 			                    {token="RSV_WRITE"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return RSV_WRITE; /*System.out.println(yytext()+" -> RSV_WRITE");*/}
{RSV_VAR} 				                    {token="RSV_VAR"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return RSV_VAR; /*System.out.println(yytext()+" -> RSV_VAR");*/}
{RSV_TRUE} 				                    {token="RSV_TRUE"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return RSV_TRUE; /*System.out.println(yytext()+" -> RSV_TRUE");*/}
{RSV_FALSE}				                    {token="RSV_FALSE"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return RSV_FALSE; /*System.out.println(yytext()+" -> RSV_FALSE");*/}
{TIPO_INT}                                  {token="TIPO_INT"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return TIPO_INT; /*System.out.println(yytext()+" -> TIPO_INT");*/}
{TIPO_BOOLEAN}                              {token="TIPO_BOOLEAN"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return TIPO_BOOLEAN; /*System.out.println(yytext()+" -> TIPO_BOOLEAN");*/}
{OPERADOR_LOGICO_DIFERENCA}                 {token="OPERADOR_LOGICO_DIFERENCA"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return OPERADOR_LOGICO_DIFERENCA; /*System.out.println(yytext()+" -> OPERADOR_LOGICO_DIFERENCA");*/}
{OPERADOR_LOGICO_MENOR}                     {token="OPERADOR_LOGICO_MENOR"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return OPERADOR_LOGICO_MENOR; /*System.out.println(yytext()+" -> OPERADOR_LOGICO_MENOR");*/}
{OPERADOR_LOGICO_MENOR_IGUAL}               {token="OPERADOR_LOGICO_MENOR_IGUAL"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return OPERADOR_LOGICO_MENOR_IGUAL; /*System.out.println(yytext()+" -> OPERADOR_LOGICO_MENOR_IGUAL");*/}
{OPERADOR_LOGICO_MAIOR_IGUAL}               {token="OPERADOR_LOGICO_MAIOR_IGUAL"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return OPERADOR_LOGICO_MAIOR_IGUAL; /*System.out.println(yytext()+" -> OPERADOR_LOGICO_MAIOR_IGUAL");*/}
{OPERADOR_LOGICO_MAIOR}                     {token="OPERADOR_LOGICO_MAIOR"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return OPERADOR_LOGICO_MAIOR; /*System.out.println(yytext()+" -> OPERADOR_LOGICO_MAIOR");*/}
{OPERADOR_LOGICO_IGUALDADE}                 {token="OPERADOR_LOGICO_IGUALDADE"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return OPERADOR_LOGICO_IGUALDADE; /*System.out.println(yytext()+" -> OPERADOR_LOGICO_IGUALDADE");*/}
{OPERADOR_LOGICO_AND}                       {token="OPERADOR_LOGICO_AND"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return OPERADOR_LOGICO_AND; /*System.out.println(yytext()+" -> OPERADOR_LOGICO_AND");*/}
{OPERADOR_LOGICO_OR}                        {token="OPERADOR_LOGICO_OR"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return OPERADOR_LOGICO_OR; /*System.out.println(yytext()+" -> OPERADOR_LOGICO_OR");*/}
{OPERADOR_LOGICO_NOT}                       {token="OPERADOR_LOGICO_NOT"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return OPERADOR_LOGICO_NOT; /*System.out.println(yytext()+" -> OPERADOR_LOGICO_NOT");*/}
{OPERADOR_ARITMETICO_ATRIBUICAO}            {token="OPERADOR_ARITMETICO_ATRIBUICAO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return OPERADOR_ARITMETICO_ATRIBUICAO; /*System.out.println(yytext()+" -> OPERADOR_ARITMETICO_ATRIBUICAO");*/}
{OPERADOR_ARITMETICO_ADICAO}                {token="OPERADOR_ARITMETICO_ADICAO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return OPERADOR_ARITMETICO_ADICAO; /*System.out.println(yytext()+" -> OPERADOR_ARITMETICO_ADICAO");*/}
{OPERADOR_ARITMETICO_SUBTRACAO}             {token="OPERADOR_ARITMETICO_SUBTRACAO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return OPERADOR_ARITMETICO_SUBTRACAO; /*System.out.println(yytext()+" -> OPERADOR_ARITMETICO_SUBTRACAO");*/}
{OPERADOR_ARITMETICO_MULTIPLICACAO}         {token="OPERADOR_ARITMETICO_MULTIPLICACAO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return OPERADOR_ARITMETICO_MULTIPLICACAO; /*System.out.println(yytext()+" -> OPERADOR_ARITMETICO_MULTIPLICACAO");*/}
{OPERADOR_ARITMETICO_DIVISAO}               {token="OPERADOR_ARITMETICO_DIVISAO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return OPERADOR_ARITMETICO_DIVISAO; /*System.out.println(yytext()+" -> OPERADOR_ARITMETICO_DIVISAO");*/}
{PARENTESES_ESQ}                            {token="PARENTESES_ESQ"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return PARENTESES_ESQ; /*System.out.println(yytext()+" -> PARENTESES_ESQ");*/}
{PARENTESES_DIR}                            {token="PARENTESES_DIR"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return PARENTESES_DIR; /*System.out.println(yytext()+" -> PARENTESES_DIR");*/}
{SIMBOLO_DOIS_PONTOS}                       {token="SIMBOLO_DOIS_PONTOS"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return SIMBOLO_DOIS_PONTOS; /*System.out.println(yytext()+" -> SIMBOLO_DOIS_PONTOS");*/}
{SIMBOLO_VIRGULA}                           {token="SIMBOLO_VIRGULA"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return SIMBOLO_VIRGULA; /*System.out.println(yytext()+" -> SIMBOLO_VIRGULA");*/}
{SIMBOLO_PONTO_E_VIRGULA}                   {token="SIMBOLO_PONTO_E_VIRGULA"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return SIMBOLO_PONTO_E_VIRGULA; /*System.out.println(yytext()+" -> SIMBOLO_PONTO_E_VIRGULA");*/}
{SIMBOLO_PONTO}                             {token="SIMBOLO_PONTO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return SIMBOLO_PONTO; /*System.out.println(yytext()+" -> SIMBOLO_PONTO");*/}
{IDENTIFICADOR}                             {
                                                if(yylength() <= 15){
                                                    token="IDENTIFICADOR";
                                                    lexema=yytext();
                                                    line=yyline;
                                                    column=yycolumn;
                                                    endColumn=column+yylength()-1;
                                                    return IDENTIFICADOR;
                                                    /*System.out.println(yytext()+" -> IDENTIFICADOR");*/
                                                }
                                                else{
                                                    token="";
                                                    lexema=yytext();
                                                    line=yyline;
                                                    column=yycolumn;
                                                    endColumn=column+yylength()-1;
                                                    erro="[ERRO_TAM_MAX_IDENTIFICADOR] Tamanho máximo para indentificador (15) excedido";
                                                    return ERRO;
                                                    /*System.out.println(yytext()+" -> ERRO_TAM_MAX_IDENTIFICADOR");*/
                                                }
                                            }
{NUMERO_INTEIRO}                            {
                                                if(yylength() <= 8){
                                                    token="NUMERO_INTEIRO";
                                                    lexema=yytext();
                                                    line=yyline;
                                                    column=yycolumn;
                                                    endColumn=column+yylength()-1;
                                                    return NUMERO_INTEIRO;
                                                    /*System.out.println(yytext()+" -> NUMERO_INTEIRO");*/
                                                }
                                                else{
                                                    token="";
                                                    lexema=yytext();
                                                    line=yyline;
                                                    column=yycolumn;
                                                    endColumn=column+yylength()-1;
                                                    erro="[ERRO_TAM_MAX_NUMERO] Tamanho máximo para número inteiro (8) excedido";
                                                    return ERRO;
                                                    /*System.out.println(yytext()+" -> ERRO_TAM_MAX_NUMERO");*/
                                                }
                                            }
{COMENTARIO_UMA_LINHA}                      {token="COMENTARIO_UMA_LINHA"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return COMENTARIO_UMA_LINHA; /*System.out.println(yytext()+" -> COMENTARIO_UMA_LINHA");*/}
{COMENTARIO_MULT_LINHAS}                    {token="COMENTARIO_MULT_LINHAS"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return COMENTARIO_MULT_LINHAS; /*System.out.println(yytext()+" -> COMENTARIO_MULT_LINHAS");*/}
{ERRO_COMENTARIO_MULT_LINHAS_SEM_FECHAR}    {token=""; line=yyline; column=yycolumn; endColumn=column+yylength()-1; lexema=yytext(); erro="[ERRO_COMENTARIO_MULT_LINHAS_SEM_FECHAR] O bloco de comentário não foi fechado"; return ERRO; /*System.out.println(yytext()+" -> ERRO_COMENTARIO_MULT_LINHAS_SEM_FECHAR");*/}
{ERRO_COMENTARIO_MULT_LINHAS_SEM_ABRIR}     {token=""; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; erro="[ERRO_COMENTARIO_MULT_LINHAS_SEM_ABRIR] O bloco de comentário não foi aberto"; return ERRO; /*System.out.println(yytext()+" -> ERRO_COMENTARIO_MULT_LINHAS_SEM_ABRIR");*/}
{ERRO_SIMBOLO_INVALIDO}                     {token=""; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; erro="[ERRO_SIMBOLO_INVALIDO] Simbolo Inválido"; return ERRO; /*System.out.println(yytext()+" -> ERRO_SIMBOLO_INVALIDO");*/}