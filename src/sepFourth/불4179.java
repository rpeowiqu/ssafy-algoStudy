package sepFourth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class บา4179 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int[][] field = new int[height][width];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[] jihun = new int[3];
        ArrayList<int[]> fire = new ArrayList<>();
        for(int i=0; i < height; i++) {
            String line = br.readLine();
            for(int j=0; j < width; j++) {
                if(line.charAt(j) == 'J') {
                    jihun[0] = i;
                    jihun[1] = j;
                    jihun[2] = 1;
                }
                if(line.charAt(j) == 'F') {
                    fire.add(new int[] {i, j, -1});
                    field[i][j] = -2;
                }
                if(line.charAt(j) == '#') field[i][j] = -1;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i < fire.size(); i++) {
            queue.offer(fire.get(i));
        }
        queue.offer(jihun);
        int time = 0;
        boolean escaped = false;
        bfs: while(!queue.isEmpty()) {
            time++;
            int size = queue.size();
            for(int i=0; i < size; i++) {
                int[] cur = queue.poll();
                if(cur[2] > 0 && canEscape(cur, height, width)) {
                    escaped = true;
                    break bfs;
                }

                for(int j=0; j < 4; j++) {
                    int[] next = new int[3];
                    next[0] = cur[0] + dy[j];
                    next[1] = cur[1] + dx[j];
                    next[2] = cur[2];
                    if(check(next, height, width) && field[next[0]][next[1]] >= 0) {
                        if(next[2] < 0) {
                            field[next[0]][next[1]] = -2;
                            queue.offer(next);
                        }

                        if(next[2] > 0 && field[next[0]][next[1]] == 0) {
                            field[next[0]][next[1]] = time;
                            queue.offer(next);
                        }
                    }
                }
            }
        }

        if(escaped) System.out.println(time);
        else System.out.println("IMPOSSIBLE");
    }

    static boolean check(int[] arr, int height, int width) {
        return arr[0] >= 0 && arr[0] < height && arr[1] >= 0 && arr[1] < width;
    }

    static boolean canEscape(int[] arr, int height, int width) {
        return arr[0] == 0 || arr[0] == height - 1 || arr[1] == 0 || arr[1] == width - 1;
    }
}