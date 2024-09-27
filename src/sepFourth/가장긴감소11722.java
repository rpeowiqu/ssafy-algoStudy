package sepFourth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴감소11722 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] sequence = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i < size; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int[] length = new int[size];
        int max = 0;
        for(int i=size - 1; i >= 0; i--) {
            for(int j=size - 1; j > i; j--) {
                if(sequence[i] > sequence[j]) {
                    length[i] = Math.max(length[i], length[j] + 1);
                    max = Math.max(max, length[i]);
                }
            }
        }

        System.out.println(max + 1);
    }
}