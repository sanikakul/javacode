package practiceproblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	public static void main(String[] args) {
		String input = "abdcdcba";
		int N = 3;
		String output="";
		output = isLongestSubstring(input, N, output);
		System.out.println(output);
	}

	private static String isLongestSubstring(String input, int n, String output) {
		String string="";
		Map<Character, Integer> map = new HashMap<>();
		char[] inputArr = input.toCharArray();
		int pointer=0;
		for(int i=0; i<(inputArr.length-n+1); i++){
			for(int j=pointer; j<inputArr.length; j++){
				if(map.containsKey(inputArr[j])){
					map.put(inputArr[j], map.get(inputArr[j])+1);
				}
				else{
					if(map.size()<n){
						map.put(inputArr[j], 1);
					}
					else{
						if(map.get(inputArr[i])>1){
							for(int k=i; k<j; k++){
								string = string+inputArr[k];
							}
							if(output.length()<string.length()){
								output=string;
							}
							string="";
							pointer=j;
							map.put(inputArr[i], map.get(inputArr[i])-1);
							break;
						}
						else{
							for(int k=i; k<j; k++){
								string = string+inputArr[k];
							}
							if(output.length()<string.length()){
								output=string;
							}
							string="";
							pointer=j;
							map.remove(inputArr[i]);
							break;
						}
					}
				}
			}
		}
		return output;
	}

}
