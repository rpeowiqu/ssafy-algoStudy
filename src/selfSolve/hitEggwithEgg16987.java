package selfSolve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hitEggwithEgg16987 {
	static int N, max, cnt;
	static boolean[] visited;
	static int[][] eggs;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		eggs = new int[N][2];
		visited = new boolean[N];
		max = 0;
		for(int i=0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			eggs[i][0] = Integer.parseInt(st.nextToken());
			eggs[i][1] = Integer.parseInt(st.nextToken());
		}
		
		destroy(0, 0);
		System.out.println(max);
	}
	
	static void destroy(int depth, int broken) {
		if(depth == N - 1) {
			max = Math.max(max, broken);
			return;
		}
		if(visited[depth]) destroy(depth + 1, broken);
		
		for(int i=0; i < N; i++) {
			int isbroken = 0;
			if(i != depth && !visited[i]) {
				eggs[depth][0] -= eggs[i][1];
				eggs[i][0] -= eggs[depth][1];
				if(eggs[depth][0] <= 0) {
					visited[depth] = true;
					isbroken++;
				}
				if(eggs[i][0] <= 0) {
					visited[i] = true;
					isbroken++;
				}
				destroy(depth + 1, broken + isbroken);
				if(visited[depth]) visited[depth] = false;
				if(visited[i]) visited[i] = false;
				eggs[depth][0] += eggs[i][1];
				eggs[i][0] += eggs[depth][1];
			}
		}
	}
}
