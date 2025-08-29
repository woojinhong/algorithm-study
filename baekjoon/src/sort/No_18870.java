package sort;

import java.io.*;
import java.util.*;

/**
 * x'1 이 뭔지 모르겠는데
 * 예제보고 문제 유추가능
 *
 * mah
 */
public class No_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());


        StringTokenizer token = new StringTokenizer(br.readLine());

        // 원본
        int[] num = new int[testCase];



        for (int i = 0; i < testCase; i++) {

            num[i] = Integer.parseInt(token.nextToken());
        }

        // 원본 배열을 복사
        int[] sortedAsc = Arrays.copyOf(num, num.length);

        // 오름차순으로 정렬
        Arrays.sort(sortedAsc);

        // sorted 요소 , 인덱스
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;

        // 중복되지 않도록 좌표에 순위 부여
        for (int i = 0; i < testCase; i++) {
            if (!map.containsKey(sortedAsc[i])) {
                map.put(sortedAsc[i], rank);
                rank++;
            }
        }

        for (int i = 0; i < testCase; i++) {
            bw.write(map.get(num[i]) + " ");
        }

        // 출력 버퍼 플러시
        bw.flush();
        bw.close();
        br.close();

    }
}
//264932 1732