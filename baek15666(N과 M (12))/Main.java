import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] array;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();
    static void combination(int start, int count){
        if(count == M){
            String str = "";

            for (int temp : stack) {
                str += temp;
                str += " ";
            }
            set.add(str);


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
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        combination(0,0);

        for(String str : set){
            System.out.println(str);
        }
    }
}
