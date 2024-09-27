

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] result;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        result = new int[N+1][9+1];
        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j < 9+1; j++) {
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(generateAllpermu());
    }
    public static int generateAllpermu(){
        int[] nums = new int[]{2,3,4,5,6,7,8,9};

        int maxScore = Integer.MIN_VALUE;
        int score = 0;
        int startP = 1;
        do{
            startP = 1;
            score = 0;
            int[] entry = getEntry(nums);
            for (int i = 1; i < N+1; i++) {
               int[] inning =  inningResult(startP, i, entry);
               startP = inning[0];
               score += inning[1];
            }
            maxScore = Math.max(score, maxScore);
        }while (getNextPermutation(nums));
        return maxScore;
    }

    public static int[] getEntry(int[] nums){
        int[] entry = new int[10];

        int idx = 1;
        int numsIdx = 0;
        while(idx < 10){

            if(idx == 4){
                entry[idx] = 1;
                idx++;
                continue;
            }

            entry[idx++] = nums[numsIdx++];
        }

        return entry;
    }

    static public int[] inningResult(int startP, int inningN, int[] entry){

        // 0 -> startP, 1 -> score
        int[] inningResult = new int[2];


        int outCnt =  0;
        int score = 0;
        int[] base = new int[4];

        int nowPlayer = startP;
        while(outCnt < 3){
            if(nowPlayer >= 10){
                nowPlayer = 1;
            }
            switch (result[inningN][entry[nowPlayer++]]){

                case 0:
                    outCnt++;
                    break;
                case 1:
                    if(base[3] == 1){
                        score++;
                        base[3] = 0;
                    }
                    if(base[2] == 1){
                        base[3] = 1;
                        base[2] = 0;
                    }
                    if(base[1] == 1){
                        base[2] = 1;
                    }
                    base[1] = 1;
                    break;
                case 2:
                    if(base[3] == 1){
                        score++;
                        base[3] = 0;
                    }
                    if(base[2] == 1){
                        score++;
                        base[2] = 0;
                    }
                    if(base[1] == 1){
                        base[3] = 1;
                        base[1] = 0;
                    }
                    base[2] = 1;
                    break;
                case 3:
                    if(base[3] == 1){
                        score++;
                        base[3] = 0;
                    }
                    if(base[2] == 1){
                        score++;
                        base[2] = 0;
                    }
                    if(base[1] == 1){
                        score++;
                        base[1] = 0;
                    }
                    base[3] = 1;
                    break;
                case 4:
                    if(base[3] == 1){
                        score++;
                        base[3] = 0;
                    }
                    if(base[2] == 1){
                        score++;
                        base[2] = 0;
                    }
                    if(base[1] == 1){
                        score++;
                        base[1] = 0;
                    }
                    score++;
                    break;
                default:
                    System.out.println("뭔가잘못됨");
            }



        }

        if(nowPlayer >= 10){
            nowPlayer = 1;
        }


        inningResult[0] = nowPlayer;
        inningResult[1] = score;

        return inningResult;
    }

    public static boolean getNextPermutation(int[] nums){

        int i = nums.length -2;
        while (i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }

        if( i >= 0 ){
            int j = nums.length -1;

            while(j >= 0 && nums[j] <= nums[i]){
                j--;
            }

            swap(nums, i, j);
        }else {
            return false;
        }

        reverse(nums, i+1, nums.length-1);

        return true;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }


}
