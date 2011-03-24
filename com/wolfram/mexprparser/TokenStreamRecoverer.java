package com.wolfram.mexprparser;

import antlr.Token;
import antlr.TokenStream;


public interface TokenStreamRecoverer extends TokenStream {
	
	public Token lastToken();
	
	public Token makeToken( int type, String text);
	
	public void insertToken( Token tok);
	
	public void dropToken( );
	
	public void replaceToken( Token tok);
	
	public void setPosition(int pos);
	
	public int getPosition();
	
	public boolean recoverySupported();

	public boolean unmodifiedToken();
}
