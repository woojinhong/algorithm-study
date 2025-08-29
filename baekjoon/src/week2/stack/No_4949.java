package week2.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/**
 모든 왼쪽 소괄호("(")는 오른쪽 소괄호(")")와만 짝을 이뤄야 한다.
 모든 왼쪽 대괄호("[")는 오른쪽 대괄호("]")와만 짝을 이뤄야 한다.
 모든 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재한다.
 모든 괄호들의 짝은 1:1 매칭만 가능하다. 즉, 괄호 하나가 둘 이상의 괄호와 짝지어지지 않는다.
 짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야 한다.
 */

public class No_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;


        // EOF(br = null) 프로그램 종료 ctrl z 까지 반복 (x)
        // 질문에 명시 온점(.) 으로 프로그램 종료
        while (!(line = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            char[] character = line.toCharArray();
            boolean isBalanced = true;  // 각 줄마다 초기화

            for(int i = 0; i < character.length; i++){
                char ch = character[i];
                if(ch == '(' || ch == '[')
                    stack.push(ch);
                else if (ch == ')'){
                    if(stack.empty() || stack.peek() != '(') {
                        isBalanced = false;
                        break;
                    }
                    stack.pop();
                    }
                else if(ch == ']'){
                    if(stack.empty() || stack.peek() != '[') {
                        isBalanced = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if(stack.empty() && isBalanced)
            sb.append("yes\n");
            else
                sb.append("no\n");
        }
        System.out.print(sb);
    }
}
