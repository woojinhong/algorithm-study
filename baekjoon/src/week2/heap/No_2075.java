package week2.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < testcase; i++){
            String line = br.readLine();
            StringTokenizer token = new StringTokenizer(line);
            while(token.hasMoreTokens()){
                pq.offer(Integer.parseInt(token.nextToken()));
            }
        }

        // testcase -1  n번째로 큰 수 출력/ n-1 poll() 이후 peek.
        for (int j = 0; j < testcase -1; j++){
            pq.poll();
        }
        System.out.println(pq.peek());
    }
}

//275588	788