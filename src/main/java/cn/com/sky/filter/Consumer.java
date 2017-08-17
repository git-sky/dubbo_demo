package cn.com.sky.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sky.filter.server.service.DemoService;

public class Consumer {
	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	private static String getPath() {
		String path = Consumer.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	public static void main(String[] args) {

		String configLocation = getPath() + "/consumer.xml";

		final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

		context.start();
		logger.info("Consumer started successfully");
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				logger.info("Shutdown hook was invoked. Shutting down Consumer.");
				context.close();
			}
		});

		DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理

		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new MyThread(demoService));
			t.start();
		}

	}

}

class MyThread implements Runnable {
	DemoService ds = null;

	MyThread(DemoService ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		String result = ds.sayHello("world"); // 执行远程方法
		System.out.println("result--> " + result);
	}
}