package week2.map;

/**
 * 해빈이는 패션에 매우 민감해서 한번 입었던 옷들의 조합을 절대 다시 입지 않는다.
 * 예를 들어 오늘 해빈이가 안경, 코트, 상의, 신발을 입었다면, 다음날은 바지를 추가로 입거나 안경대신 렌즈를 착용하거나 해야한다.
 * 해빈이가 가진 의상들이 주어졌을때 과연 해빈이는 알몸이 아닌 상태로 며칠동안 밖에 돌아다닐 수 있을까?
 */

/**
 *
 *
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No_9375 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 예) 2
        int testcase = Integer.parseInt(br.readLine());

        while (testcase -- > 0) {

            // <옷 종류, 옷 개수>
            HashMap<String, Integer> cntCategory = new HashMap<>();


            // 입력받는 옷의 개수
            int noOfClothes = Integer.parseInt(br.readLine());

            while (noOfClothes-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                // 옷 이름 무시
                st.nextToken();

                // 옷 종류
                String category = st.nextToken();

                // 옷 종류 중첩 시 map value +1
                // else 1
                if (cntCategory.containsKey(category)) {
                    cntCategory.put(category, cntCategory.get(category) + 1);
                }
                else {
                    cntCategory.put(category, 1);
                }
            }

            int result = 1;

            // 각 종류 별 입지 않은 경우의 수 + 1
            for (int val : cntCategory.values()) {
                result *= (val + 1);
            }
            // 알몸 상태 경우 제외 -1
            sb.append(result - 1).append('\n');

        }
        System.out.println(sb);
    }
}
//14148	104