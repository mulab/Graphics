
package com.wolfram.mexprparser;
import antlr.RecognitionException;
import antlr.Token;
import antlr.TokenStreamException;

import com.wolfram.mexpr.MExpr;
import com.wolfram.mexpr.visitors.MExprFilter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;

/*
 * Created on Nov 26, 2004
 * 
 * Class for generating Exprs from various input 
 * streams.  This parser does not store the intermediate 
 * token stream.
 */

public class MExprParser
{
	MExprFilter filter = null;
	int line;
	int column;
	boolean recognitionError;
	int charPosition;
	boolean parseError_;
	boolean fTypesetParse;
	
	public MExprParser( ) {
		this( false);
	}
	
	public MExprParser( boolean typesetParse) {
		fTypesetParse = typesetParse;
	}
	
	public void setMExprFilter( MExprFilter filter_) 
	{
		filter = filter_;
	}
	
    public MExpr generate(Reader inp)
    {
    	inp = MExprParserUtilities.checkReaderForEncoding( inp);
    	
        recognitionError = false;
        MExprANTLRLexer lexer = new MExprANTLRLexer( inp);
        lexer.setLexer( inp, fTypesetParse);
        MExprTokenStream tokStm = new MExprTokenStream( lexer);
        tokStm.setTypesetParse(fTypesetParse);
        MExprANTLRParser parser = new MExprANTLRParser(tokStm);
        parser.setParser( tokStm);
        if ( filter != null)
        	parser.setMExprFilter( filter);

        try {
            MExpr res = parser.topexpr();
            parseError_ = parser.isParseError();
            Token nextToken = tokStm.nextToken();
            return res;
        } catch (RecognitionException e) {
        	recognitionError = true;
        	line = e.getLine();
        	column = e.getColumn();
        } catch (TokenStreamException e) {

        }
       	charPosition = lexer.charPosition;
       	parseError_ = true;
       	return null;
   }
    
    public MExpr generateSingle(Reader inp)
    {
    	inp = MExprParserUtilities.checkReaderForEncoding( inp);
    	
        recognitionError = false;
        MExprANTLRLexer lexer = new MExprANTLRLexer(inp);
        lexer.setLexer( inp, fTypesetParse);
        MExprTokenStream tokStm = new MExprTokenStream( lexer);
        MExprANTLRParser parser = new MExprANTLRParser(tokStm);
        parser.setParser( tokStm);
        if ( filter != null)
        	parser.setMExprFilter( filter);

        try {
            MExpr res = parser.fullformexpr();
            parseError_ = parser.isParseError();
            return res;
        } catch (RecognitionException e) {
        	recognitionError = true;
        	line = e.getLine();
        	column = e.getColumn();
        } catch (TokenStreamException e) {

        }
       	charPosition = lexer.charPosition;
       	parseError_ = true;
       	return null;
   }
    
    public boolean recognitionError()
    {
    	return recognitionError;
    }
    
    public int getLine() 
    {
    	return line;
    }

    public int getColumn() 
    {
    	return column;
    }

    public int getCharPosition() 
    {
    	return charPosition;
    }

    
    public MExpr generate(String input)
    {
        return generate(new StringReader(input));
    }

    public MExpr generateSingle(String input)
    {
        return generateSingle(new StringReader(input));
    }

    public boolean isParseError() {
    	return parseError_;
    }
}