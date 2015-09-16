package practiceproblems;

public class SubstringMatching{
	
	public static void main(String[] args){
		String input = "aaabbc";
		String substring = "aaabbc";
		boolean output = isMatch(input, substring);
	}

	private static boolean isMatch(String input, String substring){
		char[] inputArr = input.toCharArray();
		char[] ssArr = substring.toCharArray();
		char temp;
		int k;
		for(int i=0; i<inputArr.length; i++){
			if(inputArr[i]==ssArr[i] || ssArr[i]=='.'){
				
			}
			else{
				if(ssArr[i]=='*'){
					if(i==0){
						return false;
					}
					if(ssArr[i-1]=='.'){
						temp = inputArr[i-1];
						for(int j=(i+1); j<inputArr.length; j++){
							if(inputArr[j]==temp){
								
							}
							
						}
					}
				}
			}
		}
		
		return true;
	}
}
