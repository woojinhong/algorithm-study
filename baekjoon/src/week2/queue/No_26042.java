package week2.queue;

import java.io.*;
import java.util.*;

/** 식당 입구 대기 줄
 * 1 a: 학생 번호가 양의 정수 a인 학생 1명이 학교 식당에 도착하여 식당 입구의 맨 뒤에 줄을 서기 시작한다.
 * 2: 식사 1인분이 준비되어 식당 입구의 맨 앞에서 대기 중인 학생 1명이 식사를 시작한다.
 *
 * queue 삽입 = a
 * queue 제거 = 2
 *
 * queue 최대 size 기록 = maxsize(큐 최대 길이), currentsize(현재 길이)
 * queue 최대 길이 여러개 = loop 탈출 후
 */
public class No_26042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 학생 대기 줄  //lastpeek 시 linkedlist와 arraydeque 의 시간복잡도 차이
        Deque<Integer> queue = new ArrayDeque<>();

        // 대기 줄이 최대일 때 맨 뒤 학생 번호
        int lastStudentAtMaxSize = Integer.MAX_VALUE;

        // 대기 줄 최대 크기 정보 저장
        int maxSize = 0;

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++){
            StringTokenizer token = new StringTokenizer(br.readLine());

            // 1 or 2
            Integer.parseInt(token.nextToken());

            // 학생번호 존재 시 add()
            if(token.hasMoreElements()) {
                queue.add(Integer.parseInt(token.nextToken()));

                // 현재 큐의 크기 확인
                int currentSize = queue.size();

                // maxsize 보다 현재 사이즈가 더 클 시
                if (currentSize > maxSize) {

                    // maxsize 정보 변경
                    maxSize = currentSize;
                    // 맨 뒤의 학생 번호 저장
                    lastStudentAtMaxSize = queue.peekLast(); // 맨 뒤의 학생 번호 저장
                } else if (currentSize == maxSize) {
                    // 동일한 최대 크기일 때, 맨 뒤 학생 번호가 더 작으면 갱신
                    lastStudentAtMaxSize = Math.min(lastStudentAtMaxSize, queue.peekLast());
                }



            }
            // 학생번호 존재 하지 않을 시 poll()
            else{
                queue.poll();
            }
        }
        bw.write(maxSize + " " + lastStudentAtMaxSize + "\n");
        bw.flush();
        bw.close();
    }
}

//40436	340
