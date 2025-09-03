package bruteForce;


import java.util.Scanner;

/**
 * 유레카 이론
 *
 * 1.자연수 n에 대한 삼각수 공식
 * T(n) = n(n+1)/2
 *
 *  테스트 케이스 t 번째 까지
 * 2.자연수 k가 주어졌을때 정확히 3개의 T(n) 합으로 표현 가능하다면 1 아니면 0
 *
 */
public class No_10448 {
    final static int TRIANGLE_COUNT = 1000;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 테스트 케이스
        int testCase = sc.nextInt();

        // 삼각수 T(n) 저장할 정수 배열
        int[] triangleNo = new int[TRIANGLE_COUNT+1];

        // 삼각수 T(n) 저장
        for(int n = 1; n <= TRIANGLE_COUNT; n++) {
            // 삼각수의 공식
            triangleNo[n] = n*(n+1)/2;
        }

        // e) 삼각수 3개로 표현 가능 여부를 담을 변수 선언
        byte isTrue;

        // 1. 테스트 케이스
        for(int i = 0; i < testCase; i++) {
            // 자연수 k
            int k = sc.nextInt();
            // e) 삼각수 3개로 표현 가능 여부를 담을 변수 0으로 초기화
            isTrue = 0;
            // 2. a = 삼각수 T(n)
            for(int a = 1; a <= TRIANGLE_COUNT; a++) {
                // 3. b = 삼각수 T(n)
                for(int b = 1; b <= TRIANGLE_COUNT; b++) {
                    // 4. c = 삼각수 T(n)
                    for(int c = 1; c <= TRIANGLE_COUNT; c++) {
                        // 4.1 자연수 k와 삼각수 [a+b+c]가 같다면
                        if(k == triangleNo[a] + triangleNo[b] + triangleNo[c]) {
                            // 4.2 e)의 변수에 1
                            isTrue = 1;
                            // 4.3 정지
                            break;
                        }
                    }
                }
            }
            System.out.println(isTrue);
        }
    }
}
