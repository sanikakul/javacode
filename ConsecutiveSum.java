package practiceproblems;

import java.util.ArrayList;
import java.util.List;

public class ConsecutiveSum {

	public static void main(String[] args){
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		List<Integer> values = new ArrayList<>();
		getSum(input, values);
	}

	private static void getSum(int[] input, List<Integer> values) {
		int sum=0;
		for(int i=1; i<=input.length; i++){
			for(int j=0; j<(input.length-i+1); j++){
				for(int k=j; k<i+j; k++){
					sum=sum+input[k];
					values.add(input[k]);
				}
				System.out.println(values + " - Sum: " +sum);
				values.removeAll(values);
				sum=0;
			}
		}
	}

}
