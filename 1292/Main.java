import java.util.Scanner;

public class Main {
public static void main(String args[]) {
		int t = 0;
		int count = 1;
		Scanner in = new Scanner(System.in);
		for(int i = 1; i<=1000; i++) {
			t += i;
		}
		int[] a = new int[t+1];
		
		for(int i=0; i<1000; i++) {
			for(int j=0; j<i; j++) {
				a[count++] = i;
			}
		}
		int n = in.nextInt();
		int m = in.nextInt();
		int result = 0;
		for(int i = n; i<=m; i++)
			result += a[i];
		
		System.out.println(result);
	}
	
}
