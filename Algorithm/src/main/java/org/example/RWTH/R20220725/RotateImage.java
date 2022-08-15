package org.example.RWTH.R20220725;

public class RotateImage {

  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i <= n / 2; i++) {
      for (int j = i; j <= n - i - 2; j++) {
        int startx = i, starty = j;
        int nextx = starty, nexty = n-1-startx;
        int unplacedValue = matrix[startx][starty];
        do {
          int tempValue = matrix[nextx][nexty];
          matrix[nextx][nexty] = unplacedValue;
          unplacedValue = tempValue;

          int currenty = nexty;
          nextx = nexty;
          nexty = n - 1 - currenty;
        } while (nextx != startx || nexty != starty);
        matrix[startx][starty] = unplacedValue;
      }
    }
  }

  public static void main(String[] args) {
    RotateImage rotateImage = new RotateImage();
    int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
    rotateImage.rotate(m);
  }
}
