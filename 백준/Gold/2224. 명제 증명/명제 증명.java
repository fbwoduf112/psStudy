import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());

		int arr[][] = new int [52][52];
		int ans[][] = new int [52][52];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " => ");
			String str = st.nextToken() + st.nextToken();
			int num = str.charAt(0);
			int num2 = str.charAt(1);
			if(num < 91) num -= 65;
			else if(num > 96 && num < 123) num -= 71;
			
			if(num2 < 91) num2 -= 65;
			else if(num2 > 96 && num2 < 123) num2 -= 71;
			
			//System.out.println(num + " " + num2);
			arr[num][num2] = 1;
		}
		
		for(int i=0; i<arr.length; i++) { //중간
			for(int j=0; j<arr.length; j++) { //시작
				if(arr[j][i] == 0) continue;
				ans[j][i] = 1;
				for(int k=0; k<arr.length; k++) { //끝
					if(arr[i][k] == 1) {
						arr[j][k] = 1;
						ans[j][k] = 1;
					}
				}
			}
		}
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(ans[i][j] == 1) {
					if(i != j) {
						if(j < 26 && i < 26) {
							char sec = (char) (j + 65);
							char fir = (char) (i + 65);
							sb.append(fir + " => " + sec + "\n");
							cnt++;
						}
						else if(j > 25 && i < 26) {
							char sec = (char) (j + 71);
							char fir = (char) (i + 65);
							sb.append(fir + " => " + sec + "\n");
							cnt++;
						}
						else if(j > 25 && i > 25) {
							char sec = (char) (j + 71);
							char fir = (char) (i + 71);
							sb.append(fir + " => " + sec + "\n");
							cnt++;
						}
						else if(j < 26 && i >25) {
							char sec = (char) (j + 65);
							char fir = (char) (i + 71);
							sb.append(fir + " => " + sec + "\n");
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
		System.out.print(sb);
	}
}