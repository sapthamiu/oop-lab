package week3;
import java.util.Scanner;
class student{
	String sname;
	int[] marks_array;
	int total;
	double avg;
	void assign(String name,int[] marks){
		sname = name;
		marks_array = marks;
		total = 0;
		avg = 0.0;
	}
	void compute(){
		for(int mark: marks_array)
			total+=mark;
		avg = (double) total/marks_array.length;
	}
	void display(){
		System.out.println("Student name: "+sname);
		System.out.println("Marks: ");
		for(int mark: marks_array)
			System.out.print(mark + " ");
		System.out.println("\nTotal Marks: "+ total);
		System.out.println("Average: "+ avg);
	}
}
class exer1{
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		student stud1 = new student();
		System.out.println("Enter Student name: ");
		String name = sc.nextLine();
		System.out.println("Enter the no. of subjects: ");
		int n = sc.nextInt();
		int[] marks = new int[n];
		System.out.println("Enter marks: ");
		for(int i = 0; i < n; i++)
			marks[i] = sc.nextInt();
		stud1.assign(name,marks);
		stud1.compute();
		stud1.display();
	}

}