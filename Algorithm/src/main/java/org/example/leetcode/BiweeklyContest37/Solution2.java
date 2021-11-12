package org.example.leetcode.BiweeklyContest37;

public class Solution2 {

  public int[] bestCoordinate(int[][] towers, int radius) {
    int x = 0, y = 0;
    int maxX = 0, maxY = 0;
    double d = 0.0;
    int maxQuality = 0;
    int quality = 0;
    for(int i=0; i<towers.length; i++) {
      maxX = Math.max(maxX, towers[i][0]);
      maxY = Math.max(maxY, towers[i][1]);
    }
    // System.out.println(maxX + " " + maxY);
    for(int i=0; i<=maxX; i++) {
      for(int j=0; j<=maxY; j++) {
        quality = 0;
        for(int k=0; k<towers.length; k++) {
          d = Math.sqrt((towers[k][0] - i)*(towers[k][0] -i) + (towers[k][1]-j)*(towers[k][1]-j));
          quality += d > radius ? 0 : (int)(towers[k][2] / (1+d));
        }
        if(quality > maxQuality) {
          x = i;
          y = j;
          maxQuality = quality;
        }
      }
    }
    int[] ans = {x, y};
    return ans;
  }


  public static void main(String[] args) {
    int[][] towers = {{1,2,5},{2,1,7},{3,1,9}};
    int radius = 2;
    int[] ans = new Solution2().bestCoordinate(towers, radius);
    System.out.println(ans[0] + " " + ans[1]);
  }
  
}
