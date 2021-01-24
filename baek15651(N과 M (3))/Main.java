import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N;
    static int M;
    static int[] array;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Stack<Integer> stack = new Stack<>();
    static void permutation(int count) throws IOException {
        if(count == M){
            for(int temp : stack){
                bw.write(String.valueOf(temp) + " ");
            }
            bw.newLine();
            bw.flush();
            return;
        }

        for(int i = 0; i<N; i++){
            stack.push(array[i]);
            permutation(count + 1);
            stack.pop();
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        array = new int[N];
        for(int i = 0; i<N; i++){
            array[i] = i+1;
        }
        permutation(0);
    }
}
