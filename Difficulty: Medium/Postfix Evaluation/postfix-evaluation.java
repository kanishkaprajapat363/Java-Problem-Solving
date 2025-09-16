import java.util.Stack;

class Solution {
    public int evaluatePostfix(String[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (String s : arr) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^")) {
                int b = stack.pop(); // second operand
                int a = stack.pop(); // first operand
                int result = 0;

                switch (s) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        // integer division with floor behavior
                        result = (int) Math.floor((double) a / b);
                        break;
                    case "^":
                        result = (int) Math.pow(a, b);
                        break;
                }
                stack.push(result);
            } else {
                // it's a number
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}
