import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] array;
    static boolean[] visited;
    static void combination(int start, int count){
        if(count == M){
            for(int i = 0; i<N; i++){
                if(visited[i])
                System.out.print(array[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i<N; i++){
            if(!visited[i]) {
                visited[i] = true;
                combination(i + 1,count + 1);
                visited[i] = false;
            }
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
