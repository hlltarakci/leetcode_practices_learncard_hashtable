// https://leetcode.com/explore/learn/card/hash-table/182/practical-applications/1139/

class MyHashSet {
    class Entry {
        public List<Integer> entries;
        public Entry(List<Integer> entries) {
            this.entries = entries;
        }
    }

    Entry[] list;
    int CAPACITY = 1000;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        list = new Entry[CAPACITY];
    }
    
    private int hash(int key) {
        return key % CAPACITY;
    }
    
    public void add(int key) {
        List<Integer> keys = new ArrayList<>();
        if(list[hash(key)] != null) keys = list[hash(key)].entries;
        if(!keys.contains(key)) keys.add(key);
        list[hash(key)] = new Entry(keys);
    }
    
    public void remove(int key) {
        if(list[hash(key)] != null) {
            List<Integer> keys = list[hash(key)].entries;
            keys.remove((Integer)key);
            if(keys.size() == 0) keys = null;
            list[hash(key)] = keys == null ? null : new Entry(keys);
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(list[hash(key)] == null) return false;
        List<Integer> keys = list[hash(key)].entries;
        return keys.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
