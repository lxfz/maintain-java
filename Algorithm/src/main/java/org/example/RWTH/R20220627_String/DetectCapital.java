package org.example.RWTH.R20220627_String;

public class DetectCapital {
  public boolean detectCapitalUse(String word) {
    boolean allLowercase = true;
    boolean allUppercase = true;
    char c;
    for (int i = 1; i < word.length(); i++) {
      c = word.charAt(i);
      if (c >= 'a' && c <= 'z') {
        allUppercase = false;
      }
      if (c >= 'A' && c <= 'Z') {
        allLowercase = false;
      }
    }

    c = word.charAt(0);
    return allLowercase || (allUppercase && c >= 'A' && c <= 'Z');
  }
}
