import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		//1부터 시작하려고
		int [] dp = new int[n+1];
		//초기값 세팅
		dp[1] = 1;
		int min = 0;
		for(int i=2; i<=n; i++) {
			min = Integer.MAX_VALUE;
			for(int j=1; j*j<=i; j++) {
				int temp = i-j*j;
				min = Math.min(min, dp[temp]);
			}
			dp[i] = min+1;
		}
		System.out.println(dp[n]);
	}
}