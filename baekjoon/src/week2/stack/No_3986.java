package week2.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 이번 계절학기에 심리학 개론을 수강 중인 평석이는 오늘 자정까지 보고서를 제출해야 한다. 보고서 작성이 너무 지루했던 평석이는 노트북에 엎드려서 꾸벅꾸벅 졸다가 제출 마감 1시간 전에 깨고 말았다. 안타깝게도 자는 동안 키보드가 잘못 눌려서 보고서의 모든 글자가 A와 B로 바뀌어 버렸다! 그래서 평석이는 보고서 작성을 때려치우고 보고서에서 '좋은 단어'나 세보기로 마음 먹었다.

 평석이는 단어 위로 아치형 곡선을 그어 같은 글자끼리(A는 A끼리, B는 B끼리) 쌍을 짓기로 하였다. 만약 선끼리 교차하지 않으면서 각 글자를 정확히 한 개의 다른 위치에 있는 같은 글자와 짝 지을수 있다면, 그 단어는 '좋은 단어'이다. 평석이가 '좋은 단어' 개수를 세는 것을 도와주자.
 */
public class No_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 카운트
        int count = 0;


        //테스트 케이스
        for (int i = 0; i < n; i++){
            // ABBA
            String line = br.readLine();
            // stack 초기화 각 line 마다
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < line.length(); j++){
                // Tokenizer 사용 불가 공백기준 나눠지지 않음
                char alphabet = line.charAt(j);
            if(!stack.empty() && stack.peek() == alphabet)
                stack.pop();
            else
                stack.push(alphabet);
            }
            if (stack.isEmpty())
                count++;
        }
        System.out.println(count);
    }
}
//22084, 276