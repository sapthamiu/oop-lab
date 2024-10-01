package com.course.structure;
public class School extends com.course.structure.Building {
	private int clroom;
	private String grade;
	public int getclroom(){
		return clroom;
	}
	public String getgrade(){
		return grade;
	}
	public void setclroom(int clroom){
		this.clroom = clroom;
	}
	public void setgrade(String grade){
		this.grade = grade;
	}
	public School(double sqft, int stories, int clroom, String grade){
		super(sqft, stories);
		this.clroom = clroom;
		this.grade = grade;
	}
	public void display(){
		super.display();
		System.out.println("No. of classrooms: " + clroom + "\nGrade: " + grade);
	}
}
