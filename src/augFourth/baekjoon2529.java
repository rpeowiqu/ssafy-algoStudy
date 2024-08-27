package augFourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2529 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int[] nums = new int[10];
		
		String[] inequality = br.readLine().split(" ");
		String biggest = "";
		String smallest = "";
		int curNum = 9;
		for(int i=0; i < num; i++) {
//			if(biggest.length() == num + 1) break;
			if(inequality[i].equals(">")) {
				biggest += Integer.toString(curNum);
			} else {
				int idx = i;
				int check = 0;
				while(idx < num && inequality[idx].equals("<")) {
					check++;
					idx++;
				}
				
				curNum -= check;
				biggest += Integer.toString(curNum);
				for(int j=1; j < check; j++) {
					biggest += Integer.toString(curNum + j);
				}
				
				curNum--;
				i += check - 1;
			}
		}
		
		curNum = 0;
		for(int i=0; i < num; i++) {
//			if(smallest.length() == num + 1) break;
			if(inequality[i].equals("<")) {
				smallest += Integer.toString(curNum++);
			} else {
				int idx = i;
				int check = 0;
				while(idx < num && inequality[idx].equals(">")) {
					check++;
					idx++;
				}
				
				curNum += check;
				smallest += Integer.toString(curNum);
				for(int j=1; j < check; j++) {
					smallest += Integer.toString(curNum - j);
				}
				
				curNum++;
				i += check - 1;
			}
		}
		
		System.out.println(biggest);
		System.out.println(smallest);
	}
}
