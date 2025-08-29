package week2.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *  Deque 활용
 *  (세가지 버튼 옵션)
    1. 맨 뒤 블록 추가 = 1
    2. 맨 앞 블록 추가 = 2
    3. 가장 나중에 추가된 블록 제거 = stack 순서대로 저장 -> 마지막에 추가된 문자열 제거예정
    if (stack length == 0) {print 0}
 */
public class No_27497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 3가지의 버튼을 누른 총 횟수 n개
        int n = Integer.parseInt(br.readLine());

        Deque<String> deque = new LinkedList<>();
        // 블록이 추가된 위치를 기록하는 데 사용
        Stack<Integer> blockstack = new Stack<>();
        // 테스트 케이스 n번
        for (int i = 0; i < n; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            // 버튼 옵션 저장 예(1,2,3)
            int button = Integer.parseInt(token.nextToken());
            // 문자열 정보 저장 (만약 3이라면 뒤에 문자열 없으니 저장 안됨)
            // if (1&2) else(3) 으로 엮음
            if (button == 1 || button == 2) {
                // block 문자열 정보 저장
                String block = token.nextToken();
                // 버튼 1 = 맨 뒤 블록 문자열 추가
                if (button == 1) {
                    deque.addLast(block);
                    blockstack.push(1);
                    // 버튼 2 = 맨 앞 블록 문자열 추가
                } else if (button == 2) {
                    deque.addFirst(block);
                    blockstack.push(2);
                }

                } else{
                    // 문자열이 빈 문자열인 경우 0을 출력한다.
                    if (!blockstack.empty()) {
                        // 1 = 뒤, 2 = 앞
                        int lastPosition = blockstack.pop();
                        if (lastPosition == 1) {
                            deque.removeLast();

                        } else {
                            deque.removeFirst();

                        }
                    }
            }
        }
        // deque 비면 0 출력
        if (deque.isEmpty()) {
            System.out.println("0");
        } else {
            // deque 문자열 출력
            StringBuilder sb = new StringBuilder();
            for (String s : deque) {
                sb.append(s);
            }
            System.out.println(sb);
        }
    }
}
