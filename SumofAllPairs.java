package practiceproblems;

import java.util.ArrayList;
import java.util.List;

public class SumofAllPairs {

	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		getSum(input);
	}

	private static void getSum(int[] input){
		int sum;
		for(int i=0; i<input.length; i++){
			for(int j=(i+1); j<input.length; j++){
				sum=input[i]+input[j];
				System.out.println(input[i] + " + " + input[j] + " = " + sum);
			}
		}
	}

}
