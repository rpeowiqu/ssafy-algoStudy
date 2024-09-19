package sepThird;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class �����̴¹̷�Ż��16954 {
	// �޸� 1032708KB �ð� 2688 ms�ε� ���� ����Ѱ���..?
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        int[] dy = {0, 0, 0, -1, -1, -1, 1, 1, 1};
        int[] idx = {15, 0};
        char[][] chessBoard = new char[16][8]; // �� �����̴°� ����� ��
        String line = "........";
        for(int i=0; i < 8; i++) { // �� �������°� ����� ��ġ
            chessBoard[i] = line.toCharArray();
        }
        for(int i=8; i < 16; i++) { // ��
            chessBoard[i] = br.readLine().toCharArray();
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(idx);
        int arrival = 0;
        int time = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int j=0; j < size; j++) {
                int[] cur = queue.poll();
                if(cur[0] <= 8 && cur[1] == 7) { // ������ ���� �����ϸ� break
                    arrival = 1;
                    break;
                }
                for(int i=0; i < 9; i++) { // dx dy ����
                    int[] next = new int[2];
                    next[0] = cur[0] + dy[i];
                    next[1] = cur[1] + dx[i];
                    if(check(next, 16 - time) && chessBoard[next[0]][next[1]] == '.') { // ������ �� ���� �ø���
                        next[0]--;
                        if(chessBoard[next[0]][next[1]] == '.') queue.offer(next);
                    }
                }
            }
            time++;
        }

        System.out.println(arrival);
    }

    static boolean check(int[] idx, int time) {
        return idx[0] > 0 && idx[0] < time && idx[1] >= 0 && idx[1] < 8;
    }
}