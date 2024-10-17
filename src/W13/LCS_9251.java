package W13;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LCS_9251 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        int[][] len = new int[first.length() + 1][second.length() + 1];
        int num = 1;
        for(int i=1; i < first.length() + 1; i++) {
            for(int j=1; j < second.length() + 1; j++) {
                if(first.charAt(i - 1) == second.charAt(j - 1)) {
                    len[i][j] = len[i - 1][j - 1] + 1;
                } else {
                    len[i][j] = Math.max(len[i - 1][j], len[i][j - 1]);
                }
            }
        }

        System.out.println(len[first.length()][second.length()]);
    }
}