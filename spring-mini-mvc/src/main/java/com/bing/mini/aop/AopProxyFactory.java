package com.bing.mini.aop;

public interface AopProxyFactory {
    AopProxy createAopProxy(Object target, PointcutAdvisor advisor);
}
