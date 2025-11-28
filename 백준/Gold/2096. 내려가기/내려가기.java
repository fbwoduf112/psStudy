import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int arr[][], dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		dp = new int[N][3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<3; i++) {
			dp[0][i] = arr[0][i];
		}
		maxDp();
		int result = Integer.MIN_VALUE;
		for(int i=0; i<3; i++) {
			if(dp[N-1][i] > result) result = dp[N-1][i];
		}
		System.out.print(result + " ");
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<3; j++) {
				dp[i][j] = 0;
			}
		}
	
		minDp();
		int resultMin = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			if(dp[N-1][i] < resultMin) resultMin = dp[N-1][i];
		}
		System.out.print(resultMin);
	}
	public static void maxDp() {
		for(int i=1; i<N; i++) {
			for(int j=0; j<3; j++) {
				//j가 왼쪽 끝
				if(j == 0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j+1]) + arr[i][j];
				}
				//j가 오른쪽 끝
				else if(j == 2) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + arr[i][j];
				}
				//j가 중간
				else {
					dp[i][j] = Math.max(dp[i-1][j+1] ,Math.max(dp[i-1][j], dp[i-1][j-1])) + arr[i][j];
				}
				
			}
		}
	}
	public static void minDp() {
		for(int i=1; i<N; i++) {
			for(int j=0; j<3; j++) {
				//j가 왼쪽 끝
				if(j == 0) {
					dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + arr[i][j];
				}
				//j가 오른쪽 끝
				else if(j == 2) {
					dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + arr[i][j];
				}
				//j가 중간
				else {
					dp[i][j] = Math.min(dp[i-1][j+1] ,Math.min(dp[i-1][j], dp[i-1][j-1])) + arr[i][j];
				}
			}
		}
	}
}