// https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1131/

class Solution {
    /*
        time: O(log n) -- num of digits
        space: O(n) -- keeping sum results in set to detect cycle
    */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        while(n != 1) {
            int sum = sumDigits(n);
            if(set.contains(sum)) return false;
            
            set.add(sum);
            n = sum;
        } 
        
        return true;
    }
    
    private int sumDigits(int num) {
        int sum = 0;
        
        while(num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        
        return sum;
    }
}
