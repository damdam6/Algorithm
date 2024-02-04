import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long count = 0;
        long length = 1;
        long range = 9;

        while (k > length * range) {
            k -= length * range;
            count += range;
            length++;
            range *= 10;
        }

        count += (k - 1) / length; // 숫자들 중 k번째 위치를 포함하는 숫자를 찾습니다.

        if (count >= N) { // 범위를 초과하는 경우의 정확한 체크
            System.out.println(-1);
            return;
        }

        long num = count + 1; // 실제 숫자를 찾습니다.
        long minusPos = (k - 1) % length; // 숫자 내에서의 위치를 계산합니다.
        long tenD = num;

        // 숫자의 해당 자릿수를 찾기 위해, num을 반복적으로 나눕니다.
        for (long i = 0; i < length - minusPos - 1; i++) {
            tenD /= 10;
        }

        System.out.println(tenD % 10); // 수정된 부분: 최종적으로 찾은 숫자의 특정 자릿수를 출력
    }
}
