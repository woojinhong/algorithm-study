package week1.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/** 문제
 고려대학교에 입학한 새내기 호돌이는 안암역을 지나다가 한 붕어빵 장수를 만났어요.

 “안녕, 안녕, 안녕하십니까, 아저씨! 붕어빵 두 개 주세요.”

 “안녕을 세 번 외쳤으니 붕어빵 세 개!”

 붕어빵 두 개의 값을 내고 세 개를 받은 호돌이는 기분이 좋았어요. 호돌이가 붕어빵 하나를 꺼내어 한 입 물었는데…. 너무 뜨거워서 그만 붕어빵을 떨어뜨리고 말았어요ㅠㅠ

 붕어빵은 자유 낙하운동을 하면서 땅에 떨어졌는데 신기하게도 좌우가 뒤집힌 모양으로 착지했답니다.

 호돌이가 붕어빵을 한 입 물기 전의 모양이 입력으로 주어지면, 땅에 떨어졌을 때에는 어떤 모양일지 출력하세요.
 **/
public class No_11945 {
    public static void main(String[] args) throws IOException {

        // 입력된 붕어빵 모양을 저장할 리스트
        List<String> breadList = new ArrayList<>();

        // 붕어빵틀 크기(열 행) + 모양(001 100) 입력 값
        BufferedReader fish = new BufferedReader(new InputStreamReader(System.in));

        // 입력 값 저장
        String line = fish.readLine();

        // 공백 기준 나누기
        StringTokenizer token = new StringTokenizer(line);

        // 첫 번째 줄에서 N과 M을 입력받음
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());


        // N개의 줄을 읽어서 리스트에 저장 예) 입력 값 3 -> "100"[0] "111"[1] "122"[2]  breadList 배열에 저장
        for (int i = 0; i < n; i++) {
            breadList.add(fish.readLine());
            if (breadList.get(i).length() != m){
                System.out.println("행의 길이가 맞지 않음");
                return;
            }
        }

        // 입력이 모두 끝난 후 좌우 반전 결과 출력
        for (String row : breadList) {
            StringBuilder sb = new StringBuilder(row);
            System.out.println(sb.reverse());
        }
    }
}

