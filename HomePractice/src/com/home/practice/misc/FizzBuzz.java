package com.home.practice.misc;

import java.util.Arrays;


public class FizzBuzz {


//	public static void main(String[] args) {
//		assert Arrays.toString(fizz_buzz(1,1)).length() == 0;
//		assert Arrays.toString(fizz_buzz(1,3)).equals(new String[]{"1","3"}):"failed";
////		System.out.println(Arrays.toString(fizz_buzz(1,5)));
////		System.out.println(Arrays.toString(fizz_buzz(1,15)));
////		System.out.println(Arrays.toString(fizz_buzz(15,1)));
//	}
	
	public static String[] fizz_buzz(int start,int end) {
		if(start < 0 || end <=0)
			throw new ArithmeticException("Range must be postive numbers");
		
		if(start > end){
			start ^= end;
			end ^= start;
			start ^= end;					
		}
		String ar[]= new String[end-start];
		int k=0;
		for (int i=start;i<end;i++){
			if(i%3 == 0 && i%5== 0){
				ar[k] = "com.home.practice.misc.FizzBuzz";
			}else if(i%3 == 0){
				ar[k] = "Fizz";
			}else if(i%5 == 0){
				ar[k] = "Buzz";
			}else{
				ar[k] = ""+i;
			}
			k++;
		}
		return ar;
	}
	
	public static void bit_count(int n){
//		int ar[][] = new int [n][n];
//		for( int i =0 ; i<n ; i++){
//			for( int j=0;j<n ; j++)
//				ar[i][j] = i^j;
//		}
//		
//		for( int i =0 ; i<n ; i++){
//			for( int j=0;j<n ; j++)
//				System.out.print(ar[i][j] + "  ");
//			System.out.println("");
//		}
//		int max = 0;
//		for( int i =0 ; i<n ; i++){		
//			for( int j=0;j<n ; j++)
//				if (max <ar[i][j]){
//					max = ar[i][j];
//				}
//		}
//		int count =0 ;
//		for( int i =0 ; i<n ; i++){
//			for( int j=0;j<n ; j++){
//				if(max == ar[i][j]){
//					count ++;
//				}
//			}
//				
//		}
//		System.out.println("max : " + max + " Count : "+count);
		System.out.println(fizz_buzz(1,5));
		
	}
		
	
	
		

}
