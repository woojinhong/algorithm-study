package week2.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 *  Deque 활용
 push_front X: 정수 X를 덱의 앞에 넣는다.
 push_back X: 정수 X를 덱의 뒤에 넣는다.
 pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 size: 덱에 들어있는 정수의 개수를 출력한다.
 empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
 front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */



/**
 *  linkedList vs arrayDeque
 *
 *  linkedlist = 각 노드 요소가 독립적인 힙 메모리 공간에 저장 -> 각 노드가 추가적인 참조를 저장 -> 메모리 오버헤드
 *  arrayDeque = 배열 특성상 순차적으로 힙 메모리 공간에 저장 -> 하나의 순차적인 메모리를 참조
 *
 *  중간에
 */
public class No_10866 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        // 테스트 케이스 n
        for (int i = 0; i < n; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            String command = token.nextToken();

            switch (command){
                    // 앞에 추가
                case "push_front":
                    int frontValue = Integer.parseInt(token.nextToken());
                    deque.addFirst(frontValue);
                    break;
                    // 뒤에 추가
                case "push_back":
                    int backValue = Integer.parseInt(token.nextToken());
                    deque.addLast(backValue);
                    break;
                    // 앞에 제거
                case "pop_front":
                    // 비어 있을 시 -1 출력
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.pollFirst()).append("\n");
                    }
                    break;
                    // 뒤에 제거
                case "pop_back":
                    // 비어 있을 시 -1 출력
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.pollLast()).append("\n");
                    }
                    break;
                case "size":
                    // 현재 개수 출력
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    // 빈 덱 = 1 , 아니면 0 출력.
                    sb.append(deque.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    // 빈 덱 -1 출력
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                        //
                    } else {
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.peekLast()).append("\n");
                    }
                    break;
            }
            }
        System.out.print(sb);
        }
    }

