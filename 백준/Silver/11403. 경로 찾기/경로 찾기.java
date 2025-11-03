import java.io.*;
import java.util.*;

public class Main {
	static int arr[][];
	static boolean check[];
	static int ans[][];
	static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int [N][N];
        check = new boolean[N];
        ans = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<N; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		if(arr[i][j] == 1) dfs(i, j);
        	}
        	Arrays.fill(check, false);
        }
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		System.out.print(ans[i][j] + " ");
        	}
        	System.out.println();
        }
    }
    static void dfs(int num, int path) {
    	check[path]=true;
    	ans[num][path] = 1;
    	for(int i=0; i<N; i++) {
    		if(!check[i] && arr[path][i] == 1) {
    			dfs(num, i);
    		}
    	}
    }
}