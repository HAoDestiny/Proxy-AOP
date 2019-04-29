package com.aop.prox.DynaProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by DESTINY on 2019/4/29.
 */
public class DynaProxyTestLog implements InvocationHandler {

    // 目标对象
    private Object target;

    // aop调用对象
    private Object proxy;


    /**
     * 通过反射来实例化目标对象
     * @param target
     * @return
     */
    public Object bind(Object target, Object proxy) {
        this.target = target;
        this.proxy = proxy;
        return Proxy.newProxyInstance(
                this.target.getClass().getClassLoader(), // 目标类
                this.target.getClass().getInterfaces(), // 目标对象接口
                this
        );
    }

    /**
     *
     * @param proxy 代理对象 即测试中的 TestLogImpl
     * @param method 代理对象当前调用的方法 即测试中的 TestLogImpl 类种的log(String content)方法
     * @param args 方法参数 即测试中的 TestLogImpl 类种的log(String content)方法 String content
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;

        /////////////////////////// 目标执行之前
        // System.out.println("----------- log start ");
        Class proxyClass = this.proxy.getClass();

        // 获取start方法
        Method start = proxyClass.getDeclaredMethod("start", Method.class);
        start.invoke(this.proxy, method);


        result = method.invoke(this.target, args); // 反射调用目标对象方法 传递参数(目标对象，参数)


        /////////////////////////// 目标执行之后
        //System.out.println("----------- log start ");
        Method end = proxyClass.getDeclaredMethod("end", Method.class);
        end.invoke(this.proxy, method);

        return result;
    }
}
