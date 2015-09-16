package chapterone;

import java.util.Arrays;

public class RotatedArray{
	
	public static void main(String[] args){
		int input=2;
		int[] array = {15, 17, 19, 20, 25, 3, 4, 5, 6, 7, 10, 14};
		
		int output = isAtIndex(array, input);
		
		System.out.println(output);
	}

	private static int isAtIndex(int[] array, int input){
		
		int index=0, before=0, after=0, pointer=0, fixed=0, counter=0;
		for(int i=0; i<(array.length-1); i++){
			before=i;
			after=i+1;
			if(input>array[before] && input<array[after]){
				fixed=after;
				counter=counter+1;
			}
			if(array[after]<array[before]){
				if(input>array[before]){
					fixed=after;
					counter=counter+1;
				}
				if(input<array[after] && input<array[before]){
					return index;
				}
				pointer=after;
				counter=counter+1;
			}
			if(counter==2){
				break;
			}
		}
		
		if(fixed>pointer){
			index=fixed-pointer;
		}
		else if(fixed<pointer){
			index=array.length-pointer+fixed;
		}
		else{
			index=array.length;
		}
		
		return index;
	}
}
