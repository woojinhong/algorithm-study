package dfs;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**양치기 꿍
 *
 * 울타리 '#'
 * 늑대 'v'
 * 양 'k'
 *
 * -제약-
 * 울타리 내부 양 > 늑대 = 늑대 x
 * 울타리 내부 늑대 > 양 = 양 x
 *
 * 몇 마리 양 && 늑대 survive?
 */
public class No_3187 {
    static int row, column;
    static char[][] board;
    static boolean[][] visited;
    static int sheepNum = 0;
    static int wolfNum = 0;

    // 방향 벡터 (상, 하, 좌, 우)
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //r
        String line = br.readLine();

        StringTokenizer token = new StringTokenizer(line);


        row = Integer.parseInt(token.nextToken());

        column = Integer.parseInt(token.nextToken());

        // 2차원 배열 크기 설정
        board = new char[row][column];

        // 방문 여부 체크
        visited = new boolean[row][column];

        // 2차원 배열 값 초기화
        for (int i = 0; i < row; i++) {
            String userInput = br.readLine();

            for (int j = 0; j < column; j++) {
                board[i][j] = userInput.substring(j, j + 1).charAt(0);
            }
        }

        int totalSheep = 0;
        int totalWolf = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] != '#' && !visited[i][j]) {

                    sheepNum = 0;
                    wolfNum = 0;

                    dfs(i,j);

                    if(sheepNum > wolfNum){
                        totalSheep += sheepNum;
                    }
                    else {
                        totalWolf += wolfNum;
                    }

                }


            }
        }

        bw.write(totalSheep + " " + totalWolf);


        bw.flush();
        bw.close();
        br.close();
    }

    // dfs 탐색
    private static void dfs(int x, int y) {

        // 방문 판매 true
        visited[x][y] = true;

        if(board[x][y] == 'k'){
            sheepNum++;
        }
        else if (board[x][y] == 'v'){
            wolfNum++;
        }


        // 타겟 위치 이동 (상, 하, 좌, 우)
        for(int i = 0; i < 4; i++){
            int targetRow = x + dRow[i];
            int targetCol = y + dCol[i];

            // 2차원 배열 범위면
            if(targetRow >= 0 && targetRow < row && targetCol >= 0 && targetCol < column) {

                // 울타리(#) 가 아니거나 방문 했을 시
                if (board[targetRow][targetCol] != '#' && !visited[targetRow][targetCol]) {

                    // 해당 위치 재귀 함수 호출
                    dfs(targetRow, targetCol);

                }
            }
        }


    }
}
// 20956 188



