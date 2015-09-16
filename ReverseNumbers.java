package chapterone;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReverseNumbers{
	
	public static void main(String[] args){
		List<Integer> input1 = new LinkedList<>(Arrays.asList(7, 1, 6, 8));
		List<Integer> input2 = new LinkedList<>(Arrays.asList(5, 9, 6));
		
		List<Integer> output = new LinkedList<>();
		output = addDigits(input1, input2);
		
		System.out.println(output);
	}

	private static List<Integer> addDigits(List<Integer> input1, List<Integer> input2){
		
		List<Integer> answer = new LinkedList<>();
		int carry = 0, lower_bound, difference, sum;
		if(input1.size()>=input2.size()){
			lower_bound=input2.size();
		}
		else{
			lower_bound=input1.size();
		}
		
		for(int i=0; i<lower_bound; i++){
			sum = input1.get(i)+input2.get(i)+carry;
			if(sum>9){
				carry=sum/10;
				sum=sum%10;
			}
			else{
				carry=0;
			}
			answer.add(sum);
		}
		
		if(input1.size()>=input2.size()){
			for(int i=input2.size(); i<input1.size(); i++){
				sum = input1.get(i)+carry;
				if(sum>9){
					carry=sum/10;
					sum=sum%10;
				}
				else{
					carry=0;
				}
				answer.add(sum);
			}
		}
		else{
			for(int i=input1.size(); i<input2.size(); i++){
				sum = input2.get(i)+carry;
				if(sum>9){
					carry=sum/10;
					sum=sum%10;
				}
				else{
					carry=0;
				}
				answer.add(sum);
			}
		}
		
		return answer;
	}
}
