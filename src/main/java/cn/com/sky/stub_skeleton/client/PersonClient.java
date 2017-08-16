package cn.com.sky.stub_skeleton.client;

import cn.com.sky.stub_skeleton.Person;

/**
 * <pre>
 * 
 * Skeleton是放在服务器端的一个“代理”，stub是放在客户端的一个“代理”，例如：stub中声明了一个sin(int x)的函数，
 * 
 * 但其中的内容并不是具体求sin(x)值的算法，而是一系列网络连接的协议 ，自动地去查找skeleton所在的主机，而后与其交换数据，并得到返回值的一系列代码。
 * 
 * 此时客户端的进程只需要去调stub中的sin(x)方法，即可实现与远端服务器的数据交换，这样便保证了数据传输对于应用进程的透明性。
 * 
 * </pre>
 */
public class PersonClient {

	public static void main(String[] args) {
		try {
			Person person = new Person_Stub();
			int age = person.getAge();
			String name = person.getName();
			System.out.println(name + " is " + age + " years old");
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}