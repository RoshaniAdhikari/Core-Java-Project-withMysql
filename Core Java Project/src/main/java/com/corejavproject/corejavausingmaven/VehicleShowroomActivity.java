package com.corejavproject.corejavausingmaven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
public class VehicleShowroomActivity {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//Add Student
	public static VehicleShowroom addVehicle() throws IOException {
		VehicleShowroom s = new VehicleShowroom();
		System.out.println("Enter Vehicle model_no");
		s.setModel_no(br.read());
		br.readLine();
		System.out.println("Enter Vehicle Name");
		s.setName(br.readLine());
		System.out.println("Enter Vehicle Price");
		s.setPrice(br.read());
		br.readLine();
		System.out.println("Enter Vehicle Colour");
		s.setColor(br.readLine());
		return s;
	}
//Update Student
	public static void updateVehicle(List<VehicleShowroom> showrooms) throws IOException {
		boolean found=false;
		System.out.println("Enter Model_No To Update The Vehicle");
		int model_no=br.read();
		ListIterator<VehicleShowroom>itr= showrooms.listIterator();
		while (itr.hasNext()) 
		{	
			VehicleShowroom s = (VehicleShowroom) itr.next();
			if(s.getModel_no()==model_no)
			{
				System.out.println("Enter Vehicle Name");
				String name = br.readLine();
				System.out.println("Enter Vehicle Price");
				int price = br.read();
				System.out.println("Enter Vehicle Colour");
				String color = br.readLine();
		    	itr.set(new VehicleShowroom(model_no,name,price,color));
				found=true;
			}	
		}
		if(!found)
		{
			System.out.println("Record Does Not Exist");
		}
		else
		{
			System.out.println("Record UPdated Successfully");
		}
	}
//Display student
	public static void displayVehicle(List<VehicleShowroom> showrooms) {

		Iterator<VehicleShowroom> itr = showrooms.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
	}
//Delete student	
	public static void deleteVehicle(List<VehicleShowroom> showrooms) throws IOException {
		boolean found=false;
		System.out.println("Enter model_no To Delete The Vehicle");
		int model_no=br.read();
		ListIterator<VehicleShowroom>itr= showrooms.listIterator();
		while (itr.hasNext()) 
		{	
			VehicleShowroom s = (VehicleShowroom) itr.next();
			if(s.getModel_no()==model_no)
			{
				itr.remove();
				found=true;
			}	
		}
		if(!found)
		{
			System.out.println("Record Does Not Exist");
		}
		else
		{
			System.out.println("Record Deleted Successfully");
		}
	}		
//search 
	public static void searchVehicle(List<VehicleShowroom> showrooms) throws IOException
	{
		boolean found=false;
		System.out.println("Enter model_no To Search The Student");
		int model_no=br.read();
		Iterator<VehicleShowroom>itr= showrooms.iterator();
		while (itr.hasNext()) {
			
			VehicleShowroom s = (VehicleShowroom) itr.next();
			if(s.getModel_no()==model_no)
			{
               System.out.println(s);		
                     found=true;
			}	
		}
		if(!found)
		{
			System.out.println("Record Does Not Exist");
		}
	}
}