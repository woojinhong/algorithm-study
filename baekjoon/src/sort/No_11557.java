package sort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/** Yangjojang of The Year
 *
 * 입력
 * 테스트 케이스
 *  - 학교 수 (1 <= N <= 100)
 *      - 한 해 술양 (0 <= L <= 10,000,000)
 *
 * 술 소비 가장 많은 학교 출력
 */

// Bubble sort 실험
public class No_11557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        List<university> uni ;
        while(testCase-- > 0){

            int uniNum = Integer.parseInt(br.readLine());

            // testCase 마다 uni 정보 초기화
            uni = new ArrayList<>();

            for (int i = 0; i < uniNum; i++){
                String line = br.readLine();
                StringTokenizer token = new StringTokenizer(line);
                String uniName = token.nextToken();
                int sojuLiter = Integer.parseInt(token.nextToken());
                uni.add(new university(uniName , sojuLiter));
            }

            // 거품 소트 시작
            bubbleSort(uni);

            // 내림차순 했으니 0번째가 가장 소주 많이 마심.
            bw.write(uni.get(0).name);
            bw.newLine();

        }
        bw.flush();
        bw.close();
        br.close();

    }
    //내림차순 정렬 -> 작은 값이 맨 오른쪽
    private static void bubbleSort(List<university> uni) {
        for(int i = 0; i < uni.size(); i++){
            for(int j = 0; j < uni.size()-1-i; j++){
                if(uni.get(j).sojuCnt < uni.get(j+1).sojuCnt){

                    // temporary 값 저장
                    university temp = uni.get(j);
                    // j 번째 인덱스 = uni[j+1] 객체 이동
                    uni.set(j, uni.get(j+1));
                    // temporary 객체 j+1 인덱스에 저장
                    uni.set(j+1, temp);

                }
            }
        }
    }

}
class university{
    String name;
    int sojuCnt;

    public university(String name, int sojuCnt) {
        this.name = name;
        this.sojuCnt = sojuCnt;
    }
}

//14004	100
