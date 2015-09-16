package chapterone;

public class Rotation{
	
	public static void main(String[] args){
		String input = "waterbottle";
		String compare = "erbottlewat";
		
		boolean output = isRotation(input, compare);
		
		if(!output){
			System.out.println(compare + " is not a rotation of " + input);
		}
		else{
			System.out.println(compare + " is a rotation of " + input);
		}
	}

	private static boolean isRotation(String input, String compare) {
		
		if(input.length()!=compare.length()){
			return false;
		}
		char[] inputArr = input.toCharArray();
		char[] compareArr = compare.toCharArray();
		int pointer=0;
		for(int i=0; i<compareArr.length; i++){
			if(inputArr[0]==compareArr[i]){
				pointer = i;
				break;
			}
		}
		for(int i=0; i<compareArr.length; i++){
			if((i+pointer)<compare.length()){
				if(inputArr[i]!=compareArr[i+pointer]){
					return false;
				}
			}
			else{
				if(inputArr[i]!=compareArr[i+pointer-compareArr.length]){
					return false;
				}
			}
		}
		return true;
	}
}
