package week2.heap;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *
 * 곱하기도 아니고 더하기 문제인데 왜 합치는 방식에 따라 금액 차이가 나는지 헷갈린다..
 * 과거의 나 반성해라
 *
 * 작은 수 로 차근 차근 개념이해
 * A)
 * 1) C1(1), C2(2), C3(3)
 * 2) C1(1) + C2(2) = X1(3) // 총 비용 $3
 * 3) C3(3) + X1(3) = X2(6) // 총 비용 $6
 * 4) X1(3) + X2(6) = $9
 *
 * B)
 * 1) C1(1), C2(2), C3(3)
 * 2) C2(2) + C3(3) = X1(5) // 총 비용 $5
 * 3) C1(1) + X1(5) = X2(6) // 총 비용 $6
 * 4) X1(5) + X2(6) = $11
 *
 * 작은 수 먼저 합쳐야 비용을 줄일 수 있는 문제
 *
 * minHeap 사용
 *
 * sum += minHeap.poll();
 *
 */
public class No_13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // testCase
        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0) {

            // 총 비용 초기화
            int sum = 0;

            // 최소 힙
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            // 파일 수
            Integer.parseInt(br.readLine());

            // 각 파일 크기
            StringTokenizer token = new StringTokenizer(br.readLine());


            // 토큰 크기에 따른 파일 정보 -> 최소 힙 추가
            while (token.hasMoreTokens()) {

                // 각 파일 최소 힙 add (40, 30, 30, 50) -> (30, 30, 40, 50)
                minHeap.offer(Integer.parseInt(token.nextToken()));
            }
            /**
             *
             *예) [10], [20], [30]
             *    10 + 20 = 30  -> 계산 후 offer[30]
             *    min heap에 남은 파일 정보 [30], [30]  (size == 2// size > 1)일 때까지 돌리면됨
             *    30 + 30 = 60 -> 계산 후 offer 필요없음 계산 바로 하면됨
             *    비용 30 + 60 = 90
             */
            while (minHeap.size() > 1) {
                // 첫 접근 sum+=minheap.poll() -> offer를 못하고 size() > 1 일때까지 모든 파일을 그냥 더해버림 그럼 더한 파일 비용과 minheap 내부 파일 중 최소 비용 파일 비교 불가

                // 첫번째 최소 크기 파일
                int firstFile = minHeap.poll();
                // 두번째 최소 크기 파일
                int secondFile = minHeap.poll();

                // 두 파일을 합치는 비용
                int mergeCost = firstFile + secondFile;

                sum += mergeCost;

                minHeap.offer(mergeCost);
            }
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
// 실패 이유를 도저히 모르겠다.
// 정답 출력은 된다..
