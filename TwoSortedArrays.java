package chapterone;

import java.util.Arrays;

public class TwoSortedArrays{
	
	public static void main(String[] args){
		int [] array1 = {1, 3, 5, 7, 9, 13, 15, 19, 22, 28, 35, 39, 40, 46, 48, 51, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] array2 = {2, 4, 5, 9, 16, 19, 25, 27, 29, 30, 31};
				
		int[] output = mergeArrays(array1, array2);
		
		System.out.println(Arrays.toString(output));
	}

	private static int[] mergeArrays(int[] array1, int[] array2){
		
		int pointer1=0, pointer2=0, place=array1.length-1, temp, start;
		for(int i=array1.length-1; i>=0; i--){
			if(array1[i]!=0){
				pointer1=i;
				pointer2 = array1.length - pointer1 - 2;
				break;
			}
		}
		start = pointer1;
		for(int i=start; i>=0; i--){
			if(pointer2>=0){
				if(array1[i]==array2[pointer2]){
					temp=array1[i];
					array1[i]=array1[place];
					array1[place]=temp;
					place = place-1;
					array1[place]=array2[pointer2];
					place = place-1;
					pointer2 = pointer2-1;
				}
				else if(array1[i]>array2[pointer2]){
					temp=array1[i];
					array1[i]=array1[place];
					array1[place]=temp;
					place = place-1;
				}
				else{
					array1[place]=array2[pointer2];
					place = place-1;
					pointer2 = pointer2-1;
					i = i+1;
				}
			}
			else{
				break;
			}
		}
		
		return array1;
	}
}
