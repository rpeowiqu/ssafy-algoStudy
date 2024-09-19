package sepThird;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 움직이는미로탈출16954 {
	// 메모리 1032708KB 시간 2688 ms인데 어케 통과한거죠..?
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        int[] dy = {0, 0, 0, -1, -1, -1, 1, 1, 1};
        int[] idx = {15, 0};
        char[][] chessBoard = new char[16][8]; // 벽 움직이는거 고려한 맵
        String line = "........";
        for(int i=0; i < 8; i++) { // 벽 내려가는거 고려한 위치
            chessBoard[i] = line.toCharArray();
        }
        for(int i=8; i < 16; i++) { // 맵
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
                if(cur[0] <= 8 && cur[1] == 7) { // 오른쪽 위에 도달하면 break
                    arrival = 1;
                    break;
                }
                for(int i=0; i < 9; i++) { // dx dy 범위
                    int[] next = new int[2];
                    next[0] = cur[0] + dy[i];
                    next[1] = cur[1] + dx[i];
                    if(check(next, 16 - time) && chessBoard[next[0]][next[1]] == '.') { // 움직인 후 위로 올리기
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