package com.bing.mini.aop;

public interface PointcutAdvisor extends Advisor{
    Pointcut getPointcut();
}
