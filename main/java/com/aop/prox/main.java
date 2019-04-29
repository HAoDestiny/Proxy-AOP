package com.aop.prox;

import com.aop.prox.DynaProxy.DynaProxyTestLog;
import com.aop.prox.interfac.impl.LoogerImpl;
import com.aop.prox.staticProxy.StaticProxyTestLog;
import com.aop.prox.interfac.TestLog;
import com.aop.prox.interfac.impl.TestLogImpl;

/**
 * Created by DESTINY on 2019/4/29.
 */
public class main {

    public static void main(String[] arg) {

        // 静态代理测试
        //TestLog testLog = new StaticProxyTestLog(new TestLogImpl());
        //testLog.log("静态代理调用实现, 静态代理只能一对一实现, 如果有多个实现类就会有多个实现类的代理类");


        // 动态代理测试
        TestLog testLog1 = (TestLog) new DynaProxyTestLog().bind(new TestLogImpl(), new LoogerImpl());
        testLog1.log("动态代理调用");

        /////////普通调用
        //TestLog testLog2 = new TestLogImpl();
        //testLog2.log("普通调用");
    }

}
