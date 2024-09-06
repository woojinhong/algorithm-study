package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No_2675 {
    public static void main(String[] args) throws IOException {

        // I/O 속도 최적화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 테스트 케이스의 개수를 입력 받음
        int testCases = Integer.parseInt(br.readLine());

        // R 문자열 결과 한번에 저장할 StringBuilder 선언
        StringBuilder finalResult = new StringBuilder();

        // 각 테스트 케이스 처리
        for (int t = 0; t < testCases; t++) {
            // 각 테스트 케이스에서 반복 횟수와 문자열 입력 받음
            String line = br.readLine();

            // split 메소드 대신 공백 기준 문자열 나눠서 저장
            StringTokenizer token = new StringTokenizer(line);

            int loop = Integer.parseInt(token.nextToken());  // 반복 횟수
            String s = token.nextToken();  // 입력 문자열

            // 문자열의 각 문자를 반복
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < loop; j++) {
                    finalResult.append(s.charAt(i));  // 각 문자를 반복해서 추가
                }
            }
            // 각 테스트 케이스 결과를 한 줄에 추가
               finalResult.append("\n");
        }
        br.close();

        // 모든 입력 처리가 완료된 후 최종 결과 출력
        System.out.print(finalResult.toString());
    }
}
