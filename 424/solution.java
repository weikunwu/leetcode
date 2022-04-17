// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

// Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

// Example 1:

// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.
// Example 2:

// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
 

// Constraints:

// 1 <= s.length <= 105
// s consists of only uppercase English letters.
// 0 <= k <= s.length

class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int max = 0;
        
        Integer[] count = new Integer[26];
        Arrays.fill(count, 0);
        
        while (r < s.length()) {
            Character curC = s.charAt(r);
            count[curC - 'A']++;
            int maxCLength = max(count);
            if (r - l + 1 - maxCLength <= k) {
                max = Math.max(r - l + 1, max);
                r++;
            } else {
                Character leftC = s.charAt(l);
                count[curC- 'A']--;
                count[leftC - 'A']--;
                l++;
            }
        }
        return max;
    }
    
    private int max(Integer[] counts) {
        int max = 0;
        for (int count:counts) {
            max = Math.max(max, count);
        }
        return max;
    }
}