package W12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class 링크와스타트_15661 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] synergy = new int[N][N];
        for(int i=0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++) {
                synergy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=1; i < (1 << N) - 1; i++) {
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();
            int leftSynergy = 0;
            int rightSynergy = 0;
            for(int j=0; j < N; j++) {
                if((i & (1 << j)) != 0) left.add(j);
                else right.add(j);
            }

            for(int j=0; j < left.size(); j++) {
                for(int k=0; k < left.size(); k++) {
                    if(j != k) leftSynergy += synergy[left.get(j)][left.get(k)];
                }
            }

            for(int j=0; j < right.size(); j++) {
                for(int k=0; k < right.size(); k++) {
                    if(j != k) rightSynergy += synergy[right.get(j)][right.get(k)];
                }
            }

            min = Math.min(min, Math.abs(leftSynergy - rightSynergy));
        }

        System.out.println(min);
    }
}