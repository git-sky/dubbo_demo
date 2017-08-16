package cn.com.sky.stub_skeleton.server;

import cn.com.sky.stub_skeleton.Person;

public class PersonServer implements Person {

	private int age;
	private String name;

	public PersonServer(String name, int age) {
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}
}