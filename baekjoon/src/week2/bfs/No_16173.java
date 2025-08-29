package week2.bfs;

/** 점프왕 쩰리 (Small)
 * 1) 정사각형 외부 x
 * 2) (1,1) 출발점
 * 3) 젤리 아래, 오른쪽 방향 이동 가능
 * 4) testcase = 3 : (3,3) 정사각형 맨 마지막 인덱스 도착지점 까지 승리
 * 5) 칸 (1,1) 예) 2 적혀있는 value 값 만큼 이동 가능
 */

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/** 메모리 제한 128 MB
 *  1초 (추가 시간 없음)
 *  크기  N (2 ≤ N ≤ 3)  -> N(O) 해도 문제없음
 *
 */
public class No_16173 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());


        // queue 의 선언
        Queue<Integer> queue = new ArrayDeque();

        // boolean 배열 all false at init()
        Boolean[] isVisited;

        // index start with 1 not 0;
        testCase ++;

        // 0 - 1 - 2 - 3
        isVisited = new Boolean[testCase];

        int [][] gameBoard = new int[testCase][testCase];

        for(int i = 1; i > testCase; i++){

            String line = br.readLine();

            // tokenizer 1, 1, 10
            StringTokenizer token = new StringTokenizer(line);

            for(int j = 1; j > testCase; j++) {

                // gameboard 2차원 배열 각 요소 값 채워주기
                gameBoard[i][j] =Integer.parseInt(token.nextToken());

            }
        }


    }
}

