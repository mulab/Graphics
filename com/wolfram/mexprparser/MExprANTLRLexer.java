// $ANTLR 2.7.4: "exprrules.g" -> "MExprANTLRLexer.java"$
 
	
	package com.wolfram.mexprparser; 

	import com.wolfram.mexpr.*;
	import com.wolfram.mexpr.visitors.*;
	import java.util.Hashtable;
	import java.io.IOException;
	import antlr.ANTLRStringBuffer;
	import java.util.ArrayList;
    import java.util.Hashtable;
    import java.util.List;

import java.io.InputStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.ANTLRException;
import java.io.Reader;
import java.util.Hashtable;
import antlr.CharScanner;
import antlr.InputBuffer;
import antlr.ByteBuffer;
import antlr.CharBuffer;
import antlr.Token;
import antlr.CommonToken;
import antlr.RecognitionException;
import antlr.NoViableAltForCharException;
import antlr.MismatchedCharException;
import antlr.TokenStream;
import antlr.ANTLRHashString;
import antlr.LexerSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.SemanticException;

public class MExprANTLRLexer extends antlr.CharScanner implements MExprANTLRParserTokenTypes, TokenStream
 {

	
/*
 Reading is done in fill of CharBuffer class
*/
	/*
		public char LA( int i) throws CharStreamException
	{
		return super.LA( i);
	}
	*/

	Reader inputReader;
	boolean charReady;
	char nextChar;
	
	boolean peekedCharReady;
	char peekedChar;
	
	boolean bufferCharReady;
	char bufferChar;
	
	ANTLRStringBuffer text;
	int streamPosition = -1;
	int charPosition = -1;
	int charStart = -1;
	
	boolean typesetParse = false;
	
	public void setLexer( Reader inputReader_)
	{
		setLexer( inputReader_, false);
	}
	
	public void setLexer( Reader inputReader_, boolean typesetMode)
	{
	    charReady = false;
	    peekedCharReady = false;
	    bufferCharReady = false;
		inputReader = inputReader_;
		text = new ANTLRStringBuffer();
		typesetParse = typesetMode;
	}
	
	public void setCharPosition( int i) {
		charPosition = i-1;
	}
	
	
	public void uponEOF() throws TokenStreamException, CharStreamException {
		consume();
    }
	
	
	public char LA( int i) throws CharStreamException
	{
	    if ( charReady)
	        return nextChar;

	    charReady = true;
	    streamPosition++;
		if ( peekedCharReady) {
			nextChar = peekedChar;
			peekedCharReady = false;
			return nextChar;
		}

		try {
			if ( bufferCharReady) {
				nextChar = bufferChar;
				bufferCharReady = false;
			}
			else {
				nextChar = (char) inputReader.read();
			}
			if ( nextChar == '\\') {
				char peekedChar2 = (char) inputReader.read();
				if ( peekedChar2 == '\n' || peekedChar2 == '\r') {
					streamPosition++;
					charReady = false;
					charPosition += 2;  // We've lost two chars
					if ( peekedChar2 == '\r') {
						// If we read \r then read again to see if 
						// the next is \n.  If it is then skip this
						// as well. If it is not then store this 
						// character.  Perhaps this should only be 
						// done if we are in some Windows compatibility
						// mode
						peekedChar2 = (char) inputReader.read();
						if ( peekedChar2 == '\n') {
							charPosition++;	
						}
						else {
							peekedCharReady = true;
							peekedChar = peekedChar2;			
						}
					}
					return LA(1);
				}
				else {
					peekedCharReady = true;
					peekedChar = peekedChar2;			
				}
			}
		}
		catch ( IOException io) {
			throw new CharStreamIOException( io);
		}
		
	    return nextChar;
	}
	
/*
 Used in number formatting, returns the next char. 
*/
	public char peekChar() throws CharStreamException
	{
	    if ( peekedCharReady)
	        return peekedChar;
		
		LA(1);
		
		peekedCharReady = true;
		try {
			if ( bufferCharReady) {
				peekedChar = bufferChar;
				bufferCharReady = false;
			}
			else {
		        peekedChar = (char) inputReader.read();
			}
	        
			if ( peekedChar == '\\') {
				char tmpChar = (char) inputReader.read();
				if ( tmpChar == '\n' || tmpChar == '\r') {
					streamPosition += 2;
					peekedCharReady = false;
					charPosition += 2;  // We've lost two chars
					
					if ( tmpChar == '\r') {
						// If we read \r then read again to see if 
						// the next is \n.  If it is then skip this
						// as well. If it is not then store this 
						// character.  Perhaps this should only be 
						// done if we are in some Windows compatibility
						// mode
						tmpChar = (char) inputReader.read();
						if ( tmpChar == '\n') {
							charPosition++;	
						}
						else {
							bufferCharReady = true;
							bufferChar = tmpChar;			
						}
					}				
					return peekChar( );
				}
				else {
					bufferCharReady = true;
					bufferChar = tmpChar;			
				}
			}
		}
		catch ( IOException io) {
			throw new CharStreamIOException( io);
		}
	
	    return peekedChar;
	}
	
	public void consume( char c) throws CharStreamException 
	{ 	
		charPosition++;
        text.append( c);
        charReady = false;
     }
	
	public void consume() throws CharStreamException 
	{ 	
        consume( LA(1));
     }
	
	
	void skip()
	{
		charPosition++;
		charReady = false;
	}
	
	
	public void match(char c) throws MismatchedCharException, CharStreamException 
	{
       if (LA(1) != c) {
            throw new MismatchedCharException(LA(1), c, false, this);
        }
        consume(c);
	}
	
	public void matchNot(char c) throws MismatchedCharException, CharStreamException
	{
       if (LA(1) == c) {
            throw new MismatchedCharException(LA(1), c, true, this);
        }
        consume();
	}
	
	public void matchRange(char c1, char c2) throws MismatchedCharException, CharStreamException 
	{
		char c = LA(1);
       if (c < c1 || c > c2) throw new MismatchedCharException(LA(1), c1, c2, false, this);
        consume(c);
	}
	
	public void resetText() 
	{
        text.setLength(0);
       	charStart = charPosition;
	}
	
	
	public Token makeToken( int type)
	{
		MExprToken token = new MExprToken();
		token.setType( type);
		
		// TODO: this isn't right for tokens of length 1, as this effectively
		// makes charStart > charEnd
		token.charStart = charStart+1;
		
		token.charEnd = charPosition;
		return token;
	}


/*
 Comes here when we have found and consumed (*, we 
 should parse to the end of the comment.
*/
	void matchComment()
		throws RecognitionException, CharStreamException, TokenStreamException
	{
		int depth = 1;
		int mode = 0;

/*
 mode 0 last char was ordinary
 mode 1 last char was *
 mode 2 last char was (
*/	
		do {
			switch( LA(1)) {
				case '*':
					if ( mode == 2) {
						mode = 0;
						depth++;
					}
					else {
						mode = 1;	
					}
					consume();
					break;
				
				case '(':
					mode = 2;	
					consume();
					break;

				case ')':
					if ( mode == 1) {
						depth--;
					}
					mode = 0;
					consume();
					break;
				
				case '\n':
					mode = 0;
				  	newline();
				  	consume();
				  	break;
				  	
				default:
					mode = 0;
					matchNot(EOF_CHAR);
			}
			
			
		}
		while( depth > 0) ;
		

	}

/*
 Comes here when we have found and consumed \!. 
*/	
	void matchActiveTypeset( boolean _createToken)
		throws RecognitionException, CharStreamException, TokenStreamException
	{
		match( '\\');
		match( '(');
		matchTypeset( _createToken);
	}
	
	
/*
 Comes here when we have found and consumed \(, we 
 should parse to the end of the typeset expr, ie we find the 
 matching \). If we find a string, then we should just parse this 
 as a string, we might also come across \* which should just 
 be skipped over.
*/
	void matchTypeset( boolean _createToken)
		throws RecognitionException, CharStreamException, TokenStreamException
	{
		int depth = 1;
		int mode = 0;

/*
 mode 0 last char was ordinary
 mode 1 last char was \
*/	
		do {
			switch( LA(1)) {
				case '\\':
					if ( mode == 1) {
						mode = 0;
					}
					else {
						mode = 1;	
					}
					consume();
					break;
				
				case '(':
					if ( mode == 1) {
						depth++;
					}
					mode = 0;
					consume();
					break;

				case ')':
					if ( mode == 1) {
						depth--;
					}
					mode = 0;
					consume();
					break;
				
				case '\"':
					if ( mode == 1) {
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
					}
					match( "\"");
					matchString( false);
					break;
	
				case ' ':
				case '\r':
				case '\t':			
					if ( mode == 1)
						consume();
					else
						skip();
					mode = 0;
					break;
				
				case 't':
				case 'n':
				case 'r':
				case '[':
				case '*':
				case '`':
				case '^':
				case '/':
				case '&':
				case '+':
				case '%':
				case '_':
				case '@':				
					mode = 0;
					consume();
					break;				
				
				case '\n':
					if ( mode == 1)
						consume();
					else
						skip();
					mode = 0;
				  	newline();
				  	break;
				  	
				default:
					if ( mode == 1) {
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
					}
					matchNot(EOF_CHAR);
			}
				
		}
		while( depth > 0) ;
	}

/*
 Comes here when we have found and consumed <<, we 
 should parse to the end of the file input.
*/
	void matchGet( boolean _createToken)
		throws RecognitionException, CharStreamException, TokenStreamException
	{
		boolean loop = true;
		
		do {
			switch( LA(1)) {
				case ' ':
				case '\r':
				case '\n':
				case '\t':
					consume();
					break;
				
				default:
					loop = false;				
			}
		}
		while( loop);
		
		if ( LA(1) == '\"') {
			match( "\"");
			matchString( false);
		}
		else {
			loop = true;
			do {
				switch( LA(1)) {
					case '\"':
					case ')':
					case ']':
					case '}':
					case '\n':
					case '\r':
					case ';':
					case ',':
					case EOF_CHAR:
						loop = false;
						break;
					
					default:
						consume();
				}
			}
			while( loop);
		}
	}


/*
 Comes here when we have found and consumed ", we 
 should scan to the end of the string token.
*/
	void matchString( boolean _createToken)
		throws RecognitionException, CharStreamException, TokenStreamException
	{
		int mode = 0;
		
		while ( true) {
			switch( LA(1)) {
				case '\\':
					consume();
					if ( mode == 1) {
						mode = 0;
					}
					else {
						mode = 1;	
					}
					break;
		
				case '\"':
					consume();
					if ( mode == 0)
						return;
					mode = 0;
					break;
				
				case '\n':
					newline();
				default:
					matchNot(EOF_CHAR);
					mode = 0;
					break;
			}
		}
	}

	void createErrorToken() 
	{
		System.out.println( "fff");	
	}


public MExprANTLRLexer(InputStream in) {
	this(new ByteBuffer(in));
}
public MExprANTLRLexer(Reader in) {
	this(new CharBuffer(in));
}
public MExprANTLRLexer(InputBuffer ib) {
	this(new LexerSharedInputState(ib));
}
public MExprANTLRLexer(LexerSharedInputState state) {
	super(state);
	caseSensitiveLiterals = true;
	setCaseSensitive(true);
	literals = new Hashtable();
}

public Token nextToken() throws TokenStreamException {
	Token theRetToken=null;
tryAgain:
	for (;;) {
		Token _token = null;
		int _ttype = Token.INVALID_TYPE;
		resetText();
		try {   // for char stream error handling
			try {   // for lexical error handling
				switch ( LA(1)) {
				case ')':
				{
					mRPAREN(true);
					theRetToken=_returnToken;
					break;
				}
				case '{':
				{
					mLBRACE(true);
					theRetToken=_returnToken;
					break;
				}
				case '}':
				{
					mRBRACE(true);
					theRetToken=_returnToken;
					break;
				}
				case ',':
				{
					mCOMMA(true);
					theRetToken=_returnToken;
					break;
				}
				case '[':
				{
					mLBRACKET(true);
					theRetToken=_returnToken;
					break;
				}
				case ']':
				{
					mRBRACKET(true);
					theRetToken=_returnToken;
					break;
				}
				case '?':
				{
					mQUESTION(true);
					theRetToken=_returnToken;
					break;
				}
				case '\'':
				{
					mDERIVATIVE(true);
					theRetToken=_returnToken;
					break;
				}
				case ';':
				{
					mSEMI(true);
					theRetToken=_returnToken;
					break;
				}
				case '/':
				{
					mSLASH_START(true);
					theRetToken=_returnToken;
					break;
				}
				case '=':
				{
					mEQUAL_START(true);
					theRetToken=_returnToken;
					break;
				}
				case '@':
				{
					mAT_START(true);
					theRetToken=_returnToken;
					break;
				}
				case '+':
				{
					mPLUS_START(true);
					theRetToken=_returnToken;
					break;
				}
				case '-':
				{
					mMINUS_START(true);
					theRetToken=_returnToken;
					break;
				}
				case '!':
				{
					mEXCLAM_START(true);
					theRetToken=_returnToken;
					break;
				}
				case ':':
				{
					mCOLON_START(true);
					theRetToken=_returnToken;
					break;
				}
				case '^':
				{
					mCARET_START(true);
					theRetToken=_returnToken;
					break;
				}
				case '>':
				{
					mGREATER_START(true);
					theRetToken=_returnToken;
					break;
				}
				case '<':
				{
					mLESS_START(true);
					theRetToken=_returnToken;
					break;
				}
				case '&':
				{
					mAMP_START(true);
					theRetToken=_returnToken;
					break;
				}
				case '|':
				{
					mBAR_START(true);
					theRetToken=_returnToken;
					break;
				}
				case '~':
				{
					mTILDE_START(true);
					theRetToken=_returnToken;
					break;
				}
				case '*':
				{
					mSTAR_START(true);
					theRetToken=_returnToken;
					break;
				}
				case '\t':  case '\n':  case '\r':  case ' ':
				{
					mWHITESPACE(true);
					theRetToken=_returnToken;
					break;
				}
				case '"':
				{
					mSTRING(true);
					theRetToken=_returnToken;
					break;
				}
				case '(':
				{
					mCOMMENT(true);
					theRetToken=_returnToken;
					break;
				}
				case '#':
				{
					mSLOT(true);
					theRetToken=_returnToken;
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					mINT_REAL_DOT(true);
					theRetToken=_returnToken;
					break;
				}
				case '.':
				{
					mDOT_START(true);
					theRetToken=_returnToken;
					break;
				}
				case '_':
				{
					mBLANK(true);
					theRetToken=_returnToken;
					break;
				}
				case '%':
				{
					mPERCENT(true);
					theRetToken=_returnToken;
					break;
				}
				case '$':  case 'A':  case 'B':  case 'C':
				case 'D':  case 'E':  case 'F':  case 'G':
				case 'H':  case 'I':  case 'J':  case 'K':
				case 'L':  case 'M':  case 'N':  case 'O':
				case 'P':  case 'Q':  case 'R':  case 'S':
				case 'T':  case 'U':  case 'V':  case 'W':
				case 'X':  case 'Y':  case 'Z':  case '`':
				case 'a':  case 'b':  case 'c':  case 'd':
				case 'e':  case 'f':  case 'g':  case 'h':
				case 'i':  case 'j':  case 'k':  case 'l':
				case 'm':  case 'n':  case 'o':  case 'p':
				case 'q':  case 'r':  case 's':  case 't':
				case 'u':  case 'v':  case 'w':  case 'x':
				case 'y':  case 'z':
				{
					mID(true);
					theRetToken=_returnToken;
					break;
				}
				case '\\':
				{
					mBACKSLASH_START(true);
					theRetToken=_returnToken;
					break;
				}
				default:
					if (((LA(1) >= '\u0080' && LA(1) <= '\ufffe'))) {
						mIDUNICODESTART(true);
						theRetToken=_returnToken;
					}
				else {
					if (LA(1)==EOF_CHAR) {uponEOF(); _returnToken = makeToken(Token.EOF_TYPE);}
				else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				}
				if ( _returnToken==null ) continue tryAgain; // found SKIP token
				_ttype = _returnToken.getType();
				_returnToken.setType(_ttype);
				return _returnToken;
			}
			catch (RecognitionException e) {
				throw new TokenStreamRecognitionException(e);
			}
		}
		catch (CharStreamException cse) {
			if ( cse instanceof CharStreamIOException ) {
				throw new TokenStreamIOException(((CharStreamIOException)cse).io);
			}
			else {
				throw new TokenStreamException(cse.getMessage());
			}
		}
	}
}

	public final void mRPAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RPAREN;
		int _saveIndex;
		
		match(')');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLBRACE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LBRACE;
		int _saveIndex;
		
		match('{');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mRBRACE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RBRACE;
		int _saveIndex;
		
		match('}');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOMMA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMMA;
		int _saveIndex;
		
		match(',');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLBRACKET(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LBRACKET;
		int _saveIndex;
		
		match('[');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mRBRACKET(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RBRACKET;
		int _saveIndex;
		
		match(']');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mQUESTION(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = QUESTION;
		int _saveIndex;
		
		match('?');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDERIVATIVE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DERIVATIVE;
		int _saveIndex;
		
		match('\'');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mDERIVATIVEINFIX(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DERIVATIVEINFIX;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mPLUSPLUSINFIX(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PLUSPLUSINFIX;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mMINUSMINUSINFIX(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = MINUSMINUSINFIX;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSEMI(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SEMI;
		int _saveIndex;
		
		match(';');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mNULLID(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NULLID;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSLASH_START(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SLASH_START;
		int _saveIndex;
		
		match('/');
		_ttype =  SLASH;
		{
		switch ( LA(1)) {
		case ';':
		{
			match(';');
			_ttype =  CONDITION;
			break;
		}
		case ':':
		{
			match(':');
			_ttype =  TAGSET;
			break;
		}
		case '@':
		{
			match('@');
			_ttype =  MAP;
			break;
		}
		case '.':
		{
			match('.');
			_ttype =  REPLACEALL;
			break;
		}
		case '=':
		{
			match('=');
			_ttype =  DIVIDEBY;
			break;
		}
		case '/':
		{
			match('/');
			_ttype =  SLASHFUN;
			{
			switch ( LA(1)) {
			case '.':
			{
				match('.');
				_ttype =  REPLACEREPEATED;
				break;
			}
			case '@':
			{
				match('@');
				_ttype =  MAPALL;
				break;
			}
			default:
				{
				}
			}
			}
			break;
		}
		default:
			{
			}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mCONDITION(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CONDITION;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mTAGSET(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TAGSET;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mMAP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = MAP;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mMAPALL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = MAPALL;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mREPLACEALL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = REPLACEALL;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mREPLACEREPEATED(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = REPLACEREPEATED;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mDIVIDEBY(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DIVIDEBY;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mSLASH(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SLASH;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mEQUAL_START(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EQUAL_START;
		int _saveIndex;
		
		match('=');
		_ttype =  SET;
		{
		switch ( LA(1)) {
		case '!':
		{
			match('!');
			
							if (LA(1) == '=') {
								match('=');_ttype =  UNSAMEQ;
							} 
							else {
								_ttype =  EQUALEXCLAM;
							}
						
			break;
		}
		case '=':
		{
			match('=');
			_ttype =  EQUAL;
			{
			if ((LA(1)=='=')) {
				match('=');
				_ttype =  SAMEQ;
			}
			else {
			}
			
			}
			break;
		}
		default:
			{
			}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mEQUAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EQUAL;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mSAMEQ(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SAMEQ;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mUNSAMEQ(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = UNSAMEQ;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mEQUALEXCLAM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EQUALEXCLAM;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mUNSET(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = UNSET;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mSET(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SET;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mAT_START(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = AT_START;
		int _saveIndex;
		
		match('@');
		_ttype =  ATFUN;
		{
		if ((LA(1)=='@')) {
			match('@');
			_ttype =  APPLY;
			{
			if ((LA(1)=='@')) {
				match('@');
				_ttype =  APPLYONE;
			}
			else {
			}
			
			}
		}
		else {
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPLUS_START(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PLUS_START;
		int _saveIndex;
		
		match('+');
		_ttype =  PLUS;
		{
		switch ( LA(1)) {
		case '+':
		{
			match('+');
			_ttype =  PLUSPLUS;
			break;
		}
		case '=':
		{
			match('=');
			_ttype =  ADDTO;
			break;
		}
		default:
			{
			}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mMINUS_START(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = MINUS_START;
		int _saveIndex;
		
		match('-');
		_ttype =  MINUS;
		{
		switch ( LA(1)) {
		case '-':
		{
			match('-');
			_ttype =  MINUSMINUS;
			break;
		}
		case '=':
		{
			match('=');
			_ttype =  SUBTRACTFROM;
			break;
		}
		case '>':
		{
			match('>');
			_ttype =  RULE;
			break;
		}
		default:
			{
			}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mEXCLAM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EXCLAM;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mEXCLAM2(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EXCLAM2;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mEXCLAM_START(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EXCLAM_START;
		int _saveIndex;
		
		match('!');
		_ttype =  EXCLAM;
		{
		switch ( LA(1)) {
		case '!':
		{
			match('!');
			_ttype =  EXCLAM2;
			break;
		}
		case '=':
		{
			match('=');
			_ttype =  UNEQUAL;
			break;
		}
		default:
			{
			}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mNOTINFIX(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NOTINFIX;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mNOTNOTINFIX(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NOTNOTINFIX;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOLON_START(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COLON_START;
		int _saveIndex;
		
		match(':');
		_ttype =  COLON;
		{
		switch ( LA(1)) {
		case ':':
		{
			match(':');
			_ttype =  MESSAGENAME;
			break;
		}
		case '>':
		{
			match('>');
			_ttype =  RULE;
			break;
		}
		case '=':
		{
			match('=');
			_ttype =  SETDELAYED;
			break;
		}
		default:
			{
			}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCARET_START(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CARET_START;
		int _saveIndex;
		
		match('^');
		_ttype =  CARET;
		{
		switch ( LA(1)) {
		case '=':
		{
			match('=');
			_ttype =  UPSET;
			break;
		}
		case ':':
		{
			match(':');
			match('=');
			_ttype =  UPSETDELAYED;
			break;
		}
		default:
			{
			}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mGREATER_START(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = GREATER_START;
		int _saveIndex;
		
		match('>');
		_ttype =  GREATER;
		{
		switch ( LA(1)) {
		case '>':
		{
			match('>');
			{
			if ((LA(1)=='>')) {
				match('>');
			}
			else {
			}
			
			}
			_ttype =  PUT; matchGet( true);
			break;
		}
		case '=':
		{
			match('=');
			_ttype =  GREATEREQUAL;
			break;
		}
		default:
			{
			}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mGET(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = GET;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mPUT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PUT;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLESS_START(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LESS_START;
		int _saveIndex;
		
		match('<');
		_ttype =  LESS;
		{
		switch ( LA(1)) {
		case '<':
		{
			match('<');
			_ttype =  GET; matchGet( true);
			break;
		}
		case '>':
		{
			match('>');
			_ttype =  STRINGJOIN;
			break;
		}
		case '=':
		{
			match('=');
			_ttype =  LESSEQUAL;
			break;
		}
		default:
			{
			}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mAMP_START(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = AMP_START;
		int _saveIndex;
		
		match('&');
		_ttype =  AMP;
		{
		if ((LA(1)=='&')) {
			match('&');
			_ttype =  AND;
		}
		else {
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mAMP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = AMP;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mAMPINFIX(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = AMPINFIX;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mPOSTFIXID(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = POSTFIXID;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mNONCOMMUTE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NONCOMMUTE;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBAR_START(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BAR_START;
		int _saveIndex;
		
		match('|');
		_ttype =  ALTERNATIVES;
		{
		if ((LA(1)=='|')) {
			match('|');
			_ttype =   OR;
		}
		else {
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mTILDE_START(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TILDE_START;
		int _saveIndex;
		
		match('~');
		_ttype =  INFIXFULLFORM;
		{
		if ((LA(1)=='~')) {
			match('~');
			_ttype =  STRINGEXPRESSION;
		}
		else {
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSTAR_START(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = STAR_START;
		int _saveIndex;
		
		match('*');
		_ttype =  TIMES;
		{
		switch ( LA(1)) {
		case '=':
		{
			match('=');
			_ttype =  TIMESBY;
			break;
		}
		case '*':
		{
			match('*');
			_ttype =  NONCOMMUTE;
			break;
		}
		default:
			{
			}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mUNSETINFIX(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = UNSETINFIX;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mWHITESPACE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WHITESPACE;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case ' ':
		{
			match(' ');
			break;
		}
		case '\r':
		{
			match('\r');
			break;
		}
		case '\n':
		{
			match('\n');
			newline();
			break;
		}
		case '\t':
		{
			match('\t');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mERROR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ERROR;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSTRING(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = STRING;
		int _saveIndex;
		
		try {      // for error handling
			match('\"');
			_ttype =  STRING; matchString(true);
		}
		catch (Exception allExceptions) {
			
					 	_ttype =  ERROR;	 
					
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMMENT;
		int _saveIndex;
		
		try {      // for error handling
			match('(');
			_ttype =  LPAREN;
			{
			if ((LA(1)=='*')) {
				match('*');
				_ttype =   COMMENT;
						  matchComment();
						
			}
			else {
			}
			
			}
		}
		catch (Exception allExceptions) {
			
					 	_ttype =  ERROR;	 
					
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSLOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SLOT;
		int _saveIndex;
		
		match('#');
		{
		switch ( LA(1)) {
		case '0':  case '1':  case '2':  case '3':
		case '4':  case '5':  case '6':  case '7':
		case '8':  case '9':
		{
			{
			int _cnt233=0;
			_loop233:
			do {
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					matchRange('0','9');
				}
				else {
					if ( _cnt233>=1 ) { break _loop233; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				
				_cnt233++;
			} while (true);
			}
			break;
		}
		case '#':
		{
			match('#');
			{
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				{
				int _cnt236=0;
				_loop236:
				do {
					if (((LA(1) >= '0' && LA(1) <= '9'))) {
						matchRange('0','9');
					}
					else {
						if ( _cnt236>=1 ) { break _loop236; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
					}
					
					_cnt236++;
				} while (true);
				}
			}
			else {
			}
			
			}
			break;
		}
		default:
			{
			}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mINT_REAL_DOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = INT_REAL_DOT;
		int _saveIndex;
		
		{
		int _cnt239=0;
		_loop239:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				matchRange('0','9');
			}
			else {
				if ( _cnt239>=1 ) { break _loop239; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt239++;
		} while (true);
		}
		_ttype =  INT;
		{
		if ((LA(1)=='^')) {
			{
			{
			
								if ( peekChar() != '^') {
									_token = makeToken(_ttype);
									_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
									_returnToken = _token;
									return;
								}
							
			match('^');
			match('^');
			{
			_loop244:
			do {
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					matchRange('0','9');
				}
				else if (((LA(1) >= 'a' && LA(1) <= 'z'))) {
					matchRange('a','z');
				}
				else if (((LA(1) >= 'A' && LA(1) <= 'Z'))) {
					matchRange('A','Z');
				}
				else {
					break _loop244;
				}
				
			} while (true);
			}
			{
			if ((LA(1)=='.')) {
				match('.');
				_ttype =  REAL;
			}
			else {
			}
			
			}
			{
			_loop247:
			do {
				switch ( LA(1)) {
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					matchRange('0','9');
					break;
				}
				case 'a':  case 'b':  case 'c':  case 'd':
				case 'e':  case 'f':  case 'g':  case 'h':
				case 'i':  case 'j':  case 'k':  case 'l':
				case 'm':  case 'n':  case 'o':  case 'p':
				case 'q':  case 'r':  case 's':  case 't':
				case 'u':  case 'v':  case 'w':  case 'x':
				case 'y':  case 'z':
				{
					matchRange('a','z');
					break;
				}
				case 'A':  case 'B':  case 'C':  case 'D':
				case 'E':  case 'F':  case 'G':  case 'H':
				case 'I':  case 'J':  case 'K':  case 'L':
				case 'M':  case 'N':  case 'O':  case 'P':
				case 'Q':  case 'R':  case 'S':  case 'T':
				case 'U':  case 'V':  case 'W':  case 'X':
				case 'Y':  case 'Z':
				{
					matchRange('A','Z');
					break;
				}
				default:
				{
					break _loop247;
				}
				}
			} while (true);
			}
			{
			if ((LA(1)=='`')) {
				match('`');
				_ttype =  REAL;
				{
				_loop250:
				do {
					if (((LA(1) >= '0' && LA(1) <= '9'))) {
						matchRange('0','9');
					}
					else {
						break _loop250;
					}
					
				} while (true);
				}
				{
				if ((LA(1)=='.')) {
					match('.');
					{
					_loop253:
					do {
						if (((LA(1) >= '0' && LA(1) <= '9'))) {
							matchRange('0','9');
						}
						else {
							break _loop253;
						}
						
					} while (true);
					}
				}
				else {
				}
				
				}
			}
			else {
			}
			
			}
			{
			if ((LA(1)=='*')) {
				
									if ( peekChar() != '^') {
										_token = makeToken(_ttype);
										_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
										_returnToken = _token;
										return;
									}
								
				match("*^");
				{
				switch ( LA(1)) {
				case '-':
				{
					match('-');
					break;
				}
				case '+':
				{
					match('+');
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
				{
				int _cnt257=0;
				_loop257:
				do {
					if (((LA(1) >= '0' && LA(1) <= '9'))) {
						matchRange('0','9');
					}
					else {
						if ( _cnt257>=1 ) { break _loop257; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
					}
					
					_cnt257++;
				} while (true);
				}
			}
			else {
			}
			
			}
			}
			}
		}
		else {
			{
			{
			if ((LA(1)=='.')) {
				match('.');
				_ttype =  REAL;
			}
			else {
			}
			
			}
			{
			_loop261:
			do {
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					matchRange('0','9');
				}
				else {
					break _loop261;
				}
				
			} while (true);
			}
			{
			if ((LA(1)=='`')) {
				match('`');
				_ttype =  REAL;
				{
				_loop264:
				do {
					if (((LA(1) >= '0' && LA(1) <= '9'))) {
						matchRange('0','9');
					}
					else {
						break _loop264;
					}
					
				} while (true);
				}
				{
				if ((LA(1)=='.')) {
					match('.');
					{
					_loop267:
					do {
						if (((LA(1) >= '0' && LA(1) <= '9'))) {
							matchRange('0','9');
						}
						else {
							break _loop267;
						}
						
					} while (true);
					}
				}
				else {
				}
				
				}
			}
			else {
			}
			
			}
			{
			if ((LA(1)=='*')) {
				
									if ( peekChar() != '^') {
										_token = makeToken(_ttype);
										_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
										_returnToken = _token;
										return;
									}
								
				match("*^");
				{
				switch ( LA(1)) {
				case '-':
				{
					match('-');
					break;
				}
				case '+':
				{
					match('+');
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
				{
				int _cnt271=0;
				_loop271:
				do {
					if (((LA(1) >= '0' && LA(1) <= '9'))) {
						matchRange('0','9');
					}
					else {
						if ( _cnt271>=1 ) { break _loop271; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
					}
					
					_cnt271++;
				} while (true);
				}
			}
			else {
			}
			
			}
			}
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDOT_START(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DOT_START;
		int _saveIndex;
		
		match('.');
		_ttype =  DOT;
		{
		switch ( LA(1)) {
		case '.':
		{
			match('.');
			_ttype =  REPEATED;
			{
			if ((LA(1)=='.')) {
				match('.');
				_ttype =  REPEATEDNULL;
			}
			else {
			}
			
			}
			break;
		}
		case '0':  case '1':  case '2':  case '3':
		case '4':  case '5':  case '6':  case '7':
		case '8':  case '9':
		{
			{
			matchRange('0','9');
			}
			{
			_loop277:
			do {
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					matchRange('0','9');
				}
				else {
					break _loop277;
				}
				
			} while (true);
			}
			_ttype =  REAL;
			{
			if ((LA(1)=='`')) {
				match('`');
				{
				_loop280:
				do {
					if (((LA(1) >= '0' && LA(1) <= '9'))) {
						matchRange('0','9');
					}
					else {
						break _loop280;
					}
					
				} while (true);
				}
				{
				if ((LA(1)=='.')) {
					match('.');
					{
					_loop283:
					do {
						if (((LA(1) >= '0' && LA(1) <= '9'))) {
							matchRange('0','9');
						}
						else {
							break _loop283;
						}
						
					} while (true);
					}
				}
				else {
				}
				
				}
			}
			else {
			}
			
			}
			{
			if ((LA(1)=='*')) {
				
									if ( peekChar() != '^') {
										_token = makeToken(_ttype);
										_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
										_returnToken = _token;
										return;
									}
								
				match("*^");
				{
				switch ( LA(1)) {
				case '-':
				{
					match('-');
					break;
				}
				case '+':
				{
					match('+');
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
				{
				int _cnt287=0;
				_loop287:
				do {
					if (((LA(1) >= '0' && LA(1) <= '9'))) {
						matchRange('0','9');
					}
					else {
						if ( _cnt287>=1 ) { break _loop287; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
					}
					
					_cnt287++;
				} while (true);
				}
			}
			else {
			}
			
			}
			break;
		}
		default:
			{
			}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mDOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DOT;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mREPEATED(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = REPEATED;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mREPEATEDNULL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = REPEATEDNULL;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mREPEATEDINFIX(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = REPEATEDINFIX;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mREPEATEDNULLINFIX(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = REPEATEDNULLINFIX;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mINT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = INT;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mREAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = REAL;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBLANK(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BLANK;
		int _saveIndex;
		
		match('_');
		_ttype =  BLANK1;
		{
		switch ( LA(1)) {
		case '.':
		{
			match('.');
			_ttype =  BLANKDOT;
			break;
		}
		case '_':
		{
			match('_');
			_ttype =  BLANK2;
			{
			if ((LA(1)=='_')) {
				match('_');
				_ttype =  BLANK3;
			}
			else {
			}
			
			}
			break;
		}
		default:
			{
			}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mPERCENTNUMBER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PERCENTNUMBER;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPERCENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PERCENT;
		int _saveIndex;
		
		match('%');
		{
		if (((LA(1) >= '0' && LA(1) <= '9'))) {
			{
			matchRange('0','9');
			}
			{
			_loop303:
			do {
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					matchRange('0','9');
				}
				else {
					break _loop303;
				}
				
			} while (true);
			}
			_ttype =  PERCENTNUMBER;
		}
		else {
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mID(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ID;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case '$':
		{
			match('$');
			break;
		}
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':  case 'g':  case 'h':
		case 'i':  case 'j':  case 'k':  case 'l':
		case 'm':  case 'n':  case 'o':  case 'p':
		case 'q':  case 'r':  case 's':  case 't':
		case 'u':  case 'v':  case 'w':  case 'x':
		case 'y':  case 'z':
		{
			matchRange('a','z');
			break;
		}
		case 'A':  case 'B':  case 'C':  case 'D':
		case 'E':  case 'F':  case 'G':  case 'H':
		case 'I':  case 'J':  case 'K':  case 'L':
		case 'M':  case 'N':  case 'O':  case 'P':
		case 'Q':  case 'R':  case 'S':  case 'T':
		case 'U':  case 'V':  case 'W':  case 'X':
		case 'Y':  case 'Z':
		{
			matchRange('A','Z');
			break;
		}
		case '`':
		{
			match('`');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		_loop307:
		do {
			switch ( LA(1)) {
			case '$':
			{
				match('$');
				break;
			}
			case 'a':  case 'b':  case 'c':  case 'd':
			case 'e':  case 'f':  case 'g':  case 'h':
			case 'i':  case 'j':  case 'k':  case 'l':
			case 'm':  case 'n':  case 'o':  case 'p':
			case 'q':  case 'r':  case 's':  case 't':
			case 'u':  case 'v':  case 'w':  case 'x':
			case 'y':  case 'z':
			{
				matchRange('a','z');
				break;
			}
			case 'A':  case 'B':  case 'C':  case 'D':
			case 'E':  case 'F':  case 'G':  case 'H':
			case 'I':  case 'J':  case 'K':  case 'L':
			case 'M':  case 'N':  case 'O':  case 'P':
			case 'Q':  case 'R':  case 'S':  case 'T':
			case 'U':  case 'V':  case 'W':  case 'X':
			case 'Y':  case 'Z':
			{
				matchRange('A','Z');
				break;
			}
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				matchRange('0','9');
				break;
			}
			case '`':
			{
				match('`');
				break;
			}
			default:
				if (((LA(1) >= '\u0080' && LA(1) <= '\ufffe'))) {
					matchRange('\u0080','\uFFFE');
				}
			else {
				break _loop307;
			}
			}
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mIDUNICODESTART(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = IDUNICODESTART;
		int _saveIndex;
		
		{
		matchRange('\u0080','\uFFFE');
		}
		{
		_loop311:
		do {
			switch ( LA(1)) {
			case '$':
			{
				match('$');
				break;
			}
			case 'a':  case 'b':  case 'c':  case 'd':
			case 'e':  case 'f':  case 'g':  case 'h':
			case 'i':  case 'j':  case 'k':  case 'l':
			case 'm':  case 'n':  case 'o':  case 'p':
			case 'q':  case 'r':  case 's':  case 't':
			case 'u':  case 'v':  case 'w':  case 'x':
			case 'y':  case 'z':
			{
				matchRange('a','z');
				break;
			}
			case 'A':  case 'B':  case 'C':  case 'D':
			case 'E':  case 'F':  case 'G':  case 'H':
			case 'I':  case 'J':  case 'K':  case 'L':
			case 'M':  case 'N':  case 'O':  case 'P':
			case 'Q':  case 'R':  case 'S':  case 'T':
			case 'U':  case 'V':  case 'W':  case 'X':
			case 'Y':  case 'Z':
			{
				matchRange('A','Z');
				break;
			}
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				matchRange('0','9');
				break;
			}
			case '`':
			{
				match('`');
				break;
			}
			default:
				if (((LA(1) >= '\u0080' && LA(1) <= '\ufffe'))) {
					matchRange('\u0080','\uFFFE');
				}
			else {
				break _loop311;
			}
			}
		} while (true);
		}
		_ttype =  ID;
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mLONGNAME(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LONGNAME;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBACKSLASH_START(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BACKSLASH_START;
		int _saveIndex;
		
		try {      // for error handling
			match('\\');
			{
			switch ( LA(1)) {
			case '!':
			{
				match('!');
				_ttype =  TYPESETEXPR; matchActiveTypeset(true);
				break;
			}
			case '(':
			{
				match('(');
				
							 if (typesetParse)  {
							 	_ttype =  TYPESETOPEN;
							 }
							 else {
							 	_ttype =  TYPESETEXPR; matchTypeset(true);
							 }
							
				break;
			}
			case ')':
			{
				match(')');
				_ttype =  TYPESETCLOSE;
				break;
			}
			case '^':
			{
				match('^');
				_ttype =  TYPESETSUPER;
				break;
			}
			case '*':
			{
				match('*');
				_ttype =  TYPESETFULLFORM;
				break;
			}
			case '@':
			{
				match('@');
				_ttype =  TYPESETSQRT;
				break;
			}
			case '_':
			{
				match('_');
				_ttype =  TYPESETSUB;
				break;
			}
			case '/':
			{
				match('/');
				_ttype =  TYPESETDIVIDE;
				break;
			}
			case '\r':
			{
				match('\r');
				_ttype =  WHITESPACE;
				break;
			}
			case '\n':
			{
				match('\n');
				newline(); _ttype =  WHITESPACE;
				break;
			}
			case 't':
			{
				match('t');
				_ttype =  TYPESETSPACE;
				break;
			}
			case ' ':
			{
				match(' ');
				_ttype =  TYPESETSPACE;
				break;
			}
			case '[':
			{
				match('[');
				{
				matchRange('A','Z');
				}
				{
				_loop317:
				do {
					switch ( LA(1)) {
					case 'a':  case 'b':  case 'c':  case 'd':
					case 'e':  case 'f':  case 'g':  case 'h':
					case 'i':  case 'j':  case 'k':  case 'l':
					case 'm':  case 'n':  case 'o':  case 'p':
					case 'q':  case 'r':  case 's':  case 't':
					case 'u':  case 'v':  case 'w':  case 'x':
					case 'y':  case 'z':
					{
						matchRange('a','z');
						break;
					}
					case 'A':  case 'B':  case 'C':  case 'D':
					case 'E':  case 'F':  case 'G':  case 'H':
					case 'I':  case 'J':  case 'K':  case 'L':
					case 'M':  case 'N':  case 'O':  case 'P':
					case 'Q':  case 'R':  case 'S':  case 'T':
					case 'U':  case 'V':  case 'W':  case 'X':
					case 'Y':  case 'Z':
					{
						matchRange('A','Z');
						break;
					}
					default:
					{
						break _loop317;
					}
					}
				} while (true);
				}
				match(']');
				_ttype =  LONGNAME;
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			}
		}
		catch (Exception allExceptions) {
			
					 	_ttype =  ERROR;	 
					
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mBACKSLASHBRACKET(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BACKSLASHBRACKET;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mTYPESETEXPR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TYPESETEXPR;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mTYPESETOPEN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TYPESETOPEN;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mTYPESETCLOSE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TYPESETCLOSE;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mTYPESETSUPER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TYPESETSUPER;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mTYPESETSUB(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TYPESETSUB;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mTYPESETSPACE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TYPESETSPACE;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mTYPESETDIVIDE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TYPESETDIVIDE;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mTYPESETFULLFORM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TYPESETFULLFORM;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mTYPESETSQRT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TYPESETSQRT;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mDUMMYID(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DUMMYID;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mIDBLANKDOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = IDBLANKDOT;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mBLANKDOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BLANKDOT;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mIDBLANKID1(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = IDBLANKID1;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mIDBLANKID2(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = IDBLANKID2;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mIDBLANKID3(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = IDBLANKID3;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mIDBLANK1(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = IDBLANK1;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mIDBLANK2(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = IDBLANK2;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mIDBLANK3(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = IDBLANK3;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mBLANKID1(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BLANKID1;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mBLANKID2(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BLANKID2;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mBLANKID3(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BLANKID3;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mBLANK1(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BLANK1;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mBLANK2(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BLANK2;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mBLANK3(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BLANK3;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mUNARYMINUS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = UNARYMINUS;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mUNARYPLUS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = UNARYPLUS;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mPACKAGE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PACKAGE;
		int _saveIndex;
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	
	
	}
