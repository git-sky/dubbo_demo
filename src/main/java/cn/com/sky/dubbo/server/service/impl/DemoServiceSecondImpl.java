package cn.com.sky.dubbo.server.service.impl;

import cn.com.sky.dubbo.server.User;
import cn.com.sky.dubbo.server.service.DemoService;

public class DemoServiceSecondImpl implements DemoService {

	public String sayHello(String name) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "provider: Hello second impl '" + name + "'";
	}

	@Override
	public void addUser(User u) {
		System.out.println("add user successfully second impl ....");
	}

	@Override
	public User getUserById(Integer id) {
		return new User();
	}

}