package W12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

class 게임개발_1516 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        int[] time = new int[N];
        int[] totalTime = new int[N];
        ArrayList<Integer>[] map = new ArrayList[N];
        for(int i=0; i < N; i++) {
            map[i] = new ArrayList<>();
        }
        for(int i=0; i < N; i++) {
            int num = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(true) {
                if(num++ == 0) time[i] = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());
                if(next == -1) break;
                map[next - 1].add(i);
                input[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i < N; i++) {
            if(input[i] == 0) {
                queue.offer(i);
                totalTime[i] = time[i];
            }
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i < size; i++) {
                int cur = queue.poll();
                for(int j=0; j < map[cur].size(); j++) {
                    int next = map[cur].get(j);
                    input[next]--;
                    totalTime[next] = Math.max(totalTime[next], totalTime[cur] + time[next]);
                    if(input[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        for(int i=0; i < N; i++) {
            sb.append(totalTime[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}