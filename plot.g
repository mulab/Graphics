grammar plot;

options{ output=AST;}
program : statement;
statement 
	:expression;

expression : ('GRAPHICS2D'|'GRAPHICS3D')'[''SHAPE''{'shape(','shape)*'}'',''OPTIONS''{'option*'}'']';

SHAPE_IDT: 'POINT2D'|'POINT3D'|'LINE2D'|'LINE3D'|'POLYGON2D'|'POLYGON3D'|'ARC'|'BEZIERCURVE2D'|'BEZIERCURVE3D'|'BSPLINECURVE2D'
           |'BSPLINECURVE3D'|'BEZIERSURFACE'|'BSPLINESURFACE'|'DISH'|'CIRCLE2D'|'CIRCLE3D'|'ELLIPSE2D'|'ELLIPSE3D'|'RECTANGL'|'SPHERE'
           |'ELLIPSOID'|'CUBOID'|'CYLINDER'|'CONE'|'CONVEXHULL2D'|'CONVEXHULL3D'
	;
	
POINTS 	:'{'FLOAT','FLOAT','FLOAT'}'	
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
shapeoptions: VAR'='INT|COLOR|JOINFORM|SIZE|VERTEXCOLORS
	;	

shape	:SHAPE_IDT '[''{' POINTS(','POINTS)*'},OPTIONS{'shapeoptions(','shapeoptions)*'}'']'
	;


option	:('ImageSize'|'ImageMargins'|'XRatio'|'YRatio'|'Axes'|'AxesOriginX'|'AxesOriginY'|'PlotRange'|'FillType'|'FrameType'|'BackColor')'='
	(POINTS|'{'POINTS','POINTS'}'|'{'POINTS','POINTS','POINTS'}'|FLOAT|STRING|INT|COLOR);

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
    :  '\'' ( ESC_SEQ | ~('\\'|'\'') )* '\''
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
