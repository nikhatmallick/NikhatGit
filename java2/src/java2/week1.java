package java2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 class MyCalculator {
	public int power(int n, int p) throws Exception {
		if(n <0 || p <0) {
			throw new Exception("n and p should be non negative");
		}
			
		return (int)((p==0)? 1: Math.pow(n, p));
	}
}

public class week1 {
	static String merged(String a, String b) {
		int aLen = a.length();
		int bLen = b.length();
		int cLen;
		if(aLen <bLen) cLen = aLen; else cLen = bLen;
		String fres="";
		for(int i=0;i < cLen;i++) {
		fres = fres +  a.substring(i, i+1) + b.substring(i, i+1);	
		}
		if(aLen<bLen) {
			fres = fres + b.substring(aLen);
		} else fres = fres + a.substring(bLen);
		return fres;
	}
	
	static int countDuplicate1(int[] numbers) {
		HashSet<int[]> hset = new HashSet<int[]>();
		Set<Integer> set = new HashSet<>();
			for(int i : numbers) {
				set.add(i);
			}
		System.out.println("size of set:" + set.size());
		
		return set.size();
	}
	
	static int myadd(float a, float b) {
	
		return (int)Math.floor(a+b);
	//	return 0;
		
	}

	static int countDuplicate(int[] numbers) {
		int dup=0;
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=0;i<numbers.length;i++) {
			for(int j=i+1;j<numbers.length;j++) {
				if(numbers[i] ==numbers[j]) {
					dup++;
					break;
				}
			}
		 
		}
		for(int i=0;i<numbers.length;i++) {
			
			if(numbers[i] == numbers[i+1]) {
				dup++;
				break;
			}
		}
		
		
		return dup;
	}
	public static void main(String []args) {
        // Write your code here.    
		
		int[] mynum = {1,1,2,2,2,3};
		int x = countDuplicate1(mynum);
		
		System.out.println("here: " + countDuplicate(mynum));
		System.out.println("add:" + myadd(2, 1));
     /*   Scanner sc = new Scanner(System.in);
        String s1,s2;
        while(sc.hasNextLine()) {
        	s1 = sc.next();
        	s2 = sc.next();
        	String fres = merged(s1, s2);
        	System.out.println( fres);
        }
        
       int n,p,res;
       while(sc.hasNextLine())
       {
             n = sc.nextInt();
            p = sc.nextInt();
       MyCalculator mc = new MyCalculator();
        try{
             res =   mc.power(n,p);
            System.out.println(res);
        }catch(Exception ex){
            System.out.println(ex);
        }        
       }*/
       
    }
}