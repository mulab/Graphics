package main;

import java.io.BufferedReader;
import java.io.FileReader;

import com.wolfram.mexpr.MExpr;
import com.wolfram.mexprparser.MExprParser;

import graph.GraphDrawer;

/*程序入口*/
public class Main {

	public static void main(String[] args){ 
		try{
			if(args.length != 2){
				args = new String[2];
				args[0] = "E:\\work\\前端SRT\\plot\\InputForm.txt";
				args[1] = "E:\\work\\前端SRT\\plot\\Graph1.png";
			}
			BufferedReader fin = new BufferedReader(new FileReader(args[0])); 
			MExprParser mep = new MExprParser();
			MExpr expr = mep.generate(fin);
			new GraphDrawer(expr,args[1]);
		}
		catch(Exception e){
			e.printStackTrace();
		}
   } 
}
