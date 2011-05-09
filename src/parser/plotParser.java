// $ANTLR 3.3 Nov 30, 2010 12:45:30 E:\\work\\srt\\antlr\\test\\plot.g 2011-04-29 16:41:38
package parser;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

//$ANTLR 3.3 Nov 30, 2010 12:45:30 E:\\work\\srt\\antlr\\test\\plot.g 2011-05-07 22:52:01

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class plotParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SHAPE_IDT", "FLOAT", "VAR", "INT", "COLOR", "JOINFORM", "SIZE", "VERTEXCOLORS", "STRING", "ID", "EXPONENT", "HEX_DIGIT", "UNICODE_ESC", "OCTAL_ESC", "ESC_SEQ", "'GRAPHICS2D'", "'GRAPHICS3D'", "'}]'", "'[SHAPE{'", "','", "'['", "'{'", "'('", "')'", "'},OPTIONS{'", "'='", "'ImageSize'", "'ImageMargins'", "'XRatio'", "'YRatio'", "'Axes'", "'AxesOriginX'", "'AxesOriginY'", "'PlotRangeX'", "'PlotRangeY'", "'FillType'", "'FrameType'", "'BackColor'", "'}'"
    };
    public static final int EOF=-1;
    public static final int T__19=19;
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
    public static final int T__42=42;
    public static final int SHAPE_IDT=4;
    public static final int FLOAT=5;
    public static final int VAR=6;
    public static final int INT=7;
    public static final int COLOR=8;
    public static final int JOINFORM=9;
    public static final int SIZE=10;
    public static final int VERTEXCOLORS=11;
    public static final int STRING=12;
    public static final int ID=13;
    public static final int EXPONENT=14;
    public static final int HEX_DIGIT=15;
    public static final int UNICODE_ESC=16;
    public static final int OCTAL_ESC=17;
    public static final int ESC_SEQ=18;

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // E:\\work\\srt\\antlr\\test\\plot.g:7:1: program : statement ;
    public final plotParser.program_return program() throws RecognitionException {
        plotParser.program_return retval = new plotParser.program_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        plotParser.statement_return statement1 = null;



        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:7:9: ( statement )
            // E:\\work\\srt\\antlr\\test\\plot.g:7:11: statement
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_statement_in_program33);
            statement1=statement();

            state._fsp--;

            adaptor.addChild(root_0, statement1.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // E:\\work\\srt\\antlr\\test\\plot.g:8:1: statement : expression ;
    public final plotParser.statement_return statement() throws RecognitionException {
        plotParser.statement_return retval = new plotParser.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        plotParser.expression_return expression2 = null;



        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:9:2: ( expression )
            // E:\\work\\srt\\antlr\\test\\plot.g:9:3: expression
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_expression_in_statement41);
            expression2=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression2.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // E:\\work\\srt\\antlr\\test\\plot.g:11:1: expression : ( 'GRAPHICS2D' | 'GRAPHICS3D' ) shapes opts '}]' ;
    public final plotParser.expression_return expression() throws RecognitionException {
        plotParser.expression_return retval = new plotParser.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set3=null;
        Token string_literal6=null;
        plotParser.shapes_return shapes4 = null;

        plotParser.opts_return opts5 = null;


        CommonTree set3_tree=null;
        CommonTree string_literal6_tree=null;

        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:11:12: ( ( 'GRAPHICS2D' | 'GRAPHICS3D' ) shapes opts '}]' )
            // E:\\work\\srt\\antlr\\test\\plot.g:11:14: ( 'GRAPHICS2D' | 'GRAPHICS3D' ) shapes opts '}]'
            {
            root_0 = (CommonTree)adaptor.nil();

            set3=(Token)input.LT(1);
            if ( (input.LA(1)>=19 && input.LA(1)<=20) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set3));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            pushFollow(FOLLOW_shapes_in_expression56);
            shapes4=shapes();

            state._fsp--;

            adaptor.addChild(root_0, shapes4.getTree());
            pushFollow(FOLLOW_opts_in_expression58);
            opts5=opts();

            state._fsp--;

            adaptor.addChild(root_0, opts5.getTree());
            string_literal6=(Token)match(input,21,FOLLOW_21_in_expression59); 
            string_literal6_tree = (CommonTree)adaptor.create(string_literal6);
            //adaptor.addChild(root_0, string_literal6_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class shapes_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shapes"
    // E:\\work\\srt\\antlr\\test\\plot.g:12:1: shapes : '[SHAPE{' ( shape ( ',' shape )* ) ;
    public final plotParser.shapes_return shapes() throws RecognitionException {
        plotParser.shapes_return retval = new plotParser.shapes_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal7=null;
        Token char_literal9=null;
        plotParser.shape_return shape8 = null;

        plotParser.shape_return shape10 = null;


        CommonTree string_literal7_tree=null;
        CommonTree char_literal9_tree=null;

        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:12:9: ( '[SHAPE{' ( shape ( ',' shape )* ) )
            // E:\\work\\srt\\antlr\\test\\plot.g:12:10: '[SHAPE{' ( shape ( ',' shape )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal7=(Token)match(input,22,FOLLOW_22_in_shapes66);
            string_literal7.setText("SHAPE");
            string_literal7_tree = (CommonTree)adaptor.create(string_literal7);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal7_tree, root_0);

            // E:\\work\\srt\\antlr\\test\\plot.g:12:21: ( shape ( ',' shape )* )
            // E:\\work\\srt\\antlr\\test\\plot.g:12:22: shape ( ',' shape )*
            {
            pushFollow(FOLLOW_shape_in_shapes70);
            shape8=shape();

            state._fsp--;

            adaptor.addChild(root_0, shape8.getTree());
            // E:\\work\\srt\\antlr\\test\\plot.g:12:27: ( ',' shape )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==23) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // E:\\work\\srt\\antlr\\test\\plot.g:12:28: ',' shape
            	    {
            	    char_literal9=(Token)match(input,23,FOLLOW_23_in_shapes72); 
            	    char_literal9_tree = (CommonTree)adaptor.create(char_literal9);
            	    //adaptor.addChild(root_0, char_literal9_tree);

            	    pushFollow(FOLLOW_shape_in_shapes73);
            	    shape10=shape();

            	    state._fsp--;

            	    adaptor.addChild(root_0, shape10.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "shapes"

    public static class shape_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shape"
    // E:\\work\\srt\\antlr\\test\\plot.g:14:1: shape : SHAPE_IDT '[' '{' pointes shapeopts '}]' ;
    public final plotParser.shape_return shape() throws RecognitionException {
        plotParser.shape_return retval = new plotParser.shape_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SHAPE_IDT11=null;
        Token char_literal12=null;
        Token char_literal13=null;
        Token string_literal16=null;
        plotParser.pointes_return pointes14 = null;

        plotParser.shapeopts_return shapeopts15 = null;


        CommonTree SHAPE_IDT11_tree=null;
        CommonTree char_literal12_tree=null;
        CommonTree char_literal13_tree=null;
        CommonTree string_literal16_tree=null;

        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:14:7: ( SHAPE_IDT '[' '{' pointes shapeopts '}]' )
            // E:\\work\\srt\\antlr\\test\\plot.g:14:8: SHAPE_IDT '[' '{' pointes shapeopts '}]'
            {
            root_0 = (CommonTree)adaptor.nil();

            SHAPE_IDT11=(Token)match(input,SHAPE_IDT,FOLLOW_SHAPE_IDT_in_shape91); 
            SHAPE_IDT11_tree = (CommonTree)adaptor.create(SHAPE_IDT11);
            root_0 = (CommonTree)adaptor.becomeRoot(SHAPE_IDT11_tree, root_0);

            char_literal12=(Token)match(input,24,FOLLOW_24_in_shape93); 
            char_literal12_tree = (CommonTree)adaptor.create(char_literal12);
            //adaptor.addChild(root_0, char_literal12_tree);

            char_literal13=(Token)match(input,25,FOLLOW_25_in_shape94); 
            char_literal13_tree = (CommonTree)adaptor.create(char_literal13);
            //adaptor.addChild(root_0, char_literal13_tree);

            pushFollow(FOLLOW_pointes_in_shape95);
            pointes14=pointes();

            state._fsp--;

            adaptor.addChild(root_0, pointes14.getTree());
            pushFollow(FOLLOW_shapeopts_in_shape97);
            shapeopts15=shapeopts();

            state._fsp--;

            adaptor.addChild(root_0, shapeopts15.getTree());
            string_literal16=(Token)match(input,21,FOLLOW_21_in_shape98); 
            string_literal16_tree = (CommonTree)adaptor.create(string_literal16);
            //adaptor.addChild(root_0, string_literal16_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "shape"

    public static class pointes_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointes"
    // E:\\work\\srt\\antlr\\test\\plot.g:16:1: pointes : points ( ',' points )* ;
    public final plotParser.pointes_return pointes() throws RecognitionException {
        plotParser.pointes_return retval = new plotParser.pointes_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal18=null;
        plotParser.points_return points17 = null;

        plotParser.points_return points19 = null;


        CommonTree char_literal18_tree=null;

        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:16:9: ( points ( ',' points )* )
            // E:\\work\\srt\\antlr\\test\\plot.g:16:11: points ( ',' points )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_points_in_pointes108);
            points17=points();

            state._fsp--;

            adaptor.addChild(root_0, points17.getTree());
            // E:\\work\\srt\\antlr\\test\\plot.g:16:17: ( ',' points )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==23) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // E:\\work\\srt\\antlr\\test\\plot.g:16:18: ',' points
            	    {
            	    char_literal18=(Token)match(input,23,FOLLOW_23_in_pointes110); 
            	    char_literal18_tree = (CommonTree)adaptor.create(char_literal18);
            	    //adaptor.addChild(root_0, char_literal18_tree);

            	    pushFollow(FOLLOW_points_in_pointes111);
            	    points19=points();

            	    state._fsp--;

            	    adaptor.addChild(root_0, points19.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pointes"

    public static class points_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "points"
    // E:\\work\\srt\\antlr\\test\\plot.g:17:1: points : '(' FLOAT ',' FLOAT ',' FLOAT ')' ;
    public final plotParser.points_return points() throws RecognitionException {
        plotParser.points_return retval = new plotParser.points_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal20=null;
        Token FLOAT21=null;
        Token char_literal22=null;
        Token FLOAT23=null;
        Token char_literal24=null;
        Token FLOAT25=null;
        Token char_literal26=null;

        CommonTree char_literal20_tree=null;
        CommonTree FLOAT21_tree=null;
        CommonTree char_literal22_tree=null;
        CommonTree FLOAT23_tree=null;
        CommonTree char_literal24_tree=null;
        CommonTree FLOAT25_tree=null;
        CommonTree char_literal26_tree=null;

        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:17:9: ( '(' FLOAT ',' FLOAT ',' FLOAT ')' )
            // E:\\work\\srt\\antlr\\test\\plot.g:17:10: '(' FLOAT ',' FLOAT ',' FLOAT ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal20=(Token)match(input,26,FOLLOW_26_in_points120); 
            char_literal20.setText("POINT");
            char_literal20_tree = (CommonTree)adaptor.create(char_literal20);
            root_0 = (CommonTree)adaptor.becomeRoot(char_literal20_tree, root_0);

            FLOAT21=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_points122); 
            FLOAT21_tree = (CommonTree)adaptor.create(FLOAT21);
            adaptor.addChild(root_0, FLOAT21_tree);

            char_literal22=(Token)match(input,23,FOLLOW_23_in_points123); 
            char_literal22_tree = (CommonTree)adaptor.create(char_literal22);
            //adaptor.addChild(root_0, char_literal22_tree);

            FLOAT23=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_points124); 
            FLOAT23_tree = (CommonTree)adaptor.create(FLOAT23);
            adaptor.addChild(root_0, FLOAT23_tree);

            char_literal24=(Token)match(input,23,FOLLOW_23_in_points125); 
            char_literal24_tree = (CommonTree)adaptor.create(char_literal24);
            //adaptor.addChild(root_0, char_literal24_tree);

            FLOAT25=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_points126); 
            FLOAT25_tree = (CommonTree)adaptor.create(FLOAT25);
            adaptor.addChild(root_0, FLOAT25_tree);

            char_literal26=(Token)match(input,27,FOLLOW_27_in_points127); 
            char_literal26_tree = (CommonTree)adaptor.create(char_literal26);
            //adaptor.addChild(root_0, char_literal26_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "points"

    public static class shapeopts_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shapeopts"
    // E:\\work\\srt\\antlr\\test\\plot.g:19:1: shapeopts : '},OPTIONS{' ( shapeoptions ( ',' shapeoptions )* )? ;
    public final plotParser.shapeopts_return shapeopts() throws RecognitionException {
        plotParser.shapeopts_return retval = new plotParser.shapeopts_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal27=null;
        Token char_literal29=null;
        plotParser.shapeoptions_return shapeoptions28 = null;

        plotParser.shapeoptions_return shapeoptions30 = null;


        CommonTree string_literal27_tree=null;
        CommonTree char_literal29_tree=null;

        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:19:10: ( '},OPTIONS{' ( shapeoptions ( ',' shapeoptions )* )? )
            // E:\\work\\srt\\antlr\\test\\plot.g:19:11: '},OPTIONS{' ( shapeoptions ( ',' shapeoptions )* )?
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal27=(Token)match(input,28,FOLLOW_28_in_shapeopts141); 
            string_literal27.setText("OPTIONS");
            string_literal27_tree = (CommonTree)adaptor.create(string_literal27);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal27_tree, root_0);

            // E:\\work\\srt\\antlr\\test\\plot.g:19:25: ( shapeoptions ( ',' shapeoptions )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==VAR) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:19:26: shapeoptions ( ',' shapeoptions )*
                    {
                    pushFollow(FOLLOW_shapeoptions_in_shapeopts145);
                    shapeoptions28=shapeoptions();

                    state._fsp--;

                    adaptor.addChild(root_0, shapeoptions28.getTree());
                    // E:\\work\\srt\\antlr\\test\\plot.g:19:38: ( ',' shapeoptions )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==23) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // E:\\work\\srt\\antlr\\test\\plot.g:19:39: ',' shapeoptions
                    	    {
                    	    char_literal29=(Token)match(input,23,FOLLOW_23_in_shapeopts147); 
                    	    char_literal29_tree = (CommonTree)adaptor.create(char_literal29);
                    	    //adaptor.addChild(root_0, char_literal29_tree);

                    	    pushFollow(FOLLOW_shapeoptions_in_shapeopts148);
                    	    shapeoptions30=shapeoptions();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, shapeoptions30.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "shapeopts"

    public static class shapeoptions_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shapeoptions"
    // E:\\work\\srt\\antlr\\test\\plot.g:21:1: shapeoptions : VAR '=' ( INT | FLOAT | COLOR | JOINFORM | SIZE | VERTEXCOLORS ) ;
    public final plotParser.shapeoptions_return shapeoptions() throws RecognitionException {
        plotParser.shapeoptions_return retval = new plotParser.shapeoptions_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VAR31=null;
        Token char_literal32=null;
        Token set33=null;

        CommonTree VAR31_tree=null;
        CommonTree char_literal32_tree=null;
        CommonTree set33_tree=null;

        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:21:13: ( VAR '=' ( INT | FLOAT | COLOR | JOINFORM | SIZE | VERTEXCOLORS ) )
            // E:\\work\\srt\\antlr\\test\\plot.g:21:14: VAR '=' ( INT | FLOAT | COLOR | JOINFORM | SIZE | VERTEXCOLORS )
            {
            root_0 = (CommonTree)adaptor.nil();

            VAR31=(Token)match(input,VAR,FOLLOW_VAR_in_shapeoptions160); 
            VAR31_tree = (CommonTree)adaptor.create(VAR31);
            root_0 = (CommonTree)adaptor.becomeRoot(VAR31_tree, root_0);

            char_literal32=(Token)match(input,29,FOLLOW_29_in_shapeoptions162); 
            char_literal32_tree = (CommonTree)adaptor.create(char_literal32);
            //adaptor.addChild(root_0, char_literal32_tree);

            set33=(Token)input.LT(1);
            if ( input.LA(1)==FLOAT||(input.LA(1)>=INT && input.LA(1)<=VERTEXCOLORS) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set33));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "shapeoptions"

    public static class opts_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "opts"
    // E:\\work\\srt\\antlr\\test\\plot.g:23:1: opts : '},OPTIONS{' ( option ( ',' option )* )? ;
    public final plotParser.opts_return opts() throws RecognitionException {
        plotParser.opts_return retval = new plotParser.opts_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal34=null;
        Token char_literal36=null;
        plotParser.option_return option35 = null;

        plotParser.option_return option37 = null;


        CommonTree string_literal34_tree=null;
        CommonTree char_literal36_tree=null;

        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:23:6: ( '},OPTIONS{' ( option ( ',' option )* )? )
            // E:\\work\\srt\\antlr\\test\\plot.g:23:7: '},OPTIONS{' ( option ( ',' option )* )?
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal34=(Token)match(input,28,FOLLOW_28_in_opts183); 
            string_literal34.setText("OPTIONS");
            string_literal34_tree = (CommonTree)adaptor.create(string_literal34);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal34_tree, root_0);

            // E:\\work\\srt\\antlr\\test\\plot.g:23:21: ( option ( ',' option )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=30 && LA6_0<=41)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:23:22: option ( ',' option )*
                    {
                    pushFollow(FOLLOW_option_in_opts187);
                    option35=option();

                    state._fsp--;

                    adaptor.addChild(root_0, option35.getTree());
                    // E:\\work\\srt\\antlr\\test\\plot.g:23:28: ( ',' option )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==23) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // E:\\work\\srt\\antlr\\test\\plot.g:23:29: ',' option
                    	    {
                    	    char_literal36=(Token)match(input,23,FOLLOW_23_in_opts189); 
                    	    char_literal36_tree = (CommonTree)adaptor.create(char_literal36);
                    	    //adaptor.addChild(root_0, char_literal36_tree);

                    	    pushFollow(FOLLOW_option_in_opts190);
                    	    option37=option();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, option37.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "opts"

    public static class option_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "option"
    // E:\\work\\srt\\antlr\\test\\plot.g:24:1: option : ( 'ImageSize' | 'ImageMargins' | 'XRatio' | 'YRatio' | 'Axes' | 'AxesOriginX' | 'AxesOriginY' | 'PlotRangeX' | 'PlotRangeY' | 'FillType' | 'FrameType' | 'BackColor' ) '=' ( points | '{' points ',' points '}' | '{' points ',' points ',' points '}' | FLOAT | STRING | INT | COLOR ) ;
    public final plotParser.option_return option() throws RecognitionException {
        plotParser.option_return retval = new plotParser.option_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set38=null;
        Token char_literal39=null;
        Token char_literal41=null;
        Token char_literal43=null;
        Token char_literal45=null;
        Token char_literal46=null;
        Token char_literal48=null;
        Token char_literal50=null;
        Token char_literal52=null;
        Token FLOAT53=null;
        Token STRING54=null;
        Token INT55=null;
        Token COLOR56=null;
        plotParser.points_return points40 = null;

        plotParser.points_return points42 = null;

        plotParser.points_return points44 = null;

        plotParser.points_return points47 = null;

        plotParser.points_return points49 = null;

        plotParser.points_return points51 = null;


        CommonTree set38_tree=null;
        CommonTree char_literal39_tree=null;
        CommonTree char_literal41_tree=null;
        CommonTree char_literal43_tree=null;
        CommonTree char_literal45_tree=null;
        CommonTree char_literal46_tree=null;
        CommonTree char_literal48_tree=null;
        CommonTree char_literal50_tree=null;
        CommonTree char_literal52_tree=null;
        CommonTree FLOAT53_tree=null;
        CommonTree STRING54_tree=null;
        CommonTree INT55_tree=null;
        CommonTree COLOR56_tree=null;

        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:24:8: ( ( 'ImageSize' | 'ImageMargins' | 'XRatio' | 'YRatio' | 'Axes' | 'AxesOriginX' | 'AxesOriginY' | 'PlotRangeX' | 'PlotRangeY' | 'FillType' | 'FrameType' | 'BackColor' ) '=' ( points | '{' points ',' points '}' | '{' points ',' points ',' points '}' | FLOAT | STRING | INT | COLOR ) )
            // E:\\work\\srt\\antlr\\test\\plot.g:24:9: ( 'ImageSize' | 'ImageMargins' | 'XRatio' | 'YRatio' | 'Axes' | 'AxesOriginX' | 'AxesOriginY' | 'PlotRangeX' | 'PlotRangeY' | 'FillType' | 'FrameType' | 'BackColor' ) '=' ( points | '{' points ',' points '}' | '{' points ',' points ',' points '}' | FLOAT | STRING | INT | COLOR )
            {
            root_0 = (CommonTree)adaptor.nil();

            set38=(Token)input.LT(1);
            set38=(Token)input.LT(1);
            if ( (input.LA(1)>=30 && input.LA(1)<=41) ) {
                input.consume();
                root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set38), root_0);
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            char_literal39=(Token)match(input,29,FOLLOW_29_in_option238); 
            char_literal39_tree = (CommonTree)adaptor.create(char_literal39);
            //adaptor.addChild(root_0, char_literal39_tree);

            // E:\\work\\srt\\antlr\\test\\plot.g:26:2: ( points | '{' points ',' points '}' | '{' points ',' points ',' points '}' | FLOAT | STRING | INT | COLOR )
            int alt7=7;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:26:3: points
                    {
                    pushFollow(FOLLOW_points_in_option242);
                    points40=points();

                    state._fsp--;

                    adaptor.addChild(root_0, points40.getTree());

                    }
                    break;
                case 2 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:26:10: '{' points ',' points '}'
                    {
                    char_literal41=(Token)match(input,25,FOLLOW_25_in_option244); 
                    char_literal41_tree = (CommonTree)adaptor.create(char_literal41);
                    //adaptor.addChild(root_0, char_literal41_tree);

                    pushFollow(FOLLOW_points_in_option245);
                    points42=points();

                    state._fsp--;

                    adaptor.addChild(root_0, points42.getTree());
                    char_literal43=(Token)match(input,23,FOLLOW_23_in_option246); 
                    char_literal43_tree = (CommonTree)adaptor.create(char_literal43);
                    adaptor.addChild(root_0, char_literal43_tree);

                    pushFollow(FOLLOW_points_in_option247);
                    points44=points();

                    state._fsp--;

                    adaptor.addChild(root_0, points44.getTree());
                    char_literal45=(Token)match(input,42,FOLLOW_42_in_option248); 
                    char_literal45_tree = (CommonTree)adaptor.create(char_literal45);
                    adaptor.addChild(root_0, char_literal45_tree);


                    }
                    break;
                case 3 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:26:32: '{' points ',' points ',' points '}'
                    {
                    char_literal46=(Token)match(input,25,FOLLOW_25_in_option250); 
                    char_literal46_tree = (CommonTree)adaptor.create(char_literal46);
                    adaptor.addChild(root_0, char_literal46_tree);

                    pushFollow(FOLLOW_points_in_option251);
                    points47=points();

                    state._fsp--;

                    adaptor.addChild(root_0, points47.getTree());
                    char_literal48=(Token)match(input,23,FOLLOW_23_in_option252); 
                    char_literal48_tree = (CommonTree)adaptor.create(char_literal48);
                    adaptor.addChild(root_0, char_literal48_tree);

                    pushFollow(FOLLOW_points_in_option253);
                    points49=points();

                    state._fsp--;

                    adaptor.addChild(root_0, points49.getTree());
                    char_literal50=(Token)match(input,23,FOLLOW_23_in_option254); 
                    char_literal50_tree = (CommonTree)adaptor.create(char_literal50);
                    adaptor.addChild(root_0, char_literal50_tree);

                    pushFollow(FOLLOW_points_in_option255);
                    points51=points();

                    state._fsp--;

                    adaptor.addChild(root_0, points51.getTree());
                    char_literal52=(Token)match(input,42,FOLLOW_42_in_option256); 
                    char_literal52_tree = (CommonTree)adaptor.create(char_literal52);
                    adaptor.addChild(root_0, char_literal52_tree);


                    }
                    break;
                case 4 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:26:63: FLOAT
                    {
                    FLOAT53=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_option258); 
                    FLOAT53_tree = (CommonTree)adaptor.create(FLOAT53);
                    adaptor.addChild(root_0, FLOAT53_tree);


                    }
                    break;
                case 5 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:26:69: STRING
                    {
                    STRING54=(Token)match(input,STRING,FOLLOW_STRING_in_option260); 
                    STRING54_tree = (CommonTree)adaptor.create(STRING54);
                    adaptor.addChild(root_0, STRING54_tree);


                    }
                    break;
                case 6 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:26:76: INT
                    {
                    INT55=(Token)match(input,INT,FOLLOW_INT_in_option262); 
                    INT55_tree = (CommonTree)adaptor.create(INT55);
                    adaptor.addChild(root_0, INT55_tree);


                    }
                    break;
                case 7 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:26:80: COLOR
                    {
                    COLOR56=(Token)match(input,COLOR,FOLLOW_COLOR_in_option264); 
                    COLOR56_tree = (CommonTree)adaptor.create(COLOR56);
                    adaptor.addChild(root_0, COLOR56_tree);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "option"

    // Delegated rules


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\30\uffff";
    static final String DFA7_eofS =
        "\30\uffff";
    static final String DFA7_minS =
        "\1\5\1\uffff\1\32\4\uffff\1\5\1\27\1\5\1\27\1\5\1\33\1\27\1\32"+
        "\1\5\1\27\1\5\1\27\1\5\1\33\1\27\2\uffff";
    static final String DFA7_maxS =
        "\1\32\1\uffff\1\32\4\uffff\1\5\1\27\1\5\1\27\1\5\1\33\1\27\1\32"+
        "\1\5\1\27\1\5\1\27\1\5\1\33\1\52\2\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\5\1\6\1\7\17\uffff\1\2\1\3";
    static final String DFA7_specialS =
        "\30\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\3\1\uffff\1\5\1\6\3\uffff\1\4\14\uffff\1\2\1\1",
            "",
            "\1\7",
            "",
            "",
            "",
            "",
            "\1\10",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\20",
            "\1\21",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\27\22\uffff\1\26",
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
            return "26:2: ( points | '{' points ',' points '}' | '{' points ',' points ',' points '}' | FLOAT | STRING | INT | COLOR )";
        }
    }
 

    public static final BitSet FOLLOW_statement_in_program33 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement41 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expression50 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_shapes_in_expression56 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_opts_in_expression58 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_expression59 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_shapes66 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_shape_in_shapes70 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_shapes72 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_shape_in_shapes73 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_SHAPE_IDT_in_shape91 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_shape93 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_shape94 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_pointes_in_shape95 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_shapeopts_in_shape97 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_shape98 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_points_in_pointes108 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_pointes110 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_points_in_pointes111 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_26_in_points120 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_FLOAT_in_points122 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_points123 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_FLOAT_in_points124 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_points125 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_FLOAT_in_points126 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_points127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_shapeopts141 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_shapeoptions_in_shapeopts145 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_shapeopts147 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_shapeoptions_in_shapeopts148 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_VAR_in_shapeoptions160 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_shapeoptions162 = new BitSet(new long[]{0x0000000000000FA0L});
    public static final BitSet FOLLOW_set_in_shapeoptions163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_opts183 = new BitSet(new long[]{0x000003FFC0000002L});
    public static final BitSet FOLLOW_option_in_opts187 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_opts189 = new BitSet(new long[]{0x000003FFC0000000L});
    public static final BitSet FOLLOW_option_in_opts190 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_set_in_option202 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_option238 = new BitSet(new long[]{0x00000000060011A0L});
    public static final BitSet FOLLOW_points_in_option242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_option244 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_points_in_option245 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_option246 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_points_in_option247 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_option248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_option250 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_points_in_option251 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_option252 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_points_in_option253 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_option254 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_points_in_option255 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_option256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_option258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_option260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_option262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLOR_in_option264 = new BitSet(new long[]{0x0000000000000002L});

}