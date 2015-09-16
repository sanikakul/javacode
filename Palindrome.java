package chapterone;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Palindrome{
	
	public static void main(String[] args){
		List<Character> input = new LinkedList<>(Arrays.asList('a', 'x', 'c', 'c', 'x', 'a'));
		
		boolean output;
		output = isPalindrome(input);
		
		if(!output){
			System.out.println(input + " is not a palindrome");
		}
		else{
			System.out.println(input + " is a palindrome");
		}
	}

	private static boolean isPalindrome(List<Character> input){
		
		int last = (input.size()-1);
		for(int i=0; i<input.size()/2; i++){
			if(input.get(i)!=input.get(last)){
				return false;
			}
			last = last-1;
		}
		return true;
	}
}
