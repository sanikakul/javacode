package practiceproblems;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {

	public static void main(String[] args){
		String input = "bust";
		String anagram = "tuba";
		boolean output = isAnagram(input, anagram);
		if(!output){
			System.out.println(anagram + " is not an anagram of " + input);
		}
		else{
			System.out.println(anagram + " is an anagram of " + input);
		}
	}

	private static boolean isAnagram(String input, String anagram) {
		if(input.length()!=anagram.length()){
			return false;
		}
		char[] inputArr = input.toCharArray();
		char[] anagramArr = anagram.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i<inputArr.length; i++){
			if(map.containsKey(inputArr[i])){
				map.put(inputArr[i], map.get(inputArr[i])+1);
			}
			else{
				map.put(inputArr[i], 1);
			}
		}
		for(int i=0; i<anagramArr.length; i++){
			if(map.containsKey(anagramArr[i])){
				map.put(anagramArr[i], map.get(anagramArr[i])-1);
			}
			else{
				return false;
			}
		}
		
		return true;
	}
}
