package javarevisitedpackage;

import java.util.Scanner;

public class PowerOfTwo
{
	private static String number;
	private static double input;
	
	public static void main(String[] args)
	{
		System.out.println("Enter a number: ");
		Scanner sc = new Scanner(System.in);
		number = sc.nextLine();
		checkInput();
		convertToDouble();
		
		double output = 0.0;
		
		if(Math.floor(input)==0)
		{
			positivePower(output);
		}
		else
		{
			if(Math.floor(input)==1)
			{
				System.out.println((int)input + " is the value obtained when 2 is raised to the power of 0");
			}
			else
			{
				positivePower(output);
			}
		}
	}

	private static void convertToDouble()
	{
		char[] charArray = number.toCharArray();
		String temp="";
		for(int i=0; i<charArray.length; i++)
		{
			temp = temp + charArray[i];
		}
		input = Double.parseDouble(temp);
	}

	private static void checkInput()
	{
		int counter = 0;
		char[] charArray = number.toCharArray();
		for(int i=0; i<charArray.length; i++)
		{
			if(charArray[i]>='0' && charArray[i]<='9')
			{
				//do nothing
			}
			else
			{
				if(charArray[i]=='.')
				{
					counter++;
					if(counter>1)
					{
						System.out.println("The input is invalid. Please enter a number again: ");
						Scanner sc = new Scanner(System.in);
						number = sc.nextLine();
						checkInput();
						break;
					}
					else
					{
						//do nothing
					}
				}
				else
				{
					System.out.println("The input is invalid. Please enter a number again: ");
					Scanner sc = new Scanner(System.in);
					number = sc.nextLine();
					checkInput();
					break;
				}
			}
		}
	}

	private static void positivePower(double output)
	{
		output = Math.log(input)/Math.log(2);
		if((input - Math.floor(input))==0.0)
		{
			if((output - Math.floor(output))==0.0)
			{
				System.out.println((int)input + " is the value obtained when 2 is raised to the power of " + (int)output);
			}
			else
			{
				System.out.println((int)input + " is the value obtained when 2 is raised to the power of " + output);
			}
		}
		else
		{
			if((output - Math.floor(output))==0.0)
			{
				System.out.println((input + " is the value obtained when 2 is raised to the power of " + (int)output));
			}
			else
			{
				System.out.println(input + " is the value obtained when 2 is raised to the power of " + output);
			}
		}
	}
}
