package dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/** 촌수계산
 *
 * -입력-
 * testCase = 전체 사람의 수
 * firstMan, secondMan = 첫번쨰 사람 고유 번호, 두번째 사람 고유 번호
 * ilchonNum = 부모 자식들 간의 관계의 개수
 * parent, child = 부모, 자식
 *
 * -출력-
 * firstMan, secondMan의 촌수 값
 *
 * -제한-
 * - child의 부모는 항상 parent 1촌
 * - 각 사람의 부모는 최대 한 명만 주어진다.
 * - 두 사람의 친척 관계가 전혀 없을때 -1을 출력
 *
 * -점화식-
 * base condition = firstMan -> secondMan 위치 도달 시 종료
 * ilchonNum의 일촌 수 = 총 간선 수, parent - child 관계 = 간선
 * 최단 경로 dfs -> 다음 노드 탐색 - > chonNum(촌수) ++
 * 두 사람(firstMan과 secondMan)이 같은 경우, 촌수 = 0
 * 두 사람 간 경로가 없을 경우, 촌수는 = -1
 * 재귀 함수는 특정 노드에서 다음 노드로 탐색을 진행하고, 목표에 도달하면 종료됩니다.

 */
public class No_2644 {
    static ArrayList<List<Integer>> ilchonArr = new ArrayList<>();
    static boolean[] visited;  // 방문 여부를 기록하는 배열
    static int result = -1;    // 촌수 결과 값

    private static void dfs(int start, int target, int chonsuCnt) {

        // 방문 판매 여부 확인
        visited[start] = true;

        //
        if(start == target){
            result = chonsuCnt;
            return;
        }

        // linked list 기준 node 수 만큼 순회

        for (Integer linkedInt : ilchonArr.get(start)) {
            if(!visited[linkedInt]) {

                dfs(linkedInt, target, chonsuCnt+1);

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int totalMan = Integer.parseInt(br.readLine());

        String line = br.readLine();

        StringTokenizer token = new StringTokenizer(line);

        int start = Integer.parseInt(token.nextToken());
        int target = Integer.parseInt(token.nextToken());

        // 총 간선 수
        int ilchonNum = Integer.parseInt(br.readLine());

        // 인덱스 1부터 시작 0은 편의를 위해 버린다.
        visited = new boolean[totalMan + 1];


        // 각 배열 사람 수 + 1
        for (int i = 0; i <= totalMan; i++){
            ilchonArr.add(new LinkedList<>());
        }

        // 간선 초기화
        for (int i = 0; i < ilchonNum; i++){
            String ilchonRelationship = br.readLine();
            StringTokenizer ilchons = new StringTokenizer(ilchonRelationship);
            int parent = Integer.parseInt(ilchons.nextToken());
            int child = Integer.parseInt(ilchons.nextToken());

            // 양방향 간선 설정
            ilchonArr.get(parent).add(child);
            ilchonArr.get(child).add(parent);
        }

        dfs(start, target, 0);

        // 결과 출력
        bw.write(result == -1 ? "-1" : String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
//14228	104
