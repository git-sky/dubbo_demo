package cn.com.sky.spi.impl;

import cn.com.sky.spi.Spi;

public class SpiBImpl implements Spi {

	public boolean isSupport(String name) {
		return "SPIB".equalsIgnoreCase(name.trim());
	}

	public String sayHello() {
		return "hello 我是厂商B";
	}

	public SpiBImpl() {
		System.out.println("SpiBImpl()...");
	}
}