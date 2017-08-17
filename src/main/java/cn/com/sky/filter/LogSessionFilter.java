package cn.com.sky.filter;

import java.util.UUID;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;

/**
 * <pre>
 * 
 * Dubbo Filter
 * 作用：向Dubbo服务传递上下文环境信息，设置黑白名单，隐式传参等等。
 * 
 * Dubbo上下文对象：RpcContext
 */
public class LogSessionFilter implements Filter {

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

		String logSessionId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
		RpcContext.getContext().setAttachment("key", logSessionId);
		System.out.println("logSessionId-->" + logSessionId);

		return invoker.invoke(invocation);
	}
}
