package com.corejavproject.corejavausingmaven;

public class VehicleShowroom {
private int model_no;
private String name;
private int price;
private String color;
public VehicleShowroom() {
	super();
}
public VehicleShowroom(int model_no, String name, int price, String color) {
	super();
	this.model_no = model_no;
	this.name = name;
	this.price = price;
	this.color = color;
}
public int getModel_no() {
	return model_no;
}
public void setModel_no(int model_no) {
	this.model_no = model_no;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
@Override
public String toString() {
	return "Showroom [model_no=" + model_no + ", name=" + name + ", price=" + price + ", color=" + color + "]";
}
}
