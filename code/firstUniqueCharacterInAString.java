// https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1120/

class Solution {
    /*
        s: string len
        time: O(s)
        space: O(s)
    */
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = prepFreqMap(s);
        
        for(int i=0; i<s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) return i;
        }
        
        return -1;
    }
    
    private Map<Character, Integer> prepFreqMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c: s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        return map;
    }
}
