// https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1124/

class Solution {
    /*
        n: string arr length
        s: average string len
        time: O(n s log s)
        space: O(n s)
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        if(strs == null) return results;
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str: strs) {
            String key = getKey(str);
            List<String> values = map.getOrDefault(key, new ArrayList<String>());
            values.add(str);
            map.put(key, values);
        }
        
        for(List<String> values: map.values())
            results.add(values);
        
        return results;
    }
    
    private String getKey(String str) {
        char[] strArr = str.toCharArray();
        Arrays.sort(strArr);
        return new String(strArr);
    }
}
