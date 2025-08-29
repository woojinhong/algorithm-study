package week1.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No_25593 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 주의 개수 입력
        int n = Integer.parseInt(br.readLine());

        // 각 근무자의 총 근무 시간을 기록할 맵
        Map<String, Integer> workTime = new HashMap<>();

        // 각 시간대별 근무 시간
        int[] shiftTimes = {4, 6, 4, 10}; // 각 시간대별 근무 시간 (08:00~12:00, 12:00~18:00, 18:00~22:00, 22:00~08:00)

        // n주차 동안의 근무표를 처리
        for (int week = 0; week < n; week++) {
            for (int day = 0; day < 7; day++) {
                for (int shift = 0; shift < 4; shift++) {
                    // 각 근무자를 읽어옴
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    while (st.hasMoreTokens()) {
                        String worker = st.nextToken();
                        if (!worker.equals("-")) {
                            // 해당 근무자의 근무 시간을 더해줌
                            workTime.put(worker, workTime.getOrDefault(worker, 0) + shiftTimes[shift]);
                        }
                    }
                }
            }
        }

        // 근무 시간이 기록된 모든 사람의 리스트에서 최대 근무 시간과 최소 근무 시간을 찾음
        if (workTime.isEmpty()) {
            System.out.println("Yes");
            return;
        }

        int maxTime = Collections.max(workTime.values());
        int minTime = Collections.min(workTime.values());

        // 최대 근무 시간과 최소 근무 시간의 차이가 12시간 이하인지 확인
        if (maxTime - minTime <= 12) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
