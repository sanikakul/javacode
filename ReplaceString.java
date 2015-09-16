package chapterone;

import java.util.Arrays;

public class ReplaceString {
	
	public static void main(String[] args) {
		
		String input = "   a   b c d e                  ";
		String output = insertChar(input);
		
		System.out.println(output);
	}

	private static String insertChar(String input) {
		int counter = 0;
		char[] inputArray = input.toCharArray();
		int pointer = inputArray.length-1;
		for(int i=(inputArray.length-1); i>=0; i--){
			if(counter==0){
				if(inputArray[i]==' '){
					//do nothing
				}
				else{
					counter = counter + 1;
					i=i+1;
				}
			}
			else{
				if(inputArray[i]!=' '){
					if(pointer!=i){
						inputArray[pointer]=inputArray[i];
						inputArray[i] = ' ';
					}
					pointer = pointer-1;
				}
				else{
					inputArray[pointer]='0';
					inputArray[pointer - 1]='2';
					inputArray[pointer - 2]='%';
					pointer=pointer-3;
				}
			}
		}
				
		String answer="";
		for(int i=0; i<inputArray.length; i++){
			answer=answer+inputArray[i];
		}
		
		return answer;
	}
}
