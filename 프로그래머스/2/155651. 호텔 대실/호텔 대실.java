import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
       
        
        Comparator<Customer> comp = new Comparator<Customer>(){
            @Override
            public int compare(Customer c1, Customer c2){
                if(c1.in < c2.in)return -1;
                if(c1.in > c2.in)return 1;  
                if(c1.out < c2.out)return -1;
                if(c1.out > c2.out)return 1;
                return 0;
            }
        };
        
         PriorityQueue<Customer> pqu = new PriorityQueue<>(comp);
        
        // 숫자로 변환
        for(String[] inOutTime: book_time){
            String[] time = inOutTime[0].split(":");
            int in = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            time = inOutTime[1].split(":");
            int out = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]) + 10;
            pqu.add(new Customer(in, out));
        }
        
        PriorityQueue<Integer> room = new PriorityQueue<>();
        int maxSize = 0;
        while(!pqu.isEmpty()){
            
            Customer tmp = pqu.poll();
            
            if(!room.isEmpty() && room.peek() <= tmp.in){
                room.poll();
            }
            room.add(tmp.out);
            maxSize = Math.max(maxSize, room.size());
        }
        
        return maxSize;
    }
    
    class Customer{
        int in;
        int out;
        Customer(int in, int out){
            this.in = in;
            this.out = out;
        }
    }
}