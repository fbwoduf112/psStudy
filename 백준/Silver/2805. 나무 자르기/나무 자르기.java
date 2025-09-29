import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int min = 0;
		int max = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		int [] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		while(min < max) {
			int mid = (min + max) / 2;
			
			long sum = 0;
			for(int tree : arr) {
				if(tree - mid > 0) sum += (tree-mid);
			}
			if(sum < M) max = mid;
			else min = mid + 1;
		}
		System.out.println(min-1);
	}
}
