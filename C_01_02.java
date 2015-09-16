package javaprogramming;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class C_01_02
{
	public static void main(String[] args)
	{
		int n;
		System.out.println("enter a number");
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		int[] newArr = new int [n];
		
		for(int i =0; i<n; i++)
		{
			Random rand = new Random();
			int randomInteger = rand.nextInt(n);
			//System.out.println(randomInteger);
			newArr[i] = randomInteger;
		}
		
		System.out.println("Array: " + Arrays.toString(newArr));
		
		for(int i =0; i<newArr.length; i++)
		{
			int k = newArr[i];
			if((k%2)!=0)
			{
				System.out.println(k);
			}
			else
			{
				//do nothing
			}
		}
	}
}
