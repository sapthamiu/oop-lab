import java.util.Scanner;
class lsearch{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter size: ");
		int n= sc.nextInt();
		int[] a= new int[n];
		System.out.println("Enter the elements: ");
		for(int i=0;i<n;i++)
			a[i]= sc.nextInt();
		System.out.println("Enter element to search: ");
		int ele = sc.nextInt();
		int pos=-1;
		for(int i=0;i<n;i++){
			if(ele==a[i])
				pos=i+1;
		}
		if(pos<0)
			System.out.println(ele+" not present");
		else System.out.println(ele+" present in position " + pos);  
	}
}