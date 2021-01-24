import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static class employee{
        int document, interview;
        employee(int d, int i){
            this.document =d;
            this.interview = i;
        }
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int T = sc.nextInt();
        int[] result = new int[T];
        //지원자의 서류점수 오름차순으로 정렬
        Comparator<employee> comp = new Comparator<employee>() {
            @Override
            public int compare(employee o1, employee o2) {
                return Integer.compare(o1.document,o2.document);
            }
        };
        for(int tc = 0; tc<T; tc++){
            int answer = 0;
            int N = sc.nextInt();
            employee[] employees = new employee[N];
            for(int a = 0; a<N; a++){
                int document = sc.nextInt();
                int interview = sc.nextInt();
                employees[a] = new employee(document, interview);
            }
            Arrays.sort(employees,comp);
            //0번째 사람은 무조건 합격이므로 면접 점수를 기준으로 삼는다.
            int limit = employees[0].interview;
            for(int i = 1; i<N; i++){
                if(employees[i].interview > limit)
                    answer++;
                else
                    limit = employees[i].interview;
            }
            result[tc] = N-answer;
        }
        for(int i = 0; i<T; i++){
            System.out.println(result[i]);
        }
    }
}
