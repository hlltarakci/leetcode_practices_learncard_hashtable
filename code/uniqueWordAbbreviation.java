// https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1137/

class ValidWordAbbr {
    /*
        time: O(len of dict)
        space: O(len of dict * average word len)
    */
    
    Map<String, Integer> map; 
    Set<String> set;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        set = new HashSet<>();
        for(String word: dictionary) {
            String key = getKey(word);
            if(!set.contains(key)) map.put(key, map.getOrDefault(key, 0) + 1); 
            set.add(word);
        }
    }
    
    private String getKey(String word) {
        if(word.length() < 3) return word;
        Integer mid = word.length()-2;
        return word.charAt(0) + mid.toString() + word.charAt(word.length()-1);
    }
    
    public boolean isUnique(String word) {
        String key = getKey(word);
        if(!map.containsKey(key)) return true;
        
        if(set.contains(word)) return map.get(key) == 1;
        
        return false;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
