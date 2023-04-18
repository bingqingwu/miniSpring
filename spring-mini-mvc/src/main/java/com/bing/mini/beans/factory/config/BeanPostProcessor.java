package com.bing.mini.beans.factory.config;

import com.bing.mini.beans.BeansException;
import com.bing.mini.beans.factory.BeanFactory;

public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

    void setBeanFactory(BeanFactory beanFactory);
}
