// https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1126/

class Solution {
    /*
        time: O(1)
        space: O(1)
    */
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        
        for(int r=0; r<board.length; r++) {
            for(int c=0; c<board[0].length; c++) {
                if(board[r][c] == '.') continue;
                
                int box = (r / 3) * 3 + c / 3;
                
                String rowKey = "r" + r + "-" + board[r][c];
                String colKey = "c" + c + "-" + board[r][c];
                String boxKey = "b" + box + "-" + board[r][c];
                
                if(set.contains(rowKey)) return false;
                if(set.contains(colKey)) return false;
                if(set.contains(boxKey)) return false;
                
                set.add(rowKey);
                set.add(colKey);
                set.add(boxKey);
            }
        }
        
        return true;
    }
    
    
}
