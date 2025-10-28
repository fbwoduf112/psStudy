import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int answer = 0;
        for(int i=0; i<M; i++) {
            // I를 찾았으면, 패턴 체크
            if(str.charAt(i) == 'I') {
                // 문자열 탐색을 위한 변수 선언
                int tmp = i;
                // 패턴 파악을 위한 변수 선언
                int cnt = 0;
                
                // 인덱스를 벗어나지 않을 때까지 탐색
                while(tmp+2 < M) {
                    // IOI 패턴인지 체크
                    if(str.charAt(tmp+1) == 'O' && str.charAt(tmp+2) == 'I') {
                        // 맞으면 cnt+1 패턴을 파악한 셈
                        cnt++;
                        // 다음 오른쪽으로 이동
                        tmp += 2;
                        
                        // Pn 패턴이 맞으면 정답에 추가
                        // 겹쳐진 패턴 탐색을 위해 다시 - 1
                        if(cnt == N) {
                            cnt--;
                            answer++;
                        }
                    }
                    else {
                        break;
                    }
                }
                // 마지막 탐색 인덱스로 이동
                i = tmp;
            }
        }
        System.out.println(answer);
    }
}