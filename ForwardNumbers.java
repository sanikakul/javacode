package chapterone;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ForwardNumbers{
	
	public static void main(String[] args){
		List<Integer> input1 = new LinkedList<>(Arrays.asList(1, 6, 1, 7));
		List<Integer> input2 = new LinkedList<>(Arrays.asList(2, 6, 9, 5));
		
		List<Integer> output = new LinkedList<>();
		output = addDigits(input1, input2);
		
		System.out.println(output);
	}

	private static List<Integer> addDigits(List<Integer> input1, List<Integer> input2) {
		List<Integer> answer = new LinkedList<>();
		int carry = 0, difference, start;
		if(input1.size()>=input2.size()){
			start = (input1.size()-1);
			difference = (input1.size()-input2.size());
			answer = calculation(input1, input2, start, difference, carry, answer);
		}
		else{
			start = (input2.size()-1);
			difference = (input2.size()-input1.size());
			answer = calculation(input2, input1, start, difference, carry, answer);
		}
		int temp, last=(answer.size()-1);
		for(int i=0; i<answer.size()/2; i++){
			temp = answer.get(i);
			answer.set(i, answer.get(last));
			answer.set(last, temp);
			last = last-1;
		}
		return answer;
	}

	private static List<Integer> calculation(List<Integer> input1,
			List<Integer> input2, int start, int difference, int carry,
			List<Integer> answer) {
		int sum;
		for(int i=start; i>=0; i--){
			if((i-difference)>=0){
				sum = input1.get(i)+input2.get(i-difference)+carry;
			}
			else{
				sum = input1.get(i)+carry;
			}
			if(sum>9){
				carry=sum/10;
				sum=sum%10;
			}
			else{
				carry=0;
			}
			answer.add(sum);
		}
		
		return answer;
	}
}
