import java.io.*;


public class Main {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		s =s+"  ";
		
		char[] char_l = s.toCharArray();
		int count = 0;
		
		for(int i = 0; i <(char_l.length-2);i++) {
			
			if( char_l[i] == 'c') {
				if((char_l[i+1] =='=')||(char_l[i+1] =='-') ){
					continue;
				}
				else {
					count +=1;
				}
				
			}
			else if(char_l[i] == 'd') {
				if(char_l[i+1] == '-') {
					continue;
				}
				else if((char_l[i+1]=='z')&&(char_l[i+2]=='=')){
					continue;
				}
				else {
					count+=1;
				}
				
			}
			else if(char_l[i] == 'l') {

				if(char_l[i+1] == 'j'){
					continue;
				}
				else {
					count +=1;
				}
			}
			else if(char_l[i] =='n') {
				if(char_l[i+1] == 'j'){
					continue;
				}
				else {
					count +=1;
				}
			}
			else if(char_l[i] =='s') {
				if(char_l[i+1] == '='){
					continue;
				}
				else {
					count +=1;
				}
			}
			else if(char_l[i] =='z') {
				
				if(char_l[i+1]=='=') {
					continue;
				}
				else {
					count+=1;
				}
				
			}
			else {
				count+=1;
				
			}
			
		}
		
		System.out.println(count);
		
	}

}