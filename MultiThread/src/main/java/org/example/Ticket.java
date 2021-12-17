package org.example;

// 购买火车票：多个线程操作同一个资源
// 问题：线程不安全
public class Ticket implements Runnable{
  private int ticketNum = 10;
  @Override
  public void run() {
    while (true) {
      if (ticketNum <= 0) {
        break;
      }
      System.out.println(Thread.currentThread().getName() + "抢到了第" + ticketNum-- + "票");
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    Ticket ticket = new Ticket();
    new Thread(ticket, "A").start();
    new Thread(ticket, "B").start();
    new Thread(ticket, "C").start();
  }
}
