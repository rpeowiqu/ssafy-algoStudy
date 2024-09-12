package sepFirst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SnakeandLadderGame16928 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ladder = Integer.parseInt(st.nextToken());
		int snake = Integer.parseInt(st.nextToken());
		int[] map = new int[101];
		for(int i=0; i < 101; i++) map[i] = i;
		for(int i=0; i < ladder + snake; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from] = to;
		}
		
		int[] road = new int[101]; // 방문수 저장할 배열
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		road[1] = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int i=1; i < 7; i++) { // 주사위 돌리기
				int next = cur + i;
				if(next > 100) continue; // 범위 안에서만 돌리기
				
				if(road[map[next]] == 0) { // 아직 방문 안 했으면
					queue.offer(map[next]); // 방문 예정
					road[map[next]] = road[cur] + 1; // 이동
				}
				
				if(map[next] == 100) break; // road[100] 갱신되면 break
			}
		}
		
		System.out.println(road[100]);
	}
}
