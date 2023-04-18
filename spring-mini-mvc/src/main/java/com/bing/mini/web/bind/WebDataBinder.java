package com.bing.mini.web.bind;

import com.bing.mini.beans.AbstractPropertyAccessor;
import com.bing.mini.beans.PropertyEditor;
import com.bing.mini.beans.PropertyValues;
import com.bing.mini.web.BeanWrapperImpl;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class WebDataBinder {
    private Object target;
    private Class<?> clz;

    private String objectName;
    AbstractPropertyAccessor propertyAccessor;

    public WebDataBinder(Object target) {
        this(target,"");
    }
    public WebDataBinder(Object target, String targetName) {
        this.target = target;
        this.objectName = targetName;
        this.clz = this.target.getClass();
        this.propertyAccessor = new BeanWrapperImpl(this.target);
    }

    public void bind(HttpServletRequest request) {
        PropertyValues mpvs = assignParameters(request);
        addBindValues(mpvs, request);
        doBind(mpvs);
    }

    private void doBind(PropertyValues mpvs) {
        applyPropertyValues(mpvs);

    }

    protected void applyPropertyValues(PropertyValues mpvs) {
        getPropertyAccessor().setPropertyValues(mpvs);
    }

    protected AbstractPropertyAccessor getPropertyAccessor() {
        return this.propertyAccessor;
    }

    private PropertyValues assignParameters(HttpServletRequest request) {
        Map<String,Object> map = WebUtils.getParametersStartingWith(request, "");

        return new PropertyValues(map);
    }

    public void registerCustomEditor(Class<?> requiredType, PropertyEditor propertyEditor) {
        getPropertyAccessor().registerCustomEditor(requiredType, propertyEditor);
    }

    protected void addBindValues(PropertyValues mpvs, HttpServletRequest request) {
    }

}
