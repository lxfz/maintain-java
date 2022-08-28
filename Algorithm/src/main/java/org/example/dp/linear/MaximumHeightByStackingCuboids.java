package org.example.dp.linear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumHeightByStackingCuboids {

  public List<int[]> getPermutation(int a, int b, int c) {
    List<int[]> res = new ArrayList<>();
    res.add(new int[]{a, b, c});
    res.add(new int[]{a, c, b});
    res.add(new int[]{b, a, c});
    res.add(new int[]{c, a, b});
    res.add(new int[]{b, c, a});
    res.add(new int[]{c, b, a});
    return res;
  }

  public int maxHeight(int[][] cuboids) {
    // width, length, height
    int len = cuboids.length;
    List<List<int[]>> shapes = new ArrayList<>();
    for (int[] cuboid : cuboids) {
      shapes.add(getPermutation(cuboid[0], cuboid[1], cuboid[2]));
    }
    int[][] heights = new int[len][6];


    int ans = Integer.MIN_VALUE;

    for (int i = 0; i < 6; i++) {
      heights[0][i] = Arrays.stream(shapes.get(0).get(i)).max().getAsInt();
      ans = Math.max(ans, heights[0][i]);
    }
    return 0;
  }

}
