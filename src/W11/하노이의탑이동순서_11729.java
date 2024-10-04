package W11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 하노이의탑이동순서_11729 {
	static StringBuilder sb;
    static int move;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        move = 0;

        int num = Integer.parseInt(br.readLine());
        sb.append((int)Math.pow(2, num) - 1).append("\n");
        hanoi(num, 1, 2, 3);
        System.out.println(sb.toString());
    }

    static void hanoi(int num, int start, int to, int end) {
        if(num == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        hanoi(num - 1, start, end, to);
        sb.append(start).append(" ").append(end).append("\n");
        hanoi(num - 1, to, start, end);
    }
}