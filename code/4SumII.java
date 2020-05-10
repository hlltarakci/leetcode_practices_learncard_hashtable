// https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1134/

class Solution {
    /*
        n: arr leng (same for all)
        time: O(n)
        space: O(n^2)
    */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int a: A) {
            for (int b: B) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        for(int c: C) {
            for(int d: D) {
                int sum = c + d;
                int complement = 0 - sum;
                if(map.containsKey(complement)) count += map.get(complement);
            }
        }
        
        return count;
    }
}
