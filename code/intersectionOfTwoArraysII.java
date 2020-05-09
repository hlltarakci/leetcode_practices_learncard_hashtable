// https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1178/

class Solution {
    /*
        m, n: array lens
        time: O(m log m + n log n) 
        space: O(1)
    */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i1 = 0, i2 = 0, i=0;
        while(i1 < nums1.length && i2 < nums2.length) {
            if(nums1[i1] == nums2[i2]) {
                nums1[i++] = nums1[i1];
                i1++;
                i2++;
            } 
            else if(nums1[i1] < nums2[i2]) i1++;
            else i2++;
        }
        
        return Arrays.copyOfRange(nums1, 0, i);
    }
    
}
