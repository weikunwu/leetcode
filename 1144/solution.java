// Given an array nums of integers, a move consists of choosing any element and decreasing it by 1.

// An array A is a zigzag array if either:

// Every even-indexed element is greater than adjacent elements, ie. A[0] > A[1] < A[2] > A[3] < A[4] > ...
// OR, every odd-indexed element is greater than adjacent elements, ie. A[0] < A[1] > A[2] < A[3] > A[4] < ...
// Return the minimum number of moves to transform the given array nums into a zigzag array.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: 2
// Explanation: We can decrease 2 to 0 or 3 to 1.
// Example 2:

// Input: nums = [9,6,1,6,2]
// Output: 4
 

// Constraints:

// 1 <= nums.length <= 1000
// 1 <= nums[i] <= 1000

class Solution {
    public int movesToMakeZigzag(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int countEven = 0;
        for (int i = 1; i < nums.length; i=i+2) {
            int min;
            if (i + 1 < nums.length) {
                min = Math.min(nums[i - 1], nums[i + 1]);
            } else {
                min = nums[i - 1];
            }
            if (nums[i] >= min) {
                countEven += nums[i] - min + 1;
            }
        }
        int countOdd = 0;
        for (int i = 0; i < nums.length; i=i+2) {
            int min;
            if (i - 1 >= 0 && i + 1 < nums.length) {
                min = Math.min(nums[i - 1], nums[i + 1]);
            } else if (i - 1 >= 0) {
                min = nums[i - 1];
            } else {
                min = nums[i + 1];
            }
            if (nums[i] >= min) {
                countOdd += nums[i] - min + 1;
            }
        }
        return Math.min(countEven, countOdd);
    }
}