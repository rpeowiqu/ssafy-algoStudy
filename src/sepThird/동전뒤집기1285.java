package sepThird;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 동전뒤집기1285 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] table = new int[N][N];
        for(int i=0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            for(int j=0; j < N; j++) {
                if(temp[j] == 'T') table[i][j] = 1;
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0; i < 1 << N; i++) {
            int sum = 0;
            for(int j=0; j < N; j++) {
                int back = 0;
                for(int k=0; k < N; k++) {
                    int cur = table[k][j];
                    if((i & (1 << k)) != 0) {
                        cur = (cur + 1) % 2;
                    }

                    if(cur == 1) back++;
                }

                sum += Math.min(back, N - back);
            }

            ans = Math.min(ans, sum);
        }

        System.out.println(ans);
    }
}