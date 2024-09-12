package week1.day2;

import java.util.Scanner;

public class No_24416 {
    static int recursiveCount = 0;  // 재귀 호출에서 코드1 실행 횟수를 위한 전역 변수
    static int dpCount = 0;         // 동적 프로그래밍에서 코드2 실행 횟수를 위한 전역 변수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 재귀 호출 방식으로 실행 횟수 구하기
        fib(n);

        // 동적 프로그래밍 방식으로 실행 횟수 구하기
        fibonacci(n);

        System.out.println(recursiveCount + " " + dpCount);
    }

    // 재귀 방식으로 피보나치 수 계산 (코드1 실행 횟수를 셈)
    static int fib(int n) {
        if (n == 1 || n == 2) {
            recursiveCount++;  // 코드1 실행 횟수 증가
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // 동적 프로그래밍 방식으로 피보나치 수 계산 (코드2 실행 횟수를 셈)
    static int fibonacci(int n) {
        int[] f = new int[n];

        // 초기값 설정
        f[0] = 1;
        f[1] = 1;

        // 동적 프로그래밍 방식에서 반복문으로 피보나치 계산
        for (int i = 3; i <= n; i++) {
            dpCount++;  // 코드2 실행 횟수 증가
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n-1];
    }
}
