package sepThird;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 전구와스위치2138 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String start = br.readLine();
        String goal = br.readLine();
        int[] useFirst = new int[N];
        int[] notUseFirst = new int[N];
        int[] target = new int[N];
        for(int i=0; i < N; i++) {
            useFirst[i] = start.charAt(i) - '0';
            notUseFirst[i] = start.charAt(i) - '0';
            target[i] = goal.charAt(i) - '0';
        }

        useFirst[0] = 1 - useFirst[0];
        useFirst[1] = 1 - useFirst[1];
        int first = 1;
        int second = 0;

        for(int i=0; i < N - 1; i++) {
            if(useFirst[i] != target[i]) {
                useFirst[i] = 1 - useFirst[i];
                useFirst[i + 1] = 1 - useFirst[i + 1];
                if(i < N - 2) useFirst[i + 2] = 1 - useFirst[i + 2];
                first++;
            }

            if(notUseFirst[i] != target[i]) {
                notUseFirst[i] = 1 - notUseFirst[i];
                notUseFirst[i + 1] = 1 - notUseFirst[i + 1];
                if(i < N - 2) notUseFirst[i + 2] = 1 - notUseFirst[i + 2];
                second++;
            }
        }

        if(target[N - 1] != useFirst[N - 1]) first = N + 1;
        if(target[N - 1] != notUseFirst[N - 1]) second = N + 1;

        int ans = Math.min(first, second);
        if(ans == N + 1) ans = -1;
        System.out.println(ans);
    }
}