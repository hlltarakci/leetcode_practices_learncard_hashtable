// https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1121/

class Solution {
    /*
        n: arr len
        time: O(n)
        space: O( min(n, k)) 
    */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null) return false;
        
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++) {
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            
            if(set.size() > k) set.remove(nums[i-k]);
        }
        
        return false;
    }
}
