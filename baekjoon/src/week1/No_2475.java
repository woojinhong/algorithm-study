package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 문제
 컴퓨터를 제조하는 회사인 KOI 전자에서는 제조하는 컴퓨터마다 6자리의 고유번호를 매긴다.
 고유번호의 처음 5자리에는 00000부터 99999까지의 수 중 하나가 주어지며 6번째 자리에는 검증수가 들어간다.
 검증수는 고유번호의 처음 5자리에 들어가는 5개의 숫자를 각각 제곱한 수의 합을 10으로 나눈 나머지이다.
 예를 들어 고유번호의 처음 5자리의 숫자들이 04256이면, 각 숫자를 제곱한 수들의 합 0+16+4+25+36 = 81 을 10으로 나눈 나머지인 1이 검증수이다.
 **/
public class No_2475 {
    public static void main(String[] args) throws IOException {

        // 제곱한 수들의 합을 저장할 변수 선언
        int sum =0;

        // 콘솔에서 입력을 받기 위해 BufferedReader 사용
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        // 입력 값 저장
        String line = input.readLine();

        // 공백을 기준으로 문자열 나눠 저장
        StringTokenizer token = new StringTokenizer(line);

        // 변수에 제곱된 합 저장
        while(token.hasMoreTokens()){
            sum += (int)Math.pow(Integer.parseInt(token.nextToken()),2);
        }

        // 나머지
        System.out.println(sum%10);
    }
}
