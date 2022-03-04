package pstfixInfix;

import dataStructures.ArrayList;
import dataStructures.DoubleLinkedList;
import dataStructures.SingleLinkedList;
import dataStructures.Stack;
import dataStructures.Vector;

public class Infix2Pstfix {
	
		private Stack<String> infixList;
		private Stack<String> stackStorage;
		
		public Stack<String> getInfixList() {
			return infixList;
		}
		/**
		 * Es un factory para crear un Stack de un tipo especifico de estructura de dato.
		 * @param text
		 * @param output
		 * @param opStack
		 */
		public void Infx2Pstfix(String output, String[] list){
			if (output=="ArrayList") {
				//Caso en el que se genera el stack de ArrayList
				stackStorage = new ArrayList<String>();
				infixList = new ArrayList<String>();
				
			}else if (output == "Vector") {
				//Caso en el que se genera el stack de Vector
				stackStorage= new Vector<String>(list.length);
				infixList = new Vector<String>(list.length);
				
			}else if (output == "SingleLinkedList") {
				//Caso en el que se genera el stack de StringLinkedList
				stackStorage= new SingleLinkedList<String>();
				infixList = new SingleLinkedList<String>();
				
			}else if (output == "DoubleLinkedList") {
				//Caso en el que se genera el stack de DoubleLinkedList
				stackStorage= new DoubleLinkedList<String>();
				infixList = new DoubleLinkedList<String>();
				
			}else {
				System.out.print("Se ingreso una estructura de dato invalida.");
				
			}

		}
		/**
		 * Este sirve para leer los valores del texto en lista.
		 * @param listValues
		 * @return
		 */
		public Stack<String> readStack(String[] listValues){
			//Para evaluar los casos de numero, suma, resta, multiplicacion y division
			for (int k=0; k<listValues.length; k++) {
				evaluateCases(listValues[k]);
//				System.out.print("Ingreso a printList: ");
//				printList();
//				System.out.print("Ingreso a printStack: ");
//				printStack();
				
			}
			//El pull hace que el contador disminuya por lo que no se almacenan todos
			int contadorInicial =stackStorage.Count();
			//Se realiza un recorrido por el stackStorage para sacar todos los valores.
			for (int l = 0; l<contadorInicial; l++) {
				
				if (stackStorage.peek()=="(") {
					System.out.print("Le hizo falta un parentesis cerrado\n");	
					return null;
				}else {
					infixList.push(stackStorage.pull());
				}
				
			}
//			printStack();
//			printList();
			
			return infixList;
		}
		
		private void evaluateCases(String value) {
			try {
				Integer.parseInt(value);
				infixList.push(value);
				
			}catch (Exception e){
				//Caso de ser operando o algo invalido
				//Caso de ser un parentesis abierto
				if (value =="(") {
					stackStorage.push(value);
					
				//Caso de ser una suma o resta
				}else if(value == "+"||value=="-") {
					caseAddOrLess(value);
				//Caso de ser multiplicacion o division
				}else if (value == "*" || value == "/"){
					caseDivMult(value);
				//Caso de ser exponencial
				}else if (value == "^") {
					caseExp(value);
				//Caso de ser parentesis cerrado											
				}else if(value==")") {
					caseCloseParenthesis();
				}else {
					//Caso en el que el texto tiene argumentos no validos
					System.out.print("El texto tiene ingresados argumentos invalidos"
							+ "dado que posee argumentos que no son numeros ni operandos de tipo:"
							+ " +,-,*,/ o ^.\n");
				}
		}
		}
		/**
		 * Es el metodo para en el caso de que se encuentra un operando suma o resta.
		 * @param value
		 */
		private void caseAddOrLess(String value) {
			if (stackStorage.IsEmpty()|| stackStorage.peek()=="(") {
				stackStorage.push(value);
				
			}else {
				
				if ((!stackStorage.IsEmpty()) || (stackStorage.peek() != "(")) {
					
					infixList.push(stackStorage.pull());
				}
				stackStorage.push(value);
			}
		}
		/**
		 * Metodo en el que se encuentra un operando multiplicacion o division.
		 * @param value
		 */
		private void caseDivMult(String value) {
			if (stackStorage.peek() != "*" || stackStorage.peek() != "/" || stackStorage.peek() != "^") {
				stackStorage.push(value);
			} else {
				while (!stackStorage.IsEmpty() && stackStorage.peek()!="(") {
					infixList.push(stackStorage.pull());
				}
				stackStorage.push(value);
			}
		}
		/**
		 * Caso en el que se encuentra un operando exponencial.
		 * @param value
		 */
		private void caseExp(String value) {
			if (stackStorage.peek() != "^") {
				if (stackStorage.peek()!="^") {
					stackStorage.push(value);
				}else {
					while (!stackStorage.IsEmpty() && stackStorage.peek() != "(") {
						infixList.push(stackStorage.pull());
					}
					stackStorage.push(value);
				}
			}
		}
		/**
		 * Caso en el que se encuentra un parentesis cerrado
		 */
		private void caseCloseParenthesis() {
			
			while (!stackStorage.IsEmpty() && stackStorage.peek()!="(") {
				infixList.push(stackStorage.pull());	
			} if (stackStorage.IsEmpty()) {
				System.out.print("Hizo falta un parentesis abierto");
			} else if (stackStorage.peek()=="(") {
				stackStorage.pull();
			}
		}
		
		

//ESTOS 3 METODOS SIRVEN PARA IMPRIMIR LAS LISTAS Y VERIFICAR DE QUE ESTAN BIEN		
//		private void printList() {
//			for (int k = 0 ; k<infixList.Count(); k++) {
//				System.out.print(((ArrayList<String>) infixList).Get(k)+" ");
//			}
//			System.out.print("\n");
//		}
//		
//		private void printStack() {
//			for (int k = 0 ; k<stackStorage.Count(); k++) {
//				System.out.print(((ArrayList<String>) stackStorage).Get(k)+" ");
//			}
//			System.out.print("\n");
//		}
//		public static void main(String[] args) {
//			Infix2Pstfix translate = new Infix2Pstfix();
//			String[] list = {"(","1","+","3",")","*","24","*","3","^","(","1","/","2",")"};
//			translate.Infx2Pstfix("ArrayList", list);
//			translate.readStack(list);
//
//		}
//	
}
		
