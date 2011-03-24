package com.wolfram.mexprparser;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import antlr.RecognitionException;
import antlr.Token;
import antlr.TokenStreamException;

import com.wolfram.mexpr.MExpr;

/*
 * 
 * Class for generating Exprs from various input 
 * streams.  This parser stores the intermediate 
 * token stream.
 */

public class MExprTokenParser {

	List tokens_;
	Reader reader_;
	ErrorListener listener_ = null;
	boolean parseError_;
	
	/*
	 * Sets the input for the parser.
	 */
	public void setInput( String text) {
		setInput( new StringReader( text));
	}

	/*
	 * Sets the input for the parser.
	 */
	public void setInput( Reader reader) {
		reader = MExprParserUtilities.checkReaderForEncoding( reader);
	   	tokens_ = new ArrayList();
    	reader_= reader;
	}
	
	/*
	 * Sets the error listener.
	 */
	public void setErrorListener( ErrorListener listener) {
		listener_ = listener;
	}
	
	
	/*
	 * Sets the input and generates an AST.
	 */
	public MExpr parse( String text) {
		setInput( text);
		generateTokens();
		return generateMExpr();
	}
	
	/*
	 * Sets the input and generates an AST.
	 */
	public MExpr parse( Reader inp) {
		setInput( inp);
		generateTokens();
		return generateMExpr();
	}
	
	
	/*
	 * Generates Tokens for the input.
	 */
	public List generateTokens() {
    	MExprANTLRLexer lexer = new MExprANTLRLexer( reader_);
		lexer.setLexer(reader_);
		MExprTokenStream tokStm = new MExprTokenStream(lexer, true);
        // parse
        MExprToken tok = null;
        int tokType;
        try {
        	do{
        		tok = (MExprToken)tokStm.nextToken();
				tokType = tok.getType(); 
				tokens_.add(tok);
				// TODO: this might not work for all things
			} while(tokType != Token.EOF_TYPE);
		} catch (TokenStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tokens_;
	}

	/*
	 * returns the token list
	 */
	public List getTokenList()
	{
		return tokens_;
	}
	
	/*
	 * sets the token list
	 */
	public void  setTokenList(List tokens)
	{
		tokens_ = tokens;
	}
	
	/*
	 * Runs the parser on the token list.
	 */
	public MExpr generateMExpr( ) {
		TokenStreamToListAdapter storedStream = new TokenStreamToListAdapter(tokens_);
		MExprANTLRParser parser = new MExprANTLRParser(storedStream);
		parser.setErrorListener( listener_);
		parser.setParser(storedStream);

		try {
			MExpr res = parser.topexpr();
			parseError_ = parser.isParseError();
			return res;
		} catch (RecognitionException e) {
			
			e.printStackTrace();
		} catch (TokenStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parseError_ = true;
		return null;		
	}
	
	/*
	 * Gets the start position of an AST node.
	 */
	public int getCharStart(MExpr node){
		int index = node.getCharStart(); 
		if ( index < 0)
			return -1;
		MExprToken tok = (MExprToken)tokens_.get(index);
		return tok.getCharStart();
	}
	
	/*
	 * Gets the end position of an AST node.
	 */
	public int getCharEnd(MExpr node){
		int index = node.getCharEnd(); 
		if ( index < 0)
			return -1;
		MExprToken tok = (MExprToken)tokens_.get(index);
		return tok.getCharEnd();
	}
	
	public boolean isParseError() {
	    	return parseError_;
	}
		
}
