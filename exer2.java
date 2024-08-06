import java.util.Scanner;
class employee{
	String ename;
	int eid;
	double basic, da, gross_sal, net_sal;
	void read(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee name: ");
		ename = sc.nextLine();
		System.out.println("Enter Employee ID: ");
		eid = sc.nextInt();
		System.out.println("Enter basic salary: ");
		basic = sc.nextDouble();
		compute_net_sal();
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
class exer2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of employees: ");
		int n = sc.nextInt();
		employee employees[] = new employee[n];
		System.out.println("Enter employee details: ");
		for(int i=0;i<n;i++){
			employees[i] = new employee();
			System.out.println("Employee " + (i+1));
			employees[i].read();
		}
		for(employee emp:employees)
			emp.display();
	}
}