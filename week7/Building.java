package com.course.structure;
public class Building{
    private double sqft;
    private int stories;
    public double getsqft(){
        return sqft;
    }
    public int getstories(){
        return stories;
    }
    public void setsqft(double sqft){
        this.sqft = sqft;
    }
    public void setstories(int stories){
        this.stories = stories;
    }
    public Building(double sqft, int stories){
        this.sqft = sqft;
        this.stories = stories;
    }
    public void display(){
        System.out.println("Square footage: "+ sqft + "\nStories: "+ stories);
    }
}