package pstfixInfix;

import java.util.Stack;
import java.lang.Math;

public class Postfix {
    public static float arithmetic_ops(String[] stringList) {
        Stack<Float> operationstack = new Stack<Float>();

        for(String string : stringList) {
            if (string.trim().equals("")) {
                continue;
            }

            switch (string) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "^":
                    float right = operationstack.pop();
                    float left = operationstack.pop();
                    double DResult = 0;
                    float Result = 0;
                    switch(string) {
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
                    operationstack.push(Result);
                    break;
                default:
                	operationstack.push(Float.parseFloat(string));
                    break;  
            }
        }
        return operationstack.pop();
    }
}