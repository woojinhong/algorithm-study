package tree;

import java.io.*;
import java.util.*;

public class No_9934 {
    static int K;
    static int[] buildings;
    static List<List<Integer>> levels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());  // 트리의 깊이
        buildings = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 각 레벨에 있는 노드 번호를 저장할 리스트
        levels = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            levels.add(new ArrayList<>());
        }

        // 트리의 중위 순회 결과로부터 트리를 재구성
        constructTree(0, buildings.length - 1, 0);

        // 결과 출력
        for (List<Integer> level : levels) {
            for (int num : level) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // 트리를 재구성하는 함수
    // start: 시작 인덱스, end: 끝 인덱스, depth: 현재 깊이
    public static void constructTree(int start, int end, int depth) {
        if (start > end) return;

        int mid = (start + end) / 2;  // 중위 순회에서 현재 루트 노드는 중앙에 위치
        levels.get(depth).add(buildings[mid]);  // 해당 깊이의 레벨에 노드 추가

        // 왼쪽 서브트리와 오른쪽 서브트리에 대해 재귀적으로 처리
        constructTree(start, mid - 1, depth + 1);  // 왼쪽 서브트리
        constructTree(mid + 1, end, depth + 1);    // 오른쪽 서브트리
    }
}
