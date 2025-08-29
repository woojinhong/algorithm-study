package string.bronze;

import java.util.Scanner;


/**
 * 예제 입력 2
 * 5
 * 54321
 *
 * 예제 출력 2
 * 15
 *
 */
public class No_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = Integer.parseInt(sc.nextLine());

        String n = sc.nextLine();

        int sum = 0;

        for(int i = 0; i < s; i++) {
            sum += (n.charAt(i)-'0');
        }
        System.out.println(sum);
    }
}
