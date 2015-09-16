package javarevisitedpackage;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumbers
{
	private static int tempInt;
	private static ArrayList<Integer> prime = new ArrayList<Integer>();
	public static void main(String[] args)
	{
		String str1;
		int input;
		System.out.println("Enter a number:");
		Scanner sc1 = new Scanner(System.in);
		str1 = sc1.nextLine();
		checkInput(str1);
		input = tempInt;
		
		divisors(input);
		
		System.out.println(prime);
	}
	
	private static void divisors(int input)
	{
		if(input == 0 || input == 1 || input == 2)
		{
			System.out.println("There are no prime numbers before " + input + ".");
		}
		else
		{
			if(input == 3)
			{
				System.out.println("The only prime number before " + input + " is 2.");
			}
			else
			{
				prime.add(2);
				prime.add(3);
				for(int i=4; i<input; i++)
				{
					for(int j=(i-1); j>1; j--)
					{
						if((i%j)==0)
						{
							break;
						}
						else
						{
							if(j==2)
							{
								prime.add(i);
							}
							else
							{
								//do nothing
							}
						}
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