package chapterone;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DeleteNode{
	
	public static void main(String[] args){
		
		char node = 'c';
		List<Character> input = new LinkedList<>(Arrays.asList('a', 'b', 'c', 'd', 'e'));
		List<Character> output = new LinkedList<>();
		
		output = deleteNode(input, node);
		
		System.out.println(output);
	}

	private static List<Character> deleteNode(List<Character> input, char node) {
		
		for(int i=0; i<input.size(); i++){
			if(input.get(i)==node){
				input.remove(i);
				break;
			}
		}
		return input;
	}

}
