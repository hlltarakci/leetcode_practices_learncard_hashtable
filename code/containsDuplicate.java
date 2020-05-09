// https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1112/

class Solution {
    /*
        n: arr len
        time: O(n)
        space: O(n)
    */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            if(set.contains(num)) return true;
            set.add(num);
        }
        
        return false;
    }
}
