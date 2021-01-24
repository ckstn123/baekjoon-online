import java.util.Scanner;

public class Main {
    static int[][] matrix;
    static int N;
    static int M;
    static int H;
    static int min = Integer.MAX_VALUE;

    public static boolean check() {
        boolean flag = true;
        for (int i = 1; i <= N; i++) {
            int temp = i;
            for (int j = 1; j <= H; j++) {
                if (matrix[temp][j] == 1) {
                    temp = temp + 1;
                } else if (matrix[temp][j] == 0) {
                    if (matrix[temp - 1][j] == 1)
                        temp = temp - 1;
                }
            }
            if (temp != i) {
                flag = false;
                return flag;
            }
        }
        return flag;
    }

    public static void recursive(int x, int y, int count) {
        if (min <= count)
            return;

        if (check()) {
            if (min > count) {
                min = count;
            }
            return;
        }
        if (count == 3) {
            return;
        }
        for (int j = y; j <= H; j++) {
            for (int i = 1; i < N; i++) {

                if (matrix[i][j] == 1) {
                    i++;
                    continue;
                }
                matrix[i][j] = 1;
                recursive(i + 2, j, count + 1);
                matrix[i][j] = 0;

            }


        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();
        matrix = new int[N + 1][H + 1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            matrix[b][a] = 1;
            //matrix[b + 1][a] = 2;
        }
        recursive(1, 1, 0);
        if (min > 3)
            System.out.println(-1);
        else
            System.out.println(min);
    }
}
