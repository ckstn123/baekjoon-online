
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] time;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int temp = 0;
		time = new int[N+1];		
		int[] result = new int[N+1];
		int[] num = new int[N+1];
		LinkedList<Integer>[] list;
		//boolean[] check = new boolean[N+1];
		
		list = new LinkedList[N+1];
		
		for(int i = 1; i<N+1; i++)
			list[i] = new LinkedList<>();
		
		for(int i = 1; i<N+1; i++) {
			time[i] = in.nextInt();
			num[i] = in.nextInt();
			for(int j = 1; j<num[i]+1; j++) {
				int task = in.nextInt();
				list[task].add(i);
			}
			
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		
		for(int i = 1; i<N+1; i++) {
			if(num[i] == 0) {
				queue.add(i);
			}
			result[i] = time[i];
			
		}
		
		while (!queue.isEmpty()) {
			int q = queue.poll();
			
			for (int src : list[q]) {
				if (result[src] < result[q] + time[src])
					result[src] = result[q] + time[src];
				if (--num[src] == 0) {
					queue.add(src);
				}
			}
		}

		for(int i = 1; i < N+1; i++) {
			temp = Math.max(temp, result[i]);
			
		}

		System.out.println(temp);
	}
						

}