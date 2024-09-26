package week2.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 push X: 정수 X를 큐에 넣는 연산이다.
 pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 size: 큐에 들어있는 정수의 개수를 출력한다.
 empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
public class No_10845 {

    public static void main(String[] args) throws IOException {
        // 입력을 처리하기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();  // 결과 출력을 위한 StringBuilder

        int N = Integer.parseInt(br.readLine());  // 명령의 개수
        Deque<Integer> deque = new ArrayDeque<>();  // 큐 생성

        // 명령을 하나씩 처리
        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            /**
             * **split()**은 정규 표현식으로 문자열을 처리하므로 좀 더 시간이 걸릴 수 있습니다.
             * Pattern 클래스의 Pattern.split() 메서드
             * 한 번 컴파일된 정규식은 캐싱되므로, 문자열을 나눌 때 추가적인 정규식 변환 작업이 없습니다.
             * **StringTokenizer**는 단순 구분자 처리이기 때문에, 성능이 더 빠를 수 있습니다.
             */
            // 공백으로 구분된 명령어를 분리
            String[] parts = command.split(" ");
            String operation = parts[0];

            switch (operation) {
                case "push":
                    int value = Integer.parseInt(parts[1]);
                    deque.offer(value);
                    break;

                case "pop":
                    // 첫 번째 요소를 제거하고 반환
                    sb.append(deque.isEmpty() ? -1 : deque.poll()).append("\n");
                    break;

                case "size":

                    // 크기 출력
                    sb.append(deque.size()).append("\n");
                    break;

                case "empty":

                    // 비어 있으면 1.orelse 0 반환
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;

                case "front":

                    // 첫번째 요소 반환
                    sb.append(deque.isEmpty() ? -1 : deque.peek()).append("\n");
                    break;

                //back
                default:

                    // 디큐의 마지막 요소 확인
                    sb.append(deque.isEmpty() ? -1 : deque.getLast()).append("\n");
                    break;
            }
        }
        // 결과 출력
        System.out.println(sb);
        br.close();
    }
}
//20736	180 queue

//20636	160 deque

//20292	176 deque (br.close) 추가: close() 도 I/O 연산으로 침. 스트림을 비울 때 추가적인 I/O 작업을 발생

