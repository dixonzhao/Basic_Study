package week03_part01;

import java.util.Scanner;

public class VehicleFactory 
{
	public MotorVehicle manufacture(String type)
	{
		MotorVehicle mv = null;
		if (type.equalsIgnoreCase("Bus"))
			mv = new Bus("Amtrak Bus", 40);
		if (type.equalsIgnoreCase("Motorcycle"))
			mv = new Motorcycle("Ducati Diavel");
		if (type.equalsIgnoreCase("StandardCar"))
			mv = new StandardCar("Honda Civic");
		return mv;
	}

	public static void main(String[] args) 
	{
		MotorVehicle [] mvs;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("How many vehicles do you want to produce?");
		mvs = new MotorVehicle[keyboard.nextInt()];
		
		VehicleFactory factory = new VehicleFactory();
		
		for (int i = 0; i < mvs.length; i++)
		{
			System.out.println("Enter of vehicle #" + i + " (Bus, Motorcycle, StandardCar): ");
			String type = keyboard.next();
			if (type.equals("Motorcycle"))
			{
				System.err.println("Error: option not available yet. Come back later");
				i--;
				continue;
			}
			mvs[i] = factory.manufacture(type);
		}
		
		System.out.println("Your vehicles are ready:");
		for (int i = 0; i < mvs.length; i++)
		{
			System.out.println(mvs[i]);
		}
	}
}
