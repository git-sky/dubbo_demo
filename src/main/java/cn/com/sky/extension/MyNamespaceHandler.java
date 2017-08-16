package cn.com.sky.extension;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * registerBeanDefinitionParser("people", new
 * PeopleBeanDefinitionParser());就是用来把节点名和解析类联系起来，在配置中引用people配置项时
 * ，就会用PeopleBeanDefinitionParser来解析配置。
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
	public void init() {
		registerBeanDefinitionParser("people", new PeopleBeanDefinitionParser());
	}
}