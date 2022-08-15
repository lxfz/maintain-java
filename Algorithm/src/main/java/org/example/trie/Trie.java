package org.example.trie;


class TrieNode {
  TrieNode[] children = new TrieNode[26];
  String word = null;
}

public class Trie {
  TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
      if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
      cur = cur.children[c - 'a'];
    }
    cur.word = word;
  }

  public boolean search(String word) {
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
      if (cur.children[c - 'a'] == null) return false;
      cur = cur.children[c - 'a'];
    }
    return cur.word != null;
  }

  public boolean startsWith(String prefix) {
    TrieNode cur = root;
    for (char c : prefix.toCharArray()) {
      if (cur.children[c - 'a'] == null) return false;
      cur = cur.children[c - 'a'];
    }
    return true;
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    System.out.println(trie.search("apple"));
  }
}
