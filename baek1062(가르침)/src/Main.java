import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static int n;
    static int k;
    static int max = 0;
    static ArrayList<Character> list;
    static boolean[] visited;
    static String[] words;

    static void combination(int start, int count, int r){
        if(count == r){
            int result = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('a',1);
            map.put('n',1);
            map.put('t',1);
            map.put('i',1);
            map.put('c',1);
            for(int i = 0; i<visited.length; i++){
                if(visited[i]){
                    map.put(list.get(i), 1);
                }
            }
            for(String word : words){
                boolean flag = false;
                for(int i = 0; i<word.length(); i++){
                    if(!map.containsKey(word.charAt(i))){
                        flag = true;
                        break;
                    }
                }
                if(!flag)
                    result++;
            }
            max = Math.max(max, result);
            return;
        }

        for(int i = start; i<list.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                combination(i, count+1, r);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        if(k < 5){
            System.out.println(0);
            return;
        }
        words = new String[n];
        list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            words[i] = sc.next();
            for(int j = 0; j<words[i].length(); j++){
                if(!list.contains(words[i].charAt(j))){
                    list.add(words[i].charAt(j));
                }
            }
        }

        list.remove((Object)'a');
        list.remove((Object)'n');
        list.remove((Object)'t');
        list.remove((Object)'i');
        list.remove((Object)'c');

        if(k-5 >= list.size()){
            System.out.println(n);
            return;
        }
        visited = new boolean[list.size()];

        combination(0, 0, k-5);
        System.out.println(max);
    }
}
