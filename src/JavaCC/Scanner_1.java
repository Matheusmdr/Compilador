/* Scanner_1.java */
/* Generated By:JavaCC: Do not edit this line. Scanner_1.java */
package JavaCC;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Scanner_1 implements Scanner_1Constants {

boolean Menosshort = false; //Saida resumida falso
ArrayList<String> listaErrosSintax = new ArrayList<>();

/*public cadeProgram() {
    Token t = new Token ();
    do {

    t = getNextToken(); //Obtém o próximo token
    String nomeToken = tokenImage[t.kind]; //guarda o nome do token na string

    } while(t.kind!=0); //condicao de parada: final do arquivo (constante eof 0 )
}

public void processa() throws Exception{
    Token t = new Token ();

    do {

    t = getNextToken(); //Obtém o próximo token
    String nomeToken = tokenImage[t.kind]; //guarda o nome do token na string

    } while(t.kind!=0); //condicao de parada: final do arquivo (constante eof 0 )
}

public void processaSintax(Scanner_1 parser) throws ParseException {
    System.out.println("comeco");
    //parser.principal();
    //cadeProgram();
    System.out.println("cabo");
}*/

public static void main(String args[], String x) throws ParseException, FileNotFoundException {

try {


}catch (Error e){
System.out.println(e.getMessage()); //Mensagem de erro léxico (em ingles) mostrando linha e coluna
}

}

    public ArrayList<String> getListaErrosSintax() {
        return listaErrosSintax;
    }

  void error_skipto(ParseException e, ArrayList<Integer> sincronizadores) throws ParseException {String erro = e.toString();
      //System.out.println(erro);  // print the error message
      armazenamentoErros(erro);
      Token t;
      // consume tokens all the way up to a token of "kind" - use a do-while loop
      // rather than a while because the current token is the one immediately before
      // the erroneous token (in our case the token immediately before what should
      // have been "if"/"while".
      do {
        t = getNextToken();
        System.out.println(t.kind);
      }
      while (!sincronizadores.contains(t.kind));
  }

  void armazenamentoErros(String erro) throws ParseException {//String erro = e.toString();
        String parametroErro = "Was expecting";
        String[] split = erro.split(parametroErro);
        String comecoErro = split[0];
        for(String str : listaErrosSintax) {
            String[] parte = str.split(parametroErro);
            String comecoErro1 = parte[0];
            if(comecoErro1.equals(comecoErro))
                return;
        }
        listaErrosSintax.add(erro); // save the error message

  }

  void teste(int kind) throws ParseException {ParseException e = generateParseException();  // generate the exception object
      String erro = e.toString();
      //System.out.println(erro);  // print the error message
      armazenamentoErros(erro);
      Token t;
      // consume tokens all the way up to a token of "kind" - use a do-while loop
      // rather than a while because the current token is the one immediately before
      // the erroneous token (in our case the token immediately before what should
      // have been "if"/"while".
      do {
        t = getNextToken();
      }
      while (t.kind != kind);
  }

  final public void principal() throws ParseException {Token t = new Token();
    try {
      programa();
      jj_consume_token(0);
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF)));
    }
}

  final public void programa() throws ParseException {Token t = new Token();
    try {
      jj_consume_token(RSV_PROGRAMA);
t = getToken(0); System.out.println("RSV_PROGRAMA Sintax: "+t.image);
      jj_consume_token(IDENTIFICADOR);
t = getToken(0); System.out.println("IDENTIFICADOR Sintax: "+t.image);
      jj_consume_token(SIMBOLO_PONTO_E_VIRGULA);
t = getToken(0); System.out.println("SIMBOLO_PONTO_E_VIRGULA Sintax: "+t.image);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TIPO_INT:
      case TIPO_BOOLEAN:{
        parteDeclaracaoVariaveis();
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case RSV_PROCEDIMENTO:{
        parteDeclaracaoSubrotinas();
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        ;
      }
      jj_consume_token(RSV_BEGIN);
t = getToken(0); System.out.println("RSV_BEGIN Sintax: "+t.image);
      comando();
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case SIMBOLO_PONTO_E_VIRGULA:{
          ;
          break;
          }
        default:
          jj_la1[2] = jj_gen;
          break label_1;
        }
        jj_consume_token(SIMBOLO_PONTO_E_VIRGULA);
t = getToken(0); System.out.println("SIMBOLO_PONTO_E_VIRGULA Sintax: "+t.image);
        comando();
      }
      jj_consume_token(RSV_FIM);
t = getToken(0); System.out.println("RSV_FIM Sintax: "+t.image);
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, SIMBOLO_PONTO_E_VIRGULA)));
        bloco();
        //System.out.println("!!!! PROGRAMA !!!!");

    }
}

  final public void bloco() throws ParseException {Token t = new Token();
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TIPO_INT:
      case TIPO_BOOLEAN:{
        parteDeclaracaoVariaveis();
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case RSV_PROCEDIMENTO:{
        parteDeclaracaoSubrotinas();
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        ;
      }
      comandoComposto();
    } catch (ParseException e) {
armazenamentoErros(e.toString());
        //error_skipto(e, new ArrayList<>(Arrays.asList(EOF)));
        bloco();
    }
}

  final public void parteDeclaracaoVariaveis() throws ParseException {Token t = new Token();
    try {
      declaracaoVariavel();
      jj_consume_token(SIMBOLO_PONTO_E_VIRGULA);
t = getToken(0); System.out.println("SIMBOLO_PONTO_E_VIRGULA Sintax: "+t.image);
      auxParteDeclaracaoVariaveis();
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, RSV_BEGIN)));
        comando();
        //System.out.println("!!!! parteDeclaracaoVariaveis !!!!");

    }
}

  final public void auxParteDeclaracaoVariaveis() throws ParseException {Token t = new Token();
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TIPO_INT:
      case TIPO_BOOLEAN:{
        declaracaoVariavel();
        jj_consume_token(SIMBOLO_PONTO_E_VIRGULA);
t = getToken(0); System.out.println("SIMBOLO_PONTO_E_VIRGULA Sintax: "+t.image);
        auxParteDeclaracaoVariaveis();
        break;
        }
      default:
        jj_la1[5] = jj_gen;

      }
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, RSV_BEGIN)));
        comando();
        System.out.println("!!!! auxParteDeclaracaoVariaveis !!!!");
    }
}

  final public void declaracaoVariavel() throws ParseException {Token t = new Token();
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TIPO_BOOLEAN:{
        jj_consume_token(TIPO_BOOLEAN);
t = getToken(0); System.out.println("TIPO_BOOLEAN Sintax: "+t.image);
        break;
        }
      case TIPO_INT:{
        jj_consume_token(TIPO_INT);
t = getToken(0); System.out.println("TIPO_INT Sintax: "+t.image);
        break;
        }
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      listaIdentificadores();
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, RSV_BEGIN)));
        comando();
    }
}

  final public void listaIdentificadores() throws ParseException {Token t = new Token();
    try {
      jj_consume_token(IDENTIFICADOR);
t = getToken(0); System.out.println("IDENTIFICADOR Sintax: "+t.image);
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case SIMBOLO_VIRGULA:{
          ;
          break;
          }
        default:
          jj_la1[7] = jj_gen;
          break label_2;
        }
        jj_consume_token(SIMBOLO_VIRGULA);
t = getToken(0); System.out.println("SIMBOLO_VIRGULA Sintax: "+t.image);
        jj_consume_token(IDENTIFICADOR);
t = getToken(0); System.out.println("IDENTIFICADOR Sintax: "+t.image);
      }
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, RSV_BEGIN)));
        comando();
    }
}

  final public void parteDeclaracaoSubrotinas() throws ParseException {Token t = new Token();
    try {
      label_3:
      while (true) {
        declaracaoProcedimento();
        jj_consume_token(SIMBOLO_PONTO_E_VIRGULA);
t = getToken(0); System.out.println("SIMBOLO_PONTO_E_VIRGULA Sintax: "+t.image);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case RSV_PROCEDIMENTO:{
          ;
          break;
          }
        default:
          jj_la1[8] = jj_gen;
          break label_3;
        }
      }
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        /* error_skipto(new ArrayList<>(Arrays.asList(SIMBOLO_PONTO_E_VIRGULA, SIMBOLO_PONTO)));
        return; */
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, RSV_BEGIN)));
        comando();
    }
}

  final public void declaracaoProcedimento() throws ParseException {Token t = new Token();
    try {
      jj_consume_token(RSV_PROCEDIMENTO);
t = getToken(0); System.out.println("RSV_PROCEDIMENTO Sintax: "+t.image);
      jj_consume_token(IDENTIFICADOR);
t = getToken(0); System.out.println("IDENTIFICADOR Sintax: "+t.image);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PARENTESES_ESQ:{
        parametrosFormais();
        break;
        }
      default:
        jj_la1[9] = jj_gen;
        ;
      }
      jj_consume_token(SIMBOLO_PONTO_E_VIRGULA);
t = getToken(0); System.out.println("SIMBOLO_PONTO_E_VIRGULA Sintax: "+t.image);
      bloco();
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        /* error_skipto(new ArrayList<>(Arrays.asList(SIMBOLO_PONTO_E_VIRGULA)));
        parteDeclaracaoSubrotinas(); */
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, RSV_BEGIN)));
        comando();
    }
}

  final public void parametrosFormais() throws ParseException {Token t = new Token();
    try {
      jj_consume_token(PARENTESES_ESQ);
t = getToken(0); System.out.println("PARENTESES_ESQ Sintax: "+t.image);
      secaoParametrosFormais();
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case SIMBOLO_PONTO_E_VIRGULA:{
          ;
          break;
          }
        default:
          jj_la1[10] = jj_gen;
          break label_4;
        }
        jj_consume_token(SIMBOLO_PONTO_E_VIRGULA);
t = getToken(0); System.out.println("SIMBOLO_PONTO_E_VIRGULA Sintax: "+t.image);
        secaoParametrosFormais();
      }
      jj_consume_token(PARENTESES_DIR);
t = getToken(0); System.out.println("PARENTESES_DIR Sintax: "+t.image);
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        /* error_skipto(new ArrayList<>(Arrays.asList(SIMBOLO_PONTO_E_VIRGULA)));
        bloco(); */
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, RSV_BEGIN)));
        comando();
    }
}

  final public void secaoParametrosFormais() throws ParseException {Token t = new Token();
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case RSV_VAR:{
        jj_consume_token(RSV_VAR);
t = getToken(0); System.out.println("RSV_VAR Sintax: "+t.image);
        break;
        }
      default:
        jj_la1[11] = jj_gen;
        ;
      }
      listaIdentificadores();
      jj_consume_token(SIMBOLO_DOIS_PONTOS);
t = getToken(0); System.out.println("SIMBOLO_DOIS_PONTOS Sintax: "+t.image);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TIPO_BOOLEAN:{
        jj_consume_token(TIPO_BOOLEAN);
t = getToken(0); System.out.println("TIPO_BOOLEAN Sintax: "+t.image);
        break;
        }
      case TIPO_INT:{
        jj_consume_token(TIPO_INT);
t = getToken(0); System.out.println("TIPO_INT Sintax: "+t.image);
        break;
        }
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, RSV_BEGIN)));
        comando();
    }
}

  final public void comandoComposto() throws ParseException {Token t = new Token();
    try {
      jj_consume_token(RSV_BEGIN);
t = getToken(0); System.out.println("RSV_BEGIN Sintax: "+t.image);
      comando();
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case SIMBOLO_PONTO_E_VIRGULA:{
          ;
          break;
          }
        default:
          jj_la1[13] = jj_gen;
          break label_5;
        }
        jj_consume_token(SIMBOLO_PONTO_E_VIRGULA);
t = getToken(0); System.out.println("SIMBOLO_PONTO_E_VIRGULA Sintax: "+t.image);
        comando();
      }
      jj_consume_token(RSV_END);
t = getToken(0); System.out.println("RSV_END Sintax: "+t.image);
    } catch (ParseException e) {
//error_skipto(e, new ArrayList<>(Arrays.asList(EOF, SIMBOLO_PONTO_E_VIRGULA)));
        Token token = new Token();
        token = getToken(0);
        if(token.kind == RSV_END)
            error_skipto(e, new ArrayList<>(Arrays.asList(EOF, SIMBOLO_PONTO_E_VIRGULA)));
        else {
            comando();
            armazenamentoErros(e.toString());
        }
    }
}

  final public void comando() throws ParseException {Token t = new Token();
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IDENTIFICADOR:{
        atribuicao();
        break;
        }
      case IDENTIFICADOR_CHAMADA_PROCEDIMENTO:{
        chamadaProcedimento();
        break;
        }
      case RSV_BEGIN:{
        comandoComposto();
        break;
        }
      case RSV_IF:{
        comandoCondicional();
        break;
        }
      case RSV_WHILE:{
        comandoRepetitivo();
        break;
        }
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF)));
    }
}

  final public void comandoRepetitivo() throws ParseException {Token t = new Token();
    try {
      jj_consume_token(RSV_WHILE);
t = getToken(0); System.out.println("RSV_WHILE Sintax: "+t.image);
      expressao();
      jj_consume_token(RSV_DO);
t = getToken(0); System.out.println("RSV_DO Sintax: "+t.image);
      comando();
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, RSV_DO, SIMBOLO_PONTO_E_VIRGULA)));
        comando();
    }
}

  final public void comandoCondicional() throws ParseException {Token t = new Token();
    try {
      jj_consume_token(RSV_IF);
t = getToken(0); System.out.println("RSV_IF Sintax: "+t.image);
      expressao();
      jj_consume_token(RSV_THEN);
t = getToken(0); System.out.println("RSV_THEN Sintax: "+t.image);
      comando();
      auxComandoCondicional();
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, RSV_THEN, SIMBOLO_PONTO_E_VIRGULA)));
        comando();
    }
}

  final public void auxComandoCondicional() throws ParseException {Token t = new Token();
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case RSV_ELSE:{
        jj_consume_token(RSV_ELSE);
t = getToken(0); System.out.println("RSV_ELSE Sintax: "+t.image);
        comando();
        break;
        }
      default:
        jj_la1[15] = jj_gen;

      }
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, SIMBOLO_PONTO_E_VIRGULA)));
        comando();
    }
}

  final public void chamadaProcedimento() throws ParseException {Token t = new Token();
    try {
      jj_consume_token(IDENTIFICADOR_CHAMADA_PROCEDIMENTO);
t = getToken(0); System.out.println("IDENTIFICADOR_CHAMADA_PROCEDIMENTO Sintax: "+t.image);
      jj_consume_token(PARENTESES_ESQ);
t = getToken(0); System.out.println("PARENTESES_ESQ Sintax: "+t.image);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case OPERADOR_LOGICO_NOT:
      case OPERADOR_ARITMETICO_ADICAO:
      case OPERADOR_ARITMETICO_SUBTRACAO:
      case PARENTESES_ESQ:
      case IDENTIFICADOR:
      case NUMERO_INTEIRO:{
        listaExpressoes();
        break;
        }
      default:
        jj_la1[16] = jj_gen;
        ;
      }
      jj_consume_token(PARENTESES_DIR);
t = getToken(0); System.out.println("PARENTESES_DIR Sintax: "+t.image);
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, SIMBOLO_PONTO_E_VIRGULA)));
        comando();
    }
}

  final public void atribuicao() throws ParseException {Token t = new Token();
    try {
      variavel();
      jj_consume_token(OPERADOR_ARITMETICO_ATRIBUICAO);
t = getToken(0); System.out.println("OPERADOR_ARITMETICO_ATRIBUICAO Sintax: "+t.image);
      expressao();
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, SIMBOLO_PONTO_E_VIRGULA)));
        comando();
    }
}

  final public void listaExpressoes() throws ParseException {Token t = new Token();
    try {
      expressao();
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case SIMBOLO_VIRGULA:{
          ;
          break;
          }
        default:
          jj_la1[17] = jj_gen;
          break label_6;
        }
        jj_consume_token(SIMBOLO_VIRGULA);
t = getToken(0); System.out.println("SIMBOLO_VIRGULA Sintax: "+t.image);
        expressao();
      }
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, SIMBOLO_PONTO_E_VIRGULA)));
        comando();
    }
}

  final public void expressao() throws ParseException {Token t = new Token();
    try {
      expressaoSimples();
      auxExpressao();
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF)));
    }
}

  final public void auxExpressao() throws ParseException {Token t = new Token();
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case OPERADOR_LOGICO_DIFERENCA:
      case OPERADOR_LOGICO_IGUAL_IGUAL:
      case OPERADOR_LOGICO_MENOR:
      case OPERADOR_LOGICO_MENOR_IGUAL:
      case OPERADOR_LOGICO_MAIOR_IGUAL:
      case OPERADOR_LOGICO_MAIOR:{
        relacao();
        expressaoSimples();
        break;
        }
      default:
        jj_la1[18] = jj_gen;

      }
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
       error_skipto(e, new ArrayList<>(Arrays.asList(EOF)));
    }
}

  final public void expressaoSimples() throws ParseException {Token t = new Token();
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case OPERADOR_ARITMETICO_ADICAO:
      case OPERADOR_ARITMETICO_SUBTRACAO:{
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case OPERADOR_ARITMETICO_ADICAO:{
          jj_consume_token(OPERADOR_ARITMETICO_ADICAO);
t = getToken(0); System.out.println("OPERADOR_ARITMETICO_ADICAO Sintax: "+t.image);
          break;
          }
        case OPERADOR_ARITMETICO_SUBTRACAO:{
          jj_consume_token(OPERADOR_ARITMETICO_SUBTRACAO);
t = getToken(0); System.out.println("OPERADOR_ARITMETICO_SUBTRACAO Sintax: "+t.image);
          break;
          }
        default:
          jj_la1[19] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      default:
        jj_la1[20] = jj_gen;
        ;
      }
      termo();
      auxExpressaoSimples();
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, SIMBOLO_PONTO_E_VIRGULA)));
        comando();
    }
}

  final public void auxExpressaoSimples() throws ParseException {Token t = new Token();
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case OPERADOR_LOGICO_OR:
      case OPERADOR_ARITMETICO_ADICAO:
      case OPERADOR_ARITMETICO_SUBTRACAO:{
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case OPERADOR_ARITMETICO_ADICAO:{
          jj_consume_token(OPERADOR_ARITMETICO_ADICAO);
t = getToken(0); System.out.println("OPERADOR_ARITMETICO_ADICAO Sintax: "+t.image);
          break;
          }
        case OPERADOR_ARITMETICO_SUBTRACAO:{
          jj_consume_token(OPERADOR_ARITMETICO_SUBTRACAO);
t = getToken(0); System.out.println("OPERADOR_ARITMETICO_SUBTRACAO Sintax: "+t.image);
          break;
          }
        case OPERADOR_LOGICO_OR:{
          jj_consume_token(OPERADOR_LOGICO_OR);
t = getToken(0); System.out.println("OPERADOR_LOGICO_OR Sintax: "+t.image);
          break;
          }
        default:
          jj_la1[21] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        termo();
        auxExpressaoSimples();
        break;
        }
      default:
        jj_la1[22] = jj_gen;

      }
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, SIMBOLO_PONTO_E_VIRGULA)));
        comando();
    }
}

  final public void termo() throws ParseException {Token t = new Token();
    try {
      fator();
      auxTermo();
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF)));
    }
}

  final public void auxTermo() throws ParseException {Token t = new Token();
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case OPERADOR_LOGICO_AND:
      case OPERADOR_ARITMETICO_MULTIPLICACAO:
      case OPERADOR_ARITMETICO_DIVISAO:{
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case OPERADOR_ARITMETICO_MULTIPLICACAO:{
          jj_consume_token(OPERADOR_ARITMETICO_MULTIPLICACAO);
t = getToken(0); System.out.println("OPERADOR_ARITMETICO_MULTIPLICACAO Sintax: "+t.image);
          break;
          }
        case OPERADOR_ARITMETICO_DIVISAO:{
          jj_consume_token(OPERADOR_ARITMETICO_DIVISAO);
t = getToken(0); System.out.println("OPERADOR_ARITMETICO_DIVISAO Sintax: "+t.image);
          break;
          }
        case OPERADOR_LOGICO_AND:{
          jj_consume_token(OPERADOR_LOGICO_AND);
t = getToken(0); System.out.println("OPERADOR_LOGICO_AND Sintax: "+t.image);
          break;
          }
        default:
          jj_la1[23] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        fator();
        auxTermo();
        break;
        }
      default:
        jj_la1[24] = jj_gen;

      }
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, SIMBOLO_PONTO_E_VIRGULA)));
        comando();
    }
}

  final public void fator() throws ParseException {Token t = new Token();
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IDENTIFICADOR:{
        variavel();
        break;
        }
      case NUMERO_INTEIRO:{
        jj_consume_token(NUMERO_INTEIRO);
t = getToken(0); System.out.println("NUMERO_INTEIRO Sintax: "+t.image);
        break;
        }
      case PARENTESES_ESQ:{
        jj_consume_token(PARENTESES_ESQ);
t = getToken(0); System.out.println("PARENTESES_ESQ Sintax: "+t.image);
        expressao();
        jj_consume_token(PARENTESES_DIR);
t = getToken(0); System.out.println("PARENTESES_DIR Sintax: "+t.image);
        break;
        }
      case OPERADOR_LOGICO_NOT:{
        jj_consume_token(OPERADOR_LOGICO_NOT);
t = getToken(0); System.out.println("OPERADOR_LOGICO_NOT Sintax: "+t.image);
        fator();
        break;
        }
      default:
        jj_la1[25] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, SIMBOLO_PONTO_E_VIRGULA)));
        comando();
    }
}

  final public void variavel() throws ParseException {Token t = new Token();
    try {
      jj_consume_token(IDENTIFICADOR);
t = getToken(0); System.out.println("IDENTIFICADOR Sintax: "+t.image);
      auxVariavel();
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, SIMBOLO_PONTO_E_VIRGULA)));
        comando();
    }
}

  final public void auxVariavel() throws ParseException {Token t = new Token();
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case OPERADOR_LOGICO_NOT:
      case OPERADOR_ARITMETICO_ADICAO:
      case OPERADOR_ARITMETICO_SUBTRACAO:
      case PARENTESES_ESQ:
      case IDENTIFICADOR:
      case NUMERO_INTEIRO:{
        expressao();
        break;
        }
      default:
        jj_la1[26] = jj_gen;

      }
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF)));
    }
}

  final public void relacao() throws ParseException {Token t = new Token();
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case OPERADOR_LOGICO_IGUAL_IGUAL:{
        jj_consume_token(OPERADOR_LOGICO_IGUAL_IGUAL);
t = getToken(0); System.out.println("OPERADOR_LOGICO_IGUAL_IGUAL Sintax: "+t.image);
        break;
        }
      case OPERADOR_LOGICO_DIFERENCA:{
        jj_consume_token(OPERADOR_LOGICO_DIFERENCA);
t = getToken(0); System.out.println("OPERADOR_LOGICO_DIFERENCA Sintax: "+t.image);
        break;
        }
      case OPERADOR_LOGICO_MENOR:{
        jj_consume_token(OPERADOR_LOGICO_MENOR);
t = getToken(0); System.out.println("OPERADOR_LOGICO_MENOR Sintax: "+t.image);
        break;
        }
      case OPERADOR_LOGICO_MENOR_IGUAL:{
        jj_consume_token(OPERADOR_LOGICO_MENOR_IGUAL);
t = getToken(0); System.out.println("OPERADOR_LOGICO_MENOR_IGUAL Sintax: "+t.image);
        break;
        }
      case OPERADOR_LOGICO_MAIOR_IGUAL:{
        jj_consume_token(OPERADOR_LOGICO_MAIOR_IGUAL);
t = getToken(0); System.out.println("OPERADOR_LOGICO_MAIOR_IGUAL Sintax: "+t.image);
        break;
        }
      case OPERADOR_LOGICO_MAIOR:{
        jj_consume_token(OPERADOR_LOGICO_MAIOR);
t = getToken(0); System.out.println("OPERADOR_LOGICO_MAIOR Sintax: "+t.image);
        break;
        }
      default:
        jj_la1[27] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (ParseException e) {
//armazenamentoErros(e.toString());
        error_skipto(e, new ArrayList<>(Arrays.asList(EOF, SIMBOLO_PONTO_E_VIRGULA)));
        comando();
    }
}

  /** Generated Token Manager. */
  public Scanner_1TokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[28];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x300000,0x100,0x0,0x300000,0x100,0x300000,0x300000,0x0,0x100,0x0,0x0,0x40000,0x300000,0x0,0x4a00,0x2000,0x80000000,0x0,0xfc00000,0x0,0x0,0x40000000,0x40000000,0x20000000,0x20000000,0x80000000,0x80000000,0xfc00000,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0x0,0x0,0x200,0x0,0x0,0x0,0x0,0x100,0x0,0x20,0x200,0x0,0x0,0x200,0x1800,0x0,0x2826,0x100,0x0,0x6,0x6,0x6,0x6,0x18,0x18,0x2820,0x2826,0x0,};
	}

  /** Constructor with InputStream. */
  public Scanner_1(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Scanner_1(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new Scanner_1TokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Scanner_1(java.io.Reader stream) {
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new Scanner_1TokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new Scanner_1TokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Scanner_1(Scanner_1TokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(Scanner_1TokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[55];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 28; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		   if ((jj_la1_1[i] & (1<<j)) != 0) {
			 la1tokens[32+j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 55; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  private boolean trace_enabled;

/** Trace enabled. */
  final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
