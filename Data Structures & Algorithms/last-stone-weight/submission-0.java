class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone: stones){
            maxHeap.add(stone);
        }

        while(!maxHeap.isEmpty()){ 
            if(maxHeap.size() == 1) return maxHeap.poll();
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            int diff = Math.abs(stone1 - stone2);
            if(diff > 0) maxHeap.add(diff);
        }
        return 0;
    }
}
