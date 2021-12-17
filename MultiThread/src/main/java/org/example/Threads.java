package org.example;


// 继承Thread, 重写run方法，调用start开启线程
class ThreadTest extends Thread {
  private final int step;

  public ThreadTest(int step) {
    this.step = step;
  }

  @Override
  public void run() {
    for (int i = 0; i < this.step; i++) {
      System.out.println("Thread : " + i);
    }
  }
}


public class Threads {
  // Thread 类实现了 Runnable接口
  // Callable接口是在工作三到五年后的重点
  public static void main(String[] args) {
    ThreadTest threadTest = new ThreadTest(2000);
    threadTest.start();
    for (int i = 0; i < 200; i++) {
      System.out.println("Main : " + i);
    }
  }
}

