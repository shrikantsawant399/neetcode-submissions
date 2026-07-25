class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int index = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(index);
        index++;

        while(index < temperatures.length){
            if(stack.isEmpty()){
                stack.push(index);
            }
            if(temperatures[index] > temperatures[stack.peek()]){
                result[stack.peek()] = index - stack.peek();
                stack.pop();
            }else{
                stack.push(index);
                index++;
            }
        }

        return result;
    }
}
