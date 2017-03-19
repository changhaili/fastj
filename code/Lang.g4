grammar Lang;

source :  (segment | function | klass |  namespace)+;
sourceUnused : source EOF ;

namespace : 'package' klassName '{' (segment | operatorFunction | function | klass | namespace )+  '}';

klass: 'class' ID (':' klassName (',' klassName )*? )? 
'{' ( segment | function | operatorFunction )*? '}' ;

 
operatorFunction : 'def' name=operators '()'   ( '{' (segment)*? '}' | '{}')
| 'def' name=operators '(' (ID (',' ID)*? (',' ID '=' v=atomicObject  )*? )? ')'  ( '{' (segment)*? '}' | '{}')
| 'def' name=operators '(' (ID '=' v=atomicObject (',' ID '=' v=atomicObject  )*? )? ')'  ( '{' (segment)*? '}' | '{}')
; 

function :  'def' name=ID '()' ( '{' (segment)*? '}' | '{}')
| 'def' name=ID '(' (ID (',' ID)*? (',' ID '=' v=atomicObject  )*? )? ')' ( '{' (segment)*? '}' | '{}')
| 'def' name=ID '(' (ID '=' v=atomicObject (',' ID '=' v=atomicObject  )*? )? ')' ( '{' (segment)*? '}' | '{}')
;

segment : '{' (segment)* '}' #blockSegment
| statement #statementSegment
| 'if' '(' term ')' segment ('else' segment )? #ifElseSegment
| (label=ID ':')? 'do' segment 'while' '(' term ')' ';'  # dowhileSegmemt
| (label=ID ':')? 'while' '(' term ')' segment # whileSegment
| (label=ID ':')? 'for' '(' ('var')? name=ID ':' term ')' segment #foreachSegment
| (label=ID ':')? 'for' '(' ( ('var')? expr0=term )? ';' ( expr1=term )? ';' ( expr2=term )? ')' segment #forSegment
| 'switch' in=term '{' ('case' con=term ':' cas=segment )*? ('default' ':' def=segment)? '}' #switchSegment
| 'try' '{' (segment)*? '}' ('catch' '(' ID ')' '{' (segment)*? '}' ) ? ('finally' '{' (segment)*? '}')? #trySegment
| 'synchronized' '(' term ')' segment  #lockSegment

;

statement :
 ';' #emptyStatement
| 'var' variantName ('=' term)? ';' #assignStatment

| 'return' (term) ? ';' #returnStatement
| 'return' '(' term ')' ';' #returnStatement
| 'yield' term ';' #yieldStatement
| 'yield' '(' term ')' ';' #yieldStatement
| 'continue' ';' #continueStatement
| 'break' (label=ID)? ';' #breakStatement
| 'throw' term ';'  #throwStatement
| term ';' #termStatement
;

term : 

 term op=OP_DOT ID # dotTerm
| '.' ID #globalIDTerm
| term op=OP_DOT 'class' # dotClassTerm
| 'defined' '(' fullPath ')' # definedTerm
| 'default' '(' term ')' # defaultTerm

| ('null' | 'true' | 'false' | 'this' | 'super' | 'class') # constTerm
| ('assert' | 'import' | 'include' ) # keywordTerm
| ('void' | 'boolean' | 'byte' | 'char' | 'short' | 'int' | 'long' | 'float' | 'double' | 'string' | 'object') #primitiveTerm

| 'new' klassName '(' (term ( ',' term)* )? ')'  #newTerm
| 'new' klassName '()'  #newTerm

| '(' (ID (',' ID)*? )? ')' '=>' (segment| term) #lambdaTerm
| '()' '=>' (segment| term) #lambdaTerm
| '[]' '()' '=>' (segment| term) #jlambdaTerm
| '[' term ']' '(' (ID (',' ID)*? )? ')' '=>' (segment| term)   #jlambdaTerm
| '[' term ']' '()' '=>' (segment| term)   #jlambdaTerm

| term '(' (term ( ',' term)*? )? ')' #invokeTerm
| term '()' #invokeTerm
| term '[' (term ( ',' term)* )?  ']' #indicesTerm
| '(' (term ( ',' term)* )?  ')' #parenthesisTerm

| '{' (( term ':' term ) (',' term ':' term )*)? '}' #mapTerm
| '{}' # mapTerm

| '[' (term ( ',' term)* )? ']' #listTerm
| '[]' #listTerm

| op=OP_MINUS term # unaryTerm
| op=OP_PLUS term # unaryTerm

| op=OP_BOOLEAN_NOT term # unaryTerm
| op=OP_BIT_NOT term # unaryTerm

| op=(OP_PLUSPLUS |OP_MINUSMINUS) term # preSelfUnaryTerm
| term op=(OP_PLUSPLUS | OP_MINUSMINUS) # postSelfUnaryTerm

| term op=(OP_POWER | OP_MULTIPLY | OP_DIVIDE | OP_MODE) term  #binaryTerm
| term op=(OP_PLUS | OP_MINUS) term #binaryTerm
| term op=(OP_BIT_LEFT_SHIFT| OP_BIT_RIGHT_SHIFT | OP_BIT_RIGHT_ROTATE)  term #binaryTerm

| term op=(OP_GREATER_THAN | OP_GREATER_EQAULS | OP_LESS_THAN | OP_LESS_EQUALS) term #binaryTerm
| term op=(OP_REF_EQUALS | OP_REF_NOT_EQUALS ) term #binaryTerm
| term op=(OP_EQUALS | OP_NOT_EQUALS ) term #binaryTerm
| term op=OP_REGEX_MATCH term #binaryTerm

| term op=OP_BIT_AND  term #binaryTerm
| term op=OP_BIT_XOR  term #binaryTerm
| term op=OP_BIT_OR  term #binaryTerm

| term op=OP_BOOLEAN_AND  term #binaryTerm
| term op=OP_BOOLEAN_OR term #binaryTerm

| term op=OP_NULLOR term #binaryTerm

| term op=(OP_BIT_LEFT_SHIFT_ASSIGN | OP_BIT_RIGHT_SHIFT_ASSIGN )  term #assignTerm

| term OP_QUESTION term OP_COLON term #conditionTerm
| term 'instanceof' term # isTerm
| term 'as' term # castTerm
| term 'in' term # inTerm

| term op=(OP_POWER_ASSIGN | OP_MULTI_ASSIGN | OP_DIV_ASSIGN | OP_MODE_ASSIGN) term #assignTerm
| term op=(OP_PLUS_ASSIGN | OP_MINUS_ASSIGN) term #assignTerm

| term op=OP_BIT_AND_ASSIGN  term #assignTerm
| term op=OP_BIT_XOR_ASSIGN  term #assignTerm
| term op=OP_BIT_OR_ASSIGN  term #assignTerm
| term op=OP_ASSIGN term #assignTerm

| atomicObject #basicTerm
;

variantName : ID;
atomicObject : (sign=('+'|'-'))? v=DATA_NUMBER | DATA_LONG | DATA_STRING | DATA_CHAR | ID ;

fullPath :  ID ('.' ID)*;
klassName : ID ('.' ID)*;

keyWords :
 'auto'  | 'static' | 'external' | 'volatile' | 'register' | 'asm' | 'transient'

| 'var' | 'val'
| 'void' | 'boolean' | 'byte' | 'char' | 'short' | 'int' | 'long' | 'float' | 'double' | 'string' | 'object' | 'unsigned'
| 'decimal' | 'strictfp'

| 'instanceof' 

| 'class' | 'interface'  | 'enum' | 'struct'| 'lambda' | 'delegate' 
| 'extends' | 'implements'
| 'def' | 'return' | 'override' | 'native' | 'yield'
| 'synchronized' 

| 'public' | 'protected' | 'private' | 'internal' | 'friend'
| 'virtual' | 'abstract'
| 'final' | 'const' | 'ref' | 'out' | 'in' 

| 'using' | 'package' | 'namespace'
| 'import' | 'include'

| 'this' | 'null' | 'true' | 'false' | 'super'
| 'new' | 'delete'
| 'defined' | 'define'
| 'try' | 'catch' | 'throw' | 'finally' | 'throws' | 'assert'

| 'if' | 'else' | 'for' | 'while' | 'do' | 'switch' | 'case' | 'default' | 'break' | 'continue' 
| 'goto' | 'elif' | 'foreach'

| 'as' | 'alias' | 'global'

;


ID : [_|a-z|A-Z][_|a-z|A-Z|0-9]*;

OP_PLUSPLUS :'++';
OP_MINUSMINUS : '--';

OP_PLUS : '+';
OP_MINUS : '-';

OP_POWER : '**';
OP_MULTIPLY : '*';
OP_DIVIDE : '/';
OP_MODE : '%';

OP_BIT_NOT : '~';
OP_BIT_AND : '&';
OP_BIT_OR : '|';
OP_BIT_XOR : '^';

OP_BIT_LEFT_SHIFT : '<<';
OP_BIT_RIGHT_SHIFT : '>>';
OP_BIT_RIGHT_ROTATE : '>>>';

OP_BOOLEAN_NOT : '!';
OP_BOOLEAN_AND : '&&';
OP_BOOLEAN_OR : '||';

OP_REF_EQUALS :'==';
OP_REF_NOT_EQUALS :'!=';

OP_REGEX_MATCH : '~=';

OP_EQUALS : '===';
OP_NOT_EQUALS : '!==';

OP_GREATER_THAN : '>';
OP_GREATER_EQAULS : '>=';
OP_LESS_THAN : '<';
OP_LESS_EQUALS : '<=';

OP_NULLOR : '??';

OP_DOT :'.';
OP_COMMA : ',';
OP_QUESTION : '?';
OP_COLON : ':';

OP_PARENTHESIS_LEFT : '(';
OP_PARENTHESIS_RIGHT : ')';

OP_BRACKET_LEFT : '[';
OP_BRACKET_RIGHT : ']';

OP_BRACE_LEFT : '{';
OP_BRACE_RIGHT : '}';

OP_SEMICOLON : ';';
OP_ASSIGN : '=';

OP_PLUS_ASSIGN : '+=';
OP_MINUS_ASSIGN : '-=';
OP_MULTI_ASSIGN : '*=';
OP_DIV_ASSIGN : '/=';
OP_MODE_ASSIGN : '%=';
OP_POWER_ASSIGN : '**=';

OP_BIT_AND_ASSIGN : '&=';
OP_BIT_OR_ASSIGN : '|=';
OP_BIT_XOR_ASSIGN : '^=';

OP_BIT_LEFT_SHIFT_ASSIGN : '<<=';
OP_BIT_RIGHT_SHIFT_ASSIGN : '>>=';
OP_BIT_RIGHT_ROTATE_ASSIGN : '>>>=';

DATA_NUMBER : [0-9]+('.'([0-9]+))?(('e')(('-'|'+')?)([0-9]+))?('f')? ; 
DATA_LONG : [0-9]+[L|l];

DATA_STRING : (('"'   (ESC_SEQ | ~('"' ))*? '"' ) | ('@\'' (ESC_SEQ | ~('\'' ))*? '\''))  ;
DATA_CHAR :   (('\''  (ESC_SEQ | ~('\'' ))   '\'') | ('@"'  (ESC_SEQ | ~('"'))   '"' ));

fragment EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;
 
fragment HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;
 
fragment ESC_SEQ :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |UNICODE_ESC
    |OCTAL_ESC ;
 
fragment OCTAL_ESC : '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7');
 
fragment UNICODE_ESC  : '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT ;
    
LINE_COMMENT  : ('//') ~('\n'|'\r')* -> skip ;
COMMENT       : '/*' .*? '*/' ->skip ;

NEWLINE: '\r' ? '\n' -> skip;
WS : (' ' |'\t' |'\n' |'\r' | EOF )+ {skip();} ;

operators : '[]' |
'()' |
OP_PLUSPLUS |
OP_MINUSMINUS |

OP_PLUS |
OP_MINUS |

OP_POWER |
OP_MULTIPLY |
OP_DIVIDE |
OP_MODE |

OP_BIT_NOT |
OP_BIT_AND |
OP_BIT_OR |
OP_BIT_XOR |

OP_BIT_LEFT_SHIFT |
OP_BIT_RIGHT_SHIFT |
OP_BIT_RIGHT_ROTATE |

OP_BOOLEAN_NOT |
OP_BOOLEAN_AND |
OP_BOOLEAN_OR |

OP_REF_EQUALS |
OP_REF_NOT_EQUALS |

OP_REGEX_MATCH |

OP_EQUALS |
OP_NOT_EQUALS |

OP_GREATER_THAN |
OP_GREATER_EQAULS |
OP_LESS_THAN |
OP_LESS_EQUALS |

OP_NULLOR |

OP_DOT |
OP_COMMA |
OP_QUESTION |
OP_COLON |

OP_PARENTHESIS_LEFT |
OP_PARENTHESIS_RIGHT |

OP_BRACKET_LEFT |
OP_BRACKET_RIGHT |

OP_BRACE_LEFT |
OP_BRACE_RIGHT |

OP_SEMICOLON |
OP_ASSIGN |

OP_PLUS_ASSIGN |
OP_MINUS_ASSIGN |
OP_MULTI_ASSIGN |
OP_DIV_ASSIGN  |
OP_MODE_ASSIGN |
OP_POWER_ASSIGN |

OP_BIT_AND_ASSIGN |
OP_BIT_OR_ASSIGN |
OP_BIT_XOR_ASSIGN |

OP_BIT_LEFT_SHIFT_ASSIGN |
OP_BIT_RIGHT_SHIFT_ASSIGN |
OP_BIT_RIGHT_ROTATE_ASSIGN ;


