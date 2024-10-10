package W12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

class ºù»ê_2573 {
    static int[][] sea;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M, cnt;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sea = new int[N][M];
        for(int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 0;
        int time = 0;
        while(cnt < 2) {
            cnt = 0;
            time++;
            visited = new boolean[N][M];
            int[][] temp = new int[N][M];
            for(int i=0; i < N; i++) {
                for(int j=0; j < M; j++) {
                    if(sea[i][j] != 0) {
                        int count = 0;
                        for(int k=0; k < 4; k++) {
                            int[] next = new int[2];
                            next[0] = i + dy[k];
                            next[1] = j + dx[k];
                            if(sea[next[0]][next[1]] == 0) count++;
                        }
                        temp[i][j] = Math.max(0, sea[i][j] - count);
                    }
                }
            }
            sea = temp;
            for(int i=0; i < N; i++) {
                for(int j=0; j < M; j++) {
                    if(!visited[i][j] && sea[i][j] > 0) bfs(new int[] {i, j});
                }
            }

            if(cnt == 0) {
                System.out.println(0);
                return;
            } else if(cnt > 1) {
                System.out.println(time);
                return;
            }
        }
    }

    static boolean check(int[] arr) {
        return arr[0] >= 0 && arr[0] < N && arr[1] >= 0 && arr[1] < M;
    }

    static void bfs(int[] arr) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(arr);
        visited[arr[0]][arr[1]] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i=0; i < 4; i++) {
                int[] next = new int[2];
                next[0] = cur[0] + dy[i];
                next[1] = cur[1] + dx[i];
                if(check(next) && !visited[next[0]][next[1]] && sea[next[0]][next[1]] > 0) {
                    visited[next[0]][next[1]] = true;
                    queue.offer(next);
                }
            }
        }
        cnt++;
    }
}