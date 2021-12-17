package org.example.factory.simple;

public class Main {

  public static void main(String[] args) {
    Car car = Factory.getCar("tesla");
    car.name();
  }
}
