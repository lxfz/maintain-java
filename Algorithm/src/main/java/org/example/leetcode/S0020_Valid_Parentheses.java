package org.example.leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class S0020_Valid_Parentheses {


    public boolean isValid(String s) {
        char[] sarr = s.toCharArray();
        Stack<Character> queue = new Stack<>();
        Map<Character, Character> m = new HashMap<>();
        m.put('(', ')');
        m.put('[', ']');
        m.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            if (sarr[i] == '(' || sarr[i] == '[' || sarr[i] == '{') {
                queue.push(sarr[i]);
            } else {
                if (queue.size() == 0) {
                    return false;
                }
                char c = queue.pop();
                if (m.get(c) != sarr[i]) {
                    return false;
                }
            }
        }
        if (queue.size() != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        S0020_Valid_Parentheses s = new S0020_Valid_Parentheses();
        String str = "([)]";
        System.out.println(s.isValid(str));

    }
}
