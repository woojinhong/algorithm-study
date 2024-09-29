package week2.heap;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/** 센티와 마법의 뿅망치
 * 인구수 N
 * 센티 키 H
 * 뿅망치 횟수 T
 * 거인 키 S
 */
public class No_19638 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // testcase, 센티 키, 뿅망치 횟수
        String line = br.readLine();

        StringTokenizer token = new StringTokenizer(line);

        int testCase = Integer.parseInt(token.nextToken());

        int centiHeight = Integer.parseInt(token.nextToken());

        int hammer = Integer.parseInt(token.nextToken());

        int giantHeight = 0;
        // 내림차순 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());


        for (int i = 0; i < testCase; i++){

            giantHeight = Integer.parseInt(br.readLine());
            // 거인 키 삽입
            pq.offer(giantHeight);
        }
        int hammerCount = 0;

        while(hammer-- > 0){
            if(pq.peek() >= centiHeight){
                if(pq.peek() == 1){
                    break;
                }
                // 망치 적용 후 거인 키 저장
                int hammerHeight = pq.poll()/2;
                // 거인 키 재 삽입
                pq.offer(hammerHeight);
                hammerCount++;  // 뿅망치 사용 횟수 증가
            }
            else {
                break;
            }
        }

        if(pq.peek() >= centiHeight) {
            bw.write("NO\n");
            bw.write(Integer.toString(pq.peek()));
        }
        else{
            bw.write("YES\n");
            bw.write(Integer.toString(hammerCount));
        }
        // 버퍼 비우기 및 닫기
        bw.flush(); // 버퍼에 남아있는 내용을 출력
        bw.close(); // 스트림 닫기
        br.close(); // 입력 스트림 닫기
    }
}
//29148	344