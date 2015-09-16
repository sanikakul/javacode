package codingchallengepackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Chef loves palindromes.
Chef initially has odd number of characters.
Chef wants to create a palindrome of maximum even length using these characters.

For this Chef needs to discard one character.
Help Chef find the character which needs to be discarded so that he can use the rest characters in any order
to form a palindrome having maximum even length.
*/

public class CharsAndPalindromes
{
	private static String input, extraStr, output="";
	private static char[] refArr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
		'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	private static char[] userArr;
	private static int[] refIntArr = new int[26];
	
	public static void main(String[] args) throws IOException
	{
		for(int i=0; i<refIntArr.length; i++)
		{
			refIntArr[i]=0;
		}
		
		System.out.println("Enter a String made up of the characters a....z: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		
		CheckLength();
				
		userArr = input.toCharArray();
		
		for(int i=0; i<userArr.length; i++)
		{
			for(int j=0; j<refArr.length; j++)
			{
				if(userArr[i]==refArr[j])
				{
					refIntArr[j] = refIntArr[j]+1;
				}
				else
				{
					//do nothing
				}
			}
		}
		
		DeleteExtras();
		
		for(int i=0; i<userArr.length; i++)
		{
			if(userArr[i]=='0')
			{
				//do nothing
			}
			else
			{
				output=output+userArr[i];
			}
		}
		
		System.out.println("The length of the longest palindrome that can be obtained from the string '"
				+ input + "' is: " + output.length());
		
	}

	private static void DeleteExtras()
	{
		for(int i=0; i<refIntArr.length; i++)
		{
			if((refIntArr[i]%2)==0)
			{
				//do nothing
			}
			else
			{
				for(int j=0; j<userArr.length; j++)
				{
					if(refArr[i]==userArr[j])
					{
						userArr[j] = '0';
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

	private static void CheckLength() throws IOException
	{
		if((input.length()%2)==0)
		{
			System.out.println("It is necessary that the String is of an odd length");
			System.out.println("The String that you have entered is of the length: " + input.length());
			System.out.println("Please enter one or more characters to continue.");
			
			BufferedReader newbr = new BufferedReader(new InputStreamReader(System.in));
			extraStr = newbr.readLine();
			
			input = input+extraStr;
			
			CheckLength();
			
		}
		else
		{
			//do nothing
		}
	}
}
