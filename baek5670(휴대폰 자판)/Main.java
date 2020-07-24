import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static TrieNode rootNode;
    static class TrieNode{
        private Map<Character, TrieNode> childNodes;
        boolean isLastNode;
        TrieNode(){
            childNodes = new HashMap<>();
        }

        void setLastNode(boolean isLastNode){
            this.isLastNode = isLastNode;
        }

        Map<Character, TrieNode> getChildNodes(){
            return this.childNodes;
        }
    }

    static void insert(String word){
        TrieNode thisNode = rootNode;
        int length = word.length();
        for(int i = 0; i<length; i++){
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        thisNode.setLastNode(true);
    }

    static int check(String word){
        TrieNode thisNode = rootNode;
        int count = 1;
        int length = word.length();
        thisNode = thisNode.getChildNodes().get(word.charAt(0));
        for(int i = 1; i<length; i++){
            if(thisNode.getChildNodes().size() == 1 && !thisNode.isLastNode){
                thisNode = thisNode.getChildNodes().get(word.charAt(i));
            }
            else if(thisNode.getChildNodes().size() >= 1){
                thisNode = thisNode.getChildNodes().get(word.charAt(i));
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            int num = Integer.parseInt(line);
            float sum = 0;
            float result = 0;
            String[] words = new String[num];
            rootNode = new TrieNode();
            for(int i = 0; i<num; i++){
                words[i] = br.readLine();
                insert(words[i]);
            }

            for(String word : words){
                sum += check(word);
            }
            result = sum / num;
            System.out.println(String.format("%.2f", result));

        }
    }
}
