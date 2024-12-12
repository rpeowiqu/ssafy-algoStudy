import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[N];

        int indegree[] = new int[N];
        for(int i=0; i < N; i++) graph[i] = new ArrayList<Integer>();

        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken()) - 1;
            int post = Integer.parseInt(st.nextToken()) - 1;
            graph[pre].add(post);
            indegree[post]++;
        }
        topologicalSort(graph, indegree, N);
        System.out.println(sb);
    }

    static void topologicalSort(ArrayList<Integer>[] graph, int[] indegree, int N){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i < N; i++) {
        	if(indegree[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            sb.append(now + 1).append(" ");

            for(int next : graph[now]){
                indegree[next]--;
                if(indegree[next]==0) queue.add(next);
            }
        }
    }
}
