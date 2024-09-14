import java.util.Scanner;
class Student{
	String sname;
	int[] marks;
	int total;
	double avg;
	// default constructor
	// Student(){
	// 	System.out.println("Inside default constructor");
	// 	sname = " ";
	// 	marks = new int[5];
	// 	total = 0;
	// 	avg = 0.0;
	// }
	Student(String sname, int[] marks){
		System.out.println("Inside parameterized constructor");
		this.sname = sname;
		this.marks = new int[5];
		this.marks = marks;
		total = 0;
		avg = 0.0;
		//compute();
		
	}
	void compute(){
		for(int mark: marks)
			total+=mark;
		avg = (double) total/marks.length;
	}
	void display(){
		System.out.println("Student name: "+sname);
		System.out.println("Marks: ");
		for(int mark: marks)
			System.out.print(mark + " ");
		System.out.println("\nTotal Marks: "+ total);
		System.out.println("Average: "+ avg);
	}
}
class ScienceStudent extends Student{
	private int practicalMarks;
	ScienceStudent(String name, int[] marks, int practical){
		super(name, marks);
		practicalMarks = practical;
	}
	void compute(){
		super.compute();
		total += practicalMarks;
		avg = (double) total / (marks.length + 1);
	}
	void displayPracticalMarks(){
		System.out.println("Practical Marks: " + practicalMarks);
	}
}
class ArtsStudent extends Student{
	private String electiveSubject;
	ArtsStudent(String name, int[] marks, String elective){
		super(name, marks);
		electiveSubject = elective;
	}
	void displayElective(){
		System.out.println("Elective subject: " + electiveSubject);
	}
}
public class Studemo{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		// //default constructor
		// Student stud1 = new Student();
		// stud1.display();

		//General student
		System.out.println("Enter Student name: ");
		String name = sc.nextLine();
		System.out.println("Enter the no. of subjects: ");
		int n = sc.nextInt();
		int[] marks = new int[n];
		System.out.println("Enter marks: ");
		for(int i = 0; i < n; i++)
			marks[i] = sc.nextInt();
		Student stud2 = new Student(name, marks);
		stud2.compute();
		stud2.display();

		//Science Student
		System.out.println("Enter the Science student's name: ");
		String namesci = sc.nextLine();
		//sc.next();
		System.out.println("Enter no. of subjects: ");
		int nsci = sc.nextInt();
		int []marksci = new int[nsci];
		System.out.println("Enter marks: ");
		for(int i = 0; i< nsci; i++)
			marksci[i] = sc.nextInt();
		System.out.println("Enter practical marks: ");
		int practical = sc.nextInt();
		ScienceStudent stud3 = new ScienceStudent(namesci, marksci, practical);
		stud3.compute();
		stud3.display();
		stud3.displayPracticalMarks();

		//Arts Student
		System.out.println("Enter the Arts student's name: ");
		String nameart = sc.nextLine();
		//sc.next();
		System.out.println("Enter no. of subjects: ");
		int nart = sc.nextInt();
		int []marksart = new int[nart];
		System.out.println("Enter marks: ");
		for(int i = 0; i< nart; i++)
			marksart[i] = sc.nextInt();
		System.out.println("Enter elective subject: ");
		String elective = sc.nextLine();
		//sc.next();
		ArtsStudent stud4 = new ArtsStudent(nameart, marksart, elective);
		stud4.compute();
		stud4.display();
		stud4.displayElective();


		//polymorphism
		Student ref = stud3;
		ref.display();
	}

}