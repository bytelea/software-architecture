package inventory;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 
import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {
    public static void main(String[] args) throws IOException
    {
    	
    System.out.println("Welcome to Stock Manager[SM]. This creates a record of your Face Makeup[FM] and Eye Makeup[EM]\n");	

    	ArrayList<FaceMakeup> A = new ArrayList<FaceMakeup>();
    	ArrayList<EyeMakeup> B = new ArrayList<EyeMakeup>();
    	
    	userInput(A,B);  
    	writeToFile(A,B);
    	System.out.println("Thank you for the data - it has been added to the file\n");
    		
    	readFile();
    	searchFile();
    	deleteAllProducts(A,B);
    	deleteSingleProduct(A,B);
    	System.out.println("Program Terminated. Thank You");
    		
    }

public static void userInput(ArrayList<FaceMakeup> A, ArrayList<EyeMakeup> B) throws IOException{
	
	
	Scanner input = new Scanner (System.in);
	System.out.println("Please type FM or EM to input a new product record \n Type finished when you have completed this task" );
	String x = input.next();
	
	if (x.equalsIgnoreCase("Exit")) {
		System.exit(0);
	}
	while (!x.equalsIgnoreCase("finished"))
	{
		if (x.equalsIgnoreCase("FM")) 
		{
			createFM(A);
		
		}
		else if (x.equalsIgnoreCase("EM"))
		{
			createEM(B);
			}
		else 
		{
			System.out.println("you have not selected a valid entry - try again\n");
				
		}
		
		System.out.println("Type FM or EM to input the next type of product you wish to capture \n Type finished when have completed this task" );
		x = input.next();
					
	      }
}

public static void createFM(ArrayList<FaceMakeup>A){
	
	Scanner input = new Scanner (System.in);
	boolean correctValue = false;
	
	System.out.println("Please provide the brand name\n");
	String brand = input.next();
	
	System.out.println("Please provide the name of the item\n");
	String itemName = input.next();
				
	System.out.println("Please provide the quatity\n");
	String quantity = input.next();
	
	System.out.println("Please provide the size od the product\n");
	String size = input.next();
	
	System.out.println("Provide the price of the product\n");
	double price = input.nextInt();			
	
	FaceMakeup FM1= new FaceMakeup(brand, itemName, quantity, size, price );
	A.add(FM1);
	
}

public static void createEM(ArrayList<EyeMakeup> B ){
	
	
	Scanner input = new Scanner (System.in);
	
	System.out.println("Please provide the brand name\n");
	String brand = input.next();
	
	System.out.println("Please provide the name of the item\n");
	String itemName = input.next();
				
	System.out.println("Please provide the quatity\n");
	String quantity = input.next();
	
	System.out.println("Please provide the size od the product\n");
	String size = input.next();
	
	System.out.println("Provide the price of the product\n");
	double price = input.nextDouble();			
	
	EyeMakeup EM1= new EyeMakeup(brand, itemName, quantity, size, price );
	B.add(EM1);
	
}

public static void writeToFile(ArrayList<FaceMakeup> A,ArrayList<EyeMakeup> B) throws IOException{
	
	File file = new File ("Product.txt");
	if (!file.exists()){
		file.createNewFile();
	}
	
	FileWriter writer = new FileWriter(file);
	
	for (int i=0;i<A.size();i++){
		writer.write((A.get(i).getBrand()+" "+A.get(i).getItemName()+" "+A.get(i).getQuantity()+" "+A.get(i).getSize()+" "+A.get(i).getPrice()+"\n"));
	}
	
	for (int j=0; j<B.size();j++){
		
		writer.write((B.get(j).getBrand()+" "+B.get(j).getItemName()+" "+B.get(j).getQuantity()+" "+B.get(j).getSize()+" "+B.get(j).getPrice()+"\n"));
	}
	
	writer.close();}

public static void readFile () throws IOException {
	
	System.out.println("Do you wish to review the data you have added? Type Yes or No please\n");
	Scanner input = new Scanner(System.in);
	String x = input.next();
	
	if (x.equalsIgnoreCase("yes")){
	
	FileReader file = new FileReader("Product.txt");		
	BufferedReader y = new BufferedReader(file);
	
	String z = y.readLine();
	
	while (z!=null)
	{
		System.out.println(z);
		z =y.readLine();
	}

	y.close();
	}
}

public static void main1(String[] args) {
    Scanner scanner = new Scanner(System.in);
}
/**
 * Allows the user to search for products containing a specific keyword and displays their contents.
 */
public static void searchFile() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the keyword to search for in product names:");
    String keyword = Scanner.nextLine();
    File directory = new File(directory);

    if (!directory.exists() || !directory.isDirectory()) {
        System.out.println("Directory does not exist.");
        return;
    }

    File[] matchingProducts = directory.listFiles((dir, itemName) -> itemName.contains(keyword));

    if (matchingProducts == null || matchingProducts.length == 0) {
        System.out.println("No files found matching the keyword.");
        return;
    }

    for (File file : matchingProducts) {
        System.out.println("Found product: " + file.getName());
        System.out.println("Contents:");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + file.getName());
            e.printStackTrace();
        }
        System.out.println("--------------------------------------------------");
    }
}

/**
 * Deletes all files within the specified directory.
 */
public static void deleteAllProducts(ArrayList<FaceMakeup> A,ArrayList<EyeMakeup> B) throws IOException
{			
	Scanner input = new Scanner (System.in);
	System.out.println("Would you like to delete all the products? Please type Yes or No");
	String x = input.nextLine();
	
	if (x.equalsIgnoreCase("Yes"))
	{
		//this clears the data from the file by overwriting it
	FileWriter file = new FileWriter ("device.txt");
	file.close();

	System.out.println("The data has been deleted from the file now\n");
	}
}

public static void deleteSingleProduct(ArrayList<FaceMakeup> A,ArrayList<EyeMakeup> B) throws IOException{
	// we also need to store a create a copy of this file while we are copying 
	
	File temp = new File("Temp.txt");
	if (!temp.exists())
	{
		temp.createNewFile();
	}	
	// call a previous method to reload all the data to the device.txt file	
	writeToFile(A,B);
	
	// need to start reading the existing file and copy 
	// it to the temp file except for line with the "searchvalue";
	File file = new File("Product.txt");
	FileReader x = new FileReader(file);
	BufferedReader y = new BufferedReader(x);
	String z = y.readLine();
	
	// this is the filewriter needed for the copy
	FileWriter tempWrite = new FileWriter(temp);
	
	/// firstly the user needs to input the value they wish to delete;
	System.out.println("You will be asked to select a product. To help with the selection you have the chance to review all data");
	// also going to allow the user a refreshed view of the data
	readFile();
	
	System.out.println("Provide some detail on the product you wish to delete now");
	Scanner input = new Scanner (System.in);
	String searchValue =input.next();	
	
	while(z!=null )
	{
		// while the line doesnt contain the product the user is deleting 
		//copy it to the file
		if (!z.trim().contains(searchValue))
		{
												
		tempWrite.write(z);}
		z=y.readLine();
	} 
	
	// close the reader & writers;
	System.out.println("That product has now been deleted from the file");
	y.close();
	tempWrite.close();
	
	// to overwrite the file - we need to delete the existing
	// device.txt file & rename the temp file to device.txt;
	file.delete();
	
	temp.renameTo(file);
}	

}
