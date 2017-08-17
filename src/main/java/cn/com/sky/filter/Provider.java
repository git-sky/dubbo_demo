package cn.com.sky.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {

	private static final Logger logger = LoggerFactory.getLogger(Provider.class);

	private static String getPath() {
		String path = Provider.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	public static void main(String[] args) throws Exception {

		String configLocation = getPath() + "/provider.xml";

		final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

		context.start();
		logger.info("Provider started successfully ");
		System.out.println("Provider started successfully ");
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				logger.info("Shutdown hook was invoked. Shutting down Provider.");
				context.close();
			}
		});

		System.in.read(); // 按任意键退出
	}

}