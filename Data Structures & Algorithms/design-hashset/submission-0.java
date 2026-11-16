class MyHashSet {
    ArrayList<Integer> set;

    public MyHashSet() {
        this.set = new ArrayList<>();
    }
    
    public void add(int key) {
        for(int val: this.set){
            if(val == key) return;
        }
        this.set.add(key);
    }
    
    public void remove(int key) {
        this.set.removeIf(val -> val == key);
    }
    
    public boolean contains(int key) {
        for(int val: this.set){
            if(val == key) return true;
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