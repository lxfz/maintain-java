package org.example;

public class ShareVariable {


    static Counter counter = new Counter();

    public static void main(String[] args) throws Exception {
      AddThread add = new AddThread();
      DecThread dec = new DecThread();
      add.start();
      dec.start();
      add.join();
      dec.join();
      System.out.println(counter.count);
    }

  static class Counter {
    public int count = 0;


    public void inc() {
      count++;
    }

    public void dec() {
      count--;
    }


  }

  static class AddThread extends Thread {
    public void run() {
      for (int i=0; i<10000; i++) { counter.inc(); }
    }
  }

  static class DecThread extends Thread {
    public void run() {
      for (int i=0; i<10000; i++) { counter.dec();  }
    }
  }

}
