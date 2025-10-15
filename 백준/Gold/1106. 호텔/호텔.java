import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int dp [] = new int [c+100];
		Arrays.fill(dp, 5000000);
		dp[0] = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cost = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());
			
			for(int j=people; j<dp.length; j++) {
				dp[j] = Math.min(dp[j], dp[j-people] + cost);
			}
		}
		int result = Integer.MAX_VALUE;
		for(int i=c; i<dp.length; i++) {
			result = Math.min(result, dp[i]);
		}
		System.out.println(result);
	}
}