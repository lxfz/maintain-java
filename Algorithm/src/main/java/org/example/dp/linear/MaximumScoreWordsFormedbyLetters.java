package org.example.dp.linear;

import java.util.Arrays;

public class MaximumScoreWordsFormedbyLetters {
    public int maxScoreWords_do_not_use_dp_if_two_difficult(String[] words, char[] letters, int[] score) {
        int[] scoreOfWords = new int[words.length];
        int[][] letterCountsOfWords = new int[words.length][26];
        int[] givenLetterCounts = new int[26];
        int[][] letterUsed = new int[words.length + 1][26];
        boolean[] canFormed = new boolean[words.length];

        // given letter counts
        for (char c : letters) {
            givenLetterCounts[c - 'a']++;
        }

        // score of words
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                letterCountsOfWords[i][c - 'a']++;
            }

            int tempScore = 0;
            boolean formed = true;
            for (int j = 0; j < 26; j++) {
                if (givenLetterCounts[j] >= letterCountsOfWords[i][j]) {
                    tempScore += letterCountsOfWords[i][j] * score['a' + j];
                } else {
                    formed = false;
                    break;
                }
            }
            if (formed) {
                scoreOfWords[i] = tempScore;
            }
            canFormed[i] = formed;
        }

        int[] dp = new int[words.length + 1]; // 到第i个单词时能获得的最大分数

        for (int i = 1; i <= words.length; i++) {
            for (int j = i - 1; j >= 0; j--) {

                // if letterUsed[j] + letterCountsOfWords[i] <= givenLetterCounts
                boolean contribute = true;
                for(int k=0; k<26; k++) {
                    if(letterUsed[j][k] + letterCountsOfWords[i-1][k] > givenLetterCounts[k]) {
                        contribute = false;
                    }
                }
                if(contribute && dp[i] < 0) { // 这里有问题，如果构建的时候分数相同怎么办？？？
                    dp[i] = Math.max(dp[i], dp[j] + scoreOfWords[i]);

                }


                // letterUsed[i] = letterUsed[j] + letterCountsOfWords[i]
            }

            // 不参与构建
            if(dp[i] < dp[i-1]) {
                dp[i] = dp[i-1];
                for(int k=0; k<26; k++) {
                    letterUsed[i][k] = letterUsed[i-1][k];
                }
            }
        }
        return 0;
    }


    public int getScore(String word, int[] givenLetterCounts, int[] score) {
        int sum = 0;
        int[] letterCounts = new int[26];

        for(char c : word.toCharArray()) {
            letterCounts[c - 'a']++;
            sum += score[c - 'a'];
            if(letterCounts[c - 'a'] > givenLetterCounts[c - 'a']) {
                return 0 ;
            }
        }
        return sum;
    }
        
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int len = words.length;
        int maxScore = 0;
        int[] givenLetterCounts = new int[26];
        for(char c : letters) {
            givenLetterCounts[c - 'a']++;
        }
        for(int i=0; i< 1 << len; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int j=0; j< len; j++) {
                if((i & (1 << j)) != 0) {
                    stringBuilder.append(words[j]);
                }
            }
            maxScore = Math.max(maxScore, getScore(stringBuilder.toString(), givenLetterCounts, score));
        }

        return maxScore;
    }


}
