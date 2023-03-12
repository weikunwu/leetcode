// An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

// Given an integer n, return the nth ugly number.

 

// Example 1:

// Input: n = 10
// Output: 12
// Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
// Example 2:

// Input: n = 1
// Output: 1
// Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 

// Constraints:

// 1 <= n <= 1690

class Solution {
    public int nthUglyNumber(int n) {
        int[] mem = new int[n];
        Arrays.fill(mem, 1);
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(2 * mem[p1], 3 * mem[p2]);
            min = Math.min(min, 5 * mem[p3]);
            if (min == 2 * mem[p1]) {
                p1++;
            }
            if (min == 3 * mem[p2]) {
                p2++;
            }
            if (min == 5 * mem[p3]) {
                p3++;
            }
            mem[i] = min;
        }
        return mem[n - 1];
    }
}