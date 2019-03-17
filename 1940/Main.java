package baek01;

import java.util.Scanner;

public class Main {
	public static int make(int a, int b, int[] p) {
		int count = 0;
		for(int i = 0; i<p.length-1; i++)
			for(int j = i+1; j<p.length; j++) {
				int t = p[i]+p[j];
				if(b == t)
					count++;
			}
		return count;
	}
	
	public static void main(String args[]) {		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		if(N >= 1 && N <= 15000)
			N=N;
		else
			return;
		int M = in.nextInt();
		if(M >= 1 && M <= 10000000)
			M=M;
		else
			return;
		int[] p = new int[N];
		
		for(int i = 0; i<N; i++) {		
			p[i] = in.nextInt();
		}
		System.out.println(make(N,M,p));			    
	}
}
