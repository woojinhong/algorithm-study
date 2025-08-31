//package string.bronze;
//
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class No_10158 {
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        StringTokenizer firstRow = new StringTokenizer(sc.nextLine());
//
//        // 게임판 입력 값
//        int x =0;
//        int y =0;
//
//        // 개미 초기위치 입력 값
//        int p = 0;
//        int q = 0;
//
//        // 게임판 x, y 값 설정
//        while (firstRow.hasMoreTokens()) {
//            x = Integer.parseInt(firstRow.nextToken());
//            y = Integer.parseInt(firstRow.nextToken());
//        }
//
//        StringTokenizer secondRow = new StringTokenizer(sc.nextLine());
//
//
//        // 게임 판 크기 설정
//        int[][] gameBoard = new int[x][y];
//
//
//        // 개미 p, q 값 설정
//        while (secondRow.hasMoreTokens()) {
//            p = Integer.parseInt(secondRow.nextToken());
//            q = Integer.parseInt(secondRow.nextToken());
//        }
//        // 현재 개미 위치 설정
//
//        // 시간 단위 설정
//        int t = sc.nextInt();
//
//
//        // 이동 부호
//        int move = 1;
//
//        // 1. 시간 Loop
//        for (int i = 0 ; i< t; i ++){
//            // 1.1 반사 조건
//            if(x==p || y==q || x == 0 || y==0){
//                // 1.1.1 부호 변경
//                move = Integer.parseInt(String.valueOf("-" + move));
//
//                p+move
//            }
//
//        }
//
//        // 1.2 반사 아닐 시 조건
//        // 1.2.1 각 x,y 좌표 1씩 증가
//    }
//}
