package cn.com.sky.extension;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * 设计配置属性和JavaBean 
 * 编写XSD文件 
 * 编写NamespaceHandler和BeanDefinitionParser完成解析工作 
 * 编写spring.handlers和spring.schemas串联起所有部件
 * 在Bean文件中应用
 */
public class Test {

	private static String getPath() {
		String path = Test.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	public static void main(String[] args) {

		String configLocation = getPath() + "/applicationContext.xml";

		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

		People p = (People) ctx.getBean("cutesource");
		System.out.println(p.getId());
		System.out.println(p.getName());
		System.out.println(p.getAge());

	}
}
