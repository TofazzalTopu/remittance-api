package com.rms.api.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
 
@Component
public class ContextProvider implements ApplicationContextAware {
 
    private ApplicationContext CONTEXT;
 
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CONTEXT = applicationContext;
    }
 
    /**
     * Get a Spring bean by type.
     **/
    public <T> T getBean(Class<T> beanClass) {
        return CONTEXT.getBean(beanClass);
    }
 
    /**
     * Get a Spring bean by name.
     **/
    public Object getBean(String beanName) {
        return CONTEXT.getBean(beanName);
    }
 
}