package week1.day2;

import java.util.Scanner;

public class No_10994 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        char[][] star = new char[4 * (N - 1) + 1][4 * (N - 1) + 1];
        for (int i = 0; i < 4 * (N - 1) + 1; i++) {
            for (int j = 0; j < 4 * (N - 1) + 1; j++) {
                star[i][j] = ' ';
            }
        }
        starBoard(0, star, N);
        for (int i = 0; i < 4 * (N - 1) + 1; i++) {
            for (int j = 0; j < 4 * (N - 1) + 1; j++) {
                System.out.print(star[i][j]);
            }
            System.out.println();
        }
    }

    public static void starBoard(int start, char[][] array, int n) {
        if (n <= 0) {
            return;
        }
        int cnt = 4 * (n - 1) + 1;
        for (int i = start; i < start+4 * (n - 1) + 1; i++) {
            array[start][i] = '*';
            array[i][start] = '*';
            array[start+4 * (n - 1)][i] = '*';
            array[i][start+4 * (n - 1)] = '*';

        }
        starBoard(start+2, array, n-1);
    }
}

