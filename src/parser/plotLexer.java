// $ANTLR 3.3 Nov 30, 2010 12:45:30 E:\\work\\srt\\antlr\\test\\plot.g 2011-04-29 16:41:38
package parser;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class plotLexer extends Lexer {
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

    public plotLexer() {;} 
    public plotLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public plotLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "E:\\work\\srt\\antlr\\test\\plot.g"; }

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:3:7: ( 'GRAPHICS2D' )
            // E:\\work\\srt\\antlr\\test\\plot.g:3:9: 'GRAPHICS2D'
            {
            match("GRAPHICS2D"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:4:7: ( 'GRAPHICS3D' )
            // E:\\work\\srt\\antlr\\test\\plot.g:4:9: 'GRAPHICS3D'
            {
            match("GRAPHICS3D"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:5:7: ( '[SHAPE{' )
            // E:\\work\\srt\\antlr\\test\\plot.g:5:9: '[SHAPE{'
            {
            match("[SHAPE{"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:6:7: ( ',' )
            // E:\\work\\srt\\antlr\\test\\plot.g:6:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:7:7: ( '},OPTIONS{' )
            // E:\\work\\srt\\antlr\\test\\plot.g:7:9: '},OPTIONS{'
            {
            match("},OPTIONS{"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:8:7: ( '}]' )
            // E:\\work\\srt\\antlr\\test\\plot.g:8:9: '}]'
            {
            match("}]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:9:7: ( '=' )
            // E:\\work\\srt\\antlr\\test\\plot.g:9:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:10:7: ( '[' )
            // E:\\work\\srt\\antlr\\test\\plot.g:10:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:11:7: ( '{' )
            // E:\\work\\srt\\antlr\\test\\plot.g:11:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:12:7: ( 'ImageSize' )
            // E:\\work\\srt\\antlr\\test\\plot.g:12:9: 'ImageSize'
            {
            match("ImageSize"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:13:7: ( 'ImageMargins' )
            // E:\\work\\srt\\antlr\\test\\plot.g:13:9: 'ImageMargins'
            {
            match("ImageMargins"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:14:7: ( 'XRatio' )
            // E:\\work\\srt\\antlr\\test\\plot.g:14:9: 'XRatio'
            {
            match("XRatio"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:15:7: ( 'YRatio' )
            // E:\\work\\srt\\antlr\\test\\plot.g:15:9: 'YRatio'
            {
            match("YRatio"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:16:7: ( 'Axes' )
            // E:\\work\\srt\\antlr\\test\\plot.g:16:9: 'Axes'
            {
            match("Axes"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:17:7: ( 'AxesOriginX' )
            // E:\\work\\srt\\antlr\\test\\plot.g:17:9: 'AxesOriginX'
            {
            match("AxesOriginX"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:18:7: ( 'AxesOriginY' )
            // E:\\work\\srt\\antlr\\test\\plot.g:18:9: 'AxesOriginY'
            {
            match("AxesOriginY"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:19:7: ( 'PlotRange' )
            // E:\\work\\srt\\antlr\\test\\plot.g:19:9: 'PlotRange'
            {
            match("PlotRange"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:20:7: ( 'FillType' )
            // E:\\work\\srt\\antlr\\test\\plot.g:20:9: 'FillType'
            {
            match("FillType"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:21:7: ( 'FrameType' )
            // E:\\work\\srt\\antlr\\test\\plot.g:21:9: 'FrameType'
            {
            match("FrameType"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:22:7: ( 'BackColor' )
            // E:\\work\\srt\\antlr\\test\\plot.g:22:9: 'BackColor'
            {
            match("BackColor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:23:7: ( '}' )
            // E:\\work\\srt\\antlr\\test\\plot.g:23:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "SHAPE_IDT"
    public final void mSHAPE_IDT() throws RecognitionException {
        try {
            int _type = SHAPE_IDT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:10:10: ( 'POINT2D' | 'POINT3D' | 'LINE2D' | 'LINE3D' | 'POLYGON2D' | 'POLYGON3D' | 'ARC' | 'BEZIERCURVE2D' | 'BEZIERCURVE3D' | 'BSPLINECURVE2D' | 'BSPLINECURVE3D' | 'BEZIERSURFACE' | 'BSPLINESURFACE' | 'DISH' | 'CIRCLE2D' | 'CIRCLE3D' | 'ELLIPSE2D' | 'ELLIPSE3D' | 'RECTANGL' | 'SPHERE' | 'ELLIPSOID' | 'CUBOID' | 'CYLINDER' | 'CONE' | 'CONVEXHULL2D' | 'CONVEXHULL3D' )
            int alt1=26;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:10:12: 'POINT2D'
                    {
                    match("POINT2D"); 


                    }
                    break;
                case 2 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:10:22: 'POINT3D'
                    {
                    match("POINT3D"); 


                    }
                    break;
                case 3 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:10:32: 'LINE2D'
                    {
                    match("LINE2D"); 


                    }
                    break;
                case 4 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:10:41: 'LINE3D'
                    {
                    match("LINE3D"); 


                    }
                    break;
                case 5 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:10:50: 'POLYGON2D'
                    {
                    match("POLYGON2D"); 


                    }
                    break;
                case 6 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:10:62: 'POLYGON3D'
                    {
                    match("POLYGON3D"); 


                    }
                    break;
                case 7 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:10:74: 'ARC'
                    {
                    match("ARC"); 


                    }
                    break;
                case 8 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:10:80: 'BEZIERCURVE2D'
                    {
                    match("BEZIERCURVE2D"); 


                    }
                    break;
                case 9 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:10:96: 'BEZIERCURVE3D'
                    {
                    match("BEZIERCURVE3D"); 


                    }
                    break;
                case 10 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:10:112: 'BSPLINECURVE2D'
                    {
                    match("BSPLINECURVE2D"); 


                    }
                    break;
                case 11 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:11:13: 'BSPLINECURVE3D'
                    {
                    match("BSPLINECURVE3D"); 


                    }
                    break;
                case 12 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:11:30: 'BEZIERSURFACE'
                    {
                    match("BEZIERSURFACE"); 


                    }
                    break;
                case 13 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:11:46: 'BSPLINESURFACE'
                    {
                    match("BSPLINESURFACE"); 


                    }
                    break;
                case 14 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:11:63: 'DISH'
                    {
                    match("DISH"); 


                    }
                    break;
                case 15 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:11:70: 'CIRCLE2D'
                    {
                    match("CIRCLE2D"); 


                    }
                    break;
                case 16 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:11:81: 'CIRCLE3D'
                    {
                    match("CIRCLE3D"); 


                    }
                    break;
                case 17 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:11:92: 'ELLIPSE2D'
                    {
                    match("ELLIPSE2D"); 


                    }
                    break;
                case 18 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:11:104: 'ELLIPSE3D'
                    {
                    match("ELLIPSE3D"); 


                    }
                    break;
                case 19 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:11:116: 'RECTANGL'
                    {
                    match("RECTANGL"); 


                    }
                    break;
                case 20 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:11:127: 'SPHERE'
                    {
                    match("SPHERE"); 


                    }
                    break;
                case 21 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:12:13: 'ELLIPSOID'
                    {
                    match("ELLIPSOID"); 


                    }
                    break;
                case 22 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:12:25: 'CUBOID'
                    {
                    match("CUBOID"); 


                    }
                    break;
                case 23 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:12:34: 'CYLINDER'
                    {
                    match("CYLINDER"); 


                    }
                    break;
                case 24 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:12:45: 'CONE'
                    {
                    match("CONE"); 


                    }
                    break;
                case 25 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:12:52: 'CONVEXHULL2D'
                    {
                    match("CONVEXHULL2D"); 


                    }
                    break;
                case 26 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:12:67: 'CONVEXHULL3D'
                    {
                    match("CONVEXHULL3D"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SHAPE_IDT"

    // $ANTLR start "POINTS"
    public final void mPOINTS() throws RecognitionException {
        try {
            int _type = POINTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:15:9: ( '{' FLOAT ',' FLOAT ',' FLOAT '}' )
            // E:\\work\\srt\\antlr\\test\\plot.g:15:10: '{' FLOAT ',' FLOAT ',' FLOAT '}'
            {
            match('{'); 
            mFLOAT(); 
            match(','); 
            mFLOAT(); 
            match(','); 
            mFLOAT(); 
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POINTS"

    // $ANTLR start "VAR"
    public final void mVAR() throws RecognitionException {
        try {
            int _type = VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:17:5: ( 'POINTSIZE' | 'COLOR2D' | 'COLOR3D' | 'THICKNESS' | 'DASHING' | 'JOINFORM' | 'VERTEXCOLORS' | 'EDGECOLOR' | 'OPACITY' )
            int alt2=9;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:17:6: 'POINTSIZE'
                    {
                    match("POINTSIZE"); 


                    }
                    break;
                case 2 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:17:18: 'COLOR2D'
                    {
                    match("COLOR2D"); 


                    }
                    break;
                case 3 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:17:28: 'COLOR3D'
                    {
                    match("COLOR3D"); 


                    }
                    break;
                case 4 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:17:38: 'THICKNESS'
                    {
                    match("THICKNESS"); 


                    }
                    break;
                case 5 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:17:50: 'DASHING'
                    {
                    match("DASHING"); 


                    }
                    break;
                case 6 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:17:60: 'JOINFORM'
                    {
                    match("JOINFORM"); 


                    }
                    break;
                case 7 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:17:71: 'VERTEXCOLORS'
                    {
                    match("VERTEXCOLORS"); 


                    }
                    break;
                case 8 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:17:86: 'EDGECOLOR'
                    {
                    match("EDGECOLOR"); 


                    }
                    break;
                case 9 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:17:98: 'OPACITY'
                    {
                    match("OPACITY"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAR"

    // $ANTLR start "SIZE"
    public final void mSIZE() throws RecognitionException {
        try {
            int _type = SIZE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:19:9: ( 'TINY' | 'SMALL' | 'MEDIUM' | 'LARGE' )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 'T':
                {
                alt3=1;
                }
                break;
            case 'S':
                {
                alt3=2;
                }
                break;
            case 'M':
                {
                alt3=3;
                }
                break;
            case 'L':
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:19:10: 'TINY'
                    {
                    match("TINY"); 


                    }
                    break;
                case 2 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:19:17: 'SMALL'
                    {
                    match("SMALL"); 


                    }
                    break;
                case 3 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:19:25: 'MEDIUM'
                    {
                    match("MEDIUM"); 


                    }
                    break;
                case 4 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:19:34: 'LARGE'
                    {
                    match("LARGE"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SIZE"

    // $ANTLR start "COLOR"
    public final void mCOLOR() throws RecognitionException {
        try {
            int _type = COLOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:21:9: ( 'WHITE' | 'BLACK' | 'PINK' | 'GREEN' | 'BLUE' | 'RED' | 'YELLOW' )
            int alt4=7;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:21:11: 'WHITE'
                    {
                    match("WHITE"); 


                    }
                    break;
                case 2 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:21:19: 'BLACK'
                    {
                    match("BLACK"); 


                    }
                    break;
                case 3 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:21:27: 'PINK'
                    {
                    match("PINK"); 


                    }
                    break;
                case 4 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:21:34: 'GREEN'
                    {
                    match("GREEN"); 


                    }
                    break;
                case 5 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:21:42: 'BLUE'
                    {
                    match("BLUE"); 


                    }
                    break;
                case 6 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:21:49: 'RED'
                    {
                    match("RED"); 


                    }
                    break;
                case 7 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:21:55: 'YELLOW'
                    {
                    match("YELLOW"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLOR"

    // $ANTLR start "JOINFORM"
    public final void mJOINFORM() throws RecognitionException {
        try {
            int _type = JOINFORM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:23:9: ( 'BEVEL' | 'ROUND' | 'MITER' )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 'B':
                {
                alt5=1;
                }
                break;
            case 'R':
                {
                alt5=2;
                }
                break;
            case 'M':
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:23:10: 'BEVEL'
                    {
                    match("BEVEL"); 


                    }
                    break;
                case 2 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:23:18: 'ROUND'
                    {
                    match("ROUND"); 


                    }
                    break;
                case 3 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:23:26: 'MITER'
                    {
                    match("MITER"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "JOINFORM"

    // $ANTLR start "VERTEXCOLORS"
    public final void mVERTEXCOLORS() throws RecognitionException {
        try {
            int _type = VERTEXCOLORS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:25:13: ( '{' COLOR ( ',' COLOR )* '}' )
            // E:\\work\\srt\\antlr\\test\\plot.g:25:14: '{' COLOR ( ',' COLOR )* '}'
            {
            match('{'); 
            mCOLOR(); 
            // E:\\work\\srt\\antlr\\test\\plot.g:25:22: ( ',' COLOR )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==',') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // E:\\work\\srt\\antlr\\test\\plot.g:25:23: ',' COLOR
            	    {
            	    match(','); 
            	    mCOLOR(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VERTEXCOLORS"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:37:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // E:\\work\\srt\\antlr\\test\\plot.g:37:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // E:\\work\\srt\\antlr\\test\\plot.g:37:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')||(LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // E:\\work\\srt\\antlr\\test\\plot.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:41:5: ( ( '0' .. '9' )+ )
            // E:\\work\\srt\\antlr\\test\\plot.g:41:7: ( '0' .. '9' )+
            {
            // E:\\work\\srt\\antlr\\test\\plot.g:41:7: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // E:\\work\\srt\\antlr\\test\\plot.g:41:7: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:45:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT )
            int alt15=3;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:45:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )?
                    {
                    // E:\\work\\srt\\antlr\\test\\plot.g:45:9: ( '0' .. '9' )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // E:\\work\\srt\\antlr\\test\\plot.g:45:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    match('.'); 
                    // E:\\work\\srt\\antlr\\test\\plot.g:45:25: ( '0' .. '9' )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // E:\\work\\srt\\antlr\\test\\plot.g:45:26: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    // E:\\work\\srt\\antlr\\test\\plot.g:45:37: ( EXPONENT )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='E'||LA11_0=='e') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // E:\\work\\srt\\antlr\\test\\plot.g:45:37: EXPONENT
                            {
                            mEXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:46:9: '.' ( '0' .. '9' )+ ( EXPONENT )?
                    {
                    match('.'); 
                    // E:\\work\\srt\\antlr\\test\\plot.g:46:13: ( '0' .. '9' )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // E:\\work\\srt\\antlr\\test\\plot.g:46:14: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    // E:\\work\\srt\\antlr\\test\\plot.g:46:25: ( EXPONENT )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='E'||LA13_0=='e') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // E:\\work\\srt\\antlr\\test\\plot.g:46:25: EXPONENT
                            {
                            mEXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:47:9: ( '0' .. '9' )+ EXPONENT
                    {
                    // E:\\work\\srt\\antlr\\test\\plot.g:47:9: ( '0' .. '9' )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // E:\\work\\srt\\antlr\\test\\plot.g:47:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);

                    mEXPONENT(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\work\\srt\\antlr\\test\\plot.g:51:5: ( ( 'A' .. 'Z' | 'a' .. 'z' | ' ' )+ )
            // E:\\work\\srt\\antlr\\test\\plot.g:51:9: ( 'A' .. 'Z' | 'a' .. 'z' | ' ' )+
            {
            // E:\\work\\srt\\antlr\\test\\plot.g:51:9: ( 'A' .. 'Z' | 'a' .. 'z' | ' ' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==' '||(LA16_0>='A' && LA16_0<='Z')||(LA16_0>='a' && LA16_0<='z')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // E:\\work\\srt\\antlr\\test\\plot.g:
            	    {
            	    if ( input.LA(1)==' '||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:55:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // E:\\work\\srt\\antlr\\test\\plot.g:55:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // E:\\work\\srt\\antlr\\test\\plot.g:55:22: ( '+' | '-' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='+'||LA17_0=='-') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // E:\\work\\srt\\antlr\\test\\plot.g:55:33: ( '0' .. '9' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='0' && LA18_0<='9')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // E:\\work\\srt\\antlr\\test\\plot.g:55:34: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:58:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // E:\\work\\srt\\antlr\\test\\plot.g:58:13: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:62:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt19=3;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt19=1;
                    }
                    break;
                case 'u':
                    {
                    alt19=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt19=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:62:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 
                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:63:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 

                    }
                    break;
                case 3 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:64:9: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:69:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt20=3;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='\\') ) {
                int LA20_1 = input.LA(2);

                if ( ((LA20_1>='0' && LA20_1<='3')) ) {
                    int LA20_2 = input.LA(3);

                    if ( ((LA20_2>='0' && LA20_2<='7')) ) {
                        int LA20_4 = input.LA(4);

                        if ( ((LA20_4>='0' && LA20_4<='7')) ) {
                            alt20=1;
                        }
                        else {
                            alt20=2;}
                    }
                    else {
                        alt20=3;}
                }
                else if ( ((LA20_1>='4' && LA20_1<='7')) ) {
                    int LA20_3 = input.LA(3);

                    if ( ((LA20_3>='0' && LA20_3<='7')) ) {
                        alt20=2;
                    }
                    else {
                        alt20=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:69:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // E:\\work\\srt\\antlr\\test\\plot.g:69:14: ( '0' .. '3' )
                    // E:\\work\\srt\\antlr\\test\\plot.g:69:15: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // E:\\work\\srt\\antlr\\test\\plot.g:69:25: ( '0' .. '7' )
                    // E:\\work\\srt\\antlr\\test\\plot.g:69:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // E:\\work\\srt\\antlr\\test\\plot.g:69:36: ( '0' .. '7' )
                    // E:\\work\\srt\\antlr\\test\\plot.g:69:37: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:70:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // E:\\work\\srt\\antlr\\test\\plot.g:70:14: ( '0' .. '7' )
                    // E:\\work\\srt\\antlr\\test\\plot.g:70:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // E:\\work\\srt\\antlr\\test\\plot.g:70:25: ( '0' .. '7' )
                    // E:\\work\\srt\\antlr\\test\\plot.g:70:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // E:\\work\\srt\\antlr\\test\\plot.g:71:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // E:\\work\\srt\\antlr\\test\\plot.g:71:14: ( '0' .. '7' )
                    // E:\\work\\srt\\antlr\\test\\plot.g:71:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // E:\\work\\srt\\antlr\\test\\plot.g:76:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // E:\\work\\srt\\antlr\\test\\plot.g:76:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 
            match('u'); 
            mHEX_DIGIT(); 
            mHEX_DIGIT(); 
            mHEX_DIGIT(); 
            mHEX_DIGIT(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UNICODE_ESC"

    public void mTokens() throws RecognitionException {
        // E:\\work\\srt\\antlr\\test\\plot.g:1:8: ( T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | SHAPE_IDT | POINTS | VAR | SIZE | COLOR | JOINFORM | VERTEXCOLORS | ID | INT | FLOAT | STRING )
        int alt21=32;
        alt21 = dfa21.predict(input);
        switch (alt21) {
            case 1 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:10: T__20
                {
                mT__20(); 

                }
                break;
            case 2 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:16: T__21
                {
                mT__21(); 

                }
                break;
            case 3 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:22: T__22
                {
                mT__22(); 

                }
                break;
            case 4 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:28: T__23
                {
                mT__23(); 

                }
                break;
            case 5 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:34: T__24
                {
                mT__24(); 

                }
                break;
            case 6 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:40: T__25
                {
                mT__25(); 

                }
                break;
            case 7 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:46: T__26
                {
                mT__26(); 

                }
                break;
            case 8 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:52: T__27
                {
                mT__27(); 

                }
                break;
            case 9 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:58: T__28
                {
                mT__28(); 

                }
                break;
            case 10 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:64: T__29
                {
                mT__29(); 

                }
                break;
            case 11 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:70: T__30
                {
                mT__30(); 

                }
                break;
            case 12 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:76: T__31
                {
                mT__31(); 

                }
                break;
            case 13 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:82: T__32
                {
                mT__32(); 

                }
                break;
            case 14 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:88: T__33
                {
                mT__33(); 

                }
                break;
            case 15 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:94: T__34
                {
                mT__34(); 

                }
                break;
            case 16 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:100: T__35
                {
                mT__35(); 

                }
                break;
            case 17 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:106: T__36
                {
                mT__36(); 

                }
                break;
            case 18 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:112: T__37
                {
                mT__37(); 

                }
                break;
            case 19 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:118: T__38
                {
                mT__38(); 

                }
                break;
            case 20 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:124: T__39
                {
                mT__39(); 

                }
                break;
            case 21 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:130: T__40
                {
                mT__40(); 

                }
                break;
            case 22 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:136: SHAPE_IDT
                {
                mSHAPE_IDT(); 

                }
                break;
            case 23 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:146: POINTS
                {
                mPOINTS(); 

                }
                break;
            case 24 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:153: VAR
                {
                mVAR(); 

                }
                break;
            case 25 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:157: SIZE
                {
                mSIZE(); 

                }
                break;
            case 26 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:162: COLOR
                {
                mCOLOR(); 

                }
                break;
            case 27 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:168: JOINFORM
                {
                mJOINFORM(); 

                }
                break;
            case 28 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:177: VERTEXCOLORS
                {
                mVERTEXCOLORS(); 

                }
                break;
            case 29 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:190: ID
                {
                mID(); 

                }
                break;
            case 30 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:193: INT
                {
                mINT(); 

                }
                break;
            case 31 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:197: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 32 :
                // E:\\work\\srt\\antlr\\test\\plot.g:1:203: STRING
                {
                mSTRING(); 

                }
                break;

        }

    }


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA2 dfa2 = new DFA2(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA1_eotS =
        "\125\uffff";
    static final String DFA1_eofS =
        "\125\uffff";
    static final String DFA1_minS =
        "\1\101\1\117\1\111\1\uffff\1\105\1\uffff\1\111\1\114\2\uffff\1"+
        "\111\1\116\1\132\1\120\1\122\2\uffff\1\116\1\114\1\116\1\131\1\105"+
        "\1\111\1\114\1\103\1\105\1\111\1\124\1\107\1\62\1\105\1\111\1\114"+
        "\1\uffff\1\105\1\120\1\62\1\117\2\uffff\1\122\1\116\1\105\1\130"+
        "\1\123\2\uffff\1\116\1\103\1\105\1\62\1\110\1\105\1\62\1\125\1\uffff"+
        "\1\103\2\uffff\1\125\1\62\3\uffff\1\122\1\125\1\uffff\1\114\2\uffff"+
        "\1\126\1\122\1\114\1\105\1\126\2\62\1\105\4\uffff\1\62\2\uffff";
    static final String DFA1_maxS =
        "\1\123\1\117\1\111\1\uffff\1\123\1\uffff\1\131\1\114\2\uffff\1"+
        "\114\1\116\1\132\1\120\1\122\2\uffff\1\116\1\114\1\116\1\131\1\105"+
        "\1\111\1\114\1\103\1\126\1\111\1\124\1\107\1\63\1\105\1\111\1\114"+
        "\1\uffff\1\105\1\120\1\63\1\117\2\uffff\1\122\1\116\1\105\1\130"+
        "\1\123\2\uffff\1\116\1\123\1\105\1\63\1\110\1\117\1\63\1\125\1\uffff"+
        "\1\123\2\uffff\1\125\1\63\3\uffff\1\122\1\125\1\uffff\1\114\2\uffff"+
        "\1\126\1\122\1\114\1\105\1\126\2\63\1\105\4\uffff\1\63\2\uffff";
    static final String DFA1_acceptS =
        "\3\uffff\1\7\1\uffff\1\16\2\uffff\1\23\1\24\5\uffff\1\26\1\27\20"+
        "\uffff\1\30\4\uffff\1\3\1\4\5\uffff\1\1\1\2\10\uffff\1\14\1\uffff"+
        "\1\17\1\20\2\uffff\1\25\1\5\1\6\2\uffff\1\15\1\uffff\1\21\1\22\10"+
        "\uffff\1\31\1\32\1\10\1\11\1\uffff\1\12\1\13";
    static final String DFA1_specialS =
        "\125\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\3\1\4\1\6\1\5\1\7\6\uffff\1\2\3\uffff\1\1\1\uffff\1\10\1"+
            "\11",
            "\1\12",
            "\1\13",
            "",
            "\1\14\15\uffff\1\15",
            "",
            "\1\16\5\uffff\1\21\5\uffff\1\17\3\uffff\1\20",
            "\1\22",
            "",
            "",
            "\1\23\2\uffff\1\24",
            "\1\25",
            "\1\26",
            "\1\27",
            "\1\30",
            "",
            "",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\41\20\uffff\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "",
            "\1\53",
            "\1\54",
            "\1\55\1\56",
            "\1\57",
            "",
            "",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "",
            "",
            "\1\65",
            "\1\66\17\uffff\1\67",
            "\1\70",
            "\1\71\1\72",
            "\1\73",
            "\1\74\11\uffff\1\75",
            "\1\76\1\77",
            "\1\100",
            "",
            "\1\101\17\uffff\1\102",
            "",
            "",
            "\1\103",
            "\1\104\1\105",
            "",
            "",
            "",
            "\1\106",
            "\1\107",
            "",
            "\1\110",
            "",
            "",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116\1\117",
            "\1\120\1\121",
            "\1\122",
            "",
            "",
            "",
            "",
            "\1\123\1\124",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "10:1: SHAPE_IDT : ( 'POINT2D' | 'POINT3D' | 'LINE2D' | 'LINE3D' | 'POLYGON2D' | 'POLYGON3D' | 'ARC' | 'BEZIERCURVE2D' | 'BEZIERCURVE3D' | 'BSPLINECURVE2D' | 'BSPLINECURVE3D' | 'BEZIERSURFACE' | 'BSPLINESURFACE' | 'DISH' | 'CIRCLE2D' | 'CIRCLE3D' | 'ELLIPSE2D' | 'ELLIPSE3D' | 'RECTANGL' | 'SPHERE' | 'ELLIPSOID' | 'CUBOID' | 'CYLINDER' | 'CONE' | 'CONVEXHULL2D' | 'CONVEXHULL3D' );";
        }
    }
    static final String DFA2_eotS =
        "\17\uffff";
    static final String DFA2_eofS =
        "\17\uffff";
    static final String DFA2_minS =
        "\1\103\1\uffff\1\117\6\uffff\1\114\1\117\1\122\1\62\2\uffff";
    static final String DFA2_maxS =
        "\1\126\1\uffff\1\117\6\uffff\1\114\1\117\1\122\1\63\2\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\5\1\6\1\7\1\10\1\11\4\uffff\1\2\1\3";
    static final String DFA2_specialS =
        "\17\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\2\1\4\1\7\4\uffff\1\5\4\uffff\1\10\1\1\3\uffff\1\3\1\uffff"+
            "\1\6",
            "",
            "\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15\1\16",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "17:1: VAR : ( 'POINTSIZE' | 'COLOR2D' | 'COLOR3D' | 'THICKNESS' | 'DASHING' | 'JOINFORM' | 'VERTEXCOLORS' | 'EDGECOLOR' | 'OPACITY' );";
        }
    }
    static final String DFA4_eotS =
        "\12\uffff";
    static final String DFA4_eofS =
        "\12\uffff";
    static final String DFA4_minS =
        "\1\102\1\uffff\1\114\4\uffff\1\101\2\uffff";
    static final String DFA4_maxS =
        "\1\131\1\uffff\1\114\4\uffff\1\125\2\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\4\1\6\1\7\1\uffff\1\2\1\5";
    static final String DFA4_specialS =
        "\12\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\2\4\uffff\1\4\10\uffff\1\3\1\uffff\1\5\4\uffff\1\1\1\uffff"+
            "\1\6",
            "",
            "\1\7",
            "",
            "",
            "",
            "",
            "\1\10\23\uffff\1\11",
            "",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "21:1: COLOR : ( 'WHITE' | 'BLACK' | 'PINK' | 'GREEN' | 'BLUE' | 'RED' | 'YELLOW' );";
        }
    }
    static final String DFA15_eotS =
        "\5\uffff";
    static final String DFA15_eofS =
        "\5\uffff";
    static final String DFA15_minS =
        "\2\56\3\uffff";
    static final String DFA15_maxS =
        "\1\71\1\145\3\uffff";
    static final String DFA15_acceptS =
        "\2\uffff\1\2\1\1\1\3";
    static final String DFA15_specialS =
        "\5\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4",
            "",
            "",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "44:1: FLOAT : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT );";
        }
    }
    static final String DFA21_eotS =
        "\1\uffff\1\35\1\42\1\uffff\1\45\1\uffff\1\46\24\35\1\116\3\uffff"+
        "\2\35\10\uffff\45\35\1\uffff\7\35\1\u0082\30\35\1\u009c\21\35\1"+
        "\u00af\1\uffff\3\35\1\u009c\7\35\1\u009c\2\35\1\u0082\4\35\1\u0082"+
        "\5\35\1\uffff\4\35\1\u00ca\7\35\1\u009c\5\35\1\uffff\7\35\1\u00e1"+
        "\1\35\1\u009c\2\35\1\u00ca\11\35\1\u00e1\1\35\1\u00ca\1\35\1\uffff"+
        "\4\35\1\u00e1\1\u009c\3\35\1\u00f8\1\u00f9\1\u009c\12\35\1\uffff"+
        "\1\35\2\u0082\2\35\1\u0082\7\35\1\u0082\4\35\1\u00ca\3\35\2\uffff"+
        "\2\35\2\u0082\10\35\1\u0124\4\35\2\u0124\7\35\1\u0124\10\35\1\u013a"+
        "\6\35\1\uffff\3\u0082\5\35\1\u0082\1\35\1\u0124\3\35\1\u014a\2\35"+
        "\1\u014d\1\u0124\2\u0082\1\uffff\1\u014e\1\u014f\5\35\3\u0082\2"+
        "\u0124\1\35\1\u0156\1\u0157\1\uffff\2\35\3\uffff\6\35\2\uffff\1"+
        "\35\1\u0163\1\u0164\7\35\1\u016d\2\uffff\5\35\2\u0082\1\u0124\1"+
        "\uffff\3\u0082\3\35\3\u0082";
    static final String DFA21_eofS =
        "\u0177\uffff";
    static final String DFA21_minS =
        "\2\40\1\123\1\uffff\1\54\1\uffff\1\56\24\40\1\56\3\uffff\2\40\10"+
        "\uffff\45\40\1\uffff\63\40\1\uffff\31\40\1\uffff\22\40\1\uffff\12"+
        "\40\2\104\16\40\1\uffff\16\40\2\104\6\40\1\uffff\1\40\2\60\5\40"+
        "\2\104\14\40\2\uffff\2\40\2\60\11\40\2\104\2\40\2\60\16\40\2\104"+
        "\7\40\1\uffff\2\60\2\40\2\104\6\40\2\104\5\40\2\60\1\uffff\7\40"+
        "\2\60\4\40\2\60\1\uffff\2\40\3\uffff\6\40\2\uffff\7\40\2\104\2\40"+
        "\2\uffff\2\104\3\40\2\60\1\40\1\uffff\2\60\1\40\2\104\1\40\2\60"+
        "\1\40";
    static final String DFA21_maxS =
        "\1\175\1\172\1\123\1\uffff\1\135\1\uffff\1\131\24\172\1\145\3\uffff"+
        "\2\172\10\uffff\45\172\1\uffff\63\172\1\uffff\31\172\1\uffff\22"+
        "\172\1\uffff\12\172\2\104\16\172\1\uffff\16\172\2\104\6\172\1\uffff"+
        "\10\172\2\104\14\172\2\uffff\15\172\2\104\22\172\2\104\7\172\1\uffff"+
        "\4\172\2\104\6\172\2\104\7\172\1\uffff\17\172\1\uffff\2\172\3\uffff"+
        "\6\172\2\uffff\7\172\2\104\2\172\2\uffff\2\104\6\172\1\uffff\3\172"+
        "\2\104\4\172";
    static final String DFA21_acceptS =
        "\3\uffff\1\4\1\uffff\1\7\26\uffff\1\37\1\35\1\40\2\uffff\1\3\1"+
        "\10\1\5\1\6\1\25\1\11\1\27\1\34\45\uffff\1\36\63\uffff\1\26\31\uffff"+
        "\1\32\22\uffff\1\16\32\uffff\1\31\26\uffff\1\33\26\uffff\1\14\1"+
        "\15\52\uffff\1\30\25\uffff\1\22\17\uffff\1\12\2\uffff\1\21\1\23"+
        "\1\24\6\uffff\1\1\1\2\13\uffff\1\17\1\20\10\uffff\1\13\11\uffff";
    static final String DFA21_specialS =
        "\u0177\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\36\13\uffff\1\3\1\uffff\1\34\1\uffff\12\33\3\uffff\1\5\3"+
            "\uffff\1\12\1\15\1\20\1\17\1\21\1\14\1\1\1\32\1\7\1\25\1\32"+
            "\1\16\1\30\1\32\1\27\1\13\1\32\1\22\1\23\1\24\1\32\1\26\1\31"+
            "\1\10\1\11\1\32\1\2\3\uffff\1\35\1\uffff\32\32\1\6\1\uffff\1"+
            "\4",
            "\1\36\40\uffff\21\40\1\37\10\40\6\uffff\32\40",
            "\1\41",
            "",
            "\1\43\60\uffff\1\44",
            "",
            "\1\47\1\uffff\12\47\10\uffff\1\50\4\uffff\1\50\10\uffff\1"+
            "\50\1\uffff\1\50\4\uffff\1\50\1\uffff\1\50",
            "\1\36\40\uffff\32\40\6\uffff\14\40\1\51\15\40",
            "\1\36\40\uffff\21\40\1\52\10\40\6\uffff\32\40",
            "\1\36\40\uffff\4\40\1\54\14\40\1\53\10\40\6\uffff\32\40",
            "\1\36\40\uffff\21\40\1\56\10\40\6\uffff\27\40\1\55\2\40",
            "\1\36\40\uffff\10\40\1\61\5\40\1\60\13\40\6\uffff\13\40\1"+
            "\57\16\40",
            "\1\36\40\uffff\32\40\6\uffff\10\40\1\62\10\40\1\63\10\40",
            "\1\36\40\uffff\4\40\1\65\6\40\1\67\6\40\1\66\7\40\6\uffff"+
            "\1\64\31\40",
            "\1\36\40\uffff\1\71\7\40\1\70\21\40\6\uffff\32\40",
            "\1\36\40\uffff\1\73\7\40\1\72\21\40\6\uffff\32\40",
            "\1\36\40\uffff\10\40\1\74\5\40\1\77\5\40\1\75\3\40\1\76\1"+
            "\40\6\uffff\32\40",
            "\1\36\40\uffff\3\40\1\101\7\40\1\100\16\40\6\uffff\32\40",
            "\1\36\40\uffff\4\40\1\102\11\40\1\103\13\40\6\uffff\32\40",
            "\1\36\40\uffff\14\40\1\105\2\40\1\104\12\40\6\uffff\32\40",
            "\1\36\40\uffff\7\40\1\106\1\107\21\40\6\uffff\32\40",
            "\1\36\40\uffff\16\40\1\110\13\40\6\uffff\32\40",
            "\1\36\40\uffff\4\40\1\111\25\40\6\uffff\32\40",
            "\1\36\40\uffff\17\40\1\112\12\40\6\uffff\32\40",
            "\1\36\40\uffff\4\40\1\113\3\40\1\114\21\40\6\uffff\32\40",
            "\1\36\40\uffff\7\40\1\115\22\40\6\uffff\32\40",
            "\1\36\40\uffff\32\40\6\uffff\32\40",
            "\1\34\1\uffff\12\33\13\uffff\1\34\37\uffff\1\34",
            "",
            "",
            "",
            "\1\36\40\uffff\1\117\3\40\1\120\25\40\6\uffff\32\40",
            "\1\36\40\uffff\32\40\6\uffff\32\40",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\36\40\uffff\32\40\6\uffff\1\121\31\40",
            "\1\36\40\uffff\32\40\6\uffff\1\122\31\40",
            "\1\36\40\uffff\32\40\6\uffff\1\123\31\40",
            "\1\36\40\uffff\13\40\1\124\16\40\6\uffff\32\40",
            "\1\36\40\uffff\32\40\6\uffff\4\40\1\125\25\40",
            "\1\36\40\uffff\2\40\1\126\27\40\6\uffff\32\40",
            "\1\36\40\uffff\32\40\6\uffff\16\40\1\127\13\40",
            "\1\36\40\uffff\10\40\1\130\2\40\1\131\16\40\6\uffff\32\40",
            "\1\36\40\uffff\15\40\1\132\14\40\6\uffff\32\40",
            "\1\36\40\uffff\32\40\6\uffff\13\40\1\133\16\40",
            "\1\36\40\uffff\32\40\6\uffff\1\134\31\40",
            "\1\36\40\uffff\32\40\6\uffff\2\40\1\135\27\40",
            "\1\36\40\uffff\25\40\1\137\3\40\1\136\6\uffff\32\40",
            "\1\36\40\uffff\17\40\1\140\12\40\6\uffff\32\40",
            "\1\36\40\uffff\1\141\23\40\1\142\5\40\6\uffff\32\40",
            "\1\36\40\uffff\15\40\1\143\14\40\6\uffff\32\40",
            "\1\36\40\uffff\21\40\1\144\10\40\6\uffff\32\40",
            "\1\36\40\uffff\22\40\1\145\7\40\6\uffff\32\40",
            "\1\36\40\uffff\22\40\1\146\7\40\6\uffff\32\40",
            "\1\36\40\uffff\21\40\1\147\10\40\6\uffff\32\40",
            "\1\36\40\uffff\1\40\1\150\30\40\6\uffff\32\40",
            "\1\36\40\uffff\13\40\1\151\16\40\6\uffff\32\40",
            "\1\36\40\uffff\13\40\1\153\1\40\1\152\14\40\6\uffff\32\40",
            "\1\36\40\uffff\13\40\1\154\16\40\6\uffff\32\40",
            "\1\36\40\uffff\6\40\1\155\23\40\6\uffff\32\40",
            "\1\36\40\uffff\2\40\1\156\1\157\26\40\6\uffff\32\40",
            "\1\36\40\uffff\24\40\1\160\5\40\6\uffff\32\40",
            "\1\36\40\uffff\7\40\1\161\22\40\6\uffff\32\40",
            "\1\36\40\uffff\1\162\31\40\6\uffff\32\40",
            "\1\36\40\uffff\10\40\1\163\21\40\6\uffff\32\40",
            "\1\36\40\uffff\15\40\1\164\14\40\6\uffff\32\40",
            "\1\36\40\uffff\10\40\1\165\21\40\6\uffff\32\40",
            "\1\36\40\uffff\21\40\1\166\10\40\6\uffff\32\40",
            "\1\36\40\uffff\1\167\31\40\6\uffff\32\40",
            "\1\36\40\uffff\3\40\1\170\26\40\6\uffff\32\40",
            "\1\36\40\uffff\23\40\1\171\6\40\6\uffff\32\40",
            "\1\36\40\uffff\10\40\1\172\21\40\6\uffff\32\40",
            "",
            "\1\36\40\uffff\17\40\1\173\12\40\6\uffff\32\40",
            "\1\36\40\uffff\4\40\1\174\25\40\6\uffff\32\40",
            "\1\36\40\uffff\32\40\6\uffff\6\40\1\175\23\40",
            "\1\36\40\uffff\32\40\6\uffff\23\40\1\176\6\40",
            "\1\36\40\uffff\32\40\6\uffff\23\40\1\177\6\40",
            "\1\36\40\uffff\13\40\1\u0080\16\40\6\uffff\32\40",
            "\1\36\40\uffff\32\40\6\uffff\22\40\1\u0081\7\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\32\40\6\uffff\23\40\1\u0083\6\40",
            "\1\36\40\uffff\15\40\1\u0084\14\40\6\uffff\32\40",
            "\1\36\40\uffff\30\40\1\u0085\1\40\6\uffff\32\40",
            "\1\36\40\uffff\12\40\1\u0086\17\40\6\uffff\32\40",
            "\1\36\40\uffff\32\40\6\uffff\13\40\1\u0087\16\40",
            "\1\36\40\uffff\32\40\6\uffff\14\40\1\u0088\15\40",
            "\1\36\40\uffff\32\40\6\uffff\12\40\1\u0089\17\40",
            "\1\36\40\uffff\10\40\1\u008a\21\40\6\uffff\32\40",
            "\1\36\40\uffff\4\40\1\u008b\25\40\6\uffff\32\40",
            "\1\36\40\uffff\13\40\1\u008c\16\40\6\uffff\32\40",
            "\1\36\40\uffff\2\40\1\u008d\27\40\6\uffff\32\40",
            "\1\36\40\uffff\4\40\1\u008e\25\40\6\uffff\32\40",
            "\1\36\40\uffff\4\40\1\u008f\25\40\6\uffff\32\40",
            "\1\36\40\uffff\6\40\1\u0090\23\40\6\uffff\32\40",
            "\1\36\40\uffff\7\40\1\u0091\22\40\6\uffff\32\40",
            "\1\36\40\uffff\7\40\1\u0092\22\40\6\uffff\32\40",
            "\1\36\40\uffff\2\40\1\u0093\27\40\6\uffff\32\40",
            "\1\36\40\uffff\16\40\1\u0094\13\40\6\uffff\32\40",
            "\1\36\40\uffff\10\40\1\u0095\21\40\6\uffff\32\40",
            "\1\36\40\uffff\4\40\1\u0096\20\40\1\u0097\4\40\6\uffff\32"+
            "\40",
            "\1\36\40\uffff\16\40\1\u0098\13\40\6\uffff\32\40",
            "\1\36\40\uffff\10\40\1\u0099\21\40\6\uffff\32\40",
            "\1\36\40\uffff\4\40\1\u009a\25\40\6\uffff\32\40",
            "\1\36\40\uffff\23\40\1\u009b\6\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\15\40\1\u009d\14\40\6\uffff\32\40",
            "\1\36\40\uffff\4\40\1\u009e\25\40\6\uffff\32\40",
            "\1\36\40\uffff\13\40\1\u009f\16\40\6\uffff\32\40",
            "\1\36\40\uffff\2\40\1\u00a0\27\40\6\uffff\32\40",
            "\1\36\40\uffff\30\40\1\u00a1\1\40\6\uffff\32\40",
            "\1\36\40\uffff\15\40\1\u00a2\14\40\6\uffff\32\40",
            "\1\36\40\uffff\23\40\1\u00a3\6\40\6\uffff\32\40",
            "\1\36\40\uffff\2\40\1\u00a4\27\40\6\uffff\32\40",
            "\1\36\40\uffff\10\40\1\u00a5\21\40\6\uffff\32\40",
            "\1\36\40\uffff\4\40\1\u00a6\25\40\6\uffff\32\40",
            "\1\36\40\uffff\23\40\1\u00a7\6\40\6\uffff\32\40",
            "\1\36\40\uffff\7\40\1\u00a8\22\40\6\uffff\32\40",
            "\1\36\40\uffff\15\40\1\u00a9\14\40\6\uffff\32\40",
            "\1\36\40\uffff\32\40\6\uffff\4\40\1\u00aa\25\40",
            "\1\36\40\uffff\32\40\6\uffff\10\40\1\u00ab\21\40",
            "\1\36\40\uffff\32\40\6\uffff\10\40\1\u00ac\21\40",
            "\1\36\40\uffff\16\40\1\u00ad\13\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\16\40\1\u00ae\13\40\4\uffff\1"+
            "\35\1\uffff\32\40",
            "",
            "\1\36\40\uffff\21\40\1\u00b0\10\40\6\uffff\32\40",
            "\1\36\40\uffff\23\40\1\u00b1\6\40\6\uffff\32\40",
            "\1\36\40\uffff\6\40\1\u00b2\23\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\23\40\1\u00b3\6\40\6\uffff\32\40",
            "\1\36\40\uffff\32\40\6\uffff\4\40\1\u00b4\25\40",
            "\1\36\40\uffff\2\40\1\u00b5\27\40\6\uffff\32\40",
            "\1\36\40\uffff\4\40\1\u00b6\25\40\6\uffff\32\40",
            "\1\36\40\uffff\13\40\1\u00b7\16\40\6\uffff\32\40",
            "\1\36\40\uffff\10\40\1\u00b8\21\40\6\uffff\32\40",
            "\1\36\40\uffff\12\40\1\u00b9\17\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\21\uffff\1\u00ba\1\u00bb\15\uffff\32\40\6\uffff\32\40",
            "\1\36\40\uffff\4\40\1\u00bc\25\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\10\40\1\u00bd\21\40\6\uffff\32\40",
            "\1\36\40\uffff\13\40\1\u00be\16\40\6\uffff\32\40",
            "\1\36\40\uffff\10\40\1\u00bf\21\40\6\uffff\32\40",
            "\1\36\40\uffff\15\40\1\u00c0\14\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\4\40\1\u00c1\25\40\6\uffff\32\40",
            "\1\36\40\uffff\21\40\1\u00c2\10\40\6\uffff\32\40",
            "\1\36\40\uffff\17\40\1\u00c3\12\40\6\uffff\32\40",
            "\1\36\40\uffff\2\40\1\u00c4\27\40\6\uffff\32\40",
            "\1\36\40\uffff\1\u00c5\31\40\6\uffff\32\40",
            "",
            "\1\36\40\uffff\3\40\1\u00c6\26\40\6\uffff\32\40",
            "\1\36\40\uffff\21\40\1\u00c7\10\40\6\uffff\32\40",
            "\1\36\40\uffff\13\40\1\u00c8\16\40\6\uffff\32\40",
            "\1\36\40\uffff\12\40\1\u00c9\17\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\5\40\1\u00cb\24\40\6\uffff\32\40",
            "\1\36\40\uffff\4\40\1\u00cc\25\40\6\uffff\32\40",
            "\1\36\40\uffff\10\40\1\u00cd\21\40\6\uffff\32\40",
            "\1\36\40\uffff\24\40\1\u00ce\5\40\6\uffff\32\40",
            "\1\36\40\uffff\21\40\1\u00cf\10\40\6\uffff\32\40",
            "\1\36\40\uffff\4\40\1\u00d0\25\40\6\uffff\32\40",
            "\1\36\40\uffff\10\40\1\u00d1\21\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\14\40\1\u00d3\5\40\1\u00d2\7\40\6\uffff\32"+
            "\40",
            "\1\36\40\uffff\32\40\6\uffff\16\40\1\u00d4\13\40",
            "\1\36\40\uffff\32\40\6\uffff\16\40\1\u00d5\13\40",
            "\1\36\40\uffff\26\40\1\u00d6\3\40\6\uffff\32\40",
            "\1\36\40\uffff\32\40\6\uffff\21\40\1\u00d7\10\40",
            "",
            "\1\36\40\uffff\32\40\6\uffff\1\u00d8\31\40",
            "\1\36\21\uffff\1\u00d9\1\u00da\15\uffff\22\40\1\u00db\7\40"+
            "\6\uffff\32\40",
            "\1\36\40\uffff\16\40\1\u00dc\13\40\6\uffff\32\40",
            "\1\36\40\uffff\32\40\6\uffff\30\40\1\u00dd\1\40",
            "\1\36\40\uffff\23\40\1\u00de\6\40\6\uffff\32\40",
            "\1\36\40\uffff\32\40\6\uffff\16\40\1\u00df\13\40",
            "\1\36\40\uffff\21\40\1\u00e0\10\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\15\40\1\u00e2\14\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\u00e3",
            "\1\u00e4",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\15\40\1\u00e5\14\40\6\uffff\32\40",
            "\1\36\40\uffff\4\40\1\u00e6\25\40\6\uffff\32\40",
            "\1\36\40\uffff\3\40\1\u00e7\26\40\6\uffff\32\40",
            "\1\36\40\uffff\3\40\1\u00e8\26\40\6\uffff\32\40",
            "\1\36\40\uffff\27\40\1\u00e9\2\40\6\uffff\32\40",
            "\1\36\21\uffff\1\u00ea\1\u00eb\15\uffff\32\40\6\uffff\32\40",
            "\1\36\40\uffff\22\40\1\u00ec\7\40\6\uffff\32\40",
            "\1\36\40\uffff\16\40\1\u00ed\13\40\6\uffff\32\40",
            "\1\36\40\uffff\15\40\1\u00ee\14\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\4\40\1\u00ef\25\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\15\40\1\u00f0\14\40\6\uffff\32\40",
            "",
            "\1\36\40\uffff\16\40\1\u00f1\13\40\6\uffff\32\40",
            "\1\36\40\uffff\27\40\1\u00f2\2\40\6\uffff\32\40",
            "\1\36\40\uffff\23\40\1\u00f3\6\40\6\uffff\32\40",
            "\1\36\40\uffff\14\40\1\u00f4\15\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\2\40\1\u00f5\27\40\6\uffff\32\40",
            "\1\36\40\uffff\32\40\6\uffff\10\40\1\u00f6\21\40",
            "\1\36\40\uffff\32\40\6\uffff\1\u00f7\31\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\32\40\6\uffff\10\40\1\u00fa\21\40",
            "\1\36\40\uffff\32\40\6\uffff\15\40\1\u00fb\14\40",
            "\1\u00fc",
            "\1\u00fd",
            "\1\36\40\uffff\10\40\1\u00fe\21\40\6\uffff\32\40",
            "\1\36\40\uffff\15\40\1\u00ff\14\40\6\uffff\32\40",
            "\1\36\40\uffff\32\40\6\uffff\17\40\1\u0100\12\40",
            "\1\36\40\uffff\32\40\6\uffff\30\40\1\u0101\1\40",
            "\1\36\40\uffff\32\40\6\uffff\13\40\1\u0102\16\40",
            "\1\36\40\uffff\2\40\1\u0103\17\40\1\u0104\7\40\6\uffff\32"+
            "\40",
            "",
            "\1\36\40\uffff\4\40\1\u0105\25\40\6\uffff\32\40",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\36\40\uffff\6\40\1\u0106\23\40\6\uffff\32\40",
            "\1\36\21\uffff\1\u0107\1\u0108\15\uffff\32\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\4\40\1\u0109\25\40\6\uffff\32\40",
            "\1\36\40\uffff\7\40\1\u010a\22\40\6\uffff\32\40",
            "\1\u010b",
            "\1\u010c",
            "\1\36\40\uffff\4\40\1\u010d\11\40\1\u010e\13\40\6\uffff\32"+
            "\40",
            "\1\36\40\uffff\13\40\1\u010f\16\40\6\uffff\32\40",
            "\1\36\40\uffff\6\40\1\u0110\23\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\4\40\1\u0111\25\40\6\uffff\32\40",
            "\1\36\40\uffff\21\40\1\u0112\10\40\6\uffff\32\40",
            "\1\36\40\uffff\2\40\1\u0113\27\40\6\uffff\32\40",
            "\1\36\40\uffff\30\40\1\u0114\1\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\22\40\1\u0115\7\40\6\uffff\32\40",
            "\1\36\40\uffff\32\40\6\uffff\31\40\1\u0116",
            "\1\36\40\uffff\32\40\6\uffff\21\40\1\u0117\10\40",
            "",
            "",
            "\1\36\40\uffff\32\40\6\uffff\6\40\1\u0118\23\40",
            "\1\36\40\uffff\32\40\6\uffff\6\40\1\u0119\23\40",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\36\40\uffff\31\40\1\u011a\6\uffff\32\40",
            "\1\36\21\uffff\1\u011b\1\u011c\15\uffff\32\40\6\uffff\32\40",
            "\1\36\40\uffff\32\40\6\uffff\4\40\1\u011d\25\40",
            "\1\36\40\uffff\32\40\6\uffff\17\40\1\u011e\12\40",
            "\1\36\40\uffff\32\40\6\uffff\16\40\1\u011f\13\40",
            "\1\36\40\uffff\24\40\1\u0120\5\40\6\uffff\32\40",
            "\1\36\40\uffff\24\40\1\u0121\5\40\6\uffff\32\40",
            "\1\36\40\uffff\2\40\1\u0122\17\40\1\u0123\7\40\6\uffff\32"+
            "\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\u0125",
            "\1\u0126",
            "\1\36\40\uffff\21\40\1\u0127\10\40\6\uffff\32\40",
            "\1\36\40\uffff\24\40\1\u0128\5\40\6\uffff\32\40",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\36\21\uffff\1\u0129\1\u012a\15\uffff\32\40\6\uffff\32\40",
            "\1\36\40\uffff\10\40\1\u012b\21\40\6\uffff\32\40",
            "\1\36\40\uffff\16\40\1\u012c\13\40\6\uffff\32\40",
            "\1\36\40\uffff\13\40\1\u012d\16\40\6\uffff\32\40",
            "\1\36\40\uffff\22\40\1\u012e\7\40\6\uffff\32\40",
            "\1\36\40\uffff\14\40\1\u012f\15\40\6\uffff\32\40",
            "\1\36\40\uffff\16\40\1\u0130\13\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\21\uffff\1\u0131\1\u0132\15\uffff\32\40\6\uffff\32\40",
            "\1\36\40\uffff\32\40\6\uffff\4\40\1\u0133\25\40",
            "\1\36\40\uffff\32\40\6\uffff\6\40\1\u0134\23\40",
            "\1\36\40\uffff\32\40\6\uffff\10\40\1\u0135\21\40",
            "\1\36\40\uffff\32\40\6\uffff\4\40\1\u0136\25\40",
            "\1\36\40\uffff\4\40\1\u0137\25\40\6\uffff\32\40",
            "\1\u0138",
            "\1\u0139",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\32\40\6\uffff\4\40\1\u013b\25\40",
            "\1\36\40\uffff\32\40\6\uffff\21\40\1\u013c\10\40",
            "\1\36\40\uffff\21\40\1\u013d\10\40\6\uffff\32\40",
            "\1\36\40\uffff\21\40\1\u013e\10\40\6\uffff\32\40",
            "\1\36\40\uffff\24\40\1\u013f\5\40\6\uffff\32\40",
            "\1\36\40\uffff\24\40\1\u0140\5\40\6\uffff\32\40",
            "",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\13\40\1\u0141\16\40\6\uffff\32\40",
            "\1\u0142",
            "\1\u0143",
            "\1\36\40\uffff\3\40\1\u0144\26\40\6\uffff\32\40",
            "\1\36\40\uffff\21\40\1\u0145\10\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\22\40\1\u0146\7\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\13\40\1\u0147\16\40\6\uffff\32\40",
            "\1\u0148",
            "\1\u0149",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\32\40\6\uffff\10\40\1\u014b\21\40",
            "\1\36\40\uffff\32\40\6\uffff\15\40\1\u014c\14\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\25\40\1\u0150\4\40\6\uffff\32\40",
            "\1\36\40\uffff\5\40\1\u0151\24\40\6\uffff\32\40",
            "\1\36\40\uffff\21\40\1\u0152\10\40\6\uffff\32\40",
            "\1\36\40\uffff\21\40\1\u0153\10\40\6\uffff\32\40",
            "\1\36\40\uffff\13\40\1\u0154\16\40\6\uffff\32\40",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\40\uffff\16\40\1\u0155\13\40\6\uffff\32\40",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "\1\36\40\uffff\32\40\6\uffff\15\40\1\u0158\14\40",
            "\1\36\40\uffff\27\40\1\u0159\1\u015a\1\40\6\uffff\32\40",
            "",
            "",
            "",
            "\1\36\40\uffff\4\40\1\u015b\25\40\6\uffff\32\40",
            "\1\36\40\uffff\1\u015c\31\40\6\uffff\32\40",
            "\1\36\40\uffff\25\40\1\u015d\4\40\6\uffff\32\40",
            "\1\36\40\uffff\5\40\1\u015e\24\40\6\uffff\32\40",
            "\1\36\21\uffff\1\u015f\1\u0160\15\uffff\32\40\6\uffff\32\40",
            "\1\36\40\uffff\21\40\1\u0161\10\40\6\uffff\32\40",
            "",
            "",
            "\1\36\40\uffff\32\40\6\uffff\22\40\1\u0162\7\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\36\21\uffff\1\u0165\1\u0166\15\uffff\32\40\6\uffff\32\40",
            "\1\36\40\uffff\2\40\1\u0167\27\40\6\uffff\32\40",
            "\1\36\40\uffff\4\40\1\u0168\25\40\6\uffff\32\40",
            "\1\36\40\uffff\1\u0169\31\40\6\uffff\32\40",
            "\1\u016a",
            "\1\u016b",
            "\1\36\40\uffff\22\40\1\u016c\7\40\6\uffff\32\40",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "",
            "",
            "\1\u016e",
            "\1\u016f",
            "\1\36\40\uffff\4\40\1\u0170\25\40\6\uffff\32\40",
            "\1\36\21\uffff\1\u0171\1\u0172\15\uffff\32\40\6\uffff\32\40",
            "\1\36\40\uffff\2\40\1\u0173\27\40\6\uffff\32\40",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40",
            "\1\u0174",
            "\1\u0175",
            "\1\36\40\uffff\4\40\1\u0176\25\40\6\uffff\32\40",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\36\17\uffff\12\35\7\uffff\32\40\4\uffff\1\35\1\uffff\32"+
            "\40"
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | SHAPE_IDT | POINTS | VAR | SIZE | COLOR | JOINFORM | VERTEXCOLORS | ID | INT | FLOAT | STRING );";
        }
    }
 

}