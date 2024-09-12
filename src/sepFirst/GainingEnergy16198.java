package sepFirst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GainingEnergy16198 {
	static int max;
	static ArrayList<Integer> beads; // �߰��� �ִ� ���� �����ϱ� ���� arraylist ���
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		beads = new ArrayList<>();
		max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i < num; i++) {
			beads.add(Integer.parseInt(st.nextToken()));
		}
		
		select(num, 0);
		System.out.println(max);
	}
	
	static void select(int length, int sum) {
		if(length == 2) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=1; i < length - 1; i++) {
			int energy = beads.get(i - 1) * beads.get(i + 1); // ������ ���
			int temp = beads.remove(i); // ���� ����
			select(beads.size(), sum + energy); // dfs
			beads.add(i, temp); // ������ �߰�
		}
	}
}