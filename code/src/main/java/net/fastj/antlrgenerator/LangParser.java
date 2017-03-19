// Generated from Lang.g4 by ANTLR 4.5.3
package net.fastj.antlrgenerator;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, T__74=75, T__75=76, T__76=77, T__77=78, T__78=79, T__79=80, 
		T__80=81, T__81=82, T__82=83, T__83=84, T__84=85, T__85=86, T__86=87, 
		T__87=88, T__88=89, T__89=90, ID=91, OP_PLUSPLUS=92, OP_MINUSMINUS=93, 
		OP_PLUS=94, OP_MINUS=95, OP_POWER=96, OP_MULTIPLY=97, OP_DIVIDE=98, OP_MODE=99, 
		OP_BIT_NOT=100, OP_BIT_AND=101, OP_BIT_OR=102, OP_BIT_XOR=103, OP_BIT_LEFT_SHIFT=104, 
		OP_BIT_RIGHT_SHIFT=105, OP_BIT_RIGHT_ROTATE=106, OP_BOOLEAN_NOT=107, OP_BOOLEAN_AND=108, 
		OP_BOOLEAN_OR=109, OP_REF_EQUALS=110, OP_REF_NOT_EQUALS=111, OP_REGEX_MATCH=112, 
		OP_EQUALS=113, OP_NOT_EQUALS=114, OP_GREATER_THAN=115, OP_GREATER_EQAULS=116, 
		OP_LESS_THAN=117, OP_LESS_EQUALS=118, OP_NULLOR=119, OP_DOT=120, OP_COMMA=121, 
		OP_QUESTION=122, OP_COLON=123, OP_PARENTHESIS_LEFT=124, OP_PARENTHESIS_RIGHT=125, 
		OP_BRACKET_LEFT=126, OP_BRACKET_RIGHT=127, OP_BRACE_LEFT=128, OP_BRACE_RIGHT=129, 
		OP_SEMICOLON=130, OP_ASSIGN=131, OP_PLUS_ASSIGN=132, OP_MINUS_ASSIGN=133, 
		OP_MULTI_ASSIGN=134, OP_DIV_ASSIGN=135, OP_MODE_ASSIGN=136, OP_POWER_ASSIGN=137, 
		OP_BIT_AND_ASSIGN=138, OP_BIT_OR_ASSIGN=139, OP_BIT_XOR_ASSIGN=140, OP_BIT_LEFT_SHIFT_ASSIGN=141, 
		OP_BIT_RIGHT_SHIFT_ASSIGN=142, OP_BIT_RIGHT_ROTATE_ASSIGN=143, DATA_NUMBER=144, 
		DATA_LONG=145, DATA_STRING=146, DATA_CHAR=147, LINE_COMMENT=148, COMMENT=149, 
		NEWLINE=150, WS=151;
	public static final int
		RULE_source = 0, RULE_sourceUnused = 1, RULE_namespace = 2, RULE_klass = 3, 
		RULE_operatorFunction = 4, RULE_function = 5, RULE_segment = 6, RULE_statement = 7, 
		RULE_term = 8, RULE_variantName = 9, RULE_atomicObject = 10, RULE_fullPath = 11, 
		RULE_klassName = 12, RULE_keyWords = 13, RULE_operators = 14;
	public static final String[] ruleNames = {
		"source", "sourceUnused", "namespace", "klass", "operatorFunction", "function", 
		"segment", "statement", "term", "variantName", "atomicObject", "fullPath", 
		"klassName", "keyWords", "operators"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'package'", "'class'", "'def'", "'()'", "'{}'", "'if'", "'else'", 
		"'do'", "'while'", "'for'", "'var'", "'switch'", "'case'", "'default'", 
		"'try'", "'catch'", "'finally'", "'synchronized'", "'return'", "'yield'", 
		"'continue'", "'break'", "'throw'", "'defined'", "'null'", "'true'", "'false'", 
		"'this'", "'super'", "'assert'", "'import'", "'include'", "'void'", "'boolean'", 
		"'byte'", "'char'", "'short'", "'int'", "'long'", "'float'", "'double'", 
		"'string'", "'object'", "'new'", "'=>'", "'[]'", "'instanceof'", "'as'", 
		"'in'", "'auto'", "'static'", "'external'", "'volatile'", "'register'", 
		"'asm'", "'transient'", "'val'", "'unsigned'", "'decimal'", "'strictfp'", 
		"'interface'", "'enum'", "'struct'", "'lambda'", "'delegate'", "'extends'", 
		"'implements'", "'override'", "'native'", "'public'", "'protected'", "'private'", 
		"'internal'", "'friend'", "'virtual'", "'abstract'", "'final'", "'const'", 
		"'ref'", "'out'", "'using'", "'namespace'", "'delete'", "'define'", "'throws'", 
		"'goto'", "'elif'", "'foreach'", "'alias'", "'global'", null, "'++'", 
		"'--'", "'+'", "'-'", "'**'", "'*'", "'/'", "'%'", "'~'", "'&'", "'|'", 
		"'^'", "'<<'", "'>>'", "'>>>'", "'!'", "'&&'", "'||'", "'=='", "'!='", 
		"'~='", "'==='", "'!=='", "'>'", "'>='", "'<'", "'<='", "'??'", "'.'", 
		"','", "'?'", "':'", "'('", "')'", "'['", "']'", "'{'", "'}'", "';'", 
		"'='", "'+='", "'-='", "'*='", "'/='", "'%='", "'**='", "'&='", "'|='", 
		"'^='", "'<<='", "'>>='", "'>>>='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "ID", "OP_PLUSPLUS", "OP_MINUSMINUS", 
		"OP_PLUS", "OP_MINUS", "OP_POWER", "OP_MULTIPLY", "OP_DIVIDE", "OP_MODE", 
		"OP_BIT_NOT", "OP_BIT_AND", "OP_BIT_OR", "OP_BIT_XOR", "OP_BIT_LEFT_SHIFT", 
		"OP_BIT_RIGHT_SHIFT", "OP_BIT_RIGHT_ROTATE", "OP_BOOLEAN_NOT", "OP_BOOLEAN_AND", 
		"OP_BOOLEAN_OR", "OP_REF_EQUALS", "OP_REF_NOT_EQUALS", "OP_REGEX_MATCH", 
		"OP_EQUALS", "OP_NOT_EQUALS", "OP_GREATER_THAN", "OP_GREATER_EQAULS", 
		"OP_LESS_THAN", "OP_LESS_EQUALS", "OP_NULLOR", "OP_DOT", "OP_COMMA", "OP_QUESTION", 
		"OP_COLON", "OP_PARENTHESIS_LEFT", "OP_PARENTHESIS_RIGHT", "OP_BRACKET_LEFT", 
		"OP_BRACKET_RIGHT", "OP_BRACE_LEFT", "OP_BRACE_RIGHT", "OP_SEMICOLON", 
		"OP_ASSIGN", "OP_PLUS_ASSIGN", "OP_MINUS_ASSIGN", "OP_MULTI_ASSIGN", "OP_DIV_ASSIGN", 
		"OP_MODE_ASSIGN", "OP_POWER_ASSIGN", "OP_BIT_AND_ASSIGN", "OP_BIT_OR_ASSIGN", 
		"OP_BIT_XOR_ASSIGN", "OP_BIT_LEFT_SHIFT_ASSIGN", "OP_BIT_RIGHT_SHIFT_ASSIGN", 
		"OP_BIT_RIGHT_ROTATE_ASSIGN", "DATA_NUMBER", "DATA_LONG", "DATA_STRING", 
		"DATA_CHAR", "LINE_COMMENT", "COMMENT", "NEWLINE", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SourceContext extends ParserRuleContext {
		public List<SegmentContext> segment() {
			return getRuleContexts(SegmentContext.class);
		}
		public SegmentContext segment(int i) {
			return getRuleContext(SegmentContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<KlassContext> klass() {
			return getRuleContexts(KlassContext.class);
		}
		public KlassContext klass(int i) {
			return getRuleContext(KlassContext.class,i);
		}
		public List<NamespaceContext> namespace() {
			return getRuleContexts(NamespaceContext.class);
		}
		public NamespaceContext namespace(int i) {
			return getRuleContext(NamespaceContext.class,i);
		}
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitSource(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitSource(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_source);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(34);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(30);
					segment();
					}
					break;
				case 2:
					{
					setState(31);
					function();
					}
					break;
				case 3:
					{
					setState(32);
					klass();
					}
					break;
				case 4:
					{
					setState(33);
					namespace();
					}
					break;
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45))) != 0) || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (ID - 91)) | (1L << (OP_PLUSPLUS - 91)) | (1L << (OP_MINUSMINUS - 91)) | (1L << (OP_PLUS - 91)) | (1L << (OP_MINUS - 91)) | (1L << (OP_BIT_NOT - 91)) | (1L << (OP_BOOLEAN_NOT - 91)) | (1L << (OP_DOT - 91)) | (1L << (OP_PARENTHESIS_LEFT - 91)) | (1L << (OP_BRACKET_LEFT - 91)) | (1L << (OP_BRACE_LEFT - 91)) | (1L << (OP_SEMICOLON - 91)) | (1L << (DATA_NUMBER - 91)) | (1L << (DATA_LONG - 91)) | (1L << (DATA_STRING - 91)) | (1L << (DATA_CHAR - 91)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SourceUnusedContext extends ParserRuleContext {
		public SourceContext source() {
			return getRuleContext(SourceContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LangParser.EOF, 0); }
		public SourceUnusedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceUnused; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterSourceUnused(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitSourceUnused(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitSourceUnused(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceUnusedContext sourceUnused() throws RecognitionException {
		SourceUnusedContext _localctx = new SourceUnusedContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sourceUnused);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			source();
			setState(39);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespaceContext extends ParserRuleContext {
		public KlassNameContext klassName() {
			return getRuleContext(KlassNameContext.class,0);
		}
		public List<SegmentContext> segment() {
			return getRuleContexts(SegmentContext.class);
		}
		public SegmentContext segment(int i) {
			return getRuleContext(SegmentContext.class,i);
		}
		public List<OperatorFunctionContext> operatorFunction() {
			return getRuleContexts(OperatorFunctionContext.class);
		}
		public OperatorFunctionContext operatorFunction(int i) {
			return getRuleContext(OperatorFunctionContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<KlassContext> klass() {
			return getRuleContexts(KlassContext.class);
		}
		public KlassContext klass(int i) {
			return getRuleContext(KlassContext.class,i);
		}
		public List<NamespaceContext> namespace() {
			return getRuleContexts(NamespaceContext.class);
		}
		public NamespaceContext namespace(int i) {
			return getRuleContext(NamespaceContext.class,i);
		}
		public NamespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterNamespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitNamespace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitNamespace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespaceContext namespace() throws RecognitionException {
		NamespaceContext _localctx = new NamespaceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_namespace);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(T__0);
			setState(42);
			klassName();
			setState(43);
			match(OP_BRACE_LEFT);
			setState(49); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(49);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(44);
					segment();
					}
					break;
				case 2:
					{
					setState(45);
					operatorFunction();
					}
					break;
				case 3:
					{
					setState(46);
					function();
					}
					break;
				case 4:
					{
					setState(47);
					klass();
					}
					break;
				case 5:
					{
					setState(48);
					namespace();
					}
					break;
				}
				}
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45))) != 0) || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (ID - 91)) | (1L << (OP_PLUSPLUS - 91)) | (1L << (OP_MINUSMINUS - 91)) | (1L << (OP_PLUS - 91)) | (1L << (OP_MINUS - 91)) | (1L << (OP_BIT_NOT - 91)) | (1L << (OP_BOOLEAN_NOT - 91)) | (1L << (OP_DOT - 91)) | (1L << (OP_PARENTHESIS_LEFT - 91)) | (1L << (OP_BRACKET_LEFT - 91)) | (1L << (OP_BRACE_LEFT - 91)) | (1L << (OP_SEMICOLON - 91)) | (1L << (DATA_NUMBER - 91)) | (1L << (DATA_LONG - 91)) | (1L << (DATA_STRING - 91)) | (1L << (DATA_CHAR - 91)))) != 0) );
			setState(53);
			match(OP_BRACE_RIGHT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KlassContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public List<KlassNameContext> klassName() {
			return getRuleContexts(KlassNameContext.class);
		}
		public KlassNameContext klassName(int i) {
			return getRuleContext(KlassNameContext.class,i);
		}
		public List<SegmentContext> segment() {
			return getRuleContexts(SegmentContext.class);
		}
		public SegmentContext segment(int i) {
			return getRuleContext(SegmentContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<OperatorFunctionContext> operatorFunction() {
			return getRuleContexts(OperatorFunctionContext.class);
		}
		public OperatorFunctionContext operatorFunction(int i) {
			return getRuleContext(OperatorFunctionContext.class,i);
		}
		public KlassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_klass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterKlass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitKlass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitKlass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KlassContext klass() throws RecognitionException {
		KlassContext _localctx = new KlassContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_klass);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__1);
			setState(56);
			match(ID);
			setState(66);
			_la = _input.LA(1);
			if (_la==OP_COLON) {
				{
				setState(57);
				match(OP_COLON);
				setState(58);
				klassName();
				setState(63);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(59);
						match(OP_COMMA);
						setState(60);
						klassName();
						}
						} 
					}
					setState(65);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				}
			}

			setState(68);
			match(OP_BRACE_LEFT);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					setState(72);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						setState(69);
						segment();
						}
						break;
					case 2:
						{
						setState(70);
						function();
						}
						break;
					case 3:
						{
						setState(71);
						operatorFunction();
						}
						break;
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(77);
			match(OP_BRACE_RIGHT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorFunctionContext extends ParserRuleContext {
		public OperatorsContext name;
		public AtomicObjectContext v;
		public OperatorsContext operators() {
			return getRuleContext(OperatorsContext.class,0);
		}
		public List<SegmentContext> segment() {
			return getRuleContexts(SegmentContext.class);
		}
		public SegmentContext segment(int i) {
			return getRuleContext(SegmentContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(LangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LangParser.ID, i);
		}
		public List<AtomicObjectContext> atomicObject() {
			return getRuleContexts(AtomicObjectContext.class);
		}
		public AtomicObjectContext atomicObject(int i) {
			return getRuleContext(AtomicObjectContext.class,i);
		}
		public OperatorFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterOperatorFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitOperatorFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitOperatorFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorFunctionContext operatorFunction() throws RecognitionException {
		OperatorFunctionContext _localctx = new OperatorFunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_operatorFunction);
		int _la;
		try {
			int _alt;
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				match(T__2);
				setState(80);
				((OperatorFunctionContext)_localctx).name = operators();
				setState(81);
				match(T__3);
				setState(91);
				switch (_input.LA(1)) {
				case OP_BRACE_LEFT:
					{
					setState(82);
					match(OP_BRACE_LEFT);
					setState(86);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
					while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1+1 ) {
							{
							{
							setState(83);
							segment();
							}
							} 
						}
						setState(88);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
					}
					setState(89);
					match(OP_BRACE_RIGHT);
					}
					break;
				case T__4:
					{
					setState(90);
					match(T__4);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				match(T__2);
				setState(94);
				((OperatorFunctionContext)_localctx).name = operators();
				setState(95);
				match(OP_PARENTHESIS_LEFT);
				setState(113);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(96);
					match(ID);
					setState(101);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
					while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1+1 ) {
							{
							{
							setState(97);
							match(OP_COMMA);
							setState(98);
							match(ID);
							}
							} 
						}
						setState(103);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
					}
					setState(110);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
					while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1+1 ) {
							{
							{
							setState(104);
							match(OP_COMMA);
							setState(105);
							match(ID);
							setState(106);
							match(OP_ASSIGN);
							setState(107);
							((OperatorFunctionContext)_localctx).v = atomicObject();
							}
							} 
						}
						setState(112);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
					}
					}
				}

				setState(115);
				match(OP_PARENTHESIS_RIGHT);
				setState(125);
				switch (_input.LA(1)) {
				case OP_BRACE_LEFT:
					{
					setState(116);
					match(OP_BRACE_LEFT);
					setState(120);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
					while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1+1 ) {
							{
							{
							setState(117);
							segment();
							}
							} 
						}
						setState(122);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
					}
					setState(123);
					match(OP_BRACE_RIGHT);
					}
					break;
				case T__4:
					{
					setState(124);
					match(T__4);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				match(T__2);
				setState(128);
				((OperatorFunctionContext)_localctx).name = operators();
				setState(129);
				match(OP_PARENTHESIS_LEFT);
				setState(142);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(130);
					match(ID);
					setState(131);
					match(OP_ASSIGN);
					setState(132);
					((OperatorFunctionContext)_localctx).v = atomicObject();
					setState(139);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
					while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1+1 ) {
							{
							{
							setState(133);
							match(OP_COMMA);
							setState(134);
							match(ID);
							setState(135);
							match(OP_ASSIGN);
							setState(136);
							((OperatorFunctionContext)_localctx).v = atomicObject();
							}
							} 
						}
						setState(141);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
					}
					}
				}

				setState(144);
				match(OP_PARENTHESIS_RIGHT);
				setState(154);
				switch (_input.LA(1)) {
				case OP_BRACE_LEFT:
					{
					setState(145);
					match(OP_BRACE_LEFT);
					setState(149);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
					while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1+1 ) {
							{
							{
							setState(146);
							segment();
							}
							} 
						}
						setState(151);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
					}
					setState(152);
					match(OP_BRACE_RIGHT);
					}
					break;
				case T__4:
					{
					setState(153);
					match(T__4);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public Token name;
		public AtomicObjectContext v;
		public List<TerminalNode> ID() { return getTokens(LangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LangParser.ID, i);
		}
		public List<SegmentContext> segment() {
			return getRuleContexts(SegmentContext.class);
		}
		public SegmentContext segment(int i) {
			return getRuleContext(SegmentContext.class,i);
		}
		public List<AtomicObjectContext> atomicObject() {
			return getRuleContexts(AtomicObjectContext.class);
		}
		public AtomicObjectContext atomicObject(int i) {
			return getRuleContext(AtomicObjectContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function);
		int _la;
		try {
			int _alt;
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(T__2);
				setState(159);
				((FunctionContext)_localctx).name = match(ID);
				setState(160);
				match(T__3);
				setState(170);
				switch (_input.LA(1)) {
				case OP_BRACE_LEFT:
					{
					setState(161);
					match(OP_BRACE_LEFT);
					setState(165);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
					while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1+1 ) {
							{
							{
							setState(162);
							segment();
							}
							} 
						}
						setState(167);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
					}
					setState(168);
					match(OP_BRACE_RIGHT);
					}
					break;
				case T__4:
					{
					setState(169);
					match(T__4);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(T__2);
				setState(173);
				((FunctionContext)_localctx).name = match(ID);
				setState(174);
				match(OP_PARENTHESIS_LEFT);
				setState(192);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(175);
					match(ID);
					setState(180);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
					while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1+1 ) {
							{
							{
							setState(176);
							match(OP_COMMA);
							setState(177);
							match(ID);
							}
							} 
						}
						setState(182);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
					}
					setState(189);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
					while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1+1 ) {
							{
							{
							setState(183);
							match(OP_COMMA);
							setState(184);
							match(ID);
							setState(185);
							match(OP_ASSIGN);
							setState(186);
							((FunctionContext)_localctx).v = atomicObject();
							}
							} 
						}
						setState(191);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
					}
					}
				}

				setState(194);
				match(OP_PARENTHESIS_RIGHT);
				setState(204);
				switch (_input.LA(1)) {
				case OP_BRACE_LEFT:
					{
					setState(195);
					match(OP_BRACE_LEFT);
					setState(199);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
					while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1+1 ) {
							{
							{
							setState(196);
							segment();
							}
							} 
						}
						setState(201);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
					}
					setState(202);
					match(OP_BRACE_RIGHT);
					}
					break;
				case T__4:
					{
					setState(203);
					match(T__4);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(206);
				match(T__2);
				setState(207);
				((FunctionContext)_localctx).name = match(ID);
				setState(208);
				match(OP_PARENTHESIS_LEFT);
				setState(221);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(209);
					match(ID);
					setState(210);
					match(OP_ASSIGN);
					setState(211);
					((FunctionContext)_localctx).v = atomicObject();
					setState(218);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
					while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1+1 ) {
							{
							{
							setState(212);
							match(OP_COMMA);
							setState(213);
							match(ID);
							setState(214);
							match(OP_ASSIGN);
							setState(215);
							((FunctionContext)_localctx).v = atomicObject();
							}
							} 
						}
						setState(220);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
					}
					}
				}

				setState(223);
				match(OP_PARENTHESIS_RIGHT);
				setState(233);
				switch (_input.LA(1)) {
				case OP_BRACE_LEFT:
					{
					setState(224);
					match(OP_BRACE_LEFT);
					setState(228);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
					while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1+1 ) {
							{
							{
							setState(225);
							segment();
							}
							} 
						}
						setState(230);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
					}
					setState(231);
					match(OP_BRACE_RIGHT);
					}
					break;
				case T__4:
					{
					setState(232);
					match(T__4);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SegmentContext extends ParserRuleContext {
		public SegmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_segment; }
	 
		public SegmentContext() { }
		public void copyFrom(SegmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BlockSegmentContext extends SegmentContext {
		public List<SegmentContext> segment() {
			return getRuleContexts(SegmentContext.class);
		}
		public SegmentContext segment(int i) {
			return getRuleContext(SegmentContext.class,i);
		}
		public BlockSegmentContext(SegmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterBlockSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitBlockSegment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitBlockSegment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrySegmentContext extends SegmentContext {
		public List<SegmentContext> segment() {
			return getRuleContexts(SegmentContext.class);
		}
		public SegmentContext segment(int i) {
			return getRuleContext(SegmentContext.class,i);
		}
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TrySegmentContext(SegmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterTrySegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitTrySegment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitTrySegment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForSegmentContext extends SegmentContext {
		public Token label;
		public TermContext expr0;
		public TermContext expr1;
		public TermContext expr2;
		public SegmentContext segment() {
			return getRuleContext(SegmentContext.class,0);
		}
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public ForSegmentContext(SegmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterForSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitForSegment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitForSegment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfElseSegmentContext extends SegmentContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public List<SegmentContext> segment() {
			return getRuleContexts(SegmentContext.class);
		}
		public SegmentContext segment(int i) {
			return getRuleContext(SegmentContext.class,i);
		}
		public IfElseSegmentContext(SegmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterIfElseSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitIfElseSegment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitIfElseSegment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementSegmentContext extends SegmentContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementSegmentContext(SegmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterStatementSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitStatementSegment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitStatementSegment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileSegmentContext extends SegmentContext {
		public Token label;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public SegmentContext segment() {
			return getRuleContext(SegmentContext.class,0);
		}
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public WhileSegmentContext(SegmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterWhileSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitWhileSegment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitWhileSegment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SwitchSegmentContext extends SegmentContext {
		public TermContext in;
		public TermContext con;
		public SegmentContext cas;
		public SegmentContext def;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<SegmentContext> segment() {
			return getRuleContexts(SegmentContext.class);
		}
		public SegmentContext segment(int i) {
			return getRuleContext(SegmentContext.class,i);
		}
		public SwitchSegmentContext(SegmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterSwitchSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitSwitchSegment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitSwitchSegment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LockSegmentContext extends SegmentContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public SegmentContext segment() {
			return getRuleContext(SegmentContext.class,0);
		}
		public LockSegmentContext(SegmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterLockSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitLockSegment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitLockSegment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DowhileSegmemtContext extends SegmentContext {
		public Token label;
		public SegmentContext segment() {
			return getRuleContext(SegmentContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public DowhileSegmemtContext(SegmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterDowhileSegmemt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitDowhileSegmemt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDowhileSegmemt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForeachSegmentContext extends SegmentContext {
		public Token label;
		public Token name;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public SegmentContext segment() {
			return getRuleContext(SegmentContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(LangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LangParser.ID, i);
		}
		public ForeachSegmentContext(SegmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterForeachSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitForeachSegment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitForeachSegment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SegmentContext segment() throws RecognitionException {
		SegmentContext _localctx = new SegmentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_segment);
		int _la;
		try {
			int _alt;
			setState(374);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				_localctx = new BlockSegmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				match(OP_BRACE_LEFT);
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45))) != 0) || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (ID - 91)) | (1L << (OP_PLUSPLUS - 91)) | (1L << (OP_MINUSMINUS - 91)) | (1L << (OP_PLUS - 91)) | (1L << (OP_MINUS - 91)) | (1L << (OP_BIT_NOT - 91)) | (1L << (OP_BOOLEAN_NOT - 91)) | (1L << (OP_DOT - 91)) | (1L << (OP_PARENTHESIS_LEFT - 91)) | (1L << (OP_BRACKET_LEFT - 91)) | (1L << (OP_BRACE_LEFT - 91)) | (1L << (OP_SEMICOLON - 91)) | (1L << (DATA_NUMBER - 91)) | (1L << (DATA_LONG - 91)) | (1L << (DATA_STRING - 91)) | (1L << (DATA_CHAR - 91)))) != 0)) {
					{
					{
					setState(238);
					segment();
					}
					}
					setState(243);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(244);
				match(OP_BRACE_RIGHT);
				}
				break;
			case 2:
				_localctx = new StatementSegmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				statement();
				}
				break;
			case 3:
				_localctx = new IfElseSegmentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(246);
				match(T__5);
				setState(247);
				match(OP_PARENTHESIS_LEFT);
				setState(248);
				term(0);
				setState(249);
				match(OP_PARENTHESIS_RIGHT);
				setState(250);
				segment();
				setState(253);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(251);
					match(T__6);
					setState(252);
					segment();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new DowhileSegmemtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(257);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(255);
					((DowhileSegmemtContext)_localctx).label = match(ID);
					setState(256);
					match(OP_COLON);
					}
				}

				setState(259);
				match(T__7);
				setState(260);
				segment();
				setState(261);
				match(T__8);
				setState(262);
				match(OP_PARENTHESIS_LEFT);
				setState(263);
				term(0);
				setState(264);
				match(OP_PARENTHESIS_RIGHT);
				setState(265);
				match(OP_SEMICOLON);
				}
				break;
			case 5:
				_localctx = new WhileSegmentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(269);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(267);
					((WhileSegmentContext)_localctx).label = match(ID);
					setState(268);
					match(OP_COLON);
					}
				}

				setState(271);
				match(T__8);
				setState(272);
				match(OP_PARENTHESIS_LEFT);
				setState(273);
				term(0);
				setState(274);
				match(OP_PARENTHESIS_RIGHT);
				setState(275);
				segment();
				}
				break;
			case 6:
				_localctx = new ForeachSegmentContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(279);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(277);
					((ForeachSegmentContext)_localctx).label = match(ID);
					setState(278);
					match(OP_COLON);
					}
				}

				setState(281);
				match(T__9);
				setState(282);
				match(OP_PARENTHESIS_LEFT);
				setState(284);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(283);
					match(T__10);
					}
				}

				setState(286);
				((ForeachSegmentContext)_localctx).name = match(ID);
				setState(287);
				match(OP_COLON);
				setState(288);
				term(0);
				setState(289);
				match(OP_PARENTHESIS_RIGHT);
				setState(290);
				segment();
				}
				break;
			case 7:
				_localctx = new ForSegmentContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(294);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(292);
					((ForSegmentContext)_localctx).label = match(ID);
					setState(293);
					match(OP_COLON);
					}
				}

				setState(296);
				match(T__9);
				setState(297);
				match(OP_PARENTHESIS_LEFT);
				setState(302);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__4) | (1L << T__10) | (1L << T__13) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45))) != 0) || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (ID - 91)) | (1L << (OP_PLUSPLUS - 91)) | (1L << (OP_MINUSMINUS - 91)) | (1L << (OP_PLUS - 91)) | (1L << (OP_MINUS - 91)) | (1L << (OP_BIT_NOT - 91)) | (1L << (OP_BOOLEAN_NOT - 91)) | (1L << (OP_DOT - 91)) | (1L << (OP_PARENTHESIS_LEFT - 91)) | (1L << (OP_BRACKET_LEFT - 91)) | (1L << (OP_BRACE_LEFT - 91)) | (1L << (DATA_NUMBER - 91)) | (1L << (DATA_LONG - 91)) | (1L << (DATA_STRING - 91)) | (1L << (DATA_CHAR - 91)))) != 0)) {
					{
					setState(299);
					_la = _input.LA(1);
					if (_la==T__10) {
						{
						setState(298);
						match(T__10);
						}
					}

					setState(301);
					((ForSegmentContext)_localctx).expr0 = term(0);
					}
				}

				setState(304);
				match(OP_SEMICOLON);
				setState(306);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__4) | (1L << T__13) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45))) != 0) || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (ID - 91)) | (1L << (OP_PLUSPLUS - 91)) | (1L << (OP_MINUSMINUS - 91)) | (1L << (OP_PLUS - 91)) | (1L << (OP_MINUS - 91)) | (1L << (OP_BIT_NOT - 91)) | (1L << (OP_BOOLEAN_NOT - 91)) | (1L << (OP_DOT - 91)) | (1L << (OP_PARENTHESIS_LEFT - 91)) | (1L << (OP_BRACKET_LEFT - 91)) | (1L << (OP_BRACE_LEFT - 91)) | (1L << (DATA_NUMBER - 91)) | (1L << (DATA_LONG - 91)) | (1L << (DATA_STRING - 91)) | (1L << (DATA_CHAR - 91)))) != 0)) {
					{
					setState(305);
					((ForSegmentContext)_localctx).expr1 = term(0);
					}
				}

				setState(308);
				match(OP_SEMICOLON);
				setState(310);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__4) | (1L << T__13) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45))) != 0) || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (ID - 91)) | (1L << (OP_PLUSPLUS - 91)) | (1L << (OP_MINUSMINUS - 91)) | (1L << (OP_PLUS - 91)) | (1L << (OP_MINUS - 91)) | (1L << (OP_BIT_NOT - 91)) | (1L << (OP_BOOLEAN_NOT - 91)) | (1L << (OP_DOT - 91)) | (1L << (OP_PARENTHESIS_LEFT - 91)) | (1L << (OP_BRACKET_LEFT - 91)) | (1L << (OP_BRACE_LEFT - 91)) | (1L << (DATA_NUMBER - 91)) | (1L << (DATA_LONG - 91)) | (1L << (DATA_STRING - 91)) | (1L << (DATA_CHAR - 91)))) != 0)) {
					{
					setState(309);
					((ForSegmentContext)_localctx).expr2 = term(0);
					}
				}

				setState(312);
				match(OP_PARENTHESIS_RIGHT);
				setState(313);
				segment();
				}
				break;
			case 8:
				_localctx = new SwitchSegmentContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(314);
				match(T__11);
				setState(315);
				((SwitchSegmentContext)_localctx).in = term(0);
				setState(316);
				match(OP_BRACE_LEFT);
				setState(324);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(317);
						match(T__12);
						setState(318);
						((SwitchSegmentContext)_localctx).con = term(0);
						setState(319);
						match(OP_COLON);
						setState(320);
						((SwitchSegmentContext)_localctx).cas = segment();
						}
						} 
					}
					setState(326);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				}
				setState(330);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(327);
					match(T__13);
					setState(328);
					match(OP_COLON);
					setState(329);
					((SwitchSegmentContext)_localctx).def = segment();
					}
				}

				setState(332);
				match(OP_BRACE_RIGHT);
				}
				break;
			case 9:
				_localctx = new TrySegmentContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(334);
				match(T__14);
				setState(335);
				match(OP_BRACE_LEFT);
				setState(339);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(336);
						segment();
						}
						} 
					}
					setState(341);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				}
				setState(342);
				match(OP_BRACE_RIGHT);
				setState(355);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(343);
					match(T__15);
					setState(344);
					match(OP_PARENTHESIS_LEFT);
					setState(345);
					match(ID);
					setState(346);
					match(OP_PARENTHESIS_RIGHT);
					setState(347);
					match(OP_BRACE_LEFT);
					setState(351);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
					while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1+1 ) {
							{
							{
							setState(348);
							segment();
							}
							} 
						}
						setState(353);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
					}
					setState(354);
					match(OP_BRACE_RIGHT);
					}
					break;
				}
				setState(366);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
				case 1:
					{
					setState(357);
					match(T__16);
					setState(358);
					match(OP_BRACE_LEFT);
					setState(362);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
					while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1+1 ) {
							{
							{
							setState(359);
							segment();
							}
							} 
						}
						setState(364);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
					}
					setState(365);
					match(OP_BRACE_RIGHT);
					}
					break;
				}
				}
				break;
			case 10:
				_localctx = new LockSegmentContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(368);
				match(T__17);
				setState(369);
				match(OP_PARENTHESIS_LEFT);
				setState(370);
				term(0);
				setState(371);
				match(OP_PARENTHESIS_RIGHT);
				setState(372);
				segment();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmptyStatementContext extends StatementContext {
		public EmptyStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignStatmentContext extends StatementContext {
		public VariantNameContext variantName() {
			return getRuleContext(VariantNameContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public AssignStatmentContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterAssignStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitAssignStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitAssignStatment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ThrowStatementContext extends StatementContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ThrowStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterThrowStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitThrowStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitThrowStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TermStatementContext extends StatementContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterTermStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitTermStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitTermStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakStatementContext extends StatementContext {
		public Token label;
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public BreakStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueStatementContext extends StatementContext {
		public ContinueStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitContinueStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStatementContext extends StatementContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ReturnStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class YieldStatementContext extends StatementContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public YieldStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterYieldStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitYieldStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitYieldStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		int _la;
		try {
			setState(420);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				_localctx = new EmptyStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(376);
				match(OP_SEMICOLON);
				}
				break;
			case 2:
				_localctx = new AssignStatmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(377);
				match(T__10);
				setState(378);
				variantName();
				setState(381);
				_la = _input.LA(1);
				if (_la==OP_ASSIGN) {
					{
					setState(379);
					match(OP_ASSIGN);
					setState(380);
					term(0);
					}
				}

				setState(383);
				match(OP_SEMICOLON);
				}
				break;
			case 3:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(385);
				match(T__18);
				setState(387);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__4) | (1L << T__13) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45))) != 0) || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (ID - 91)) | (1L << (OP_PLUSPLUS - 91)) | (1L << (OP_MINUSMINUS - 91)) | (1L << (OP_PLUS - 91)) | (1L << (OP_MINUS - 91)) | (1L << (OP_BIT_NOT - 91)) | (1L << (OP_BOOLEAN_NOT - 91)) | (1L << (OP_DOT - 91)) | (1L << (OP_PARENTHESIS_LEFT - 91)) | (1L << (OP_BRACKET_LEFT - 91)) | (1L << (OP_BRACE_LEFT - 91)) | (1L << (DATA_NUMBER - 91)) | (1L << (DATA_LONG - 91)) | (1L << (DATA_STRING - 91)) | (1L << (DATA_CHAR - 91)))) != 0)) {
					{
					setState(386);
					term(0);
					}
				}

				setState(389);
				match(OP_SEMICOLON);
				}
				break;
			case 4:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(390);
				match(T__18);
				setState(391);
				match(OP_PARENTHESIS_LEFT);
				setState(392);
				term(0);
				setState(393);
				match(OP_PARENTHESIS_RIGHT);
				setState(394);
				match(OP_SEMICOLON);
				}
				break;
			case 5:
				_localctx = new YieldStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(396);
				match(T__19);
				setState(397);
				term(0);
				setState(398);
				match(OP_SEMICOLON);
				}
				break;
			case 6:
				_localctx = new YieldStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(400);
				match(T__19);
				setState(401);
				match(OP_PARENTHESIS_LEFT);
				setState(402);
				term(0);
				setState(403);
				match(OP_PARENTHESIS_RIGHT);
				setState(404);
				match(OP_SEMICOLON);
				}
				break;
			case 7:
				_localctx = new ContinueStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(406);
				match(T__20);
				setState(407);
				match(OP_SEMICOLON);
				}
				break;
			case 8:
				_localctx = new BreakStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(408);
				match(T__21);
				setState(410);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(409);
					((BreakStatementContext)_localctx).label = match(ID);
					}
				}

				setState(412);
				match(OP_SEMICOLON);
				}
				break;
			case 9:
				_localctx = new ThrowStatementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(413);
				match(T__22);
				setState(414);
				term(0);
				setState(415);
				match(OP_SEMICOLON);
				}
				break;
			case 10:
				_localctx = new TermStatementContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(417);
				term(0);
				setState(418);
				match(OP_SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BasicTermContext extends TermContext {
		public AtomicObjectContext atomicObject() {
			return getRuleContext(AtomicObjectContext.class,0);
		}
		public BasicTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterBasicTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitBasicTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitBasicTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryTermContext extends TermContext {
		public Token op;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode OP_POWER() { return getToken(LangParser.OP_POWER, 0); }
		public TerminalNode OP_MULTIPLY() { return getToken(LangParser.OP_MULTIPLY, 0); }
		public TerminalNode OP_DIVIDE() { return getToken(LangParser.OP_DIVIDE, 0); }
		public TerminalNode OP_MODE() { return getToken(LangParser.OP_MODE, 0); }
		public TerminalNode OP_PLUS() { return getToken(LangParser.OP_PLUS, 0); }
		public TerminalNode OP_MINUS() { return getToken(LangParser.OP_MINUS, 0); }
		public TerminalNode OP_BIT_LEFT_SHIFT() { return getToken(LangParser.OP_BIT_LEFT_SHIFT, 0); }
		public TerminalNode OP_BIT_RIGHT_SHIFT() { return getToken(LangParser.OP_BIT_RIGHT_SHIFT, 0); }
		public TerminalNode OP_BIT_RIGHT_ROTATE() { return getToken(LangParser.OP_BIT_RIGHT_ROTATE, 0); }
		public TerminalNode OP_GREATER_THAN() { return getToken(LangParser.OP_GREATER_THAN, 0); }
		public TerminalNode OP_GREATER_EQAULS() { return getToken(LangParser.OP_GREATER_EQAULS, 0); }
		public TerminalNode OP_LESS_THAN() { return getToken(LangParser.OP_LESS_THAN, 0); }
		public TerminalNode OP_LESS_EQUALS() { return getToken(LangParser.OP_LESS_EQUALS, 0); }
		public TerminalNode OP_REF_EQUALS() { return getToken(LangParser.OP_REF_EQUALS, 0); }
		public TerminalNode OP_REF_NOT_EQUALS() { return getToken(LangParser.OP_REF_NOT_EQUALS, 0); }
		public TerminalNode OP_EQUALS() { return getToken(LangParser.OP_EQUALS, 0); }
		public TerminalNode OP_NOT_EQUALS() { return getToken(LangParser.OP_NOT_EQUALS, 0); }
		public TerminalNode OP_REGEX_MATCH() { return getToken(LangParser.OP_REGEX_MATCH, 0); }
		public TerminalNode OP_BIT_AND() { return getToken(LangParser.OP_BIT_AND, 0); }
		public TerminalNode OP_BIT_XOR() { return getToken(LangParser.OP_BIT_XOR, 0); }
		public TerminalNode OP_BIT_OR() { return getToken(LangParser.OP_BIT_OR, 0); }
		public TerminalNode OP_BOOLEAN_AND() { return getToken(LangParser.OP_BOOLEAN_AND, 0); }
		public TerminalNode OP_BOOLEAN_OR() { return getToken(LangParser.OP_BOOLEAN_OR, 0); }
		public TerminalNode OP_NULLOR() { return getToken(LangParser.OP_NULLOR, 0); }
		public BinaryTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterBinaryTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitBinaryTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitBinaryTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DotClassTermContext extends TermContext {
		public Token op;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode OP_DOT() { return getToken(LangParser.OP_DOT, 0); }
		public DotClassTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterDotClassTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitDotClassTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDotClassTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreSelfUnaryTermContext extends TermContext {
		public Token op;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode OP_PLUSPLUS() { return getToken(LangParser.OP_PLUSPLUS, 0); }
		public TerminalNode OP_MINUSMINUS() { return getToken(LangParser.OP_MINUSMINUS, 0); }
		public PreSelfUnaryTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterPreSelfUnaryTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitPreSelfUnaryTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitPreSelfUnaryTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefinedTermContext extends TermContext {
		public FullPathContext fullPath() {
			return getRuleContext(FullPathContext.class,0);
		}
		public DefinedTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterDefinedTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitDefinedTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDefinedTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PostSelfUnaryTermContext extends TermContext {
		public Token op;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode OP_PLUSPLUS() { return getToken(LangParser.OP_PLUSPLUS, 0); }
		public TerminalNode OP_MINUSMINUS() { return getToken(LangParser.OP_MINUSMINUS, 0); }
		public PostSelfUnaryTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterPostSelfUnaryTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitPostSelfUnaryTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitPostSelfUnaryTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CastTermContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public CastTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterCastTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitCastTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitCastTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InTermContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public InTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterInTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitInTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitInTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewTermContext extends TermContext {
		public KlassNameContext klassName() {
			return getRuleContext(KlassNameContext.class,0);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public NewTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterNewTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitNewTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitNewTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignTermContext extends TermContext {
		public Token op;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode OP_BIT_LEFT_SHIFT_ASSIGN() { return getToken(LangParser.OP_BIT_LEFT_SHIFT_ASSIGN, 0); }
		public TerminalNode OP_BIT_RIGHT_SHIFT_ASSIGN() { return getToken(LangParser.OP_BIT_RIGHT_SHIFT_ASSIGN, 0); }
		public TerminalNode OP_POWER_ASSIGN() { return getToken(LangParser.OP_POWER_ASSIGN, 0); }
		public TerminalNode OP_MULTI_ASSIGN() { return getToken(LangParser.OP_MULTI_ASSIGN, 0); }
		public TerminalNode OP_DIV_ASSIGN() { return getToken(LangParser.OP_DIV_ASSIGN, 0); }
		public TerminalNode OP_MODE_ASSIGN() { return getToken(LangParser.OP_MODE_ASSIGN, 0); }
		public TerminalNode OP_PLUS_ASSIGN() { return getToken(LangParser.OP_PLUS_ASSIGN, 0); }
		public TerminalNode OP_MINUS_ASSIGN() { return getToken(LangParser.OP_MINUS_ASSIGN, 0); }
		public TerminalNode OP_BIT_AND_ASSIGN() { return getToken(LangParser.OP_BIT_AND_ASSIGN, 0); }
		public TerminalNode OP_BIT_XOR_ASSIGN() { return getToken(LangParser.OP_BIT_XOR_ASSIGN, 0); }
		public TerminalNode OP_BIT_OR_ASSIGN() { return getToken(LangParser.OP_BIT_OR_ASSIGN, 0); }
		public TerminalNode OP_ASSIGN() { return getToken(LangParser.OP_ASSIGN, 0); }
		public AssignTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterAssignTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitAssignTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitAssignTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaTermContext extends TermContext {
		public SegmentContext segment() {
			return getRuleContext(SegmentContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(LangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LangParser.ID, i);
		}
		public LambdaTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterLambdaTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitLambdaTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitLambdaTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisTermContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public ParenthesisTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterParenthesisTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitParenthesisTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitParenthesisTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListTermContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public ListTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterListTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitListTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitListTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsTermContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public IsTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterIsTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitIsTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitIsTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GlobalIDTermContext extends TermContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public GlobalIDTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterGlobalIDTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitGlobalIDTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitGlobalIDTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstTermContext extends TermContext {
		public ConstTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterConstTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitConstTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitConstTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndicesTermContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public IndicesTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterIndicesTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitIndicesTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitIndicesTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryTermContext extends TermContext {
		public Token op;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode OP_MINUS() { return getToken(LangParser.OP_MINUS, 0); }
		public TerminalNode OP_PLUS() { return getToken(LangParser.OP_PLUS, 0); }
		public TerminalNode OP_BOOLEAN_NOT() { return getToken(LangParser.OP_BOOLEAN_NOT, 0); }
		public TerminalNode OP_BIT_NOT() { return getToken(LangParser.OP_BIT_NOT, 0); }
		public UnaryTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterUnaryTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitUnaryTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitUnaryTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimitiveTermContext extends TermContext {
		public PrimitiveTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterPrimitiveTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitPrimitiveTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitPrimitiveTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionTermContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode OP_QUESTION() { return getToken(LangParser.OP_QUESTION, 0); }
		public TerminalNode OP_COLON() { return getToken(LangParser.OP_COLON, 0); }
		public ConditionTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterConditionTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitConditionTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitConditionTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class KeywordTermContext extends TermContext {
		public KeywordTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterKeywordTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitKeywordTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitKeywordTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DotTermContext extends TermContext {
		public Token op;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TerminalNode OP_DOT() { return getToken(LangParser.OP_DOT, 0); }
		public DotTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterDotTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitDotTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDotTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MapTermContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public MapTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterMapTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitMapTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitMapTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InvokeTermContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public InvokeTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterInvokeTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitInvokeTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitInvokeTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefaultTermContext extends TermContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public DefaultTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterDefaultTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitDefaultTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDefaultTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JlambdaTermContext extends TermContext {
		public SegmentContext segment() {
			return getRuleContext(SegmentContext.class,0);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(LangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LangParser.ID, i);
		}
		public JlambdaTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterJlambdaTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitJlambdaTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitJlambdaTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_term, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				{
				_localctx = new GlobalIDTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(423);
				match(OP_DOT);
				setState(424);
				match(ID);
				}
				break;
			case 2:
				{
				_localctx = new DefinedTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(425);
				match(T__23);
				setState(426);
				match(OP_PARENTHESIS_LEFT);
				setState(427);
				fullPath();
				setState(428);
				match(OP_PARENTHESIS_RIGHT);
				}
				break;
			case 3:
				{
				_localctx = new DefaultTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(430);
				match(T__13);
				setState(431);
				match(OP_PARENTHESIS_LEFT);
				setState(432);
				term(0);
				setState(433);
				match(OP_PARENTHESIS_RIGHT);
				}
				break;
			case 4:
				{
				_localctx = new ConstTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(435);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 5:
				{
				_localctx = new KeywordTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(436);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__30) | (1L << T__31))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 6:
				{
				_localctx = new PrimitiveTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(437);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 7:
				{
				_localctx = new NewTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(438);
				match(T__43);
				setState(439);
				klassName();
				setState(440);
				match(OP_PARENTHESIS_LEFT);
				setState(449);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__4) | (1L << T__13) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45))) != 0) || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (ID - 91)) | (1L << (OP_PLUSPLUS - 91)) | (1L << (OP_MINUSMINUS - 91)) | (1L << (OP_PLUS - 91)) | (1L << (OP_MINUS - 91)) | (1L << (OP_BIT_NOT - 91)) | (1L << (OP_BOOLEAN_NOT - 91)) | (1L << (OP_DOT - 91)) | (1L << (OP_PARENTHESIS_LEFT - 91)) | (1L << (OP_BRACKET_LEFT - 91)) | (1L << (OP_BRACE_LEFT - 91)) | (1L << (DATA_NUMBER - 91)) | (1L << (DATA_LONG - 91)) | (1L << (DATA_STRING - 91)) | (1L << (DATA_CHAR - 91)))) != 0)) {
					{
					setState(441);
					term(0);
					setState(446);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==OP_COMMA) {
						{
						{
						setState(442);
						match(OP_COMMA);
						setState(443);
						term(0);
						}
						}
						setState(448);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(451);
				match(OP_PARENTHESIS_RIGHT);
				}
				break;
			case 8:
				{
				_localctx = new NewTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(453);
				match(T__43);
				setState(454);
				klassName();
				setState(455);
				match(T__3);
				}
				break;
			case 9:
				{
				_localctx = new LambdaTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(457);
				match(OP_PARENTHESIS_LEFT);
				setState(466);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(458);
					match(ID);
					setState(463);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
					while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1+1 ) {
							{
							{
							setState(459);
							match(OP_COMMA);
							setState(460);
							match(ID);
							}
							} 
						}
						setState(465);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
					}
					}
				}

				setState(468);
				match(OP_PARENTHESIS_RIGHT);
				setState(469);
				match(T__44);
				setState(472);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
				case 1:
					{
					setState(470);
					segment();
					}
					break;
				case 2:
					{
					setState(471);
					term(0);
					}
					break;
				}
				}
				break;
			case 10:
				{
				_localctx = new LambdaTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(474);
				match(T__3);
				setState(475);
				match(T__44);
				setState(478);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
				case 1:
					{
					setState(476);
					segment();
					}
					break;
				case 2:
					{
					setState(477);
					term(0);
					}
					break;
				}
				}
				break;
			case 11:
				{
				_localctx = new JlambdaTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(480);
				match(T__45);
				setState(481);
				match(T__3);
				setState(482);
				match(T__44);
				setState(485);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					setState(483);
					segment();
					}
					break;
				case 2:
					{
					setState(484);
					term(0);
					}
					break;
				}
				}
				break;
			case 12:
				{
				_localctx = new JlambdaTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(487);
				match(OP_BRACKET_LEFT);
				setState(488);
				term(0);
				setState(489);
				match(OP_BRACKET_RIGHT);
				setState(490);
				match(OP_PARENTHESIS_LEFT);
				setState(499);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(491);
					match(ID);
					setState(496);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
					while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1+1 ) {
							{
							{
							setState(492);
							match(OP_COMMA);
							setState(493);
							match(ID);
							}
							} 
						}
						setState(498);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
					}
					}
				}

				setState(501);
				match(OP_PARENTHESIS_RIGHT);
				setState(502);
				match(T__44);
				setState(505);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
				case 1:
					{
					setState(503);
					segment();
					}
					break;
				case 2:
					{
					setState(504);
					term(0);
					}
					break;
				}
				}
				break;
			case 13:
				{
				_localctx = new JlambdaTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(507);
				match(OP_BRACKET_LEFT);
				setState(508);
				term(0);
				setState(509);
				match(OP_BRACKET_RIGHT);
				setState(510);
				match(T__3);
				setState(511);
				match(T__44);
				setState(514);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(512);
					segment();
					}
					break;
				case 2:
					{
					setState(513);
					term(0);
					}
					break;
				}
				}
				break;
			case 14:
				{
				_localctx = new ParenthesisTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(516);
				match(OP_PARENTHESIS_LEFT);
				setState(525);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__4) | (1L << T__13) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45))) != 0) || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (ID - 91)) | (1L << (OP_PLUSPLUS - 91)) | (1L << (OP_MINUSMINUS - 91)) | (1L << (OP_PLUS - 91)) | (1L << (OP_MINUS - 91)) | (1L << (OP_BIT_NOT - 91)) | (1L << (OP_BOOLEAN_NOT - 91)) | (1L << (OP_DOT - 91)) | (1L << (OP_PARENTHESIS_LEFT - 91)) | (1L << (OP_BRACKET_LEFT - 91)) | (1L << (OP_BRACE_LEFT - 91)) | (1L << (DATA_NUMBER - 91)) | (1L << (DATA_LONG - 91)) | (1L << (DATA_STRING - 91)) | (1L << (DATA_CHAR - 91)))) != 0)) {
					{
					setState(517);
					term(0);
					setState(522);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==OP_COMMA) {
						{
						{
						setState(518);
						match(OP_COMMA);
						setState(519);
						term(0);
						}
						}
						setState(524);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(527);
				match(OP_PARENTHESIS_RIGHT);
				}
				break;
			case 15:
				{
				_localctx = new MapTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(528);
				match(OP_BRACE_LEFT);
				setState(543);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__4) | (1L << T__13) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45))) != 0) || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (ID - 91)) | (1L << (OP_PLUSPLUS - 91)) | (1L << (OP_MINUSMINUS - 91)) | (1L << (OP_PLUS - 91)) | (1L << (OP_MINUS - 91)) | (1L << (OP_BIT_NOT - 91)) | (1L << (OP_BOOLEAN_NOT - 91)) | (1L << (OP_DOT - 91)) | (1L << (OP_PARENTHESIS_LEFT - 91)) | (1L << (OP_BRACKET_LEFT - 91)) | (1L << (OP_BRACE_LEFT - 91)) | (1L << (DATA_NUMBER - 91)) | (1L << (DATA_LONG - 91)) | (1L << (DATA_STRING - 91)) | (1L << (DATA_CHAR - 91)))) != 0)) {
					{
					{
					setState(529);
					term(0);
					setState(530);
					match(OP_COLON);
					setState(531);
					term(0);
					}
					setState(540);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==OP_COMMA) {
						{
						{
						setState(533);
						match(OP_COMMA);
						setState(534);
						term(0);
						setState(535);
						match(OP_COLON);
						setState(536);
						term(0);
						}
						}
						setState(542);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(545);
				match(OP_BRACE_RIGHT);
				}
				break;
			case 16:
				{
				_localctx = new MapTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(546);
				match(T__4);
				}
				break;
			case 17:
				{
				_localctx = new ListTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(547);
				match(OP_BRACKET_LEFT);
				setState(556);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__4) | (1L << T__13) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45))) != 0) || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (ID - 91)) | (1L << (OP_PLUSPLUS - 91)) | (1L << (OP_MINUSMINUS - 91)) | (1L << (OP_PLUS - 91)) | (1L << (OP_MINUS - 91)) | (1L << (OP_BIT_NOT - 91)) | (1L << (OP_BOOLEAN_NOT - 91)) | (1L << (OP_DOT - 91)) | (1L << (OP_PARENTHESIS_LEFT - 91)) | (1L << (OP_BRACKET_LEFT - 91)) | (1L << (OP_BRACE_LEFT - 91)) | (1L << (DATA_NUMBER - 91)) | (1L << (DATA_LONG - 91)) | (1L << (DATA_STRING - 91)) | (1L << (DATA_CHAR - 91)))) != 0)) {
					{
					setState(548);
					term(0);
					setState(553);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==OP_COMMA) {
						{
						{
						setState(549);
						match(OP_COMMA);
						setState(550);
						term(0);
						}
						}
						setState(555);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(558);
				match(OP_BRACKET_RIGHT);
				}
				break;
			case 18:
				{
				_localctx = new ListTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(559);
				match(T__45);
				}
				break;
			case 19:
				{
				_localctx = new UnaryTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(560);
				((UnaryTermContext)_localctx).op = match(OP_MINUS);
				setState(561);
				term(31);
				}
				break;
			case 20:
				{
				_localctx = new UnaryTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(562);
				((UnaryTermContext)_localctx).op = match(OP_PLUS);
				setState(563);
				term(30);
				}
				break;
			case 21:
				{
				_localctx = new UnaryTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(564);
				((UnaryTermContext)_localctx).op = match(OP_BOOLEAN_NOT);
				setState(565);
				term(29);
				}
				break;
			case 22:
				{
				_localctx = new UnaryTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(566);
				((UnaryTermContext)_localctx).op = match(OP_BIT_NOT);
				setState(567);
				term(28);
				}
				break;
			case 23:
				{
				_localctx = new PreSelfUnaryTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(568);
				((PreSelfUnaryTermContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==OP_PLUSPLUS || _la==OP_MINUSMINUS) ) {
					((PreSelfUnaryTermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(569);
				term(27);
				}
				break;
			case 24:
				{
				_localctx = new BasicTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(570);
				atomicObject();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(686);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(684);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(573);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(574);
						((BinaryTermContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (OP_POWER - 96)) | (1L << (OP_MULTIPLY - 96)) | (1L << (OP_DIVIDE - 96)) | (1L << (OP_MODE - 96)))) != 0)) ) {
							((BinaryTermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(575);
						term(26);
						}
						break;
					case 2:
						{
						_localctx = new BinaryTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(576);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(577);
						((BinaryTermContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_PLUS || _la==OP_MINUS) ) {
							((BinaryTermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(578);
						term(25);
						}
						break;
					case 3:
						{
						_localctx = new BinaryTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(579);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(580);
						((BinaryTermContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (OP_BIT_LEFT_SHIFT - 104)) | (1L << (OP_BIT_RIGHT_SHIFT - 104)) | (1L << (OP_BIT_RIGHT_ROTATE - 104)))) != 0)) ) {
							((BinaryTermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(581);
						term(24);
						}
						break;
					case 4:
						{
						_localctx = new BinaryTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(582);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(583);
						((BinaryTermContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (OP_GREATER_THAN - 115)) | (1L << (OP_GREATER_EQAULS - 115)) | (1L << (OP_LESS_THAN - 115)) | (1L << (OP_LESS_EQUALS - 115)))) != 0)) ) {
							((BinaryTermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(584);
						term(23);
						}
						break;
					case 5:
						{
						_localctx = new BinaryTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(585);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(586);
						((BinaryTermContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_REF_EQUALS || _la==OP_REF_NOT_EQUALS) ) {
							((BinaryTermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(587);
						term(22);
						}
						break;
					case 6:
						{
						_localctx = new BinaryTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(588);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(589);
						((BinaryTermContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_EQUALS || _la==OP_NOT_EQUALS) ) {
							((BinaryTermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(590);
						term(21);
						}
						break;
					case 7:
						{
						_localctx = new BinaryTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(591);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(592);
						((BinaryTermContext)_localctx).op = match(OP_REGEX_MATCH);
						setState(593);
						term(20);
						}
						break;
					case 8:
						{
						_localctx = new BinaryTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(594);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(595);
						((BinaryTermContext)_localctx).op = match(OP_BIT_AND);
						setState(596);
						term(19);
						}
						break;
					case 9:
						{
						_localctx = new BinaryTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(597);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(598);
						((BinaryTermContext)_localctx).op = match(OP_BIT_XOR);
						setState(599);
						term(18);
						}
						break;
					case 10:
						{
						_localctx = new BinaryTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(600);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(601);
						((BinaryTermContext)_localctx).op = match(OP_BIT_OR);
						setState(602);
						term(17);
						}
						break;
					case 11:
						{
						_localctx = new BinaryTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(603);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(604);
						((BinaryTermContext)_localctx).op = match(OP_BOOLEAN_AND);
						setState(605);
						term(16);
						}
						break;
					case 12:
						{
						_localctx = new BinaryTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(606);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(607);
						((BinaryTermContext)_localctx).op = match(OP_BOOLEAN_OR);
						setState(608);
						term(15);
						}
						break;
					case 13:
						{
						_localctx = new BinaryTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(609);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(610);
						((BinaryTermContext)_localctx).op = match(OP_NULLOR);
						setState(611);
						term(14);
						}
						break;
					case 14:
						{
						_localctx = new AssignTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(612);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(613);
						((AssignTermContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_BIT_LEFT_SHIFT_ASSIGN || _la==OP_BIT_RIGHT_SHIFT_ASSIGN) ) {
							((AssignTermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(614);
						term(13);
						}
						break;
					case 15:
						{
						_localctx = new ConditionTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(615);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(616);
						match(OP_QUESTION);
						setState(617);
						term(0);
						setState(618);
						match(OP_COLON);
						setState(619);
						term(12);
						}
						break;
					case 16:
						{
						_localctx = new IsTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(621);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(622);
						match(T__46);
						setState(623);
						term(11);
						}
						break;
					case 17:
						{
						_localctx = new CastTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(624);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(625);
						match(T__47);
						setState(626);
						term(10);
						}
						break;
					case 18:
						{
						_localctx = new InTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(627);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(628);
						match(T__48);
						setState(629);
						term(9);
						}
						break;
					case 19:
						{
						_localctx = new AssignTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(630);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(631);
						((AssignTermContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (OP_MULTI_ASSIGN - 134)) | (1L << (OP_DIV_ASSIGN - 134)) | (1L << (OP_MODE_ASSIGN - 134)) | (1L << (OP_POWER_ASSIGN - 134)))) != 0)) ) {
							((AssignTermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(632);
						term(8);
						}
						break;
					case 20:
						{
						_localctx = new AssignTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(633);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(634);
						((AssignTermContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_PLUS_ASSIGN || _la==OP_MINUS_ASSIGN) ) {
							((AssignTermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(635);
						term(7);
						}
						break;
					case 21:
						{
						_localctx = new AssignTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(636);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(637);
						((AssignTermContext)_localctx).op = match(OP_BIT_AND_ASSIGN);
						setState(638);
						term(6);
						}
						break;
					case 22:
						{
						_localctx = new AssignTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(639);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(640);
						((AssignTermContext)_localctx).op = match(OP_BIT_XOR_ASSIGN);
						setState(641);
						term(5);
						}
						break;
					case 23:
						{
						_localctx = new AssignTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(642);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(643);
						((AssignTermContext)_localctx).op = match(OP_BIT_OR_ASSIGN);
						setState(644);
						term(4);
						}
						break;
					case 24:
						{
						_localctx = new AssignTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(645);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(646);
						((AssignTermContext)_localctx).op = match(OP_ASSIGN);
						setState(647);
						term(3);
						}
						break;
					case 25:
						{
						_localctx = new DotTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(648);
						if (!(precpred(_ctx, 54))) throw new FailedPredicateException(this, "precpred(_ctx, 54)");
						setState(649);
						((DotTermContext)_localctx).op = match(OP_DOT);
						setState(650);
						match(ID);
						}
						break;
					case 26:
						{
						_localctx = new DotClassTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(651);
						if (!(precpred(_ctx, 52))) throw new FailedPredicateException(this, "precpred(_ctx, 52)");
						setState(652);
						((DotClassTermContext)_localctx).op = match(OP_DOT);
						setState(653);
						match(T__1);
						}
						break;
					case 27:
						{
						_localctx = new InvokeTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(654);
						if (!(precpred(_ctx, 39))) throw new FailedPredicateException(this, "precpred(_ctx, 39)");
						setState(655);
						match(OP_PARENTHESIS_LEFT);
						setState(664);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__4) | (1L << T__13) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45))) != 0) || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (ID - 91)) | (1L << (OP_PLUSPLUS - 91)) | (1L << (OP_MINUSMINUS - 91)) | (1L << (OP_PLUS - 91)) | (1L << (OP_MINUS - 91)) | (1L << (OP_BIT_NOT - 91)) | (1L << (OP_BOOLEAN_NOT - 91)) | (1L << (OP_DOT - 91)) | (1L << (OP_PARENTHESIS_LEFT - 91)) | (1L << (OP_BRACKET_LEFT - 91)) | (1L << (OP_BRACE_LEFT - 91)) | (1L << (DATA_NUMBER - 91)) | (1L << (DATA_LONG - 91)) | (1L << (DATA_STRING - 91)) | (1L << (DATA_CHAR - 91)))) != 0)) {
							{
							setState(656);
							term(0);
							setState(661);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
							while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1+1 ) {
									{
									{
									setState(657);
									match(OP_COMMA);
									setState(658);
									term(0);
									}
									} 
								}
								setState(663);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
							}
							}
						}

						setState(666);
						match(OP_PARENTHESIS_RIGHT);
						}
						break;
					case 28:
						{
						_localctx = new InvokeTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(667);
						if (!(precpred(_ctx, 38))) throw new FailedPredicateException(this, "precpred(_ctx, 38)");
						setState(668);
						match(T__3);
						}
						break;
					case 29:
						{
						_localctx = new IndicesTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(669);
						if (!(precpred(_ctx, 37))) throw new FailedPredicateException(this, "precpred(_ctx, 37)");
						setState(670);
						match(OP_BRACKET_LEFT);
						setState(679);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__4) | (1L << T__13) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45))) != 0) || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (ID - 91)) | (1L << (OP_PLUSPLUS - 91)) | (1L << (OP_MINUSMINUS - 91)) | (1L << (OP_PLUS - 91)) | (1L << (OP_MINUS - 91)) | (1L << (OP_BIT_NOT - 91)) | (1L << (OP_BOOLEAN_NOT - 91)) | (1L << (OP_DOT - 91)) | (1L << (OP_PARENTHESIS_LEFT - 91)) | (1L << (OP_BRACKET_LEFT - 91)) | (1L << (OP_BRACE_LEFT - 91)) | (1L << (DATA_NUMBER - 91)) | (1L << (DATA_LONG - 91)) | (1L << (DATA_STRING - 91)) | (1L << (DATA_CHAR - 91)))) != 0)) {
							{
							setState(671);
							term(0);
							setState(676);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==OP_COMMA) {
								{
								{
								setState(672);
								match(OP_COMMA);
								setState(673);
								term(0);
								}
								}
								setState(678);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(681);
						match(OP_BRACKET_RIGHT);
						}
						break;
					case 30:
						{
						_localctx = new PostSelfUnaryTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(682);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(683);
						((PostSelfUnaryTermContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_PLUSPLUS || _la==OP_MINUSMINUS) ) {
							((PostSelfUnaryTermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(688);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class VariantNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public VariantNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variantName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterVariantName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitVariantName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitVariantName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariantNameContext variantName() throws RecognitionException {
		VariantNameContext _localctx = new VariantNameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_variantName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(689);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomicObjectContext extends ParserRuleContext {
		public Token sign;
		public Token v;
		public TerminalNode DATA_NUMBER() { return getToken(LangParser.DATA_NUMBER, 0); }
		public TerminalNode DATA_LONG() { return getToken(LangParser.DATA_LONG, 0); }
		public TerminalNode DATA_STRING() { return getToken(LangParser.DATA_STRING, 0); }
		public TerminalNode DATA_CHAR() { return getToken(LangParser.DATA_CHAR, 0); }
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public AtomicObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicObject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterAtomicObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitAtomicObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitAtomicObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomicObjectContext atomicObject() throws RecognitionException {
		AtomicObjectContext _localctx = new AtomicObjectContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_atomicObject);
		int _la;
		try {
			setState(699);
			switch (_input.LA(1)) {
			case OP_PLUS:
			case OP_MINUS:
			case DATA_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(692);
				_la = _input.LA(1);
				if (_la==OP_PLUS || _la==OP_MINUS) {
					{
					setState(691);
					((AtomicObjectContext)_localctx).sign = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==OP_PLUS || _la==OP_MINUS) ) {
						((AtomicObjectContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(694);
				((AtomicObjectContext)_localctx).v = match(DATA_NUMBER);
				}
				break;
			case DATA_LONG:
				enterOuterAlt(_localctx, 2);
				{
				setState(695);
				match(DATA_LONG);
				}
				break;
			case DATA_STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(696);
				match(DATA_STRING);
				}
				break;
			case DATA_CHAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(697);
				match(DATA_CHAR);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(698);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FullPathContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LangParser.ID, i);
		}
		public FullPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterFullPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitFullPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFullPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullPathContext fullPath() throws RecognitionException {
		FullPathContext _localctx = new FullPathContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fullPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(701);
			match(ID);
			setState(706);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_DOT) {
				{
				{
				setState(702);
				match(OP_DOT);
				setState(703);
				match(ID);
				}
				}
				setState(708);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KlassNameContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LangParser.ID, i);
		}
		public KlassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_klassName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterKlassName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitKlassName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitKlassName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KlassNameContext klassName() throws RecognitionException {
		KlassNameContext _localctx = new KlassNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_klassName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(709);
			match(ID);
			setState(714);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_DOT) {
				{
				{
				setState(710);
				match(OP_DOT);
				setState(711);
				match(ID);
				}
				}
				setState(716);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeyWordsContext extends ParserRuleContext {
		public KeyWordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyWords; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterKeyWords(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitKeyWords(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitKeyWords(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyWordsContext keyWords() throws RecognitionException {
		KeyWordsContext _localctx = new KeyWordsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_keyWords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(717);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__69 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__73 - 64)) | (1L << (T__74 - 64)) | (1L << (T__75 - 64)) | (1L << (T__76 - 64)) | (1L << (T__77 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__81 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorsContext extends ParserRuleContext {
		public TerminalNode OP_PLUSPLUS() { return getToken(LangParser.OP_PLUSPLUS, 0); }
		public TerminalNode OP_MINUSMINUS() { return getToken(LangParser.OP_MINUSMINUS, 0); }
		public TerminalNode OP_PLUS() { return getToken(LangParser.OP_PLUS, 0); }
		public TerminalNode OP_MINUS() { return getToken(LangParser.OP_MINUS, 0); }
		public TerminalNode OP_POWER() { return getToken(LangParser.OP_POWER, 0); }
		public TerminalNode OP_MULTIPLY() { return getToken(LangParser.OP_MULTIPLY, 0); }
		public TerminalNode OP_DIVIDE() { return getToken(LangParser.OP_DIVIDE, 0); }
		public TerminalNode OP_MODE() { return getToken(LangParser.OP_MODE, 0); }
		public TerminalNode OP_BIT_NOT() { return getToken(LangParser.OP_BIT_NOT, 0); }
		public TerminalNode OP_BIT_AND() { return getToken(LangParser.OP_BIT_AND, 0); }
		public TerminalNode OP_BIT_OR() { return getToken(LangParser.OP_BIT_OR, 0); }
		public TerminalNode OP_BIT_XOR() { return getToken(LangParser.OP_BIT_XOR, 0); }
		public TerminalNode OP_BIT_LEFT_SHIFT() { return getToken(LangParser.OP_BIT_LEFT_SHIFT, 0); }
		public TerminalNode OP_BIT_RIGHT_SHIFT() { return getToken(LangParser.OP_BIT_RIGHT_SHIFT, 0); }
		public TerminalNode OP_BIT_RIGHT_ROTATE() { return getToken(LangParser.OP_BIT_RIGHT_ROTATE, 0); }
		public TerminalNode OP_BOOLEAN_NOT() { return getToken(LangParser.OP_BOOLEAN_NOT, 0); }
		public TerminalNode OP_BOOLEAN_AND() { return getToken(LangParser.OP_BOOLEAN_AND, 0); }
		public TerminalNode OP_BOOLEAN_OR() { return getToken(LangParser.OP_BOOLEAN_OR, 0); }
		public TerminalNode OP_REF_EQUALS() { return getToken(LangParser.OP_REF_EQUALS, 0); }
		public TerminalNode OP_REF_NOT_EQUALS() { return getToken(LangParser.OP_REF_NOT_EQUALS, 0); }
		public TerminalNode OP_REGEX_MATCH() { return getToken(LangParser.OP_REGEX_MATCH, 0); }
		public TerminalNode OP_EQUALS() { return getToken(LangParser.OP_EQUALS, 0); }
		public TerminalNode OP_NOT_EQUALS() { return getToken(LangParser.OP_NOT_EQUALS, 0); }
		public TerminalNode OP_GREATER_THAN() { return getToken(LangParser.OP_GREATER_THAN, 0); }
		public TerminalNode OP_GREATER_EQAULS() { return getToken(LangParser.OP_GREATER_EQAULS, 0); }
		public TerminalNode OP_LESS_THAN() { return getToken(LangParser.OP_LESS_THAN, 0); }
		public TerminalNode OP_LESS_EQUALS() { return getToken(LangParser.OP_LESS_EQUALS, 0); }
		public TerminalNode OP_NULLOR() { return getToken(LangParser.OP_NULLOR, 0); }
		public TerminalNode OP_DOT() { return getToken(LangParser.OP_DOT, 0); }
		public TerminalNode OP_COMMA() { return getToken(LangParser.OP_COMMA, 0); }
		public TerminalNode OP_QUESTION() { return getToken(LangParser.OP_QUESTION, 0); }
		public TerminalNode OP_COLON() { return getToken(LangParser.OP_COLON, 0); }
		public TerminalNode OP_PARENTHESIS_LEFT() { return getToken(LangParser.OP_PARENTHESIS_LEFT, 0); }
		public TerminalNode OP_PARENTHESIS_RIGHT() { return getToken(LangParser.OP_PARENTHESIS_RIGHT, 0); }
		public TerminalNode OP_BRACKET_LEFT() { return getToken(LangParser.OP_BRACKET_LEFT, 0); }
		public TerminalNode OP_BRACKET_RIGHT() { return getToken(LangParser.OP_BRACKET_RIGHT, 0); }
		public TerminalNode OP_BRACE_LEFT() { return getToken(LangParser.OP_BRACE_LEFT, 0); }
		public TerminalNode OP_BRACE_RIGHT() { return getToken(LangParser.OP_BRACE_RIGHT, 0); }
		public TerminalNode OP_SEMICOLON() { return getToken(LangParser.OP_SEMICOLON, 0); }
		public TerminalNode OP_ASSIGN() { return getToken(LangParser.OP_ASSIGN, 0); }
		public TerminalNode OP_PLUS_ASSIGN() { return getToken(LangParser.OP_PLUS_ASSIGN, 0); }
		public TerminalNode OP_MINUS_ASSIGN() { return getToken(LangParser.OP_MINUS_ASSIGN, 0); }
		public TerminalNode OP_MULTI_ASSIGN() { return getToken(LangParser.OP_MULTI_ASSIGN, 0); }
		public TerminalNode OP_DIV_ASSIGN() { return getToken(LangParser.OP_DIV_ASSIGN, 0); }
		public TerminalNode OP_MODE_ASSIGN() { return getToken(LangParser.OP_MODE_ASSIGN, 0); }
		public TerminalNode OP_POWER_ASSIGN() { return getToken(LangParser.OP_POWER_ASSIGN, 0); }
		public TerminalNode OP_BIT_AND_ASSIGN() { return getToken(LangParser.OP_BIT_AND_ASSIGN, 0); }
		public TerminalNode OP_BIT_OR_ASSIGN() { return getToken(LangParser.OP_BIT_OR_ASSIGN, 0); }
		public TerminalNode OP_BIT_XOR_ASSIGN() { return getToken(LangParser.OP_BIT_XOR_ASSIGN, 0); }
		public TerminalNode OP_BIT_LEFT_SHIFT_ASSIGN() { return getToken(LangParser.OP_BIT_LEFT_SHIFT_ASSIGN, 0); }
		public TerminalNode OP_BIT_RIGHT_SHIFT_ASSIGN() { return getToken(LangParser.OP_BIT_RIGHT_SHIFT_ASSIGN, 0); }
		public TerminalNode OP_BIT_RIGHT_ROTATE_ASSIGN() { return getToken(LangParser.OP_BIT_RIGHT_ROTATE_ASSIGN, 0); }
		public OperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterOperators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitOperators(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitOperators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorsContext operators() throws RecognitionException {
		OperatorsContext _localctx = new OperatorsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_operators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(719);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__45 || ((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (OP_PLUSPLUS - 92)) | (1L << (OP_MINUSMINUS - 92)) | (1L << (OP_PLUS - 92)) | (1L << (OP_MINUS - 92)) | (1L << (OP_POWER - 92)) | (1L << (OP_MULTIPLY - 92)) | (1L << (OP_DIVIDE - 92)) | (1L << (OP_MODE - 92)) | (1L << (OP_BIT_NOT - 92)) | (1L << (OP_BIT_AND - 92)) | (1L << (OP_BIT_OR - 92)) | (1L << (OP_BIT_XOR - 92)) | (1L << (OP_BIT_LEFT_SHIFT - 92)) | (1L << (OP_BIT_RIGHT_SHIFT - 92)) | (1L << (OP_BIT_RIGHT_ROTATE - 92)) | (1L << (OP_BOOLEAN_NOT - 92)) | (1L << (OP_BOOLEAN_AND - 92)) | (1L << (OP_BOOLEAN_OR - 92)) | (1L << (OP_REF_EQUALS - 92)) | (1L << (OP_REF_NOT_EQUALS - 92)) | (1L << (OP_REGEX_MATCH - 92)) | (1L << (OP_EQUALS - 92)) | (1L << (OP_NOT_EQUALS - 92)) | (1L << (OP_GREATER_THAN - 92)) | (1L << (OP_GREATER_EQAULS - 92)) | (1L << (OP_LESS_THAN - 92)) | (1L << (OP_LESS_EQUALS - 92)) | (1L << (OP_NULLOR - 92)) | (1L << (OP_DOT - 92)) | (1L << (OP_COMMA - 92)) | (1L << (OP_QUESTION - 92)) | (1L << (OP_COLON - 92)) | (1L << (OP_PARENTHESIS_LEFT - 92)) | (1L << (OP_PARENTHESIS_RIGHT - 92)) | (1L << (OP_BRACKET_LEFT - 92)) | (1L << (OP_BRACKET_RIGHT - 92)) | (1L << (OP_BRACE_LEFT - 92)) | (1L << (OP_BRACE_RIGHT - 92)) | (1L << (OP_SEMICOLON - 92)) | (1L << (OP_ASSIGN - 92)) | (1L << (OP_PLUS_ASSIGN - 92)) | (1L << (OP_MINUS_ASSIGN - 92)) | (1L << (OP_MULTI_ASSIGN - 92)) | (1L << (OP_DIV_ASSIGN - 92)) | (1L << (OP_MODE_ASSIGN - 92)) | (1L << (OP_POWER_ASSIGN - 92)) | (1L << (OP_BIT_AND_ASSIGN - 92)) | (1L << (OP_BIT_OR_ASSIGN - 92)) | (1L << (OP_BIT_XOR_ASSIGN - 92)) | (1L << (OP_BIT_LEFT_SHIFT_ASSIGN - 92)) | (1L << (OP_BIT_RIGHT_SHIFT_ASSIGN - 92)) | (1L << (OP_BIT_RIGHT_ROTATE_ASSIGN - 92)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 25);
		case 1:
			return precpred(_ctx, 24);
		case 2:
			return precpred(_ctx, 23);
		case 3:
			return precpred(_ctx, 22);
		case 4:
			return precpred(_ctx, 21);
		case 5:
			return precpred(_ctx, 20);
		case 6:
			return precpred(_ctx, 19);
		case 7:
			return precpred(_ctx, 18);
		case 8:
			return precpred(_ctx, 17);
		case 9:
			return precpred(_ctx, 16);
		case 10:
			return precpred(_ctx, 15);
		case 11:
			return precpred(_ctx, 14);
		case 12:
			return precpred(_ctx, 13);
		case 13:
			return precpred(_ctx, 12);
		case 14:
			return precpred(_ctx, 11);
		case 15:
			return precpred(_ctx, 10);
		case 16:
			return precpred(_ctx, 9);
		case 17:
			return precpred(_ctx, 8);
		case 18:
			return precpred(_ctx, 7);
		case 19:
			return precpred(_ctx, 6);
		case 20:
			return precpred(_ctx, 5);
		case 21:
			return precpred(_ctx, 4);
		case 22:
			return precpred(_ctx, 3);
		case 23:
			return precpred(_ctx, 2);
		case 24:
			return precpred(_ctx, 54);
		case 25:
			return precpred(_ctx, 52);
		case 26:
			return precpred(_ctx, 39);
		case 27:
			return precpred(_ctx, 38);
		case 28:
			return precpred(_ctx, 37);
		case 29:
			return precpred(_ctx, 26);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0099\u02d4\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\6"+
		"\2%\n\2\r\2\16\2&\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4\64\n"+
		"\4\r\4\16\4\65\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5@\n\5\f\5\16\5C\13\5"+
		"\5\5E\n\5\3\5\3\5\3\5\3\5\7\5K\n\5\f\5\16\5N\13\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\7\6W\n\6\f\6\16\6Z\13\6\3\6\3\6\5\6^\n\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\7\6f\n\6\f\6\16\6i\13\6\3\6\3\6\3\6\3\6\7\6o\n\6\f\6\16\6r\13\6\5"+
		"\6t\n\6\3\6\3\6\3\6\7\6y\n\6\f\6\16\6|\13\6\3\6\3\6\5\6\u0080\n\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u008c\n\6\f\6\16\6\u008f\13\6"+
		"\5\6\u0091\n\6\3\6\3\6\3\6\7\6\u0096\n\6\f\6\16\6\u0099\13\6\3\6\3\6\5"+
		"\6\u009d\n\6\5\6\u009f\n\6\3\7\3\7\3\7\3\7\3\7\7\7\u00a6\n\7\f\7\16\7"+
		"\u00a9\13\7\3\7\3\7\5\7\u00ad\n\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00b5\n"+
		"\7\f\7\16\7\u00b8\13\7\3\7\3\7\3\7\3\7\7\7\u00be\n\7\f\7\16\7\u00c1\13"+
		"\7\5\7\u00c3\n\7\3\7\3\7\3\7\7\7\u00c8\n\7\f\7\16\7\u00cb\13\7\3\7\3\7"+
		"\5\7\u00cf\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00db\n\7\f"+
		"\7\16\7\u00de\13\7\5\7\u00e0\n\7\3\7\3\7\3\7\7\7\u00e5\n\7\f\7\16\7\u00e8"+
		"\13\7\3\7\3\7\5\7\u00ec\n\7\5\7\u00ee\n\7\3\b\3\b\7\b\u00f2\n\b\f\b\16"+
		"\b\u00f5\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0100\n\b\3\b\3"+
		"\b\5\b\u0104\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0110\n\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u011a\n\b\3\b\3\b\3\b\5\b\u011f\n"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0129\n\b\3\b\3\b\3\b\5\b\u012e"+
		"\n\b\3\b\5\b\u0131\n\b\3\b\3\b\5\b\u0135\n\b\3\b\3\b\5\b\u0139\n\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0145\n\b\f\b\16\b\u0148\13\b"+
		"\3\b\3\b\3\b\5\b\u014d\n\b\3\b\3\b\3\b\3\b\3\b\7\b\u0154\n\b\f\b\16\b"+
		"\u0157\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0160\n\b\f\b\16\b\u0163\13"+
		"\b\3\b\5\b\u0166\n\b\3\b\3\b\3\b\7\b\u016b\n\b\f\b\16\b\u016e\13\b\3\b"+
		"\5\b\u0171\n\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0179\n\b\3\t\3\t\3\t\3\t\3"+
		"\t\5\t\u0180\n\t\3\t\3\t\3\t\3\t\5\t\u0186\n\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u019d"+
		"\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u01a7\n\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7"+
		"\n\u01bf\n\n\f\n\16\n\u01c2\13\n\5\n\u01c4\n\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\7\n\u01d0\n\n\f\n\16\n\u01d3\13\n\5\n\u01d5\n\n\3\n\3"+
		"\n\3\n\3\n\5\n\u01db\n\n\3\n\3\n\3\n\3\n\5\n\u01e1\n\n\3\n\3\n\3\n\3\n"+
		"\3\n\5\n\u01e8\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u01f1\n\n\f\n\16\n"+
		"\u01f4\13\n\5\n\u01f6\n\n\3\n\3\n\3\n\3\n\5\n\u01fc\n\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\5\n\u0205\n\n\3\n\3\n\3\n\3\n\7\n\u020b\n\n\f\n\16\n\u020e"+
		"\13\n\5\n\u0210\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u021d"+
		"\n\n\f\n\16\n\u0220\13\n\5\n\u0222\n\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u022a"+
		"\n\n\f\n\16\n\u022d\13\n\5\n\u022f\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\5\n\u023e\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0296\n\n\f\n\16\n\u0299\13\n\5\n\u029b"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u02a5\n\n\f\n\16\n\u02a8\13\n"+
		"\5\n\u02aa\n\n\3\n\3\n\3\n\7\n\u02af\n\n\f\n\16\n\u02b2\13\n\3\13\3\13"+
		"\3\f\5\f\u02b7\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u02be\n\f\3\r\3\r\3\r\7\r\u02c3"+
		"\n\r\f\r\16\r\u02c6\13\r\3\16\3\16\3\16\7\16\u02cb\n\16\f\16\16\16\u02ce"+
		"\13\16\3\17\3\17\3\20\3\20\3\20\27ALXgpz\u008d\u0097\u00a7\u00b6\u00bf"+
		"\u00c9\u00dc\u00e6\u0146\u0155\u0161\u016c\u01d1\u01f2\u0297\3\22\21\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\21\4\2\4\4\33\37\3\2 \"\3\2#-"+
		"\3\2^_\3\2be\3\2`a\3\2jl\3\2ux\3\2pq\3\2st\3\2\u008f\u0090\3\2\u0088\u008b"+
		"\3\2\u0086\u0087\5\2\3\5\b.\61\\\5\2\6\6\60\60^\u0091\u0364\2$\3\2\2\2"+
		"\4(\3\2\2\2\6+\3\2\2\2\b9\3\2\2\2\n\u009e\3\2\2\2\f\u00ed\3\2\2\2\16\u0178"+
		"\3\2\2\2\20\u01a6\3\2\2\2\22\u023d\3\2\2\2\24\u02b3\3\2\2\2\26\u02bd\3"+
		"\2\2\2\30\u02bf\3\2\2\2\32\u02c7\3\2\2\2\34\u02cf\3\2\2\2\36\u02d1\3\2"+
		"\2\2 %\5\16\b\2!%\5\f\7\2\"%\5\b\5\2#%\5\6\4\2$ \3\2\2\2$!\3\2\2\2$\""+
		"\3\2\2\2$#\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\3\3\2\2\2()\5\2\2"+
		"\2)*\7\2\2\3*\5\3\2\2\2+,\7\3\2\2,-\5\32\16\2-\63\7\u0082\2\2.\64\5\16"+
		"\b\2/\64\5\n\6\2\60\64\5\f\7\2\61\64\5\b\5\2\62\64\5\6\4\2\63.\3\2\2\2"+
		"\63/\3\2\2\2\63\60\3\2\2\2\63\61\3\2\2\2\63\62\3\2\2\2\64\65\3\2\2\2\65"+
		"\63\3\2\2\2\65\66\3\2\2\2\66\67\3\2\2\2\678\7\u0083\2\28\7\3\2\2\29:\7"+
		"\4\2\2:D\7]\2\2;<\7}\2\2<A\5\32\16\2=>\7{\2\2>@\5\32\16\2?=\3\2\2\2@C"+
		"\3\2\2\2AB\3\2\2\2A?\3\2\2\2BE\3\2\2\2CA\3\2\2\2D;\3\2\2\2DE\3\2\2\2E"+
		"F\3\2\2\2FL\7\u0082\2\2GK\5\16\b\2HK\5\f\7\2IK\5\n\6\2JG\3\2\2\2JH\3\2"+
		"\2\2JI\3\2\2\2KN\3\2\2\2LM\3\2\2\2LJ\3\2\2\2MO\3\2\2\2NL\3\2\2\2OP\7\u0083"+
		"\2\2P\t\3\2\2\2QR\7\5\2\2RS\5\36\20\2S]\7\6\2\2TX\7\u0082\2\2UW\5\16\b"+
		"\2VU\3\2\2\2WZ\3\2\2\2XY\3\2\2\2XV\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[^\7\u0083"+
		"\2\2\\^\7\7\2\2]T\3\2\2\2]\\\3\2\2\2^\u009f\3\2\2\2_`\7\5\2\2`a\5\36\20"+
		"\2as\7~\2\2bg\7]\2\2cd\7{\2\2df\7]\2\2ec\3\2\2\2fi\3\2\2\2gh\3\2\2\2g"+
		"e\3\2\2\2hp\3\2\2\2ig\3\2\2\2jk\7{\2\2kl\7]\2\2lm\7\u0085\2\2mo\5\26\f"+
		"\2nj\3\2\2\2or\3\2\2\2pq\3\2\2\2pn\3\2\2\2qt\3\2\2\2rp\3\2\2\2sb\3\2\2"+
		"\2st\3\2\2\2tu\3\2\2\2u\177\7\177\2\2vz\7\u0082\2\2wy\5\16\b\2xw\3\2\2"+
		"\2y|\3\2\2\2z{\3\2\2\2zx\3\2\2\2{}\3\2\2\2|z\3\2\2\2}\u0080\7\u0083\2"+
		"\2~\u0080\7\7\2\2\177v\3\2\2\2\177~\3\2\2\2\u0080\u009f\3\2\2\2\u0081"+
		"\u0082\7\5\2\2\u0082\u0083\5\36\20\2\u0083\u0090\7~\2\2\u0084\u0085\7"+
		"]\2\2\u0085\u0086\7\u0085\2\2\u0086\u008d\5\26\f\2\u0087\u0088\7{\2\2"+
		"\u0088\u0089\7]\2\2\u0089\u008a\7\u0085\2\2\u008a\u008c\5\26\f\2\u008b"+
		"\u0087\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008e\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0084\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u009c\7\177\2\2\u0093\u0097\7"+
		"\u0082\2\2\u0094\u0096\5\16\b\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2"+
		"\2\u0097\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097"+
		"\3\2\2\2\u009a\u009d\7\u0083\2\2\u009b\u009d\7\7\2\2\u009c\u0093\3\2\2"+
		"\2\u009c\u009b\3\2\2\2\u009d\u009f\3\2\2\2\u009eQ\3\2\2\2\u009e_\3\2\2"+
		"\2\u009e\u0081\3\2\2\2\u009f\13\3\2\2\2\u00a0\u00a1\7\5\2\2\u00a1\u00a2"+
		"\7]\2\2\u00a2\u00ac\7\6\2\2\u00a3\u00a7\7\u0082\2\2\u00a4\u00a6\5\16\b"+
		"\2\u00a5\u00a4\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a7\u00a5"+
		"\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ad\7\u0083\2"+
		"\2\u00ab\u00ad\7\7\2\2\u00ac\u00a3\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ee"+
		"\3\2\2\2\u00ae\u00af\7\5\2\2\u00af\u00b0\7]\2\2\u00b0\u00c2\7~\2\2\u00b1"+
		"\u00b6\7]\2\2\u00b2\u00b3\7{\2\2\u00b3\u00b5\7]\2\2\u00b4\u00b2\3\2\2"+
		"\2\u00b5\u00b8\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00bf"+
		"\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7{\2\2\u00ba\u00bb\7]\2\2\u00bb"+
		"\u00bc\7\u0085\2\2\u00bc\u00be\5\26\f\2\u00bd\u00b9\3\2\2\2\u00be\u00c1"+
		"\3\2\2\2\u00bf\u00c0\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c2\u00b1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2"+
		"\2\2\u00c4\u00ce\7\177\2\2\u00c5\u00c9\7\u0082\2\2\u00c6\u00c8\5\16\b"+
		"\2\u00c7\u00c6\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00ca\3\2\2\2\u00c9\u00c7"+
		"\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cf\7\u0083\2"+
		"\2\u00cd\u00cf\7\7\2\2\u00ce\u00c5\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00ee"+
		"\3\2\2\2\u00d0\u00d1\7\5\2\2\u00d1\u00d2\7]\2\2\u00d2\u00df\7~\2\2\u00d3"+
		"\u00d4\7]\2\2\u00d4\u00d5\7\u0085\2\2\u00d5\u00dc\5\26\f\2\u00d6\u00d7"+
		"\7{\2\2\u00d7\u00d8\7]\2\2\u00d8\u00d9\7\u0085\2\2\u00d9\u00db\5\26\f"+
		"\2\u00da\u00d6\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dc\u00da"+
		"\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00d3\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00eb\7\177\2\2\u00e2\u00e6\7"+
		"\u0082\2\2\u00e3\u00e5\5\16\b\2\u00e4\u00e3\3\2\2\2\u00e5\u00e8\3\2\2"+
		"\2\u00e6\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8\u00e6"+
		"\3\2\2\2\u00e9\u00ec\7\u0083\2\2\u00ea\u00ec\7\7\2\2\u00eb\u00e2\3\2\2"+
		"\2\u00eb\u00ea\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00a0\3\2\2\2\u00ed\u00ae"+
		"\3\2\2\2\u00ed\u00d0\3\2\2\2\u00ee\r\3\2\2\2\u00ef\u00f3\7\u0082\2\2\u00f0"+
		"\u00f2\5\16\b\2\u00f1\u00f0\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3"+
		"\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6"+
		"\u0179\7\u0083\2\2\u00f7\u0179\5\20\t\2\u00f8\u00f9\7\b\2\2\u00f9\u00fa"+
		"\7~\2\2\u00fa\u00fb\5\22\n\2\u00fb\u00fc\7\177\2\2\u00fc\u00ff\5\16\b"+
		"\2\u00fd\u00fe\7\t\2\2\u00fe\u0100\5\16\b\2\u00ff\u00fd\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0179\3\2\2\2\u0101\u0102\7]\2\2\u0102\u0104\7}\2"+
		"\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106"+
		"\7\n\2\2\u0106\u0107\5\16\b\2\u0107\u0108\7\13\2\2\u0108\u0109\7~\2\2"+
		"\u0109\u010a\5\22\n\2\u010a\u010b\7\177\2\2\u010b\u010c\7\u0084\2\2\u010c"+
		"\u0179\3\2\2\2\u010d\u010e\7]\2\2\u010e\u0110\7}\2\2\u010f\u010d\3\2\2"+
		"\2\u010f\u0110\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112\7\13\2\2\u0112"+
		"\u0113\7~\2\2\u0113\u0114\5\22\n\2\u0114\u0115\7\177\2\2\u0115\u0116\5"+
		"\16\b\2\u0116\u0179\3\2\2\2\u0117\u0118\7]\2\2\u0118\u011a\7}\2\2\u0119"+
		"\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\7\f"+
		"\2\2\u011c\u011e\7~\2\2\u011d\u011f\7\r\2\2\u011e\u011d\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\7]\2\2\u0121\u0122\7}\2"+
		"\2\u0122\u0123\5\22\n\2\u0123\u0124\7\177\2\2\u0124\u0125\5\16\b\2\u0125"+
		"\u0179\3\2\2\2\u0126\u0127\7]\2\2\u0127\u0129\7}\2\2\u0128\u0126\3\2\2"+
		"\2\u0128\u0129\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\7\f\2\2\u012b\u0130"+
		"\7~\2\2\u012c\u012e\7\r\2\2\u012d\u012c\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"\u012f\3\2\2\2\u012f\u0131\5\22\n\2\u0130\u012d\3\2\2\2\u0130\u0131\3"+
		"\2\2\2\u0131\u0132\3\2\2\2\u0132\u0134\7\u0084\2\2\u0133\u0135\5\22\n"+
		"\2\u0134\u0133\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0138"+
		"\7\u0084\2\2\u0137\u0139\5\22\n\2\u0138\u0137\3\2\2\2\u0138\u0139\3\2"+
		"\2\2\u0139\u013a\3\2\2\2\u013a\u013b\7\177\2\2\u013b\u0179\5\16\b\2\u013c"+
		"\u013d\7\16\2\2\u013d\u013e\5\22\n\2\u013e\u0146\7\u0082\2\2\u013f\u0140"+
		"\7\17\2\2\u0140\u0141\5\22\n\2\u0141\u0142\7}\2\2\u0142\u0143\5\16\b\2"+
		"\u0143\u0145\3\2\2\2\u0144\u013f\3\2\2\2\u0145\u0148\3\2\2\2\u0146\u0147"+
		"\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u014c\3\2\2\2\u0148\u0146\3\2\2\2\u0149"+
		"\u014a\7\20\2\2\u014a\u014b\7}\2\2\u014b\u014d\5\16\b\2\u014c\u0149\3"+
		"\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f\7\u0083\2\2"+
		"\u014f\u0179\3\2\2\2\u0150\u0151\7\21\2\2\u0151\u0155\7\u0082\2\2\u0152"+
		"\u0154\5\16\b\2\u0153\u0152\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0156\3"+
		"\2\2\2\u0155\u0153\3\2\2\2\u0156\u0158\3\2\2\2\u0157\u0155\3\2\2\2\u0158"+
		"\u0165\7\u0083\2\2\u0159\u015a\7\22\2\2\u015a\u015b\7~\2\2\u015b\u015c"+
		"\7]\2\2\u015c\u015d\7\177\2\2\u015d\u0161\7\u0082\2\2\u015e\u0160\5\16"+
		"\b\2\u015f\u015e\3\2\2\2\u0160\u0163\3\2\2\2\u0161\u0162\3\2\2\2\u0161"+
		"\u015f\3\2\2\2\u0162\u0164\3\2\2\2\u0163\u0161\3\2\2\2\u0164\u0166\7\u0083"+
		"\2\2\u0165\u0159\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0170\3\2\2\2\u0167"+
		"\u0168\7\23\2\2\u0168\u016c\7\u0082\2\2\u0169\u016b\5\16\b\2\u016a\u0169"+
		"\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016d\3\2\2\2\u016c\u016a\3\2\2\2\u016d"+
		"\u016f\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0171\7\u0083\2\2\u0170\u0167"+
		"\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0179\3\2\2\2\u0172\u0173\7\24\2\2"+
		"\u0173\u0174\7~\2\2\u0174\u0175\5\22\n\2\u0175\u0176\7\177\2\2\u0176\u0177"+
		"\5\16\b\2\u0177\u0179\3\2\2\2\u0178\u00ef\3\2\2\2\u0178\u00f7\3\2\2\2"+
		"\u0178\u00f8\3\2\2\2\u0178\u0103\3\2\2\2\u0178\u010f\3\2\2\2\u0178\u0119"+
		"\3\2\2\2\u0178\u0128\3\2\2\2\u0178\u013c\3\2\2\2\u0178\u0150\3\2\2\2\u0178"+
		"\u0172\3\2\2\2\u0179\17\3\2\2\2\u017a\u01a7\7\u0084\2\2\u017b\u017c\7"+
		"\r\2\2\u017c\u017f\5\24\13\2\u017d\u017e\7\u0085\2\2\u017e\u0180\5\22"+
		"\n\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0181\3\2\2\2\u0181"+
		"\u0182\7\u0084\2\2\u0182\u01a7\3\2\2\2\u0183\u0185\7\25\2\2\u0184\u0186"+
		"\5\22\n\2\u0185\u0184\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187\3\2\2\2"+
		"\u0187\u01a7\7\u0084\2\2\u0188\u0189\7\25\2\2\u0189\u018a\7~\2\2\u018a"+
		"\u018b\5\22\n\2\u018b\u018c\7\177\2\2\u018c\u018d\7\u0084\2\2\u018d\u01a7"+
		"\3\2\2\2\u018e\u018f\7\26\2\2\u018f\u0190\5\22\n\2\u0190\u0191\7\u0084"+
		"\2\2\u0191\u01a7\3\2\2\2\u0192\u0193\7\26\2\2\u0193\u0194\7~\2\2\u0194"+
		"\u0195\5\22\n\2\u0195\u0196\7\177\2\2\u0196\u0197\7\u0084\2\2\u0197\u01a7"+
		"\3\2\2\2\u0198\u0199\7\27\2\2\u0199\u01a7\7\u0084\2\2\u019a\u019c\7\30"+
		"\2\2\u019b\u019d\7]\2\2\u019c\u019b\3\2\2\2\u019c\u019d\3\2\2\2\u019d"+
		"\u019e\3\2\2\2\u019e\u01a7\7\u0084\2\2\u019f\u01a0\7\31\2\2\u01a0\u01a1"+
		"\5\22\n\2\u01a1\u01a2\7\u0084\2\2\u01a2\u01a7\3\2\2\2\u01a3\u01a4\5\22"+
		"\n\2\u01a4\u01a5\7\u0084\2\2\u01a5\u01a7\3\2\2\2\u01a6\u017a\3\2\2\2\u01a6"+
		"\u017b\3\2\2\2\u01a6\u0183\3\2\2\2\u01a6\u0188\3\2\2\2\u01a6\u018e\3\2"+
		"\2\2\u01a6\u0192\3\2\2\2\u01a6\u0198\3\2\2\2\u01a6\u019a\3\2\2\2\u01a6"+
		"\u019f\3\2\2\2\u01a6\u01a3\3\2\2\2\u01a7\21\3\2\2\2\u01a8\u01a9\b\n\1"+
		"\2\u01a9\u01aa\7z\2\2\u01aa\u023e\7]\2\2\u01ab\u01ac\7\32\2\2\u01ac\u01ad"+
		"\7~\2\2\u01ad\u01ae\5\30\r\2\u01ae\u01af\7\177\2\2\u01af\u023e\3\2\2\2"+
		"\u01b0\u01b1\7\20\2\2\u01b1\u01b2\7~\2\2\u01b2\u01b3\5\22\n\2\u01b3\u01b4"+
		"\7\177\2\2\u01b4\u023e\3\2\2\2\u01b5\u023e\t\2\2\2\u01b6\u023e\t\3\2\2"+
		"\u01b7\u023e\t\4\2\2\u01b8\u01b9\7.\2\2\u01b9\u01ba\5\32\16\2\u01ba\u01c3"+
		"\7~\2\2\u01bb\u01c0\5\22\n\2\u01bc\u01bd\7{\2\2\u01bd\u01bf\5\22\n\2\u01be"+
		"\u01bc\3\2\2\2\u01bf\u01c2\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2"+
		"\2\2\u01c1\u01c4\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c3\u01bb\3\2\2\2\u01c3"+
		"\u01c4\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c6\7\177\2\2\u01c6\u023e\3"+
		"\2\2\2\u01c7\u01c8\7.\2\2\u01c8\u01c9\5\32\16\2\u01c9\u01ca\7\6\2\2\u01ca"+
		"\u023e\3\2\2\2\u01cb\u01d4\7~\2\2\u01cc\u01d1\7]\2\2\u01cd\u01ce\7{\2"+
		"\2\u01ce\u01d0\7]\2\2\u01cf\u01cd\3\2\2\2\u01d0\u01d3\3\2\2\2\u01d1\u01d2"+
		"\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d2\u01d5\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d4"+
		"\u01cc\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d7\7\177"+
		"\2\2\u01d7\u01da\7/\2\2\u01d8\u01db\5\16\b\2\u01d9\u01db\5\22\n\2\u01da"+
		"\u01d8\3\2\2\2\u01da\u01d9\3\2\2\2\u01db\u023e\3\2\2\2\u01dc\u01dd\7\6"+
		"\2\2\u01dd\u01e0\7/\2\2\u01de\u01e1\5\16\b\2\u01df\u01e1\5\22\n\2\u01e0"+
		"\u01de\3\2\2\2\u01e0\u01df\3\2\2\2\u01e1\u023e\3\2\2\2\u01e2\u01e3\7\60"+
		"\2\2\u01e3\u01e4\7\6\2\2\u01e4\u01e7\7/\2\2\u01e5\u01e8\5\16\b\2\u01e6"+
		"\u01e8\5\22\n\2\u01e7\u01e5\3\2\2\2\u01e7\u01e6\3\2\2\2\u01e8\u023e\3"+
		"\2\2\2\u01e9\u01ea\7\u0080\2\2\u01ea\u01eb\5\22\n\2\u01eb\u01ec\7\u0081"+
		"\2\2\u01ec\u01f5\7~\2\2\u01ed\u01f2\7]\2\2\u01ee\u01ef\7{\2\2\u01ef\u01f1"+
		"\7]\2\2\u01f0\u01ee\3\2\2\2\u01f1\u01f4\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f2"+
		"\u01f0\3\2\2\2\u01f3\u01f6\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f5\u01ed\3\2"+
		"\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f8\7\177\2\2\u01f8"+
		"\u01fb\7/\2\2\u01f9\u01fc\5\16\b\2\u01fa\u01fc\5\22\n\2\u01fb\u01f9\3"+
		"\2\2\2\u01fb\u01fa\3\2\2\2\u01fc\u023e\3\2\2\2\u01fd\u01fe\7\u0080\2\2"+
		"\u01fe\u01ff\5\22\n\2\u01ff\u0200\7\u0081\2\2\u0200\u0201\7\6\2\2\u0201"+
		"\u0204\7/\2\2\u0202\u0205\5\16\b\2\u0203\u0205\5\22\n\2\u0204\u0202\3"+
		"\2\2\2\u0204\u0203\3\2\2\2\u0205\u023e\3\2\2\2\u0206\u020f\7~\2\2\u0207"+
		"\u020c\5\22\n\2\u0208\u0209\7{\2\2\u0209\u020b\5\22\n\2\u020a\u0208\3"+
		"\2\2\2\u020b\u020e\3\2\2\2\u020c\u020a\3\2\2\2\u020c\u020d\3\2\2\2\u020d"+
		"\u0210\3\2\2\2\u020e\u020c\3\2\2\2\u020f\u0207\3\2\2\2\u020f\u0210\3\2"+
		"\2\2\u0210\u0211\3\2\2\2\u0211\u023e\7\177\2\2\u0212\u0221\7\u0082\2\2"+
		"\u0213\u0214\5\22\n\2\u0214\u0215\7}\2\2\u0215\u0216\5\22\n\2\u0216\u021e"+
		"\3\2\2\2\u0217\u0218\7{\2\2\u0218\u0219\5\22\n\2\u0219\u021a\7}\2\2\u021a"+
		"\u021b\5\22\n\2\u021b\u021d\3\2\2\2\u021c\u0217\3\2\2\2\u021d\u0220\3"+
		"\2\2\2\u021e\u021c\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0222\3\2\2\2\u0220"+
		"\u021e\3\2\2\2\u0221\u0213\3\2\2\2\u0221\u0222\3\2\2\2\u0222\u0223\3\2"+
		"\2\2\u0223\u023e\7\u0083\2\2\u0224\u023e\7\7\2\2\u0225\u022e\7\u0080\2"+
		"\2\u0226\u022b\5\22\n\2\u0227\u0228\7{\2\2\u0228\u022a\5\22\n\2\u0229"+
		"\u0227\3\2\2\2\u022a\u022d\3\2\2\2\u022b\u0229\3\2\2\2\u022b\u022c\3\2"+
		"\2\2\u022c\u022f\3\2\2\2\u022d\u022b\3\2\2\2\u022e\u0226\3\2\2\2\u022e"+
		"\u022f\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u023e\7\u0081\2\2\u0231\u023e"+
		"\7\60\2\2\u0232\u0233\7a\2\2\u0233\u023e\5\22\n!\u0234\u0235\7`\2\2\u0235"+
		"\u023e\5\22\n \u0236\u0237\7m\2\2\u0237\u023e\5\22\n\37\u0238\u0239\7"+
		"f\2\2\u0239\u023e\5\22\n\36\u023a\u023b\t\5\2\2\u023b\u023e\5\22\n\35"+
		"\u023c\u023e\5\26\f\2\u023d\u01a8\3\2\2\2\u023d\u01ab\3\2\2\2\u023d\u01b0"+
		"\3\2\2\2\u023d\u01b5\3\2\2\2\u023d\u01b6\3\2\2\2\u023d\u01b7\3\2\2\2\u023d"+
		"\u01b8\3\2\2\2\u023d\u01c7\3\2\2\2\u023d\u01cb\3\2\2\2\u023d\u01dc\3\2"+
		"\2\2\u023d\u01e2\3\2\2\2\u023d\u01e9\3\2\2\2\u023d\u01fd\3\2\2\2\u023d"+
		"\u0206\3\2\2\2\u023d\u0212\3\2\2\2\u023d\u0224\3\2\2\2\u023d\u0225\3\2"+
		"\2\2\u023d\u0231\3\2\2\2\u023d\u0232\3\2\2\2\u023d\u0234\3\2\2\2\u023d"+
		"\u0236\3\2\2\2\u023d\u0238\3\2\2\2\u023d\u023a\3\2\2\2\u023d\u023c\3\2"+
		"\2\2\u023e\u02b0\3\2\2\2\u023f\u0240\f\33\2\2\u0240\u0241\t\6\2\2\u0241"+
		"\u02af\5\22\n\34\u0242\u0243\f\32\2\2\u0243\u0244\t\7\2\2\u0244\u02af"+
		"\5\22\n\33\u0245\u0246\f\31\2\2\u0246\u0247\t\b\2\2\u0247\u02af\5\22\n"+
		"\32\u0248\u0249\f\30\2\2\u0249\u024a\t\t\2\2\u024a\u02af\5\22\n\31\u024b"+
		"\u024c\f\27\2\2\u024c\u024d\t\n\2\2\u024d\u02af\5\22\n\30\u024e\u024f"+
		"\f\26\2\2\u024f\u0250\t\13\2\2\u0250\u02af\5\22\n\27\u0251\u0252\f\25"+
		"\2\2\u0252\u0253\7r\2\2\u0253\u02af\5\22\n\26\u0254\u0255\f\24\2\2\u0255"+
		"\u0256\7g\2\2\u0256\u02af\5\22\n\25\u0257\u0258\f\23\2\2\u0258\u0259\7"+
		"i\2\2\u0259\u02af\5\22\n\24\u025a\u025b\f\22\2\2\u025b\u025c\7h\2\2\u025c"+
		"\u02af\5\22\n\23\u025d\u025e\f\21\2\2\u025e\u025f\7n\2\2\u025f\u02af\5"+
		"\22\n\22\u0260\u0261\f\20\2\2\u0261\u0262\7o\2\2\u0262\u02af\5\22\n\21"+
		"\u0263\u0264\f\17\2\2\u0264\u0265\7y\2\2\u0265\u02af\5\22\n\20\u0266\u0267"+
		"\f\16\2\2\u0267\u0268\t\f\2\2\u0268\u02af\5\22\n\17\u0269\u026a\f\r\2"+
		"\2\u026a\u026b\7|\2\2\u026b\u026c\5\22\n\2\u026c\u026d\7}\2\2\u026d\u026e"+
		"\5\22\n\16\u026e\u02af\3\2\2\2\u026f\u0270\f\f\2\2\u0270\u0271\7\61\2"+
		"\2\u0271\u02af\5\22\n\r\u0272\u0273\f\13\2\2\u0273\u0274\7\62\2\2\u0274"+
		"\u02af\5\22\n\f\u0275\u0276\f\n\2\2\u0276\u0277\7\63\2\2\u0277\u02af\5"+
		"\22\n\13\u0278\u0279\f\t\2\2\u0279\u027a\t\r\2\2\u027a\u02af\5\22\n\n"+
		"\u027b\u027c\f\b\2\2\u027c\u027d\t\16\2\2\u027d\u02af\5\22\n\t\u027e\u027f"+
		"\f\7\2\2\u027f\u0280\7\u008c\2\2\u0280\u02af\5\22\n\b\u0281\u0282\f\6"+
		"\2\2\u0282\u0283\7\u008e\2\2\u0283\u02af\5\22\n\7\u0284\u0285\f\5\2\2"+
		"\u0285\u0286\7\u008d\2\2\u0286\u02af\5\22\n\6\u0287\u0288\f\4\2\2\u0288"+
		"\u0289\7\u0085\2\2\u0289\u02af\5\22\n\5\u028a\u028b\f8\2\2\u028b\u028c"+
		"\7z\2\2\u028c\u02af\7]\2\2\u028d\u028e\f\66\2\2\u028e\u028f\7z\2\2\u028f"+
		"\u02af\7\4\2\2\u0290\u0291\f)\2\2\u0291\u029a\7~\2\2\u0292\u0297\5\22"+
		"\n\2\u0293\u0294\7{\2\2\u0294\u0296\5\22\n\2\u0295\u0293\3\2\2\2\u0296"+
		"\u0299\3\2\2\2\u0297\u0298\3\2\2\2\u0297\u0295\3\2\2\2\u0298\u029b\3\2"+
		"\2\2\u0299\u0297\3\2\2\2\u029a\u0292\3\2\2\2\u029a\u029b\3\2\2\2\u029b"+
		"\u029c\3\2\2\2\u029c\u02af\7\177\2\2\u029d\u029e\f(\2\2\u029e\u02af\7"+
		"\6\2\2\u029f\u02a0\f\'\2\2\u02a0\u02a9\7\u0080\2\2\u02a1\u02a6\5\22\n"+
		"\2\u02a2\u02a3\7{\2\2\u02a3\u02a5\5\22\n\2\u02a4\u02a2\3\2\2\2\u02a5\u02a8"+
		"\3\2\2\2\u02a6\u02a4\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7\u02aa\3\2\2\2\u02a8"+
		"\u02a6\3\2\2\2\u02a9\u02a1\3\2\2\2\u02a9\u02aa\3\2\2\2\u02aa\u02ab\3\2"+
		"\2\2\u02ab\u02af\7\u0081\2\2\u02ac\u02ad\f\34\2\2\u02ad\u02af\t\5\2\2"+
		"\u02ae\u023f\3\2\2\2\u02ae\u0242\3\2\2\2\u02ae\u0245\3\2\2\2\u02ae\u0248"+
		"\3\2\2\2\u02ae\u024b\3\2\2\2\u02ae\u024e\3\2\2\2\u02ae\u0251\3\2\2\2\u02ae"+
		"\u0254\3\2\2\2\u02ae\u0257\3\2\2\2\u02ae\u025a\3\2\2\2\u02ae\u025d\3\2"+
		"\2\2\u02ae\u0260\3\2\2\2\u02ae\u0263\3\2\2\2\u02ae\u0266\3\2\2\2\u02ae"+
		"\u0269\3\2\2\2\u02ae\u026f\3\2\2\2\u02ae\u0272\3\2\2\2\u02ae\u0275\3\2"+
		"\2\2\u02ae\u0278\3\2\2\2\u02ae\u027b\3\2\2\2\u02ae\u027e\3\2\2\2\u02ae"+
		"\u0281\3\2\2\2\u02ae\u0284\3\2\2\2\u02ae\u0287\3\2\2\2\u02ae\u028a\3\2"+
		"\2\2\u02ae\u028d\3\2\2\2\u02ae\u0290\3\2\2\2\u02ae\u029d\3\2\2\2\u02ae"+
		"\u029f\3\2\2\2\u02ae\u02ac\3\2\2\2\u02af\u02b2\3\2\2\2\u02b0\u02ae\3\2"+
		"\2\2\u02b0\u02b1\3\2\2\2\u02b1\23\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b3\u02b4"+
		"\7]\2\2\u02b4\25\3\2\2\2\u02b5\u02b7\t\7\2\2\u02b6\u02b5\3\2\2\2\u02b6"+
		"\u02b7\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u02be\7\u0092\2\2\u02b9\u02be"+
		"\7\u0093\2\2\u02ba\u02be\7\u0094\2\2\u02bb\u02be\7\u0095\2\2\u02bc\u02be"+
		"\7]\2\2\u02bd\u02b6\3\2\2\2\u02bd\u02b9\3\2\2\2\u02bd\u02ba\3\2\2\2\u02bd"+
		"\u02bb\3\2\2\2\u02bd\u02bc\3\2\2\2\u02be\27\3\2\2\2\u02bf\u02c4\7]\2\2"+
		"\u02c0\u02c1\7z\2\2\u02c1\u02c3\7]\2\2\u02c2\u02c0\3\2\2\2\u02c3\u02c6"+
		"\3\2\2\2\u02c4\u02c2\3\2\2\2\u02c4\u02c5\3\2\2\2\u02c5\31\3\2\2\2\u02c6"+
		"\u02c4\3\2\2\2\u02c7\u02cc\7]\2\2\u02c8\u02c9\7z\2\2\u02c9\u02cb\7]\2"+
		"\2\u02ca\u02c8\3\2\2\2\u02cb\u02ce\3\2\2\2\u02cc\u02ca\3\2\2\2\u02cc\u02cd"+
		"\3\2\2\2\u02cd\33\3\2\2\2\u02ce\u02cc\3\2\2\2\u02cf\u02d0\t\17\2\2\u02d0"+
		"\35\3\2\2\2\u02d1\u02d2\t\20\2\2\u02d2\37\3\2\2\2U$&\63\65ADJLX]gpsz\177"+
		"\u008d\u0090\u0097\u009c\u009e\u00a7\u00ac\u00b6\u00bf\u00c2\u00c9\u00ce"+
		"\u00dc\u00df\u00e6\u00eb\u00ed\u00f3\u00ff\u0103\u010f\u0119\u011e\u0128"+
		"\u012d\u0130\u0134\u0138\u0146\u014c\u0155\u0161\u0165\u016c\u0170\u0178"+
		"\u017f\u0185\u019c\u01a6\u01c0\u01c3\u01d1\u01d4\u01da\u01e0\u01e7\u01f2"+
		"\u01f5\u01fb\u0204\u020c\u020f\u021e\u0221\u022b\u022e\u023d\u0297\u029a"+
		"\u02a6\u02a9\u02ae\u02b0\u02b6\u02bd\u02c4\u02cc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}