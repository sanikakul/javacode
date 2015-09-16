package chapterone;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KthToLast{
	
	public static void main(String[] args){
		int k = 1;
		List<Integer> input = new LinkedList<>(Arrays.asList(20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0));
		int output = findElement(input, k);
		
		System.out.println(output);
	}

	private static int findElement(List<Integer> input, int k){
		int answer;
		if((input.size()-k)>=0){
			for(int i=0; i<input.size(); i++){
				if(i==(input.size()-1)){
					answer=input.get(i-k);
					return answer;
				}
			}
		}
		return 0;
	}
}
