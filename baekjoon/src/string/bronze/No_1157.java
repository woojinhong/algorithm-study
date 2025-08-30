package string.bronze;

import java.util.Scanner;

public class No_1157 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        String word = sc.next();

        // count 배열 생성  ASCII 코드 (a~z) (1~26)  a = 65    A = 85
        // 0 ~ 25
        int[] countRepeatWord = new int[26];

        // 입력 값을 char 배열로 치환
        char[] splitWord = word.toCharArray();

        // 입력 값 저장 missisipi
        for(int i = 0; i < word.length(); i++){
            // 입력 값이 소문자 일 때  예) 'b'-'a' = 9
            if('a'<=splitWord[i] && splitWord[i]<='z')
                countRepeatWord[splitWord[i]-'a']++;

            // 입력 값이 대문자 일 때   예) 'B'-'A' = 1
            else
                countRepeatWord[splitWord[i]-'A']++;
        }

        // 첫번째 배열 max 변수에 저장
        int max = -1;
        char alphabet='?';
        for(int i = 0; i < countRepeatWord.length; i++){
            if(max < countRepeatWord[i]) {
                max = countRepeatWord[i];
                alphabet = (char)(i + 'A');
            }
            // 알파벳 최대 빈도수가 두개이상 같을때 '?' 출력
            else if(max == countRepeatWord[i]){
                alphabet = '?';
            }
        }

        System.out.println(alphabet);
    }
}