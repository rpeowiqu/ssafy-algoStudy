package sepFirst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR9019_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int before = Integer.parseInt(st.nextToken());
			int after = Integer.parseInt(st.nextToken());
			
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(before);
			String road = "";
			int num = 0;
			bfs: while(!queue.isEmpty()) {
				int cur = queue.poll();
				if(cur == after) break;
				for(int i=0; i < 4; i++) {
					int changeNum = change(i, cur);
					queue.offer(changeNum);
					road += addString(i);
					if(changeNum == after) break bfs;
					num++;
				}
			}
			System.out.println(road);
			while(num > 3) {
				sb.append(road.charAt(num));
				num = num / 4 - 1;
			}
			sb.append(road.charAt(num));
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static String addString(int num) {
		switch(num) {
		case 0:
			return "D";
		case 1:
			return "S";
		case 2:
			return "L";
		case 3:
			return "R";
		default:
			return "";
		}
	}
	
	static int change(int order, int num) {
		switch(order) {
		case 0:
			return (num << 1) % 10000;
		case 1:
			return (num + 9999) % 10000;
		case 2:
			return ((((num % 1000) / 100) * 10 + (num % 100) / 10) * 10 + num % 10) * 10 + num / 1000;
		case 3:
			return (((num % 10) * 10 + (num / 1000)) * 10 + ((num % 1000) / 100)) * 10 + (num % 100) / 10;
		default:
			return 0;
		}
	}
}