import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N;
    static int M;
    static int[] array;
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();
    static void combination(int start, int count){
        if(count == M){
            for(int temp : stack){
                System.out.print(temp + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i<N; i++){
            stack.push(array[i]);
            combination(i,count + 1);
            stack.pop();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        array = new int[N];
        visited = new boolean[N];
        for(int i = 0; i<N; i++){
            array[i] = i+1;
        }
        combination(0,0);
    }
}
