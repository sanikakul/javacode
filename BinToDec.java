package bintodec;

import java.util.Scanner;

public class BinToDec
{
	private static String input;
	private static int[] leftBin;
	private static int[] rightBin;
	private static char[] charArray;
	private static int outputLeft=0;
	private static double outputRight=0;
	private static int counter=0;
	private static int position;
	private static int decimal;
	
	public static void main(String[] args)
	{
		System.out.println("Enter a binary number (1, 0, and maximum 1 decimal point only): ");
		Scanner sc = new Scanner(System.in);
		input = sc.next();
		
		check();
		
		split();
		
		if(counter==1)
		{
			double output=0;
			for(int i=0; i<leftBin.length; i++)
			{
				int temp = (int) (leftBin[i] * Math.pow(2, i));
				outputLeft = outputLeft + temp;
			}
			
			for(int i=0; i<rightBin.length; i++)
			{
				double temp1 = Math.pow(2, i);
				double temp2 = 1/temp1;
				double temp = rightBin[i]*temp2;
				outputRight = outputRight + temp;
			}
			
			output = outputLeft + outputRight;
			
			System.out.println("Binary input: " + input);
			System.out.println("Decimal output: " + output);
		}
		else
		{
			int output=0;
			for(int i=0; i<leftBin.length; i++)
			{
				int temp = (int) (leftBin[i] * Math.pow(2, i));
				outputLeft = outputLeft + temp;
			}
			
			output = outputLeft;
			
			System.out.println("Binary input: " + input);
			System.out.println("Decimal output: " + output);
		}
	}

	private static void split()
	{
		if(counter==1)
		{
			leftBin = new int[position];
			for(int i=(leftBin.length-1); i>=0; i--)
			{
				leftBin[i]=charArray[leftBin.length-1-i] - '0';
			}
			rightBin = new int[decimal-1];
			for(int i=0; i<rightBin.length; i++)
			{
				rightBin[i]=charArray[i+position+1] - '0';
			}
		}
		else
		{
			leftBin = new int[charArray.length];
			for(int i=(leftBin.length-1); i>=0; i--)
			{
				leftBin[i]=charArray[leftBin.length-1-i] - '0';
			}
		}
	}

	private static void check()
	{
		charArray = input.toCharArray();
		for(int i=0; i<charArray.length; i++)
		{
			if(charArray[i]=='1' || charArray[i]=='0')
			{
				//do nothing
			}
			else
			{
				if(charArray[i]=='.')
				{
					counter = counter + 1;
					if(counter>1)
					{
						System.out.println("Input has multiple decimal points");
						System.out.println("(1, 0, and maximum 1 decimal point only): ");
						Scanner sc = new Scanner(System.in);
						input = sc.next();
						check();
						break;
					}
					else
					{
						if(counter==0)
						{
							//do nothing
						}
						else
						{
							position = (i);
							decimal = charArray.length - position;
						}
					}
				}
				else
				{
					System.out.println("Input has characters apart from 1 and 0");
					System.out.println("Please enter a binary number (1, 0, and maximum 1 decimal point only): ");
					Scanner sc = new Scanner(System.in);
					input = sc.next();
					check();
					break;
				}
			}
		}
	}
}
