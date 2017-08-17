package cn.com.sky.cache;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 服务端 缓存 接口实现
 * 
 */
public class CacheServiceImpl implements CacheService {

	private final AtomicInteger i = new AtomicInteger();

	public String findCache(String id) {
		System.out.println("CacheServiceImpl--findCache:" + id);
		return "request: " + id + ", response: " + i.getAndIncrement();
	}
}