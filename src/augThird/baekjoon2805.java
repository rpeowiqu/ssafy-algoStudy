package augThird;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class baekjoon2805 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int treeNum = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] trees = new int[treeNum];
        st = new StringTokenizer(br.readLine());
        int left = 0;
        int right = 0;
        for(int i=0; i < treeNum; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, trees[i]);
        }

        while(left < right) {
            int mid = (left + right) / 2;
            long len = 0;
            for(int i=0; i < treeNum; i++) {
                if(trees[i] >= mid) len += trees[i] - mid;
            }

            if(len >= target) left = mid + 1;
            else right = mid;
        }

        System.out.println(left - 1);
    }
}
