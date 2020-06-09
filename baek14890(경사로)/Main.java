import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int N = sc.nextInt();
        int L = sc.nextInt();
        boolean flag = false;
        int[][] matrix = new int[N][N];
        int[][] state = new int[N][N]; //경사로가 만들어졌는지 확인하는 배열
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        //가로 방향
        for(int i = 0; i<N; i++) {
            flag = true;
            for (int j = 0; j < N-1; j++) {
                if(!flag)
                    break;
                if(matrix[i][j] - matrix[i][j+1] == -1 && j >= L-1){ //왼쪽으로 확인
                    for(int k = 0; k<L; k++){
                        if(state[i][j-k] == 0 && matrix[i][j-k] - matrix[i][j+1] == -1){
                            state[i][j-k] = 1;
                        }
                        else {
                            flag = false;
                            break;
                        }

                    }
                }
                else if(matrix[i][j] - matrix[i][j+1] == 1 && j <= N-L-1){ //오른쪽으로 확인
                    for(int k = 1; k<=L; k++){
                        if(state[i][j+k] == 0 && matrix[i][j+k] - matrix[i][j] == -1){
                            state[i][j+k] = 1;
                        }
                        else {
                            flag = false;
                            break;
                        }

                    }
                }
                else if(matrix[i][j] - matrix[i][j+1] == 0){
                    continue;
                }
                else {
                    flag = false;
                    break;
                }
            }
            //state 배열 한줄씩 초기화
            for(int t = 0; t<N; t++){
                state[i][t] = 0;
            }
            if(flag)
                result++;
        }
        //세로방향
        for(int i = 0; i<N; i++) {
            flag = true;
            for (int j = 0; j < N-1; j++) {
                if(!flag)
                    break;
                if(matrix[j][i] - matrix[j+1][i] == -1 && j >= L-1){//아래쪽으로 확인
                    for(int k = 0; k<L; k++){
                        if(state[j-k][i] == 0 && matrix[j-k][i] - matrix[j+1][i] == -1){
                            state[j-k][i] = 1;
                        }
                        else {
                            flag = false;
                            break;
                        }

                    }
                }
                else if(matrix[j][i] - matrix[j+1][i] == 1 && j <= N-L-1){//위쪽으로 확인
                    for(int k = 1; k<=L; k++){
                        if(state[j+k][i] == 0 && matrix[j+k][i] - matrix[j][i] == -1){
                            state[j+k][i] = 1;
                        }
                        else {
                            flag = false;
                            break;
                        }

                    }
                }
                else if(matrix[j][i] - matrix[j+1][i] == 0){
                    continue;
                }
                else{
                    flag = false;
                    break;
                }
            }
            for(int t = 0; t<N; t++){
                state[t][i] = 0;
            }

            if(flag)
                result++;
        }

        System.out.println(result);
    }


}
