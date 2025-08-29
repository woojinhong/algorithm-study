package week2.heap;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 가운데를 말해요
 * max, min 삽입 숫자 홀수 = max +1  그래야 중간 값 뽑음.. 예) (max = 3 1 min = 5)  max peek() = 3
 * 그냥 이것만 알면 됨
 *
 */
public class No_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        // n 홀수 시 = maxheap + 1 유지, 그래야 max.peek() 중간 값 출력 가능.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < testCase; i ++){
            // 자연수 입력
            int n = Integer.parseInt(br.readLine());
            // 자연수 max 삽입, 최대값 정렬을 위해 필수
            maxHeap.offer(n);
            // 큰 수는 minheap으로 옮겨 줌
            minHeap.offer(maxHeap.poll());

            if(maxHeap.size() == minHeap.size()) {
                // min (maxheap, minheap) 하려 했지만 그럴필요없음 max heap 최대가 항상 min heap 최소보다 작음
                bw.write(maxHeap.peek() +"\n");
            }
            // max size (3)< min size (4)  홀수 = min 최소값이 중간 값
            else{
                // 홀수 크기 중간 값 출력
                bw.write(minHeap.peek()+"\n");
                // maxheap +1 유지
                maxHeap.offer(minHeap.poll());
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

// 476