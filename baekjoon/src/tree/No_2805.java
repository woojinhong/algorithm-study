package tree;

import java.io.*;
import java.util.*;

public class No_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 필요한 나무 길이

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        // 이분 탐색을 위한 변수 설정
        int low = 0;
        int high = Arrays.stream(trees).max().getAsInt(); // 나무의 최대 높이

        // 이분 탐색 시작
        while (low <= high) {
            int mid = (low + high) / 2;
            long total = 0;

            // mid 높이에서 자를 때 얻는 나무의 총 길이 계산
            for (int tree : trees) {
                if (tree > mid) {
                    total += tree - mid;
                }
            }

            // 나무의 총 길이가 M 이상이면 높이를 더 높여본다.
            if (total >= M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // 최종적으로 high가 가장 큰 적합한 절단기 높이가 된다.
        System.out.println(high);
    }
}
//119292	496