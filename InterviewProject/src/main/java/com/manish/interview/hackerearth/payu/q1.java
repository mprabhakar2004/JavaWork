package com.manish.interview.hackerearth.payu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Manishkumar
 * @since 08/06/2017.
 */
public class q1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T= in.nextInt();
		for (int i=0;i<T;i++){
			int N = in.nextInt();
			List<Integer> list = new ArrayList<>();

			for (int j = 0; j < N; j++) {
				list.add(in.nextInt());
			}
			int t=N;
			boolean flag=false;
			while (true){
				while (list.remove(Integer.valueOf(t))){
					flag=true;
				}

				if (!flag || list.size()==0 ) break;
				t= list.size();
				flag = false;
			}
			if(list.size()>0)
				System.out.println("NO");
			else
				System.out.println("YES");
		}

	}
}
