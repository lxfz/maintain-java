package org.example.RWTH.R20220620_DFS;

public class WordSearch {

  public boolean dfs(char[][] board, boolean[][] visited, String word, StringBuilder current, int i, int j) {
    if (visited[i][j] || word.charAt(current.length()) != board[i][j]) {
      return false;
    }
    current.append(board[i][j]);
    visited[i][j] = true;
    boolean res = false;

    if (current.length() == word.length()) {
      res = word.equals(current.toString());
      current.deleteCharAt(current.length() - 1);
      visited[i][j] = false;
      return res;
    }

    if (i - 1 >= 0) res = dfs(board, visited, word, current, i - 1, j);
    if (i + 1 < board.length) res = res || dfs(board, visited, word, current, i + 1, j);
    if (j - 1 >= 0) res = res || dfs(board, visited, word, current, i, j - 1);
    if (j + 1 < board[0].length) res = res || dfs(board, visited, word, current, i, j + 1);

    current.deleteCharAt(current.length() - 1);
    visited[i][j] = false;
    return res;
  }

  public boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    if (m * n < word.length()) {
      return false;
    }
    boolean res = false;
    boolean[][] visited = new boolean[m][n];
    StringBuilder current = new StringBuilder();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        res = dfs(board, visited, word, current, i, j);
        if (res) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    String word = "ABCB";
    WordSearch wordSearch = new WordSearch();
    System.out.println(wordSearch.exist(board, word));
  }
}
