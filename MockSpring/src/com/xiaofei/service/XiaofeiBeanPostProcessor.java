package com.xiaofei.service;

import com.xiaofei.spring.BeanPostProcessor;
import com.xiaofei.spring.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class XiaofeiBeanPostProcessor implements BeanPostProcessor {
  @Override
  public Object postProcessBeforeInitialization(String beanName, Object bean) {
    if (beanName.equals("userService")) {
      System.out.println("XiaofeiBeanPostProcessor:postProcessBeforeInitialization ");
    }
    return bean;
  }

  @Override
  public Object  postProcessAfterInitialization(String beanName, Object bean) {
    if (beanName.equals("userService")) {

      System.out.println("XiaofeiBeanPostProcessor:postProcessAfterInitialization ");
      System.out.println("创建代理对象");

      Object proxyInstance = Proxy.newProxyInstance(
          XiaofeiBeanPostProcessor.class.getClassLoader(),
          bean.getClass().getInterfaces(),
          new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
              System.out.println("切面逻辑");
              return method.invoke(bean, args);
            }
          });
      return proxyInstance;
    }
    return bean;
  }
}
