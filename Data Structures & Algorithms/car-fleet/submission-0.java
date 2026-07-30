class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<Double> stack = new ArrayDeque<>();
        Integer[] indices = new Integer[position.length];

        for(int i = 0; i < position.length; i++){
            indices[i] = i;
        }

        Arrays.sort(indices, (a,b) -> Integer.compare(position[a], position[b]));
        int index = indices[indices.length - 1];
        double timeRequired = (double)(target - position[index]) / speed[index];
        stack.push(timeRequired);


        for(int i = indices.length - 2; i >= 0; i--){
            index = indices[i];
            timeRequired = (double)(target - position[index]) / speed[index];
            if(timeRequired > stack.peek()){
                stack.push(timeRequired);
            }
        }

        return stack.size();
    }
}
