package oop.Assignment2;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 * @author Diego Loya
 * Displays menu and takes input from user
 */
public class Driver {
	/**
	 * Displays menu, takes user input, and calls corresponding action
	 */
	public static void main(String[] args) {
	
		int choice;		//holds user input for desired action
		Inventory test = new Inventory();
		
		try {
			FileInputStream fis = new FileInputStream("videoStoreInventory");
			ObjectInputStream ois = new ObjectInputStream(fis);
			test.list = (ArrayList<Movie>)ois.readObject();
			fis.close();
			} 
			catch (FileNotFoundException e) {
				System.out.println("Cannot find datafile");
			    } 
			catch (IOException e) {
				System.out.println("Problem with file input");
			    }
			catch (ClassNotFoundException e) {
				System.out.println("Class not found on input from file");
			}
	
		do {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("\nVideo Store Inventory Menu \n");
			System.out.println("1. Add Movie \n2. Remove Movie \n3. Find Movie by SKU \n4. "
					+ "Display Inventory \n5. Quit the Program \n");
			System.out.println("Enter your choice:");
			choice=scanner.nextInt();
			
			if (choice==1){
				test.addMovie();
			}
			else if (choice==2){
				test.removeMovie();
			}
			else if (choice==3){
				test.displayMovie();
			}
			else if (choice==4){
				test.display();
			}	
			
		}while(choice!=5);
		
		   //the following code writes the objects to the file:
	    try {
	    	FileOutputStream fos = new FileOutputStream("videoStoreInventory");
	    	ObjectOutputStream oos = new ObjectOutputStream(fos);
	    	oos.writeObject(test.list); //ArrayList & contents are serializable
	    	fos.close();
	    } 
	    catch (IOException e) {
	    	System.out.println("Problem with file output");
	    }
	    
		System.out.print("\nProgram terminated..");
	}
	
}


