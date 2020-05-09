// https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1177/

class Solution {
    /*
        m, n : list lengths
        time: O(m + n)
        s : average string length
        space: O(m * s) -- could be improved to O(min(m, n) * s) by choosing smaller list first
    */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = populateMap(list1);
        
        int minIndexSum = Integer.MAX_VALUE, index = 0;
        for(int i=0; i<list2.length; i++) {
            if(!map.containsKey(list2[i])) continue;
            
            int indexSum = i + map.get(list2[i]);
            
            if(minIndexSum < indexSum) continue;
            
            if(minIndexSum > indexSum) {
                index = 0;
                minIndexSum = indexSum;
            }
            
            list1[index++] = list2[i];
        }
        
        return Arrays.copyOfRange(list1, 0, index);
        
    }
    
    private Map<String, Integer> populateMap(String[] list) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<list.length; i++) 
            map.put(list[i], i);
        
        return map;
    }
    
}
