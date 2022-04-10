// An additive number is a string whose digits can form an additive sequence.

// A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

// Given a string containing only digits, return true if it is an additive number or false otherwise.

// Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

 

// Example 1:

// Input: "112358"
// Output: true
// Explanation: 
// The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
// 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
// Example 2:

// Input: "199100199"
// Output: true
// Explanation: 
// The additive sequence is: 1, 99, 100, 199. 
// 1 + 99 = 100, 99 + 100 = 199
 

// Constraints:

// 1 <= num.length <= 35
// num consists only of digits.

class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(0) == '0' && i > 1) {
                return false;
            }
            Long first = Long.valueOf(num.substring(0, i));
            for (int j = 1; num.length() - i - j > 0; j++) {
                if (num.charAt(i) == '0' && j > 1) {
                    break;
                }
                Long second = Long.valueOf(num.substring(i, i + j));
                if (isValid(first, second, num, i + j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isValid(Long first, Long second, String arr, int index) {
        if (index == arr.length()) {
            return true;
        }
        Long third = first + second;
        first = second;
        second = third;
        String sum = Long.toString(second);
        return arr.startsWith(sum, index) && isValid(first, second, arr, index + sum.length());
    }
}