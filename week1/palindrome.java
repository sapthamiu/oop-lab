import java.util.Scanner;
class palindrome{
	public static void main(String args[]){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n=sc.nextInt();
		System.out.println("Reversed no. = "+ reversed(n));
		System.out.println("Palindrome: "+ispalindrome(n));
	}
	public static int reversed(int n){
		int temp=n;
		int rev=0;
		int dig;
		while(temp>0){
			dig= temp%10;
			rev= rev*10 + dig;
			temp/=10;
		}
		return rev;
	}
	public static boolean ispalindrome(int num){
		int rev= reversed(num);
		if (rev==num)
			return true;
		else 
			return false;
	}
}
