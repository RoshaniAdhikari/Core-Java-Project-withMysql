package com.corejavproject.corejavausingmaven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SmartCityMainClass {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_city", "root", "root");
            SmartCityActivity smartCityActivity = new SmartCityActivity(con);

            while (true) {
            	BufferedReader br=new  BufferedReader(new InputStreamReader(System.in));
                System.out.println();
                System.out.println("===== Smart City =====");
        			System.out.println("1. Insert Hotel Information");
        			System.out.println("2. Get Hotel Details");
        			System.out.println("3. Insert Transportation Information");
        			System.out.println("4. Get Transportation Details");
        			System.out.println("5. Insert Air Ticket Information");
        			System.out.println("6. Get Air Ticket Details");
        			System.out.println("7. Insert Shopping Information");
        			System.out.println("8. Get Shopping Details");
        			System.out.println("9. Insert City News");
        			System.out.println("10. Get City News");
        			System.out.println("Enter your choice (1-10):");
        			int choice = Integer.parseInt(br.readLine());
                switch (choice) {
                    case 1:
                        smartCityActivity.insertHotelInformation();
                        break;
                    case 2:
                        smartCityActivity.displayHotelInformation();
                        break;
                    case 3:
                        smartCityActivity.insertTransportInformation();
                        break;
                    case 4:
                        smartCityActivity.displayTransportInformation();
                        break;
                    case 5:
                        smartCityActivity.insertAirlineInformation();
                        break;
                    case 6:
                        smartCityActivity.displayAirlineInformation();
                        break;
                    case 7:
                        smartCityActivity.insertShoppingInformation();
                        break;
                    case 8:
                        smartCityActivity.displayShoppingInformation();
                        break;
                    case 9:
                        smartCityActivity.insertCityNewsInformation();
                        break;
                    case 10:
                        smartCityActivity.displayCityNewsInformation();
                        break;
                    
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

