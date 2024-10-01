package week2.graph;

import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

/**
 * testcase
 * N: 국가 수 노드 / 정점(vertex)
 * M: 비행 종류 간선(edge)
 * (a,b): 간선의 연결 정보  예)1-2
 * 양방향 그래프: 노드 (나라)간 왕복이 가능하다
 */
public class No_9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // testCase 2
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++){
            // 국가 수, 비행기 종류(간선 수)
            String line = br.readLine();
            // token 공백기준
            StringTokenizer token = new StringTokenizer(line);
            // 국가 수
            int totalDest = Integer.parseInt(token.nextToken());
            // 간선(edge) 수
            int totalEdge = Integer.parseInt(token.nextToken());


            // 간선 testcase
            while(totalEdge-- > 0){
                // (a,b) (1-2) (2-3) (1-3)
                String linkedEdge = br.readLine();

                // 간선 토큰화
                StringTokenizer tokenEdge = new StringTokenizer(linkedEdge);

                // 첫번째 노드 필요x
                tokenEdge.nextToken();
                // 두번째 노드 필요x
                tokenEdge.nextToken();
            }

            // 국가 수 - 1개의 비행기로 모든 국가를 연결할 수 있음
            bw.write((totalDest - 1) + "\n");
        }

        // 자원 닫기
        bw.flush();
        bw.close();
        br.close();
    }
}
//	45976	308
