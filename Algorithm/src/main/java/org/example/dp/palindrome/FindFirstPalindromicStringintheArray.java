package org.example.dp.palindrome;

public class FindFirstPalindromicStringintheArray {
    
    public boolean isPalindrome(String s) {
        int i =0; 
        int j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public String firstPalindrome(String[] words) {
        for(String word: words) {
            if(isPalindrome(word)) return word;
        }
        return "";
    } 
}
