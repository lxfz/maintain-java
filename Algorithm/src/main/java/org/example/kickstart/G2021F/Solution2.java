package org.example.kickstart.G2021F;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Solution2 {
  public static List<PriorityQueue<Long>> a = new ArrayList<>();

  public static long solve(long d, long n, long k) {
    long ans = 0;
    long cnt = 0;
    long tempAns = 0;
    for(int i=0; i<d; i++) {
      tempAns = 0;
      cnt = 0;
      PriorityQueue<Long> maxHeap = a.get(i);
      while(!maxHeap.isEmpty() && cnt < k) {
        tempAns +=  maxHeap.poll();
        cnt++;
      }
      ans = Math.max(ans, tempAns);
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int d, n, k;
    long h;
    int b, e;
    for(long i=0; i<3*100000; i++) {
      PriorityQueue<Long> maxHeap = new PriorityQueue<>(new Comparator<Long>(){
        @Override
        public int compare(Long i1,Long i2){
            return (int)(i2-i1);
        }});
      a.add(maxHeap);
    }

    for (long i = 1; i <= t; ++i) {
      in.nextLine();
      d = in.nextInt();
      n = in.nextInt();
      k = in.nextInt();

      for(long ii=a.size(); ii<d; ii++) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(new Comparator<Long>(){
          @Override
          public int compare(Long i1,Long i2){
              return (int)(i2-i1);
          }});
        a.add(maxHeap);
      }

      for(int j=0; j<d; j++) {
        PriorityQueue<Long> maxHeap = a.get(j);
        maxHeap.clear();
      }

      for(int j=0; j<n; j++) {
        in.nextLine();
        h = in.nextInt();
        b = in.nextInt();
        e = in.nextInt();
        for(int y=b; y<=e; y++) {
          PriorityQueue<Long> maxHeap = a.get(y);
          maxHeap.add(h);
        }
      }
      System.out.println("Case #" + i + ": " + solve(d, n, k));
    }
  } 
}
