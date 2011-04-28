package parser;

//$ANTLR 3.3 Nov 30, 2010 12:45:30 E:\\work\\srt\\antlr\\test\\plot.g 2011-04-22 23:20:48

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class plotParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SHAPE_IDT", "FLOAT", "POINTS", "VAR", "SIZE", "COLOR", "JOINFORM", "VERTEXCOLORS", "INT", "STRING", "ID", "EXPONENT", "ESC_SEQ", "HEX_DIGIT", "UNICODE_ESC", "OCTAL_ESC", "'GRAPHICS2D'", "'GRAPHICS3D'", "'['", "'SHAPE'", "'{'", "','", "'}'", "'OPTIONS'", "']'", "'='", "'},OPTIONS{'", "'ImageSize'", "'ImageMargins'", "'XRatio'", "'YRatio'", "'Axes'", "'AxesOriginX'", "'AxesOriginY'", "'PlotRange'", "'FillType'", "'FrameType'", "'BackColor'"
    };
    public static final int EOF=-1;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int SHAPE_IDT=4;
    public static final int FLOAT=5;
    public static final int POINTS=6;
    public static final int VAR=7;
    public static final int SIZE=8;
    public static final int COLOR=9;
    public static final int JOINFORM=10;
    public static final int VERTEXCOLORS=11;
    public static final int INT=12;
    public static final int STRING=13;
    public static final int ID=14;
    public static final int EXPONENT=15;
    public static final int ESC_SEQ=16;
    public static final int HEX_DIGIT=17;
    public static final int UNICODE_ESC=18;
    public static final int OCTAL_ESC=19;

    // delegates
    // delegators


        public plotParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public plotParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return plotParser.tokenNames; }
    public String getGrammarFileName() { return "E:\\work\\srt\\antlr\\test\\plot.g"; }


    public static class program_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // E:\\work\\srt\\antlr\\test\\plot.g:4:1: program : statement ;
    public final plotParser.program_return program() throws RecognitionException {
        plotParser.program_return retval = new plotParser.program_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        plotParser.statement_return statement1 = null;



        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:4:9: ( statement )
            // E:\\work\\srt\\antlr\\test\\plot.g:4:11: statement
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_statement_in_program18);
            statement1=statement();

            state._fsp--;

            adaptor.addChild(root_0, statement1.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // E:\\work\\srt\\antlr\\test\\plot.g:5:1: statement : expression ;
    public final plotParser.statement_return statement() throws RecognitionException {
        plotParser.statement_return retval = new plotParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        plotParser.expression_return expression2 = null;



        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:6:2: ( expression )
            // E:\\work\\srt\\antlr\\test\\plot.g:6:3: expression
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expression_in_statement26);
            expression2=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression2.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // E:\\work\\srt\\antlr\\test\\plot.g:8:1: expression : ( 'GRAPHICS2D' | 'GRAPHICS3D' ) '[' 'SHAPE' '{' shape ( ',' shape )* '}' ',' 'OPTIONS' '{' ( option )* '}' ']' ;
    public final plotParser.expression_return expression() throws RecognitionException {
        plotParser.expression_return retval = new plotParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set3=null;
        Token char_literal4=null;
        Token string_literal5=null;
        Token char_literal6=null;
        Token char_literal8=null;
        Token char_literal10=null;
        Token char_literal11=null;
        Token string_literal12=null;
        Token char_literal13=null;
        Token char_literal15=null;
        Token char_literal16=null;
        plotParser.shape_return shape7 = null;

        plotParser.shape_return shape9 = null;

        plotParser.option_return option14 = null;


        Object set3_tree=null;
        Object char_literal4_tree=null;
        Object string_literal5_tree=null;
        Object char_literal6_tree=null;
        Object char_literal8_tree=null;
        Object char_literal10_tree=null;
        Object char_literal11_tree=null;
        Object string_literal12_tree=null;
        Object char_literal13_tree=null;
        Object char_literal15_tree=null;
        Object char_literal16_tree=null;

        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:8:12: ( ( 'GRAPHICS2D' | 'GRAPHICS3D' ) '[' 'SHAPE' '{' shape ( ',' shape )* '}' ',' 'OPTIONS' '{' ( option )* '}' ']' )
            // E:\\work\\srt\\antlr\\test\\plot.g:8:14: ( 'GRAPHICS2D' | 'GRAPHICS3D' ) '[' 'SHAPE' '{' shape ( ',' shape )* '}' ',' 'OPTIONS' '{' ( option )* '}' ']'
            {
            root_0 = (Object)adaptor.nil();

            set3=(Token)input.LT(1);
            if ( (input.LA(1)>=20 && input.LA(1)<=21) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set3));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            char_literal4=(Token)match(input,22,FOLLOW_22_in_expression39); 
            char_literal4_tree = (Object)adaptor.create(char_literal4);
            adaptor.addChild(root_0, char_literal4_tree);

            string_literal5=(Token)match(input,23,FOLLOW_23_in_expression40); 
            string_literal5_tree = (Object)adaptor.create(string_literal5);
            adaptor.addChild(root_0, string_literal5_tree);

            char_literal6=(Token)match(input,24,FOLLOW_24_in_expression41); 
            char_literal6_tree = (Object)adaptor.create(char_literal6);
            adaptor.addChild(root_0, char_literal6_tree);

            pushFollow(FOLLOW_shape_in_expression42);
            shape7=shape();

            state._fsp--;

            adaptor.addChild(root_0, shape7.getTree());
            // E:\\work\\srt\\antlr\\test\\plot.g:8:59: ( ',' shape )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==25) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // E:\\work\\srt\\antlr\\test\\plot.g:8:60: ',' shape
            	    {
            	    char_literal8=(Token)match(input,25,FOLLOW_25_in_expression44); 
            	    char_literal8_tree = (Object)adaptor.create(char_literal8);
            	    adaptor.addChild(root_0, char_literal8_tree);

            	    pushFollow(FOLLOW_shape_in_expression45);
            	    shape9=shape();

            	    state._fsp--;

            	    adaptor.addChild(root_0, shape9.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            char_literal10=(Token)match(input,26,FOLLOW_26_in_expression48); 
            char_literal10_tree = (Object)adaptor.create(char_literal10);
            adaptor.addChild(root_0, char_literal10_tree);

            char_literal11=(Token)match(input,25,FOLLOW_25_in_expression49); 
            char_literal11_tree = (Object)adaptor.create(char_literal11);
            adaptor.addChild(root_0, char_literal11_tree);

            string_literal12=(Token)match(input,27,FOLLOW_27_in_expression50); 
            string_literal12_tree = (Object)adaptor.create(string_literal12);
            adaptor.addChild(root_0, string_literal12_tree);

            char_literal13=(Token)match(input,24,FOLLOW_24_in_expression51); 
            char_literal13_tree = (Object)adaptor.create(char_literal13);
            adaptor.addChild(root_0, char_literal13_tree);

            // E:\\work\\srt\\antlr\\test\\plot.g:8:88: ( option )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=31 && LA2_0<=41)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // E:\\work\\srt\\antlr\\test\\plot.g:8:88: option
            	    {
            	    pushFollow(FOLLOW_option_in_expression52);
            	    option14=option();

            	    state._fsp--;

            	    adaptor.addChild(root_0, option14.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            char_literal15=(Token)match(input,26,FOLLOW_26_in_expression54); 
            char_literal15_tree = (Object)adaptor.create(char_literal15);
            adaptor.addChild(root_0, char_literal15_tree);

            char_literal16=(Token)match(input,28,FOLLOW_28_in_expression55); 
            char_literal16_tree = (Object)adaptor.create(char_literal16);
            adaptor.addChild(root_0, char_literal16_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class shapeoptions_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shapeoptions"
    // E:\\work\\srt\\antlr\\test\\plot.g:27:1: shapeoptions : ( VAR '=' INT | COLOR | JOINFORM | SIZE | VERTEXCOLORS );
    public final plotParser.shapeoptions_return shapeoptions() throws RecognitionException {
        plotParser.shapeoptions_return retval = new plotParser.shapeoptions_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token VAR17=null;
        Token char_literal18=null;
        Token INT19=null;
        Token COLOR20=null;
        Token JOINFORM21=null;
        Token SIZE22=null;
        Token VERTEXCOLORS23=null;

        Object VAR17_tree=null;
        Object char_literal18_tree=null;
        Object INT19_tree=null;
        Object COLOR20_tree=null;
        Object JOINFORM21_tree=null;
        Object SIZE22_tree=null;
        Object VERTEXCOLORS23_tree=null;

        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:27:13: ( VAR '=' INT | COLOR | JOINFORM | SIZE | VERTEXCOLORS )
            int alt3=5;
            switch ( input.LA(1) ) {
            case VAR:
                {
                alt3=1;
                }
                break;
            case COLOR:
                {
                alt3=2;
                }
                break;
            case JOINFORM:
                {
                alt3=3;
                }
                break;
            case SIZE:
                {
                alt3=4;
                }
                break;
            case VERTEXCOLORS:
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:27:15: VAR '=' INT
                    {
                    root_0 = (Object)adaptor.nil();

                    VAR17=(Token)match(input,VAR,FOLLOW_VAR_in_shapeoptions290); 
                    VAR17_tree = (Object)adaptor.create(VAR17);
                    adaptor.addChild(root_0, VAR17_tree);

                    char_literal18=(Token)match(input,29,FOLLOW_29_in_shapeoptions291); 
                    char_literal18_tree = (Object)adaptor.create(char_literal18);
                    adaptor.addChild(root_0, char_literal18_tree);

                    INT19=(Token)match(input,INT,FOLLOW_INT_in_shapeoptions292); 
                    INT19_tree = (Object)adaptor.create(INT19);
                    adaptor.addChild(root_0, INT19_tree);


                    }
                    break;
                case 2 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:27:25: COLOR
                    {
                    root_0 = (Object)adaptor.nil();

                    COLOR20=(Token)match(input,COLOR,FOLLOW_COLOR_in_shapeoptions294); 
                    COLOR20_tree = (Object)adaptor.create(COLOR20);
                    adaptor.addChild(root_0, COLOR20_tree);


                    }
                    break;
                case 3 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:27:31: JOINFORM
                    {
                    root_0 = (Object)adaptor.nil();

                    JOINFORM21=(Token)match(input,JOINFORM,FOLLOW_JOINFORM_in_shapeoptions296); 
                    JOINFORM21_tree = (Object)adaptor.create(JOINFORM21);
                    adaptor.addChild(root_0, JOINFORM21_tree);


                    }
                    break;
                case 4 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:27:40: SIZE
                    {
                    root_0 = (Object)adaptor.nil();

                    SIZE22=(Token)match(input,SIZE,FOLLOW_SIZE_in_shapeoptions298); 
                    SIZE22_tree = (Object)adaptor.create(SIZE22);
                    adaptor.addChild(root_0, SIZE22_tree);


                    }
                    break;
                case 5 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:27:45: VERTEXCOLORS
                    {
                    root_0 = (Object)adaptor.nil();

                    VERTEXCOLORS23=(Token)match(input,VERTEXCOLORS,FOLLOW_VERTEXCOLORS_in_shapeoptions300); 
                    VERTEXCOLORS23_tree = (Object)adaptor.create(VERTEXCOLORS23);
                    adaptor.addChild(root_0, VERTEXCOLORS23_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "shapeoptions"

    public static class shape_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shape"
    // E:\\work\\srt\\antlr\\test\\plot.g:30:1: shape : SHAPE_IDT '[' '{' POINTS ( ',' POINTS )* '},OPTIONS{' shapeoptions ( ',' shapeoptions )* '}' ']' ;
    public final plotParser.shape_return shape() throws RecognitionException {
        plotParser.shape_return retval = new plotParser.shape_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHAPE_IDT24=null;
        Token char_literal25=null;
        Token char_literal26=null;
        Token POINTS27=null;
        Token char_literal28=null;
        Token POINTS29=null;
        Token string_literal30=null;
        Token char_literal32=null;
        Token char_literal34=null;
        Token char_literal35=null;
        plotParser.shapeoptions_return shapeoptions31 = null;

        plotParser.shapeoptions_return shapeoptions33 = null;


        Object SHAPE_IDT24_tree=null;
        Object char_literal25_tree=null;
        Object char_literal26_tree=null;
        Object POINTS27_tree=null;
        Object char_literal28_tree=null;
        Object POINTS29_tree=null;
        Object string_literal30_tree=null;
        Object char_literal32_tree=null;
        Object char_literal34_tree=null;
        Object char_literal35_tree=null;

        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:30:7: ( SHAPE_IDT '[' '{' POINTS ( ',' POINTS )* '},OPTIONS{' shapeoptions ( ',' shapeoptions )* '}' ']' )
            // E:\\work\\srt\\antlr\\test\\plot.g:30:8: SHAPE_IDT '[' '{' POINTS ( ',' POINTS )* '},OPTIONS{' shapeoptions ( ',' shapeoptions )* '}' ']'
            {
            root_0 = (Object)adaptor.nil();

            SHAPE_IDT24=(Token)match(input,SHAPE_IDT,FOLLOW_SHAPE_IDT_in_shape310); 
            SHAPE_IDT24_tree = (Object)adaptor.create(SHAPE_IDT24);
            adaptor.addChild(root_0, SHAPE_IDT24_tree);

            char_literal25=(Token)match(input,22,FOLLOW_22_in_shape312); 
            char_literal25_tree = (Object)adaptor.create(char_literal25);
            adaptor.addChild(root_0, char_literal25_tree);

            char_literal26=(Token)match(input,24,FOLLOW_24_in_shape313); 
            char_literal26_tree = (Object)adaptor.create(char_literal26);
            adaptor.addChild(root_0, char_literal26_tree);

            POINTS27=(Token)match(input,POINTS,FOLLOW_POINTS_in_shape315); 
            POINTS27_tree = (Object)adaptor.create(POINTS27);
            adaptor.addChild(root_0, POINTS27_tree);

            // E:\\work\\srt\\antlr\\test\\plot.g:30:31: ( ',' POINTS )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==25) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // E:\\work\\srt\\antlr\\test\\plot.g:30:32: ',' POINTS
            	    {
            	    char_literal28=(Token)match(input,25,FOLLOW_25_in_shape317); 
            	    char_literal28_tree = (Object)adaptor.create(char_literal28);
            	    adaptor.addChild(root_0, char_literal28_tree);

            	    POINTS29=(Token)match(input,POINTS,FOLLOW_POINTS_in_shape318); 
            	    POINTS29_tree = (Object)adaptor.create(POINTS29);
            	    adaptor.addChild(root_0, POINTS29_tree);


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            string_literal30=(Token)match(input,30,FOLLOW_30_in_shape321); 
            string_literal30_tree = (Object)adaptor.create(string_literal30);
            adaptor.addChild(root_0, string_literal30_tree);

            pushFollow(FOLLOW_shapeoptions_in_shape322);
            shapeoptions31=shapeoptions();

            state._fsp--;

            adaptor.addChild(root_0, shapeoptions31.getTree());
            // E:\\work\\srt\\antlr\\test\\plot.g:30:67: ( ',' shapeoptions )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==25) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // E:\\work\\srt\\antlr\\test\\plot.g:30:68: ',' shapeoptions
            	    {
            	    char_literal32=(Token)match(input,25,FOLLOW_25_in_shape324); 
            	    char_literal32_tree = (Object)adaptor.create(char_literal32);
            	    adaptor.addChild(root_0, char_literal32_tree);

            	    pushFollow(FOLLOW_shapeoptions_in_shape325);
            	    shapeoptions33=shapeoptions();

            	    state._fsp--;

            	    adaptor.addChild(root_0, shapeoptions33.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            char_literal34=(Token)match(input,26,FOLLOW_26_in_shape328); 
            char_literal34_tree = (Object)adaptor.create(char_literal34);
            adaptor.addChild(root_0, char_literal34_tree);

            char_literal35=(Token)match(input,28,FOLLOW_28_in_shape329); 
            char_literal35_tree = (Object)adaptor.create(char_literal35);
            adaptor.addChild(root_0, char_literal35_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "shape"

    public static class option_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "option"
    // E:\\work\\srt\\antlr\\test\\plot.g:34:1: option : ( 'ImageSize' | 'ImageMargins' | 'XRatio' | 'YRatio' | 'Axes' | 'AxesOriginX' | 'AxesOriginY' | 'PlotRange' | 'FillType' | 'FrameType' | 'BackColor' ) '=' ( POINTS | '{' POINTS ',' POINTS '}' | '{' POINTS ',' POINTS ',' POINTS '}' | FLOAT | STRING | INT | COLOR ) ;
    public final plotParser.option_return option() throws RecognitionException {
        plotParser.option_return retval = new plotParser.option_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set36=null;
        Token char_literal37=null;
        Token POINTS38=null;
        Token char_literal39=null;
        Token POINTS40=null;
        Token char_literal41=null;
        Token POINTS42=null;
        Token char_literal43=null;
        Token char_literal44=null;
        Token POINTS45=null;
        Token char_literal46=null;
        Token POINTS47=null;
        Token char_literal48=null;
        Token POINTS49=null;
        Token char_literal50=null;
        Token FLOAT51=null;
        Token STRING52=null;
        Token INT53=null;
        Token COLOR54=null;

        Object set36_tree=null;
        Object char_literal37_tree=null;
        Object POINTS38_tree=null;
        Object char_literal39_tree=null;
        Object POINTS40_tree=null;
        Object char_literal41_tree=null;
        Object POINTS42_tree=null;
        Object char_literal43_tree=null;
        Object char_literal44_tree=null;
        Object POINTS45_tree=null;
        Object char_literal46_tree=null;
        Object POINTS47_tree=null;
        Object char_literal48_tree=null;
        Object POINTS49_tree=null;
        Object char_literal50_tree=null;
        Object FLOAT51_tree=null;
        Object STRING52_tree=null;
        Object INT53_tree=null;
        Object COLOR54_tree=null;

        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:34:8: ( ( 'ImageSize' | 'ImageMargins' | 'XRatio' | 'YRatio' | 'Axes' | 'AxesOriginX' | 'AxesOriginY' | 'PlotRange' | 'FillType' | 'FrameType' | 'BackColor' ) '=' ( POINTS | '{' POINTS ',' POINTS '}' | '{' POINTS ',' POINTS ',' POINTS '}' | FLOAT | STRING | INT | COLOR ) )
            // E:\\work\\srt\\antlr\\test\\plot.g:34:9: ( 'ImageSize' | 'ImageMargins' | 'XRatio' | 'YRatio' | 'Axes' | 'AxesOriginX' | 'AxesOriginY' | 'PlotRange' | 'FillType' | 'FrameType' | 'BackColor' ) '=' ( POINTS | '{' POINTS ',' POINTS '}' | '{' POINTS ',' POINTS ',' POINTS '}' | FLOAT | STRING | INT | COLOR )
            {
            root_0 = (Object)adaptor.nil();

            set36=(Token)input.LT(1);
            if ( (input.LA(1)>=31 && input.LA(1)<=41) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set36));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            char_literal37=(Token)match(input,29,FOLLOW_29_in_option362); 
            char_literal37_tree = (Object)adaptor.create(char_literal37);
            adaptor.addChild(root_0, char_literal37_tree);

            // E:\\work\\srt\\antlr\\test\\plot.g:35:2: ( POINTS | '{' POINTS ',' POINTS '}' | '{' POINTS ',' POINTS ',' POINTS '}' | FLOAT | STRING | INT | COLOR )
            int alt6=7;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:35:3: POINTS
                    {
                    POINTS38=(Token)match(input,POINTS,FOLLOW_POINTS_in_option366); 
                    POINTS38_tree = (Object)adaptor.create(POINTS38);
                    adaptor.addChild(root_0, POINTS38_tree);


                    }
                    break;
                case 2 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:35:10: '{' POINTS ',' POINTS '}'
                    {
                    char_literal39=(Token)match(input,24,FOLLOW_24_in_option368); 
                    char_literal39_tree = (Object)adaptor.create(char_literal39);
                    adaptor.addChild(root_0, char_literal39_tree);

                    POINTS40=(Token)match(input,POINTS,FOLLOW_POINTS_in_option369); 
                    POINTS40_tree = (Object)adaptor.create(POINTS40);
                    adaptor.addChild(root_0, POINTS40_tree);

                    char_literal41=(Token)match(input,25,FOLLOW_25_in_option370); 
                    char_literal41_tree = (Object)adaptor.create(char_literal41);
                    adaptor.addChild(root_0, char_literal41_tree);

                    POINTS42=(Token)match(input,POINTS,FOLLOW_POINTS_in_option371); 
                    POINTS42_tree = (Object)adaptor.create(POINTS42);
                    adaptor.addChild(root_0, POINTS42_tree);

                    char_literal43=(Token)match(input,26,FOLLOW_26_in_option372); 
                    char_literal43_tree = (Object)adaptor.create(char_literal43);
                    adaptor.addChild(root_0, char_literal43_tree);


                    }
                    break;
                case 3 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:35:32: '{' POINTS ',' POINTS ',' POINTS '}'
                    {
                    char_literal44=(Token)match(input,24,FOLLOW_24_in_option374); 
                    char_literal44_tree = (Object)adaptor.create(char_literal44);
                    adaptor.addChild(root_0, char_literal44_tree);

                    POINTS45=(Token)match(input,POINTS,FOLLOW_POINTS_in_option375); 
                    POINTS45_tree = (Object)adaptor.create(POINTS45);
                    adaptor.addChild(root_0, POINTS45_tree);

                    char_literal46=(Token)match(input,25,FOLLOW_25_in_option376); 
                    char_literal46_tree = (Object)adaptor.create(char_literal46);
                    adaptor.addChild(root_0, char_literal46_tree);

                    POINTS47=(Token)match(input,POINTS,FOLLOW_POINTS_in_option377); 
                    POINTS47_tree = (Object)adaptor.create(POINTS47);
                    adaptor.addChild(root_0, POINTS47_tree);

                    char_literal48=(Token)match(input,25,FOLLOW_25_in_option378); 
                    char_literal48_tree = (Object)adaptor.create(char_literal48);
                    adaptor.addChild(root_0, char_literal48_tree);

                    POINTS49=(Token)match(input,POINTS,FOLLOW_POINTS_in_option379); 
                    POINTS49_tree = (Object)adaptor.create(POINTS49);
                    adaptor.addChild(root_0, POINTS49_tree);

                    char_literal50=(Token)match(input,26,FOLLOW_26_in_option380); 
                    char_literal50_tree = (Object)adaptor.create(char_literal50);
                    adaptor.addChild(root_0, char_literal50_tree);


                    }
                    break;
                case 4 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:35:63: FLOAT
                    {
                    FLOAT51=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_option382); 
                    FLOAT51_tree = (Object)adaptor.create(FLOAT51);
                    adaptor.addChild(root_0, FLOAT51_tree);


                    }
                    break;
                case 5 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:35:69: STRING
                    {
                    STRING52=(Token)match(input,STRING,FOLLOW_STRING_in_option384); 
                    STRING52_tree = (Object)adaptor.create(STRING52);
                    adaptor.addChild(root_0, STRING52_tree);


                    }
                    break;
                case 6 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:35:76: INT
                    {
                    INT53=(Token)match(input,INT,FOLLOW_INT_in_option386); 
                    INT53_tree = (Object)adaptor.create(INT53);
                    adaptor.addChild(root_0, INT53_tree);


                    }
                    break;
                case 7 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:35:80: COLOR
                    {
                    COLOR54=(Token)match(input,COLOR,FOLLOW_COLOR_in_option388); 
                    COLOR54_tree = (Object)adaptor.create(COLOR54);
                    adaptor.addChild(root_0, COLOR54_tree);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "option"

    // Delegated rules


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\14\uffff";
    static final String DFA6_eofS =
        "\14\uffff";
    static final String DFA6_minS =
        "\1\5\1\uffff\1\6\4\uffff\1\31\1\6\1\31\2\uffff";
    static final String DFA6_maxS =
        "\1\30\1\uffff\1\6\4\uffff\1\31\1\6\1\32\2\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\5\1\6\1\7\3\uffff\1\2\1\3";
    static final String DFA6_specialS =
        "\14\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\3\1\1\2\uffff\1\6\2\uffff\1\5\1\4\12\uffff\1\2",
            "",
            "\1\7",
            "",
            "",
            "",
            "",
            "\1\10",
            "\1\11",
            "\1\13\1\12",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "35:2: ( POINTS | '{' POINTS ',' POINTS '}' | '{' POINTS ',' POINTS ',' POINTS '}' | FLOAT | STRING | INT | COLOR )";
        }
    }
 

    public static final BitSet FOLLOW_statement_in_program18 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement26 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expression34 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_expression39 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_expression40 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_expression41 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_shape_in_expression42 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_25_in_expression44 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_shape_in_expression45 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_26_in_expression48 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_expression49 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_expression50 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_expression51 = new BitSet(new long[]{0x000003FF84000000L});
    public static final BitSet FOLLOW_option_in_expression52 = new BitSet(new long[]{0x000003FF84000000L});
    public static final BitSet FOLLOW_26_in_expression54 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_expression55 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_shapeoptions290 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_shapeoptions291 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_INT_in_shapeoptions292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLOR_in_shapeoptions294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOINFORM_in_shapeoptions296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIZE_in_shapeoptions298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VERTEXCOLORS_in_shapeoptions300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHAPE_IDT_in_shape310 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_shape312 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_shape313 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_POINTS_in_shape315 = new BitSet(new long[]{0x0000000042000000L});
    public static final BitSet FOLLOW_25_in_shape317 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_POINTS_in_shape318 = new BitSet(new long[]{0x0000000042000000L});
    public static final BitSet FOLLOW_30_in_shape321 = new BitSet(new long[]{0x0000000000000F80L});
    public static final BitSet FOLLOW_shapeoptions_in_shape322 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_25_in_shape324 = new BitSet(new long[]{0x0000000000000F80L});
    public static final BitSet FOLLOW_shapeoptions_in_shape325 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_26_in_shape328 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_shape329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_option339 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_option362 = new BitSet(new long[]{0x0000000001003260L});
    public static final BitSet FOLLOW_POINTS_in_option366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_option368 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_POINTS_in_option369 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_option370 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_POINTS_in_option371 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_option372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_option374 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_POINTS_in_option375 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_option376 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_POINTS_in_option377 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_option378 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_POINTS_in_option379 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_option380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_option382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_option384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_option386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLOR_in_option388 = new BitSet(new long[]{0x0000000000000002L});

}