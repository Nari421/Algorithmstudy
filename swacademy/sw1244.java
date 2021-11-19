package swAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1244 {
	static int count, number[], max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			count = Integer.parseInt(st.nextToken());
			number = new int[s.length()];
			max = Integer.MIN_VALUE;
			for (int i = 0; i < s.length(); i++) {
				number[i] = Integer.parseInt(s.charAt(i) + "");
			}
			if(number.length<count)count = number.length;
			dfs(0, 0);
			System.out.println("#" + t + " " + max);
		}

	}

	private static void dfs(int index, int start) {
		if (index == count) {
			String s = "";
			for (int i = 0; i < number.length; i++) {
				s += Integer.toString(number[i]);
			}
			int result = Integer.parseInt(s);
			max = max > result ? max : result;
			return;
		}
		for (int i = start; i < number.length-1; i++) {
			for (int j = i + 1; j < number.length; j++) {
					int tmp = number[i];
					number[i]=number[j];
					number[j] = tmp;
					dfs(index+1,i);
					tmp = number[i];
					number[i]=number[j];
					number[j] = tmp;
			}
		}
	}

}
