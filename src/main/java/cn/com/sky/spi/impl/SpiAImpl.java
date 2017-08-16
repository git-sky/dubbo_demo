package cn.com.sky.spi.impl;

import cn.com.sky.spi.Spi;

public class SpiAImpl implements Spi {

	public boolean isSupport(String name) {
		return "SPIA".equalsIgnoreCase(name.trim());
	}

	public String sayHello() {
		return "hello 我是厂商A";
	}

	public SpiAImpl() {
		System.out.println("SpiAImpl()...");
	}

}