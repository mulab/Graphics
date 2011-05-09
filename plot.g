grammar plot;

options{ output=AST;
	 ASTLabelType=CommonTree;
	 language=Java;
}
program : statement;
statement 
	:expression;
	
expression : ('GRAPHICS2D'|'GRAPHICS3D') shapes opts'}]';
shapes  :'[SHAPE{'^ (shape(','shape)*)
        ;
shape	:SHAPE_IDT^'[''{'pointes shapeopts'}]'
	;	
pointes : points(','points)*;
points 	:'('^FLOAT','FLOAT','FLOAT')'
        ;
shapeopts:'},OPTIONS{'^ (shapeoptions(','shapeoptions)*)?	
	;
shapeoptions:VAR^'='(INT|FLOAT|COLOR|JOINFORM|SIZE|VERTEXCOLORS)
	;
opts	:'},OPTIONS{'^ (option(','option)*)?;		
option	:('ImageSize'|'ImageMargins'|'XRatio'|'YRatio'|'Axes'|'AxesOriginX'|'AxesOriginY'|'PlotRangeX'|'PlotRangeY'|
         'FillType'|'FrameType'|'BackColor')^'='
	(points|'{'points','points'}'|'{'points','points','points'}'|FLOAT|STRING|INT|COLOR);

SHAPE_IDT: 'POINT2D'|'POINT3D'|'LINE2D'|'LINE3D'|'POLYGON2D'|'POLYGON3D'|'ARC'|'BEZIERCURVE2D'|'BEZIERCURVE3D'|
	   'BSPLINECURVE2D'|'BSPLINECURVE3D'|'BEZIERSURFACE'|'BSPLINESURFACE'|'DISH'|'CIRCLE2D'|'CIRCLE3D'|
	   'ELLIPSE2D'|'ELLIPSE3D'|'RECTANGL'|'SPHERE'|'ELLIPSOID'|'CUBOID'|'CYLINDER'|'CONE'|
	   'CONVEXHULL2D'|'CONVEXHULL3D'
	;
VAR	:'POINTSIZE'|'COLOR2D'|'COLOR3D'|'THICKNESS'|'DASHING'|'JOINFORM'|'VERTEXCOLORS'|'EDGECOLOR'|'OPACITY'	
	;
SIZE    :'TINY'|'SMALL'|'MEDIUM'|'LARGE'
        ;
COLOR   : 'WHITE'|'BLACK'|'PINK'|'GREEN'|'BLUE'|'RED'|'YELLOW'
        ;
JOINFORM:'BEVEL'|'ROUND'|'MITER'
        ;        	
VERTEXCOLORS:'{'COLOR(','COLOR)*'}'	
	;

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;
    

INT :	'0'..'9'+
    ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

STRING
    :   ('A'..'Z' | 'a'..'z' | ' ') +
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
