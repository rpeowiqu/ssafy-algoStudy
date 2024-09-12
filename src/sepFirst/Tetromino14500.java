package sepFirst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tetromino14500 {
	static int max;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int[][] field = new int[row][col];
		visited = new boolean[row][col];
		max = Integer.MIN_VALUE;
		
		for(int i=0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j < col; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < row; i++) { // 모든 지점에서 테트로미노 확인
			for(int j=0; j < col; j++) {
				tetromino(0, 0, field, i, j);
				tshape(field, i, j);
			}
		}
		System.out.println(max);
	}
	
	static void tetromino(int depth, int sum, int[][] arr, int y, int x) { // 테트로미노 모양 백트래킹
		if(depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		if((x < 0 || x >= arr[0].length) || (y < 0 || y >= arr.length)) return;

		if(!visited[y][x]) {
			visited[y][x] = true;
			tetromino(depth + 1, sum + arr[y][x], arr, y - 1, x);
			tetromino(depth + 1, sum + arr[y][x], arr, y + 1, x);
			tetromino(depth + 1, sum + arr[y][x], arr, y, x - 1);
			tetromino(depth + 1, sum + arr[y][x], arr, y, x + 1);
			visited[y][x] = false;
		}
	}
	
	static void tshape(int[][] arr, int y, int x) { // ㅗ모양 계산
		if((x < 0 || x >= arr[0].length) || (y < 0 || y >= arr.length)) return;
		
		if(y == 0) {
			if(x == 0) return;
			else if(x == arr[0].length - 1) return;
			else max = Math.max(max, arr[y][x] + arr[y + 1][x] + arr[y][x - 1] + arr[y][x + 1]);
		} else if(y == arr.length - 1) {
			if(x == 0) return;
			else if(x == arr[0].length - 1) return;
			else max = Math.max(max, arr[y][x] + arr[y - 1][x] + arr[y][x - 1] + arr[y][x + 1]);
		} else {
			if(x == 0) max = Math.max(max, arr[y][x] + arr[y][x + 1] + arr[y + 1][x] + arr[y - 1][x]);
			else if(x == arr[0].length - 1) max = Math.max(max, arr[y][x] + arr[y][x - 1] + arr[y + 1][x] + arr[y - 1][x]);
			else max = Math.max(max, Math.max(Math.max(arr[y][x] + arr[y - 1][x] + arr[y][x - 1] + arr[y][x + 1], arr[y][x] + arr[y + 1][x] + arr[y][x - 1] + arr[y][x + 1]), Math.max(arr[y][x] + arr[y][x - 1] + arr[y + 1][x] + arr[y - 1][x], arr[y][x] + arr[y][x + 1] + arr[y + 1][x] + arr[y - 1][x])));
		}
	}
}
