package oop.Assignment2;
import java.util.*;

/**
 * @author Diego Loya
 * Creates and interacts with a collection of movies in inventory 
 */
public class Inventory {
	
	private int s;	//numeric value of a movie's unique code
	private Scanner input;	//will hold value from user input
	public ArrayList<Product> list = new ArrayList<Product>();
	
	
	/**
	 * Creates an instance of Movie using user input and adds to arrayList
	 */
	void addMovie(){
		
		String t;	//Holds user input for title of movie
		float p;	//Holds user input for price of movie
		int q;		//Holds user input for quantity of movie
		
		System.out.println("Enter the SKU (numbers only!):");			
		input = new Scanner(System.in);
		if(input.hasNextInt()){
			s=input.nextInt();
			
															
			for (int i = 0; i < list.size(); i++){		
				Product temp = list.get(i);
				
				if (s==temp.getSku()){
					System.out.print("\n***SKU must be unique***\n");
					return;
				}
			}
		}
		else{
			System.out.print("\n***SKU needs to be numbers only***\n");
			return;
		}
		
		System.out.println("Enter the movie title:");
		input = new Scanner(System.in);
		t=input.nextLine();
		
		System.out.println("Enter the price:");
		if(input.hasNextFloat()){
			p=input.nextFloat();
			if (p<=0){
				System.out.print("\n***Price needs to be greater than $0.00***\n");
				return;
			}
			
		}
		else{
			System.out.print("\n***Price needs to be numbers & decimals only***\n");
			return;
		}
		
		System.out.println("Enter the quantity:");
		if(input.hasNextInt()){
			q=input.nextInt();
			if (q<0){
				System.out.print("\n***Quantity has to be greater or equal to 0***\n");
				return;
			}
				
		}
		else{
			System.out.print("\n***Quantity needs to be numbers only***\n");
			return;
		}
		
		Product newEntry = new Product(s,t,p,q);
		list.add(newEntry);
		
		System.out.print("\n***Movie has been added***\n");

	}
				
	/**
	 * Takes input from user to search in inventory, if found it removes from inventory.
	 */
	void removeMovie(){
		System.out.println("Enter the SKU of the movie to be removed:");
		input = new Scanner(System.in);
		if(input.hasNextInt()){
			s=input.nextInt();
		}
		else{
			System.out.print("\n***SKU needs to be numbers only***\n");
			return;
		}
		int flag=0;
		for (int i = 0; i < list.size(); i++){
			Product temp = list.get(i);
			
			if (s==temp.getSku()){
				flag=1;
				list.remove(temp);
				System.out.print("\n***Movie has been removed***\n");
			}
		}
		if (flag==0)
			System.out.print("\n***Movie is not in Inventory***\n");

	}

	/**
	 * Displays the contents of arrayList by using print() method from Movie class
	 */
	void display(){

		if (list.size()==0){
			System.out.print("\n***Movie is empty***\n");
			return;
		}
		
		System.out.format("\n%-10s%-30s%7s%16s","SKU","Title","Price","Quantity");
		System.out.println("\n------------------------------------------------------------------");
		
		for (int i = 0; i < list.size(); i++){
			Product temp = list.get(i);
			temp.print();
			System.out.println();
			
		}
	}
	
	/**
	 * Takes user input, searches for the movie, and displays info if found
	 */
	void displayMovie(){
		
		System.out.println("Enter the SKU to view information:");
		input = new Scanner(System.in);
		if(input.hasNextInt()){
			s=input.nextInt();
		}
		else{
			System.out.print("\n***SKU needs to be numbers only***\n");
			return;
		}
		int flag=0;
		for (int i = 0; i < list.size(); i++){
			Product temp = list.get(i);
			if (temp.getSku()==s){
				
				flag=1;
				System.out.format("\n%-10s%-30s%7s%16s","SKU","Title","Price","Quantity");
				System.out.println("\n---------------------------------------------------------------");
				temp.print();
				System.out.println();
			}
		}
		if (flag==0)
			System.out.print("\n***Movie is not in Inventory***\n");	
	}
}