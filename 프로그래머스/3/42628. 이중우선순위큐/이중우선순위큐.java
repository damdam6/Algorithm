import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> pqu = new PriorityQueue<>();
        PriorityQueue<Integer> maxPqu = new PriorityQueue<>(Collections.reverseOrder());
        for(String str: operations){
            String[] data = str.split(" ");
            char command = data[0].charAt(0);
            int num = Integer.parseInt(data[1]);
            
            switch(command){
                case 'I':{
                    pqu.add(num);
                    maxPqu.add(num);
                    break;
                }
                case 'D':{
                    if(num == -1){
                       if(pqu.isEmpty())break;;
                        int delNum = pqu.poll();
                        maxPqu.remove(delNum);
                    }
                    if(num == 1){
                         if(pqu.isEmpty())break;
                        int delNum = maxPqu.poll();
                        pqu.remove(delNum);
                    }
                    
                }
            }
        }
        
        if(pqu.isEmpty()){
           return new int[]{0,0};
        };
      if(pqu.size() == 1){
          return new int[]{pqu.peek(),pqu.peek()};
      };
        
        int min = pqu.poll();
       int max = maxPqu.poll();
        
    
        return new int[]{max, min};

            
        }
                       
       
    
}