package org.example.dp;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
  List<String> res = new ArrayList<>();

  private void search(int nLeft, int nRight, String current) {
    if (nLeft == 0 && nRight == 0) {
      res.add(current);
    }
    if (nRight < nLeft) {
      return;
    }
    if (nLeft > 0) search(nLeft - 1, nRight, current + "(");
    if (nRight > 0) search(nLeft, nRight - 1, current + ")");
  }

  public List<String> generateParenthesis(int n) {
    search(n, n, "");
    return this.res;
  }

  public static void main(String[] args) {
    GenerateParentheses generateParentheses = new GenerateParentheses();
    List<String> res = generateParentheses.generateParenthesis(3);
    for (int i = 0; i < res.size(); i++) {
      System.out.println(res.get(i));
    }
  }
}
