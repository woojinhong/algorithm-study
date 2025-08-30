package string.bronze;

import java.util.Scanner;

public class No_1543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문서 입력 값 추출 (ababababa)
        String doc = sc.nextLine();

        // 단어 입력 값 추출 (aba)
        String word = sc.nextLine();

        int count =0;

        // 1. 문서의 길이만큼 LOOP
        for (int i = 0; i < doc.length(); i++){
            // 1.1. 문서와 단어가 일치 시 count 증가
            boolean matchCase = true;
            for(int j = 0; j < word.length(); j++){
                // 2. 단어 불일치 시 break
                if(i+j >= doc.length() || doc.charAt(i+j) != word.charAt(j)) {
                    matchCase = false;
                    break;
                }
            }
            if(matchCase){
                count++;
                i += word.length()-1;
            }
        }
        System.out.println(count);
    }
}

