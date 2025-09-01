package Array;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 줄 세우기
 *
 * 자기 앞에 자기보다 키가 큰 학생이 없다면 그냥 그 자리에 서고 차례가 끝난다.
 * 자기 앞에 자기보다 키가 큰 학생이 한 명 이상 있다면 그중 가장 앞에 있는 학생(A)의 바로 앞에 선다.
 * 이때, A부터 그 뒤의 모든 학생들은 공간을 만들기 위해 한 발씩 뒤로 물러서게 된다.
 */
public class No_10431 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 수
        int testCases = sc.nextInt();

        // 학생 20명 신장 입력 값 + 각각의 테스트 케이스 수
        String studentHeights = sc.nextLine();

        StringTokenizer st = new StringTokenizer(studentHeights);

        // 학생 신장 값을 담을 크기 (20) + 테스트 케이스 수 (1) 의 int 배열 선언
        int[] heights = new int[20];

//        for(int i = 0; i < testCases; i++) {
            int index = 0;
            while (st.hasMoreTokens()) {
                heights[index++] = Integer.parseInt(st.nextToken());
            }


        int count = 0;


        // 1. 배열의 맨 뒤 (INDEX( 0~ 20 )) 부터 체킹
        for(int i = heights.length; i >= 1; i--) {
            // 2. 학생 신장의 값을 담은 첫번째 배열 (INDEX 1) 부터 계산
            for(int j = 1; j <= heights.length; j++) {
                // 2.1 맨 마지막 학생(heights[20])의 신장과 첫번째 학생(heights[1]) 보다 작다 조건문
                if(heights[i]<heights[j]) {
                    // 2.1.1 마지막 학생이 첫번째 보다 키가 작을 시 [studentHeights.length()-1](20) - j (break;) count+= 19
                    int add = heights.length - j;
                    count += add;
                    break;
                }
            }
        }

        // 3. 출력 height[0] testCase 번호 + count
        System.out.println(count);


    }
}
