// https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1105/

class Solution {
    /*
        l: length of larger array
        s: length of smaller array
        time: O(l log l + s log l) -- sort larger array, binary search looping smaller array
        space: O(s) -- intersection set
    */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        Set<Integer> set = new HashSet<>();
        int[] larger = nums1.length >= nums2.length ? nums1 : nums2;
        int[] smaller = nums1.length >= nums2.length ? nums2 : nums1;
        Arrays.sort(larger);
        
        for(int num: smaller) {
            if( Arrays.binarySearch(larger, num) >= 0) 
                set.add(num);
        }
        
        return convert(set);
    }
    
    private int[] convert(Set<Integer> set) {
        int[] arr = new int[set.size()];
        int index = 0;
        for(int num: set) 
            arr[index++] = num;
        
        return arr;
    }
}
