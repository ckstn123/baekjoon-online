import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int min = Integer.MAX_VALUE;

    static ArrayList<camera> cam_list = new ArrayList<>();
    static class camera{
        int x,y,num;

        public camera(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static void deep_copy(int[][] matrix, int[][] new_matrix){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                new_matrix[i][j] = matrix[i][j];
            }
        }
    }

    static void dfs(int[][] matrix, int camera_count, int size){
        if(camera_count == size){
            int count = 0;
            for(int i = 0; i<n; i++) {
                for (int j = 0; j < m; j++) {
                    if(matrix[i][j] == 0)
                        count++;
                }
            }
            min = Math.min(min, count);
            return;
        }
        int[][] new_matrix = new int[n][m];
        if(cam_list.get(camera_count).num == 1){
            deep_copy(matrix, new_matrix);
            up(new_matrix, cam_list.get(camera_count));
            dfs(new_matrix, camera_count+1, size);

            deep_copy(matrix, new_matrix);
            down(new_matrix, cam_list.get(camera_count));
            dfs(new_matrix, camera_count+1, size);

            deep_copy(matrix, new_matrix);
            left(new_matrix, cam_list.get(camera_count));
            dfs(new_matrix, camera_count+1, size);

            deep_copy(matrix, new_matrix);
            right(new_matrix, cam_list.get(camera_count));
            dfs(new_matrix, camera_count+1, size);
        }
        else if(cam_list.get(camera_count).num == 2){
            deep_copy(matrix, new_matrix);
            up(new_matrix, cam_list.get(camera_count));
            down(new_matrix, cam_list.get(camera_count));
            dfs(new_matrix, camera_count+1, size);

            deep_copy(matrix, new_matrix);
            left(new_matrix, cam_list.get(camera_count));
            right(new_matrix, cam_list.get(camera_count));
            dfs(new_matrix, camera_count+1, size);
        }
        else if(cam_list.get(camera_count).num == 3){
            deep_copy(matrix, new_matrix);
            up(new_matrix, cam_list.get(camera_count));
            left(new_matrix, cam_list.get(camera_count));
            dfs(new_matrix, camera_count+1, size);

            deep_copy(matrix, new_matrix);
            down(new_matrix, cam_list.get(camera_count));
            left(new_matrix, cam_list.get(camera_count));
            dfs(new_matrix, camera_count+1, size);

            deep_copy(matrix, new_matrix);
            up(new_matrix, cam_list.get(camera_count));
            right(new_matrix, cam_list.get(camera_count));
            dfs(new_matrix, camera_count+1, size);

            deep_copy(matrix, new_matrix);
            down(new_matrix, cam_list.get(camera_count));
            right(new_matrix, cam_list.get(camera_count));
            dfs(new_matrix, camera_count+1, size);
        }
        else if(cam_list.get(camera_count).num == 4){
            deep_copy(matrix, new_matrix);
            up(new_matrix, cam_list.get(camera_count));
            left(new_matrix, cam_list.get(camera_count));
            down(new_matrix, cam_list.get(camera_count));
            dfs(new_matrix, camera_count+1, size);

            deep_copy(matrix, new_matrix);
            up(new_matrix, cam_list.get(camera_count));
            right(new_matrix, cam_list.get(camera_count));
            down(new_matrix, cam_list.get(camera_count));
            dfs(new_matrix, camera_count+1, size);

            deep_copy(matrix, new_matrix);
            left(new_matrix, cam_list.get(camera_count));
            up(new_matrix, cam_list.get(camera_count));
            right(new_matrix, cam_list.get(camera_count));
            dfs(new_matrix, camera_count+1, size);

            deep_copy(matrix, new_matrix);
            left(new_matrix, cam_list.get(camera_count));
            down(new_matrix, cam_list.get(camera_count));
            right(new_matrix, cam_list.get(camera_count));
            dfs(new_matrix, camera_count+1, size);
        }
        else{
            deep_copy(matrix, new_matrix);
            up(new_matrix, cam_list.get(camera_count));
            down(new_matrix, cam_list.get(camera_count));
            left(new_matrix, cam_list.get(camera_count));
            right(new_matrix, cam_list.get(camera_count));
            dfs(new_matrix, camera_count+1, size);
        }
    }

    static void up(int[][] matrix,camera cam){
        int x = cam.x;
        int y = cam.y;
        for(int i = y; i<n; i++){
            if(matrix[i][x] == 6){
                break;
            }
            if(matrix[i][x] == 0){
                matrix[i][x] = 10;
            }
        }
    }
    static void down(int[][] matrix,camera cam){
        int x = cam.x;
        int y = cam.y;
        for(int i = y; i>=0; i--){
            if(matrix[i][x] == 6){
                break;
            }
            if(matrix[i][x] == 0){
                matrix[i][x] = 10;
            }
        }
    }
    static void right(int[][] matrix,camera cam){
        int x = cam.x;
        int y = cam.y;
        for(int i = x; i<m; i++){
            if(matrix[y][i] == 6){
                break;
            }
            if(matrix[y][i] == 0){
                matrix[y][i] = 10;
            }
        }
    }
    static void left(int[][] matrix,camera cam){
        int x = cam.x;
        int y = cam.y;
        for(int i = x; i>=0; i--){
            if(matrix[y][i] == 6){
                break;
            }
            if(matrix[y][i] == 0){
                matrix[y][i] = 10;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                matrix[i][j] = sc.nextInt();
                if(matrix[i][j] > 0 && matrix[i][j] < 6){
                    cam_list.add(new camera(j,i,matrix[i][j]));
                }
            }
        }

        int size = cam_list.size();
        dfs(matrix, 0, size);

        System.out.println(min);
    }
}
