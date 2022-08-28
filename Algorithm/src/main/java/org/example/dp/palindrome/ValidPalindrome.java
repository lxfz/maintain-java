package org.example.dp.palindrome;

public class ValidPalindrome {
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')){
                stringBuilder.append(s.charAt(i));
            }
        }
        return isPalindrome(stringBuilder.toString(), 0, stringBuilder.length()-1);
    }

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();
        String s = "0P";
        System.out.println(solution.isPalindrome(s));
    }
}
