import java.util.Scanner;

public class Main {
	

	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] k = new int[T];
		int[] n = new int[T];
		int[][] m = new int[15][15];
		for(int i = 0; i<15; i++) {
			m[0][i] = i;
			m[i][0] = 0;			
		}
		
		for(int i = 1; i<15; i++) {
			for(int j = 1; j<15; j++) {
				for(int p = j; p>0; p--)
					m[i][j] += m[i-1][p];
			}
				
		}
		for(int i = 0; i<T; i++) {		
			k[i] = in.nextInt();
			n[i] = in.nextInt();
		}
		
		for(int i = 0; i<T; i++)
			System.out.println(m[k[i]][n[i]]);
	}
}
