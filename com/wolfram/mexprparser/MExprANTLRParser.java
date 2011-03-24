// $ANTLR 2.7.4: "exprrules.g" -> "MExprANTLRParser.java"$
 
	
	package com.wolfram.mexprparser; 

	import com.wolfram.mexpr.*;
	import com.wolfram.mexpr.visitors.*;
	import java.util.Hashtable;
	import java.io.IOException;
	import antlr.ANTLRStringBuffer;
	import java.util.ArrayList;
    import java.util.Hashtable;
    import java.util.List;

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;

public class MExprANTLRParser extends antlr.LLkParser       implements MExprANTLRParserTokenTypes
 {

	Hashtable store = new Hashtable();
	TokenStreamRecoverer input;
	boolean tokenReady;
	int nextTokenType;
	Token nextToken;
	MExprFactory factory;
	ErrorListener errorListener_;
	boolean parseError_ = false;
	int braceCount;
	int bracketCount;
	int parenCount;
	MExprTokenStream tokenHandler;
	

/*
 nextToken called by fill in TokenBuffer
 consume defined in TokenBuffer
*/

	public void setParser( TokenStreamRecoverer input_)
	{
		input = input_;
		tokenReady = false;
		parseError_ = false;
		factory = new MExprFactory();
		braceCount = 0;
		bracketCount = 0;
		parenCount = 0;
		tokenHandler = null;
	}
	
	
	// ERROR_HANDLING: added this
	public void setErrorListener(ErrorListener listener){
		errorListener_ = listener;
	}

	public boolean isParseError() {
		return parseError_;
	}

	private MExprTokenStream getTokenHandler() {
		if ( tokenHandler == null) {
			tokenHandler = new MExprTokenStream();
		}
		return tokenHandler;
	}
	
	
	protected void addError(String description, Token tok1, int type, MExprToken start, MExprToken end){
		parseError_ = true;
		if(errorListener_ != null){
			errorListener_.errorHappened(description, tok1.getText(), type, start, end);
		}
	}

	protected MExpr handleErrorRecoverer( Exception allExceptions, int pos) {
		Token lastToken = input.lastToken();
		MExprToken nextToken = null;
		try {
			nextToken = (MExprToken)LT(1);
		}
		catch ( TokenStreamException e2) {
			
		}	
		if ( nextToken == null) {
			System.out.println( "Token was null ");
			return handleErrorBasic( allExceptions);
		}
		
		
		// This token error runs to the end, there is no recovery
		if ( nextToken.getType() == ERROR) {
			System.out.println("Token Error 1");
			addError("Token error", nextToken, MExprParserConstants.TOKEN_ERROR, (MExprToken)nextToken,(MExprToken)nextToken);			
			consume();
			return new MOperator("ERROR_NODE");
		}
		
		MExprToken idTok = (MExprToken)input.makeToken( MExprANTLRParserTokenTypes.ID, "ErrorRecoveryToken");
		if ( !input.unmodifiedToken()) {
			return handleErrorBasic( allExceptions);
		}
		idTok.tokenIndex_ = nextToken.tokenIndex_;
		input.insertToken( idTok);
		input.setPosition( pos);
		consume();
		MExpr res = null;
		try {
			res = semiexpr();
		}
		catch ( RecognitionException e1) {
			System.out.println( "Exception 1");
		}
		catch ( TokenStreamException e2) {
			System.out.println( "Exception 2");
			res = handleErrorBasic( allExceptions);
		}
		if ( res == null) {
			res = handleErrorBasic( allExceptions);
			res.setCharStart( ((MExprToken)lastToken).tokenIndex_);
		}

		res.setCharEnd( idTok.tokenIndex_);
		// Add errors		
		MExprTokenStream tHand = getTokenHandler();
		boolean errorGone = false;
		if ( lastToken != null && tHand.tokenIsStartMatch( lastToken)) {
			if ( !tHand.tokenCanStart( nextToken)) {
				addError("Missing argument", nextToken, MExprParserConstants.MISSING_ARG_LEFT, (MExprToken)nextToken,(MExprToken)nextToken);
				errorGone = true;
			}
		}
		else if ( lastToken != null && tHand.tokenIsEndMatch( nextToken)) {
			if ( !tHand.tokenCanEnd( lastToken)) {
				addError("Missing argument", lastToken, MExprParserConstants.MISSING_ARG_RIGHT, (MExprToken)lastToken,(MExprToken)lastToken);
				errorGone = true;
			}
		}
		else if ( lastToken != null && !tHand.tokenCanEnd( lastToken)) {
			addError("Missing argument",lastToken, MExprParserConstants.MISSING_ARG_RIGHT, (MExprToken)lastToken,(MExprToken)lastToken);
			errorGone = true;
		}
		else if ( !tHand.tokenCanStart( nextToken)) {
			addError("Missing argument", nextToken, MExprParserConstants.MISSING_ARG_LEFT, (MExprToken)nextToken,(MExprToken)nextToken);
			errorGone = true;
		}
		
		if ( !errorGone) {
			addError("Syntax error", lastToken, MExprParserConstants.SYNTAX_ERROR, (MExprToken)lastToken,(MExprToken)nextToken);
		}
		
		return res;
	}
		
	protected MExpr handleErrorBasic( Exception allExceptions) {

		MExpr value = new MOperator("ERROR_NODE");
		try {
			Token startToken = LT(1);
			Token endToken = LT(1);
			while( LA(1)!=PACKAGE && LA(1) != EOF) {
				endToken = LT(1);
				consume();
			}

			addError("Syntax error", startToken, MExprParserConstants.SYNTAX_ERROR, (MExprToken)startToken ,(MExprToken)endToken );
		} catch (Exception e) {
			parseError_ = true;
			e.printStackTrace();
			// TODO: handle exception
		}
		return value;
	}

	protected MExpr handleError( Exception allExceptions, int pos) {
		// TODO: try to find out the starting token
		// TODO: should this happen?
		//	consume();

		if ( input.recoverySupported()) {
			return handleErrorRecoverer( allExceptions, pos);
		}
		return handleErrorBasic( allExceptions);
	}	
										
	
	/*
	 Called from the top-level topexpr or startexpr to recover from 
	 an error.
	*/									
	protected MExpr handleErrorStart( Exception allExceptions, MExpr value, int pos)
		throws TokenStreamException, RecognitionException  {
		 
		if ( !input.recoverySupported()) {
			return handleErrorBasic( allExceptions);
		}
		
		if ( LA(1) != COMMA && 
				LA(1) != RBRACE && 
				LA(1) != RBRACKET && 
				LA(1) != LBRACKET && 
				LA(1) != RPAREN &&
				LA(1) != ERROR) {
			value = handleError( allExceptions, pos);
			// This should never come from startexpr (only topexpr)
			return joinErrorToPackage( value);
		}
		
		String text = "";
		int type = MExprParserConstants.SYNTAX_ERROR;
		if ( LA(1) == COMMA) {
			text = "Comma error";
			type = MExprParserConstants.COMMA_ERROR;
		}
		else if ( LA(1) == RBRACE) {
			text = "Brace error";
			type = MExprParserConstants.BRACE_ERROR;
		}
		else if ( LA(1) == RBRACKET) {
			text = "Bracket error";
			type = MExprParserConstants.RBRACKET_ERROR;
		}
		else if ( LA(1) == LBRACKET) {
			text = "Bracket error";
			type = MExprParserConstants.LBRACKET_ERROR;
		}
		else if ( LA(1) == RPAREN) {
			text = "Parenthesis error";
			type = MExprParserConstants.PAREN_ERROR;
		}
		else if ( LA(1) == ERROR) {
			System.out.println("Token Error 1");
			text = "Token error";
			type = MExprParserConstants.TOKEN_ERROR;
		}
		addError( text, LT(1), type, (MExprToken)LT(1) ,(MExprToken)LT(1));
		consume();
		
		return joinErrorToPackage( value);
	}
	
	
	/*
	 * Called at the toplevel, to join the error to the package.
	 */
	MExpr joinErrorToPackage( MExpr value) 
		throws TokenStreamException, RecognitionException {
		if ( LA(1) == PACKAGE)
			consume();
		if ( LA(1) == EOF)
			return value;
		
		return new MNormal( MExpr.JOINPACKAGEexpr, value);
	}
	
	
	MExpr handleParenError( RecognitionException e, MExpr value, Token tok1, int pos) 
		throws RecognitionException, TokenStreamException {
		
		if ( !input.recoverySupported()) {
			throw e;
		}
				
		MExprToken tokStart = (MExprToken)tok1;
		MExprToken tokEnd = (MExprToken)tok1;
		if ( LA(1) == EOF || 
				LA(1) == COMMA ||
				LA(1) == RBRACKET && bracketCount > 0 ||
				LA(1) == RBRACE && braceCount > 0) {
			addError("Unterminated brace", tokStart, MExprParserConstants.UNTERMINATED_PAREN, tokStart, tokEnd);
			if ( value == null) {
				value = new MOperator("ERROR_NODE");	
			}
			value = new MNormal( MExpr.PARENexpr, value);  
			value.setCharStart( (MExprToken) tok1);
			return value;
		}
		
		// No need to check parenCount, this was called from parenexpr
		boolean dropToken = false;
		if ( LA(1) == RBRACKET) {
			addError("Missing open bracket", LT(1), MExprParserConstants.MISSING_OPEN_BRACKET, (MExprToken)LT(1), (MExprToken)LT(1));
			dropToken = true;		
		}
		else if ( LA(1) == RBRACE) {
			addError("Missing open brace", LT(1), MExprParserConstants.MISSING_OPEN_BRACE, (MExprToken)LT(1), (MExprToken)LT(1));
			dropToken = true;		
		}
		if ( dropToken && input.unmodifiedToken()) {
		   	input.dropToken();
		   	input.setPosition( pos);
		   	consume();
			return parenexpr();				
		}
		
		if ( LA(1) == ERROR && input.unmodifiedToken()) {
			System.out.println("Token Error 1");
			addError("Token error", LT(1), MExprParserConstants.TOKEN_ERROR, (MExprToken)LT(1), (MExprToken)LT(1));
			Token idTok = input.makeToken( MExprANTLRParserTokenTypes.ID, "ErrorRecoveryToken");
		   	input.replaceToken(idTok);
		   	input.setPosition( pos);
		   	consume();
			return parenexpr();						
		}
		
		// Happens when a token that can't start an expr is found after a [(
		throw e;		
	}
	
	MExpr handleListError( RecognitionException e, MExprVector args, 
			Token tok1, int pos)
		throws RecognitionException, TokenStreamException {

		if ( !input.recoverySupported()) {
			throw e;
		}
				
		MExprToken tokStart = (MExprToken)tok1;
		MExprToken tokEnd = (MExprToken)tok1;
		if ( LA(1) == EOF || 
				LA(1) == RBRACKET && bracketCount > 0 ||
				LA(1) == RPAREN && parenCount > 0) {
			addError("Unterminated brace", tokStart, MExprParserConstants.UNTERMINATED_BRACE, tokStart, tokEnd);
			MExpr value = new MNormal( MExpr.LISTexpr);
			if ( args != null) {
				value = new MNormal( MExpr.LISTexpr, args);
			}
			value.setCharStart( (MExprToken) tok1);
			return value;
		}

		// No need to check bracketCount, this was called from fullformhead
		boolean dropToken = false;
		if ( LA(1) == RBRACKET) {
			addError("Missing open bracket", LT(1), MExprParserConstants.MISSING_OPEN_BRACKET, (MExprToken)LT(1), (MExprToken)LT(1));
			dropToken = true;		
		}
		else if ( LA(1) == RPAREN) {
			addError("Missing open parenthesis", LT(1), MExprParserConstants.MISSING_OPEN_PAREN, (MExprToken)LT(1), (MExprToken)LT(1));
			dropToken = true;		
		}
		else if ( LA(1) == ERROR) {
			System.out.println("Token Error 1");
			addError("Token error", LT(1), MExprParserConstants.TOKEN_ERROR, (MExprToken)LT(1), (MExprToken)LT(1));
			dropToken = true;		
		}
		if ( dropToken && input.unmodifiedToken()) {
		   	input.dropToken();
		   	input.setPosition( pos);
		   	consume();
			return listexpr();				
		}
	
		// Happens when a token that can't start an expr is found after a { 
		throw e;
	}		
	
	
	MExprHeadVector handleFullFormError( 
	RecognitionException e, MExprHeadVector args, MExprVector tmp, Token tok1, Token parttok1, boolean bodyLen, int pos) 
		throws RecognitionException, TokenStreamException {
	
		if ( !input.recoverySupported()) {
			throw e;
		}
	
		if ( parttok1 != null) {
			if ( bodyLen)
				bracketCount -= 2;
			if ( tmp != null)
				tmp.isPart = true;
		}
		else {
			if ( bodyLen)
				bracketCount--;
		}
		
		if ( tmp != null) {
			tmp.setCharEnd((MExprToken)input.lastToken());
			args.add( tmp);
		}
		
		MExprToken tokStart = (MExprToken)tok1;
		MExprToken tokEnd = (MExprToken)(parttok1 == null? tok1: parttok1);
		if ( LA(1) == EOF || 
				LA(1) == RBRACE && braceCount > 0 ||
				LA(1) == RPAREN && parenCount > 0) {
			addError("Unterminated bracket", tok1, MExprParserConstants.UNTERMINATED_BRACKET, tokStart , tokEnd);
			if ( args.length() == 0) {
				tmp= new MExprVector();
				tmp.setCharEnd( tokEnd);
				args.add(tmp);
			}
			return args;	
		}
		
		// No need to check bracketCount, this was called from fullformhead
		boolean dropToken = false;
		if ( LA(1) == RBRACE) {
			addError("Missing open brace", LT(1), MExprParserConstants.MISSING_OPEN_BRACE, (MExprToken)LT(1), (MExprToken)LT(1));
			dropToken = true;		
		}
		else if ( LA(1) == RPAREN) {
			addError("Missing open parenthesis", LT(1), MExprParserConstants.MISSING_OPEN_PAREN, (MExprToken)LT(1), (MExprToken)LT(1));
			dropToken = true;		
		}
		else if ( LA(1) == ERROR) {
			System.out.println("Token Error 1");
			addError("Token error", LT(1), MExprParserConstants.TOKEN_ERROR, (MExprToken)LT(1), (MExprToken)LT(1));
			dropToken = true;		
		}
		if ( dropToken && input.unmodifiedToken()) {
		   	input.dropToken();
		   	input.setPosition( pos);
		   	consume();
			return fullformhead();				
		}
		
		// Happens when a token that can't start an expr is found after a [ 
		throw e;
	}
	
	
	public void setMExprFilter( MExprFilter filter)
	{
		factory.setFilter( filter);
	}

	public int LA( int i) throws TokenStreamException
	{
		if ( tokenReady)
			return nextTokenType;
		tokenReady = true;
		nextToken = input.nextToken();
		nextTokenType = nextToken.getType();
		return nextTokenType;
	}

	public Token LT( int i) throws TokenStreamException
	{
		if ( tokenReady)
			return nextToken;
		tokenReady = true;
		nextToken = input.nextToken();
		nextTokenType = nextToken.getType();
		return nextToken;
	}


   public void match(int t) throws MismatchedTokenException, TokenStreamException {
        if (LA(1) != t)
            throw new MismatchedTokenException(tokenNames, LT(1), t, false, getFilename());
        else
        // mark token as consumed -- fetch next token deferred until LA/LT
            consume();
    }

	public void consume()
	{
		tokenReady = false;
	}	

	void putAST( Token token, MExpr value) 
	{
		String text = token.getText();
		store.put( text, value);
	}

	MExpr getAST( Token token) throws TokenStreamException
	{
		String text = token.getText();
		MExpr value = ( MExpr) store.remove( text);
		if ( value == null)
			throw new TokenStreamException( "Missing value.");
		
		return value;
	}


	public final MExpr topexpr() throws RecognitionException, TokenStreamException {
		
		MExpr lastvalue = null;

		while( true) {
			
			MExpr value = topexprImpl();
			if ( value.head().sameQ(MExpr.JOINPACKAGEexpr)) {
				value = value.part(1);
				if ( value.sameQ( MExpr.NULLexpr)) {
					int pos = 0;
					if ( lastvalue != null) {
						pos = lastvalue.getCharEnd()+1;
					}
					//This is not really correct,  the length of the token is 
					//not 1, really it is 0.  This was added for a QuickFix
					//it also causes problems for the Outline
					value = new MOperator( "Null");
					value.setCharPositions( pos, pos);
				}
				if ( lastvalue != null) {
					value = factory.joinExpr( MExpr.PACKAGEexpr, lastvalue, value);	
				}
				lastvalue = value;
			}
			else {
				if ( value.sameQ( MExpr.NULLexpr)) {
					int pos = 0;
					if ( lastvalue != null) {
						pos = lastvalue.getCharEnd()+1;
					}
					value = new MOperator( "Null");
					value.setCharPositions( pos, pos);
				}
				if ( lastvalue != null) {
					value = factory.joinExpr( MExpr.PACKAGEexpr, lastvalue, value);	
				}
				return value;
			}
		}
	}


protected MExprANTLRParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public MExprANTLRParser(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected MExprANTLRParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public MExprANTLRParser(TokenStream lexer) {
  this(lexer,1);
}

public MExprANTLRParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
}

	public final MExpr  topexprImpl() throws RecognitionException, TokenStreamException {
		MExpr value = MExpr.NULLexpr;
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case NOT:
			case NOTNOT:
			case UNARYPLUS:
			case UNARYMINUS:
			case TYPESETSQRT:
			case PLUSPLUS:
			case MINUSMINUS:
			case TYPESETFULLFORM:
			case LPAREN:
			case TYPESETOPEN:
			case LBRACE:
			case ID:
			case GET:
			case INT:
			case REAL:
			case STRING:
			case POSTFIXID:
			case NULLID:
			case ERROR:
			case BLANKDOT:
			case SLOT:
			case TYPESETEXPR:
			case PERCENT:
			case PERCENTNUMBER:
			case BLANK1:
			case BLANK2:
			case BLANK3:
			case BLANKID1:
			case BLANKID2:
			case BLANKID3:
			{
				value=startexpr();
				break;
			}
			case EOF:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (Exception allExceptions) {
			
					return handleErrorStart( allExceptions, value, 0);
				
		}
		return value;
	}
	
	public final MExpr  startexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e; int pos = 0;
		
		try {      // for error handling
			value=expr();
			{
			_loop6:
			do {
				if ((LA(1)==PACKAGE)) {
					match(PACKAGE);
					pos = input.getPosition();
					{
					switch ( LA(1)) {
					case EOF:
					{
						match(Token.EOF_TYPE);
						break;
					}
					case NOT:
					case NOTNOT:
					case UNARYPLUS:
					case UNARYMINUS:
					case TYPESETSQRT:
					case PLUSPLUS:
					case MINUSMINUS:
					case TYPESETFULLFORM:
					case LPAREN:
					case TYPESETOPEN:
					case LBRACE:
					case ID:
					case GET:
					case INT:
					case REAL:
					case STRING:
					case POSTFIXID:
					case NULLID:
					case ERROR:
					case BLANKDOT:
					case SLOT:
					case TYPESETEXPR:
					case PERCENT:
					case PERCENTNUMBER:
					case BLANK1:
					case BLANK2:
					case BLANK3:
					case BLANKID1:
					case BLANKID2:
					case BLANKID3:
					{
						e=expr();
						
							     	value = factory.appendExpr( MExpr.PACKAGEexpr, value, e);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
				}
				else {
					break _loop6;
				}
				
			} while (true);
			}
			match(Token.EOF_TYPE);
		}
		catch (Exception allExceptions) {
			
					value = handleErrorStart( allExceptions, value, pos);
				
		}
		return value;
	}
	
	public final MExpr  expr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		int pos = input.getPosition(); if (tokenReady) pos--;
		
		try {      // for error handling
			value=semiexpr();
		}
		catch (Exception allExceptions) {
			
					value = handleError( allExceptions, pos);
				
		}
		return value;
	}
	
	public final MExpr  semiexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  semiToken = null;
		MExpr e;
		
		value=putexpr();
		{
		_loop10:
		do {
			if ((LA(1)==SEMI)) {
				semiToken = LT(1);
				match(SEMI);
				e=putexpr();
				
							int rightMostTokenIndex = 0;
							value = factory.appendExpr( MExpr.COMPOUNDEexpr, value, e);
							if ( value.getCharEnd() == -1) { value.setCharEnd((IMExprToken)semiToken);}
							
			}
			else {
				break _loop10;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  putexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  tok = null;
		MExpr h;
		
		value=setexpr();
		{
		switch ( LA(1)) {
		case PUT:
		{
			tok = LT(1);
			match(PUT);
			
					String txt = tok.getText();
					if ( txt.length() > 2 && txt.charAt(2)=='>') {
						h = MExpr.PUTAPPENDexpr;
						txt = txt.substring(3);
					}
					else {
						h = MExpr.PUTexpr;
						txt = txt.substring(2);
					}
					value = new MNormal( h, value, new MString( txt));
					value.setCharEnd( (MExprToken)tok);
				
			break;
		}
		case EOF:
		case PACKAGE:
		case SEMI:
		case RBRACKET:
		case COMMA:
		case RPAREN:
		case TYPESETCLOSE:
		case RBRACE:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return value;
	}
	
	public final MExpr  setexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  tok = null;
		Token  tok1 = null;
		MExpr e = null, e1;
		
		value=slashfunexpr();
		{
		switch ( LA(1)) {
		case SET:
		{
			match(SET);
			e=setexpr();
			value = new MNormal( MExpr.SETexpr, value, e);
			break;
		}
		case SETDELAYED:
		{
			match(SETDELAYED);
			e=setexpr();
			value = new MNormal( MExpr.SETDELAYEDexpr, value, e);
			break;
		}
		case UPSET:
		{
			match(UPSET);
			e=setexpr();
			value = new MNormal( MExpr.UPSETexpr, value, e);
			break;
		}
		case UPSETDELAYED:
		{
			match(UPSETDELAYED);
			e=setexpr();
			value = new MNormal( MExpr.UPSETDELAYEDexpr, value, e);
			break;
		}
		case TAGSET:
		{
			{
			match(TAGSET);
			e=slashfunexpr();
			{
			switch ( LA(1)) {
			case SET:
			{
				{
				match(SET);
				e1=setexpr();
				value = new MNormal( MExpr.TAGSETexpr, value, e, e1);
				}
				break;
			}
			case SETDELAYED:
			{
				{
				match(SETDELAYED);
				e1=setexpr();
				value = new MNormal( MExpr.TAGSETDELAYEDexpr, value, e, e1);
				}
				break;
			}
			case UNSETINFIX:
			{
				{
				tok = LT(1);
				match(UNSETINFIX);
				
					      		MNormal ef = new MNormal( MExpr.TAGUNSETexpr, value, e); 
					      		ef.setCharEnd( (MExprToken)tok);
					 			putAST( tok, ef);
					      		
				value=setexpr();
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			}
			break;
		}
		case UNSETINFIX:
		{
			tok1 = LT(1);
			match(UNSETINFIX);
			
				 	MNormal ef = new MNormal( MExpr.UNSETexpr, value);
				 	ef.setCharEnd( (MExprToken)tok1);
				 	putAST( tok1, ef);
				 	
			value=setexpr();
			break;
		}
		case EOF:
		case PACKAGE:
		case SEMI:
		case PUT:
		case RBRACKET:
		case COMMA:
		case RPAREN:
		case TYPESETCLOSE:
		case RBRACE:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return value;
	}
	
	public final MExpr  slashfunexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e = null, e1;
		
		value=functionexpr();
		{
		_loop22:
		do {
			if ((LA(1)==SLASHFUN)) {
				match(SLASHFUN);
				e1=functionexpr();
				
							value = new MNormalSpecial( e1, value);
						
			}
			else {
				break _loop22;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  functionexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  tok1 = null;
		MExpr e;
		
		value=operequalsexpr();
		{
		_loop25:
		do {
			if ((LA(1)==AMPINFIX)) {
				tok1 = LT(1);
				match(AMPINFIX);
				
							MNormal ef = new MNormal( MExpr.FUNCTIONexpr, value);
							ef.setCharEnd( (MExprToken)tok1);
							putAST( tok1, ef);
						
				value=operequalsexpr();
			}
			else {
				break _loop25;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  operequalsexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e, h = null;
		
		value=replaceallexpr();
		{
		switch ( LA(1)) {
		case ADDTO:
		case SUBTRACTFROM:
		case TIMESBY:
		case DIVIDEBY:
		{
			{
			switch ( LA(1)) {
			case ADDTO:
			{
				match(ADDTO);
				h = MExpr.ADDTOexpr;
				break;
			}
			case SUBTRACTFROM:
			{
				match(SUBTRACTFROM);
				h = MExpr.SUBTRACTFROMexpr;
				break;
			}
			case TIMESBY:
			{
				match(TIMESBY);
				h = MExpr.TIMESBYexpr;
				break;
			}
			case DIVIDEBY:
			{
				match(DIVIDEBY);
				h = MExpr.DIVIDEBYexpr;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			e=operequalsexpr();
				
						value = new MNormal( h, value, e);
					
			break;
		}
		case EOF:
		case PACKAGE:
		case SEMI:
		case PUT:
		case SET:
		case SETDELAYED:
		case UPSET:
		case UPSETDELAYED:
		case TAGSET:
		case UNSETINFIX:
		case SLASHFUN:
		case AMPINFIX:
		case RBRACKET:
		case COMMA:
		case RPAREN:
		case TYPESETCLOSE:
		case RBRACE:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return value;
	}
	
	public final MExpr  replaceallexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e;
		
		value=ruleexpr();
		{
		_loop33:
		do {
			switch ( LA(1)) {
			case REPLACEALL:
			{
				{
				match(REPLACEALL);
				e=ruleexpr();
				value = new MNormal( MExpr.REPLACEALLexpr, value, e);
				}
				break;
			}
			case REPLACEREPEATED:
			{
				{
				match(REPLACEREPEATED);
				e=ruleexpr();
				value = new MNormal( MExpr.REPLACEREPEATEDexpr, value, e);
				}
				break;
			}
			default:
			{
				break _loop33;
			}
			}
		} while (true);
		}
		return value;
	}
	
	public final MExpr  ruleexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  rule = null;
		MExpr e;
		
		value=conditionexpr();
		{
		switch ( LA(1)) {
		case RULE:
		{
			rule = LT(1);
			match(RULE);
			e=ruleexpr();
			value = new MNormal( factory.getRule( rule.getText()), value, e);
					
			break;
		}
		case EOF:
		case PACKAGE:
		case SEMI:
		case PUT:
		case SET:
		case SETDELAYED:
		case UPSET:
		case UPSETDELAYED:
		case TAGSET:
		case UNSETINFIX:
		case SLASHFUN:
		case AMPINFIX:
		case ADDTO:
		case SUBTRACTFROM:
		case TIMESBY:
		case DIVIDEBY:
		case REPLACEALL:
		case REPLACEREPEATED:
		case RBRACKET:
		case COMMA:
		case RPAREN:
		case TYPESETCLOSE:
		case RBRACE:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return value;
	}
	
	public final MExpr  conditionexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e;
		
		value=stringexpressionexpr();
		{
		_loop38:
		do {
			if ((LA(1)==CONDITION)) {
				match(CONDITION);
				e=stringexpressionexpr();
				value = new MNormal( MExpr.CONDITIONexpr, value, e);
			}
			else {
				break _loop38;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  stringexpressionexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e;
		
		value=alternativesexpr();
		{
		_loop41:
		do {
			if ((LA(1)==STRINGEXPRESSION)) {
				match(STRINGEXPRESSION);
				e=alternativesexpr();
				
							 value = factory.appendExpr( MExpr.STRINGEXPRESSIONexpr, value, e);
							
			}
			else {
				break _loop41;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  alternativesexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e;
		
		value=repeatedexpr();
		{
		_loop44:
		do {
			if ((LA(1)==ALTERNATIVES)) {
				match(ALTERNATIVES);
				e=repeatedexpr();
				
								value = factory.appendExpr( MExpr.ALTERNATIVESexpr, value, e);
			}
			else {
				break _loop44;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  repeatedexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  tok1 = null;
		Token  tok2 = null;
		MExpr e;
		
		value=orexpr();
		{
		_loop49:
		do {
			if ((LA(1)==REPEATEDINFIX)) {
				{
				tok1 = LT(1);
				match(REPEATEDINFIX);
				
							MNormal ef = new MNormal( MExpr.REPEATEDexpr, value);
							ef.setCharEnd( (MExprToken)tok1);
							putAST( tok1, ef);
				value=orexpr();
				}
			}
			else if ((LA(1)==REPEATEDNULLINFIX)) {
				{
				tok2 = LT(1);
				match(REPEATEDNULLINFIX);
				
							MNormal ef = new MNormal( MExpr.REPEATEDNULLexpr, value);
							ef.setCharEnd( (MExprToken) tok2);
							putAST( tok2, ef);
				value=orexpr();
				}
			}
			else {
				break _loop49;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  orexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e;
		
		value=andexpr();
		{
		_loop52:
		do {
			if ((LA(1)==OR)) {
				match(OR);
				e=andexpr();
				
								value = factory.appendExpr( MExpr.ORexpr, value, e);
			}
			else {
				break _loop52;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  andexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e;
		
		value=notexpr();
		{
		_loop55:
		do {
			if ((LA(1)==AND)) {
				match(AND);
				e=notexpr();
				
								value = factory.appendExpr( MExpr.ANDexpr, value, e);
			}
			else {
				break _loop55;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  notexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  notToken = null;
		Token  notnotToken = null;
		MExpr e;
		
		if ((_tokenSet_0.member(LA(1)))) {
			value=sameqexpr();
		}
		else if ((LA(1)==NOT)) {
			notToken = LT(1);
			match(NOT);
			value=notexpr();
			
					value = new MNormal( MExpr.NOTexpr, value);
					value.setCharStart( (MExprToken) notToken);
					
		}
		else if ((LA(1)==NOTNOT)) {
			notnotToken = LT(1);
			match(NOTNOT);
			value=notexpr();
			
					value = new MNormal( MExpr.NOTexpr, value);
					value.setCharStart( -1);
					value = new MNormal( MExpr.NOTexpr, value);
					value.setCharStart( (MExprToken) notnotToken);		
					
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		return value;
	}
	
	public final MExpr  sameqexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e;
		
		value=equalexpr();
		{
		_loop61:
		do {
			if ((LA(1)==SAMEQ)) {
				{
				match(SAMEQ);
				e=equalexpr();
				
								value = factory.appendExpr( MExpr.SAMEQexpr, value, e);
				}
			}
			else if ((LA(1)==UNSAMEQ)) {
				{
				match(UNSAMEQ);
				e=equalexpr();
				
								value = factory.appendExpr( MExpr.UNSAMEQexpr, value, e);
				}
			}
			else {
				break _loop61;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  equalexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e;
		
		value=plusminusexpr();
		{
		_loop70:
		do {
			if ((LA(1)==EQUAL)) {
				{
				match(EQUAL);
				e=plusminusexpr();
				
								value = factory.appendInequality( MExpr.EQUALexpr, value, e);
				}
			}
			else if ((LA(1)==UNEQUAL)) {
				{
				match(UNEQUAL);
				e=plusminusexpr();
				
								value = factory.appendInequality( MExpr.UNEQUALexpr, value, e);
				}
			}
			else if ((LA(1)==GREATER)) {
				{
				match(GREATER);
				e=plusminusexpr();
				
								value = factory.appendInequality( MExpr.GREATERexpr, value, e);
				}
			}
			else if ((LA(1)==LESS)) {
				{
				match(LESS);
				e=plusminusexpr();
				
								value = factory.appendInequality( MExpr.LESSexpr, value, e);
				}
			}
			else if ((LA(1)==GREATEREQUAL)) {
				{
				match(GREATEREQUAL);
				e=plusminusexpr();
				
								value = factory.appendInequality( MExpr.GREATEREQUALexpr, value, e);
				}
			}
			else if ((LA(1)==LESSEQUAL)) {
				{
				match(LESSEQUAL);
				e=plusminusexpr();
				
								value = factory.appendInequality( MExpr.LESSEQUALexpr, value, e);
				}
			}
			else {
				break _loop70;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  plusminusexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  minusToken = null;
		MExpr tmp;
		
		value=timesexpr();
		{
		_loop75:
		do {
			if ((LA(1)==PLUS)) {
				{
				match(PLUS);
				tmp=timesexpr();
				
								value = factory.appendExpr( MExpr.PLUSexpr, value, tmp);
				}
			}
			else if ((LA(1)==MINUS)) {
				{
				minusToken = LT(1);
				match(MINUS);
				tmp=timesexpr();
				
								value = factory.appendExpr( 
									   MExpr.PLUSexpr, value, new MNormal( MExpr.MINUSexpr, tmp 
									   ));
				}
			}
			else {
				break _loop75;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  timesexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr tmp;
		
		value=divideexpr();
		{
		_loop79:
		do {
			if ((_tokenSet_1.member(LA(1)))) {
				{
				switch ( LA(1)) {
				case TIMES:
				{
					match(TIMES);
					break;
				}
				case NOT:
				case NOTNOT:
				case UNARYPLUS:
				case UNARYMINUS:
				case TYPESETSQRT:
				case PLUSPLUS:
				case MINUSMINUS:
				case TYPESETFULLFORM:
				case LPAREN:
				case TYPESETOPEN:
				case LBRACE:
				case ID:
				case GET:
				case INT:
				case REAL:
				case STRING:
				case POSTFIXID:
				case NULLID:
				case ERROR:
				case BLANKDOT:
				case SLOT:
				case TYPESETEXPR:
				case PERCENT:
				case PERCENTNUMBER:
				case BLANK1:
				case BLANK2:
				case BLANK3:
				case BLANKID1:
				case BLANKID2:
				case BLANKID3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				tmp=divideexpr();
				
						value = factory.appendExpr( MExpr.TIMESexpr, value, tmp);
			}
			else {
				break _loop79;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  divideexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr tmp;
		
		value=unaryplusminusexpr();
		{
		_loop82:
		do {
			if ((LA(1)==SLASH)) {
				match(SLASH);
				tmp=unaryplusminusexpr();
				
							value = factory.appendExpr( MExpr.TIMESexpr, value,  
							new MNormal( MExpr.RECIPROCALexpr, tmp)
							);
			}
			else if ((LA(1)==TYPESETDIVIDE)) {
				match(TYPESETDIVIDE);
				tmp=unaryplusminusexpr();
				
							value = new MNormal( MExpr.TYPESETDIVIDEexpr, value, tmp);
							
			}
			else {
				break _loop82;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  unaryplusminusexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  plusOperandToken = null;
		Token  minusOperandToken = null;
		
		if ((_tokenSet_0.member(LA(1)))) {
			value=dotexpr();
		}
		else if ((LA(1)==UNARYPLUS)) {
			plusOperandToken = LT(1);
			match(UNARYPLUS);
			value=unaryplusminusexpr();
			
					value = new MNormal( MExpr.PLUSexpr, value);
					value.setCharStart( (MExprToken)plusOperandToken);
					
		}
		else if ((LA(1)==UNARYMINUS)) {
			minusOperandToken = LT(1);
			match(UNARYMINUS);
			value=unaryplusminusexpr();
			
					value = new MNormal( MExpr.MINUSexpr, value);
					value.setCharStart( (MExprToken)minusOperandToken);
				
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		return value;
	}
	
	public final MExpr  dotexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e;
		
		value=noncommuteexpr();
		{
		_loop86:
		do {
			if ((LA(1)==DOT)) {
				match(DOT);
				e=noncommuteexpr();
				
							value = factory.appendExpr( MExpr.DOTexpr, value, e);
			}
			else {
				break _loop86;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  noncommuteexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e;
		
		value=powerexpr();
		{
		_loop89:
		do {
			if ((LA(1)==NONCOMMUTE)) {
				match(NONCOMMUTE);
				e=powerexpr();
				
							value = factory.appendExpr( MExpr.NONCOMMUTATIVEMULTIPLYexpr, value, e);
			}
			else {
				break _loop89;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  powerexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e;
		
		value=typesetsqrtexpr();
		{
		if ((LA(1)==CARET)) {
			match(CARET);
			e=powerexpr();
			
				 	value = new MNormal( MExpr.POWERexpr, value, e);
		}
		else if ((LA(1)==TYPESETSUPER)) {
			match(TYPESETSUPER);
			e=powerexpr();
			
				 	value = new MNormal( MExpr.TYPESETSUPERSCRIPTexpr, value, e);
		}
		else if ((_tokenSet_2.member(LA(1)))) {
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		return value;
	}
	
	public final MExpr  typesetsqrtexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  tok = null;
		
		switch ( LA(1)) {
		case TYPESETSQRT:
		{
			tok = LT(1);
			match(TYPESETSQRT);
			value=typesetsqrtexpr();
			value = new MNormal( MExpr.TYPESETSQRTexpr, value);
					 value.setCharStart( (MExprToken)tok);
			break;
		}
		case NOT:
		case NOTNOT:
		case UNARYPLUS:
		case UNARYMINUS:
		case PLUSPLUS:
		case MINUSMINUS:
		case TYPESETFULLFORM:
		case LPAREN:
		case TYPESETOPEN:
		case LBRACE:
		case ID:
		case GET:
		case INT:
		case REAL:
		case STRING:
		case POSTFIXID:
		case NULLID:
		case ERROR:
		case BLANKDOT:
		case SLOT:
		case TYPESETEXPR:
		case PERCENT:
		case PERCENTNUMBER:
		case BLANK1:
		case BLANK2:
		case BLANK3:
		case BLANKID1:
		case BLANKID2:
		case BLANKID3:
		{
			value=stringjoinexpr();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		return value;
	}
	
	public final MExpr  stringjoinexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e;
		
		value=derivativeexpr();
		{
		_loop95:
		do {
			if ((LA(1)==STRINGJOIN)) {
				match(STRINGJOIN);
				e=derivativeexpr();
				
								value = factory.appendExpr( MExpr.STRINGJOINexpr, value, e);
			}
			else {
				break _loop95;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  derivativeexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  tok1 = null;
		MExpr e;
		
		value=factorialexpr();
		{
		_loop98:
		do {
			if ((LA(1)==DERIVATIVEINFIX)) {
				tok1 = LT(1);
				match(DERIVATIVEINFIX);
				
						MNormal ef = new MNormal( MExpr.DERIVATIVE1expr, value);
						ef.setCharEnd( (MExprToken) tok1);
						putAST( tok1, ef);
				value=factorialexpr();
			}
			else {
				break _loop98;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  factorialexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  tok1 = null;
		Token  tok2 = null;
		MExpr e;
		
		value=mapexpr();
		{
		_loop103:
		do {
			if ((LA(1)==NOTINFIX)) {
				{
				tok1 = LT(1);
				match(NOTINFIX);
				
								MNormal e1 = new MNormal( MExpr.FACTORIALexpr, value);
								e1.setCharEnd( (MExprToken) tok1);
								putAST( tok1, e1);
				value=mapexpr();
				}
			}
			else if ((LA(1)==NOTNOTINFIX)) {
				{
				tok2 = LT(1);
				match(NOTNOTINFIX);
				
								MNormal e1 = new MNormal( MExpr.FACTORIAL2expr, value);
								e1.setCharEnd( (MExprToken) tok2);
								putAST( tok2, e1);
				value=mapexpr();
				}
			}
			else {
				break _loop103;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  mapexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e;
		
		value=infixfullformexpr();
		{
		if ((LA(1)==MAP)) {
			match(MAP);
			e=mapexpr();
			value = new MNormal( MExpr.MAPexpr, value, e);
		}
		else if ((LA(1)==MAPALL)) {
			match(MAPALL);
			e=mapexpr();
			value = new MNormal( MExpr.MAPALLexpr, value, e);
		}
		else if ((LA(1)==APPLY)) {
			match(APPLY);
			e=mapexpr();
			value = new MNormal( MExpr.APPLYexpr, value, e);
		}
		else if ((LA(1)==APPLYONE)) {
			match(APPLYONE);
			e=mapexpr();
			value = new MNormal( MExpr.APPLYONEexpr, value, e);
		}
		else if ((_tokenSet_2.member(LA(1)))) {
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		return value;
	}
	
	public final MExpr  infixfullformexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e1, e2;
		
		value=atfullformexpr();
		{
		_loop108:
		do {
			if ((LA(1)==INFIXFULLFORM)) {
				match(INFIXFULLFORM);
				e1=atfullformexpr();
				match(INFIXFULLFORM);
				e2=atfullformexpr();
				
								value = new MNormalSpecial( e1, value, e2);
							
			}
			else {
				break _loop108;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  atfullformexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e1;
		
		value=precrementexpr();
		{
		if ((LA(1)==ATFUN)) {
			match(ATFUN);
			e1=atfullformexpr();
			MExpr ef = new MNormal( value, e1);
					  ef.setCharStart( value.getCharStart());
					  value = ef;
		}
		else if ((_tokenSet_2.member(LA(1)))) {
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		return value;
	}
	
	public final MExpr  precrementexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  plusplusToken = null;
		Token  minusminusToken = null;
		Token  tok = null;
		
		if ((_tokenSet_3.member(LA(1)))) {
			value=postcrementexpr();
		}
		else if ((LA(1)==PLUSPLUS)) {
			plusplusToken = LT(1);
			match(PLUSPLUS);
			value=precrementexpr();
			
					value = new MNormal( MExpr.PREINCREMENTexpr, value);
					value.setCharStart( (MExprToken)plusplusToken);
					
		}
		else if ((LA(1)==MINUSMINUS)) {
			minusminusToken = LT(1);
			match(MINUSMINUS);
			value=precrementexpr();
			
					MNormal ef = new MNormal( MExpr.PREDECREMENTexpr, value);
					ef.setCharStart( (MExprToken)minusminusToken);
					value = ef;
					
		}
		else if ((LA(1)==TYPESETFULLFORM)) {
			tok = LT(1);
			match(TYPESETFULLFORM);
			value=fullformexpr();
			value = new MNormal( MExpr.TYPESETFULLFORMexpr, value);
				 value.setCharStart( (MExprToken)tok);
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		return value;
	}
	
	public final MExpr  postcrementexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  tok1 = null;
		Token  tok2 = null;
		MExpr e;
		
		value=patterntestexpr();
		{
		_loop116:
		do {
			if ((LA(1)==PLUSPLUSINFIX)) {
				{
				tok1 = LT(1);
				match(PLUSPLUSINFIX);
				
							MNormal e1 = new MNormal( MExpr.INCREMENTexpr, value);
							e1.setCharEnd( (MExprToken)tok1);
							putAST( tok1,  e1);
				value=patterntestexpr();
				}
			}
			else if ((LA(1)==MINUSMINUSINFIX)) {
				{
				tok2 = LT(1);
				match(MINUSMINUSINFIX);
				
							MNormal e1 = new MNormal( MExpr.DECREMENTexpr, value);
							e1.setCharEnd( (MExprToken)tok2);
							putAST( tok2, e1);
				value=patterntestexpr();
				}
			}
			else {
				break _loop116;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  fullformexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr head;
				MExprHeadVector args;
		
		head=parenexpr();
		factory.registerhead( head);
		args=fullformhead();
		value = factory.UnwindHead( head, args);
		return value;
	}
	
	public final MExpr  patterntestexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e;
		
		value=messagenameexpr();
		{
		if ((LA(1)==QUESTION)) {
			match(QUESTION);
			e=messagenameexpr();
			value = new MNormal( MExpr.PATTERNTESTexpr, value, e);
		}
		else if ((_tokenSet_2.member(LA(1)))) {
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		return value;
	}
	
	public final MExpr  messagenameexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		MExpr e;
		
		value=highprefix();
		{
		_loop121:
		do {
			if ((LA(1)==MESSAGENAME)) {
				match(MESSAGENAME);
				e=highprefix();
				
							if ( e instanceof MSymbol) {
								MExpr e1 = new MString( ((MSymbol)e).symbolName());
								e1.cloneCharPositions( e);
								e = e1;
							}
							value = factory.appendExpr( MExpr.MESSAGENAMEexpr, value, e);
			}
			else {
				break _loop121;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  highprefix() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  notToken = null;
		Token  notnotToken = null;
		Token  unaryminusToken = null;
		Token  unaryplusToken = null;
		Token  plusplusToken = null;
		Token  minusminusToken = null;
		
		switch ( LA(1)) {
		case NOT:
		{
			notToken = LT(1);
			match(NOT);
			value=plusminusexpr();
			
						value = new MNormal( MExpr.NOTexpr, value);
						value.setCharStart( (MExprToken) notToken);
					
			break;
		}
		case NOTNOT:
		{
			notnotToken = LT(1);
			match(NOTNOT);
			value=plusminusexpr();
			
						value = new MNormal( MExpr.NOTexpr, value);
						value.setCharStart( (MExprToken) notnotToken);
						value = new MNormal( MExpr.NOTexpr, value);
						value.setCharStart( (MExprToken) notnotToken);		
					
			break;
		}
		case UNARYMINUS:
		{
			unaryminusToken = LT(1);
			match(UNARYMINUS);
			value=dotexpr();
			
						value = new MNormal( MExpr.MINUSexpr, value);
						value.setCharStart( (MExprToken) unaryminusToken);
					
			break;
		}
		case UNARYPLUS:
		{
			unaryplusToken = LT(1);
			match(UNARYPLUS);
			value=dotexpr();
			value = new MNormal( MExpr.PLUSexpr, value);  
					  value.setCharStart( (MExprToken) unaryplusToken);
					
			break;
		}
		case PLUSPLUS:
		{
			plusplusToken = LT(1);
			match(PLUSPLUS);
			value=dotexpr();
			
						value = new MNormal( MExpr.PREINCREMENTexpr, value);  
						value.setCharStart( (MExprToken) plusplusToken);
					
			break;
		}
		case MINUSMINUS:
		{
			minusminusToken = LT(1);
			match(MINUSMINUS);
			value=dotexpr();
			
						value = new MNormal( MExpr.PREDECREMENTexpr, value); 
						value.setCharStart( (MExprToken) minusminusToken); 
					
			break;
		}
		case LPAREN:
		case TYPESETOPEN:
		case LBRACE:
		case ID:
		case GET:
		case INT:
		case REAL:
		case STRING:
		case POSTFIXID:
		case NULLID:
		case ERROR:
		case BLANKDOT:
		case SLOT:
		case TYPESETEXPR:
		case PERCENT:
		case PERCENTNUMBER:
		case BLANK1:
		case BLANK2:
		case BLANK3:
		case BLANKID1:
		case BLANKID2:
		case BLANKID3:
		{
			value=fullformexpr();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		return value;
	}
	
	public final MExpr  parenexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  leftparenToken = null;
		Token  rParenToken = null;
		Token  rightparenToken = null;
		Token  t1Token = null;
		Token  t2Token = null;
		
			int pos = input.getPosition(); 
			if (tokenReady) pos--;
			
		
		try {      // for error handling
			switch ( LA(1)) {
			case LBRACE:
			case ID:
			case GET:
			case INT:
			case REAL:
			case STRING:
			case POSTFIXID:
			case NULLID:
			case ERROR:
			case BLANKDOT:
			case SLOT:
			case TYPESETEXPR:
			case PERCENT:
			case PERCENTNUMBER:
			case BLANK1:
			case BLANK2:
			case BLANK3:
			case BLANKID1:
			case BLANKID2:
			case BLANKID3:
			{
				value=listexpr();
				break;
			}
			case LPAREN:
			{
				leftparenToken = LT(1);
				match(LPAREN);
				{
				switch ( LA(1)) {
				case RPAREN:
				{
					rParenToken = LT(1);
					match(RPAREN);
					break;
				}
				case NOT:
				case NOTNOT:
				case UNARYPLUS:
				case UNARYMINUS:
				case TYPESETSQRT:
				case PLUSPLUS:
				case MINUSMINUS:
				case TYPESETFULLFORM:
				case LPAREN:
				case TYPESETOPEN:
				case LBRACE:
				case ID:
				case GET:
				case INT:
				case REAL:
				case STRING:
				case POSTFIXID:
				case NULLID:
				case ERROR:
				case BLANKDOT:
				case SLOT:
				case TYPESETEXPR:
				case PERCENT:
				case PERCENTNUMBER:
				case BLANK1:
				case BLANK2:
				case BLANK3:
				case BLANKID1:
				case BLANKID2:
				case BLANKID3:
				{
					parenCount++;
					value=expr();
					rightparenToken = LT(1);
					match(RPAREN);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				
						{parenCount--;}
						if ( value == null) {
							if ( !input.recoverySupported()) {
								throw new NoViableAltException(rParenToken, getFilename());
							}
							value = new MOperator("ERROR_NODE");
							addError( "Empty parenthesis", leftparenToken,
								MExprParserConstants.EMPTY_PARENS,(MExprToken) leftparenToken,
								(MExprToken) rParenToken);
							rightparenToken = rParenToken;
						}
						value = new MNormal( MExpr.PARENexpr, value);  
						value.setCharStart( (MExprToken) leftparenToken);
						value.setCharEnd( (MExprToken) rightparenToken);
					
				break;
			}
			case TYPESETOPEN:
			{
				t1Token = LT(1);
				match(TYPESETOPEN);
				value=expr();
				t2Token = LT(1);
				match(TYPESETCLOSE);
				
					value = new MNormal( MExpr.TYPESETPARENexpr, value);
					value.setCharStart( (MExprToken) t1Token);
					value.setCharEnd( (MExprToken) t2Token);
					
				{
				switch ( LA(1)) {
				case TYPESETSUB:
				{
					match(TYPESETSUB);
					MExpr e1;
					e1=parenexpr();
					value = new MNormal(MExpr.TYPESETSUBSCRIPTexpr, value, e1);
					break;
				}
				case EOF:
				case PACKAGE:
				case SEMI:
				case PUT:
				case SET:
				case SETDELAYED:
				case UPSET:
				case UPSETDELAYED:
				case TAGSET:
				case UNSETINFIX:
				case SLASHFUN:
				case AMPINFIX:
				case ADDTO:
				case SUBTRACTFROM:
				case TIMESBY:
				case DIVIDEBY:
				case REPLACEALL:
				case REPLACEREPEATED:
				case RULE:
				case CONDITION:
				case STRINGEXPRESSION:
				case ALTERNATIVES:
				case REPEATEDINFIX:
				case REPEATEDNULLINFIX:
				case OR:
				case AND:
				case NOT:
				case NOTNOT:
				case SAMEQ:
				case UNSAMEQ:
				case EQUAL:
				case UNEQUAL:
				case GREATER:
				case LESS:
				case GREATEREQUAL:
				case LESSEQUAL:
				case PLUS:
				case MINUS:
				case TIMES:
				case SLASH:
				case TYPESETDIVIDE:
				case UNARYPLUS:
				case UNARYMINUS:
				case DOT:
				case NONCOMMUTE:
				case CARET:
				case TYPESETSUPER:
				case TYPESETSQRT:
				case STRINGJOIN:
				case DERIVATIVEINFIX:
				case NOTINFIX:
				case NOTNOTINFIX:
				case MAP:
				case MAPALL:
				case APPLY:
				case APPLYONE:
				case INFIXFULLFORM:
				case ATFUN:
				case PLUSPLUS:
				case MINUSMINUS:
				case TYPESETFULLFORM:
				case PLUSPLUSINFIX:
				case MINUSMINUSINFIX:
				case QUESTION:
				case MESSAGENAME:
				case LBRACKET:
				case RBRACKET:
				case COMMA:
				case LPAREN:
				case RPAREN:
				case TYPESETOPEN:
				case TYPESETCLOSE:
				case LBRACE:
				case RBRACE:
				case ID:
				case COLON:
				case GET:
				case INT:
				case REAL:
				case STRING:
				case POSTFIXID:
				case NULLID:
				case ERROR:
				case BLANKDOT:
				case SLOT:
				case TYPESETEXPR:
				case PERCENT:
				case PERCENTNUMBER:
				case BLANK1:
				case BLANK2:
				case BLANK3:
				case BLANKID1:
				case BLANKID2:
				case BLANKID3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException e) {
			
					parenCount--;
					value = handleParenError( e, value, leftparenToken, pos);
				
		}
		return value;
	}
	
	public final MExprHeadVector  fullformhead() throws RecognitionException, TokenStreamException {
		MExprHeadVector value = null;
		
		Token  lTok1 = null;
		Token  rTok1 = null;
		Token  rTok2 = null;
		Token  plTok1 = null;
		Token  prTok1 = null;
		Token  prTok2 = null;
		Token  prTok3 = null;
		Token  prTok4 = null;
		MExprHeadVector args = new MExprHeadVector();
			 MExprVector tmp = null;
			 int pos = input.getPosition(); 
			 if (tokenReady) pos--;
			 boolean bodyLen = false;
			
		
		try {      // for error handling
			{
			_loop130:
			do {
				if ((LA(1)==LBRACKET)) {
					{
					lTok1 = LT(1);
					match(LBRACKET);
					{
					switch ( LA(1)) {
					case RBRACKET:
					{
						rTok1 = LT(1);
						match(RBRACKET);
						tmp = new MExprVector( ); tmp.setCharEnd((MExprToken)rTok1); 
										args.add(tmp); value = args;
						break;
					}
					case NOT:
					case NOTNOT:
					case UNARYPLUS:
					case UNARYMINUS:
					case TYPESETSQRT:
					case PLUSPLUS:
					case MINUSMINUS:
					case TYPESETFULLFORM:
					case LPAREN:
					case TYPESETOPEN:
					case LBRACE:
					case ID:
					case GET:
					case INT:
					case REAL:
					case STRING:
					case POSTFIXID:
					case NULLID:
					case ERROR:
					case BLANKDOT:
					case SLOT:
					case TYPESETEXPR:
					case PERCENT:
					case PERCENTNUMBER:
					case BLANK1:
					case BLANK2:
					case BLANK3:
					case BLANKID1:
					case BLANKID2:
					case BLANKID3:
					{
						bracketCount++; bodyLen = true;
						tmp=commalist();
						rTok2 = LT(1);
						match(RBRACKET);
						bracketCount--; tmp.setCharEnd((MExprToken)rTok2);args.add( tmp); tmp = null; bodyLen = false; value = args ;
						break;
					}
					case LBRACKET:
					{
						{
						plTok1 = LT(1);
						match(LBRACKET);
						{
						switch ( LA(1)) {
						case RBRACKET:
						{
							prTok1 = LT(1);
							match(RBRACKET);
							prTok2 = LT(1);
							match(RBRACKET);
							bracketCount -= 2; tmp = new MExprVector(); tmp.isPart = true;  
												tmp.setCharEnd((MExprToken)prTok2);args.add(tmp); tmp = null; value = args;
							break;
						}
						case NOT:
						case NOTNOT:
						case UNARYPLUS:
						case UNARYMINUS:
						case TYPESETSQRT:
						case PLUSPLUS:
						case MINUSMINUS:
						case TYPESETFULLFORM:
						case LPAREN:
						case TYPESETOPEN:
						case LBRACE:
						case ID:
						case GET:
						case INT:
						case REAL:
						case STRING:
						case POSTFIXID:
						case NULLID:
						case ERROR:
						case BLANKDOT:
						case SLOT:
						case TYPESETEXPR:
						case PERCENT:
						case PERCENTNUMBER:
						case BLANK1:
						case BLANK2:
						case BLANK3:
						case BLANKID1:
						case BLANKID2:
						case BLANKID3:
						{
							bracketCount += 2; bodyLen = true;
							tmp=commalist();
							prTok3 = LT(1);
							match(RBRACKET);
							prTok4 = LT(1);
							match(RBRACKET);
							bracketCount -= 2; tmp.isPart = true; tmp.setCharEnd((MExprToken)prTok4);
												args.add( tmp); tmp = null; bodyLen = false; value = args ;
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						}
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					}
				}
				else {
					break _loop130;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException e) {
			
					value = handleFullFormError( e, args, tmp, lTok1, plTok1, bodyLen, pos);
				
		}
		return value;
	}
	
	public final MExprVector  commalist() throws RecognitionException, TokenStreamException {
		MExprVector value = null;
		
		MExprVector args = new MExprVector(); MExpr tmp;
		
		tmp=expr();
		args.add( tmp); value = args;
		{
		_loop133:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				tmp=expr();
				args.add( tmp); value = args;
			}
			else {
				break _loop133;
			}
			
		} while (true);
		}
		return value;
	}
	
	public final MExpr  listexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  leftBraceToken = null;
		Token  rightBraceEmptyToken = null;
		Token  rightBraceListToken = null;
		MExprVector args = null;
			int pos = input.getPosition(); 
			if (tokenReady) pos--;
			
		
		try {      // for error handling
			switch ( LA(1)) {
			case ID:
			case GET:
			case INT:
			case REAL:
			case STRING:
			case POSTFIXID:
			case NULLID:
			case ERROR:
			case BLANKDOT:
			case SLOT:
			case TYPESETEXPR:
			case PERCENT:
			case PERCENTNUMBER:
			case BLANK1:
			case BLANK2:
			case BLANK3:
			case BLANKID1:
			case BLANKID2:
			case BLANKID3:
			{
				value=patternexpr();
				break;
			}
			case LBRACE:
			{
				leftBraceToken = LT(1);
				match(LBRACE);
				braceCount++;
				{
				switch ( LA(1)) {
				case RBRACE:
				{
					rightBraceEmptyToken = LT(1);
					match(RBRACE);
					break;
				}
				case NOT:
				case NOTNOT:
				case UNARYPLUS:
				case UNARYMINUS:
				case TYPESETSQRT:
				case PLUSPLUS:
				case MINUSMINUS:
				case TYPESETFULLFORM:
				case LPAREN:
				case TYPESETOPEN:
				case LBRACE:
				case ID:
				case GET:
				case INT:
				case REAL:
				case STRING:
				case POSTFIXID:
				case NULLID:
				case ERROR:
				case BLANKDOT:
				case SLOT:
				case TYPESETEXPR:
				case PERCENT:
				case PERCENTNUMBER:
				case BLANK1:
				case BLANK2:
				case BLANK3:
				case BLANKID1:
				case BLANKID2:
				case BLANKID3:
				{
					args=commalist();
					rightBraceListToken = LT(1);
					match(RBRACE);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				
						braceCount--;
						if ( args == null) {
							value = new MNormal( MExpr.LISTexpr);
							value.setCharEnd( (MExprToken) rightBraceEmptyToken);
						}
						else {
							value = new MNormal( MExpr.LISTexpr, args);
							value.setCharEnd( (MExprToken) rightBraceListToken);
						}
						value.setCharStart( (MExprToken) leftBraceToken);
					
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException e) {
			
					braceCount--;
					value = handleListError( e, args, leftBraceToken, pos);
				
		}
		return value;
	}
	
	public final MExpr  patternexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  astId = null;
		Token  tok1 = null;
		Token  tok2 = null;
		Token  tok3 = null;
		Token  tok4 = null;
		Token  tok5 = null;
		Token  tok6 = null;
		Token  tok7 = null;
		Token  pattId = null;
		MExpr e1 = null, e2 = null, e3 = null, e4 = null, e5 = null, e6 = null; 
			int len; MExprToken tok; int pos = -1;
		
		if ((LA(1)==ID)) {
			{
			astId = LT(1);
			match(ID);
			{
			switch ( LA(1)) {
			case TYPESETSUB:
			{
				match(TYPESETSUB);
				e6=parenexpr();
				break;
			}
			case IDBLANK1:
			case IDBLANK2:
			case IDBLANK3:
			{
				{
				switch ( LA(1)) {
				case IDBLANK1:
				{
					tok1 = LT(1);
					match(IDBLANK1);
					e3 = factory.makeBlank( 1, (MExprToken)tok1);
					break;
				}
				case IDBLANK2:
				{
					tok2 = LT(1);
					match(IDBLANK2);
					e3 = factory.makeBlank( 2, (MExprToken)tok2);
					break;
				}
				case IDBLANK3:
				{
					tok3 = LT(1);
					match(IDBLANK3);
					e3 = factory.makeBlank( 3, (MExprToken)tok3);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				if ((LA(1)==COLON)) {
					match(COLON);
					e5=alternativesexpr();
				}
				else if ((_tokenSet_2.member(LA(1)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				break;
			}
			case IDBLANKDOT:
			{
				tok4 = LT(1);
				match(IDBLANKDOT);
				
									e4 = factory.makeBlank(1, (MExprToken)tok4);
									
				break;
			}
			case IDBLANKID1:
			case IDBLANKID2:
			case IDBLANKID3:
			{
				{
				switch ( LA(1)) {
				case IDBLANKID1:
				{
					tok5 = LT(1);
					match(IDBLANKID1);
					len = 1; tok = (MExprToken) tok5;
					break;
				}
				case IDBLANKID2:
				{
					tok6 = LT(1);
					match(IDBLANKID2);
					len = 2; tok = (MExprToken) tok6;
					break;
				}
				case IDBLANKID3:
				{
					tok7 = LT(1);
					match(IDBLANKID3);
					len = 3; tok = (MExprToken) tok7;
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				pattId = LT(1);
				match(ID);
				
									e3 = new MSymbol( (MExprToken) pattId);
									e3 = factory.makeBlankId( e3, len, tok);
									pos = e3.getCharEnd();
									
				{
				if ((LA(1)==COLON)) {
					match(COLON);
					e5=alternativesexpr();
				}
				else if ((_tokenSet_2.member(LA(1)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				break;
			}
			default:
				if ((LA(1)==COLON)) {
					match(COLON);
					e1=alternativesexpr();
					{
					if ((LA(1)==COLON)) {
						match(COLON);
						e2=alternativesexpr();
					}
					else if ((_tokenSet_2.member(LA(1)))) {
					}
					else {
						throw new NoViableAltException(LT(1), getFilename());
					}
					
					}
				}
				else if ((_tokenSet_2.member(LA(1)))) {
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			
						if ( e4 != null) {
							// eg a_.
							e4 = new MNormal( MExpr.PATTERNexpr,
											new MSymbol( (MExprToken)astId), e4);
							value = new MNormal(  MExpr.OPTIONALexpr, e4);
						}
						else if ( e3 != null) {
							// e5 is null means a_
							// e5 not null means a_ : 1
							value = new MNormal( MExpr.PATTERNexpr,
											new MSymbol( (MExprToken)astId), e3);
							if ( e5 == null) {
								// Make sure that the extent goes to the end of the 
								// Pattern, only for a_ 
								if ( pos > 0)
									value.setCharEnd( pos);
							}
							else {
								value = new MNormal( MExpr.OPTIONALexpr, value, e5);
							}
						}
						else if ( e6 != null) {
							// eg a \_ 
							value = new MNormal( MExpr.TYPESETSUBSCRIPTexpr, new MSymbol( (MExprToken)astId), e6);
						}
						else if ( e1 == null) {
							// eg a
							value = new MSymbol( (MExprToken)astId);
						}
						else if ( e2 == null) {
							// eg a : {}   but factory does some modifying
							value = factory.OptionalPattern( (MExprToken)astId, e1);
						}
						else {
							// eg a : {} : 6
							e1 = new MNormal( MExpr.PATTERNexpr,new MSymbol( (MExprToken)astId), e1);
							value = new MNormal( MExpr.OPTIONALexpr, e1, e2); 
						}
					
			}
		}
		else if (((LA(1) >= BLANK1 && LA(1) <= BLANKID3))) {
			value=pattern();
			{
			if ((LA(1)==COLON)) {
				match(COLON);
				e1=alternativesexpr();
			}
			else if ((_tokenSet_2.member(LA(1)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			
						if (e1 != null) 
							value = new MNormal( MExpr.OPTIONALexpr, value, e1);
					
		}
		else if (((LA(1) >= GET && LA(1) <= BLANKID3))) {
			value=getexpr();
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		return value;
	}
	
	public final MExpr  pattern() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  astBlnk1 = null;
		Token  astBlnk2 = null;
		Token  astBlnk3 = null;
		Token  tok1 = null;
		Token  tok2 = null;
		Token  tok3 = null;
		Token  pattId = null;
		int len; MExprToken tok; MExpr e1, e2;
		
		switch ( LA(1)) {
		case BLANK1:
		{
			astBlnk1 = LT(1);
			match(BLANK1);
			value = factory.makeBlank(1, (MExprToken)astBlnk1);
			break;
		}
		case BLANK2:
		{
			astBlnk2 = LT(1);
			match(BLANK2);
			value = factory.makeBlank(2, (MExprToken)astBlnk2);
			break;
		}
		case BLANK3:
		{
			astBlnk3 = LT(1);
			match(BLANK3);
			value = factory.makeBlank(3, (MExprToken)astBlnk3);
			break;
		}
		case BLANKID1:
		case BLANKID2:
		case BLANKID3:
		{
			{
			{
			switch ( LA(1)) {
			case BLANKID1:
			{
				tok1 = LT(1);
				match(BLANKID1);
				len = 1; tok = (MExprToken) tok1;
				break;
			}
			case BLANKID2:
			{
				tok2 = LT(1);
				match(BLANKID2);
				len = 2; tok = (MExprToken) tok2;
				break;
			}
			case BLANKID3:
			{
				tok3 = LT(1);
				match(BLANKID3);
				len = 3; tok = (MExprToken) tok3;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			pattId = LT(1);
			match(ID);
			
						e1 = new MSymbol( (MExprToken) pattId);
						value = factory.makeBlankId( e1, len, tok);
					
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		return value;
	}
	
	public final MExpr  getexpr() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  g = null;
		MExpr e1, e2;
		
		switch ( LA(1)) {
		case GET:
		{
			g = LT(1);
			match(GET);
			
					value = new MNormal( MExpr.GETexpr, 
						new MString(g.getText().substring(2)));
					value.setCharPositions( (MExprToken)g);
				
			break;
		}
		case INT:
		case REAL:
		case STRING:
		case POSTFIXID:
		case NULLID:
		case ERROR:
		case BLANKDOT:
		case SLOT:
		case TYPESETEXPR:
		case PERCENT:
		case PERCENTNUMBER:
		case BLANK1:
		case BLANK2:
		case BLANK3:
		case BLANKID1:
		case BLANKID2:
		case BLANKID3:
		{
			value=atom();
			{
			switch ( LA(1)) {
			case TYPESETSUB:
			{
				match(TYPESETSUB);
				e1=parenexpr();
				
						value = new MNormal( MExpr.TYPESETSUBSCRIPTexpr, value, e1);	
						
				break;
			}
			case EOF:
			case PACKAGE:
			case SEMI:
			case PUT:
			case SET:
			case SETDELAYED:
			case UPSET:
			case UPSETDELAYED:
			case TAGSET:
			case UNSETINFIX:
			case SLASHFUN:
			case AMPINFIX:
			case ADDTO:
			case SUBTRACTFROM:
			case TIMESBY:
			case DIVIDEBY:
			case REPLACEALL:
			case REPLACEREPEATED:
			case RULE:
			case CONDITION:
			case STRINGEXPRESSION:
			case ALTERNATIVES:
			case REPEATEDINFIX:
			case REPEATEDNULLINFIX:
			case OR:
			case AND:
			case NOT:
			case NOTNOT:
			case SAMEQ:
			case UNSAMEQ:
			case EQUAL:
			case UNEQUAL:
			case GREATER:
			case LESS:
			case GREATEREQUAL:
			case LESSEQUAL:
			case PLUS:
			case MINUS:
			case TIMES:
			case SLASH:
			case TYPESETDIVIDE:
			case UNARYPLUS:
			case UNARYMINUS:
			case DOT:
			case NONCOMMUTE:
			case CARET:
			case TYPESETSUPER:
			case TYPESETSQRT:
			case STRINGJOIN:
			case DERIVATIVEINFIX:
			case NOTINFIX:
			case NOTNOTINFIX:
			case MAP:
			case MAPALL:
			case APPLY:
			case APPLYONE:
			case INFIXFULLFORM:
			case ATFUN:
			case PLUSPLUS:
			case MINUSMINUS:
			case TYPESETFULLFORM:
			case PLUSPLUSINFIX:
			case MINUSMINUSINFIX:
			case QUESTION:
			case MESSAGENAME:
			case LBRACKET:
			case RBRACKET:
			case COMMA:
			case LPAREN:
			case RPAREN:
			case TYPESETOPEN:
			case TYPESETCLOSE:
			case LBRACE:
			case RBRACE:
			case ID:
			case COLON:
			case GET:
			case INT:
			case REAL:
			case STRING:
			case POSTFIXID:
			case NULLID:
			case ERROR:
			case BLANKDOT:
			case SLOT:
			case TYPESETEXPR:
			case PERCENT:
			case PERCENTNUMBER:
			case BLANK1:
			case BLANK2:
			case BLANK3:
			case BLANKID1:
			case BLANKID2:
			case BLANKID3:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		return value;
	}
	
	public final MExpr  atom() throws RecognitionException, TokenStreamException {
		MExpr value = null;
		
		Token  astInt = null;
		Token  astReal = null;
		Token  astStr = null;
		Token  postId = null;
		Token  nullId = null;
		Token  error = null;
		Token  blankDot = null;
		Token  slot = null;
		Token  tok = null;
		Token  tok1 = null;
		Token  outtok = null;
		MExpr e1, e2;
		
		switch ( LA(1)) {
		case INT:
		{
			astInt = LT(1);
			match(INT);
			value = new MInteger( (MExprToken)astInt);
			break;
		}
		case REAL:
		{
			astReal = LT(1);
			match(REAL);
			value = new MReal((MExprToken)astReal);
			break;
		}
		case STRING:
		{
			astStr = LT(1);
			match(STRING);
			value = factory.makeStringChars( (MExprToken)astStr);
			break;
		}
		case POSTFIXID:
		{
			postId = LT(1);
			match(POSTFIXID);
			value = getAST( postId);
			break;
		}
		case NULLID:
		{
			nullId = LT(1);
			match(NULLID);
			value = new MOperator( "Null");
			break;
		}
		case ERROR:
		{
			error = LT(1);
			match(ERROR);
			
					addError("Token error", error, MExprParserConstants.TOKEN_ERROR, (MExprToken)error,(MExprToken)error);
					value = new MOperator("ERROR_NODE");
				
			break;
		}
		case BLANKDOT:
		{
			blankDot = LT(1);
			match(BLANKDOT);
			
					value = factory.makeBlank(1, (MExprToken)blankDot);
					value = new MNormal( MExpr.OPTIONALexpr, value);
					
			break;
		}
		case SLOT:
		{
			slot = LT(1);
			match(SLOT);
			
					value = factory.makeSlot((MExprToken)slot);	
					
			break;
		}
		case TYPESETEXPR:
		{
			tok = LT(1);
			match(TYPESETEXPR);
			value = new MTypeset( tok.getText());
			break;
		}
		case PERCENT:
		{
			tok1 = LT(1);
			match(PERCENT);
			value = new MNormal( MExpr.OUTexpr); value.setCharPositions((IMExprToken)tok1);
			break;
		}
		case PERCENTNUMBER:
		{
			outtok = LT(1);
			match(PERCENTNUMBER);
			value = factory.makeOutNumber((IMExprToken)outtok);
			break;
		}
		case BLANK1:
		case BLANK2:
		case BLANK3:
		case BLANKID1:
		case BLANKID2:
		case BLANKID3:
		{
			value=pattern();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		return value;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"PACKAGE",
		"SEMI",
		"PUT",
		"SET",
		"SETDELAYED",
		"UPSET",
		"UPSETDELAYED",
		"TAGSET",
		"UNSETINFIX",
		"SLASHFUN",
		"AMPINFIX",
		"ADDTO",
		"SUBTRACTFROM",
		"TIMESBY",
		"DIVIDEBY",
		"REPLACEALL",
		"REPLACEREPEATED",
		"RULE",
		"CONDITION",
		"STRINGEXPRESSION",
		"ALTERNATIVES",
		"REPEATEDINFIX",
		"REPEATEDNULLINFIX",
		"OR",
		"AND",
		"NOT",
		"NOTNOT",
		"SAMEQ",
		"UNSAMEQ",
		"EQUAL",
		"UNEQUAL",
		"GREATER",
		"LESS",
		"GREATEREQUAL",
		"LESSEQUAL",
		"PLUS",
		"MINUS",
		"TIMES",
		"SLASH",
		"TYPESETDIVIDE",
		"UNARYPLUS",
		"UNARYMINUS",
		"DOT",
		"NONCOMMUTE",
		"CARET",
		"TYPESETSUPER",
		"TYPESETSQRT",
		"STRINGJOIN",
		"DERIVATIVEINFIX",
		"NOTINFIX",
		"NOTNOTINFIX",
		"MAP",
		"MAPALL",
		"APPLY",
		"APPLYONE",
		"INFIXFULLFORM",
		"ATFUN",
		"PLUSPLUS",
		"MINUSMINUS",
		"TYPESETFULLFORM",
		"PLUSPLUSINFIX",
		"MINUSMINUSINFIX",
		"QUESTION",
		"MESSAGENAME",
		"LBRACKET",
		"RBRACKET",
		"COMMA",
		"LPAREN",
		"RPAREN",
		"TYPESETOPEN",
		"TYPESETCLOSE",
		"TYPESETSUB",
		"LBRACE",
		"RBRACE",
		"ID",
		"COLON",
		"IDBLANK1",
		"IDBLANK2",
		"IDBLANK3",
		"IDBLANKDOT",
		"IDBLANKID1",
		"IDBLANKID2",
		"IDBLANKID3",
		"GET",
		"INT",
		"REAL",
		"STRING",
		"POSTFIXID",
		"NULLID",
		"ERROR",
		"BLANKDOT",
		"SLOT",
		"TYPESETEXPR",
		"PERCENT",
		"PERCENTNUMBER",
		"BLANK1",
		"BLANK2",
		"BLANK3",
		"BLANKID1",
		"BLANKID2",
		"BLANKID3",
		"DERIVATIVE",
		"SLASH_START",
		"EQUAL_START",
		"EQUALEXCLAM",
		"UNSET",
		"AT_START",
		"PLUS_START",
		"MINUS_START",
		"EXCLAM",
		"EXCLAM2",
		"EXCLAM_START",
		"COLON_START",
		"CARET_START",
		"GREATER_START",
		"LESS_START",
		"AMP_START",
		"AMP",
		"BAR_START",
		"TILDE_START",
		"STAR_START",
		"WHITESPACE",
		"COMMENT",
		"INT_REAL_DOT",
		"DOT_START",
		"REPEATED",
		"REPEATEDNULL",
		"BLANK",
		"IDUNICODESTART",
		"LONGNAME",
		"BACKSLASH_START",
		"BACKSLASHBRACKET",
		"TYPESETSPACE",
		"DUMMYID"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { -2304664331138105344L, 2199014888064L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { -2304662132114849792L, 2199014888064L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { -14L, 2199014930431L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 6917581805809827840L, 2199014888064L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	
	}
