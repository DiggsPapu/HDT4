package pstfixInfix;

import java.io.File;
import java.io.BufferedWriter;
import java.util.Scanner;

/**
 * 
 * @author Diego Alonzo 20172
 *
 */
public class Main {
	public static void userDataType(String userMode) {
		Scanner scanner = new Scanner(System.in);
		switch (userMode) {
		
		case "ArrayList":{
			System.out.print("ArrayList");
			break;
		}
		case "Vector":{
			System.out.print("Vector");
			break;
		}
		case "List":{
			System.out.print("Dado que ingreso List, entonces necesitamos que indique que tipo de List:\n"
					+ "1. SingleLinkedList\n2. DoubleLinkedList");
			
			
			switch (scanner.nextLine()) {
			case "SingleLinkedList":{
				System.out.print("SingleLinkedList\n");
				break;
			}
			
			case "DoubleLinkedList":{
				System.out.print("DoubleLinkedList\n");
				break;
			}
			
			}
			
			scanner.close();
			break;
		}
		}
		
//		if (userMode == "ArrayList") {
//			
//			scanner.close();
//		}else if (userMode == "Vector") {
//			scanner.close();
//		}else if (userMode == "List") {
//			System.out.print("Dado que ingreso List, entonces necesitamos que indique que tipo de List:\n"
//					+ "1. SingleLinkedList\n2. DoubleLinkedList");
//			
//			String listType = scanner.nextLine();
//			
//			if (listType == "SingleLinkedList") {
//					
//			}else if (listType == "DoubleLinkedList") {
//					
//			}else {
//				System.out.print("No selecciono ninguna opcion valida de lista, feliz dia.");
//				
//			}
//			
//			scanner.close();
//			
//		}else {
//			System.out.print("No selecciono niguna opcion valida. Feliz dia");
//			scanner.close();
//		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Bienvenidos al programa para operar funciones Infix mediante Postfix.\n"
				+ "Es por ello que necesitamos que nos indique en donde es que se encuentra su archivo a evaluar.\n ");
		
		String directory = scanner.nextLine();
		
		File newfile = new File(directory);
		
		if (newfile.exists()&& newfile.canRead()){
			System.out.print("Ahora necesitamos que nos indique que clase de estructura de datos desea que implementemos.\n"
					+ "1.ArrayList\n2.Vector\n3.List");
			userDataType(scanner.nextLine());
			scanner.close();
		} else {
			System.out.print("El archivo no existe o no es posible leerlo.");
		}
	}

}
