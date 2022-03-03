package pstfixInfix;

import dataStructures.ArrayList;
import dataStructures.DoubleLinkedList;
import dataStructures.SingleLinkedList;
import dataStructures.Stack;
import dataStructures.Vector;

public class Infix2Pstfix {
	
		Stack<String> infixList;
		Stack<String> stackStorage;
		
		/**
		 * Es un factory para crear un Stack de un tipo especifico de estructura de dato.
		 * @param text
		 * @param output
		 * @param opStack
		 */
		public void Infx2Pstfix(String output){
			
			switch(stackCase(output)) {
			//Casos
			
			case 1:{
				//Caso en el que se genera el stack de ArrayList
				stackStorage = new ArrayList<String>();
				infixList = new ArrayList<String>();
				System.out.print("Entro ArrayList\n");
			}case 2:{
				//Caso en el que se genera el stack de Vector
				stackStorage= new Vector<String>();
				infixList = new Vector<String>();
				System.out.print("Entro Vector\n");
			}case 3:{
				//Caso en el que se genera el stack de StringLinkedList
				stackStorage= new SingleLinkedList<String>();
				infixList = new SingleLinkedList<String>();
				System.out.print("Entro SingleLinkedList\n");
			}case 4:{
				//Caso en el que se genera el stack de DoubleLinkedList
				stackStorage= new DoubleLinkedList<String>();
				infixList = new DoubleLinkedList<String>();
				System.out.print("Entro DoubleLinkedList\n");
			}
			}
		}
		/**
		 * En este caso genera un getType para hacer el instanceCreator.
		 * @param stackOption
		 * @return
		 */
		private int stackCase(String stackOption){
			
			if (stackOption == "ArrayList") {
				return 1;
			}else if (stackOption == "Vector") {
				return 2;
			}else if (stackOption=="SingleLinkedList") {
				return 3;
			}else if (stackOption=="DoubleLinkedList") {
				return 4;
			}else {
				return 0;
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
				
			}
			//El pull hace que el contador disminuya por lo que no se almacenan todos
			int contadorInicial =stackStorage.Count();
			//Se realiza un recorrido por el stackStorage para sacar todos los valores.
			for (int l = 0; l<contadorInicial; l++) {
				System.out.print(l);
				if (stackStorage.peek()=="(") {
					System.out.print("Le hizo falta un parentesis cerrado");				
				}else {
					infixList.push(stackStorage.pull());
				}
				
			}
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
							+ " +,-,*,/ o ^.");
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
				System.out.print("Entro");
				stackStorage.pull();
			}
		}
		
		

			
//		private void printList() {
//			for (int k = 0 ; k<infixList.Count(); k++) {
//				System.out.print(((DoubleLinkedList<String>) infixList).Get(k)+" ");
//			}
//			System.out.print("\n");
//		}
//		
//		private void printStack() {
//			for (int k = 0 ; k<stackStorage.Count(); k++) {
//				System.out.print(((DoubleLinkedList<String>) stackStorage).Get(k)+" ");
//			}
//		}
		
	
}
		
