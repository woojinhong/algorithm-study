package sort;

import java.io.*;
import java.util.*;

/** 팀명 정하기
 * 1) 세 참가자의 입학 연도를 100으로 나눈 나머지를 오름차순으로 정렬해서 이어 붙인 문자열
 * 1) 2018, 2019, 2020 -> 181920
 * 2) 세 참가자 중 성씨를 영문으로 표기했을 때의 첫 글자를 백준 온라인 저지에서 해결한 문제가 많은 사람부터 차례대로 나열한 문자열
 * 2) 600 AHN, 2000 LEE, 6000 OH -> OLA
 *
 *
 * 입력
 * p = 해결한 문제의 개수
 * y = 입학 연도
 * s = 성씨
 */


class teamInfo{
    int solvedNum;
    int enrolYear;
    String lastName;

    teamInfo(int sn, int ey, String ln){
        solvedNum = sn;
        enrolYear = ey;
        lastName = ln;
    }
}
public class No_28114 {

    static int teamSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // 세명의 참가자 정보 저장하기 위한 배열
        List<teamInfo> teams = new ArrayList<>();


        for (int i = 0; i < 3; i++) {
            // 개수, 연도, 성
            StringTokenizer token = new StringTokenizer(br.readLine());

            int solvedNum = Integer.parseInt(token.nextToken());
            int enrolYear = Integer.parseInt(token.nextToken());
            String lastName = token.nextToken();


            // teamInfo class 객체 생성 -> teams 배열에 저장
            teams.add(new teamInfo(solvedNum, enrolYear, lastName));
        }

        // static 변수
        teamSize = teams.size();

        // 연도 뒤 두자리 수 오름차순 sort

        // 연도 배열 선언
        int[] sortYear = new int[teamSize];

        int index = 0;
        // 참가자 순회 -> 연도 두자리 수 반환 -> 오름차순 정렬 -> 연도 배열 저장
        for (teamInfo team : teams) {
            // 뒤 두자리 수 저장 (만약 1996 년 들어오면? 오케이 거기까지 생각 x)
            int modularYear = team.enrolYear % 100;

            // 삽입 순 정렬
            sortYear[index++] = modularYear;
        }
        // 오름 차순 정렬
        // 그냥 stream 써보고 싶어서 써봄 절대 필요x (Arrays.sort(sortYear) 하면 됨)
        sortYear = Arrays.stream(sortYear)  // int[] -> stream 변환
                // 만약 내림차순 이라면 boxed()를 써서 Integer wrapper로 변환해 Collections 메서드를 사용해야함 기본형은 사용 x
                .sorted()
                // stream -> int[] 변환
                .toArray();

        // bufferedwriter 이용 출력
        for (int i : sortYear) {
            bw.write(String.valueOf(i));  // String 으로 출력 "181920"
        }
        bw.newLine(); // 줄바꿈


        // 버블 정렬을 사용하여 문제 해결 수 기준 내림차순 정렬
        bubbleSort(teams);

        for (teamInfo team : teams) {
            // lastname 의 첫글자
            bw.write(team.lastName.charAt(0));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    // 매번 리스트에서 가장 큰/ 가장 작은 요소를 오른쪽 끝으로 이동시키는 정렬 방식
    private static void bubbleSort(List<teamInfo> teams) {

        // teamSize -1 = 두개의 인접한 요소 비교를 위해
        for (int i = 0; i < teamSize - 1; i++) {
            for (int j = 0; j < teamSize - 1 - i; j++) {

                // teams배열 푼 문제 수 index [0] vs [1] 내림차순 정렬 비교
                // [>]로 바꾸면 오름차순
                if (teams.get(j).solvedNum < teams.get(j + 1).solvedNum) {
                    // temporary 변수 값 저장용  [0] 값 저장
                    teamInfo temp = teams.get(j);

                    // 헷갈린점 : set(teams[0], teams.get(1)) 해당 인덱스 0 위치에 [1] =? 의 값을 set할때
                    // set 메서드 내부적으로 list.set(index, element);
                    // E set(int index, E element); 첫번째 파라미터에 인덱스 값 만 넣어주면 내부적으로 처리
                    teams.set(j, teams.get(j + 1));

                    // temporary 변수 값 -> 바뀐 인덱스 자리에 값 채워줌
                    teams.set(j + 1, temp);
                }
            }
        }
    }
}
//14512	104

