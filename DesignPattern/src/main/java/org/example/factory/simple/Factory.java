package org.example.factory.simple;

public class Factory {
  public static Car getCar(String name){
    if(name.equals("nio")) {
      return new Nio();
    } else if (name.equals("tesla")) {
      return new Tesla();
    }
    return null;
  }
  // 工厂方法模式扩张性比较强
  // 不符合开闭原则，每次增加新的产品都需要修改factory
  // 但是在实际业务中使用的比较多
}
