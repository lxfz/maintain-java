package org.example;

public class TestLambda {
  public static void main(String[] args) {
   ILike like = (A)->{
     System.out.println(A +  "I like lambda.");
    };

   like.lambda("A");
  }
}

// 函数式接口
interface ILike{
  void lambda(String name);
}
