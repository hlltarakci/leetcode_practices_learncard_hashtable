// https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1176/

class Solution {
    /*
        n: arr len
        time: O(n)
        space: O(1)
    */
    public int singleNumber(int[] nums) {
        int single = 0;
        for(int num: nums) single ^= num;
        
        return single;
    }
}
