import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int dp [] = new int [n+1];
		dp[0] = 0;
		
		for(int i=1; i<dp.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			//i + T = 현재 날짜 + 걸리는 시간, n+1마지막보다 작거나 같아야죠
			dp[i] = Math.max(dp[i], dp[i-1]);
			
			int nextDay = i+T-1;
			if(nextDay <= n) dp[nextDay] = Math.max(dp[nextDay], dp[i-1] + P);
		}
		int result = Integer.MIN_VALUE;
		for(int i=1; i<dp.length; i++) {
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}
}