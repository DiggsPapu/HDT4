package pstfixInfix;

//import java.util.Stack;
import dataStructures.Stack;
import dataStructures.Vector;
import dataStructures.ArrayList;
import dataStructures.SingleLinkedList;
import dataStructures.DoubleLinkedList;
import java.lang.Math;

public class Postfix {
	private Stack<String> psfxList;
	private Stack<Float> stackNum;
	
	
	public float evaluatePsfx(Stack<String> list) {
		psfxList =  list;
		stackNum = new DoubleLinkedList<Float>();
		for (int k = 0; k<=psfxList.Count(); k++) {
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
			System.out.print("Hubo algun error dado que su expresion"
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
					break;
				}case "*":{
					stackNum.push(mult());
					break;
				}case "/":{
					stackNum.push(div());
					break;
				}case "^": {
					stackNum.push(exp());
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
		
		if (value2 == 0 && value1 >= 0) {
			return (float) 1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0;
		}else if (value2 == 0 && value1 <=0) {
			return (float) -1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0;
			
		}else {
			return value1/value2;
		}
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
		String[] list = {"12","3","+","24","3","1","2","/","^","*","*"};
		
		DoubleLinkedList<String> stack = new DoubleLinkedList<String>();
		
		for (int k = 0; k<list.length; k++) {
			stack.push(list[list.length-1-k]);
			System.out.print(stack.peek()+ "\n");
		}
		Postfix postfix = new Postfix();
		postfix.evaluatePsfx(stack);

	}
}