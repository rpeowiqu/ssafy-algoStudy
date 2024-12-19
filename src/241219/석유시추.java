import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    static int row, col;
    static int[] oils;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    
    public int solution(int[][] land) {
        int answer = 0;
        row = land.length;
        col = land[0].length;
        oils = new int[col];
        visited = new boolean[row][col];
        
        for(int i=0; i < col; i++) {
            for(int j=0; j < row; j++) {
                if(land[j][i] == 1 && !visited[j][i]) {
                    bfs(j, i, land);
                }
            }
        }
        
        for(int i=0; i < col; i++) {
            if(answer < oils[i]) answer = oils[i];
        }
        return answer;
    }
    
    static void bfs(int y, int x, int[][] land) {
        Queue<int[]> queue = new LinkedList<>();
        int size = 1;
        int[] idxs = new int[col];
        queue.offer(new int[] {y, x});
        idxs[x]++;
        visited[y][x] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i=0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(check(ny, nx) && land[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.offer(new int[] {ny, nx});
                    size++;
                    if(idxs[nx] == 0) idxs[nx]++;
                }
            }
        }
        
        for(int i=0; i < col; i++) {
            if(idxs[i] > 0) oils[i] += size;
        }
    }
    
    static boolean check(int y, int x) {
        return y >= 0 && y < row && x >= 0 && x < col;
    }
}
