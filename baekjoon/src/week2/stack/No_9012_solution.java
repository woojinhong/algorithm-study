package week2.stack;

import java.util.Scanner;
import java.util.Stack;

public class No_9012_solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++){
            String target = scanner.next();;
            System.out.println(parenthesisVerification(target) ? "YES" : "NO");
        }
        scanner.close();
    }

    private static boolean parenthesisVerification(String target) {
        Stack<Character> stack = new Stack<>();

        for(char c : target.toCharArray()){
            if( c=='('){
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()){
                    return false;
                }
                stack.pop();

            }
        }
        return stack.isEmpty();
    }

}
