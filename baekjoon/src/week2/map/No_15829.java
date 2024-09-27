package week2.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 Hashing 문제
 접근

 //a = 1, b = 2 .... z = 26
 1.Map 으로 저장하자

 for (i< testcase)
 반복문으로 sum += (map.keyvalue * 31^i)
 sum +=
 */
public class No_15829 {

    public static void main(String[] args) throws IOException {

        final int FIXED_NO = 1;

        final int FIXED_R = 31;

        final int FIXED_M = 1234567891;

        // 최종 값
        long sum = 0;

        // r^i
        long pow = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> transformAscii = new HashMap<>();

        // Map에 각 캐릭터 ->  치환된 Ascii 저장
        for (char c = 'a'; c <= 'z'; c++) {
            transformAscii.put(c, c - 'a' + FIXED_NO);  // 예) put('a', 97-'97' +1)
        }

        // 예) zzz
        String line = br.readLine();

        // testcase loop
        for (int i = 0; i < testcase; i++){

            // 각 알파벳 저장
            char alphabet = line.charAt(i);

            //
            sum += ((transformAscii.get(alphabet) * pow) % FIXED_M) ;


            //  곱셈이 먼저 이루어진 후에 모듈로 연산이 적용되기 때문에 곱셈 자체에서 오버플로우가 발생함
            pow = (pow * FIXED_R) % FIXED_M;

        }
        System.out.println(sum % FIXED_M);
    }
}
// 14268 100