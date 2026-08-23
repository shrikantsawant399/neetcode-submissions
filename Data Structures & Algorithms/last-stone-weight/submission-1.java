class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone: stones){
            maxHeap.add(stone);
        }

        while(!maxHeap.isEmpty()){ 
            if(maxHeap.size() == 1) return maxHeap.poll();
            int diff = Math.abs(maxHeap.poll() - maxHeap.poll());
            if(diff > 0) maxHeap.add(diff);
        }
        return 0;
    }
}
