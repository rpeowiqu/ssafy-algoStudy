package sepFirst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ConnectingNetworks1922 {
	static int[] parent, rank;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int coms = Integer.parseInt(br.readLine());
		int lines = Integer.parseInt(br.readLine());
		int[][] edges = new int[lines][3];
		parent = new int[coms];
		rank = new int[coms];
		
		for(int i=0; i < lines; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[i][0] = start - 1;
			edges[i][1] = end - 1;
			edges[i][2] = weight;
		}
		
		for(int i=0; i < coms; i++) { // makeset
			parent[i] = i;
			rank[i] = 1;
		}
		
		Arrays.sort(edges, new Comparator<int[]>() { // 가중치로 정렬
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		int minSum = 0;
		int cnt = 0;
		for(int[] edge : edges) { // 크루스칼 공식 사용
			if(union(edge[0], edge[1])) {
				minSum += edge[2];
				if(++cnt == coms - 1) break;
			}
		}
		
		System.out.println(minSum);
	}
	
	static boolean union(int start, int end) {
		start = find(start);
		end = find(end);
		if(start == end) return false;
		
		if(rank[start] < rank[end]) {
			rank[end] += rank[start];
			parent[start] = end;
		} else {
			rank[start] += rank[end];
			parent[end] = start;
		}
		
		return true;
	}
	
	static int find(int node) {
		if(parent[node] == node) return node;
		return parent[node] = find(parent[node]);
	}
}
