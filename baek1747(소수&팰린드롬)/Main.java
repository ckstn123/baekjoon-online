import java.util.Scanner;

public class Main {
    public static boolean check(String temp){
        String compare = "";
        for(int i = temp.length() - 1; i>=0; i--){
            compare += temp.charAt(i);
        }

        if(compare.equals(temp))
            return true;
        return false;
    }

    static boolean isPrime(int temp){

        for(int i = 2; i<=temp/2; i++){
            if(temp % i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N==1){
            N++;
        }

        while (true){
            if(check(String.valueOf(N)) && isPrime(N)){
                break;
            }
            N++;
        }

        System.out.println(N);
    }
}
