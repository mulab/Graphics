// $ANTLR 3.3 Nov 30, 2010 12:45:30 E:\\work\\srt\\antlr\\test\\plot.g 2011-04-29 16:41:38
package parser;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class plotParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SHAPE_IDT", "FLOAT", "POINTS", "VAR", "SIZE", "COLOR", "JOINFORM", "VERTEXCOLORS", "INT", "STRING", "ID", "EXPONENT", "HEX_DIGIT", "UNICODE_ESC", "OCTAL_ESC", "ESC_SEQ", "'GRAPHICS2D'", "'GRAPHICS3D'", "'[SHAPE{'", "','", "'},OPTIONS{'", "'}]'", "'='", "'['", "'{'", "'ImageSize'", "'ImageMargins'", "'XRatio'", "'YRatio'", "'Axes'", "'AxesOriginX'", "'AxesOriginY'", "'PlotRange'", "'FillType'", "'FrameType'", "'BackColor'", "'}'"
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
    public static final int HEX_DIGIT=16;
    public static final int UNICODE_ESC=17;
    public static final int OCTAL_ESC=18;
    public static final int ESC_SEQ=19;

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
    // E:\\work\\srt\\antlr\\test\\plot.g:8:1: expression : ( 'GRAPHICS2D' | 'GRAPHICS3D' ) '[SHAPE{' ( shape ( ',' shape )* ) '},OPTIONS{' ( option ( ',' option )* )? '}]' ;
    public final plotParser.expression_return expression() throws RecognitionException {
        plotParser.expression_return retval = new plotParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set3=null;
        Token string_literal4=null;
        Token char_literal6=null;
        Token string_literal8=null;
        Token char_literal10=null;
        Token string_literal12=null;
        plotParser.shape_return shape5 = null;

        plotParser.shape_return shape7 = null;

        plotParser.option_return option9 = null;

        plotParser.option_return option11 = null;


        Object set3_tree=null;
        Object string_literal4_tree=null;
        Object char_literal6_tree=null;
        Object string_literal8_tree=null;
        Object char_literal10_tree=null;
        Object string_literal12_tree=null;

        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:8:12: ( ( 'GRAPHICS2D' | 'GRAPHICS3D' ) '[SHAPE{' ( shape ( ',' shape )* ) '},OPTIONS{' ( option ( ',' option )* )? '}]' )
            // E:\\work\\srt\\antlr\\test\\plot.g:8:14: ( 'GRAPHICS2D' | 'GRAPHICS3D' ) '[SHAPE{' ( shape ( ',' shape )* ) '},OPTIONS{' ( option ( ',' option )* )? '}]'
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

            string_literal4=(Token)match(input,22,FOLLOW_22_in_expression40); 
            string_literal4_tree = (Object)adaptor.create(string_literal4);
            adaptor.addChild(root_0, string_literal4_tree);

            // E:\\work\\srt\\antlr\\test\\plot.g:8:50: ( shape ( ',' shape )* )
            // E:\\work\\srt\\antlr\\test\\plot.g:8:51: shape ( ',' shape )*
            {
            pushFollow(FOLLOW_shape_in_expression42);
            shape5=shape();

            state._fsp--;

            adaptor.addChild(root_0, shape5.getTree());
            // E:\\work\\srt\\antlr\\test\\plot.g:8:56: ( ',' shape )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==23) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // E:\\work\\srt\\antlr\\test\\plot.g:8:57: ',' shape
            	    {
            	    char_literal6=(Token)match(input,23,FOLLOW_23_in_expression44); 
            	    char_literal6_tree = (Object)adaptor.create(char_literal6);
            	    adaptor.addChild(root_0, char_literal6_tree);

            	    pushFollow(FOLLOW_shape_in_expression45);
            	    shape7=shape();

            	    state._fsp--;

            	    adaptor.addChild(root_0, shape7.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            string_literal8=(Token)match(input,24,FOLLOW_24_in_expression49); 
            string_literal8_tree = (Object)adaptor.create(string_literal8);
            adaptor.addChild(root_0, string_literal8_tree);

            // E:\\work\\srt\\antlr\\test\\plot.g:8:80: ( option ( ',' option )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=29 && LA3_0<=39)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:8:81: option ( ',' option )*
                    {
                    pushFollow(FOLLOW_option_in_expression51);
                    option9=option();

                    state._fsp--;

                    adaptor.addChild(root_0, option9.getTree());
                    // E:\\work\\srt\\antlr\\test\\plot.g:8:87: ( ',' option )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==23) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // E:\\work\\srt\\antlr\\test\\plot.g:8:88: ',' option
                    	    {
                    	    char_literal10=(Token)match(input,23,FOLLOW_23_in_expression53); 
                    	    char_literal10_tree = (Object)adaptor.create(char_literal10);
                    	    adaptor.addChild(root_0, char_literal10_tree);

                    	    pushFollow(FOLLOW_option_in_expression54);
                    	    option11=option();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, option11.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;

            }

            string_literal12=(Token)match(input,25,FOLLOW_25_in_expression59); 
            string_literal12_tree = (Object)adaptor.create(string_literal12);
            adaptor.addChild(root_0, string_literal12_tree);


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
    // E:\\work\\srt\\antlr\\test\\plot.g:27:1: shapeoptions : VAR '=' ( INT | FLOAT | COLOR | JOINFORM | SIZE | VERTEXCOLORS ) ;
    public final plotParser.shapeoptions_return shapeoptions() throws RecognitionException {
        plotParser.shapeoptions_return retval = new plotParser.shapeoptions_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token VAR13=null;
        Token char_literal14=null;
        Token set15=null;

        Object VAR13_tree=null;
        Object char_literal14_tree=null;
        Object set15_tree=null;

        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:27:13: ( VAR '=' ( INT | FLOAT | COLOR | JOINFORM | SIZE | VERTEXCOLORS ) )
            // E:\\work\\srt\\antlr\\test\\plot.g:27:15: VAR '=' ( INT | FLOAT | COLOR | JOINFORM | SIZE | VERTEXCOLORS )
            {
            root_0 = (Object)adaptor.nil();

            VAR13=(Token)match(input,VAR,FOLLOW_VAR_in_shapeoptions294); 
            VAR13_tree = (Object)adaptor.create(VAR13);
            adaptor.addChild(root_0, VAR13_tree);

            char_literal14=(Token)match(input,26,FOLLOW_26_in_shapeoptions295); 
            char_literal14_tree = (Object)adaptor.create(char_literal14);
            adaptor.addChild(root_0, char_literal14_tree);

            set15=(Token)input.LT(1);
            if ( input.LA(1)==FLOAT||(input.LA(1)>=SIZE && input.LA(1)<=INT) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set15));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "shapeoptions"

    public static class shape_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shape"
    // E:\\work\\srt\\antlr\\test\\plot.g:30:1: shape : SHAPE_IDT '[' '{' POINTS ( ',' POINTS )* '},OPTIONS{' ( shapeoptions ( ',' shapeoptions )* )? '}]' ;
    public final plotParser.shape_return shape() throws RecognitionException {
        plotParser.shape_return retval = new plotParser.shape_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHAPE_IDT16=null;
        Token char_literal17=null;
        Token char_literal18=null;
        Token POINTS19=null;
        Token char_literal20=null;
        Token POINTS21=null;
        Token string_literal22=null;
        Token char_literal24=null;
        Token string_literal26=null;
        plotParser.shapeoptions_return shapeoptions23 = null;

        plotParser.shapeoptions_return shapeoptions25 = null;


        Object SHAPE_IDT16_tree=null;
        Object char_literal17_tree=null;
        Object char_literal18_tree=null;
        Object POINTS19_tree=null;
        Object char_literal20_tree=null;
        Object POINTS21_tree=null;
        Object string_literal22_tree=null;
        Object char_literal24_tree=null;
        Object string_literal26_tree=null;

        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:30:7: ( SHAPE_IDT '[' '{' POINTS ( ',' POINTS )* '},OPTIONS{' ( shapeoptions ( ',' shapeoptions )* )? '}]' )
            // E:\\work\\srt\\antlr\\test\\plot.g:30:8: SHAPE_IDT '[' '{' POINTS ( ',' POINTS )* '},OPTIONS{' ( shapeoptions ( ',' shapeoptions )* )? '}]'
            {
            root_0 = (Object)adaptor.nil();

            SHAPE_IDT16=(Token)match(input,SHAPE_IDT,FOLLOW_SHAPE_IDT_in_shape318); 
            SHAPE_IDT16_tree = (Object)adaptor.create(SHAPE_IDT16);
            adaptor.addChild(root_0, SHAPE_IDT16_tree);

            char_literal17=(Token)match(input,27,FOLLOW_27_in_shape320); 
            char_literal17_tree = (Object)adaptor.create(char_literal17);
            adaptor.addChild(root_0, char_literal17_tree);

            char_literal18=(Token)match(input,28,FOLLOW_28_in_shape321); 
            char_literal18_tree = (Object)adaptor.create(char_literal18);
            adaptor.addChild(root_0, char_literal18_tree);

            POINTS19=(Token)match(input,POINTS,FOLLOW_POINTS_in_shape323); 
            POINTS19_tree = (Object)adaptor.create(POINTS19);
            adaptor.addChild(root_0, POINTS19_tree);

            // E:\\work\\srt\\antlr\\test\\plot.g:30:31: ( ',' POINTS )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==23) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // E:\\work\\srt\\antlr\\test\\plot.g:30:32: ',' POINTS
            	    {
            	    char_literal20=(Token)match(input,23,FOLLOW_23_in_shape325); 
            	    char_literal20_tree = (Object)adaptor.create(char_literal20);
            	    adaptor.addChild(root_0, char_literal20_tree);

            	    POINTS21=(Token)match(input,POINTS,FOLLOW_POINTS_in_shape326); 
            	    POINTS21_tree = (Object)adaptor.create(POINTS21);
            	    adaptor.addChild(root_0, POINTS21_tree);


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            string_literal22=(Token)match(input,24,FOLLOW_24_in_shape329); 
            string_literal22_tree = (Object)adaptor.create(string_literal22);
            adaptor.addChild(root_0, string_literal22_tree);

            // E:\\work\\srt\\antlr\\test\\plot.g:30:55: ( shapeoptions ( ',' shapeoptions )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==VAR) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:30:56: shapeoptions ( ',' shapeoptions )*
                    {
                    pushFollow(FOLLOW_shapeoptions_in_shape331);
                    shapeoptions23=shapeoptions();

                    state._fsp--;

                    adaptor.addChild(root_0, shapeoptions23.getTree());
                    // E:\\work\\srt\\antlr\\test\\plot.g:30:68: ( ',' shapeoptions )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==23) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // E:\\work\\srt\\antlr\\test\\plot.g:30:69: ',' shapeoptions
                    	    {
                    	    char_literal24=(Token)match(input,23,FOLLOW_23_in_shape333); 
                    	    char_literal24_tree = (Object)adaptor.create(char_literal24);
                    	    adaptor.addChild(root_0, char_literal24_tree);

                    	    pushFollow(FOLLOW_shapeoptions_in_shape334);
                    	    shapeoptions25=shapeoptions();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, shapeoptions25.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            string_literal26=(Token)match(input,25,FOLLOW_25_in_shape339); 
            string_literal26_tree = (Object)adaptor.create(string_literal26);
            adaptor.addChild(root_0, string_literal26_tree);


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

        Token set27=null;
        Token char_literal28=null;
        Token POINTS29=null;
        Token char_literal30=null;
        Token POINTS31=null;
        Token char_literal32=null;
        Token POINTS33=null;
        Token char_literal34=null;
        Token char_literal35=null;
        Token POINTS36=null;
        Token char_literal37=null;
        Token POINTS38=null;
        Token char_literal39=null;
        Token POINTS40=null;
        Token char_literal41=null;
        Token FLOAT42=null;
        Token STRING43=null;
        Token INT44=null;
        Token COLOR45=null;

        Object set27_tree=null;
        Object char_literal28_tree=null;
        Object POINTS29_tree=null;
        Object char_literal30_tree=null;
        Object POINTS31_tree=null;
        Object char_literal32_tree=null;
        Object POINTS33_tree=null;
        Object char_literal34_tree=null;
        Object char_literal35_tree=null;
        Object POINTS36_tree=null;
        Object char_literal37_tree=null;
        Object POINTS38_tree=null;
        Object char_literal39_tree=null;
        Object POINTS40_tree=null;
        Object char_literal41_tree=null;
        Object FLOAT42_tree=null;
        Object STRING43_tree=null;
        Object INT44_tree=null;
        Object COLOR45_tree=null;

        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:34:8: ( ( 'ImageSize' | 'ImageMargins' | 'XRatio' | 'YRatio' | 'Axes' | 'AxesOriginX' | 'AxesOriginY' | 'PlotRange' | 'FillType' | 'FrameType' | 'BackColor' ) '=' ( POINTS | '{' POINTS ',' POINTS '}' | '{' POINTS ',' POINTS ',' POINTS '}' | FLOAT | STRING | INT | COLOR ) )
            // E:\\work\\srt\\antlr\\test\\plot.g:34:9: ( 'ImageSize' | 'ImageMargins' | 'XRatio' | 'YRatio' | 'Axes' | 'AxesOriginX' | 'AxesOriginY' | 'PlotRange' | 'FillType' | 'FrameType' | 'BackColor' ) '=' ( POINTS | '{' POINTS ',' POINTS '}' | '{' POINTS ',' POINTS ',' POINTS '}' | FLOAT | STRING | INT | COLOR )
            {
            root_0 = (Object)adaptor.nil();

            set27=(Token)input.LT(1);
            if ( (input.LA(1)>=29 && input.LA(1)<=39) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set27));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            char_literal28=(Token)match(input,26,FOLLOW_26_in_option372); 
            char_literal28_tree = (Object)adaptor.create(char_literal28);
            adaptor.addChild(root_0, char_literal28_tree);

            // E:\\work\\srt\\antlr\\test\\plot.g:35:2: ( POINTS | '{' POINTS ',' POINTS '}' | '{' POINTS ',' POINTS ',' POINTS '}' | FLOAT | STRING | INT | COLOR )
            int alt7=7;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:35:3: POINTS
                    {
                    POINTS29=(Token)match(input,POINTS,FOLLOW_POINTS_in_option376); 
                    POINTS29_tree = (Object)adaptor.create(POINTS29);
                    adaptor.addChild(root_0, POINTS29_tree);


                    }
                    break;
                case 2 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:35:10: '{' POINTS ',' POINTS '}'
                    {
                    char_literal30=(Token)match(input,28,FOLLOW_28_in_option378); 
                    char_literal30_tree = (Object)adaptor.create(char_literal30);
                    adaptor.addChild(root_0, char_literal30_tree);

                    POINTS31=(Token)match(input,POINTS,FOLLOW_POINTS_in_option379); 
                    POINTS31_tree = (Object)adaptor.create(POINTS31);
                    adaptor.addChild(root_0, POINTS31_tree);

                    char_literal32=(Token)match(input,23,FOLLOW_23_in_option380); 
                    char_literal32_tree = (Object)adaptor.create(char_literal32);
                    adaptor.addChild(root_0, char_literal32_tree);

                    POINTS33=(Token)match(input,POINTS,FOLLOW_POINTS_in_option381); 
                    POINTS33_tree = (Object)adaptor.create(POINTS33);
                    adaptor.addChild(root_0, POINTS33_tree);

                    char_literal34=(Token)match(input,40,FOLLOW_40_in_option382); 
                    char_literal34_tree = (Object)adaptor.create(char_literal34);
                    adaptor.addChild(root_0, char_literal34_tree);


                    }
                    break;
                case 3 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:35:32: '{' POINTS ',' POINTS ',' POINTS '}'
                    {
                    char_literal35=(Token)match(input,28,FOLLOW_28_in_option384); 
                    char_literal35_tree = (Object)adaptor.create(char_literal35);
                    adaptor.addChild(root_0, char_literal35_tree);

                    POINTS36=(Token)match(input,POINTS,FOLLOW_POINTS_in_option385); 
                    POINTS36_tree = (Object)adaptor.create(POINTS36);
                    adaptor.addChild(root_0, POINTS36_tree);

                    char_literal37=(Token)match(input,23,FOLLOW_23_in_option386); 
                    char_literal37_tree = (Object)adaptor.create(char_literal37);
                    adaptor.addChild(root_0, char_literal37_tree);

                    POINTS38=(Token)match(input,POINTS,FOLLOW_POINTS_in_option387); 
                    POINTS38_tree = (Object)adaptor.create(POINTS38);
                    adaptor.addChild(root_0, POINTS38_tree);

                    char_literal39=(Token)match(input,23,FOLLOW_23_in_option388); 
                    char_literal39_tree = (Object)adaptor.create(char_literal39);
                    adaptor.addChild(root_0, char_literal39_tree);

                    POINTS40=(Token)match(input,POINTS,FOLLOW_POINTS_in_option389); 
                    POINTS40_tree = (Object)adaptor.create(POINTS40);
                    adaptor.addChild(root_0, POINTS40_tree);

                    char_literal41=(Token)match(input,40,FOLLOW_40_in_option390); 
                    char_literal41_tree = (Object)adaptor.create(char_literal41);
                    adaptor.addChild(root_0, char_literal41_tree);


                    }
                    break;
                case 4 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:35:63: FLOAT
                    {
                    FLOAT42=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_option392); 
                    FLOAT42_tree = (Object)adaptor.create(FLOAT42);
                    adaptor.addChild(root_0, FLOAT42_tree);


                    }
                    break;
                case 5 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:35:69: STRING
                    {
                    STRING43=(Token)match(input,STRING,FOLLOW_STRING_in_option394); 
                    STRING43_tree = (Object)adaptor.create(STRING43);
                    adaptor.addChild(root_0, STRING43_tree);


                    }
                    break;
                case 6 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:35:76: INT
                    {
                    INT44=(Token)match(input,INT,FOLLOW_INT_in_option396); 
                    INT44_tree = (Object)adaptor.create(INT44);
                    adaptor.addChild(root_0, INT44_tree);


                    }
                    break;
                case 7 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:35:80: COLOR
                    {
                    COLOR45=(Token)match(input,COLOR,FOLLOW_COLOR_in_option398); 
                    COLOR45_tree = (Object)adaptor.create(COLOR45);
                    adaptor.addChild(root_0, COLOR45_tree);


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


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\14\uffff";
    static final String DFA7_eofS =
        "\14\uffff";
    static final String DFA7_minS =
        "\1\5\1\uffff\1\6\4\uffff\1\27\1\6\1\27\2\uffff";
    static final String DFA7_maxS =
        "\1\34\1\uffff\1\6\4\uffff\1\27\1\6\1\50\2\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\5\1\6\1\7\3\uffff\1\2\1\3";
    static final String DFA7_specialS =
        "\14\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\3\1\1\2\uffff\1\6\2\uffff\1\5\1\4\16\uffff\1\2",
            "",
            "\1\7",
            "",
            "",
            "",
            "",
            "\1\10",
            "\1\11",
            "\1\13\20\uffff\1\12",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "35:2: ( POINTS | '{' POINTS ',' POINTS '}' | '{' POINTS ',' POINTS ',' POINTS '}' | FLOAT | STRING | INT | COLOR )";
        }
    }
 

    public static final BitSet FOLLOW_statement_in_program18 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement26 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expression35 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_expression40 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_shape_in_expression42 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_expression44 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_shape_in_expression45 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_expression49 = new BitSet(new long[]{0x000000FFE2000000L});
    public static final BitSet FOLLOW_option_in_expression51 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_23_in_expression53 = new BitSet(new long[]{0x000000FFE0000000L});
    public static final BitSet FOLLOW_option_in_expression54 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_25_in_expression59 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_shapeoptions294 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_shapeoptions295 = new BitSet(new long[]{0x0000000000001F20L});
    public static final BitSet FOLLOW_set_in_shapeoptions296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHAPE_IDT_in_shape318 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_shape320 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_shape321 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_POINTS_in_shape323 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_shape325 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_POINTS_in_shape326 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_shape329 = new BitSet(new long[]{0x0000000002000080L});
    public static final BitSet FOLLOW_shapeoptions_in_shape331 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_23_in_shape333 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_shapeoptions_in_shape334 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_25_in_shape339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_option349 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_option372 = new BitSet(new long[]{0x0000000010003260L});
    public static final BitSet FOLLOW_POINTS_in_option376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_option378 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_POINTS_in_option379 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_option380 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_POINTS_in_option381 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_option382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_option384 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_POINTS_in_option385 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_option386 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_POINTS_in_option387 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_option388 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_POINTS_in_option389 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_option390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_option392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_option394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_option396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLOR_in_option398 = new BitSet(new long[]{0x0000000000000002L});

}