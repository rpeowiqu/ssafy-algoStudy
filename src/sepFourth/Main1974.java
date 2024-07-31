package sepFourth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main1974 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		int[][] sudoku = new int[9][9];
		root : for(int t=0; t < testCase; t++) {
			for(int i=0; i < 9; i++) {
				String[] row = br.readLine().split(" ");
				for(int j=0; j < 9; j++) {
					sudoku[i][j] = Integer.parseInt(row[j]);
				}
			}
			
			int[][] checkBox = new int[9][9];
			for(int i=0; i < 9; i++) {
				int[] checkC = new int[9];
				int[] checkR = new int[9];
				for(int j=0; j < 9; j++) {
					checkC[sudoku[i][j] - 1]++;
					checkR[sudoku[j][i] - 1]++;
					
					if(checkC[sudoku[i][j] - 1] == 2) {
						bw.write("#" + (t + 1) + " 0\n");
						continue root;
					}
					
					if(checkR[sudoku[j][i] - 1] == 2) {
						bw.write("#" + (t + 1) + " 0\n");
						continue root;
					}
					
					if(i < 3) {
						if(j < 3) {
							checkBox[0][sudoku[i][j] - 1]++;
							if(checkBox[0][sudoku[i][j] - 1] == 2) {
								bw.write("#" + (t + 1) + " 0\n");
								continue root;
							}
						} else if(j < 6) {
							checkBox[1][sudoku[i][j] - 1]++;
							if(checkBox[1][sudoku[i][j] - 1] == 2) {
								bw.write("#" + (t + 1) + " 0\n");
								continue root;
							}
						} else {
							checkBox[2][sudoku[i][j] - 1]++;
							if(checkBox[2][sudoku[i][j] - 1] == 2) {
								bw.write("#" + (t + 1) + " 0\n");
								continue root;
							}
						}
					} else if(i < 6) {
						if(j < 3) {
							checkBox[3][sudoku[i][j] - 1]++;
							if(checkBox[3][sudoku[i][j] - 1] == 2) {
								bw.write("#" + (t + 1) + " 0\n");
								continue root;
							}
						} else if(j < 6) {
							checkBox[4][sudoku[i][j] - 1]++;
							if(checkBox[4][sudoku[i][j] - 1] == 2) {
								bw.write("#" + (t + 1) + " 0\n");
								continue root;
							}
						} else {
							checkBox[5][sudoku[i][j] - 1]++;
							if(checkBox[5][sudoku[i][j] - 1] == 2) {
								bw.write("#" + (t + 1) + " 0\n");
								continue root;
							}
						}
					} else {
						if(j < 3) {
							checkBox[6][sudoku[i][j] - 1]++;
							if(checkBox[6][sudoku[i][j] - 1] == 2) {
								bw.write("#" + (t + 1) + " 0\n");
								continue root;
							}
						} else if(j < 6) {
							checkBox[7][sudoku[i][j] - 1]++;
							if(checkBox[7][sudoku[i][j] - 1] == 2) {
								bw.write("#" + (t + 1) + " 0\n");
								continue root;
							}
						} else {
							checkBox[8][sudoku[i][j] - 1]++;
							if(checkBox[8][sudoku[i][j] - 1] == 2) {
								bw.write("#" + (t + 1) + " 0\n");
								continue root;
							}
						}
					}
				}
			}
			bw.write("#" + (t + 1) + " 1\n");
		}
		
		bw.flush();
		bw.close();
	}
}
