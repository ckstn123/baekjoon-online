import java.util.Scanner;
import java.math.*;
public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Main main = new Main();
		int result;
		int N = in.nextInt();
		int[][] rgb = new int[N+1][3];
		int[][] d = new int[N+1][3];
		
		for(int i = 1; i<=N; i++) {
			for(int j = 0; j<3; j++) {			
				rgb[i][j] = in.nextInt();
			}
		}
		
		for(int i = 1; i<=N; i++) {
			d[i][0] = Math.min(d[i-1][1],d[i-1][2]) + rgb[i][0];
			d[i][1] = Math.min(d[i-1][0],d[i-1][2]) + rgb[i][1];
			d[i][2] = Math.min(d[i-1][0],d[i-1][1]) + rgb[i][2];
		}
		
		result = d[N][0];
		for(int i = 0; i<3; i++) {
			if(result > d[N][i])
				result = d[N][i];
		}
		System.out.println(result);
	}

}
