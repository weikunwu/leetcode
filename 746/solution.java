// You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

// You can either start from the step with index 0, or the step with index 1.

// Return the minimum cost to reach the top of the floor.

 

// Example 1:

// Input: cost = [10,15,20]
// Output: 15
// Explanation: You will start at index 1.
// - Pay 15 and climb two steps to reach the top.
// The total cost is 15.
// Example 2:

// Input: cost = [1,100,1,1,1,100,1,1,100,1]
// Output: 6
// Explanation: You will start at index 0.
// - Pay 1 and climb two steps to reach index 2.
// - Pay 1 and climb two steps to reach index 4.
// - Pay 1 and climb two steps to reach index 6.
// - Pay 1 and climb one step to reach index 7.
// - Pay 1 and climb two steps to reach index 9.
// - Pay 1 and climb one step to reach the top.
// The total cost is 6.
 

// Constraints:

// 2 <= cost.length <= 1000
// 0 <= cost[i] <= 999

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] mem = new int[cost.length];
        Arrays.fill(mem, -1);
        return Math.min(minMem(0, cost, mem), minMem(1, cost, mem));
    }
    private int minMem(int i, int[] cost, int[] mem) {
        if (mem[i] != -1) {
            return mem[i];
        }
        int n = cost.length;
        if (n - i - 1 <= 1) {
            mem[i] = cost[i];
            return mem[i];
        }
        mem[i] = cost[i] + Math.min(minMem(i + 2, cost, mem), minMem(i + 1, cost, mem));
        return mem[i];
    }
}