package com.corejavproject.corejavausingmaven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class SmartCityActivity {
    private Connection con;
    private PreparedStatement ps;

    public SmartCityActivity(Connection con) {
        this.con = con;
    }
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // Insert Hotel Information
    public void insertHotelInformation() throws IOException, SQLException {
        System.out.println("Enter Hotel Name:");
        String inHotelName = br.readLine();

        System.out.println("Enter Location:");
        String inHotelLocation = br.readLine();

        System.out.println("Enter Price:");
        double inHotelprice = Double.parseDouble(br.readLine());

        System.out.println("Enter Availability:");
        int inHotelAvailability = Integer.parseInt(br.readLine());

        String queryInHotel = "insert into hotel (hotel_name, location, price, availability) values (?, ?, ?, ?)";
        ps = con.prepareStatement(queryInHotel);
        ps.setString(1, inHotelName);
        ps.setString(2, inHotelLocation);
        ps.setDouble(3, inHotelprice);
        ps.setInt(4, inHotelAvailability);
        ps.executeUpdate();
        System.out.println("Hotel information inserted successfully!");
    }

 // Get Hotel Details
    public void displayHotelInformation() throws IOException, SQLException {
	String queryGetHotel = "select * from hotel";
	ps = con.prepareStatement(queryGetHotel);
	ResultSet rsHotel = ps.executeQuery();

	System.out.println("Hotel Details:");
	System.out.println("-----------------------------------------------------------------------------------------");
	System.out.printf("%-10s %-30s %-20s %-15s %-15s\n", "Hotel ID", "Hotel Name", "Location", "Price", "Availability");
	System.out.println("-----------------------------------------------------------------------------------------");

	while (rsHotel.next()) {
		int getHotelId = rsHotel.getInt("hotel_id");
		String getHotelName = rsHotel.getString("hotel_name");
		String getHotelLocation = rsHotel.getString("location");
		double getHotelPrice = rsHotel.getDouble("price");
		int getHotelAvailability = rsHotel.getInt("availability");
		System.out.printf("%-10s %-30s %-20s %-15s %-15s\n", getHotelId, getHotelName, getHotelLocation,
				getHotelPrice, getHotelAvailability);
	}
}
 // Insert Transportation Information
    public void insertTransportInformation() throws IOException, SQLException {
	System.out.println("Enter Transport Type:");
	String inTransportType = br.readLine();

	System.out.println("Enter Description:");
	String inTransportDescription = br.readLine();

	System.out.println("Enter Fare:");
	double inTransportFare = Double.parseDouble(br.readLine());
	
	System.out.println("Enter Availability:");
	int inTransportAvailability = Integer.parseInt(br.readLine());				

	String queryInTransport = "INSERT INTO transportation (transport_type, description, fare, availability) VALUES (?, ?, ?, ?)";
	ps = con.prepareStatement(queryInTransport);
	ps.setString(1, inTransportType);
	ps.setString(2, inTransportDescription);
	ps.setDouble(3, inTransportFare);
	ps.setInt(4, inTransportAvailability);
	ps.executeUpdate();
	System.out.println("Transportation information inserted successfully!");
}
 // Get Transportation Details
    public void displayTransportInformation() throws IOException, SQLException {
	String queryGetTransport = "SELECT * FROM transportation";
	ps = con.prepareStatement(queryGetTransport);
	ResultSet rsTransport = ps.executeQuery();
	System.out.println("Transportation Details:");
	System.out.println("------------------------------------------------------------------------------------------");
	System.out.printf("%-10s %-20s %-30s %-15s %-15s\n", "Transport ID", "Transport Type", "Description",
			"Fare", "Availability");
	System.out.println("------------------------------------------------------------------------------------------");
	while (rsTransport.next()) {
		int getTransportId = rsTransport.getInt("transport_id");
		String getTransportType = rsTransport.getString("transport_type");
		String getTransportDescription = rsTransport.getString("description");
		double getTransportFare = rsTransport.getDouble("fare");
		int getTransportAvailability = rsTransport.getInt("availability");
		System.out.printf("%-10s %-20s %-30s %-15s %-15s\n", getTransportId, getTransportType,
				getTransportDescription, getTransportFare, getTransportAvailability);
	}
}
    // Insert AirLine Details
    public void insertAirlineInformation() throws IOException, SQLException {
	System.out.println("Enter Airline:");
	String inAirline = br.readLine();

	System.out.println("Enter Destination:");
	String inDestination = br.readLine();

	System.out.println("Enter Departure Date (YYYY-MM-DD):");
	String inDepartureDateStr = br.readLine();			
	Date inDepartureDate = Date.valueOf(inDepartureDateStr);

	System.out.println("Enter Price:");
	double inAirlinePrice = Double.parseDouble(br.readLine());

	System.out.println("Enter Availability:");
	int inAirlineAvailability = Integer.parseInt(br.readLine());				

	String queryInAirline = "INSERT INTO air_tickets (airline, destination, departure_date, price, availability) VALUES (?, ?, ?, ?, ?)";
	ps = con.prepareStatement(queryInAirline);
	ps.setString(1, inAirline);
	ps.setString(2, inDestination);
	ps.setDate(3, inDepartureDate);
	ps.setDouble(4, inAirlinePrice);
	ps.setInt(5, inAirlineAvailability);
	ps.executeUpdate();
	System.out.println("Air ticket information inserted successfully!");
    }
 // Get AirLine Details
    public void displayAirlineInformation() throws IOException, SQLException {
	String queryGetAirline = "SELECT * FROM air_tickets";
	ps = con.prepareStatement(queryGetAirline);
	ResultSet rsGetAirline = ps.executeQuery();

	System.out.println("Air Ticket Details:");
	System.out.println("--------------------------------------------------------------------------------------------");
	System.out.printf("%-10s %-20s %-30s %-15s %-15s %-15s\n", "Ticket ID", "Airline", "Destination",
			"Departure Date", "Price", "Availability");
	System.out.println("--------------------------------------------------------------------------------------------");

	while (rsGetAirline.next()) {
		int getTicketId = rsGetAirline.getInt("ticket_id");
		String getAirline = rsGetAirline.getString("airline");
		String getDestination = rsGetAirline.getString("destination");
		Date getDepartureDate = rsGetAirline.getDate("departure_date");
		double getPrice = rsGetAirline.getDouble("price");
		int getAirlineAvailability = rsGetAirline.getInt("availability");

		System.out.printf("%-10s %-20s %-30s %-15s %-15s %-15s\n", getTicketId, getAirline, getDestination,
				getDepartureDate, getPrice, getAirlineAvailability);
	}
}
 // Insert Shopping Details
    public void insertShoppingInformation() throws IOException, SQLException {
	System.out.println("Enter Shop Name:");
	String inShopName = br.readLine();

	System.out.println("Enter Location:");
	String inLocation = br.readLine();

	System.out.println("Enter Category:");
	String inCategory = br.readLine();

	System.out.println("Enter Opening Hours:");
	int inOpeningHours = Integer.parseInt(br.readLine());				

	String queryInShopping = "INSERT INTO shopping_details (shop_name, location, category, opening_hours) VALUES (?, ?, ?, ?)";
	ps = con.prepareStatement(queryInShopping);
	ps.setString(1, inShopName);
	ps.setString(2, inLocation);
	ps.setString(3, inCategory);
	ps.setInt(4, inOpeningHours);
	ps.executeUpdate();
	System.out.println("Shopping details inserted successfully!");
}
public void displayShoppingInformation() throws IOException, SQLException {
	// Get Shopping Details
	String queryGetShopping = "SELECT * FROM shopping_details";
	ps = con.prepareStatement(queryGetShopping);
	ResultSet rsGetShopping = ps.executeQuery();

	System.out.println("Shopping Details:");
	System.out.println("--------------------------------------------------------");
	System.out.printf("%-10s %-20s %-30s %-15s\n", "Shop ID", "Shop Name", "Location", "Category",
			"Opening Hours");
	System.out.println("--------------------------------------------------------");

	while (rsGetShopping.next()) {
		int getShopId = rsGetShopping.getInt("shop_id");
		String getShopName = rsGetShopping.getString("shop_name");
		String getShopLocation = rsGetShopping.getString("location");
		String getShopCategory = rsGetShopping.getString("category");
		String getShopOpeningHours = rsGetShopping.getString("opening_hours");
		System.out.printf("%-10s %-20s %-30s %-15s\n", getShopId, getShopName, getShopLocation,
				getShopCategory, getShopOpeningHours);
	}
}
public void insertCityNewsInformation() throws IOException, SQLException {
	// Insert City News
	System.out.println("Enter News Title:");
	String inNewstitle = br.readLine();
	System.out.println("Enter News Content:");
	String inNewaContent = br.readLine();

	System.out.println("Enter Publish Date (YYYY-MM-DD):");
	String inPublishDateStr = br.readLine();
	Date inPublishDate = Date.valueOf(inPublishDateStr);
	String queryInNews = "INSERT INTO city_news (title, content, publish_date) VALUES (?, ?, ?)";
	ps = con.prepareStatement(queryInNews);
	ps.setString(1, inNewstitle);
	ps.setString(2, inNewaContent);
	ps.setDate(3, inPublishDate);
	ps.executeUpdate();
	System.out.println("City news information inserted successfully!");
}
public void displayCityNewsInformation() throws IOException, SQLException {
	// Get City News
	String queryGetNews = "SELECT * FROM city_news";
	ps = con.prepareStatement(queryGetNews);
	ResultSet rsGetNews = ps.executeQuery();
	System.out.println("City News Details:");
	System.out.println("--------------------------------------------------------");
	System.out.printf("%-10s %-30s %-50s %-15s\n", "News ID", "Title", "Content", "Publish Date");
	System.out.println("--------------------------------------------------------");

	while (rsGetNews.next()) {
		int getNewsId = rsGetNews.getInt("news_id");
		String getNewsTitle = rsGetNews.getString("title");
		String getNewsContent = rsGetNews.getString("content");
		Date getPublishDate = rsGetNews.getDate("publish_date");

		System.out.printf("%-10s %-30s %-50s %-15s\n", getNewsId, getNewsTitle, getNewsContent,
				getPublishDate);
	}
}
}

