class KthLargest {
    int kthLargestElement;
    PriorityQueue<Integer> heap;
    int[] stream;

    public KthLargest(int k, int[] nums) {
        this.kthLargestElement = k;
        heap = new PriorityQueue<>();
        for(int num: nums){
            heap.add(num);
        }
    }
    
    public int add(int val) {
        heap.add(val);
        while(heap.size() > kthLargestElement) {
            heap.poll();
        }
        return heap.peek();
    }
}
