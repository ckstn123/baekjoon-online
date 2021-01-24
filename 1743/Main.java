import java.util.Scanner;

public class Main {

	public int recursive(int[][] a, int n, int m, int[][] visited, int N, int M) {
		int count = 1;
		if (n != 0)
			if (a[n - 1][m] == 1 && visited[n - 1][m] != 1) {
				//count++;
				visited[n - 1][m] = 1;
				count += recursive(a, n - 1, m, visited, N, M);
			}
		if (m != 0)
			if (a[n][m - 1] == 1 && visited[n][m - 1] != 1) {
				//count++;
				visited[n][m - 1] = 1;
				count += recursive(a, n, m - 1, visited, N, M);
			}
		if (n < N - 1)
			if (a[n + 1][m] == 1 && visited[n + 1][m] != 1) {
				//count++;
				visited[n + 1][m] = 1;
				count += recursive(a, n + 1, m, visited, N, M);
			}
		if (m < M - 1)
			if (a[n][m + 1] == 1 && visited[n][m + 1] != 1) {
				//count++;
				visited[n][m + 1] = 1;
				count += recursive(a, n, m + 1, visited, N, M);
			}
		return count;

	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Main main = new Main();
		int t1 = 0;
		int t2 = 0;
		int N = in.nextInt();
		if (1 <= N && N <= 100)
			N = N;
		else
			return;
		int M = in.nextInt();
		if (1 <= M && M <= 100)
			M = M;
		else
			return;

		int[][] result = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				result[i][j] = 0;
		int K = in.nextInt();
		
		if (1 <= K && K <= 10000)
			K = K;
		else
			return;

		int r;
		int c;
		for (int i = 0; i < K; i++) {
			r = in.nextInt();
			c = in.nextInt();
			result[r - 1][c - 1] = 1;
		}
		int[][] visited = new int[N][M];

		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				if (result[i][j] == 1 && visited[i][j] == 0) {

					visited[i][j] = 1;
					t1 = main.recursive(result, i, j, visited, N, M);
					if (t1 >= t2)
						t2 = t1;
				}
			}
		}

		System.out.println(t2);
	}

}
