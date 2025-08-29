
import java.io.*;
import java.util.StringTokenizer;


// 상하좌우 인접 한 1의 모임
// 대각선은 개별 그룹
public class No_1012 {
    static int row, column;
    static int[][] board;
    static boolean[][] visited;

    // 방향 벡터 (상, 하, 좌, 우)
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String line = br.readLine();

            StringTokenizer token = new StringTokenizer(line);

            row = Integer.parseInt(token.nextToken());
            column = Integer.parseInt(token.nextToken());

            int totalEdge = Integer.parseInt(token.nextToken());
            // 배열 크기 선언
            board = new int[row][column];
            visited = new boolean[row][column];


            for (int i = 0; i < totalEdge; i++) {
                token = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(token.nextToken());
                int y = Integer.parseInt(token.nextToken());
                // 배추 표기
                board[x][y] = 1;
            }


            int wormCount = 0;
            // 모든 배추 위치에 대해 DFS 탐색
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    // 배추가 있고 방문하지 않았으면 새로운 그룹으로 간주
                    if (board[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        wormCount++;  // 새로운 지렁이 추가
                    }

                }
            }
            bw.write(String.valueOf(wormCount));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y) {
        // 방문 확인
        visited[x][y] = true;

        // 0~ 3 (4 방향 탐색)  상 하 좌 우 순차적
        for (int i = 0; i < 4; i++) {
            int nRow = x + dRow[i];
            int nCol = y + dCol[i];

            // 배열 범위 안에 배추가 있으며 아직 방문하지 않을 시 무한 재귀
            if (nRow >= 0 && nCol >= 0 && nRow < row && nCol < column && board[nRow][nCol] == 1 && !visited[nRow][nCol]) {
                dfs(nRow, nCol);
            }
        }
    }
}
//	15800	132