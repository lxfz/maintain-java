package org.example.dp.palindrome;

public class RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        return s.equals(new StringBuilder(s).reverse().toString())? 1: 2;
    } 
}
