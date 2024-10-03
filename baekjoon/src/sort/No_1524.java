package sort;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 세준세비
 *
 * -제한-
 * testcase
 *  1) 각 전투에서 살아있는 병사중 제일 약한 병사가 죽는다.
 *  2) 제일 약한 병사가 여러 명이고, 제일 약한 병사가 모두 같은 편에 있다면,
 *     그 중에 한 명이 임의로 선택되어 죽는다.
 *  3) 제일 약한 병사가 여러 명이고, 양 편에 모두 있다면,
 *     세비의 제일 약한 병사 중 한 명이 임의로 선택되어 죽는다.
 *  4) 전쟁은 한 명의 병사를 제외하고 모두 죽었을 때 끝난다.
 *
 *  -입력-
 *  1) testcase
 *  2) N: 세준 병사 수 M: 세비 병사 수
 *  3) 세준 병사 힘
 *  4) 세비 병사 힘
 *
 *  -출력-
 *  1) 각 testcase 마다 출력
 *  2) 세준이가 이기면 S를 세비가 이기면 B를 둘다 아닐 경우에는 C
 *
 *  -접근-
 *  1) testcase
 *  2) min heap
 */

import java.io.*;
import java.util.StringTokenizer;

public class No_1524 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {

            StringTokenizer token = new StringTokenizer(br.readLine());

            int sejunCnt = Integer.parseInt(token.nextToken());
            int sebiCnt = Integer.parseInt(token.nextToken());

            // 세준이 병사 힘 배열
            int[] sejun = new int[sejunCnt];
            StringTokenizer sejunDmgToken = new StringTokenizer(br.readLine());
            for (int i = 0; i < sejunCnt; i++) {
                sejun[i] = Integer.parseInt(sejunDmgToken.nextToken());
            }

            // 세비 병사 힘 배열
            int[] sebi = new int[sebiCnt];
            StringTokenizer sebiDmgToken = new StringTokenizer(br.readLine());
            for (int i = 0; i < sebiCnt; i++) {
                sebi[i] = Integer.parseInt(sebiDmgToken.nextToken());
            }

            // 세준이와 세비의 가장 강한 병사 찾기
            int maxSejun = getMaxPower(sejun);
            int maxSebi = getMaxPower(sebi);

            // 승자 결정
            if (maxSejun > maxSebi) {
                bw.write("S\n");
            } else if (maxSejun < maxSebi) {
                bw.write("B\n");
            } else {
                bw.write("C\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 병사 배열에서 가장 강한 병사의 힘을 반환하는 함수
    private static int getMaxPower(int[] soldiers) {
        int maxPower = soldiers[0];
        for (int power : soldiers) {
            if (power > maxPower) {
                maxPower = power;
            }
        }
        return maxPower;
    }
}

