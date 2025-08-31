package Array;

import java.util.Scanner;

/**
 * 백준 1236번 성 지키기
 */
public class No_1236{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 행(row)의 수
        int m = sc.nextInt(); // 열(column)의 수

        char[][] castle = new char[n][m];

        // 성의 상태 입력받기
        for (int i = 0; i < n; i++) {
            castle[i] = sc.next().toCharArray();
        }

        // 1. 보호받지 못하는 '행'의 개수 세기
        int needRowCount = 0;
        for (int i = 0; i < n; i++) {
            boolean hasSecurity = false;
            for (int j = 0; j < m; j++) {
                if (castle[i][j] == 'X') {
                    hasSecurity = true;
                    break; // 해당 행에 경비원이 있으면 더 이상 탐색할 필요 없음
                }
            }
            // for 루프가 끝날 때까지 경비원을 찾지 못했다면, 필요한 행의 수 증가
            if (!hasSecurity) {
                needRowCount++;
            }
        }

        // 2. 보호받지 못하는 '열'의 개수 세기
        int needColCount = 0;
        for (int i = 0; i < m; i++) {
            boolean hasSecurity = false;
            for (int j = 0; j < n; j++) {
                if (castle[j][i] == 'X') {
                    hasSecurity = true;
                    break; // 해당 열에 경비원이 있으면 더 이상 탐색할 필요 없음
                }
            }
            // for 루프가 끝날 때까지 경비원을 찾지 못했다면, 필요한 열의 수 증가
            if (!hasSecurity) {
                needColCount++;
            }
        }

        // 3. 필요한 행의 수와 열의 수 중 더 큰 값을 출력
        System.out.println(Math.max(needRowCount, needColCount));
    }
}