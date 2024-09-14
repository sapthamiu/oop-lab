package com.course.structure;
public class House extends Building{
	private int bed;
	private int bath;
	public int getbed(){
		return bed;
	}
	public int getbath(){
		return bath;
	}
	public void setbed(int bed){
		this.bed = bed;
	}
	public void setbath(int bath){
		this.bath = bath;
	}
	public House(double sqft, int stories, int bed, int bath){
		super(sqft, stories);
		this.bed = bed;
		this.bath = bath;
	}
	public void display(){
		super.display();
		System.out.println("No. of bedrooms: " + bed + "\nNo. of bathrooms: " + bath);
	}
}
