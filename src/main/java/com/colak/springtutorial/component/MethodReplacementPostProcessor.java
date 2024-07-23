package com.colak.springtutorial.component;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@RequiredArgsConstructor
public class MethodReplacementPostProcessor implements BeanPostProcessor {


    private final MyMethodReplacer methodReplacer;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean instanceof MyBean) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(bean.getClass());
            enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
                // Check for the specific method signature with Person argument
                if ("originalMethod".equals(method.getName()) && method.getParameterCount() == 1 && method.getParameterTypes()[0] == Person.class) {
                    return methodReplacer.reimplement(bean, method, args);
                }
                return proxy.invokeSuper(obj, args);
            });
            return enhancer.create();
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}

