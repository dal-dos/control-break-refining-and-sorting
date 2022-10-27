package AS1;

import java.io.File;
import java.text.NumberFormat;
import java.util.Scanner;

public class BikeRental2022 {

	public static void main(String[] args) {
		String temp = ""; 
		double total = 0;
		double subtotal = 0;
		double amtTemp = 0; //initializing variables
		int count=0;
		boolean check = false;
		
		
		File myFile = new File("c:\\temp\\AS1Data1275.csv");
		
		try 
		{
		Scanner myData = new Scanner(myFile);
		String fmt = "%-15s %10s %10s %10s %10s %10s \n"; //string formats
		String fmt2 = "%60s";
		NumberFormat numC = NumberFormat.getCurrencyInstance();
		System.out.printf(fmt,"Customer","Rental Date", "Bike Type", "Insured", "Rental Amt", "Options"); //Titles
			while(myData.hasNextLine()) //while loop until there is no more data in the .CSV file
			{
				total = total + amtTemp; //adds the calculated Rental Amount to itself each time
				subtotal = subtotal + amtTemp; //add the calculated Rental Amount each time, but resets when the customer name is different
				String arrTemp[] = temp.split(","); // an array to catch the names each time so when it goes back around it can take the previous names.
				temp = myData.nextLine();//takes the data from the CSV
				Rental2022 Person = new Rental2022(temp);//Constructor which puts the data into its respective variables in the Rental2022 obj.
				Person.setCustomerTemp(arrTemp[0]);//this sets the CustomerTemp in Rental2022 so we can save the name to check if its the same as the previous.
				amtTemp = Person.getAmt(); //this just gets the amount calculated from Rental2022 and stores it in amtTemp to make it easier to calculate
				check = (Person.CheckCustomer() != ""); //this is a boolean variable to see if the customers data is finished, so we can calculate the subtotal for that specific person.
				if(count > 0 && check) { //this if statement checks if count is more than 1 so the subtotal isnt 0 at the beginning.
					System.out.printf(fmt2, "----------\n"); //this if contains prints to print the subtotal after each customer and resets the subtotal for the next person
					System.out.printf(fmt2,numC.format(subtotal)+ "\n");
					System.out.println("");
					subtotal = 0;
				} 
				//this print takes all the info that ran through Rental2022 to get the information from the data and displays it nicely.
				System.out.printf(fmt, Person.CheckCustomer(), Person.getRentalDate(), Person.BikeType(), Person.isInsured(), numC.format(Person.RentalAmt()), Person.Options());
				count = count+1;//adds to the count (how many times this loop has run)
			}
			
		System.out.printf(fmt2, "----------\n");	//This is to do my final calculations for the last subtotal and the total.
		subtotal = subtotal + amtTemp;
		System.out.printf(fmt2,numC.format(subtotal)+ "\n");
		total = total + amtTemp;
		System.out.println("The total amt is " + numC.format(total));
		System.out.println("Program coded by Dalveer Dosanjh");
		} catch(Exception ex)
		{
			System.out.println("Error");
		}
		
	}

		
	}


