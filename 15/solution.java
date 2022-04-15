// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

 

// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Example 2:

// Input: nums = []
// Output: []
// Example 3:

// Input: nums = [0]
// Output: []
 

// Constraints:

// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }

        }

        HashSet<String> set = new HashSet<>();
        List<List<Integer>> l = new ArrayList<>();
        for (int num1:map.keySet()) {
            int target = -num1;
            for (int num2:map.keySet()) {
                if (num2 == num1 && map.get(num1) < 2) {
                    continue;
                }
                int num3 = target - num2;
                if (map.containsKey(num3)) {
                    if (num3 == num2 && num3 == num1 && map.get(num3) < 3) {
                        continue;
                    }
                    if ((num3 == num2 || num3 == num1) && map.get(num3) < 2) {
                        continue;
                    }
                    List<Integer> list = new ArrayList();
                    int[] temp = new int[] {num1, num2, num3};
                    Arrays.sort(temp);
                    if (!set.contains(Arrays.toString(temp))) {
                        list.add(num1);
                        list.add(num2);
                        list.add(num3);
                        l.add(list);
                        set.add(Arrays.toString(temp));
                    }
                }
                
            }
        }
        return l;
    }
}