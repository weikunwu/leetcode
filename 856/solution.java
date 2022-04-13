// Given a balanced parentheses string s, return the score of the string.

// The score of a balanced parentheses string is based on the following rule:

// "()" has score 1.
// AB has score A + B, where A and B are balanced parentheses strings.
// (A) has score 2 * A, where A is a balanced parentheses string.
 

// Example 1:

// Input: s = "()"
// Output: 1
// Example 2:

// Input: s = "(())"
// Output: 2
// Example 3:

// Input: s = "()()"
// Output: 2
 

// Constraints:

// 2 <= s.length <= 50
// s consists of only '(' and ')'.
// s is a balanced parentheses string.

class Solution {
    public int scoreOfParentheses(String s) {
        if (s.length() == 2) {
            return 1;
        }
        int b = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                b++;
            } else {
                b--;
            }
            if (b == 0) {
                if ( i != s.length() - 1 ) {
                    String lefts = s.substring(0,i + 1);
                    String rights = s.substring(i + 1, s.length());
                    return scoreOfParentheses(lefts) + scoreOfParentheses(rights);
                }
            }
        }
        return scoreOfParentheses(s.substring(1,s.length() - 1)) * 2; 
    }
}