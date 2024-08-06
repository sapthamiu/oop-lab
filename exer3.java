import java.util.Scanner;
class mixer{
	int arr[];
	void accept(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int m = sc.nextInt();
		System.out.println("Enter the sorted array: ");
		arr=new int[n];
		for(int i = 0; i< n; i++)
			arr[i] = sc.nextInt();
	}
	mixer mix(mixer A){
		mixer res = new mixer();
		res.arr = new int [this.arr.length + A.arr.length];
		for(int i =0; )

				
	}
	void display(){
		System.out.println("Array: \n");
		for(ele: arr)
			System.out.print(ele + " ");
	}
}
class exer3{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		mixer mixer1 = new mixer();
		mixer mixer2 = new mixer();
		mixer1.accept();
		mixer2.accept();
		mixer resultant = mixer1.mix(mixer2);
		resultant.display();
	}
}