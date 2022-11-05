// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: src/LexicalAnalysis/LexicalAnalyzer.flex

package LexicalAnalysis;
import SintexAnalysis.Tokens;
import java_cup.runtime.Symbol;

// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
public class LexicalAnalyzer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\u10ff\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\2\0\1\1\22\0\1\1\7\0"+
    "\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
    "\12\13\1\14\1\15\1\16\1\17\1\20\2\0\32\21"+
    "\4\0\1\21\1\0\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\2\21\1\33\1\34\1\35"+
    "\1\36\1\37\1\21\1\40\1\41\1\42\1\43\1\44"+
    "\1\45\3\21\1\46\1\1\1\47\u0182\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[512];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\1\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\16\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\4\17\1\27\3\17\1\30\2\17\1\31\7\17\1\32"+
    "\1\22\1\33\2\17\1\34\1\17\1\35\1\17\1\36"+
    "\1\37\4\17\1\40\4\17\1\41\1\42\3\17\1\43"+
    "\1\44\1\45\2\17\1\46\1\17\1\47\2\17\1\50"+
    "\1\51\3\17\1\52\1\17\1\53\1\17\1\54";

  private static int [] zzUnpackAction() {
    int [] result = new int[101];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\50\0\50\0\50\0\50\0\50\0\50\0\50"+
    "\0\50\0\120\0\170\0\240\0\50\0\310\0\50\0\360"+
    "\0\u0118\0\u0140\0\u0168\0\u0190\0\u01b8\0\u01e0\0\u0208\0\u0230"+
    "\0\u0258\0\u0280\0\u02a8\0\u02d0\0\u02f8\0\u0320\0\u0348\0\50"+
    "\0\u0370\0\50\0\50\0\50\0\50\0\u0398\0\u03c0\0\u03e8"+
    "\0\u0410\0\u0118\0\u0438\0\u0460\0\u0488\0\u0118\0\u04b0\0\u04d8"+
    "\0\u0118\0\u0500\0\u0528\0\u0550\0\u0578\0\u05a0\0\u05c8\0\u05f0"+
    "\0\50\0\50\0\u0118\0\u0618\0\u0640\0\u0118\0\u0668\0\u0690"+
    "\0\u06b8\0\u0118\0\u0118\0\u06e0\0\u0708\0\u0730\0\u0758\0\u0118"+
    "\0\u0780\0\u07a8\0\u07d0\0\u07f8\0\u0118\0\50\0\u0820\0\u0848"+
    "\0\u0870\0\u0118\0\u0118\0\u0118\0\u0898\0\u08c0\0\u0118\0\u08e8"+
    "\0\u0118\0\u0910\0\u0938\0\u0118\0\u0118\0\u0960\0\u0988\0\u09b0"+
    "\0\u0118\0\u09d8\0\u0118\0\u0a00\0\u0118";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[101];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\2\1\12\1\13\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\1\23\1\21\1\24\1\25\1\26\2\21"+
    "\1\27\2\21\1\30\1\31\1\32\1\33\1\21\1\34"+
    "\1\21\1\35\1\36\1\37\1\40\62\0\1\41\50\0"+
    "\1\13\53\0\1\42\47\0\1\43\1\44\46\0\1\45"+
    "\43\0\1\21\5\0\25\21\15\0\1\21\5\0\14\21"+
    "\1\46\10\21\15\0\1\21\5\0\5\21\1\47\7\21"+
    "\1\50\7\21\15\0\1\21\5\0\11\21\1\51\3\21"+
    "\1\52\7\21\15\0\1\21\5\0\12\21\1\53\1\21"+
    "\1\54\10\21\15\0\1\21\5\0\1\21\1\55\23\21"+
    "\15\0\1\21\5\0\6\21\1\56\5\21\1\57\10\21"+
    "\15\0\1\21\5\0\15\21\1\60\7\21\15\0\1\21"+
    "\5\0\17\21\1\61\5\21\15\0\1\21\5\0\17\21"+
    "\1\62\5\21\15\0\1\21\5\0\5\21\1\63\17\21"+
    "\15\0\1\21\5\0\10\21\1\64\6\21\1\65\5\21"+
    "\15\0\1\21\5\0\1\21\1\66\23\21\15\0\1\21"+
    "\5\0\10\21\1\67\6\21\1\70\5\21\2\0\47\37"+
    "\1\71\2\41\1\72\45\41\13\0\1\21\5\0\4\21"+
    "\1\73\20\21\15\0\1\21\5\0\7\21\1\74\15\21"+
    "\15\0\1\21\5\0\15\21\1\75\7\21\15\0\1\21"+
    "\5\0\23\21\1\76\1\21\15\0\1\21\5\0\20\21"+
    "\1\77\4\21\15\0\1\21\5\0\4\21\1\100\20\21"+
    "\15\0\1\21\5\0\12\21\1\101\12\21\15\0\1\21"+
    "\5\0\21\21\1\102\3\21\15\0\1\21\5\0\21\21"+
    "\1\103\3\21\15\0\1\21\5\0\15\21\1\104\7\21"+
    "\15\0\1\21\5\0\1\21\1\105\23\21\15\0\1\21"+
    "\5\0\5\21\1\106\17\21\15\0\1\21\5\0\22\21"+
    "\1\107\2\21\15\0\1\21\5\0\17\21\1\110\5\21"+
    "\15\0\1\21\5\0\11\21\1\111\13\21\15\0\1\21"+
    "\5\0\11\21\1\112\13\21\15\0\1\21\5\0\11\21"+
    "\1\113\13\21\15\0\1\21\5\0\12\21\1\114\12\21"+
    "\15\0\1\21\5\0\5\21\1\115\17\21\13\0\1\116"+
    "\1\0\1\21\5\0\25\21\15\0\1\21\5\0\20\21"+
    "\1\117\4\21\15\0\1\21\5\0\3\21\1\120\3\21"+
    "\1\121\15\21\15\0\1\21\5\0\4\21\1\122\20\21"+
    "\15\0\1\21\5\0\14\21\1\123\10\21\15\0\1\21"+
    "\5\0\5\21\1\124\17\21\15\0\1\21\5\0\12\21"+
    "\1\125\12\21\15\0\1\21\5\0\21\21\1\126\3\21"+
    "\15\0\1\21\5\0\14\21\1\127\10\21\15\0\1\21"+
    "\5\0\5\21\1\130\17\21\15\0\1\21\5\0\5\21"+
    "\1\131\17\21\15\0\1\21\5\0\5\21\1\132\17\21"+
    "\15\0\1\21\5\0\17\21\1\133\5\21\15\0\1\21"+
    "\5\0\5\21\1\134\17\21\15\0\1\21\5\0\5\21"+
    "\1\135\17\21\15\0\1\21\5\0\1\21\1\136\23\21"+
    "\15\0\1\21\5\0\4\21\1\137\20\21\15\0\1\21"+
    "\5\0\1\21\1\140\23\21\15\0\1\21\5\0\14\21"+
    "\1\141\10\21\15\0\1\21\5\0\22\21\1\142\2\21"+
    "\15\0\1\21\5\0\13\21\1\143\11\21\15\0\1\21"+
    "\5\0\17\21\1\144\5\21\15\0\1\21\5\0\5\21"+
    "\1\145\17\21\2\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2600];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\10\11\3\1\1\11\1\1\1\11\20\1\1\11"+
    "\1\1\4\11\23\1\2\11\23\1\1\11\27\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[101];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
    public String token;
    public String lexema;
    public String erro;
    public int line;
    public int column;
    public int endColumn;


    public long getOffset(){
        return this.yychar;
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public LexicalAnalyzer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          {     return new Symbol(Tokens.EOF, "Fim do arquivo");
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { token=""; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; erro="[ERRO_SIMBOLO_INVALIDO] Simbolo Inválido"; return new Symbol(Tokens.ERRO_SIMBOLO_INVALIDO, yytext()); /*System.out.println(yytext()+" -> ERRO_SIMBOLO_INVALIDO");*/
            }
            // fall through
          case 45: break;
          case 2:
            { 
            }
            // fall through
          case 46: break;
          case 3:
            { token="PARENTESES_ESQ"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.PARENTESES_ESQ, yytext()); /*System.out.println(yytext()+" -> PARENTESES_ESQ");*/
            }
            // fall through
          case 47: break;
          case 4:
            { token="PARENTESES_DIR"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.PARENTESES_DIR, yytext()); /*System.out.println(yytext()+" -> PARENTESES_DIR");*/
            }
            // fall through
          case 48: break;
          case 5:
            { token="OPERADOR_ARITMETICO_MULTIPLICACAO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_ARITMETICO_MULTIPLICACAO, yytext()); /*System.out.println(yytext()+" -> OPERADOR_ARITMETICO_MULTIPLICACAO");*/
            }
            // fall through
          case 49: break;
          case 6:
            { token="OPERADOR_ARITMETICO_ADICAO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_ARITMETICO_ADICAO, yytext()); /*System.out.println(yytext()+" -> OPERADOR_ARITMETICO_ADICAO");*/
            }
            // fall through
          case 50: break;
          case 7:
            { token="SIMBOLO_VIRGULA"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.SIMBOLO_VIRGULA, yytext()); /*System.out.println(yytext()+" -> SIMBOLO_VIRGULA");*/
            }
            // fall through
          case 51: break;
          case 8:
            { token="OPERADOR_ARITMETICO_SUBTRACAO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_ARITMETICO_SUBTRACAO, yytext()); /*System.out.println(yytext()+" -> OPERADOR_ARITMETICO_SUBTRACAO");*/
            }
            // fall through
          case 52: break;
          case 9:
            { if(yylength() <= 8){
                                                    token="NUMERO_INTEIRO";
                                                    lexema=yytext();
                                                    line=yyline;
                                                    column=yycolumn;
                                                    endColumn=column+yylength()-1;
                                                    return new Symbol(Tokens.NUMERO_INTEIRO, yytext());
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
            // fall through
          case 53: break;
          case 10:
            { token="SIMBOLO_DOIS_PONTOS"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.SIMBOLO_DOIS_PONTOS, yytext()); /*System.out.println(yytext()+" -> SIMBOLO_DOIS_PONTOS");*/
            }
            // fall through
          case 54: break;
          case 11:
            { token="SIMBOLO_PONTO_E_VIRGULA"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.SIMBOLO_PONTO_E_VIRGULA, yytext()); /*System.out.println(yytext()+" -> SIMBOLO_PONTO_E_VIRGULA");*/
            }
            // fall through
          case 55: break;
          case 12:
            { token="OPERADOR_LOGICO_MENOR"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_LOGICO_MENOR, yytext()); /*System.out.println(yytext()+" -> OPERADOR_LOGICO_MENOR");*/
            }
            // fall through
          case 56: break;
          case 13:
            { token="OPERADOR_LOGICO_IGUALDADE"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_LOGICO_IGUALDADE, yytext()); /*System.out.println(yytext()+" -> OPERADOR_LOGICO_IGUALDADE");*/
            }
            // fall through
          case 57: break;
          case 14:
            { token="OPERADOR_LOGICO_MAIOR"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_LOGICO_MAIOR, yytext()); /*System.out.println(yytext()+" -> OPERADOR_LOGICO_MAIOR");*/
            }
            // fall through
          case 58: break;
          case 15:
            { if(yylength() <= 15){
                                                    token="IDENTIFICADOR";
                                                    lexema=yytext();
                                                    line=yyline;
                                                    column=yycolumn;
                                                    endColumn=column+yylength()-1;
                                                    return new Symbol(Tokens.IDENTIFICADOR, yytext());
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
            // fall through
          case 59: break;
          case 16:
            { token=""; line=yyline; column=yycolumn; endColumn=column+yylength()-1; lexema=yytext(); erro="[ERRO_COMENTARIO_MULT_LINHAS_SEM_FECHAR] O bloco de comentário não foi fechado"; return new Symbol(Tokens.ERRO_COMENTARIO_MULT_LINHAS_SEM_FECHAR, yytext()); /*System.out.println(yytext()+" -> ERRO_COMENTARIO_MULT_LINHAS_SEM_FECHAR");*/
            }
            // fall through
          case 60: break;
          case 17:
            { token=""; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; erro="[ERRO_COMENTARIO_MULT_LINHAS_SEM_ABRIR] O bloco de comentário não foi aberto"; return new Symbol(Tokens.ERRO_COMENTARIO_MULT_LINHAS_SEM_ABRIR, yytext()); /*System.out.println(yytext()+" -> ERRO_COMENTARIO_MULT_LINHAS_SEM_ABRIR");*/
            }
            // fall through
          case 61: break;
          case 18:
            { token="COMENTARIO_UMA_LINHA"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.COMENTARIO_UMA_LINHA, yytext()); /*System.out.println(yytext()+" -> COMENTARIO_UMA_LINHA");*/
            }
            // fall through
          case 62: break;
          case 19:
            { token="OPERADOR_ARITMETICO_ATRIBUICAO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_ARITMETICO_ATRIBUICAO, yytext()); /*System.out.println(yytext()+" -> OPERADOR_ARITMETICO_ATRIBUICAO");*/
            }
            // fall through
          case 63: break;
          case 20:
            { token="OPERADOR_LOGICO_MENOR_IGUAL"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_LOGICO_MENOR_IGUAL, yytext()); /*System.out.println(yytext()+" -> OPERADOR_LOGICO_MENOR_IGUAL");*/
            }
            // fall through
          case 64: break;
          case 21:
            { token="OPERADOR_LOGICO_DIFERENCA"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_LOGICO_DIFERENCA, yytext()); /*System.out.println(yytext()+" -> OPERADOR_LOGICO_DIFERENCA");*/
            }
            // fall through
          case 65: break;
          case 22:
            { token="OPERADOR_LOGICO_MAIOR_IGUAL"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_LOGICO_MAIOR_IGUAL, yytext()); /*System.out.println(yytext()+" -> OPERADOR_LOGICO_MAIOR_IGUAL");*/
            }
            // fall through
          case 66: break;
          case 23:
            { token="RSV_DO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_DO, yytext()); /*System.out.println(yytext()+" -> RSV_DO");*/
            }
            // fall through
          case 67: break;
          case 24:
            { token="RSV_IF"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_IF, yytext()); /*System.out.println(yytext()+" -> RSV_IF");*/
            }
            // fall through
          case 68: break;
          case 25:
            { token="OPERADOR_LOGICO_OR"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_LOGICO_OR, yytext()); /*System.out.println(yytext()+" -> OPERADOR_LOGICO_OR");*/
            }
            // fall through
          case 69: break;
          case 26:
            { token="COMENTARIO_MULT_LINHAS"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.COMENTARIO_MULT_LINHAS, yytext()); /*System.out.println(yytext()+" -> COMENTARIO_MULT_LINHAS");*/
            }
            // fall through
          case 70: break;
          case 27:
            { token="OPERADOR_LOGICO_AND"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_LOGICO_AND, yytext()); /*System.out.println(yytext()+" -> OPERADOR_LOGICO_AND");*/
            }
            // fall through
          case 71: break;
          case 28:
            { token="OPERADOR_ARITMETICO_DIVISAO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_ARITMETICO_DIVISAO, yytext()); /*System.out.println(yytext()+" -> OPERADOR_ARITMETICO_DIVISAO");*/
            }
            // fall through
          case 72: break;
          case 29:
            { token="RSV_END"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_END, yytext()); /*System.out.println(yytext()+" -> RSV_END");*/
            }
            // fall through
          case 73: break;
          case 30:
            { token="TIPO_INT"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.TIPO_INT, yytext()); /*System.out.println(yytext()+" -> TIPO_INT");*/
            }
            // fall through
          case 74: break;
          case 31:
            { token="OPERADOR_LOGICO_NOT"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.OPERADOR_LOGICO_NOT, yytext()); /*System.out.println(yytext()+" -> OPERADOR_LOGICO_NOT");*/
            }
            // fall through
          case 75: break;
          case 32:
            { token="RSV_VAR"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_DO, yytext()); /*System.out.println(yytext()+" -> RSV_VAR");*/
            }
            // fall through
          case 76: break;
          case 33:
            { token="RSV_ELSE"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_ELSE, yytext()); /*System.out.println(yytext()+" -> RSV_ELSE");*/
            }
            // fall through
          case 77: break;
          case 34:
            { token="SIMBOLO_TERMINACAO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.SIMBOLO_TERMINACAO, yytext()); /*System.out.println(yytext()+" -> SIMBOLO_TERMINACAO");*/
            }
            // fall through
          case 78: break;
          case 35:
            { token="RSV_READ"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_READ, yytext()); /*System.out.println(yytext()+" -> RSV_READ");*/
            }
            // fall through
          case 79: break;
          case 36:
            { token="RSV_THEN"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_THEN, yytext()); /*System.out.println(yytext()+" -> RSV_THEN");*/
            }
            // fall through
          case 80: break;
          case 37:
            { token="RSV_TRUE"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_TRUE, yytext()); /*System.out.println(yytext()+" -> RSV_TRUE");*/
            }
            // fall through
          case 81: break;
          case 38:
            { token="RSV_BEGIN"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_BEGIN, yytext()); /*System.out.println(yytext()+" -> RSV_BEGIN");*/
            }
            // fall through
          case 82: break;
          case 39:
            { token="RSV_FALSE"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_FALSE, yytext()); /*System.out.println(yytext()+" -> RSV_FALSE");*/
            }
            // fall through
          case 83: break;
          case 40:
            { token="RSV_WHILE"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_WHILE, yytext()); /*System.out.println(yytext()+" -> RSV_WHILE");*/
            }
            // fall through
          case 84: break;
          case 41:
            { token="RSV_WRITE"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_WRITE, yytext()); /*System.out.println(yytext()+" -> RSV_WRITE");*/
            }
            // fall through
          case 85: break;
          case 42:
            { token="TIPO_BOOLEAN"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.TIPO_BOOLEAN, yytext()); /*System.out.println(yytext()+" -> TIPO_BOOLEAN");*/
            }
            // fall through
          case 86: break;
          case 43:
            { token="RSV_PROGRAMA"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_PROGRAMA, yytext()); /*System.out.println(yytext()+" -> RSV_PROGRAMA");*/
            }
            // fall through
          case 87: break;
          case 44:
            { token="RSV_PROCEDIMENTO"; lexema=yytext(); line=yyline; column=yycolumn; endColumn=column+yylength()-1; return new Symbol(Tokens.RSV_PROCEDIMENTO, yytext()); /*System.out.println(yytext()+" -> RSV_PROCEDIMENTO");*/
            }
            // fall through
          case 88: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
