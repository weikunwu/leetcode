// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
 

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "()[]{}"
// Output: true
// Example 3:

// Input: s = "(]"
// Output: false
 

// Constraints:

// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.

class Solution {
    public boolean isValid(String s) {
        Stack <Character> stk = new Stack<>();
        for (char c:s.toCharArray()) {
            if (c == ')' || c == '}' || c == ']') {
                if (stk.isEmpty()) {
                    return false;
                }
                char cur = stk.pop();
                if ( (c == ')' && cur != '(')
                   || (c == '}' && cur != '{')
                   || (c == ']' && cur != '[')) {
                    return false;
                }
            } else {
                stk.push(c);
            }
        }
        return stk.isEmpty();
    }
}