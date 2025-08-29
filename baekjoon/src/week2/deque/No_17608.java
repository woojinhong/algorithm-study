package week2.deque;
/**
 N개의 막대기에 대한 높이 정보가 주어질 때, 오른쪽에서 보아서 몇 개가 보이는지를 알아내는 프로그램을 작성하려고 한다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**접근법:
 막대기를 보는 방향 -> 마지막 요소 위치
 자료구조: Stack, ArrayDeque
 마지막 요소 값을 기준으로 더 적은 값은 POP
 남은 요소 개수 count
 Stack.count? 이런 메서드가 존재하지 않을까?


 ** 해당 문제에 대해 각 자료구조별 시간 복잡도 고민
 * *Stack*
 * 접근(조회)는 O(1)
 * 삭제 POP()도 O(1)
 *
 * 다른 자료구조는 어떨까?
 * *Arraylist*
 * 접근(조회) O(1)
 * 삭제 O(n) = 중간 요소 제거 시 요소 이동시간 존재
 *
 * *LinkedList*
 * 접근(조회) O(n): 마지막 노드 접근 시 n개의 노드를 거쳐 확인
 * 삭제 O(1): 인덱스를 알면 삭제는 상수 시간복잡도
 *
 * *queue*
 * 접근 0(n): 마지막 요소 접근을 위해 앞에 요소부터 순차적으로 삭제해야함 (아주 안좋음)
 * 삭제 O(1): 삭제는 상수 시간 복잡도 이지만 애초에 마지막 요소를 알아야 하므로 (접근O(n) 후 삭제O(1))
 *
 * *deque*  linkedlist
 * 접근 O(1): 인덱스 기반으로 요소에 빠르게 접근하는 것처럼 보이지만, 실제로는 내부적으로 첫 번째 노드부터 차례대로 탐색하여 해당 인덱스에 도달
 * 삭제 O(1): 마찬가지로 빠름, 허나 중간은 O(n)

 * *deque*  ArrayDeque
 * 접근 O(1): 마지막 요소 접근 시 빠름, 허나 중간 요소 접근 시 O(n) 중간요소는 하나씩 삭제해가며 접근해야함
 * 삭제 O(1): 마찬가지로 빠름, 허나 중간은 O(n)
 *
 *
 *
 *
 * *궁금한 점*
 * deque = new linkedlist() VS List = new linkedList()
 * 같은 구현체를 갖고 다른 인터페이스를 상속하는 상황은 어떤 자료구조를 사용한건가?
 * deque, List, Stack, queue 는 자료구조가 아닌 인터페이스 즉 사용가능한 메서드들이 다름
 * 즉 구현체가 자료구조, 노드를 이용한 매커니즘에 인터페이스에 따라 사용 가능한 기능이 다른거
 *
 *예)
 *  deque = 인덱스 접근 불가
 *  List = 인덱스 접근 가능
 */


// Stack 과 Deque 둘다 사용가능
public class No_17608 {
    public static void main(String[] args) throws IOException {
        /**
         * 각 줄 마다 버퍼에 미리 저장된 데이터에서 값을 반환하기 때문에 성능이 더 효율적
         *
         Scanner: 정규 표현식을 사용하여 데이터를 자동으로 파싱하는 과정이 추가
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());


        // 배열기반 arrayDeque 자료구조 이용
        Deque<Integer> bars = new ArrayDeque<>();

        // 테스트 케이스
        for(int i = 0; i < testcase; i++){
            int bar = Integer.parseInt(br.readLine());
            bars.addLast(bar);
        }

        // 마지막 막대를 기준으로 설정
        int lastbar = bars.removeLast();  // 첫 번째 기준은 마지막 막대
        int visibleCount = 1;  // 마지막 막대는 무조건 보임

        //deque가 비어있을때 까지 루프
        while(!bars.isEmpty()){
        if(lastbar<bars.peekLast()){
            // 기준보다 큰 막대 갱신 후 삭제
            lastbar = bars.removeLast();
            // 보이는 막대 개수 증가
            visibleCount++;
        }else{
            bars.removeLast();
        }

        }

        System.out.println(visibleCount);
    }
}
//25944	232