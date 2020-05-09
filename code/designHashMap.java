// https://leetcode.com/explore/learn/card/hash-table/182/practical-applications/1140/

class MyHashMap {
    class Entry {
        public int key;
        public int value;
        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    class Bucket {
        public List<Entry> entries = new LinkedList<>();
        
        public Bucket(List<Entry> entries) {
            this.entries = entries;
        }
        
        public void addOrUpdate(int key, int value) {
            for(Entry entry: entries) {
                if(entry.key == key) {
                    entry.value = value;
                    return;
                }
            }
            
            entries.add(new Entry(key, value));
        }
        
        public int get(int key) {
            for(Entry entry: entries) {
                if(entry.key == key) 
                    return entry.value;
            }
            
            return -1;
        }
        
        public void removeIfExists(int key) {
            for(Entry entry: entries) {
                if(entry.key == key) {
                    entries.remove(entry);
                    return;
                }     
            }
        }
        
    }
    
    Bucket[] hashtable;
    int CAPACITY = 100;

    /** Initialize your data structure here. */
    public MyHashMap() {
        hashtable = new Bucket[CAPACITY];
        for(int i=0; i<hashtable.length; i++) 
            hashtable[i] = new Bucket(new LinkedList<>());
    }
    
    private int hash(int key) {
        return key % CAPACITY;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        hashtable[hash(key)].addOrUpdate(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return hashtable[hash(key)].get(key);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hashtable[hash(key)].removeIfExists(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
