import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
	static int C;
	static long A;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		C = Integer.parseInt(st.nextToken());
		System.out.println(pow(B));
	}
	
	static long pow(long exponent) {
		//탈출
		if(exponent == 1) {
			return A % C;
		}
		//재귀
		long temp = pow(exponent/2);
		
		//정답
		if(exponent % 2 == 1) {
			return (temp * temp % C) * A % C;
		}
		return temp * temp % C;
	}
}