package selfSolve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class makePassword1759 {
	static char[] selected, alphabets;
	static int L, C;
	static StringBuilder sb;
	static boolean[] visited;
	static char[] moeum = {'a', 'i', 'e', 'o', 'u'};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alphabets = new char[C];
		selected = new char[L];
		visited = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i < C; i++) {
			alphabets[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alphabets);
		
		make(0, 0);
		System.out.println(sb.toString());
	}
	
	static void make(int depth, int idx) {
		if(depth == L) {
			String cur = "";
			for(int i=0; i < L; i++) {
				cur += selected[i];
			}
			int mo = 0;
			int ja = 0;
			for(int i=0; i < L; i++) {
				int isja = 0;
				for(int j=0; j < 5; j++) {
					if(selected[i] == moeum[j]) {
						isja++;
						mo++;
					}
				}
				if(isja == 0) ja++;
			}
			if(mo > 0 && ja > 1) sb.append(cur).append("\n");
			return;
		}
		
		if(idx == C) return;
		
		selected[depth] = alphabets[idx];
		make(depth + 1, idx + 1);
		make(depth, idx + 1);
	}
}
