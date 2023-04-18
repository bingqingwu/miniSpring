package com.bing.mini.context;

import com.bing.mini.beans.BeansException;
import com.bing.mini.beans.factory.ListableBeanFactory;
import com.bing.mini.beans.factory.config.BeanFactoryPostProcessor;
import com.bing.mini.beans.factory.config.ConfigurableBeanFactory;
import com.bing.mini.beans.factory.config.ConfigurableListableBeanFactory;
import com.bing.mini.core.env.Environment;
import com.bing.mini.core.env.EnvironmentCapable;

public interface ApplicationContext
        extends EnvironmentCapable, ListableBeanFactory, ConfigurableBeanFactory, ApplicationEventPublisher {

    String getApplicationName();

    long getStartupDate();

    ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException;

    void setEnvironment(Environment environment);

    Environment getEnvironment();

    void addBeanFactoryPostProcessor(BeanFactoryPostProcessor postProcessor);

    void refresh() throws BeansException, IllegalStateException;

    void close();

    boolean isActive();
}
