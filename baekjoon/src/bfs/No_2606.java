package bfs;

import java.io.*;
import java.util.*;

/** 바이러스 문제 풀이 */
public class No_2606 {
    static ArrayList<Integer>[] virusList;  // 각 컴퓨터의 연결 관계를 나타내는 인접 리스트
    static boolean[] visited;  // 방문 여부를 기록하는 배열

    // BFS 탐색 함수
    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;  // 시작 노드 방문 처리
        int count = 0;  // 감염된 컴퓨터 수를 기록할 변수

        while (!queue.isEmpty()) {
            int virus = queue.poll();
            count++;  // 현재 컴퓨터 감염 처리

            // 연결된 다른 컴퓨터 탐색
            for (int next : virusList[virus]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;  // 방문 처리
                }
            }
        }

        return count - 1;  // 1번 컴퓨터는 제외하고 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 컴퓨터의 수 (노드 수)
        int totalComputers = Integer.parseInt(br.readLine());
        // 네트워크 상에서 직접 연결된 컴퓨터 쌍의 수 (간선 수)
        int edgeCount = Integer.parseInt(br.readLine());

        // 인접 리스트 초기화
        virusList = new ArrayList[totalComputers + 1];
        for (int i = 1; i <= totalComputers; i++) {
            virusList[i] = new ArrayList<>();
        }

        // 방문 배열 초기화
        visited = new boolean[totalComputers + 1];

        // 간선 정보 입력받기 (연결된 컴퓨터 쌍 입력)
        for (int i = 0; i < edgeCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            virusList[u].add(v);
            virusList[v].add(u);  // 양방향 간선 처리
        }

        // BFS 탐색 시작 (1번 컴퓨터에서 시작)
        int result = bfs(1);

        // 감염된 컴퓨터 수 출력 (1번 컴퓨터 제외)
        System.out.println(result);
    }
}
