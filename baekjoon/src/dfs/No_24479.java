package dfs;

import java.io.*;
import java.util.*;

public class No_24479 {
    static ArrayList<Integer>[] graph;
    static int[] visitOrder;
    static int order = 1; // 방문 순서
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        visitOrder = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        // 각 정점의 인접 리스트를 오름차순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 탐색 시작
        dfs(R);

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(visitOrder[i]);
        }
    }

    // DFS 함수
    static void dfs(int node) {
        visited[node] = true;
        visitOrder[node] = order++; // 방문 순서 기록

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
