package chapterone;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Duplicates{
	
	public static void main(String[] args){
		List<Character> input = new LinkedList<>(Arrays.asList('s', 'a', 'n', 'i', 'k', 'a'));
		List<Character> output = new LinkedList<>();
		
		output = removeDuplicates(input);
		
		System.out.println(output);
	}

	private static List<Character> removeDuplicates(List<Character> input) {
		
		Set<Character> hs = new HashSet<>();
		for(int i=0; i<input.size(); i++){
			if(hs.contains(input.get(i))){
				input.remove(i);
				i = i-1;
			}
			else{
				hs.add(input.get(i));
			}
		}
		return input;
	}
}
