/*
 * Created on Jan 20, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.wolfram.mexprparser;

import antlr.CommonToken;

import com.wolfram.mexpr.IMExprToken;

/**
 * @author twj
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MExprToken extends CommonToken implements IMExprToken
{
	//This states if this is a ID which has been 
	//fixed into a pattern
	public boolean fixedID = false;
	
    int charStart;
    int charEnd;
    
    // LOCATION: added token index 
    // TODO: either extend ExprToken from Token (instead of CommonToken)
    // to save the fields line/column; 
    // Important: this must be initialized to -1 to make it possible 
    // to distinct between undefined (-1) and defined (>0)
    int tokenIndex_ = -1;
    
    public int getCharStart()
    {
        return charStart;
    }
    
    public int getCharEnd()
    {
        return charEnd;
    }
    
    /**
     * 
     * @return the index of this token in the sequence of lexed tokens coming 
     * from the ExprTokenStream (not from the Antlr generated Lexer)
     */
    public int getTokenIndex()
    {
        return tokenIndex_;
    }
             
}
