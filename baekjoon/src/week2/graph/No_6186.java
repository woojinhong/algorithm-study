package week2.graph;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Best Grass
 *
 *
 * grass clump shown (single '#' || two '#') symbols side-by-side **(but not on a diagonal)**.
 *
 * No two symbols representing two different clumps are adjacent. (서로 다른 두개의 #는 인접하지 않는다 아래위로)
 *
 */

public class No_6186 {
    static int row, column;
    // 2차원 배열 크기
    static char[][] board;
    // 방문 여부
    static boolean[][] visited;

    // 예) drow[0]= -1, dcol[0] = 0 (상) , 하 좌 우
    static int[] dirRow = {-1, 1, 0, 0};
    static int[] dirCol = {0, 0, -1, 1};

    // dfs 메서드
    static void dfs(int x, int y){

        visited[x][y] = true;

        // direction 상, 하, 좌, 우 순서대로 순회
        for (int i = 0; i < 4; i++){
            // 타겟 x 좌표
            int targetRow = x + dirRow[i];

            // 타겟 y 좌표
            int targetCol = y + dirCol[i];

            // 2차원 배열의 타겟 위치 -> 사용자 설정 범위 벗어나지 않고
            if(targetRow >= 0 && targetRow < row && targetCol >= 0 && targetCol < column){
                // 2차원 배열의 타겟 위치 -> '#' && 방문 여부 -> false
                if(board[targetRow][targetCol] == '#' && !visited[targetRow][targetCol]){
                    // 모든 조건에 부합 -> 재귀 호출로 다음 인접한 '#' 탐색
                    dfs(targetRow,targetCol);
                }
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // row, column
        String line = br.readLine();

        StringTokenizer token = new StringTokenizer(line);

        row = Integer.parseInt(token.nextToken());
        column = Integer.parseInt(token.nextToken());

        // board 배열 크기 설정
        board = new char[row][column];

        // visited 배열 크기 설정
        // boolean default = false
        visited = new boolean[row][column];


        // 2차원 배열을 사용자 값으로 초기화
        for(int i = 0; i < row; i++){
            String userInput = br.readLine();
            for(int j = 0; j < column; j++){
                // 문자열의 substring(0,1) -> char로 반환 -> 배열 순회 각 사용자 입력 요소 저장.
                board[i][j] = userInput.substring(j,j+1).charAt(0);
            }
        }

        // 잔디 # 카운트
        int clumps = 0;

        // 2차원 배열을 순회하며 #을 찾고 DFS 실행
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){

                // 배열 값 == # ?
                if(board[i][j] == '#') {
                    // 아직 방문 전 ?
                    if (!visited[i][j]) {
                        // 잔디 # +1
                        clumps++;
                        // dfs 메서드 -> 인접한 #들 방문처리
                        dfs(i,j);
                    }
                }

            }
        }
        bw.write(String.valueOf(clumps));

        bw.flush();
        bw.close();
        br.close();
    }
}

//14772	108
