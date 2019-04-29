package com.aop.prox.interfac;

import java.lang.reflect.Method;

/**
 * Created by DESTINY on 2019/4/29.
 */
public interface Looger {

    void start(Method method);

    void end(Method method);

}
