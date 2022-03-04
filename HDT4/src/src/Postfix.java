package pstfixInfix;

import java.util.Stack;
import java.lang.Math;

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
                    double DResult = 0;
                    float Result = 0;
                    switch(str) {
                        case "+":
                        	DResult = left + right;
                            break;
                        case "-":
                        	DResult = left - right;
                            break;
                        case "*":
                        	DResult = left * right;
                            break;
                        case "/":
                        	DResult = left / right;
                            break;
                        case "^":
                        	DResult = Math.pow(left, right);
                            break;
                        default:
                            break;
                    }
                    Result = (float)DResult;
                    operands.push(Result);
                    break;
                default:
                    operands.push(Float.parseFloat(str));
                    break;  
            }
        }
        return operands.pop();
    }
}