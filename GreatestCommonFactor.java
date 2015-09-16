package javarevisitedpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GreatestCommonFactor
{
	private static int tempInt;	
	private static ArrayList<Integer> group  = new ArrayList<Integer>();
	private static ArrayList<Integer> answer  = new ArrayList<Integer>();
	public static void main(String[] args)
	{
		String str1;
		System.out.println("How many numbers do you want to compare? ");
		Scanner sc1 = new Scanner(System.in);
		str1 = sc1.nextLine();
		checkInput(str1);
		int total = tempInt;
		
	    String[] strNum = new String[total];
	    int[] numbers = new int[total];
		
		for(int i=0; i<total; i++)
		{
			System.out.println("Enter input number " + (i+1) + ": ");
			Scanner sc = new Scanner(System.in);
			strNum[i] = sc.nextLine();
			checkInput(strNum[i]);
			numbers[i]  = tempInt;
		}
				
		for(int i=0; i<total; i++)
		{
			factors(numbers[i]);
		}
		
		int gcf = 1;
		for(int i=0; i<answer.size(); i++)
		{
			gcf = gcf * answer.get(i);
		}
		
		System.out.println("The greatest common factor of " + Arrays.toString(numbers) + " is " + gcf);
	}

	private static void factors(int i)
	{
		int temp = i;
		ArrayList<Integer> allFactors = new ArrayList<Integer>();
		for(int j=0; j<(temp+1); j++)
		{
			if(j==0)
			{
				//do nothing
			}
			else
			{
				if(j==1)
				{
					allFactors.add(j);
				}
				else
				{
					if(i%j==0)
					{
						allFactors.add(j);
						i = i/j;
						j=j-1;
					}
					else
					{
						//do nothing
					}
				}
			}
		}
		if(group.isEmpty())
		{
			group.addAll(allFactors);
		}
		else
		{
			if(answer.isEmpty())
			{
				compare(allFactors);
			}
			else
			{
				group.removeAll(group);
				group.addAll(answer);
				answer.removeAll(answer);
				compare(allFactors);
			}
		}
	}

	private static void compare(ArrayList<Integer> allFactors)
	{
		int size_0 = group.size();
		int size_new = allFactors.size();
		int temp = 0;
		if(size_0<=size_new)
		{
			for(int z=0; z<size_0; z++)
			{
				for(int y=temp; y<size_new; y++)
				{
					if(group.get(z)==allFactors.get(y))
					{
						answer.add(group.get(z));
						temp = y+1;
						break;
					}
					else
					{
						//do nothing
					}
				}
			}
		}
		else
		{

			for(int z=0; z<size_new; z++)
			{
				for(int y=temp; y<size_0; y++)
				{
					if(group.get(y)==allFactors.get(z))
					{
						answer.add(group.get(y));
						temp = y+1;
						break;
					}
					else
					{
						//do nothing
					}
				}
			}
		}
	}

	private static void checkInput(String strCheck)
	{
		char[] charArray = strCheck.toCharArray();
		for(int i=0; i<charArray.length; i++)
		{
			if(charArray[i]>='0' && charArray[i]<='9')
			{
				if(i==(charArray.length-1))
				{
					tempInt = Integer.parseInt(strCheck);
				}
				else
				{
					//do nothing
				}
			}
			else
			{
				String temp = "";
				System.out.println("Invalid input. Please enter another number: ");
				Scanner sc = new Scanner(System.in);
				temp = sc.nextLine();
				checkInput(temp);
				break;
			}
		}
	
	}
}
