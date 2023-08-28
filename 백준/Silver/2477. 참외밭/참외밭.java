
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 육각형

		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		// 0번은 무시하기
		
		ArrayList<Integer> arrAll = new ArrayList<>();
		ArrayList<Integer> Arr1 = new ArrayList<>();
		ArrayList<Integer> Arr2 = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(bf.readLine());
			int direc = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());

			if(i%2==0) {
				Arr1.add(val);
			}else {
				Arr2.add(val);
			}
			
			arrAll.add(val);

		}

		//max값 구하기
		int max1 = 0;
		for(int a: Arr1)max1 = Math.max(max1, a);
		int max2 = 0;
		for(int a: Arr2)max2 = Math.max(max2, a);
		
		int idx =0;

		
		int min1=0;
		int min2=0;
		for(int i=0; i<6;i++) {
			
			
			//i가 짝수면 Arr1에 해당하는 값임
			if(i%2==0) {
				
				//Arr1의 max가 아닐 때
				if(arrAll.get(i) != max1) {
					//좌우가 max2가 아님을 확인해야됨
					if(arrAll.get((i+6-1)%6)!= max2 && arrAll.get((i+6+1)%6)!=max2){
						min1 = arrAll.get(i);
					}
				}
				
				
			}else {
				//Arr2의 max가 아닐 때
				if(arrAll.get(i) != max2) {
					//좌우가 max1가 아님을 확인해야됨
					if(arrAll.get((i+6-1)%6)!= max1 && arrAll.get((i+6+1)%6)!=max1){
						min2 = arrAll.get(i);
					}
				}
				
			}
			
		}
		


		sb.append(max1*max2*N-min1*min2*N);
		System.out.println(sb);

		

	}

}
