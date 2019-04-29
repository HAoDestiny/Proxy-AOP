package com.aop.prox.staticProxy;

import com.aop.prox.interfac.TestLog;

/**
 * 静态代理
 * Created by DESTINY on 2019/4/29.
 */
public class StaticProxyTestLog implements TestLog {

    private TestLog testLog;

    public StaticProxyTestLog(TestLog testLog) {
        this.testLog = testLog;
    }

    @Override
    public void log(String content) {
        System.out.println("startLog ===== ");
        testLog.log(content);
        System.out.println("endLog ===== ");
    }
}
