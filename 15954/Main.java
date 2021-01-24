import java.util.Scanner;
import java.math.*;
public class Main {
	public double Mean(int N, int K, int[] a) {
		double sum = 0;
		double result = 0;
		for(int i = N; i<K; i++) {
			sum += a[i];
		}
		result = sum/(double)(K-N);
		return result;
	}
	public double Deviation(int N, int K, int[] a, double M) {
		double sum = 0;
		double result = 0;
		for(int i = N; i<K; i++) {
			sum += Math.pow(a[i]-M, 2);
		}
		result = sum/(double)(K-N);
		return Math.sqrt(result);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Main main = new Main();
		int N = in.nextInt();
		int K = in.nextInt();
		
		double min,temp;
		int[] people = new int[N];
		
		for(int i = 0; i<N; i++) {
			people[i] = in.nextInt();
		}
		
		min = main.Deviation(0,K,people,main.Mean(0,K,people));
		for (int i = 0; i <= N-K; i++) {	//연속된 k개의 인형들의 표준편차 구하기
			for (int j = K; j + i <= N; j++)
			{
				temp = main.Deviation(i, i + j, people,main.Mean(i, i + j,people));
				if (min >= temp) min = temp;
			}
		}
		System.out.println(min);
	}
}
