package org.example.baidu;

import java.util.Scanner;

public class AcrossTheGalaxy {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();

    int[][] cor = new int[k+2][2];
    for(int i=1; i<=k; i++) {
      cor[i][0] = in.nextInt();
      cor[i][1] = in.nextInt();
    }
    cor[k+1][0] = n;
    cor[k+1][1] = m;

    double ans = Double.MAX_VALUE;
    double dis = 0.0F;
    for(int i=0; i<cor.length; i++) {
      for(int j=i+1; j<cor.length; j++) {
        dis = Math.sqrt( Math.pow(cor[i][0]-cor[j][0], 2) + Math.pow(cor[i][1] - cor[j][1], 2));
        ans = Double.min(ans, dis);
      }
    }
    System.out.printf("%.4f", ans/2);
  }
}
