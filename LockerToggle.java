package chapterone;

import java.util.Arrays;

public class LockerToggle{
	
	public static void main(String[] args){
		int[] doors = new int[101];
		for(int i=0; i<101; i++){
			doors[i] = 0;
		}
		
		int output = doorsOpen(doors);
		
		System.out.println(output);
	}

	private static int doorsOpen(int[] doors) {
		
		for(int i=2; i<=101; i++){
			for(int j=1; i*j<=100; j++){
				if(doors[i*j]==0){
					doors[i*j]=1;
					System.out.println(Arrays.toString(doors));
				}
				else if(doors[i*j]==1){
					doors[i*j]=0;
					System.out.println(Arrays.toString(doors));
				}
			}
		}
		int counter = 0;
		for(int i=1; i<101; i++){
			if(doors[i]==0){
				counter = counter+1;
			}
		}
		return counter;
	}
}
