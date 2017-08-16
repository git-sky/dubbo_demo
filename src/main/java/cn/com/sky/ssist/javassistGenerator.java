package cn.com.sky.ssist;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtField.Initializer;
import javassist.CtNewMethod;
import javassist.Modifier;

public class javassistGenerator {

	public static void main(String[] args) throws Exception {
		// 创建类
		ClassPool pool = ClassPool.getDefault();
		CtClass cls = pool.makeClass("cn.com.sky.ssist.TestClass");

		// 添加私有成员name及其getter、setter方法
		CtField param = new CtField(pool.get("java.lang.String"), "name", cls);

		param.setModifiers(Modifier.PRIVATE);
		cls.addMethod(CtNewMethod.setter("setName", param));
		cls.addMethod(CtNewMethod.getter("getName", param));
		cls.addField(param, Initializer.constant(""));

		// 添加有参的构造体
		CtConstructor cons = new CtConstructor(new CtClass[] { pool.get("java.lang.String") }, cls);
		cons.setBody("{$0.name = $1;}");
		cls.addConstructor(cons);

		// 打印创建类的类名
		System.out.println(cls.toClass());

		// 通过反射创建无参的实例，并调用getName方法
		Object o = Class.forName("cn.com.sky.ssist.TestClass").newInstance();
		Method getter = o.getClass().getMethod("getName");
		System.out.println(getter.invoke(o));

		// 调用其setName方法
		Method setter = o.getClass().getMethod("setName", new Class[] { String.class });
		setter.invoke(o, "Adam");
		System.out.println(getter.invoke(o));

		// 通过反射创建有参的实例，并调用getName方法
		o = Class.forName("cn.com.sky.ssist.TestClass").getConstructor(String.class).newInstance("Liu Jian");
		getter = o.getClass().getMethod("getName");
		System.out.println(getter.invoke(o));

	}

}