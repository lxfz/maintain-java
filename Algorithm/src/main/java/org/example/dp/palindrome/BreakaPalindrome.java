package org.example.dp.palindrome;

public class BreakaPalindrome {
    public String breakPalindrome(String palindrome) {
        int mid = palindrome.length() / 2;
        mid -= palindrome.length() % 2;
        if(palindrome.length() == 1) return "";
        char[] s = palindrome.toCharArray();
        for(int i=0; i<=mid; i++) {
            if(s[i] > 'a') {
                s[i] = 'a';
                return new String(s);
            }
        }
        s[s.length-1] += 1;
        return new String(s);
    }
}
