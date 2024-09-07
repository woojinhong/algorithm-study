package week1.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 혜민이는 요즘 모스 부호에 관심이 많아졌다. 모스 부호는 짧은 신호와 긴 신호를 적절히 조합하여 문자 기호를 표기하는 방식이다.
 각 문자를 나타내는 방식은 미리 정해져 있는데,
 예를 들어, 짧은 신호를 '.', 긴 신호를 '-'로 나타낸다면, 모스 부호로 알파벳 'A'는 '.-', 숫자 1은 '.----'와 같이 표기할 수 있다.
 모스 부호를 알고 있으면 위험한 상황에서 구조 요청을 하는 데 유용할 것 같아,
 혜민이는 평상시에 친구들과 연락을 주고받을 때도 모스 부호를 사용하려고 한다.
 혜민이는 친구들이 보내온 모스 부호를 올바르게 해독했는지 바로바로 확인하고 싶어졌다.
 알파벳 A-Z, 숫자 0-9, 기호 ',', '.', '?', ':', '-', '@'로 이루어진 길이
 $N$인 문자열을 변환한 모스 부호가 주어질 때, 주어진 모스 부호를 해독하여 원래의 문자열을 출력하는 프로그램을 작성해 보자.
 */
public class No_29701 {
    public static void main(String[] args) throws IOException {

        HashMap<String, String> map = new HashMap<>();
        map.put(".-", "A");
        map.put("-...", "B");
        map.put("-.-.", "C");
        map.put("-..", "D");
        map.put(".", "E");
        map.put("..-.", "F");
        map.put("--.", "G");
        map.put("....", "H");
        map.put("..", "I");
        map.put(".---", "J");
        map.put("-.-", "K");
        map.put(".-..", "L");
        map.put("--", "M");
        map.put("-.", "N");
        map.put("---", "O");
        map.put(".--.", "P");
        map.put("--.-", "Q");
        map.put(".-.", "R");
        map.put("...", "S");
        map.put("-", "T");
        map.put("..-", "U");
        map.put("...-", "V");
        map.put(".--", "W");
        map.put("-..-", "X");
        map.put("-.--", "Y");
        map.put("--..", "Z");
        map.put(".----", "1");
        map.put("..---", "2");
        map.put("...--", "3");
        map.put("....-", "4");
        map.put(".....", "5");
        map.put("-....", "6");
        map.put("--...", "7");
        map.put("---..", "8");
        map.put("----.", "9");
        map.put("-----", "0");
        map.put("--..--", ",");
        map.put(".-.-.-", ".");
        map.put("..--..", "?");
        map.put("---...", ":");
        map.put("-....-", "-");
        map.put(".--.-.", "@");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<n; i++){

            sb.append(map.get(token.nextToken()));
        }
        System.out.println(sb);
    }
}
