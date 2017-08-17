package cn.com.sky.cache.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sky.cache.CacheService;

/**
 * 客户端入口
 */
public class CacheConsumer {

	private static String getPath() {
		String path = CacheConsumer.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	public static void main(String[] args) throws Exception {

		String configLocation = getPath() + "/CacheConsumer.xml";

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		context.start();

		CacheService cacheService = (CacheService) context.getBean("cacheService");

		// 测试缓存生效，多次调用返回同样的结果。(服务器端自增长返回值)
		String fix = null;
		for (int i = 0; i < 5; i++) {
			String result = cacheService.findCache("0"); // request: 0, response: 1001
			if (fix == null || fix.equals(result)) {
				System.out.println("OK: " + result);
			} else {
				System.err.println("ERROR: " + result);
			}
			fix = result;
			Thread.sleep(6000);
		}

		// LRU的缺省cache.size为1000，执行1001次，应有溢出，执行了1001次后1001*2=2002，所以result为2002
		for (int n = 0; n < 1002; n++) {
			String pre = null;
			for (int i = 0; i < 10; i++) {
				String result = cacheService.findCache(String.valueOf(n));
				if (pre != null && !pre.equals(result)) {
					System.err.println("ERROR: " + result);
				} else {
					System.out.println(result);
				}
				pre = result;
			}
		}

		// 测试LRU有移除最开始的一个缓存项
		String result = cacheService.findCache("0"); // request: 0, response: 2002
		if (fix != null && !fix.equals(result)) {
			System.out.println("OK: " + result);
		} else {
			System.err.println("ERROR: " + result);
		}

	}
}