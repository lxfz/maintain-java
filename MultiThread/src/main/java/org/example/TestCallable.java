package org.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallable implements Callable<Boolean> {
  private final int num;
  public TestCallable(int num) {
    this.num = num;
  }
  @Override
  public Boolean call() throws Exception {
    Thread.sleep(100);
    return this.num % 2 == 0;
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    TestCallable c1 = new TestCallable(3);
    TestCallable c2 = new TestCallable(8);
    TestCallable c3 = new TestCallable(332);

    // 1. 创建服务
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    // 2. 提交执行
    Future<Boolean>  r1 = executorService.submit(c1);
    Future<Boolean>  r2 = executorService.submit(c2);
    Future<Boolean>  r3 = executorService.submit(c3);

    // 3. 获取结果
    boolean rs1 = r1.get();
    boolean rs2 = r2.get();
    boolean rs3 = r3.get();

    System.out.println(rs1);
    System.out.println(rs2);
    System.out.println(rs3);

    // 4. 关闭服务
    executorService.shutdown();
  }
}
