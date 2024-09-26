package week2.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 스페이스로 띄어쓰기 된 단어들의 리스트가 주어질때, 단어들을 반대 순서로 뒤집어라.
 각 라인은 w개의 영단어로 이루어져 있으며, 총 L개의 알파벳을 가진다.
 각 행은 알파벳과 스페이스로만 이루어져 있다.
 단어 사이에는 하나의 스페이스만 들어간다.
 */
public class No_12605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i< testcase; i++){

            List<String> list = new ArrayList<>();
            StringTokenizer word = new StringTokenizer(br.readLine());
            while (word.hasMoreTokens()) {
                list.add(word.nextToken());
            }

            Collections.reverse(list);


            sb.append("Case #").append(i + 1).append(": ")
                    // stream은 추가적인 오버헤드가 발생하니 코딩 테스트에 부적합. 하지만 stream 연습중이라 계속 써보려한다
                    // joining method를 이용해 list의 각 요소당 " "기준으로 재생성 후 최종연산.
                    .append(list.stream().collect(Collectors.joining(" ")))
                    .append("\n");
        }
        System.out.println(sb);
    }
}


//14048	96
