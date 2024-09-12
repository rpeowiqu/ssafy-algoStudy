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
		
		int[] road = new int[101]; // �湮�� ������ �迭
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		road[1] = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int i=1; i < 7; i++) { // �ֻ��� ������
				int next = cur + i;
				if(next > 100) continue; // ���� �ȿ����� ������
				
				if(road[map[next]] == 0) { // ���� �湮 �� ������
					queue.offer(map[next]); // �湮 ����
					road[map[next]] = road[cur] + 1; // �̵�
				}
				
				if(map[next] == 100) break; // road[100] ���ŵǸ� break
			}
		}
		
		System.out.println(road[100]);
	}
}
