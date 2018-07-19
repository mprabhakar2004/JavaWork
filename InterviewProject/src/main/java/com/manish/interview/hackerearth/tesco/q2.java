package com.manish.interview.hackerearth.tesco;

/**
 * @author Manishkumar
 * @since 03/25/2017.
 */
public class q2 {
	public static void main(String[] args) {
		String input1 = null;
		String input2 =null;
		System.out.println(contains(input1,input2));
	}

	/**
	 * Find out every character of string input2 contains in input1. Return yes if so otherwise return no.
	 * @param input1
	 * @param input2
	 * @return
	 */
	public static String contains(String input1, String input2){
		if((input1 == null && input2 ==null)){
			return "yes";
		}else if (input1 == null || input2 == null){
			return "no";
		}
		char []input1Arr = input1.toCharArray();
		char []input2Arr = input2.toCharArray();
		int []charMap = new int [256];
		for (char ch:input1Arr){
			charMap[ch] ++;
		}
		for (char ch:input2Arr){
			if(charMap[ch]>=1){
				charMap[ch]--;
			}else {
				return "no";
			}
		}
		return "yes";
	}
}
