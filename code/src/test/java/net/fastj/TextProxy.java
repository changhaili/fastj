package net.fastj;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import javassist.CannotCompileException;
import javassist.NotFoundException;
import net.fastj.lang.reflection.ClassMaker;
import net.fastj.lang.reflection.InvokeArgument;
import net.fastj.lang.reflection.InvokeHandler;

public class TextProxy {

	public static abstract class A {
		public abstract void fun();
		
		public abstract void fun2();
	}

	public static abstract class B extends A {
		public void fun() {
			System.out.println("aaaaaaaaa");			
		}
	}

	@Test
	public void testProxy() throws NotFoundException, CannotCompileException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException {
		
		System.out.println(Thread.getAllStackTraces());

		ClassMaker p = new ClassMaker(new Class[] { B.class });

		Class<?> cls = p.makeClass();

		B obj = (B) cls.getConstructors()[0].newInstance(new InvokeHandler() {

			@Override
			public Object invoke(InvokeArgument arg) {
				System.out.println("sssssssss");
				//arg.invoke();
				return null;
			}
			
		});

		obj.fun2();

		// for(Method method : B.class.getMethods()){
		//
		// System.out.println(method);
		// }

		// ProxyCreator p = new ProxyCreator(new Class[] { B.class });
		//
		// p.create(null);

	}

}
