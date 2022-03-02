package pstfixInfix;

import java.util.Stack;

public class Postfix {
    public static float arithmetic_ops(String[] strArr) {
        Stack<Float> operands = new Stack<Float>();

        for(String str : strArr) {
            if (str.trim().equals("")) {
                continue;
            }

            switch (str) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "^":
                    float right = operands.pop();
                    float left = operands.pop();
                    float value = 0;
                    switch(str) {
                        case "+":
                            value = left + right;
                            break;
                        case "-":
                            value = left - right;
                            break;
                        case "*":
                            value = left * right;
                            break;
                        case "/":
                            value = left / right;
                            break;
                        case "^":
                            value = left / right;
                            break;
                        default:
                            break;
                    }
                    operands.push(value);
                    break;
                default:
                    operands.push(Float.parseFloat(str));
                    break;  
            }
        }
        return operands.pop();
    }
}