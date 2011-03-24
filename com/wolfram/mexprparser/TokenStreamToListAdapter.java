package com.wolfram.mexprparser;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import antlr.Token;
import antlr.TokenStreamException;

public class TokenStreamToListAdapter implements 
		TokenStreamRecoverer {
	private int count = 0;

	Hashtable extraTokens;
	
	// NOTE: the new ArrayList element just avoids NullPointerExceptions in case
	// someone accesses
	// tokens_ in non-incremental mode
	private List tokens_ = new ArrayList(1);

	/**
	 * 
	 * @param tokens
	 *            must be List of ExprTokens
	 */
	public TokenStreamToListAdapter(List tokens) {
		this.tokens_ = tokens;
		extraTokens = null;
	}

	
	public Token nextToken() throws TokenStreamException {
		
		Token tok = nextTokenWorker();
		while ( tok.getType() == MExprANTLRParserTokenTypes.COMMENT) {
			tok = nextTokenWorker();
		}
		return tok;
	}
	
	Token nextTokenWorker() throws TokenStreamException {
		
		if ( extraTokens != null) {
			TokenHolder h = (TokenHolder)extraTokens.get( new Integer( count));
			if ( h != null) {
				return h.getToken();
			}
		}
		
		if (count < tokens_.size()) {
			Token retValue = (Token) tokens_.get(count++);
			return retValue;
		} else {
			if ( count == 0) {
				return null;
			}
			// return the last token
			return (Token) tokens_.get( tokens_.size()-1);
		}
	}
	
	public Token lastToken() {
		if ( count < 2)
			return null;

		if ( extraTokens != null) {
			TokenHolder h = (TokenHolder)extraTokens.get( new Integer( count-2));
			if ( h != null) {
				return h.getLastToken();
			}
		}

		return (Token)tokens_.get( count-2);
	}
	
	public Token makeToken( int tokID, String text) {

        MExprToken token = new MExprToken();
		token.setType( tokID);
		token.setText( text);

		return token;
	}
	
	public void insertToken( Token extra) {
		if ( extraTokens == null) {
			extraTokens = new Hashtable();
		}
		int pos = count-1;
		extraTokens.put( new Integer( pos), new TokenHolder( extra, (Token)tokens_.get( pos)));
	}

	public void replaceToken( Token extra) {
		if ( extraTokens == null) {
			extraTokens = new Hashtable();
		}
		int pos = count-1;
		extraTokens.put( new Integer( pos), new TokenHolder( extra));
	}

	public void dropToken() {
		if ( extraTokens == null) {
			extraTokens = new Hashtable();
		}
		int pos = count-1;
		extraTokens.put( new Integer( pos), new TokenHolder());
	}
	
	public int getPosition() {
		return count;
	}
	
	public void setPosition( int pos) {
		count = pos;
	}
	
	public boolean recoverySupported() {
		return true;
	}
	
	public boolean unmodifiedToken() {
		if ( extraTokens == null) {
			return true;
		}
		int pos = count-1;
		return extraTokens.get( new Integer( pos)) == null;
	}
	
	class TokenHolder
	{
		Token token1;
		Token token2;
		boolean firstQ;
		boolean dropToken;
		
		TokenHolder() {
			dropToken = true;
		}
		
		TokenHolder( Token t1, Token t2) {
			token1 = t1;
			token2 = t2;
			firstQ = true;
			dropToken = false;
		}
		
		TokenHolder( Token t1) {
			token1 = t1;
			token2 = null;
			firstQ = true;
			dropToken = false;
		}
		
		
		Token getToken( ) { 
			if ( dropToken) {
				Hashtable toks = extraTokens;
				extraTokens = null;
				Token res = null;
				try {
					count++;
					res = nextToken();
				} catch (TokenStreamException e) {
				}
				extraTokens = toks;
				return res;
			}

			if (token2 == null) {
				count++;
				return token1;
			}
			
			if (firstQ) {
				firstQ = false;
				return token1;
			}
			count++;
			firstQ = true;
			return token2;
		}
		
		Token getLastToken( ) { 
			if (dropToken) {
				return (Token) tokens_.get(count-1);
			}
			return token2;
		}
		
	}
	
}
