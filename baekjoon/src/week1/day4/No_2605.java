package week1.day4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/** 1.문제
 첫 번째 학생이 번호를 뽑은 후 : 1
 두 번째 학생이 번호를 뽑은 후 : 2 1
 세 번째 학생이 번호를 뽑은 후 : 2 3 1
 네 번째 학생이 번호를 뽑은 후 : 4 2 3 1
 다섯 번째 학생이 번호를 뽑은 후 : 4 2 5 3 1
 따라서 최종적으로 학생들이 줄을 선 순서는 4, 2, 5, 3, 1이 된다.

 줄을 선 학생들이 차례로 뽑은 번호가 주어질 때 학생들이 최종적으로 줄을 선 순서를 출력하는 프로그램을 작성하시오.
 **/

/** 고민
 ** ArrayList VS LinkedList **

 List 인터페이스를 구현하는 자료구조
 - 요소의 삽입 순서대로 저장
 - 동적으로 크기 증가
 - 인덱스를 이용한 요소 접근법


 ** 빅오 표기법(Big O Notation) **

 알고리즘이 실행되는 데 걸리는 시간 또는 필요한 메모리 양이 입력 크기(n)에 따라 어떻게 변하는지를 설명하는 방식.

 - O(n) (선형 시간 복잡도) : 시간이 입력 크기 n에 비례해서 늘어남 예: linkedlist 노드 조회
 - O(1) (상수 시간): 입력의 크기와 관계없이 항상 일정함 예: arraylist 인덱스 조회
 - O(log n): 로그 시간, 입력 크기가 커져도 시간 증가가 매우 느림. 예: 이진 탐색.
 - O(n²): 입력 크기에 따라 처리 시간이 급격히 증가. 예: 이차 시간, 중첩된 반복문

 ArrayList:
 삽입: 배열 기반, 중간 삽입의 시간 복잡도는 O(n)
 탐색: 특정 인덱스에 접근 : O(1).
 - 즉, 배열의 특정 위치를 탐색하는 것은 빠르지만, 삽입 연산 자체는 느림.

 LinkedList:
 삽입: 노드 기반, 중간 삽입의 시간 복잡도 O(1).
 탐색: 특정 인덱스 탐색 시 :O(n)  (처음부터 해당 인덱스까지 차례대로 노드를 탐색해야 함)
 14092	100 112

 ** 자료구조 고민 **
 * ArrayList : 100ms
 * LinkedList : 112ms

 ***** linkedList 실행시간이 길었던 이유.. *****

 ** 실행 시간 차이의 원인 **

 백준의 입력 데이터(5, 0 1 1 3 2)는 5개의 값에 불과. 이 적은 입력 크기로는 중간 삽입에 따른 성능 차이가 크게 드러나지 않는다고 판단.

 하지만 학생 수, 즉 입력 크기가 늘어날 수 록 중간 삽입이 빈번히 발생하는 문제이므로 삽입연산 O(1) **LinkedList**가 더 빠른 수행이 가능하다고 판단.

 **/
public class No_2605 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 입력: 학생의 수 N
        int N = Integer.parseInt(in.readLine());

        // 두 번째 입력: 학생들이 뽑은 번호들
        StringTokenizer st = new StringTokenizer(in.readLine());

        // 학생들의 줄을 저장할 리스트 (LinkedList는 중간에 삽입하기 편리함)
        List<Integer> students = new LinkedList<>();

        // 학생들이 번호를 뽑은 순서대로 반복
        for(int i = 0; i < N; i++) {
            // 번호를 뽑은 후, 몇 칸 앞으로 갈지 결정 (Integer.parseInt(st.nextToken()))
            int pick = Integer.parseInt(st.nextToken());

            // 학생 번호는 1부터 시작하므로 (i+1)을 사용
            // `i - pick` 번째 위치에 해당 학생을 삽입
            students.add(i - pick, i + 1);
        }

        // 최종 줄의 상태를 출력하기 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(students.get(i)).append(" ");
        }

        // 결과 출력
        System.out.println(sb);
    }
}
