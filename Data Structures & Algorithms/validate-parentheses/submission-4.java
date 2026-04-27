class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(int i = 1; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                if(!stack.isEmpty() && map.get(s.charAt(i)) == stack.peek()){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}
