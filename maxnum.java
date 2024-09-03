import java.util.Scanner;
class maxnum{
	public static void main(String args[]){
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter 3 numbers: ");
		int a= sc.nextInt();
		int b= sc.nextInt();
		int c= sc.nextInt();
		System.out.println("Maximum = "+max(a,b,c));
	}
	public static int max(int a, int b, int c){
		if(a>b && a>c)
			return a;
		else if(b>a && b>c)
			return b;
		else return c;
	}
	
}