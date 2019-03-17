import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Main main = new Main();
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] result = new int[T];
		for (int i = 0; i < T; i++)
			result[i] = 0;
		for (int t = 0; t < T; t++) {
			int count = 0;
			int H = in.nextInt();
			if (H >= 1 && H <= 99)
				H = H;
			else
				return;

			int W = in.nextInt();
			if (W >= 1 && W <= 99)
				W = W;
			else
				return;
			int N = in.nextInt();
			if (N >= 1 && N <= H * W)
				N = N;
			else
				return;

			int[][] build = new int[W][H];
			for (int i = 0; i < W; i++) {
				for (int j = 0; j < H; j++) {
					if (build[i][j] != 1) {
						count++;
						if (N == count) {
							result[t] = 100 * (j + 1) + i + 1;
						}
					}
				}
			}

		}
		for (int i = 0; i < T; i++)
			System.out.println(result[i]);
	}

}
