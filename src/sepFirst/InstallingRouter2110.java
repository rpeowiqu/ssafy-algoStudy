package sepFirst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InstallingRouter2110 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int routers = Integer.parseInt(st.nextToken());
		
		long[] houses = new long[num];
		for(int i=0; i < num; i++) {
			houses[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(houses);
		long left = 1;
		long right = houses[num - 1] + 1;
		while(left < right) {
			long mid = (left + right) / 2;
			int idx = 0;
			int curRouters = 1;
			for(int i=0; i < num; i++) {
				if(houses[i] - houses[idx] >= mid) {
					curRouters++;
					idx = i;
				}
			}
			
			if(curRouters < routers) right = mid;
			else left = mid + 1;
		}
		
		System.out.println(left - 1);
	}
}
