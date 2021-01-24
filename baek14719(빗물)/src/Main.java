import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int max = 0;
        int H = sc.nextInt();
        int W = sc.nextInt();
        int[] blocks = new int[W];
        int[] left = new int[W];
        int[] right = new int[W];
        for(int i = 0; i <W; i++){
            blocks[i] = sc.nextInt();
            max = Math.max(max, blocks[i]);
            left[i] = max;
        }
        max = 0;
        for(int i = W-1; i>= 0; i--){
            max = Math.max(max, blocks[i]);
            right[i] = max;
        }

        for(int i = 1; i<W-1; i++){
            result += Math.min(left[i], right[i]) - blocks[i];
        }

        System.out.println(result);
    }
}
