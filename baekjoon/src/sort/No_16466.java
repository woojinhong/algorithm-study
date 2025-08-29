package sort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**콘서트
 *
 *  티켓 중 번호가 가장 작은 티켓의 번호를 알고 싶다.
 *
 *  -입력-
 *  첫째 줄에 1차 티켓팅에서 팔린 티켓들의 수인 정수 N
 *  둘째 줄에는 1차 티켓팅에서 팔린 티켓들의 번호 정수 Ai
 *
 *  -출력-
 *  양한이가 가질 수 있는 티켓 중 가장 작은 번호를 출력한다.
 *
 *
 * - 접근
 * 1차 티켓 min heap poll()
 * 2차 티켓 배열 bubble sort int[minheap.poll()] 크기의 배열을 생성 후
 *
 */
public class No_16466 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        StringTokenizer token = new StringTokenizer(br.readLine());


        // minHeap
        PriorityQueue<Integer> ticketNum = new PriorityQueue<>();

        while(testCase-- >0){
            ticketNum.offer(Integer.parseInt(token.nextToken()));
        }

        int count = 1;
        // 1부터 count minheap의 poll 과 비교 -> 같지 않다면 count 1씩 증가
        while(!ticketNum.isEmpty() && ticketNum.peek() == count){
            ticketNum.poll();
            count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();

    }
}
// 116528 672