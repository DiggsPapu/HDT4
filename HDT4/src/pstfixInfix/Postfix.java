package pstfixInfix;

//import java.util.Stack;
import dataStructures.Stack;

import dataStructures.Vector;
import dataStructures.ArrayList;

import dataStructures.DoubleLinkedList;
import dataStructures.SingleLinkedList;


public class Postfix {
	private Stack<String> psfxList;
	private Stack<Float> stackNum;

	private Calculator calculadora;

	

	public float evaluatePsfx(Stack<String> list, String DataStructure) {

		psfxList =  list;
		calculadora = Calculator.getInstance();
		PostfixDataStructures(DataStructure,list.Count());
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
					stackNum.push(calculadora.add(stackNum.pull(), stackNum.pull()));
					System.out.print(stackNum.peek());
					break;
				}case "-":{
					stackNum.push(calculadora.subs(stackNum.pull(), stackNum.pull()));
					System.out.print(stackNum.peek());
					break;
				}case "*":{
					stackNum.push(calculadora.mult(stackNum.pull(), stackNum.pull()));
					System.out.print(stackNum.peek());
					break;
				}case "/":{
					stackNum.push(calculadora.div(stackNum.pull(), stackNum.pull()));
					System.out.print(stackNum.peek());
					break;
				}case "^": {
					stackNum.push(calculadora.exp(stackNum.pull(), stackNum.pull()));
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
	/**
	 * Es un factory para crear y seleccionar el tipo de estructura de dato
	 * para realizar las operaciones postfix
	 * @param output
	 * @param counter
	 */
	public void PostfixDataStructures(String output, int counter){
		if (output=="ArrayList") {
			//Caso en el que se genera el stack de ArrayList
			stackNum = new ArrayList<Float>();
			
		}else if (output == "Vector") {
			//Caso en el que se genera el stack de Vector
			stackNum= new Vector<Float>(counter);
			
		}else if (output == "SingleLinkedList") {
			//Caso en el que se genera el stack de StringLinkedList
			stackNum= new SingleLinkedList<Float>();
			
		}else if (output == "DoubleLinkedList") {
			//Caso en el que se genera el stack de DoubleLinkedList
			stackNum = new DoubleLinkedList<Float>();
			
		}else {
			System.out.print("Se ingreso una estructura de dato invalida.");
			
		}

	}

	
	private boolean enoughNumbers() {
		if (stackNum.Count()>1) {
			return true;
		}else {
			return false;
		}
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
		String[] list = {"1","3","+","24","3","1","2","/","^","*","*"};
		
		DoubleLinkedList<String> stack = new DoubleLinkedList<String>();
		
		for (int k = 0; k<list.length; k++) {
			stack.push(list[list.length-1-k]);
			System.out.print(stack.peek()+ "\n");
		}
		Postfix postfix = new Postfix();
		postfix.evaluatePsfx(stack, "DoubleLinkedList");

	}
}