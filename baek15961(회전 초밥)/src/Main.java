import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] numbers = new int[n];
        for(int i = 0; i<n; i++){
            numbers[i] = sc.nextInt();
        }
        for(int i =0; i<k; i++){
            if(!map.containsKey(numbers[i])){
                map.put(numbers[i], 1);
            }
            else {
                int count = map.get(numbers[i]);
                map.put(numbers[i], count+1);
            }
        }
        if(map.containsKey(c))
            max = map.size();
        else
            max = map.size()+1;
        int left = 0;
        int right = k-1;
        int cnt = 0;
        while(right != k-2){
            if(map.get(numbers[left]) == 1)
                map.remove(numbers[left]);
            else {
                int count = map.get(numbers[left]);
                map.put(numbers[left], count-1);
            }
            left = (left+1)%n;
            right = (right+1)%n;
            if(!map.containsKey(numbers[right])){
                map.put(numbers[right], 1);
            }
            else {
                int count = map.get(numbers[right]);
                map.put(numbers[right], count+1);
            }
            if(map.containsKey(c))
                cnt = map.size();
            else
                cnt = map.size()+1;

            max = Math.max(max , cnt);
        }

        System.out.println(max);
    }
}
