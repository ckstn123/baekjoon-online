
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static LinkedList<Integer>[] list;
	static int[] time;

	public static void main(String args[]) {
		Main main = new Main();
		Scanner in = new Scanner(System.in);

		N = in.nextInt();
		if (N >= 1 && N <= 500)
			N = N;
		else
			return;
		int[] result = new int[N + 1];
		int[] check = new int[N + 1];
		time = new int[N + 1];

		list = new LinkedList[N + 1];
		for (int i = 1; i < N + 1; i++)
			list[i] = new LinkedList<>();
		for (int i = 1; i < N + 1; i++) {
			time[i] = in.nextInt();
			while (true) {
				int C = in.nextInt();

				if (C == -1)
					break;

				list[C].add(i);
				check[i]++;

			}

		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i < N + 1; i++) {
			if (check[i] == 0)
				queue.add(i);
			result[i] = time[i];
		}

		while (!queue.isEmpty()) {
			int q = queue.poll();

			for (int src : list[q]) {
				if (result[src] < result[q] + time[src])
					result[src] = result[q] + time[src];
				if (--check[src] == 0) {
					queue.add(src);
				}
			}
		}

		for (int i = 1; i < N + 1; i++)
			System.out.println(result[i]);
	}
}
