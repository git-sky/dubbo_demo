package cn.com.sky.dubbo.server.service.impl;

import cn.com.sky.dubbo.server.User;
import cn.com.sky.dubbo.server.service.DemoService;

import com.alibaba.dubbo.rpc.RpcContext;

public class DemoServiceImpl implements DemoService {

	public String sayHello(String name) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String sessionId = RpcContext.getContext().getAttachment("key");
		System.out.println(sessionId);

		return "provider: Hello '" + name + "'";
	}

	@Override
	public void addUser(User u) {
		System.out.println("add user successfully ....");
	}

	@Override
	public User getUserById(Integer id) {
		return new User();
	}

}