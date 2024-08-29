package augFourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon14889 {
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		min = Integer.MAX_VALUE;
		int num = Integer.parseInt(br.readLine());
		int[][] spec = new int[num][num];
		boolean[] visited = new boolean[num];
		
		for(int i=0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j < num; j++) {
				spec[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeTeam(0, 0, 0, 0, spec, visited);
		System.out.println(min);
	}
	
	static void makeTeam(int depth, int idx, int team1, int team2, int[][] spec, boolean[] visited) {
		if(idx == visited.length / 2) {
			for(int i=0; i < visited.length; i++) {
				for(int j=0; j < visited.length; j++) {
					if(visited[i] && visited[j]) team1 += spec[i][j];
					if(!visited[i] && !visited[j]) team2 += spec[i][j];
				}
			}
			
			min = Math.min(min, Math.abs(team1 - team2));
			return;
		}
		
		for(int i=depth; i < visited.length; i++) {
			visited[i] = true;
			makeTeam(i + 1, idx + 1, team1, team2, spec, visited);
			visited[i] = false;
		}
	}
}
