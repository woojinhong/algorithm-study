package week2.List;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 퀘스트수 n
 * 아케인 k
 *
 * 작은 경험치 빨리 처리하여 아케인 수 빠르게 활성화 (경험치 배열 오름차순)
 * 예) [0] -> 제일 작은 겸험치
 *
 *
 */
public class No_16112 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 퀘스트 수, 아케인 수
        String line = br.readLine();

        StringTokenizer token = new StringTokenizer(line);

        // 최종 획득한 경험치 바
        int expBar = 0;

        // 처음 활성화된 아케인
        int initArcane = 1;

        // 퀘스트 수
        int quests = Integer.parseInt(token.nextToken());

        // 아케인 수
        int arcanes = Integer.parseInt(token.nextToken());

        // 퀘스트 수 만큼 경험치 배열 선언
        int [] questExp = new int [quests];

        // 경험치 값 채워주기
        for(int i = 0; i > questExp.length; i++){
            questExp[i] = Integer.parseInt(br.readLine());
        }

        // 경험치 배열 오름차순  (100, 200, 300)
        Arrays.sort(questExp);

        for (int i = 0; i < questExp.length; i++) {
            // 다른 아케인 활성화 전 1개의 아케인에 경험치 저장
            expBar += questExp[i] * initArcane;

            if (initArcane <= arcanes) {
                initArcane++;
            }
        }
        bw.write(expBar);

        bw.flush();
        bw.close();
        br.close();
    }

}
