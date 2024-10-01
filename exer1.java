import java.util.Scanner;
class employee{
	String ename;
	int eid;
	double basic, da, gross_sal, net_sal;
	employee(){
		System.out.println("Inside Default constructor");
		ename = " ";
		eid = 0;
		basic = 0;
		da = 0;
		gross_sal = 0;
		net_sal = 0;
	}

	employee(String ename, int eid,double basic){
		System.out.println("Inside parameterized constructor");
		this.ename = formatemployeename(ename);
		this.eid = eid;
		this.basic = basic;
		compute_net_sal();
	}
	String formatemployeename(String ename){
		int space = ename.indexOf(" ");
		String firstname = ename.substring(0,1).toUpperCase()+ ename.substring(1,space).toLowerCase();
		
		String lastname = ename.substring(space+1, space+2).toUpperCase() + ename.substring(space+2, ename.length()).toLowerCase();		
		return (firstname + " " +lastname);
	}
	String generatemail(){
		int space = ename.indexOf(" ");
		String mail = ename.substring(0,1).toLowerCase()+ ename.substring(space+1, ename.length()).toLowerCase()+"@example.com";
		return mail;
	}
	
	void compute_net_sal(){
		da = 0.52 * basic;
		gross_sal = basic + da;
		double it = 0.3 * gross_sal;
		net_sal = gross_sal - it;
	}
	
	void display(){
		System.out.println("Employee name: " + ename);
		System.out.println("Employee ID: " + eid);
		System.out.println("Basic salary: " + basic);
		System.out.println("DA: " + da);
		System.out.println("Gross Salary: " + gross_sal);
		System.out.println("Net Salary: " + net_sal);
	}

}
class exer1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//default constructor
		employee emptemp = new employee();
		emptemp.display();
		System.out.println("Enter no. of employees: ");
		int n = sc.nextInt();
		sc.nextLine();
		//parameterized constructor
		employee employees[] = new employee[n];
		System.out.println("Enter employee details: ");
		for(int i=0;i<n;i++){
			sc.nextLine();
			
			System.out.println("Employee " + (i+1));
			System.out.println("Enter Employee name: ");
			String ename = sc.nextLine();
			System.out.println("Enter Employee ID: ");
			int eid = sc.nextInt();
			System.out.println("Enter basic salary: ");
			double basic = sc.nextDouble();
			employees[i] = new employee(ename, eid, basic);
			
		}

		for(employee emp:employees){
			emp.display();
			System.out.println("Employee mail id: "+emp.generatemail());
		}
	}
}