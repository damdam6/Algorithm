

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        Stack<Character> stk = new Stack<>();
        Stack<Integer> stkVal = new Stack<>(); // 숫자를 저장하는 스택입니다.
        
        String input = bf.readLine();
        
        boolean isBalanced = true; // 괄호의 균형을 체크합니다.
        int tempValue = 0; // 임시로 값을 계산하기 위한 변수입니다.

        for(char ch : input.toCharArray()) {
            switch(ch) {
                case '(':
                case '[':
                    stk.push(ch);
                    stkVal.push(tempValue); // 현재까지의 값을 스택에 넣습니다.
                    tempValue = 0; // 임시 값 초기화
                    break;
                case ')':
                    if(stk.isEmpty() || stk.pop() != '(') {
                        isBalanced = false;
                    } else {
                        tempValue = (tempValue == 0 ? 1 : tempValue) * 2;
                        tempValue += stkVal.pop(); // 이전 값과 더합니다.
                    }
                    break;
                case ']':
                    if(stk.isEmpty() || stk.pop() != '[') {
                        isBalanced = false;
                    } else {
                        tempValue = (tempValue == 0 ? 1 : tempValue) * 3;
                        tempValue += stkVal.pop(); // 이전 값과 더합니다.
                    }
                    break;
            }
            if(!isBalanced) break; // 균형이 깨졌다면 반복을 종료합니다.
        }

        if(!isBalanced || !stk.isEmpty()) { // 스택이 비어있지 않거나, 균형이 깨진 경우
            System.out.println(0);
        } else {
            System.out.println(tempValue);
        }
    }
}
