package com.bing.mini.web;

import com.bing.mini.context.ClassPathXmlApplicationContext;
import com.bing.mini.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

public class XmlWebApplicationContext
        extends ClassPathXmlApplicationContext implements WebApplicationContext {
    private ServletContext servletContext;

    public XmlWebApplicationContext(String fileName) {
        super(fileName);
    }

    @Override
    public ServletContext getServletContext() {
        return this.servletContext;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
