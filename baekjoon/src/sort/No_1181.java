package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class No_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());


        // Set을 사용하여 중복 단어 제거
        Set<String> wordsSet = new HashSet<>();


        // 단어 삽입
        while (testCase-- > 0){
            wordsSet.add(br.readLine());
        }

        // set 삽입 예시) (i, no, wait, wont)

        // Stream을 사용하여 Set을 List로 변환하고 정렬
        List<String> sortedWordsList = wordsSet.stream()

                //"i" (길이 1), "no" (길이 2), "wait" (길이 4), "wont" (길이 4)의 순서  // 길이가 같으면 set에 삽입 순서에 따라 다름.
                .sorted(Comparator.comparingInt(String::length)

                        // .thenComparing((word1, word2) -> word1.compareTo(word2));
                        // -1 : word1 앞에 배치
                        // 1 : word2 앞으로
                        // 0 : 유지
                        .thenComparing(String::compareTo))
                //최종 연산 -> list로 반호나
                .collect(Collectors.toList());

        // 결과 출력
        sortedWordsList.forEach(System.out::println);
    }
}

//	26780	572