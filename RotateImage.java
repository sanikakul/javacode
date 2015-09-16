package chapterone;

import java.util.Arrays;

public class RotateImage{
	
	public static void main(String[] args){
		
		int[][] input = {{00, 01, 02, 03},{10, 11, 12, 13},{20, 21, 22, 23},{30, 31, 32, 33}};
		int[][] output = rotation(input);
		
		System.out.println(output);
	}

	private static int[][] rotation(int[][] input){
		
		int[][] answer = {};
		int[] values = new int[2];
		for(int i=0; i<=input.length/2; i++){
			for(int j=i; j<input.length/2; j++){
				values = getValues(i, j, input.length);
			}
		}
		
		return answer;
	}

	private static int[] getValues(int i, int j, int N){
		int[] values = new int[2];
		j = j+(N-1);
		if(j>(N-1)){
			
		}
		return values;
	}
}
