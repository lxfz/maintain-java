package org.example.median;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

  private PriorityQueue<Integer> queueMin;
  private PriorityQueue<Integer> queueMax;

  public MedianFinder() {
    queueMin = new PriorityQueue<>((x, y) -> (y - x));
    queueMax = new PriorityQueue<>((x, y) -> (x - y));
  }

  public void addNum(int num) {
    if (queueMin.isEmpty() || num <= queueMin.peek()) {
      queueMin.offer(num);
      if (queueMin.size() - 1 > queueMax.size()) {
        queueMax.offer(queueMin.poll());
      }
    } else {  // num > queueMin.peek
      queueMax.offer(num);
      if (queueMax.size() > queueMin.size()) {
        queueMin.offer(queueMax.poll());
      }
    }
  }

  public double findMedian() {
    if (queueMin.size() > queueMax.size()) {
      return queueMin.peek();
    } else {
      return (queueMin.peek() + queueMax.peek()) / 2.0;
    }
  }
}

public class FindMedianFromDataStream {
  public static void main(String[] args) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1 - o2;
      }
    });
    queue.offer(2);
    queue.offer(1);
    System.out.println(Arrays.toString(queue.toArray()));
  }
}
