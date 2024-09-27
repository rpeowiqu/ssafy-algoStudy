package sepFourth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class 줄세우기2252 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        int[] students = new int[num];
        int[] indegrees = new int[num];
        ArrayList<Integer>[] connects = new ArrayList[num];
        for(int i=0; i < num; i++) {
            connects[i] = new ArrayList<>();
        }
        
        for(int i=0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int smaller = Integer.parseInt(st.nextToken()) - 1;
            int bigger = Integer.parseInt(st.nextToken()) - 1;
            connects[smaller].add(bigger);
            students[bigger]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i < num; i++) {
            if(students[i] == 0) {
                sb.append(i + 1).append(" ");
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int i=0; i < connects[cur].size(); i++) {
                int next = connects[cur].get(i);
                students[next]--;
                if(students[next] == 0) {
                    sb.append(next + 1).append(" ");
                    queue.offer(next);
                }
            }
        }

        System.out.println(sb.toString());
    }
}