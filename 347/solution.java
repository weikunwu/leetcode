// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]
 

// Constraints:

// 1 <= nums.length <= 105
// k is in the range [1, the number of unique elements in the array].
// It is guaranteed that the answer is unique.

class Solution {
    public int[] topKFrequent(int[] nums, int k) {        
        HashMap<Integer, Integer> freqMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (freqMap.containsKey(num)) {
                freqMap.put(num, freqMap.get(num) + 1);
            } else {
                freqMap.put(num, 1);
            }
        }
        PriorityQueue <Integer> pq = new PriorityQueue((o1, o2) -> freqMap.get(o2) - freqMap.get(o1));
        for (int num:nums) {
            if (!pq.contains(num)) {
                pq.add(num);
            }
        }
        int freq = nums.length;
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}