package leetcodeproblems;

/*
 *
 * 
Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target,
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 * 
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Solution
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		int in, target;
		System.out.println("Enter the number of elements: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		in = Integer.parseInt(br.readLine());
		
		int[] userArr = new int[in];
		
		for(int i =0; i<userArr.length; i++)
		{
			Random rand = new Random();
			int randomInteger = rand.nextInt(userArr.length);
			userArr[i] = randomInteger;
		}
						
		sort(userArr);
		
		System.out.println(Arrays.toString(userArr));
		
		System.out.println("Please enter the target number: ");
		BufferedReader newbr = new BufferedReader(new InputStreamReader(System.in));
		target = Integer.parseInt(newbr.readLine());
		
		twoSum(userArr, target);
		
	}

	private static void sort(int[] userArr)
	{		
		for(int j=1; j<(userArr.length); j++)
		{
			for(int i=0; i<j; i++)
			{
				if(userArr[i]==userArr[j])
				{
					//do nothing
				}
				else
				{
					if(userArr[i]<userArr[j])
					{
						//do nothing
					}
					else
					{
						int temp1=userArr[j];
						for(int k=j;k>i;k--)
						{
							userArr[k]=userArr[k-1];
						}
						userArr[i]=temp1;
					}
				}
			}
		}
	}

	public static int[] twoSum(int[] userArr, int target) throws NumberFormatException, IOException
	{
		
		for(int i=0; i<(userArr.length-1); i++)
		{
			for(int j=(i+1); j<userArr.length; j++)
			{
				if((userArr[i]+userArr[j])==target)
				{
					System.out.println("The number at index " + i + " is " + userArr[i] + " and the number at index " + j + " is " + userArr[j]);
					System.out.println("The addition of " + userArr[i] + " and " + userArr[j] + " is " + target);
					System.exit(0);
				}
				else
				{
					if(i==(userArr.length-2) && j==(userArr.length-1))
					{
						System.out.println("The given target is out of bounds. Please enter a new target:");
						BufferedReader newerbr = new BufferedReader(new InputStreamReader(System.in));
						target = Integer.parseInt(newerbr.readLine());
						
						twoSum(userArr, target);
					}
					else
					{
						//do nothing
					}
				}
			}
		}
		return null;
	}
}
