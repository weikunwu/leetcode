// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.

 

// Example 1:

// Input: nums = [1,1,1], k = 2
// Output: 2
// Example 2:

// Input: nums = [1,2,3], k = 3
// Output: 2
 

// Constraints:

// 1 <= nums.length <= 2 * 104
// -1000 <= nums[i] <= 1000
// -107 <= k <= 107

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        
        count.put(0, 1);
        
        int sum = 0;
        int res = 0;
        for (int num:nums) {
            sum += num;
            int diff = sum - k;
            if (count.containsKey(diff)) {
                res += count.get(diff);
            }
            if (!count.containsKey(sum)) {
                count.put(sum, 1);
            } else {
                count.put(sum, count.get(sum) + 1);
            }
        }
        return res;
    }
}