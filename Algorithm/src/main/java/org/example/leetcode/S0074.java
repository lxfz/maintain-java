package org.example.leetcode;

public class S0074{

  public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    int m = matrix.length;
    int n = matrix[0].length;

    int mid = m/2;
    int ll = 0, h = m;

    while(ll < h){
      if(target<matrix[mid][0]) h = mid-1;
      else if (target > matrix[mid][0]) ll = mid+1;
      else return true;
      mid = (ll + h) / 2;
    }

    int l = 0; h = n;
    mid = n / 2;
    while(l < h) {
      if(target<matrix[ll][mid]) h = mid-1;
      else if (target > matrix[ll][mid]) l = mid + 1 ;
      else return true;
      mid = (l + h) / 2;
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] matrix = {
      {1,   3,  5,  7},
      {10, 11, 16, 20},
      {23, 30, 34, 50}
    };

    boolean result = new S0074().searchMatrix(matrix, 3);
    System.out.println(result);


  }
}