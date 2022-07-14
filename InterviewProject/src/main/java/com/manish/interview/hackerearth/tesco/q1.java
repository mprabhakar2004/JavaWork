package com.manish.interview.hackerearth.tesco;

/**
 * @author Manishkumar
 * @since 03/25/2017.
 */
public class q1 {
	public static void main(String[] args) {
		int []ar={2,2,2};

		System.out.println(secondLargest(3,ar));
	}

	/**
	 * Return second largest element in array. Return -1 if there is none i.e. all element is same.
	 * @param input1
	 * @param input2
	 * @return
	 */

	public static int secondLargest(int input1, int []input2){
		int max = 0;
		for(int i=0;i<input1;i++){
			if(max <input2[i]){
				max = input2[i];
			}
		}
		int max2=-1;
		for(int i=0;i<input1;i++){
			if(input2[i]!= max && max2 <input2[i]){
				max2 = input2[i];
			}
		}
		return max2;
	}
}

