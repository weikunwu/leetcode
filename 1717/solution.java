// You are given a string s and two integers x and y. You can perform two types of operations any number of times.

// Remove substring "ab" and gain x points.
// For example, when removing "ab" from "cabxbae" it becomes "cxbae".
// Remove substring "ba" and gain y points.
// For example, when removing "ba" from "cabxbae" it becomes "cabxe".
// Return the maximum points you can gain after applying the above operations on s.

 

// Example 1:

// Input: s = "cdbcbbaaabab", x = 4, y = 5
// Output: 19
// Explanation:
// - Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
// - Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
// - Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
// - Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
// Total score = 5 + 4 + 5 + 5 = 19.
// Example 2:

// Input: s = "aabbaaxybbaabb", x = 5, y = 4
// Output: 20
 

// Constraints:

// 1 <= s.length <= 105
// 1 <= x, y <= 104
// s consists of lowercase English letters.

class Solution {
    public int maximumGain(String s, int x, int y) {
        int big = x > y ? x : y;
        int small = big == x ? y : x;
        char first = big == x ? 'a' : 'b';
        char second = first == 'a' ? 'b' : 'a';
        int pt = 0;
        Stack<Character> stk1 = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == second && !stk1.isEmpty() && stk1.peek() == first) {
                stk1.pop();
                pt += big;
            } else {
                stk1.push(c);
            }
            
        }
        Stack<Character> stk2 = new Stack<>();
        while (!stk1.isEmpty()) {
            char c = stk1.pop();
            if (c == second && !stk2.isEmpty() && stk2.peek() == first) {
                stk2.pop();
                pt += small;
            } else {
                stk2.push(c);
            }
        }
        return pt;
    }
}