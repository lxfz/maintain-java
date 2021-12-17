package org.example.factory.method;

public class Main {

  public static void main(String[] args) {
    Car car = new TeslaFactory().getCar();
    car.name();
  }
}
