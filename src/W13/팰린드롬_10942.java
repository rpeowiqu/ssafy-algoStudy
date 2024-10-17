package W13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ÆÓ¸°µå·Ò_10942 {
    static int N;
    static int[] seq;
    static int[][] dp;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        seq = new int[N];
        dp = new int[N][N];
        for(int i=0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
        }

        int questions = Integer.parseInt(br.readLine());
        for(int i=0; i < questions; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;
            sb.append(memo(left, right)).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int memo(int a, int b) {
        if(dp[a][b] != -1) return dp[a][b];
        if(a == b) return dp[a][b] = 1;
        if(a + 1 == b && seq[a] == seq[b]) return dp[a][b] = 1;
        if(seq[a] != seq[b]) return dp[a][b] = 0;
        else return dp[a][b] = memo(a + 1, b - 1);
    }
}