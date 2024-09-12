package sepFirst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class TwoCoins16197 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char[][] desk = new char[row][col];
        boolean[][] visited1 = new boolean[row][col];
        boolean[][] visited2 = new boolean[row][col];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[] idx = new int[4];
        int num = 0;
        for(int i=0; i < row; i++) {
        	desk[i] = br.readLine().toCharArray();
        	for(int j=0; j < col; j++) {
        		if(desk[i][j] == 'o') {
        			idx[num++] = i;
        			idx[num++] = j;
        		}
        	}
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {idx[0], idx[1]});
        queue.offer(new int[] {idx[2], idx[3]});
        visited1[idx[0]][idx[1]] = true;
        visited2[idx[2]][idx[3]] = true;
        int time = 0;
        bfs: while(!queue.isEmpty()) {
        	time++;
        	if(time > 10) {
        		System.out.println(-1);
        		break;
        	}
        	int size = queue.size() / 2;
        	for(int i=0; i < size; i++) {
        		int[] first = queue.poll();
        		int[] second = queue.poll();
        		for(int j=0; j < 4; j++) {
        			int[] nfir = new int[2];
        			int[] nsec = new int[2];
        			nfir[0] = first[0] + dy[j];
        			nsec[0] = second[0] + dy[j];
        			nfir[1] = first[1] + dx[j];
        			nsec[1] = second[1] + dx[j];
        			if(check(nfir, row, col) && visited1[nfir[0]][nfir[1]] || check(nsec, row, col) && visited2[nsec[0]][nsec[1]]) continue;
        			if(!check(nfir, row, col) && !check(nsec, row, col)) continue;
        			if(check(nfir, row, col) ^ check(nsec, row, col)) {
        				System.out.println(time);
        				break bfs;
        			}
        			
        			if(check(nfir, row, col) && desk[nfir[0]][nfir[1]] == '#') {
        				nfir[0] -= dy[j];
        				nfir[1] -= dx[j];
        			}
        			
        			if(check(nsec, row, col) && desk[nsec[0]][nsec[1]] == '#') {
        				nsec[0] -= dy[j];
        				nsec[1] -= dx[j];
        			}
        			
        			if(Arrays.equals(nfir, nsec)) continue;
        			
        			queue.offer(nfir);
        			queue.offer(nsec);
        		}
        	}
        }
    }

    static boolean check(int[] idx, int row, int col) {
        return idx[0] >= 0 && idx[0] < row && idx[1] >= 0 && idx[1] < col;
    }
}