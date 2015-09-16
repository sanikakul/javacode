package chapterone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCompression {
	
	public static void main(String[] args) {
		
		String input = "ahhhhhha";
		String output = compress(input);
		System.out.println(output);
	}

	private static String compress(String input) {
		
		int counter = 0;
		char[] inputArray = input.toCharArray();
		List<Character> compression = new ArrayList<>();
		for(int i=0; i<inputArray.length; i++){
			if(i==0){
				counter=1;
			}
			else{
				if(inputArray[i]==inputArray[i-1]){
					counter = counter+1;
				}
				else{
					compression.add(inputArray[i-1]);
					compression.add((char)(counter + '0'));
					counter = 1;
				}
			}
			if(i==(inputArray.length-1)){
				compression.add(inputArray[i]);
				compression.add((char)(counter + '0'));
			}
		}
		String answer = "";
		for(int i=0; i<compression.size(); i++){
			answer = answer+compression.get(i);
		}
		
		if(answer.length()>input.length()){
			return input;
		}
		return answer;
	}
}
