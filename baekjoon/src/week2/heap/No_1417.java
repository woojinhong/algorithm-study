package week2.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;


public class No_1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // testcase
        int testcase  =  Integer.parseInt(br.readLine());

        // 기호 1번 표
        int firstCandidate = Integer.parseInt(br.readLine());

        // 최소 매수 값
        int minBribe = 0;

        // 내림차순 heap 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < testcase -1; i++) {
            // 기호 1 번 제외 표
            pq.offer(Integer.parseInt(br.readLine()));
        }

        // 가장 득표수가 높은 표보다 클 때 까지 반복
        while (!pq.isEmpty() && firstCandidate <= pq.peek()) {

            minBribe++;

            pq.offer(pq.poll() - 1) ;

            firstCandidate++;

        }
        System.out.println(minBribe);
    }
}
