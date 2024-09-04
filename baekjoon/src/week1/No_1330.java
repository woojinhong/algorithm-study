package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 문제
두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
 **/
public class No_1330 {
    public static void main(String[] args) throws IOException {

        // 콘솔에서 입력을 받기 위해 BufferedReader 사용
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 입력 값 저장
        String line = reader.readLine();
        // 공백을 기준으로 문자열 나눠 저장
        StringTokenizer token = new StringTokenizer(line);

        // 변수 A, B에 사용자 입력을 정수로 변환하여 저장
        int A = Integer.parseInt(token.nextToken());
        int B = Integer.parseInt(token.nextToken());

        // 출력
        System.out.println(A > B ? '>' : A < B ? '<' : "==");
    }
}

