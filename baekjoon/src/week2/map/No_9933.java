package week2.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 창영이는 민균이의 컴퓨터를 해킹해 텍스트 파일 하나를 자신의 메일로 전송했다. 파일에는 단어가 한 줄에 하나씩 적혀있었고, 이 중 하나는 민균이가 온라인 저지에서 사용하는 비밀번호이다.
 *
 * 파일을 살펴보던 창영이는 모든 단어의 길이가 홀수라는 사실을 알아내었다. 그리고 언젠가 민균이가 이 목록에 대해서 얘기했던 것을 생각해냈다. 민균이의 비밀번호는 목록에 포함되어 있으며, 비밀번호를 뒤집어서 쓴 문자열도 포함되어 있다.
 *
 * 예를 들어, 민균이의 비밀번호가 "tulipan"인 경우에 목록에는 "napilut"도 존재해야 한다. 알 수 없는 이유에 의해 모두 비밀번호로 사용 가능하다고 한다.
 *
 * 민균이의 파일에 적혀있는 단어가 모두 주어졌을 때, 비밀번호의 길이와 가운데 글자를 출력하는 프로그램을 작성하시오.
 */


// Hash Map <String, Char>
// string.converse == map keycontains.? : value :
// 해당 길이 출력
public class No_9933 {
    public static void main(String[] args) throws IOException {

        // <비밀번호 후보, 중간 문자>
        HashMap<String, Character> middleword = new HashMap<>();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());


        // key의 길이 저장
        int keyLength = 0;
        // key 해당 중간 char 저장
        char value = 0;

        for (int i = 0; i < testcase; i++){
            String word = br.readLine();
            // 가운데 글자를 구하기 위한 동작
            // 1. 중간 인덱스 구하기
            // 2. 중간 char 반환
            // 3. map의 value로 저장
            int midindex = word.length() / 2;
            char midchar = word.charAt(midindex);

            // 단어 map에 추가
            middleword.put(word, midchar);

            // 뒤집은 단어 저장
            String reverseword = new StringBuilder(word).reverse().toString();

            // 뒤집은 단어 -> map에 존재 유무
            if(middleword.containsKey(reverseword)){
                // key의 길이 출력
                keyLength = word.length();

                // key에 해당하는 value(중간 문자) 출력
                value = midchar;

            }
        }
        // 결과 출력
        System.out.println(keyLength + " " + value);
        br.close();
    }
}
// 16476 124