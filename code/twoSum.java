// https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1115/

class Solution {
    /*
        n: arr len
        time: O(n)
        space: O(n)
    */
    public int[] twoSum(int[] nums, int target) {
        if(nums == null) return new int[] {-1, -1};
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) return new int[] {map.get(complement), i};
            map.put(nums[i], i);
        }
        
        return new int[] {-1, -1};
    }
}
