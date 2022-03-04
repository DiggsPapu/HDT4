package pstfixInfix;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

/**
 * 
 * @author Diego Alonzo 20172
 *
 */
public class Main {
	
	
	public static void userDataType(String userMode, String dir) {
		//Para leer las respuestas
		Scanner scanner = new Scanner(System.in);
		
		//Para poder hacer la conversion de infix a postfix
		Infix2Pstfix infix = new Infix2Pstfix();
		
		//Para hacer los casos para las respuestas que daran
		switch (userMode) {
		
		//Caso en el que la respuesta fue ArrayList
		case "ArrayList":{
			System.out.print("ArrayList");
			
			//Conversion del string del archivo a lista string
			String[] archiveList = conversionStringArchivo(dir);
			
			//Creacion del tipo de estructura de dato seleccionada
			//En este caso ArrayList
			infix.Infx2Pstfix(userMode, archiveList);
			//Traduccion de infix a postfix almacenado en un stack de tipo ArrayList
			infix.readStack(archiveList);
			//Salir del switch
			break;
		}
		case "Vector":{
			System.out.print("Vector");
			
			//Conversion del string del archivo a lista string
			String[] archiveList = conversionStringArchivo(dir);
			
			//Creacion del tipo de estructura de dato seleccionada
			//En este caso Vector y el archive list sirve para saber la longitud del vector dado que es un tipo de estructura no dinámica
			infix.Infx2Pstfix(userMode, archiveList);
			//Traduccion de infix a postfix almacenado en un stack de tipo ArrayList
			infix.readStack(archiveList);
			//Salir del switch
			break;
		}
		case "List":{
			System.out.print("Dado que ingreso List, entonces necesitamos que indique que tipo de List:\n"
					+ "1. SingleLinkedList\n2. DoubleLinkedList");
			userMode = scanner.nextLine();
			
			switch (userMode) {
			case "SingleLinkedList":{
				System.out.print("SingleLinkedList\n");


				//Conversion del string del archivo a lista string
				String[] archiveList = conversionStringArchivo(dir);
				
				//Creacion del tipo de estructura de dato seleccionada
				//En este caso SingleLinkedList
				infix.Infx2Pstfix(userMode, archiveList);
				//Traduccion de infix a postfix almacenado en un stack de tipo ArrayList
				infix.readStack(archiveList);
				//Salir del switch
				break;
			}
			
			case "DoubleLinkedList":{
				System.out.print("DoubleLinkedList\n");


				//Conversion del string del archivo a lista string
				String[] archiveList = conversionStringArchivo(dir);
				
				//Creacion del tipo de estructura de dato seleccionada
				//En este caso DoubleLinkedList
				infix.Infx2Pstfix(userMode, archiveList);
				//Traduccion de infix a postfix almacenado en un stack de tipo ArrayList
				infix.readStack(archiveList);
				//Salir del switch
				break;
			}default:{
				System.out.print("No selecciono ningun valor valido de lista, feliz dia");
				break;
			}
			
			}
			
			scanner.close();
			break;
		}
		}
		
	}
	
	private static String[] conversionStringArchivo(String filedi) {
		try {
			
			BufferedReader read= new BufferedReader(new FileReader(filedi));
			
			String contenido = read.readLine();
			String[] tempArray= contenido.split(",");
			read.close();

			return tempArray;
			}
		
		catch (Exception e) {
			System.out.print("El archivo no es posible de ordenar dado que no solo posee numeros\n");
			String[] tempArray= null;

			return tempArray;
		}
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
					+ "1.ArrayList\n2.Vector\n3.List\n");
			userDataType(scanner.nextLine(), directory);
			scanner.close();
		} else {
			System.out.print("El archivo no existe o no es posible leerlo.\n");
		}
	}

}
