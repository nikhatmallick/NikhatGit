package com.niki.ui.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MyRandom {

	public static void main(String[] args) {

		Random r = new Random();
		for(int i=1;i<=3;i++) {
			//System.out.println(r.nextInt(5));
		}
		
		
		  ArrayList<Integer> list = new ArrayList<Integer>();
	        for (int i=1; i<6; i++) {
	            list.add(new Integer(i));
	        }
	        Collections.shuffle(list);
	        for (int i=0; i<3; i++) {
	            System.out.println(list.get(i));
	        }
	}

}
