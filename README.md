# Proxy-AOP
基于动态代理 AOP原理 自定义实现日志操作

## DynaProxyTestLog实现了 InvocationHandler 接口
````java
    /**
     * @param proxy 代理对象 即测试中的 TestLogImpl
     * @param method 代理对象当前调用的方法 即测试中的 TestLogImpl 类种的log(String content)方法
     * @param args 方法参数 即测试中的 TestLogImpl 类种的log(String content)方法 String content
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        
        Class proxyClass = this.proxy.getClass();

        // 获取start方法
        Method start = proxyClass.getDeclaredMethod("start", Method.class);
        start.invoke(this.proxy, method);

        result = method.invoke(this.target, args); // 反射调用目标对象方法 传递参数(目标对象，参数)

        Method end = proxyClass.getDeclaredMethod("end", Method.class);
        end.invoke(this.proxy, method);
        return null;
    }
````

## 返回代理对象
````java
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
````

## 动态代理调用 main.java
````java
        // 动态代理测试
        TestLog testLog1 = (TestLog) new DynaProxyTestLog().bind(new TestLogImpl(), new LoogerImpl());
        testLog1.log("动态代理调用");
````
