package org.example;

// 通过Runnable接口的实现类启动线程
class RunnableImpl implements Runnable {
  private final int step;
  public RunnableImpl(int step) {
    this.step = step;
  }

  @Override
  public void run() {
    for (int i = 0; i < this.step; i++) {
      System.out.println("Thread : " + i);
    }
  }
}


public class Runnables {
  public static void main(String[] args) {
    new  Thread(new RunnableImpl(2000)).start();
    for (int i = 0; i < 200; i++) {
      System.out.println("Main : " + i);
    }
  }
}