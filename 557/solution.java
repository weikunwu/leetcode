// Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 

// Example 1:

// Input: s = "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
// Example 2:

// Input: s = "God Ding"
// Output: "doG gniD"
 

// Constraints:

// 1 <= s.length <= 5 * 104
// s contains printable ASCII characters.
// s does not contain any leading or trailing spaces.
// There is at least one word in s.
// All the words in s are separated by a single space.

class Solution {
    public String reverseWords(String s) {
        String[] res = s.split(" ");
        for (int i = 0; i < res.length; i++) {
            res[i] = reverse(res[i]);
        }
        return String.join(" ", res);
    }
    
    private String reverse(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < str.length() / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[str.length() - i - 1];
            arr[str.length() - i - 1] = temp;
        }
        return new String(arr);
    }
}