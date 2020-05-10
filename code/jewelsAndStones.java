// https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1136/

class Solution {
    /*
        j, s : str lens
        time: O(j + s)
        space: O(j)
    */
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        
        for(char c: J.toCharArray()) set.add(c);
        
        int count = 0;
        for(char c: S.toCharArray()) {
            if(set.contains(c)) count++;
        }
        
        return count;
    }
}
