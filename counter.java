import java.util.Scanner;
class Counter{
	static int count = 0;
	Counter(){
		count++;
	}
	static void showcount(){
		System.out.println("No. of objects created: " + count);
	}
}
class counter{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of objects you want to create: ");
		int n = sc.nextInt();
		Counter ob [] = new Counter [n];
		for( int i = 0 ; i< n; i++)
			ob[i] = new Counter();
		Counter.showcount();

	}
}