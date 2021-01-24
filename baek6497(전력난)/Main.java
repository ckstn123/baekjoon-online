import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static int[] parent;

    static int find(int x){
        if(x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y){
            return;
        }
        parent[y] = x;
    }

    static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            if(m == 0 && n == 0)
                break;
            long sum = 0;
            long total = 0;
            long[][] matrix = new long[n][3];
            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                long c = sc.nextLong();
                total += c;
                matrix[i][0] = a;
                matrix[i][1] = b;
                matrix[i][2] = c;
            }

            Comparator<long[]> comp = (a, b) -> {
                return (int) (a[2] - b[2]);
            };
            Arrays.sort(matrix, comp);

            for (int i = 0; i < n; i++) {
                int x = (int) matrix[i][0];
                int y = (int) matrix[i][1];
                if (!isSameParent(x, y)) {
                    sum += matrix[i][2];
                    union(x, y);
                }
            }
            System.out.println(total - sum);
        }
    }
}
