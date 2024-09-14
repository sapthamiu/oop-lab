import java.util.Scanner;
class Employee{
	String ename;
	int eid;
	double basic, da, gross_sal, net_sal;
	/*Employee(){
		System.out.println("Inside Default constructor");
		ename = " ";
		eid = 0;
		basic = 0;
		da = 0;
		gross_sal = 0;
		net_sal = 0;
	}*/

	Employee(String ename, int eid,double basic){
		System.out.println("Inside parameterized constructor");
		//this.ename = formatemployeename(ename);
		this.ename = ename;
		this.eid = eid;
		this.basic = basic;
		//calculateSalary();
	}
	// String formatemployeename(String ename){
	// 	int space = ename.indexOf(" ");
	// 	String firstname = ename.substring(0,1).toUpperCase()+ ename.substring(1,space).toLowerCase();
		
	// 	String lastname = ename.substring(space+1, space+2).toUpperCase() + ename.substring(space+2, ename.length()).toLowerCase();		
	// 	return (firstname + " " +lastname);
	// }
	// String generatemail(){
	// 	int space = ename.indexOf(" ");
	// 	String mail = ename.substring(0,1).toLowerCase()+ ename.substring(space+1, ename.length()).toLowerCase()+"@example.com";
	// 	return mail;
	// }
	
	void calculateSalary(){
		da = 0.52 * basic;
		gross_sal = basic + da;
		double it = 0.3 * gross_sal;
		net_sal = gross_sal - it;
	}
	
	void displayEmployeeDetails(){
		System.out.println("Employee name: " + ename);
		System.out.println("Employee ID: " + eid);
		System.out.println("Basic salary: " + basic);
		System.out.println("DA: " + da);
		System.out.println("Gross Salary: " + gross_sal);
		System.out.println("Net Salary: " + net_sal);
	}

}
class FullTimeEmp extends Employee{
	double bonus;
	double deductions;
	FullTimeEmp(String ename, int eid,double basic, double bonus, double deductions){
		super(ename, eid, basic);
		this.bonus = bonus;
		this.deductions = deductions;
	}
	void calculateSalary(){
		super.calculateSalary();
		net_sal += (bonus-deductions);
	}
	void displayEmployeeDetails(){
		super.displayEmployeeDetails();
		System.out.println("Bonus: " + bonus + "Deductions: " + deductions);		
	}
}
class PartTimeEmp extends Employee{
	int hoursWorked;
	final static double hourlyRate = 100;
	PartTimeEmp(String name, int eid, int hours){
		super(name, eid, 0);
		hoursWorked=hours;
	}
	void calculateSalary(){
		net_sal= hoursWorked*hourlyRate;
	}
	void displayEmployeeDetails(){

		System.out.println("Employee name: " + ename);
		System.out.println("Employee ID: " + eid);
		System.out.println("Hours Worked: " + hoursWorked);
		System.out.println("Net Salary: " + net_sal);

	}
}
public class Empdemo{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// //default constructor
		// Employee emptemp = new Employee();
		// emptemp.display();
		// System.out.println("Enter no. of employees: ");
		// int n = sc.nextInt();
		// sc.nextLine();

		//parameterized constructor
		// Employee employees[] = new Employee[n];
		// System.out.println("Enter employee details: ");
		// for(int i=0;i<n;i++){
		// 	sc.nextLine();
			
		// 	System.out.println("Employee " + (i+1));
		// 	System.out.println("Enter Employee name: ");
		// 	String ename = sc.nextLine();
		// 	System.out.println("Enter Employee ID: ");
		// 	int eid = sc.nextInt();
		// 	System.out.println("Enter basic salary: ");
		// 	double basic = sc.nextDouble();
		// 	employees[i] = new Employee(ename, eid, basic);
			
		// }

		// for(Employee emp:employees){
		// 	emp.display();
		// 	System.out.println("Employee mail id: "+emp.generatemail());
		// }

		//General Employee
		System.out.println("Enter employee name and employee ID: ");
		String name = sc.nextLine();
		int id = sc.nextInt();
		System.out.println("Enter basic salary: ");
		double basic = sc.nextDouble();
		Employee emp1 = new Employee(name,id,basic);
		emp1.calculateSalary();
		emp1.displayEmployeeDetails();

		//Part-time Employee
		System.out.println("Enter part-time employee name and employee ID: ");
		String pname = sc.nextLine();
		int pid = sc.nextInt();
		System.out.println("Enter hours worked: ");
		int hours = sc.nextInt();
		PartTimeEmp emp2 = new PartTimeEmp(pname,pid,hours);
		emp2.calculateSalary();
		emp2.displayEmployeeDetails();

		//Full-time Employee
		System.out.println("Enter Full-time employee name and employee ID: ");
		String fname = sc.nextLine();
		int fid = sc.nextInt();
		System.out.println("Enter basic salary: ");
		int fbasic = sc.nextInt();
		System.out.println("Enter bonus: ");
		double bonus = sc.nextDouble();
		System.out.println("Enter deductions: ");
		double deduct = sc.nextDouble();
		FullTimeEmp emp3 = new FullTimeEmp(fname,fid,fbasic, bonus, deduct);
		emp3.calculateSalary();
		emp3.displayEmployeeDetails();
	}
}