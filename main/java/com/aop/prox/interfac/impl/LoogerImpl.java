package com.aop.prox.interfac.impl;

import com.aop.prox.interfac.Looger;

import java.lang.reflect.Method;

/**
 * aop日志处理类
 * Created by DESTINY on 2019/4/29.
 */
public class LoogerImpl implements Looger {

    public LoogerImpl() {
        System.out.println("==================自定义aop启动");
    }

    @Override
    public void start(Method method) {
        log(method, "start 目标执行之前 todo....");
    }

    @Override
    public void end(Method method) {
        log(method, "end 目标执行之后 todo....");
    }

    private void log(Method method, String m) {
        System.out.println(method.getClass().getPackage().getName() + " method:" + method.getName() + ":  " + m );
    }
}
