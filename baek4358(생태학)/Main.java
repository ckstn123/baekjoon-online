import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static TrieNode rootNode;
    static class TrieNode{
        private Map<Character, TrieNode> chileNodes;
        int count = 0;
        TrieNode(){
            chileNodes = new HashMap<>();
        }
        Map<Character, TrieNode> getChileNodes(){
            return this.chileNodes;
        }
    }

    static void insert(String word){
        TrieNode thisNode = rootNode;
        int length = word.length();
        for(int i = 0; i<length; i++){
            thisNode = thisNode.getChileNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        thisNode.count++;
    }

    static int check(String word){
        TrieNode thisNode = rootNode;
        int length = word.length();
        for(int i = 0; i<length; i++){
            thisNode = thisNode.getChileNodes().get(word.charAt(i));
        }
        return thisNode.count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        rootNode = new TrieNode();
        String line;
        double total = 0;
        Set<String> set = new HashSet<>();
        while((line = br.readLine()) != null){
            set.add(line);
            total++;
            insert(line);
        }
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        for(String str : set){
            list.add(str);
        }
        list.sort(comp);

        for(String word : list){
            int num = check(word);
            System.out.println(word + " " + String.format("%.4f", (num/total)*100.0));
        }
    }
}
