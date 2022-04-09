class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        int minVal = nums[0];
        for (int num:nums) {
            minVal = Math.min(minVal, num);
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = minVal;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int index = (i+j) % nums.length;
                int val = nums[index];
                if (nums[i] < val) {
                    result[i] = val;
                    break;
                }
            }
            if (result[i] == minVal) {
                result[i] = -1;
            }
        }
        return result;
    }
}