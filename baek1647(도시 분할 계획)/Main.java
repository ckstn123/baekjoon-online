import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static int[] parent;
    static int max = 0;
    static int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y)
            return;
        parent[y] = x;
    }

    static boolean isSameParent(int x, int y){
        x = find(x);
        y = find(y);
        return x == y;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int sum = 0;
        int[][] matrix = new int[m][3];
        parent = new int[n+1];
        for(int i = 1; i<=n; i++){
            parent[i] = i;
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<3; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        Comparator<int[]> comp = (a,b) -> {
          return a[2] - b[2];
        };

        Arrays.sort(matrix,comp);

        for(int i=0; i<m; i++){
            if(!isSameParent(matrix[i][0], matrix[i][1])){
                sum += matrix[i][2];
                max = Math.max(max, matrix[i][2]);
                union(matrix[i][0], matrix[i][1]);
            }
        }

        System.out.println(sum-max);
    }
}
