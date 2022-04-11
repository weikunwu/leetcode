// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

// Example 1:

// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".
// Example 2:

// Input: s = "applepenapple", wordDict = ["apple","pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
// Note that you are allowed to reuse a dictionary word.
// Example 3:

// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: false
 

// Constraints:

// 1 <= s.length <= 300
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 20
// s and wordDict[i] consist of only lowercase English letters.
// All the strings of wordDict are unique.

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        HashMap<String, Boolean> mem = new HashMap();
        for (String word : wordDict) {
            words.add(word);
        }
        return wordBreak(s, words, mem);
    }
    private boolean wordBreak(String s, Set<String> words, HashMap<String, Boolean> mem) {
        if (mem.get(s) != null) {
            return mem.get(s);
        }
        if (words.contains(s)) {
            mem.put(s, true);
            return true;
        }
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i, s.length());
            if (words.contains(right) && wordBreak(left, words, mem)) {
                mem.put(s, true);
                return true;
            }
        }
        mem.put(s,false);
        return false;
    }
}