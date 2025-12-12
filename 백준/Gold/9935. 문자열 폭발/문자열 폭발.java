import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String bomb = br.readLine();
		
		int str_len = str.length();
		int bomb_len = bomb.length();
		
		Stack <Character> st = new Stack<>();
		for(int i=0; i<str_len; i++) {
			int cnt = 0;
			st.add(str.charAt(i));
			
			if(st.size() >= bomb_len) {
				
				//처음부터 검사 x
				for(int j=0; j<bomb_len; j++) {
					//조건문 수정
					if(st.get(st.size()- bomb_len + j) == bomb.charAt(j)) {
						cnt++;
					}
				}
				if(cnt == bomb_len) {
					for(int k=0; k<bomb_len; k++) st.pop();
				}
			}
		}
		if(st.isEmpty()) System.out.println("FRULA");
		else {
			for(int i=0; i<st.size(); i++) {
				sb.append(st.get(i));
			}
		}
		System.out.println(sb);
	}
}