package week2.heap;


import java.io.*;
import java.util.PriorityQueue;


/** 최소 힙
 * 중점: x = 0 -> poll()
 * else: offer()
 */
public class No_1927 {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 0; i < testCase; i++){
        // 자연수
        int n = Integer.parseInt(br.readLine());
        // 삽입한 자연수 가 0 일 시 최소 값 출력
        if (n == 0){
            // 배열 비어 있을 시 0 출력
            if(!pq.isEmpty())
                bw.write(pq.poll()+"\n");
            else
            //최소값
            bw.write("0\n");
        }else {
            // 0이 아닌 자연수  -> 배열에 삽입
            pq.offer(n);
        }
    }
    bw.flush();
    bw.close();
    br.close();
    }
}
//26636	276