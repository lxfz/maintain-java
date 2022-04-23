package com.xiaofei.spring;

//
public class BeanDefinition {

  private Class type; // Bean 的类型
  private String scope;

  public Class getType() {
    return type;
  }

  public void setType(Class type) {
    this.type = type;
  }

  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }
}
