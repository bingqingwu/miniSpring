package com.bing.mini.beans.factory.config;

import com.bing.mini.beans.BeansException;
import com.bing.mini.beans.factory.BeanFactory;

public interface BeanFactoryPostProcessor {
    void postProcessBeanFactory(BeanFactory beanFactory) throws BeansException;
}
