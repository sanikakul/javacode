package practiceproblems;

import java.util.HashMap;
import java.util.Map;

public class ConsecutiveAnagram {
	
	public static void main(String[] args){
		String word = "amaze";
		String string = "amazing";
		Map<Character, Integer> prime = new HashMap<>();
		prime.put('a', 2);
		prime.put('b', 3);
		prime.put('c', 5);
		prime.put('d', 7);
		prime.put('e', 11);
		prime.put('f', 13);
		prime.put('g', 17);
		prime.put('h', 19);
		prime.put('i', 23);
		prime.put('j', 29);
		prime.put('k', 31);
		prime.put('l', 37);
		prime.put('m', 41);
		prime.put('n', 43);
		prime.put('o', 47);
		prime.put('p', 53);
		prime.put('q', 59);
		prime.put('r', 61);
		prime.put('s', 67);
		prime.put('t', 71);
		prime.put('u', 73);
		prime.put('v', 79);
		prime.put('w', 83);
		prime.put('x', 89);
		prime.put('y', 97);
		prime.put('z', 101);
		boolean output = hasAnagram(word, string, prime);
		
		if(!output){
			System.out.println(string + " does not contain " + word);
		}
		else{
			System.out.println(string + " contains " + word);
		}
	}

	private static boolean hasAnagram(String word, String string, Map<Character, Integer> prime){
		char[] stringArr = string.toCharArray();
		char[] wordArr = word.toCharArray();
		int product=1, compare=1;
		for(int i=0; i<wordArr.length; i++){
			product = product*prime.get(wordArr[i]);
		}
		for(int i=0; i<(stringArr.length-wordArr.length+1); i++){
			for(int j=i; j<wordArr.length+i; j++){
				compare = compare*prime.get(stringArr[j]);
			}
			if(product==compare){
				return true;
			}
			compare=1;
		}
		return false;
	}
}
