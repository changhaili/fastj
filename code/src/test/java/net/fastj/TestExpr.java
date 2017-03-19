package net.fastj;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.mmodel.Printer;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.reflection.Reflections;
import net.fastj.lang.result.Result;

public class TestExpr {

	public void assertExpr(String expr, Object v) {

		MModelContext datums = new MModelContext(null, Printer.Nothing);

		LangNode node = LangEnginers.parseSimpleExpr(expr, datums);

		Object v2 = LangUtils.toValue(node, datums);

		if (Reflections.isArray(v2)) {

			Object[] vs0 = net.fastj.collection.Collections.toArray(v);
			Object[] vs1 = net.fastj.collection.Collections.toArray(v2);

			System.out.println(StringUtils.join(net.fastj.collection.Collections.toArray(v), ","));
			Assert.assertTrue(v == v2 || v != null && Arrays.equals(vs0, vs1));

		} else {
			System.out.println(v2);
			Assert.assertTrue(v == v2 || v != null && v.equals(v2));
		}

	}

	@Test
	public void testBaseExpr() {

		System.out.println("testBaseExpr");

		this.assertExpr("1+1", 2);
		this.assertExpr("array(1,2,4,3, 5,6,7).length", 7);

		this.assertExpr("@'abcd'.substring(0,3)", "abc");
		this.assertExpr("@'abc{0}+{1}' % (1,4)", "abc1+4");
		this.assertExpr("new String(@'abcd').length()", 4);

		this.assertExpr("[1,2,3,4].size()", 4);

		this.assertExpr("3 in (1,2,4,5,6,7, 3)", true);

		this.assertExpr("{@'a':123, @'b':345}[@'b']", 345);

		this.assertExpr("!(1==1)", false);
		this.assertExpr("[1,2,3,4].size()", 4);

		this.assertExpr("abc??10", 10);
		this.assertExpr("default(java.lang.String)", null);
		this.assertExpr("@'abcd' ~= @'.*'", true);
		this.assertExpr("new String(@'abcd')", "abcd");
		this.assertExpr("new String(\"abcd\")", "abcd");
		this.assertExpr("range(1,5)", new Object[] { 1, 2, 3, 4, 5 });
		this.assertExpr("[1,2,3,4,5][4]", 5);
		this.assertExpr("new String()", "");

		this.assertExpr("new java.lang.String(@'abc')", "abc");

		this.assertExpr("default(boolean)", false);
		this.assertExpr("default(float)", 0.0f);
		this.assertExpr("default(String)", null);

		this.assertExpr("defined(String)", false);

		this.assertExpr("'a'+2", 'a' + 2);

		this.assertExpr("max(1,2)", 2);
		this.assertExpr("min(1.2,2)", 1.2);
		this.assertExpr("min(1.23e-2f,2)", 1.23e-2f);

		this.assertExpr("@'123'+(@'abc' instanceof Integer)", "123false");

		this.assertExpr("true ^^ false", true);
		this.assertExpr("1 ^ 7", 6);
		this.assertExpr("@'abcd'[1]", 'b');
		this.assertExpr("3**4", 81.0);
		this.assertExpr("@'abc'*4", "abcabcabcabc");

		this.assertExpr("java.lang.Integer.parseInt(@'1234')", 1234);

		this.assertExpr("@'abc'.charAt(1)", 'b');

		this.assertExpr("1/2+20", 20);

		this.assertExpr("\"abc\"+2", "abc2");
		this.assertExpr("@'abc'+2", "abc2");

		this.assertExpr("@\"b\"+2", 'b' + 2);

		this.assertExpr("false? 1 : 40", 40);

		this.assertExpr("@'abcd(1+2)efc'+1L+2", "abcd(1+2)efc12");

	}

	public static class A {

		public int v = 20;
	}

	public static class B {

		public A a = new A();

		public static int B1 = 10;
	}

	private void execCode(String text) {

		MModelContext pool = new MModelContext(null, Printer.Nothing);
		LangNode node = LangEnginers.parseCode(text, pool);
		Result v = LangUtils.eval(node, pool);

		System.out.println(v.get());
	}

	@Test
	public void testForeach() {

		System.out.println("testForeach");

		String text = "var c=3; for(var i : range(1,5)) { c+=i; if(i==3) break; } c";

		execCode(text);

	}

	@Test
	public void testFor() {

		System.out.println("testFor");

		String text = "var c=1; for(i=0;i<20;i++) { c+=i;} c";

		execCode(text);

	}

	@Test
	public void testIf() {

		System.out.println("testIf");

		String text = ".c=3; if(c<1) 4; else 5;";

		execCode(text);

	}

	@Test
	public void testWhile() {
		System.out.println("testWhile");

		String text = "c=1; i=0; while(i<10) {i++;c=c+i; k=i;} c";

		execCode(text);
	}

	@Test
	public void testDoWhile() {
		System.out.println("testDoWhile");

		String text = "c=1; i=0; do{i++;c=c+i; k=i;}while(i<10); c";

		execCode(text);

	}

	@Test
	public void testSwitch() {

		System.out.println("testSwitch");

		String text = "var c=20; switch(4) { case 10: { c=2 ; break;} case 1: { c=1; } default: c=4; } c";

		execCode(text);
	}

	@Test
	public void testComment() {

		System.out.println("testComment");

		String text = "c=1; /* c=20 ; */ i=0; while(i<10) {i++;c=c+i; k=i;} c";

		execCode(text);
	}

	@Test
	public void testFunction() {

		System.out.println("testFunction");

		String text = "def fun(id0, id1=20,id2=30){ if(id0) id1; else id2;}; fun(false);  ";

		execCode(text);
	}

	@Test
	public void testFunction2() {

		System.out.println("testFunction2");

		String text = "def fun(id0){ return id0+20; } def fun2(f, b) {return f(b);} return fun2((k)=>{k*19;},19);  ";

		execCode(text);
	}

	@Test
	public void testLambda() {

		System.out.println("testLambda");

		String text = "var c=(d)=>{k=23; return k*d;}; c(2) ";

		execCode(text);
	}

	@Test
	public void testPrint() {

		System.out.println("testPrint");

		String text = "println(@'12345'); 1 ";

		execCode(text);
	}

	@Test
	public void testThrow() {
		System.out.println("testThrow");

		String text = " var k = null; try{ assert(false, @'abc'); }catch(e) {k =e;} ; k.toString()";

		execCode(text);
	}

	// @Test
	// public void testClass() {
	//
	// System.out.println("testClass");
	//
	// String text = "interface IA { def x(); } class A{ i=20; def fun(a){return
	// a+this.i;} } class B : A , IA { def x() {} def fun(a){ return a* this.i;
	// } } new B().fun(2); ";
	//
	// execCode(text);
	// }

	@Test
	public void testExtends() {

		System.out.println("testExtends");

		String text = "class C1{ i=20; this.j=3; }  class C2 : C1  { def fun(a){ return a* this.i * this.j; } }  new C2().fun(2); ";

		execCode(text);
	}
}
