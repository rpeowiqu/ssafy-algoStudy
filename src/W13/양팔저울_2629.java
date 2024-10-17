package W13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¾çÆÈÀú¿ï_2629 {
	static int weightNum, checkNum;
    static int[] weights;
    static boolean[][] dp;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        weightNum = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        weights = new int[weightNum + 1];
        dp = new boolean[31][15001];
        for(int i=1; i < weightNum + 1; i++) weights[i] = Integer.parseInt(st.nextToken());

        check(0, 0);
        
        checkNum = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < checkNum; i++) {
            int bead = Integer.parseInt(st.nextToken());
            if(bead > 15000) sb.append("N").append(" ");
            else sb.append(dp[weightNum][bead] ? "Y " : "N ");
        }

        System.out.println(sb.toString());
    }

    static void check(int idx, int weight){
		if(dp[idx][weight])
			return;
		dp[idx][weight] = true;
		if(idx == weightNum)
			return;

		check(idx+1, weight);
		check(idx+1, weight + weights[idx + 1]);
		check(idx+1, Math.abs(weight - weights[idx + 1]));
	}
}