//package DATE0831;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		arr = new int[1000000];
		for(int i=0;i<1000000;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(0,1000000-1);
		System.out.println(arr[500000]);
	}
	
	//이번엔 병합 정렬로 풀어보기
	
	//나눠서 진입하는 과정
	public static void mergeSort(int L, int R) {
		
		if(L >= R) return;
		
		int mid = (L+R)/2;
		mergeSort(L, mid);
		mergeSort(mid+1,R);
		merge(L, mid, R);
	}
	
	//두 덩어리를 합치는 과정
	public static void merge(int L, int mid, int R) {
		int[] tmpArr = new int[R-L+1];
		int idx = 0;
		
		int idxL = L;
		int idxR = mid+1;
		
		//[L ~ mid] [mid+1 ~ R] 두 개의 덩어리를 정렬하면서 합치는 과정
		//L과 mid+1을 비교하면서 정렬
		//두 개의 덩어리는 이미 각각 정렬되어 있음을 가정
		while(idxL<=mid && idxR<=R) {
			
			if(arr[idxL]<=arr[idxR]) {
				tmpArr[idx++] = arr[idxL++];
			}else {
				tmpArr[idx++] = arr[idxR++];
			}
		}
		
		if(idxL<=mid) {
			for(int i=idxL;i<=mid;i++) {
				tmpArr[idx++]=arr[idxL++];
			}
		}else {
			for(int i=idxR;i<=R;i++) {
				tmpArr[idx++]=arr[idxR++];
			}
		}
		
		for(int i=L;i<R+1;i++) {
			arr[i] = tmpArr[i-L];
		}
	}

}
