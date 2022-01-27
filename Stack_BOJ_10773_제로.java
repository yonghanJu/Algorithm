// 2022-01-27
// https://www.acmicpc.net/problem/10773

import java.util.*;
 
public class Main {
    public static void main(String[] args) {
    	Stack<Integer> stack = new Stack<>();
    	Scanner sc =new Scanner(System.in);
    	int c = sc.nextInt();
    	
       	int in;
    	for(int i =0; i<c; i++) {
    		in =sc.nextInt();
    		if(in != 0) stack.add(in);
    		else stack.pop();
    	}
    
    	int count =0;
    	int a = stack.size();
    	for(int i=0; i<a; i++) {
        	count += stack.pop();
        }
    	
    	
    	System.out.println(count+"");
    }
}
