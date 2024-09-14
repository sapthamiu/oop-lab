package myPackages.p1;
public class Maximum{

	public static int max(int a, int b, int c){
		return a>b?(a>c?a:c):(b>c?b:c);
	}
	public static float max(float a, float b, float c){
		return a>b?(a>c?a:c):(b>c?b:c);
	}
	public static int max(int []a){
		int max = a[0];
		for(int ele:a){
			if(ele>max)
				max = ele;
		}
		return max;
	}
	public static int max(int[][]m){
		int max = m[0][0];
		for(int[] x:m)
			for(int y:x)
          		if (y > max)
                	max = y;
		return max;
	}
}