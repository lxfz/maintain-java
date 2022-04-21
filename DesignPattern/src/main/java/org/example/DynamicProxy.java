package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


interface Hello {
  void morning(String name);
}


public class DynamicProxy {

  public static void main(String[] args) {
    InvocationHandler handler = new InvocationHandler() {
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println(proxy);
        System.out.println(method);
        if (method.getName().equals("morning")) {
          System.out.println("Good morning: " + args[0]);
        }
        return null;
      }
    };


    // Java标准库提供了动态代理功能，允许在运行期动态创建一个接口的实例；
    // invocationHandler 代理被调用的接口方法
    Hello hello = (Hello) Proxy.newProxyInstance(
        Hello.class.getClassLoader(), // 传入ClassLoader
        new Class[] { Hello.class }, // 传入要实现的接口
        handler // 传入处理调用方法的InvocationHandler
    );
    hello.morning("Bob");
  }
}
