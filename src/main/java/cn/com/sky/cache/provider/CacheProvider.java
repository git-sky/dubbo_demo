package cn.com.sky.cache.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CacheProvider {

	private static String getPath() {
		String path = CacheProvider.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	public static void main(String[] args) throws Exception {

		String configLocation = getPath() + "/CacheProvider.xml";

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		context.start();
		System.out.println("按任意键退出");
		System.in.read();
	}
}