package codingchallengepackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 
Chef is a mathematics student. His professor has given him a difficult task.
Professor initially provides Chef with a list of numbers.
For every number in the list, Chef has to calculate the sum 'S' of digits such that 0<=S<=9.
Even if the sum of digits is coming as a 'n' digit number, Chef has to bring it down to 1 digit number
by further calculating the sum of the n digits and so on.
Each value of final one digit sum is assigned a color.

The color starts from index 0 to 9 and the value for each is given as follows:-

0-red
1-yellow
2-blue
3-green
4-turquoise
5-violet
6-black
7-white
8-pink
9-orange

For each number in the list, Chef will obtain a 1 digit sum at the end.
From these sums, Chef needs to find the color relating to the maximum 1 digit sum from the list.
Professor clarifies the problem through the following example:
Consider a list of 2 numbers 52 and 181.
The addition of digits of number 52 gives 52=5+2=7, and that of 181 gives 181=1+8+1=10=1+0=1.
So the maximum value is 7. So look at the color present at index 7 i.e. 'white'. So the output is white.

 *
 */

public class ColorsAndNumbers
{
	private static int n, rem=0;
	//Declaring a temporary Array of size of the number of elements
	private static int[] tempArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		//Declare colors for numbers from 0 to 9
		
		String[] color= new String[10];
		color[0] = "red";
		color[1] = "yellow";
		color[2] = "blue";
		color[3] = "green";
		color[4] = "turquoise";
		color[5] = "violet";
		color[6] = "black";
		color[7] = "white";
		color[8] = "pink";
		color[9] = "orange";
		
		int input, temp;
		
		//Getting the number of elements from the user
		System.out.println("Enter the number of elements:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		//Declaring an Array of size of the number of elements
		int[] userArr = new int[n];
		
		//Getting input from the user to fill in the array
		
		System.out.println("Enter the values to be evaluated:");
		for(int i=0; i<n; i++)
		{
			System.out.print("Enter value " + (i+1) + ": ");
			BufferedReader newbr = new BufferedReader(new InputStreamReader(System.in));
			input = Integer.parseInt(newbr.readLine());
			userArr[i]=input;
		}
		
		//Initializing the temporary Array
		tempArr = new int[n];
		
		//calculating the addition of all the digits in each element of userArr
		
		for(int i=0; i<n; i++)
		{
			temp = userArr[i];
			Summation(temp, i);
		}
		//System.out.println(Arrays.toString(tempArr));
		
		int max = tempArr[0];
		for(int i=1; i<n; i++)
		{
			if(max<tempArr[i])
			{
				max=tempArr[i];
			}
			else
			{
				//do nothing
			}
		}
		//System.out.println("Maximum: " + max);
		
		System.out.println("Color: " + color[max]);
	}

	private static void Summation(int temp, int i)
	{
		if(temp<10)
		{
			tempArr[i] = temp;
		}
		else
		{
			tempArr[i]=0;
			AddDigits(temp, i);
		}
	}

	private static void AddDigits(int temp, int i)
	{
		rem=temp%10;
		temp=temp/10;
		if(temp==0)
		{
			tempArr[i]=tempArr[i]+rem;
			if(tempArr[i]<10)
			{
				//do nothing
			}
			else
			{
				Summation(tempArr[i], i);
			}
		}
		else
		{
			tempArr[i]=tempArr[i]+rem;
			AddDigits(temp, i);
		}
	}
}
