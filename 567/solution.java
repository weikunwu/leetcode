// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

// In other words, return true if one of s1's permutations is the substring of s2.

 

// Example 1:

// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").
// Example 2:

// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false
 

// Constraints:

// 1 <= s1.length, s2.length <= 104
// s1 and s2 consist of lowercase English letters.

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] count = new int[26];
        Arrays.fill(count, 0);
        int[] des = new int[26];
        Arrays.fill(des, 0);
        for (char c:s1.toCharArray()) {
            des[c - 'a']++;
        }
        for (int i = 0; i < s1.length() ; i++) {
            count[s2.charAt(i) - 'a']++;
        }
        if (equals(des, count)) {
            return true;
        }
        for (int i = 1; i <= s2.length() - s1.length(); i++) {
            char start = s2.charAt(i - 1);
            char end = s2.charAt(s1.length() + i - 1);
            count[end-'a']++;
            count[start-'a']--;
            if (equals(des, count)) {
                return true;
            }
        }
        return false;
    }
    private boolean equals(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}