package javarevisitedpackage;

import java.util.Scanner;

public class CheckPower
{
	private static int tempInt;
	public static void main(String[] args)
	{
		String str1;
		String str2;
		
		System.out.println("Enter first number: ");
		Scanner sc1 = new Scanner(System.in);
		str1 = sc1.nextLine();
		checkInput(str1);
		int answer = tempInt;
		
		System.out.println("Enter second number: ");
		Scanner sc2 = new Scanner(System.in);
		str2 = sc2.nextLine();
		checkInput(str2);
		int number = tempInt;
		
		double power = Math.log(answer)/Math.log(number);
		
		if(((float)power - Math.floor(power))==0.0)
		{
			System.out.println(number + " should be raised to the power of " + (int)power + " to give the answer " + answer);
		}
		else
		{
			System.out.println(answer + " cannot be obtainted by raising " + number + " to any integer value");
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
