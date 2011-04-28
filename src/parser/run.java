package parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class run
{
	public static void main(String[] args) throws Exception
	{
		File file = new File("input.txt");
		InputStream is = new FileInputStream(file);

		ANTLRInputStream input = new ANTLRInputStream(is);
		plotLexer lexer = new plotLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		plotParser parser = new plotParser(tokens);
		plotParser.program_return r = parser.program();
		System.out.println(((BaseTree)r.getTree()).toStringTree());
	}
}

