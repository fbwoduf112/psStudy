import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	static int [][] dp = new int[30][30];	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			sb.append(comb(e, w)).append("\n");
			
		
			}
		System.out.println(sb);
		}
		static int comb(int w, int e) {
			if(dp[w][e] > 0) return dp[w][e];
			if(w == e || e == 0) return dp[w][e] = 1;
			return dp[w][e] = comb(w-1, e-1) + comb(w-1, e);
		}
		
}