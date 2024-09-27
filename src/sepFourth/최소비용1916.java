package sepFourth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class 최소비용1916 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cityNum = Integer.parseInt(br.readLine());
        int busNum = Integer.parseInt(br.readLine());
        ArrayList<int[]>[] cities = new ArrayList[cityNum];
        int[] dist = new int[cityNum];
        boolean[] visited = new boolean[cityNum];

        for(int i=0; i < cityNum; i++) {
            cities[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i < busNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cities[Integer.parseInt(st.nextToken()) - 1].add(new int[] {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int goal = Integer.parseInt(st.nextToken()) - 1;

        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                return arr1[1] - arr2[1];
            }
        });

        pq.add(new int[] {start, 0});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(cur[0] == goal) break;
            visited[cur[0]] = true;
            for(int[] next : cities[cur[0]]) {
                if(!visited[next[0]] && dist[next[0]] > dist[cur[0]] + next[1]) {
                    dist[next[0]] = dist[cur[0]] + next[1];
                    next[1] = dist[next[0]];
                    pq.offer(next);
                }
            }
        }

        System.out.println(dist[goal]);
    }
}