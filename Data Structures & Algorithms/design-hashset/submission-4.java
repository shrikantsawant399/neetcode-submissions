class MyHashSet {
    List<Integer>[] set; 
    int defaultBucket = 1000;

    public MyHashSet() {
        this.set = new List[defaultBucket];
    }
    
    public void add(int key) {
        int bucket = key % defaultBucket;
        if(this.set[bucket] == null){
            this.set[bucket] = new LinkedList<>();
        }

        if(!this.contains(key)) this.set[bucket].add(key);
    }
    
    public void remove(int key) {
        int bucket = key % defaultBucket;
        if(this.set[bucket] != null && this.set[bucket].size() != 0){
            this.set[bucket].remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        int bucket = key % defaultBucket;
        if(this.set[bucket] == null || this.set[bucket].size() == 0) return false;
        for(int num: this.set[bucket]){
            if(num == key) return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */