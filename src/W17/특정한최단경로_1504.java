import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static class Edge implements Comparable<Edge> { // 클래스 생성
        int num, dis;

        Edge(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }

        @Override
        public int compareTo(Edge e) {
            return dis - e.dis;
        }
    }
    
    static int N, E;
    static boolean[] visited;
    static int[] distances;
    static PriorityQueue<Edge> pq;
    static ArrayList<Edge>[] adjList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N]; // 인접리스트
        distances = new int[N]; // 거리들
        visited = new boolean[N]; // 방문 체크
        for(int i=0; i < N; i++) {
            adjList[i] = new ArrayList<Edge>();
        }

        for(int i=0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            int dis = Integer.parseInt(st.nextToken());
            adjList[first].add(new Edge(second, dis)); // 두 정점 연결시키기
            adjList[second].add(new Edge(first, dis)); // 두 정점 연결시키기
        }

        st = new StringTokenizer(br.readLine());
        int path1 = Integer.parseInt(st.nextToken()) - 1; // 들러야 할 곳
        int path2 = Integer.parseInt(st.nextToken()) - 1; // 들러야 할 곳

        long temp1 = 0;
        long temp2 = 0;
        temp1 += dijkstra(0, path1); // path1을 먼저 들를 경우 거리 계산
        temp1 += dijkstra(path1, path2);
        temp1 += dijkstra(path2, N - 1);
        temp2 += dijkstra(0, path2); // path2를 먼저 들를 경우 거리 계산
        temp2 += dijkstra(path2, path1);
        temp2 += dijkstra(path1, N - 1);

        long ans = temp1 < temp2 ? temp1 : temp2; // 둘 중 짧은 것 체크
        if(ans >= Integer.MAX_VALUE) ans = -1; // 경로 없으면 -1
        System.out.println(ans);
    }

    static int dijkstra(int from, int to) {
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        pq = new PriorityQueue<Edge>();
        pq.offer(new Edge(from, 0));
        distances[from] = 0;
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(visited[cur.num]) continue;

            visited[cur.num] = true;
            for(int i=0; i < adjList[cur.num].size(); i++) {
                Edge next = adjList[cur.num].get(i);

                if(distances[next.num] > distances[cur.num]+next.dis){
                    distances[next.num] = distances[cur.num] + next.dis;
                    pq.offer(new Edge(next.num, distances[next.num]));
                }
            }
        }

        return distances[to];
    }
}
