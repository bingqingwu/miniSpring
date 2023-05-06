package com.bing.mini.aop;

import com.bing.mini.beans.BeansException;
import com.bing.mini.beans.factory.BeanFactory;
import com.bing.mini.beans.factory.BeanFactoryAware;
import com.bing.mini.beans.factory.FactoryBean;
import org.springframework.util.ClassUtils;

public class ProxyFactoryBean  implements FactoryBean<Object> , BeanFactoryAware {

    private BeanFactory beanFactory;
    private AopProxyFactory aopProxyFactory;
    private String interceptorName;
    private String targetName;
    private Object target;
    private ClassLoader proxyClassLoader = ClassUtils.getDefaultClassLoader();
    private Object singletonInstance;
    private PointcutAdvisor  advisor;

    public ProxyFactoryBean() {
        this.aopProxyFactory = new DefaultAopProxyFactory();
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void setAopProxyFactory(AopProxyFactory aopProxyFactory) {
        this.aopProxyFactory = aopProxyFactory;
    }
    public AopProxyFactory getAopProxyFactory() {
        return this.aopProxyFactory;
    }

    protected AopProxy createAopProxy() {
        System.out.println("----------createAopProxy for :"+target+"--------");
        return getAopProxyFactory().createAopProxy(target, this.advisor);
    }


    public void setInterceptorName(String interceptorName) {
        this.interceptorName = interceptorName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }
    public Object getTarget() {
        return target;
    }
    public void setTarget(Object target) {
        this.target = target;
    }


    public void setAdvisor(PointcutAdvisor advisor) {
        this.advisor = advisor;
    }

    @Override
    public Object getObject() throws Exception {
        initializeAdvisor();
        return getSingletonInstance();
    }

    private synchronized void initializeAdvisor() {
        Object advice = null;
        MethodInterceptor mi = null;
        try {
            advice = this.beanFactory.getBean(this.interceptorName);
        } catch (BeansException e) {
            e.printStackTrace();
        }

        this.advisor = (PointcutAdvisor)advice;

//        if (advice instanceof BeforeAdvice) {
//            mi = new MethodBeforeAdviceInterceptor((MethodBeforeAdvice)advice);
//        }
//        else if (advice instanceof AfterAdvice){
//            mi = new AfterReturningAdviceInterceptor((AfterReturningAdvice)advice);
//        }
//        else if (advice instanceof MethodInterceptor) {
//            mi = (MethodInterceptor)advice;
//        }
//
//        advisor = new DefaultAdvisor();
//        advisor.setMethodInterceptor(mi);
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    private synchronized Object getSingletonInstance() {
        if (this.singletonInstance == null) {
            this.singletonInstance = getProxy(createAopProxy());
        }
        System.out.println("----------return proxy for :"+this.singletonInstance+"--------"+this.singletonInstance.getClass());

        return this.singletonInstance;
    }

    protected Object getProxy(AopProxy aopProxy) {
        return aopProxy.getProxy();
    }

}
