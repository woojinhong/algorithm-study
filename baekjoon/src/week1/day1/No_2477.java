package week1.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class No_2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 각 변의 위치를 특정할 배열 선언
        int[] edge = new int[6];

        // 가로, 세로 최대 값 선언
        int max_width = 0, max_height = 0;

        // 가로, 세로 최댓 값 인덱스
        int width_index = -1, height_index = -1;

        // 1m^2의 넓이에 자라는 참외의 개수 입력 값
        int n = Integer.parseInt(br.readLine());

        // 6개의 변 입력 값
        for(int i = 0; i<edge.length; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());

            // 동, 서, 남, 북
            int direction = Integer.parseInt(token.nextToken());
            // 변의 길이
            int length = Integer.parseInt(token.nextToken());

            // 변의 인덱스 값 저장
            edge[i] = length;

            // 세로, 가로 최댓 값 구하기
            switch (direction){
                case 1:
                case 2:
                    max_width = Math.max(max_width, edge[i]);
                    width_index = i;
                    break;
                case 3:
                case 4:
                    max_height = Math.max(max_height, edge[i]);
                    height_index = i;
                    break;
            }
        }

        // 큰 직사각형
        int lRectangle = max_width * max_height;

        // 작은 직사각형의 height, width
        int abs_height = Math.abs(edge[(width_index + 1) % 6] - edge[(width_index + 5) % 6]);
        int abs_width = Math.abs(edge[(height_index + 1) % 6] - edge[(height_index + 5) % 6]);



        // 작은 직사각형
        int sRectangle = abs_height * abs_width;

        // 원하는 육각형 면적
        int rectangle = lRectangle-sRectangle;

        // 육각형 면적의 참외 개수
        System.out.println(rectangle * n);
    }
}
