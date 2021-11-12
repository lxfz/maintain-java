package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Hello{
  void morning(String name);
}

public class DynamicProxy {

  public static void main(String[] args) {
    InvocationHandler handler = new InvocationHandler() {
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method);
        if(method.getName().equals("morning")){
          System.out.println("Good morning: " + args[0]);
        }
        return null;
      }
    };


    // Java标准库提供了动态代理功能，允许在运行期动态创建一个接口的实例；
    Hello hello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(),
        new Class[] {Hello.class},
        handler
        );
    hello.morning("Bob");
  }
}
