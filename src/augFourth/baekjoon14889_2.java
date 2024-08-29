package augFourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon14889_2 {
	static int min;
	static int[][] spec;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		min = Integer.MAX_VALUE;
		int num = Integer.parseInt(br.readLine());
		spec = new int[num][num];
		visited = new boolean[num];
		int n = visited.length / 2;
		
		for(int i=0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j < num; j++) {
				spec[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeTeam(0, 0, n);
		System.out.println(min);
	}
	
	static void makeTeam(int idx, int depth, int n) {
		if(idx == n) {
			int team1 = 0;
			int team2 = 0;
			for(int i=0; i < visited.length; i++) {
				for(int j=0; j < visited.length; j++) {
					if(visited[i]) {
						if(visited[j]) team1 += spec[i][j];
					} else {
						if(!visited[j]) team2 += spec[i][j];
					}
				}
			}
			
			min = Math.min(min, Math.abs(team1 - team2));
			return;
		}
		
		for(int i=depth; i < 2 * n; i++) {
			visited[i] = true;
			makeTeam(idx + 1, i + 1, n);
			visited[i] = false;
		}
	}
}
