package org.example.factory.method;

public class NioFactory implements Factory{
  @Override
  public Car getCar() {
    return new Nio();
  }
}
