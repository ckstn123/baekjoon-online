import java.util.Scanner;

public class Main {
    static int[][] Gear;
    static void swap(int a, int b, int num){
        int temp = Gear[a][num];
        Gear[a][num] = Gear[b][num];
        Gear[b][num] = temp;
    }
    static void rotation(int num, int dir){
        if(dir == 1){
            for(int i = 1; i<8; i++){
                swap(0, i, num);
            }
        }
        else if(dir == -1){
            for(int i = 0; i<7; i++){
                swap(i+1, i, num);
            }
        }
    }
    static void compare(int num, int dir){
        int[] check = new int[4];
        check[num] = dir;
        for(int i = num; i<3; i++){
            if(Gear[2][i] != Gear[6][i+1]){
                check[i+1] = -check[i];
            }
            else
                check[i+1] = 0;
//            if(i > 0){
//                if(Gear[6][i] != Gear[2][i-1]){
//                    check[i-1] = -dir;
//                }
//                else
//                    check[i-1] = 0;
//            }
        }
        for(int i = num; i>0; i--){
            if(Gear[6][i] != Gear[2][i-1]){
                check[i-1] = -check[i];
            }
            else
                check[i-1] = 0;
        }
        for(int i = 0; i<4; i++){
            rotation(i, check[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gear = new int[8][4];
        int result = 0;
        for(int i = 0; i<4; i++){
            String temp = sc.nextLine();
            for(int j = 0; j<8; j++){
                int num = temp.charAt(j) - '0';
                Gear[j][i] = num;
            }
        }
        int K = sc.nextInt();
        for(int i = 0; i<K; i++){
            int num = sc.nextInt() -1;
            int dir = sc.nextInt();
            compare(num,dir);

        }
        for(int i = 0; i<4; i++){
            if(Gear[0][i] == 1){
                result += Math.pow(2, i);
            }
        }
        System.out.println(result);
    }
}
