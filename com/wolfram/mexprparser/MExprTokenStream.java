/*
 * Created on Dec 11, 2004
 * Window - Preferences - Java - Code Style - Code Templates
 */

/*
 * TODO
 * 
 * Think through the way that Package tokens are introduced.
 * 
 * At the moment a Package token can be introduced by a comment 
 * token following an expr (with sufficient white space). This is 
 * necessary to get tokens that are ordered correctly with space 
 * information,  which is necessary for any form of searching 
 * through the token list.
 * 
 * However, it introduces a complication in that a Package token 
 * might not be followed by an expr.
 * 
 * This could be thought through better.  Perhaps only triggering 
 * Package tokens on exprs,  but checking the token list to look 
 * at the last token to see what offset to use for the Package token.
 * This might involve switching the Package token with the comment.
 * Another complication would be to use any return chars from a 
 * comment.
 * 
 * Soon I might want to allow the incremental parser to introduce 
 * new package tokens and this would probably require return tokens 
 * to be introduced. This will be a good time to revist and fix.
 * 
 */


package com.wolfram.mexprparser;

import java.util.Stack;

import antlr.Token;
import antlr.TokenStream;
import antlr.TokenStreamException;

/**
 * @author twj Preferences - Java - Code Style - Code Templates
 */
public class MExprTokenStream implements TokenStreamRecoverer
{
    protected TokenStream input;

    protected Token lastExprToken = null;

    int nestingLevel = 0;
    
    //If we are storing the token list
    boolean tokenIndexStore_ = false;
    
    boolean fTypesetParse = false;

    public MExprTokenStream() {
    	this( null, false);
    }

    
    public MExprTokenStream(TokenStream input) {
        this( input, false);
    }
    
    public MExprTokenStream(TokenStream input, boolean tokenIndexStore) {
        this.input = input;
        tokenIndexStore_ = tokenIndexStore;
    }
    
    public void setTypesetParse( boolean typesetParse) {
    	fTypesetParse = typesetParse;
    }

    Stack tokenStack = new Stack();

    int inserted = 0;

    
    // LOCATION: added this 
	private int currTokenIndex_ = 0;

    Token getNextToken() throws TokenStreamException
    {
        if (tokenStack.isEmpty())
            return input.nextToken();

        return (Token) tokenStack.pop();
    }

    void pushToken(Token token)
    {
        tokenStack.push(token);
    }

    /*
     * Return the string of a generated/inserted token.
     */
    String makeInsertedText(String base)
    {
        inserted++;

        return base + ":" + Integer.toString(inserted);
    }

    /*
     * Filter the token stream. We strip comments and whitespace here. If we
     * did'nt we would need to make sure that the lastToken was set correctly.
     * 
     * We also put in some fixes for minus/plus. If the last token could finish
     * an expr then we should use unary minus/plus. If the last token is an
     * infix token with higher precedence than unary minus/plus we need to
     * insert a token with higher precedence
     */
    public Token nextToken() throws TokenStreamException
    {
        Token token = null;
        int type;

        int returnCount = 0;
        /*
         * First skip over whitespace/comments
         */
        do {
            token = getNextToken();
            type = token.getType();

            if (type == MExprANTLRParserTokenTypes.WHITESPACE) {
                if ("\n".equals(token.getText()))
                    returnCount++;
            }
            
            
         } while ((!tokenIndexStore_ && type == MExprANTLRParserTokenTypes.COMMENT)
                || type == MExprANTLRParserTokenTypes.WHITESPACE 
                || fTypesetParse && whiteSpaceTypeset(token));

        /*
         * Now check for semi as the last token.
         */
        if (lastExprToken != null
                && lastExprToken.getType() == MExprANTLRParserTokenTypes.SEMI)
            token = fixSEMI(token, returnCount > 0 && nestingLevel == 0);

         boolean incrementNestingLevel = false;
         int lastNestingLevel = nestingLevel;
        /*
         * Now fix up individual tokens.
         */
        switch (token.getType()) {
        	case MExprANTLRParserTokenTypes.LONGNAME:
        		token = fixLongName( token);
        		break;
        
            case MExprANTLRParserTokenTypes.MINUS:
                if (!tokenCanEnd(lastExprToken) || tokenIsPrefix(lastExprToken))
                    token.setType(MExprANTLRParserTokenTypes.UNARYMINUS);
                break;

            case MExprANTLRParserTokenTypes.PLUS:
                if (!tokenCanEnd(lastExprToken) || tokenIsPrefix(lastExprToken))
                    token.setType(MExprANTLRParserTokenTypes.UNARYPLUS);
                break;

            case MExprANTLRParserTokenTypes.AMP:
                token = fixPostfix("AMPXX", MExprANTLRParserTokenTypes.AMPINFIX,
                        token);
                break;

            case MExprANTLRParserTokenTypes.DERIVATIVE:
                token = fixPostfix("DERIVATIVEXX", MExprANTLRParserTokenTypes.DERIVATIVEINFIX,
                        token);
                break;

            case MExprANTLRParserTokenTypes.SET:
                token = fixSET(token);
                break;

             case MExprANTLRParserTokenTypes.REPEATED:
                token = fixPostfix("REPEATEDXX", MExprANTLRParserTokenTypes.REPEATEDINFIX,
                        token);
                break;

            case MExprANTLRParserTokenTypes.REPEATEDNULL:
                token = fixPostfix("REPEATEDNULLXX", MExprANTLRParserTokenTypes.REPEATEDNULLINFIX,
                        token);
                break;

	/*
	 * Convert EXCLAM into prefix NOT or postfix FACTORIAL.
	 * 
	 * Turns into NOT if lastToken is an infix or a prefix.
	 * If lastToken can end or is not a prefix becomes NOT
	 * a + !b,    + ! a,  
	 * 
     * Also if last token can end and we have returnCount/lastNestingLevel
     * set then we will be inserting a PACKAGE token and this will become 
     * NOT,  so the real test is (a + b) || !a || !c which equals b || !a || !c
     */
            case MExprANTLRParserTokenTypes.EXCLAM:
                if ((returnCount > 0 && lastNestingLevel <= 0) || !tokenCanEnd(lastExprToken) || tokenIsPrefix( lastExprToken)) {
                    token.setType(MExprANTLRParserTokenTypes.NOT);
                }
                else {
                	token = fixPostfix("EXCLAM", MExprANTLRParserTokenTypes.NOTINFIX,
                        token);
                }
                break;
  
      /*
       * See EXCLAM
       */
            case MExprANTLRParserTokenTypes.EXCLAM2:
                if ((returnCount > 0 && lastNestingLevel <= 0) || !tokenCanEnd(lastExprToken) || tokenIsPrefix(lastExprToken)) {
                    token.setType(MExprANTLRParserTokenTypes.NOTNOT);
                }
                else {
                	token = fixPostfix("EXCLAM2", MExprANTLRParserTokenTypes.NOTNOTINFIX,
                        token);
                }
                break;
                

            case MExprANTLRParserTokenTypes.PLUSPLUS:
                if (tokenCanEnd(lastExprToken) && !tokenIsPrefix(lastExprToken))
                    token = fixPostfix("PLUSPLUSXX", MExprANTLRParserTokenTypes.PLUSPLUSINFIX,
                            token);
                break;
                
            case MExprANTLRParserTokenTypes.MINUSMINUS:
                if (tokenCanEnd(lastExprToken) && !tokenIsPrefix(lastExprToken))
                    token = fixPostfix("MINUSMINUSXX", MExprANTLRParserTokenTypes.MINUSMINUSINFIX,
                            token);
                break;

            case MExprANTLRParserTokenTypes.COMMA:
                token = fixThisComma(token);
                break;


            case MExprANTLRParserTokenTypes.LPAREN:
            case MExprANTLRParserTokenTypes.LBRACE:
            case MExprANTLRParserTokenTypes.LBRACKET:
            	incrementNestingLevel = true;
                break;

                
            case MExprANTLRParserTokenTypes.RPAREN:
                nestingLevel--;
            	break;

            case MExprANTLRParserTokenTypes.RBRACE:
            case MExprANTLRParserTokenTypes.RBRACKET:
            	token = fixLastComma( token);
            	if ( token.getType() != MExprANTLRParserTokenTypes.NULLID)
            		nestingLevel--;
        		break;
           
            case MExprANTLRParserTokenTypes.ID:
                token = fixID( token);
            	break;
  
            case MExprANTLRParserTokenTypes.BLANK1:
            case MExprANTLRParserTokenTypes.BLANK2:
            case MExprANTLRParserTokenTypes.BLANK3:
                token = fixBLANK( token);
            	break;

            case MExprANTLRParserTokenTypes.EQUALEXCLAM:
            	token = fixEQUALEXCLAM( token);
            	break;

            case MExprANTLRParserTokenTypes.TYPESETOPEN:
                token = fixTypesetOpen(token);
                break;

            case MExprANTLRParserTokenTypes.TYPESETSPACE:
                return nextToken();

        }

        /*
         * The test for Comment is here because tokenCanStart does not 
         * return True for Comment (this would mess up all sorts of 
         * other things).
         * 
         * If this changes see EXCLAM
         */
        if (returnCount > 0 && lastNestingLevel <= 0 && tokenCanEnd(lastExprToken)
                //&& (tokenCanStart(token) || 
                //		token.getType() == MExprANTLRParserTokenTypes.COMMENT)
                ) {
            pushToken(token);
            int lim = getLimit( lastExprToken, token);
            token = makeToken(MExprANTLRParserTokenTypes.PACKAGE, "Package", lastExprToken);
            setLimit( token, lim);
            nestingLevel = 0;
        }
        else if ( incrementNestingLevel) {
        	nestingLevel++;
        }
        
        if ( token.getType() != MExprANTLRParserTokenTypes.COMMENT) {
        	lastExprToken = token;
        }
        
//		// LOCATION: added this
        // this must happen here instead of the ExprLexer because this TokenStream
        // changes the token count;
        if ( tokenIndexStore_)
        	((MExprToken)token).tokenIndex_ = currTokenIndex_++;
        else
        	((MExprToken)token).tokenIndex_ = -1;
        return token;
    }

    /*
     * Set the limits on the token.
     */
    void setLimit( Token t, int limit) {
       	MExprToken tok = (MExprToken)t;
       	tok.charEnd = limit;
       	tok.charStart = limit;
    }
    
    /*
     * Get a limit to be after lastExprToken and before token
     */
    int getLimit( Token t1, Token t2) 
    {
       	MExprToken lastToken = (MExprToken)t1;
       	MExprToken nextToken = (MExprToken)t2;
       	
       	int end = lastToken.getCharEnd();
       	int start = nextToken.getCharStart();
       	
       	if ( end+1 < start) {
       		return end+1;
       	}
       	/*
       	 * I can't see how this can happen, but this is not terrible.
       	 */
       return end;
    }

    Token makeToken(int type, String text, Token old)
    {
        MExprToken oldtoken = (MExprToken) old;
        
        MExprToken token = new MExprToken();
		token.setType( type);
		token.charStart = oldtoken.getCharStart();
		token.charEnd = oldtoken.getCharEnd();
//		// LOCATION: added this 
//		token.tokenIndex_ = currTokenIndex_++;

        token.setColumn(old.getColumn());
        token.setLine(old.getLine());
//        token.setColumn(old.getColumn());
//        token.setColumn(old.getColumn());
        token.setText( text);

        return token;
    }

    
    /*
     * A BLANK token may be immediately followed by ID. 
     * If so then adjust to BLANKID token.
     */
    
    Token fixBLANK( Token token) throws TokenStreamException
    {
        Token next = getNextToken();
        pushToken( next);
       
        if ( next.getType() != MExprANTLRParserTokenTypes.ID) {
            return token;
        }
        
        //So this ID does not form another 
        ((MExprToken)next).fixedID = true;
        
        int newType = 0;
        switch ( token.getType()) {
            case MExprANTLRParserTokenTypes.BLANK1:
                newType = MExprANTLRParserTokenTypes.BLANKID1;
            	break;
            
            case MExprANTLRParserTokenTypes.BLANK2:
                newType = MExprANTLRParserTokenTypes.BLANKID2;
            	break;
            
            case MExprANTLRParserTokenTypes.BLANK3:
                newType = MExprANTLRParserTokenTypes.BLANKID3;
            	break;
        }
  
        token.setType( newType);
         
        return token;
    }
        
    Token fixEQUALEXCLAM( Token token) throws TokenStreamException
    {
    	MExprToken setToken = (MExprToken)makeToken(MExprANTLRParserTokenTypes.SET, 
        						"=", token);
    	MExprToken exclamToken = (MExprToken)makeToken(MExprANTLRParserTokenTypes.NOT, 
        						"!", token);
    	setToken.charEnd--;
        exclamToken.charStart++;
        pushToken( exclamToken);
        return setToken;
    }
    
        
    /*
     * An ID token may be immediately followed by _, _., __, ___, _ ID, __ ID or ___ ID, 
     * if it is then adjust accordingly.  Also make sure that the ID does 
     * not end in `.
     */
    
    Token fixID( Token token) throws TokenStreamException
    {
        String text = token.getText();
        if ( text.endsWith( "`")) {
        	token.setType( MExprANTLRParserTokenTypes.ERROR);
        	return token;
        }
        
        //This ID has already been used in one pattern
        if ( ((MExprToken)token).fixedID) {
            return token;
        }
        Token next = getNextToken();
        int type = next.getType();
        int newType = 0;
        switch ( type) {
            case MExprANTLRParserTokenTypes.BLANKDOT:
                newType = MExprANTLRParserTokenTypes.IDBLANKDOT;
            	break;
            
            case MExprANTLRParserTokenTypes.BLANK1:
                newType = MExprANTLRParserTokenTypes.IDBLANK1;
            	break;
            
            case MExprANTLRParserTokenTypes.BLANK2:
                newType = MExprANTLRParserTokenTypes.IDBLANK2;
            	break;
            
            case MExprANTLRParserTokenTypes.BLANK3:
                newType = MExprANTLRParserTokenTypes.IDBLANK3;
            	break;
            
            default:
                pushToken( next);
            	return token;
        }
        
        next.setType( newType);
        
        if ( type == MExprANTLRParserTokenTypes.BLANKDOT) {
            pushToken( next);
            return token;
        }
        
        Token next1 = getNextToken();
        if ( next1.getType() != MExprANTLRParserTokenTypes.ID) {
             pushToken( next1);
             pushToken( next);
           return token;
        }
        
        //So this ID does not form another 
        ((MExprToken)next1).fixedID = true;
        switch ( type) {
            case MExprANTLRParserTokenTypes.BLANK1:
                newType = MExprANTLRParserTokenTypes.IDBLANKID1;
            	break;
            
            case MExprANTLRParserTokenTypes.BLANK2:
                newType = MExprANTLRParserTokenTypes.IDBLANKID2;
            	break;
            
            case MExprANTLRParserTokenTypes.BLANK3:
                newType = MExprANTLRParserTokenTypes.IDBLANKID3;
            	break;
        }
        
        next.setType( newType);
        pushToken( next1);
        pushToken( next);
       
        return token;
     }
    
    /*
     * Fix an AMP token, if this is followed by anything that is not an end
     * operator such as ')' or an operator of lower precedence then change to an
     * AMPINFIX and insert an AMPID operator.  Old comment...
     * 
     * Postfix operators need special treatment to avoid terminating the parse.
     * Something like a& ^ b where ^ is higher precedence than & needs to call 
     * up the parse function chain,  but this is hard since we are now coming 
     * down the chain.  Eg a^b& parses to Function[ Power[a,b]],  which works 
     * since power is higher up the parse chain function.  But we want a& ^ b 
     * to parse to Power[ Function[a], b],  ie the power is lower, but this 
     * is problematic since power is higher up the chain.
     * 
     * The solution is to insert a POSTFIXID token, a token which has very 
     * high precedence (that of an ID).  This is parsed at the top of the 
     * chain, making sure that any operators higher than & get dealt with. 
     * The actual expr that results from Function[a] is stored in a hashtable.
     * 
     * This seems very awkward,  perhaps there is a neater way to process this 
     * when working with LL parsers.
     * 
     */

    Token fixPostfix(String baseName, int type, Token token)
            throws TokenStreamException
    {
        Token newToken = null, testToken;

        String text = makeInsertedText(baseName);
        newToken = makeToken(type, text, token);
        testToken = makeToken(MExprANTLRParserTokenTypes.POSTFIXID, text, token);
        pushToken(testToken);

        return newToken;
    }

    /*
     * token is following a SEMI token. If token is something that can start an
     * expr and we've not passed over several returns then return token. 
     * If not then push token back, create a NullToken and return it.
     * 
     * If we are at the end of the file don't put in a package token
     */

    Token fixSEMI(Token token, boolean retEnd) throws TokenStreamException
    {
        Token nullToken;
        int type;
        Token testToken = token;
        
        if ( !retEnd && testToken.getType() == MExprANTLRParserTokenTypes.COMMENT) {
        	Stack tmp = new Stack();
        	Token token1;
            do {
                token1 = getNextToken();
                type = token1.getType();                
                tmp.push( token1);
             } while (type == MExprANTLRParserTokenTypes.COMMENT
                    || type == MExprANTLRParserTokenTypes.WHITESPACE 
                    || fTypesetParse && whiteSpaceTypeset(token1));
            
            while( !tmp.empty()) {
            	pushToken( (Token)tmp.pop());
            }
            
            if (tokenCanStart(token1) && !retEnd) {
                return token;
            }
           
        }
        
        if (tokenCanStart(testToken) && !retEnd) {
            return token;
        }

        String text = makeInsertedText("Null");
        nullToken = makeToken(MExprANTLRParserTokenTypes.NULLID, text, lastExprToken);
        pushToken(token);

        if ( retEnd && token.getType() != MExprANTLRParserTokenTypes.EOF)
            pushToken( makeToken(MExprANTLRParserTokenTypes.PACKAGE, "Package", nullToken));

        return nullToken;
    }

    /*
     * Return TRUE if token could have ended the expr. If token is null
     * (beginning of stream) then we return false.
     */
    boolean tokenCanEnd(Token token)
    {
        if (token == null)
            return false;
        int type = token.getType();
        switch (type) {
        	case MExprANTLRParserTokenTypes.NOT:
        	case MExprANTLRParserTokenTypes.NOTNOT:
            case MExprANTLRParserTokenTypes.RBRACE:
            case MExprANTLRParserTokenTypes.RBRACKET:
            case MExprANTLRParserTokenTypes.RPAREN:
            case MExprANTLRParserTokenTypes.INT: 
            case MExprANTLRParserTokenTypes.REAL:
            case MExprANTLRParserTokenTypes.ID:
            case MExprANTLRParserTokenTypes.NULLID:
            case MExprANTLRParserTokenTypes.POSTFIXID:
            case MExprANTLRParserTokenTypes.STRING:
            case MExprANTLRParserTokenTypes.BLANK1:
            case MExprANTLRParserTokenTypes.IDBLANK1:
            case MExprANTLRParserTokenTypes.BLANKID1:
            case MExprANTLRParserTokenTypes.IDBLANKID1:
            case MExprANTLRParserTokenTypes.BLANK2:
            case MExprANTLRParserTokenTypes.IDBLANK2:
            case MExprANTLRParserTokenTypes.BLANKID2:
            case MExprANTLRParserTokenTypes.IDBLANKID2:
            case MExprANTLRParserTokenTypes.BLANK3:
            case MExprANTLRParserTokenTypes.IDBLANK3:
            case MExprANTLRParserTokenTypes.BLANKID3:
            case MExprANTLRParserTokenTypes.IDBLANKID3:
            case MExprANTLRParserTokenTypes.IDBLANKDOT:
            case MExprANTLRParserTokenTypes.BLANKDOT:
            case MExprANTLRParserTokenTypes.SLOT: 
            case MExprANTLRParserTokenTypes.TYPESETEXPR:
            case MExprANTLRParserTokenTypes.GET:
            case MExprANTLRParserTokenTypes.PUT:
            case MExprANTLRParserTokenTypes.PERCENT:
            case MExprANTLRParserTokenTypes.PERCENTNUMBER:
            	                return true;
        }

        return false;
    }

    /*
     * We should list atoms and prefix operators. EOF will return false.
     */
    boolean tokenCanStart(Token token)
    {

        int type = token.getType();
        switch (type) {
            case MExprANTLRParserTokenTypes.NOT:
            case MExprANTLRParserTokenTypes.PLUS:
            case MExprANTLRParserTokenTypes.MINUS:
            case MExprANTLRParserTokenTypes.PLUSPLUS:
            case MExprANTLRParserTokenTypes.MINUSMINUS:
            case MExprANTLRParserTokenTypes.LBRACE:
            case MExprANTLRParserTokenTypes.LPAREN:
            case MExprANTLRParserTokenTypes.INT:
            case MExprANTLRParserTokenTypes.REAL:
            case MExprANTLRParserTokenTypes.ID:
            case MExprANTLRParserTokenTypes.STRING:
            case MExprANTLRParserTokenTypes.BLANK1:
            case MExprANTLRParserTokenTypes.IDBLANK1:
            case MExprANTLRParserTokenTypes.BLANKID1:
            case MExprANTLRParserTokenTypes.IDBLANKID1:
            case MExprANTLRParserTokenTypes.BLANK2:
            case MExprANTLRParserTokenTypes.IDBLANK2:
            case MExprANTLRParserTokenTypes.BLANKID2:
            case MExprANTLRParserTokenTypes.IDBLANKID2:
            case MExprANTLRParserTokenTypes.BLANK3:
            case MExprANTLRParserTokenTypes.IDBLANK3:
            case MExprANTLRParserTokenTypes.BLANKID3:
            case MExprANTLRParserTokenTypes.IDBLANKID3:
            case MExprANTLRParserTokenTypes.SLOT:
            case MExprANTLRParserTokenTypes.TYPESETEXPR:
            case MExprANTLRParserTokenTypes.PERCENT:
            case MExprANTLRParserTokenTypes.PERCENTNUMBER:
            case MExprANTLRParserTokenTypes.GET:
                return true;
        }

        return false;
    }

    /*
     * We should list atoms and prefix operators. EOF will return false.
     */
    boolean tokenIsPrefix(Token token)
    {
        if (token == null)
            return false;

        int type = token.getType();
        switch (type) {
            case MExprANTLRParserTokenTypes.UNARYMINUS:
            case MExprANTLRParserTokenTypes.UNARYPLUS:
            case MExprANTLRParserTokenTypes.NOT:
            case MExprANTLRParserTokenTypes.PLUSPLUS:
            case MExprANTLRParserTokenTypes.MINUSMINUS:
                return true;
        }

        return false;
    }
    
    boolean tokenIsStartMatch( Token token) 
    {
        int type = token.getType();
        return 
    		type == MExprANTLRParserTokenTypes.LBRACKET ||
    		type == MExprANTLRParserTokenTypes.LBRACE ||
    		type == MExprANTLRParserTokenTypes.LPAREN;
    }

    boolean tokenIsEndMatch( Token token) 
    {
        int type = token.getType();
        return 
    		type == MExprANTLRParserTokenTypes.RBRACKET ||
    		type == MExprANTLRParserTokenTypes.RBRACE ||
    		type == MExprANTLRParserTokenTypes.RPAREN;
    }

    /*
     * This is a longname, replace with the appropriate operator if desired.
     */
    Token fixLongName( Token token)
    {
    	String name = token.getText();
    	Token nToken;
    	
    	if ( name.equals( "\\[LeftDoubleBracket]")) {
             nToken = makeToken(MExprANTLRParserTokenTypes.LBRACKET, "[", token);
            pushToken(nToken);
            return nToken;
    	}
    	
    	if ( name.equals( "\\[RightDoubleBracket]")) {
            nToken = makeToken(MExprANTLRParserTokenTypes.RBRACKET, "]", token);
            pushToken(nToken);
            return nToken;
    	}
    	
    	if ( name.equals( "\\[Rule]")) {
            nToken = makeToken(MExprANTLRParserTokenTypes.RULE, "->", token);
            return nToken;
    	}
    	
    	if ( name.equals( "\\[RuleDelayed]")) {
            nToken = makeToken(MExprANTLRParserTokenTypes.RULE, ":>", token);
            return nToken;
    	}
    	
        nToken = makeToken(MExprANTLRParserTokenTypes.ID, name, token);
   	
    	return nToken;
    }

    
    
    /*
     * This is a SET token, we need to look at the next token, if this is 
     * a . then we need to treat as an UNSET,  which also requires fixup.
     */
    Token fixSET( Token token) throws TokenStreamException
    {
    
    	/* 
    	 * This is bad...  comments between = and . will get lost.
    	 * 
    	 */
        MExprToken next = (MExprToken) getNextToken();
        while( next.getType() == MExprANTLRParserTokenTypes.WHITESPACE ||
        		next.getType() == MExprANTLRParserTokenTypes.COMMENT) {
        	next = (MExprToken) getNextToken();
        }
        
        if ( next.getType() != MExprANTLRParserTokenTypes.DOT) {
        	pushToken( next);
        	return token;
        }
    	
    	MExprToken newToken = (MExprToken) makeToken(MExprANTLRParserTokenTypes.UNSET, "=.", token);
    	newToken.charEnd = next.getCharEnd();
    	return fixPostfix("UNSETXX", MExprANTLRParserTokenTypes.UNSETINFIX,
                newToken);
    }
    
    
    
    /*
     * This is a comma, check to see if the last token was a
     * { or [ or , .  In this case insert a NullID.
     */
    Token fixThisComma( Token token)
    {
    	if ( lastExprToken == null)
    		return token;
    	
    	int lastType = lastExprToken.getType();
    	if ( lastType != MExprANTLRParserTokenTypes.LBRACE && 
    			lastType != MExprANTLRParserTokenTypes.LBRACKET &&
				lastType != MExprANTLRParserTokenTypes.COMMA)
    		return token;

        pushToken(token);   	
    	return makeToken(MExprANTLRParserTokenTypes.NULLID, "Null", lastExprToken);
    }

    /*
     * This is a } or ] character, check to see if the last token was a
     * ,  In this case insert a NullID.
     */
    Token fixLastComma( Token token)
    {
       	if ( lastExprToken == null)
    		return token;
       	
    	int lastType = lastExprToken.getType();
    	if ( lastType != MExprANTLRParserTokenTypes.COMMA)
    		return token;

        pushToken(token);   	
    	return makeToken(MExprANTLRParserTokenTypes.NULLID, "Null", lastExprToken);
   	
    }

	public Token makeEOFToken() {
        MExprToken token = new MExprToken();
		token.setType( MExprANTLRParserTokenTypes.EOF);
		return token;
	}

	
	/*
	 All methods for the TokenStreamRecoverer that are not supported.
	 */
	public void insertToken(Token tok) {
	}

	public void replaceToken(Token tok) {
	}

	public void dropToken( ) {
	}

	public Token lastToken() {
		return null;
	}

	public Token makeToken(int type, String text) {
		return null;
	}

	public boolean recoverySupported() {
		return false;
	}

	public void setPosition( int pos) {
	}

	public int getPosition() {
		return 0;
	}
	
	public boolean unmodifiedToken() {
		return false;
	}
	
	/*
	 * Process \( .. \) in case it contains a comment
	 */
	Token fixTypesetOpen(Token token) throws TokenStreamException {
		MExprToken next = (MExprToken) getNextToken();

		if (next.getType() == MExprANTLRParserTokenTypes.COMMENT ||
			next.getType() == MExprANTLRParserTokenTypes.LONGNAME && 
				next.getText().equals("\\[IndentingNewLine]")) {
			MExprToken next1 = (MExprToken) getNextToken();
			return nextToken();
		}
		
		pushToken(next);
		return token;
	}

	boolean whiteSpaceTypeset( Token token) {
		
		int type = token.getType();
		if ( type == MExprANTLRParserTokenTypes.TYPESETSPACE) {
			return true;
		}
		if ( type == MExprANTLRParserTokenTypes.LONGNAME && 
				token.getText().equals("\\[IndentingNewLine]")) {
			return true;
		}

		return false;
	}
	
}