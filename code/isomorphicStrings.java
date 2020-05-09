// https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1117/

class Solution {
    /*
        n : str len
        time: O(n)
        space: O(n)
    */
    public boolean isIsomorphic(String s, String t) {
        if( s == null && t == null ) return true;
        if( s.length() != t.length() ) return false;
        
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            if(map1.containsKey(charS)) {
                if(charT != map1.get(charS)) return false;
            } 
            else {
                if(map2.containsKey(charT)) return false;
                map1.put(charS, charT);
                map2.put(charT, charS);
            }
        }
        
        return true;
    }
}
