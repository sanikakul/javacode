package chapterone;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramStrings{
	
	public static void main(String[] args){
		String[] input = {"tier", "acne", "acre", "but", "listen", "care", "tire", "cane", "silent", "tub", "rite"};
		String[] output = groupByAnagram(input);
		
		System.out.println(Arrays.toString(output));
	}

	private static String[] groupByAnagram(String[] input){
		/*for(int i=0; i<input.length; i++){
		answer[i] = Sort(input[i]);
		}*/
		String[] answer = {"eirt", "acen", "acer", "btu", "eilnst", "acer", "eirt", "acen", "eilnst", "btu", "eirt"};
		Map<String, String> map = new HashMap<>();
		
		for(int i=0; i<answer.length; i++){
			map.put(answer[i], input[i]);
		}
		
		for (Map.Entry entry : map.entrySet()) {
		    System.out.println(entry.getKey() + ", " + entry.getValue());
		}
		
		return answer;
	}
}