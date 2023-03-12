// Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

// If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.

 

// Example 1:

// Input: s = "abcdefg", k = 2
// Output: "bacdfeg"
// Example 2:

// Input: s = "abcd", k = 2
// Output: "bacd"
 

// Constraints:

// 1 <= s.length <= 104
// s consists of only lowercase English letters.
// 1 <= k <= 104

class Solution {
    public String reverseStr(String s, int k) {
        char[] arr =s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (i % k == 0 && i / k % 2 == 0) {
                reverse(arr, i, Math.min(i + k, s.length()));
            }
        }
        return new String(arr);
    }
    private void reverse(char[] arr, int start, int end) {
        int size = end - start;
        for (int i = 0; i < size / 2; i++) {
            char temp = arr[start + i];
            arr[start + i] = arr[end - i - 1];
            arr[end - i - 1] = temp;
        }
    }
}