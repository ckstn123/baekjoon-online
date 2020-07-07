import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static TrieNode rootNode;

    void insert(String word){
        TrieNode thisNode = rootNode;

        for(int i = 0; i<word.length(); i++){
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i),c -> new TrieNode());
        }
        thisNode.setIsLastChar(true);
    }

    boolean contains(String word){
        TrieNode thisNode = rootNode;

        for(int i = 0; i<word.length(); i++){
            char character = word.charAt(i);
            if(thisNode.getChildNodes().isEmpty()){
                return true;
            }
            TrieNode node = thisNode.getChildNodes().get(character);

            if(node == null){
                return false;
            }

            thisNode = node;
        }

        return true;
    }


    public boolean isRootEmpty(){
        return rootNode.getChildNodes().isEmpty();
    }
    public static class TrieNode{
        // 자식 노드 맵
        private Map<Character, TrieNode> childNodes = new HashMap<>();
        // 마지막 글자인지 여부
        private boolean isLastChar;
        // 자식 노드 맵 Getter
        Map<Character, TrieNode> getChildNodes() {
            return this.childNodes;
        }
        // 마지막 글자인지 여부 Getter
        boolean isLastChar() {
            return this.isLastChar;
        }
        // 마지막 글자인지 여부 Setter
        void setIsLastChar(boolean isLastChar) {
            this.isLastChar = isLastChar;
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테스트 케이스
        for (int testCase = 0; testCase < T; testCase++) {
            int n = Integer.parseInt(br.readLine()); // 전화번호의 수
            rootNode = new TrieNode();
            boolean flag = true;
            for(int i = 0; i<n; i++){
                String word = br.readLine();
                //입력할 때마다 확인
                if(flag){
                    if(main.isRootEmpty()){
                        main.insert(word);
                    }
                    else if(main.contains(word)){
                        flag = false;
                    }
                    else
                        main.insert(word);
                }
            }
            if(flag){
                System.out.println("YES");
            }
            else
                System.out.println("NO");
        }
    }
}
