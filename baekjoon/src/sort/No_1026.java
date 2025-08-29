//package sort;
//
//import java.io.*;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
///**
// * int[] A = [N]
// * int[] B = [N]
// */
//public class No_1026 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int sizeArr = Integer.parseInt(br.readLine());
//
//        int[] A = new int[sizeArr];  // 배열 A
//        int[] B = new int[sizeArr];  // 배열 B
//
//        String lineA = br.readLine();
//        String lineB = br.readLine();
//
//        StringTokenizer tokenA = new StringTokenizer(lineA);
//        StringTokenizer tokenB = new StringTokenizer(lineB);
//
//        // A,B 배열 값 채워준다
//        for(int i = 0; i < sizeArr; i++){
//            A[i] = Integer.parseInt(tokenA.nextToken());
//            B[i] = Integer.parseInt(tokenB.nextToken());
//        }
//
//        mergeSortAsc()
//
//        for (int i = 0; i < N; i++) {
//            A[i] = sc.nextInt();
//        }
//
//        for (int i = 0; i < N; i++) {
//            B[i] = sc.nextInt();
//        }
//
//        // 병합 정렬을 이용하여 A는 오름차순, B는 내림차순으로 정렬
//        mergeSortAsc(A, 0, N - 1);
//        mergeSortDesc(B, 0, N - 1);
//
//        // S의 최솟값을 계산
//        int S = 0;
//        for (int i = 0; i < N; i++) {
//            S += A[i] * B[i];
//        }
//
//        // 결과 출력
//        System.out.println(S);
//    }
//}
