package practiceproblems;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class NonRepeatingChars{
	
	public static void main(String[] args){
		String input = "kulkarni";
		char output = firstNonRepeat(input);
		System.out.println(output);
	}

	private static char firstNonRepeat(String input) {
		char answer = 0;
		int value=0;
		char[] array = input.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		Set<Character> set = new LinkedHashSet<>();
		for(int i=0; i<array.length; i++){
			if(map.containsKey(array[i])){
				map.put(array[i], map.get(array[i])+1);
				set.remove(array[i]);
			}
			else{
				map.put(array[i], 1);
				set.add(array[i]);
			}
		}
		if(set.iterator().hasNext()){
			answer=set.iterator().next();
		}
		
		return answer;
	}
}
