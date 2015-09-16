package chapterone;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListPartitioning{
	
	public static void main(String[] args){
		
		char pivot = 'n';
		List<Character> input = new LinkedList<>(Arrays.asList('a', 's', 'n', 'i', 'k'));
		List<Character> output = new LinkedList<>();
		
		output = partitionList(input, pivot);
		
		System.out.println(output);
	}

	private static List<Character> partitionList(List<Character> input, char pivot) {
		
		List<Character> buffer = new LinkedList<>();
		int pointer=0;
		for(int i=0; i<input.size(); i++){
			if(input.get(i)==pivot){
				pointer = i;
				break;
			}
			if(input.get(i)>pivot){
				input.add(input.get(i));
				input.remove(i);
				i = i-1;
			}
		}
		
		for(int i=(pointer+1); i<input.size(); i++){
			if(input.get(i)<pivot){
				buffer.add(input.get(i));
				input.remove(i);
				i = i-1;
			}
		}
		
		for(int i=(pointer+1); i<(pointer+buffer.size()); i++){
			input.add(input.get(i));
			
		}
		
		input.add(pointer+buffer.size(), input.get(pointer));
		
		for(int i=pointer; i<=pointer+buffer.size()-1; i++){
			input.set(i, buffer.get(i-pointer));
		}
		
		return input;
	}

}
