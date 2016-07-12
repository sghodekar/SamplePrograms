package com.santosh.java;

public class Shuffle {

	public static void main(String[] args) {
		Shuffle s = new Shuffle();
		
		s.shuffle(1, 3, 6, 4, 5, 7, 8);		

	}
	
	public void shuffle(int... i) {
		for (int j= 0; j < i.length; j++) {
			int rand = (int)(Math.random() * 100) % i.length;

			int temp = i[j];
			i[j] = i[rand];
			i[rand] = temp;
		}
		
		for(int k=0; k<i.length; k++) {
			System.out.println(i[k] +" ");
		}
	}

}
