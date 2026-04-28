class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for(String token : tokens){
            if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")){
                stack.push(token);
            }else{
                int secondOperand = Integer.parseInt(stack.pop());
                int firstOperand = Integer.parseInt(stack.pop());
                switch(token){
                    case "+": 
                        stack.push(String.valueOf(firstOperand + secondOperand));
                        break;
                    case "-":
                        stack.push(String.valueOf(firstOperand - secondOperand));
                        break;
                    case "*":
                        stack.push(String.valueOf(firstOperand * secondOperand));
                        break;
                    case "/":
                        stack.push(String.valueOf(firstOperand / secondOperand));
                        break;            
                }
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
