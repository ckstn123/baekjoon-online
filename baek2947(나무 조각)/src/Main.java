import java.util.Scanner;

public class Main {
    static int[] numbers;
    static boolean check(){
        for(int i = 0; i<5; i++){
            if(numbers[i] != i+1){
                return false;
            }
        }
        return true;
    }

    static void swap(int left, int right){
        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        numbers = new int[5];
        for(int i = 0; i<5; i++){
            numbers[i] = sc.nextInt();
        }

        while(!check()){
            for(int i = 0; i<4; i++){
                if(numbers[i] > numbers[i+1]){
                    swap(i, i+1);
                    for(int temp : numbers)
                        System.out.print(temp + " ");
                    System.out.println();
                }
            }
        }
    }
}
