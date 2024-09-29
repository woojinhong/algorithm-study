package week2.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 *  번째 줄에 정환이 음을 아는 노래의 개수
 * $N$, 정환이 맞히기를 시도할 노래의 개수
 * $M$이 공백으로 구분되어 주어진다.
 *
 * 두 번째 줄부터
 * $N$개의 줄에 걸쳐 노래 제목의 길이
 * $T$, 영어 대소문자로 이루어진 문자열 노래 제목
 * $S$, 해당 노래에서 처음 등장하는 일곱 개의 음이름
 * $a_1, a_2, a_3, a_4, a_5, a_6, a_7$이 공백으로 구분되어 주어진다.
 *
 *
 * $N+2$번째 줄부터
 * $M$개의 줄에 걸쳐 정환이 맞히기를 시도할 노래의 첫 세 음의 음이름
 * $b_1, b_2, b_3$가 공백으로 구분되어 주어진다.
 *
 * 주어지는 음이름은 각각 C, D, E, F, G, A, B 중 하나이다. 같은 제목이 두 번 이상 주어지지 않는다.
 */
public class No_31562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 입력 (N: 노래 개수, M: 맞히기 시도 개수)
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        // 노래 정보 저장용 HashMap (첫 세 음 -> 노래 제목 리스트) 예) ccc = Cprogramming
        HashMap<String, HashSet<String>> songMap = new HashMap<>();

        // n개의 노래 정보 입력 (노래 제목 길이, 노래 제목, 7개 음계)
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());

            // 노래 제목의 길이 (사용하지 않음)
            token.nextToken();

            // 노래 제목
            String title = token.nextToken();

            // 첫 7개의 음 중 첫 세 음 추출
            StringBuilder firstThreeNotes = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                firstThreeNotes.append(token.nextToken());
            }

            String key = firstThreeNotes.toString();

            // HashMap에 첫 세 음을 키로 하고, 해당 음으로 시작하는 노래 제목을 저장
            songMap.putIfAbsent(key, new HashSet<>()); // 해당 키 존재 하지 않을 시 new HashSet<> 객체 생성
            songMap.get(key).add(title); // 만약 key 중복 시, 새로운 title 추가 예 ccc = {cprogramm, doyoubulidsnow}
        }

        // M개의 맞히기 시도 처리
        for (int i = 0; i < m; i++) {
            // 첫 세 음 입력
            token = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                sb.append(token.nextToken());
            }

            String threeNotesStringfy = sb.toString();

            // 해당 음으로 시작하는 노래 찾기
            // 해당 음 맞는 제목 없으면 "!" 반환
            if (!songMap.containsKey(threeNotesStringfy)) {
                System.out.println("!");
            } else {
                // 제목 hashset 반환 후 새로운 개
                HashSet<String> matchedSongs = songMap.get(threeNotesStringfy);
                if (matchedSongs.size() == 1) {
                    // 반환 값 String.  findfirst() -> 첫번째 요소 찾아 optional<T> 로 반환  // .get() = 요소 꺼내오기
                    System.out.println(matchedSongs.stream().findFirst().get());
                } else {
                    // key 값 연결된 제목이 한개 이상이면 ? 반환
                    System.out.println("?");
                }
            }
        }
    }
}
