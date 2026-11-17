class MyHashMap {

    List<Entry>[] map;
    int defaultCapacity = 1000;

    public MyHashMap() {
        this.map = new LinkedList[defaultCapacity];
    }
    
    public void put(int key, int value) {
        int bucket = key % defaultCapacity;
        if(this.map[bucket] == null){
            this.map[bucket] = new LinkedList<>();
        }

        if(!this.containsKey(key)){
            Entry entry = new Entry(key, value);
            this.map[bucket].add(entry);
        }else{
            for(Entry entry : this.map[bucket]){
                if(entry.key == key) entry.value = value;
            }
        }
    }
    
    public int get(int key) {
        int bucket = key % defaultCapacity;

        if(this.map[bucket] != null && this.map[bucket].size() != 0){
            for(Entry entry : this.map[bucket]){
                if(entry.key == key) return entry.value;
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        int bucket = key % defaultCapacity;
        if(this.map[bucket] != null && this.map[bucket].size() != 0){
            this.map[bucket].removeIf(entry -> entry.key == key);
        }
    }

    public boolean containsKey(int key){
        int bucket = key % defaultCapacity;
        if(this.map[bucket] != null && this.map[bucket].size() != 0){
            for(Entry entry : this.map[bucket]){
                if(entry.key == key) return true;
            }
        }
        return false;
    }
}

class Entry{
    int key;
    int value;

    public Entry(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */