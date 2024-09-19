package sepThird;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class 돌그룹12886 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] rocks = new int[3];
        boolean[][] check = new boolean[1501][1501];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i=0; i < 3; i++) {
            rocks[i] = Integer.parseInt(st.nextToken());
            sum += rocks[i];
        }
        if(sum % 3 != 0) { // 똑같이 나눌 수 없으면 끝내기
            System.out.println(0);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(rocks);
        check[rocks[0]][rocks[1]] = true;
        int ans = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == cur[1] && cur[1] == cur[2]) { // 만들 수 있으면
                ans = 1;
                break;
            }
            int[] next = new int[3];
            if(cur[0] != cur[1]) { // 다르면 큰거 작은거 계산
                next[0] = cur[0] > cur[1] ? cur[0] - cur[1] : cur[0] * 2;
                next[1] = cur[0] > cur[1] ? cur[1] * 2 : cur[1] - cur[0];
                next[2] = cur[2];
                if(!check[next[0]][next[1]] && next[0] + next[1] + next[2] == sum) {
                    check[next[0]][next[1]] = true;
                    queue.offer(next);
                }
            }

            next = new int[3];
            if(cur[0] != cur[2]) {
                next[0] = cur[0] > cur[2] ? cur[0] - cur[2] : cur[0] * 2;
                next[1] = cur[1];
                next[2] = cur[0] > cur[2] ? cur[2] * 2 : cur[2] - cur[0];
                if(!check[next[0]][next[2]] && next[0] + next[1] + next[2] == sum) {
                    check[next[0]][next[2]] = true;
                    queue.offer(next);
                }
            }

            next = new int[3];
            if(cur[1] != cur[2]) {
                next[0] = cur[0];
                next[1] = cur[0] > cur[1] ? cur[1] * 2 : cur[1] - cur[0];
                next[2] = cur[0] > cur[2] ? cur[2] * 2 : cur[2] - cur[0];
                if(!check[next[1]][next[2]] && next[0] + next[1] + next[2] == sum) {
                    check[next[1]][next[2]] = true;
                    queue.offer(next);
                }
            }
        }

        System.out.println(ans);
    }
}