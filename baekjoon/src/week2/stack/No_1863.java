package week2.stack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 10
 * 1 1
 * 2 2
 * 5 1
 * 6 3
 * 8 1
 * 11 0
 * 15 2
 * 17 3
 * 20 2
 * 22 1
 *
 * n번째 줄의 첫번째 x (위치) = 무시
 * 두번째 y (높이) 삽입 마다 기존 높이 보다 작을 시 count +1
 * 굳이 stack 이 필요한가? 자료구조 자체가 필요한가>>?????
 * int 건물 > 새로운 입력 값 = count +1 하면되지않나
 *
 * */
public class No_1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        // 이전 빌딩 크기
        int prevHeight = 0;

        // 빌딩 초기화
        int count = 0;

        while(testCase-- > 0){
            String line = br.readLine();

            StringTokenizer token = new StringTokenizer(line);

            // x값 위치 필요없음 = token 소모
            token.nextToken();

            int buildingHeight = Integer.parseInt(token.nextToken());

            // 높이가 이전보다 작을 때 새로운 건물이 끝났거나, 높이가 커졌을 때 새로운 건물이 시작되므로 카운트
            if (buildingHeight > prevHeight || (buildingHeight == 0)) {

                count++;

            }


            // 이전 높이를 현재 높이로 업데이트
            prevHeight = buildingHeight;
        }
        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();
    }

}
