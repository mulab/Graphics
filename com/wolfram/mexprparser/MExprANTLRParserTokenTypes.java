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

public interface MExprANTLRParserTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int PACKAGE = 4;
	int SEMI = 5;
	int PUT = 6;
	int SET = 7;
	int SETDELAYED = 8;
	int UPSET = 9;
	int UPSETDELAYED = 10;
	int TAGSET = 11;
	int UNSETINFIX = 12;
	int SLASHFUN = 13;
	int AMPINFIX = 14;
	int ADDTO = 15;
	int SUBTRACTFROM = 16;
	int TIMESBY = 17;
	int DIVIDEBY = 18;
	int REPLACEALL = 19;
	int REPLACEREPEATED = 20;
	int RULE = 21;
	int CONDITION = 22;
	int STRINGEXPRESSION = 23;
	int ALTERNATIVES = 24;
	int REPEATEDINFIX = 25;
	int REPEATEDNULLINFIX = 26;
	int OR = 27;
	int AND = 28;
	int NOT = 29;
	int NOTNOT = 30;
	int SAMEQ = 31;
	int UNSAMEQ = 32;
	int EQUAL = 33;
	int UNEQUAL = 34;
	int GREATER = 35;
	int LESS = 36;
	int GREATEREQUAL = 37;
	int LESSEQUAL = 38;
	int PLUS = 39;
	int MINUS = 40;
	int TIMES = 41;
	int SLASH = 42;
	int TYPESETDIVIDE = 43;
	int UNARYPLUS = 44;
	int UNARYMINUS = 45;
	int DOT = 46;
	int NONCOMMUTE = 47;
	int CARET = 48;
	int TYPESETSUPER = 49;
	int TYPESETSQRT = 50;
	int STRINGJOIN = 51;
	int DERIVATIVEINFIX = 52;
	int NOTINFIX = 53;
	int NOTNOTINFIX = 54;
	int MAP = 55;
	int MAPALL = 56;
	int APPLY = 57;
	int APPLYONE = 58;
	int INFIXFULLFORM = 59;
	int ATFUN = 60;
	int PLUSPLUS = 61;
	int MINUSMINUS = 62;
	int TYPESETFULLFORM = 63;
	int PLUSPLUSINFIX = 64;
	int MINUSMINUSINFIX = 65;
	int QUESTION = 66;
	int MESSAGENAME = 67;
	int LBRACKET = 68;
	int RBRACKET = 69;
	int COMMA = 70;
	int LPAREN = 71;
	int RPAREN = 72;
	int TYPESETOPEN = 73;
	int TYPESETCLOSE = 74;
	int TYPESETSUB = 75;
	int LBRACE = 76;
	int RBRACE = 77;
	int ID = 78;
	int COLON = 79;
	int IDBLANK1 = 80;
	int IDBLANK2 = 81;
	int IDBLANK3 = 82;
	int IDBLANKDOT = 83;
	int IDBLANKID1 = 84;
	int IDBLANKID2 = 85;
	int IDBLANKID3 = 86;
	int GET = 87;
	int INT = 88;
	int REAL = 89;
	int STRING = 90;
	int POSTFIXID = 91;
	int NULLID = 92;
	int ERROR = 93;
	int BLANKDOT = 94;
	int SLOT = 95;
	int TYPESETEXPR = 96;
	int PERCENT = 97;
	int PERCENTNUMBER = 98;
	int BLANK1 = 99;
	int BLANK2 = 100;
	int BLANK3 = 101;
	int BLANKID1 = 102;
	int BLANKID2 = 103;
	int BLANKID3 = 104;
	int DERIVATIVE = 105;
	int SLASH_START = 106;
	int EQUAL_START = 107;
	int EQUALEXCLAM = 108;
	int UNSET = 109;
	int AT_START = 110;
	int PLUS_START = 111;
	int MINUS_START = 112;
	int EXCLAM = 113;
	int EXCLAM2 = 114;
	int EXCLAM_START = 115;
	int COLON_START = 116;
	int CARET_START = 117;
	int GREATER_START = 118;
	int LESS_START = 119;
	int AMP_START = 120;
	int AMP = 121;
	int BAR_START = 122;
	int TILDE_START = 123;
	int STAR_START = 124;
	int WHITESPACE = 125;
	int COMMENT = 126;
	int INT_REAL_DOT = 127;
	int DOT_START = 128;
	int REPEATED = 129;
	int REPEATEDNULL = 130;
	int BLANK = 131;
	int IDUNICODESTART = 132;
	int LONGNAME = 133;
	int BACKSLASH_START = 134;
	int BACKSLASHBRACKET = 135;
	int TYPESETSPACE = 136;
	int DUMMYID = 137;
}
