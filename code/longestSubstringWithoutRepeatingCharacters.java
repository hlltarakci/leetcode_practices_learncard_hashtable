// https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1135/

class Solution {
    /*
        s: str len
        time: O(s)
        space: O(s)
    */
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        Map<Character, Integer> map = new HashMap<>();
        
        int index = 0, maxLen = 0, subIndex = 0;
        while(index < s.length()) {
            char c = s.charAt(index);
            if(map.containsKey(c) && map.get(c) >= subIndex) subIndex = map.get(c) + 1;
            
            map.put(c, index);
            index++;
            maxLen = Math.max(maxLen, index-subIndex);
        }
        
        return maxLen;
    }
}
