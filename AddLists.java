package leetcodeproblems;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * 
 * 
You are given two linked lists representing two non-negative numbers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 * 
 * 
 * 
 */

public class AddLists
{
	public static void main(String[] args)
	{
		String str1, str2;
		LinkedList<Integer> llistFinal = new LinkedList<Integer>();
		System.out.println("Enter non-negative digits to be stored in the first list (example = 123): ");
		Scanner sc1 = new Scanner(System.in);
		str1 = sc1.next();
		
		checkStr(str1);
		
		LinkedList<Integer> llistOne = new LinkedList<Integer>();
		convertToLList(llistOne, str1);
						
		System.out.println("Enter non-negative digits to be stored in the second list (example = 456): ");
		Scanner sc2 = new Scanner(System.in);
		str2 = sc2.next();
		
		checkStr(str2);
		
		LinkedList<Integer> llistTwo = new LinkedList<Integer>();
		convertToLList(llistTwo, str2);
		
		equalizeLength(llistOne, llistTwo);
		
		Collections.reverse(llistOne);		
		Collections.reverse(llistTwo);
		
		addition(llistOne, llistTwo, llistFinal);
		
		System.out.println(llistFinal);
		
	}

	private static void equalizeLength(LinkedList<Integer> llistOne, LinkedList<Integer> llistTwo)
	{
		int temp1, temp2=0;
		
		if(llistOne.size()==llistTwo.size())
		{
			//do nothing
		}
		else
		{
			if(llistOne.size()>llistTwo.size())
			{
				temp1=llistOne.size()-llistTwo.size();
				for(int i=0; i<temp1; i++)
				{
					llistTwo.add(temp2);
				}
			}
			else
			{
				temp1=llistTwo.size()-llistOne.size();
				for(int i=0; i<temp1; i++)
				{
					llistOne.add(temp2);
				}
			}
		}
	}

	private static void addition(LinkedList<Integer> llistGen1, LinkedList<Integer> llistGen2, LinkedList<Integer> llistFinal) 
	{
		int carry=0, temp;
		for(int i=llistGen1.size()-1; i>=0; i--)
		{
			temp = llistGen1.get(i) + llistGen2.get(i) + carry;
			if(temp<10)
			{
				carry=0;	
			}
			else
			{
				carry = temp/10;
				temp = temp%10;
			}
				
			llistFinal.add(temp);
			
			if(i==0)
			{
				if(carry!=0)
				{
					llistFinal.add(carry);
				}
				else
				{
					//do nothing
				}
			}
			else
			{
				//do nothing
			}
		}
	}

	private static void convertToLList(LinkedList<Integer> llistGen, String str)
	{
		int[] intArray = new int[str.length()];
		for (int i = 0; i < intArray.length; i++)
		{
	        intArray[i] = str.charAt(i) - '0';
	    }
		
	    for (int i = 0; i < intArray.length; i++)
	    {
	        llistGen.add(intArray[i]);
	    }
	    
	}

	private static void checkStr(String str)
	{
		char[] charArray = str.toCharArray();
		
		for(int i=0; i<charArray.length; i++)
		{
			if(charArray[i]=='0' || charArray[i]=='1' || charArray[i]=='2' || charArray[i]=='3' || charArray[i]=='4' ||
					charArray[i]=='5' || charArray[i]=='6' || charArray[i]=='7' || charArray[i]=='8' || charArray[i]=='9')
			{
				//do nothing
			}
			else
			{
				System.out.println("Input is invalid. Please enter a valid input again:");
				Scanner sc = new Scanner(System.in);
				str = sc.next();
				checkStr(str);
				break;
			}
		}
	}
}
