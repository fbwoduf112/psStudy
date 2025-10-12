import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		int seq = Integer.parseInt(br.readLine());
		for(int k=0; k<seq; k++) {
			findMax();
		}
	}
	
	static void findMax() throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int [][] arr = new int[2][n];
		int [][] dp = new int [2][n];
		
		for(int i=0; i<2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = arr[0][0];
		dp[1][0] = arr[1][0];
		int max = Math.max(dp[0][0], dp[1][0]);
		if(n > 1) {
			dp[0][1] = dp[1][0] + arr[0][1];
			dp[1][1] = dp[0][0] + arr[1][1];
			max = Math.max(dp[0][1], dp[1][1]);
		}
		
		for(int i=2; i<n; i++) {
			for(int j=0; j<2; j++) {
				if(j == 0) {
					dp[j][i] = Math.max(dp[j+1][i-2], dp[j+1][i-1]) + arr[j][i];
					if(dp[j][i] > max) max = dp[j][i];
				}
				else if(j == 1) {
					dp[j][i] = Math.max(dp[j-1][i-2], dp[j-1][i-1]) + arr[j][i];
					if(dp[j][i] > max) max = dp[j][i];
				}
			}
		}
		System.out.println(max);
	}
}