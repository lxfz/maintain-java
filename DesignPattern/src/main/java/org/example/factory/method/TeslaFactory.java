package org.example.factory.method;

public class TeslaFactory implements Factory{
  @Override
  public Car getCar() {
    return new Tesla();
  }
}
