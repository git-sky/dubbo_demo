package cn.com.sky.dubbo.server.service.impl;

import cn.com.sky.dubbo.server.User;
import cn.com.sky.dubbo.server.service.DemoService;

public class DemoServiceThirdImpl implements DemoService {

	public String sayHello(String name) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "provider: Hello third impl '" + name + "'";
	}

	@Override
	public void addUser(User u) {
		System.out.println("add user successfully third impl ....");
	}

	@Override
	public User getUserById(Integer id) {
		return new User();
	}

}