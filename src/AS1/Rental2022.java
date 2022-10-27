package AS1;

import java.text.NumberFormat;

public class Rental2022 
{
	private String customer;
	private String customerTemp;
	private String rentalDate;
	private String bikeType;
	private boolean insured;
	private int hrs;
	private String options;
	
	
	public Rental2022(String data) //This constructor takes temp (the CSV data line)
	{
		String [] info = data.split(","); //turns the temp into an array (assuming theres no errors in the data)
		customer = info[0];
		rentalDate = info[1];
		bikeType =info[2];
		insured = (info[3].contains("Y"));//turns the Y/N from insured and turns it into a boolean
		hrs =  Integer.parseInt(info[4]);//turns the number of hours from string to int
		options = info[5];
	}
	
	public String CheckCustomer() //CheckCustomer checks if there is a new customer or not. returns blank or the new customers name
	{
		String temp;
		if(customer.contentEquals(customerTemp)) 
			temp = "";
		else 
			temp = customer;
			
		return temp;
	}
	
	public void setCustomerTemp(String n) //sets CustomerTemp from BikeRental2022
	{
		customerTemp = n;
	}
	
	
	public double RentalAmt() { //RentalAmt takes the bikeType and the insurances and calculates the amount based off that.
		double rate;
		double insuranceAmt = 0;
		switch(bikeType) 
		{
		case "E":
			rate = 22;
			break;
		case "M":
			rate = 10;
			break;
		case "S":
			rate = 8;
			break;
		default:
			rate = 15;
		}
		if (insured)
			insuranceAmt = 5;
		
		double rentalAmt = hrs * rate + insuranceAmt;
		
		return rentalAmt;
	}
	
	public double getAmt() 
	{
		return RentalAmt(); //this returns the amount to BikeRental2022
	}
	
	public String isInsured() //checks if it is insured.
	{
		String temp = "No";
		if(insured)
			temp = "Yes";
		return temp;
	}
	
	public String BikeType() { //Returns the name from the bikeType code.
		String temp; 
		switch(bikeType) 
		{
		case "E":
			temp= "Electric";
			break;
		case "M":
			temp= "Mountain";
			break;
		case "S":
			temp= "7-speed";
			break;
		default:
			temp= "Tandem";
		}
		return temp;
	}
	
	public String Options() { //Takes the code of the options and returns the full name(s).
		String temp = "";
		
		if(options.contains("C"))
			temp = temp + "Child Seat " ;
		if(options.contains("H"))
			temp = temp + "Helmet " ;
		if(options.contains("L"))
			temp = temp + "Lock " ;
		if(options.contains("O"))
			temp = temp + "Odometer " ;
		if(options.contains("R"))
			temp = temp + "Rack " ;
		if(options.contains("S"))
			temp = temp + "Storage " ;
		
		temp = temp.trim();
		temp = temp.replace(" ", " & ");
		
		return temp;
	}
	
	public String getRentalDate() { //takes the rentalDate and returns it.
		return rentalDate;
	}
	
}

