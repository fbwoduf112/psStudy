import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
	static int arr[][];
	static int dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<N+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = arr[i][j] + dp[i][j-1];
			}
		}
//		
//		for(int i=1; i<N+1; i++) {
//			for(int j=1; j<N+1; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			System.out.println(dp(x1, y1, x2, y2));
		}
	}
	
	static int dp(int x1, int y1, int x2, int y2) {
		int sum = 0;
		for(int i=x1; i<=x2; i++) {
			sum += dp[i][y2];
		}
		
		for(int i=x1; i<=x2; i++) {
			sum -= dp[i][y1-1];
		}
		
		return sum;
	}
}

/**
 *	ex) 2행 2열, 3행 4열
 *	dp[2][4] + dp[3][4] - dp[2][1] - dp[3][1]
 
 * 	ex) 1행 1열, 3행 3열
 * 	dp[1][3] + dp[2][3] + dp[3][3] - dp[1][0] - dp[2][0] - dp[3][0]
 
 * 	ex) 1행 2열, 3행 3열
 * 	dp[1][3] + dp[2][3] + dp[3][3] - dp[1][1] - dp[2][1] - dp[3][1]
 * 	
 * 	ex) 2행 2열, 3행 3열
 * 	dp[2][3] + dp[3][3] - dp[2][1] - dp[3][1]
 * 	for(i=2행 i<=3행){sum += dp[i][뒤에x]}
 * 	- for(i=2행 ㅑ<=3행){sum -= dp[i][앞-1]}
 * 2행 2열
 * **/