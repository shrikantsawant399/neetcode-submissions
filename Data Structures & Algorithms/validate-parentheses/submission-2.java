class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(int i = 1; i < s.length(); i++){
            if(stack.empty()){
                stack.push(s.charAt(i));
                continue;
            }
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) == stack.peek()){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }

        if(stack.empty())
            return true;
        return false;    
    }
}
