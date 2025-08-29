//package week2.dfs;
//
//import java.io.*;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.function.BiFunction;
//
///**
// * 연결 요소의 개수
// *
// * 1) 첫째 줄에 정점의 개수 N과 간선의 개수 M (노드, 간선)
// * 2) 둘쨰 줄 M개의 줄에 간선의 양 끝점 u와 v (간선 방향) - 무방향
// * 3) 출력: 연결 요소의 개수. 각 방향을 깊이 탐색한 횟수
// */
//public class No_11724 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int testCase = Integer.parseInt(br.readLine());
//
//        // edge 개수
//        int edgeNum = Integer.parseInt(br.readLine());
//
//        // edgeList
//        List<List<Integer>> edgeList = new LinkedList<>();
//
//        // LinkedList 인접 리스트 초기화
//        // list 초기화에 의미가 있나?
//        for (int i = 0; i <= testCase; i++){
//            edgeList.add(new LinkedList<>());
//        }
//
//        // 인덱스 1 부터 이용/ 0은 갖다버림  시작노드가 1이기 떄문에 헷갈리니까
//        for(int i = 1; i > edgeNum; i++){
//            edgeList.get(i).add()
//        }
//
//
//    }
//}
