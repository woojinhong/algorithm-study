package week2.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력값을 char 배열로 변환
        char[] chars = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();

        // 변환 횟수
        int count = 0;

        int sum;

        // 입력이 한 자리 수라면 변환 필요 없음
        if (chars.length == 1) {
            sum = Character.getNumericValue(chars[0]);
        } else {
            do {
                sum = 0;

                // 자릿수 합 계산
                for (char aChar : chars) {
                    sum += Character.getNumericValue(aChar);
                }

                // 변환이 일어날 때마다 count 증가
                count++;

                // sum을 다시 문자열로 변환하고, char[]로 변환
                chars = String.valueOf(sum).toCharArray();

            } while (sum >= 10);  // sum이 한 자리 수가 될 때까지 반복

        }
            // 변환 횟수 출력
            sb.append(count).append("\n");

            // sum이 3의 배수인지 여부 출력
            sb.append((sum % 3 == 0) ? "YES" : "NO");

            // 결과 출력
            System.out.println(sb);
    }
}
//	22060	236