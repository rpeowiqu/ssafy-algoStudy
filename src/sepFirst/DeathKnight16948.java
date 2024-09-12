package sepFirst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DeathKnight16948 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		int[] idx = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i < 4; i++) {
			idx[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] visited = new boolean[size][size];
		int[][] field = new int[size][size];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {idx[0], idx[1]});
		visited[idx[0]][idx[1]] = true;
		while(!queue.isEmpty()) { // bfs
			int[] cur = queue.poll();
			int[] dx = {-1, 1, -2, 2, -1, 1};
			int[] dy = {-2, -2, 0, 0, 2, 2};
			for(int i=0; i < 6; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				if(ny >= 0 && ny < size && nx >= 0 && nx < size && !visited[ny][nx]) { // 맵 안에서 돌리기
					field[ny][nx] = field[cur[0]][cur[1]] + 1;
					visited[ny][nx] = true;
					queue.offer(new int[] {ny, nx});
				}
			}
		}
		
		if(field[idx[2]][idx[3]] == 0) field[idx[2]][idx[3]]--; // 못 가면 -1 출력
		System.out.println(field[idx[2]][idx[3]]); // 답 출력
	}
}
