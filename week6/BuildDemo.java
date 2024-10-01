import java.util.Scanner;
class Building{
	private double sqft;
	private int stories;
	double getsqft(){
		return sqft;
	}
	int getstories(){
		return stories;
	}
	void getsqft(double sqft){
		this.sqft = sqft;
	}
	void getstories(int stories){
		this.stories = stories;
	}
	Building(double sqft, int stories){
		this.sqft = sqft;
		this.stories = stories;
	}
	void display(){
		System.out.println("Square footage: "+ sqft + "\nStories: "+ stories);
	}
}
class House extends Building{
	private int bed;
	private int bath;
	int getbed(){
		return bed;
	}
	int getbath(){
		return bath;
	}
	void setbed(int bed){
		this.bed = bed;
	}
	void setbath(int bath){
		this.bath = bath;
	}
	House(double sqft, int stories, int bed, int bath){
		super(sqft, stories);
		this.bed = bed;
		this.bath = bath;
	}
	void display(){
		super.display();
		System.out.println("No. of bedrooms: " + bed + "\nNo. of bathrooms: " + bath);
	}
}
class School extends Building{
	private int clroom;
	private String grade;
	int getclroom(){
		return clroom;
	}
	String getgrade(){
		return grade;
	}
	void setclroom(int clroom){
		this.clroom = clroom;
	}
	void setgrade(String grade){
		this.grade = grade;
	}
	School(double sqft, int stories, int clroom, String grade){
		super(sqft, stories);
		this.clroom = clroom;
		this.grade = grade;
	}
	void display(){
		super.display();
		System.out.println("No. of classrooms: " + clroom + "\nGrade: " + grade);
	}
}
public class BuildDemo{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//General Building
		System.out.println("Enter square footage: ");
		double sqft = sc.nextDouble();
		System.out.println("Enter no. of stories: ");
		int stories = sc.nextInt();
		System.out.println("--Menu--\n1. House\n2. School\n3. Exit");
		int choice;
		do{
			System.out.println("Your choice: ");
			choice = sc.nextInt();
			if(choice==1){
				System.out.println("Enter no. of bedrooms: ");
				int bed = sc.nextInt();
				System.out.println("Enter no. of bathrooms: ");
				int bath = sc.nextInt();
				House house = new House(sqft,stories,bed,bath);
				System.out.println("--House Details--");
				house.display();
			}
			else if(choice == 2){
				System.out.println("Enter no. of classrooms: ");
				int clroom = sc.nextInt();
				System.out.println("Enter grade: ");
				String grade = sc.next();
				//sc.next();
				School school = new School(sqft, stories, clroom, grade);
				System.out.println("--School Details--");
				school.display();
			}
			else System.out.println("Exiting.");
		}while(choice == 1 || choice == 2);
		sc.close();
	}
}