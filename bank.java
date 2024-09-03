import java.util.Scanner;
class account{
	String depo;
	int accno;
	String acctype;
	double bal;
	static double interest = 7.5;
	account(){
		depo = " ";
		accno = 0;
		acctype = " ";
		bal = 0;
	}
	account(String depo, int accno, String acctype, double bal){
		this.depo = depo;
		this.accno = accno;
		this.acctype = acctype;
		this.bal = bal;
	}
	void deposit(double amount){
		if(amount>0){
			bal += amount;
			System.out.println(amount + " deposited. Total balance = "+ bal);
		}
		else System.out.println("Invalid amount");
	}
	void withdraw(double amount){
		if(amount>0 && bal>=500){
			bal -= amount;
			System.out.println(amount + " withdrawn. Total balance = "+ bal);			
		}
		else System.out.println("Invalid amount of Insufficient balance.");
	}
	void display(){
		System.out.println("Name of depositor: " + depo);
		System.out.println("Account number" + accno);
		System.out.println("Account Type: " + acctype);
		System.out.println("Balance amount: " + bal);
	}
	static void intrate(){
		System.out.println("Rate of Interest: " + interest);
	}
}
class bank{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//default
		account acctemp = new account();
		acctemp.display();
		//parameterized
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		System.out.println("Enter Acc. No. :");
		int acc = sc.nextInt();
		System.out.println("Enter account type: ");
		sc.nextLine();
		String type = sc.nextLine();
		System.out.println("Enter Balance amount: ");
		double balance = sc.nextDouble();
		account newacc = new account(name, acc, type, balance);
		newacc.display();
		newacc.deposit(1000);
		newacc.withdraw(500);
		account.intrate();
		newacc.display();
	}
}