package pstfixInfix;

import dataStructures.Stack;

import dataStructures.DoubleLinkedList;
import java.lang.Math;

public class Postfix {
	private Stack<String> psfxList;
	private Singleton SingleT;
	public Stack<Float> stackNum; 

	public float evaluatePsfx(Stack<String> list) {
		psfxList =  list;
		SingleT = Singleton.getInstance();
		stackNum = SingleT.stackNum;
		int contador = psfxList.Count();
		for (int k = 0; k<contador; k++) {
			String valueString = psfxList.pull();
			System.out.print(" "+valueString+" Es el valor para la corrida : "+k+ "\n");
			evaluateOpsType(valueString);
			
		}
		int k=0;
		for (int l = 0; l<stackNum.Count(); l++) {
			k++;
		}
		float result = stackNum.pull();
		if (k==1) {
			System.out.print("Se realizo con exito la operacion,"
					+ " el resultado es: "+ result);
			
		}else {
			System.out.print("Hubo algun error dado que su expresion "
					+ "matematica tenia algo malo.");
		}
		return result;
	}
	private void evaluateOpsType(String valueString) {
		try {
			stackNum.push((float) Integer.parseInt(valueString));
			System.out.print(stackNum.peek()+"\n");
			
		}catch (Exception e) {
			if (enoughNumbers()) {
				switch (valueString) {
				
				case "+":{
					stackNum.push(add());
					System.out.print(stackNum.peek());
					break;
				}case "-":{
					stackNum.push(subs());
					System.out.print(stackNum.peek());
					break;
				}case "*":{
					stackNum.push(mult());
					System.out.print(stackNum.peek());
					break;
				}case "/":{
					stackNum.push(div());
					System.out.print(stackNum.peek());
					break;
				}case "^": {
					stackNum.push(exp());
					System.out.print(stackNum.peek());
					break;
				}
			}
			
			
			}else {
				for (int k = 0; k<30; k++) {
					stackNum.push((float) 8329);
				}
				
			}
		}
	}
	private boolean enoughNumbers() {
		if (stackNum.Count()>1) {
			return true;
		}else {
			return false;
		}
	}
	private Float add(){
		float result= stackNum.pull() + stackNum.pull();
		return result;
	}
	private Float subs(){
		float result= - stackNum.pull() + stackNum.pull();
		return result;
	}
	private Float mult(){
		float result= stackNum.pull() * stackNum.pull();
		return result;
	}
	private Float div(){
		float value2 = stackNum.pull();
		float value1 = stackNum.pull();
		float result = value1/value2;
		return result;
	}
	
	
	private Float exp(){
		double value2 = stackNum.pull();
		double value1 = stackNum.pull();
		
		float result= (float) Math.pow(value1, value2);
		return result;
	}
	
//    public static float arithmetic_ops(String[] stringList) {
//        Stack<Float> operationstack = new Stack<Float>();
//
//        for(String string : stringList) {
//            if (string.trim().equals("")) {
//                continue;
//            }
//
//            switch (string) {
//                case "+":
//                case "-":
//                case "*":
//                case "/":
//                case "^":
//                    float right = operationstack.pop();
//                    float left = operationstack.pop();
//                    double DResult = 0;
//                    float Result = 0;
//                    switch(string) {
//                        case "+":
//                        	DResult = left + right;
//                            break;
//                        case "-":
//                        	DResult = left - right;
//                            break;
//                        case "*":
//                        	DResult = left * right;
//                            break;
//                        case "/":
//                        	DResult = left / right;
//                            break;
//                        case "^":
//                        	DResult = Math.pow(left, right);
//                            break;
//                        default:
//                            break;
//                    }
//                    Result = (float)DResult;
//                    operationstack.push(Result);
//                    System.out.print(Result);
//                    break;
//                default:
//                	operationstack.push(Float.parseFloat(string));
//                    break;  
//            }
//        }
//        return operationstack.pop();
//    }
    public static void main(String[] args) {
		String[] list = {"-1","0","3","/","*","+"};
		
		DoubleLinkedList<String> stack = new DoubleLinkedList<String>();
		
		for (int k = 0; k<list.length; k++) {
			stack.push(list[list.length-1-k]);
			System.out.print(stack.peek()+ "\n");
		}
		Postfix postfix = new Postfix();
		postfix.evaluatePsfx(stack);

	}
}