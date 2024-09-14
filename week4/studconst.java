import java.util.Scanner;
class student{
	String sname;
	int[] marks_array;
	int total;
	double avg;
	// default constructor
	student(){
		System.out.println("Inside default constructor");
		sname = " ";
		marks_array = new int[5];
		//marks_array = {0};
		total = 0;
		avg = 0.0;
	}
	student(String sname, int[] marks_array){
		System.out.println("Inside parameterized constructor");
		this.sname = sname;
		this.marks_array = marks_array;
		compute();
		
	}
	/*void assign(String name,int[] marks){
		sname = name;
		marks_array = marks;
		total = 0;
		avg = 0.0;
	}
	*/
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
class studconst{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//default constructor
		student stud1 = new student();
		stud1.display();
		System.out.println("Enter Student name: ");
		String name = sc.nextLine();
		System.out.println("Enter the no. of subjects: ");
		int n = sc.nextInt();
		int[] marks = new int[n];
		System.out.println("Enter marks: ");
		for(int i = 0; i < n; i++)
			marks[i] = sc.nextInt();
		/*stud1.assign(name,marks);
		stud1.compute();
		stud1.display();
		*/
		student stud2 = new student(name, marks);
		stud2.display();
	}

}