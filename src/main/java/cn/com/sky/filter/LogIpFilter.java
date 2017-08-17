package cn.com.sky.filter;

import com.alibaba.dubbo.common.utils.NetUtils;
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
public class LogIpFilter implements Filter {

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

		String localhost = NetUtils.getLocalHost();

		RpcContext.getContext().setAttachment("localhost", localhost);
		System.out.println("localhost-->" + localhost);

		return invoker.invoke(invocation);
	}
}
