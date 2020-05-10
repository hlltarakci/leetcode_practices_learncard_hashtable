// https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1133/

class Solution {
    /*
        n: nums len
        time: O(n log k)
        space: O(n)
    */
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null) return null;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> map.get(a) - map.get(b));
        for(int key: map.keySet()) {
            heap.add(key);
            if (heap.size() > k) heap.remove();
        }
        
        int[] kfreq = new int[k];
        int index = 0;
        while(!heap.isEmpty()) 
             kfreq[index++] = heap.remove();
        
        return kfreq;
    }
}
