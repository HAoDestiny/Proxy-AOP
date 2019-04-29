package com.aop.prox.interfac.impl;

import com.aop.prox.interfac.TestLog;

/**
 * Created by DESTINY on 2019/4/29.
 */
public class TestLogImpl implements TestLog {

    @Override
    public void log(String content) {
        System.out.println("------------" + content);
    }
}
