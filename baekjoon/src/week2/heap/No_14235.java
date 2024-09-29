package week2.heap;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No_14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 방문 횟수 n 입력
        int n = Integer.parseInt(br.readLine());

        // 최대 힙을 위한 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            // 입력을 한 줄씩 처리
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 첫 번째 값: a가 0이면 아이를 만남, 0이 아니면 거점지에서 선물 충전
            int a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                // 아이를 만난 경우
                if (pq.isEmpty()) {
                    // 선물이 없으면 -1 출력
                    bw.write("-1\n");
                } else {
                    // 선물이 있으면 가장 큰 값(최대값) 출력
                    bw.write(pq.poll() + "\n");
                }
            } else {
                // 거점지에서 a개의 선물을 충전
                for (int j = 0; j < a; j++) {
                    pq.offer(Integer.parseInt(st.nextToken()));  // 선물을 최대 힙에 삽입
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
