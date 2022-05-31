// There is an integer array nums sorted in ascending order (with distinct values).

// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:

// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
// Example 3:

// Input: nums = [1], target = 0
// Output: -1
 

// Constraints:

// 1 <= nums.length <= 5000
// -104 <= nums[i] <= 104
// All values of nums are unique.
// nums is an ascending array that is possibly rotated.
// -104 <= target <= 104

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int k = (l + r) / 2;
        while (l <= r) {
            if (nums[k] >= nums[0]) {
                l = k + 1;
            } else {
                r = k - 1;
            }
            k = (l + r) / 2;
        }
        int offset = (k + 1) % n;
        l = 0;
        r = n - 1;
        int mid = (l + r) / 2;
        while (l <= r) {
            int num = nums[(offset + mid) % n];
            if (target > num) {
                l = mid + 1;
            } else if (target < num) {
                r = mid - 1;
            } else {
                return (offset + mid) % n;
            }
            mid = (l + r) / 2;
        }
        return -1;
    }
}



class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            
            // left sorted
            if (nums[l] <= nums[mid]) {
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[r]) {
                    r = mid - 1;
                } else {
                    l = l + 1;
                }
            }
        }
        return -1;
    }
}