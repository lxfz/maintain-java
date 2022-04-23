package com.xiaofei.service;

import com.xiaofei.spring.ApplicationContext;
import com.xiaofei.spring.Autowired;
import com.xiaofei.spring.BeanNameAware;
import com.xiaofei.spring.Component;
import com.xiaofei.spring.InitializingBean;
import com.xiaofei.spring.Scope;

@Component
public class UserService implements BeanNameAware, InitializingBean, UserInterface {

  @Autowired
  private OrderService orderService;


  private String beanName;

  private String xxx;

  public UserService() {
  }


  @Override
  public void test() {
    System.out.println(orderService);
  }

  // Spring的回调函数
  @Override
  public void setBeanName(String beanName) {
    this.beanName = beanName;
  }


  @Override
  public void afterPropertiesSet() {
    System.out.println("初始化方法");
  }
}
