package javarevisitedpackage;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveElement
{
	private static String input;
	private static String delChar;
	private static String output ="";
	private static String answer;
	private static ArrayList<Character> nonrepeats = new ArrayList<Character>();
	
	public static void main(String[] args)
	{
		System.out.println("Please enter any string: ");
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		
		allChars();
		
		checkLength();
		
		System.out.println("Please enter the Element to be deleted from '" + input + "': ");
		Scanner an = new Scanner(System.in);
		delChar = an.nextLine();
		
		checkValidity();
		
		deleteElement();
		
		System.out.println("After deleting " + delChar + " from '" + input + "' : " + output);
		
		recursion();
		
	}

	private static void checkLength()
	{
		if(nonrepeats.size()==0)
		{
			System.out.println("There are no elements left to be deleted!");
			System.exit(0);
		}
		else
		{
			//do nothing
		}
	}

	private static void recursion()
	{
		System.out.println("Do you want to delete another character?(Yes/No): ");
		Scanner ner = new Scanner(System.in);
		answer = ner.next();
		
		if(answer.equals("Yes") || answer.equals("yes") || answer.equals("No") || answer.equals("no"))
		{
			if(answer.equals("No") || answer.equals("no"))
			{
				System.exit(0);
			}
			else
			{
				input = output;
				output = "";
				checkLength();
				System.out.println("Please enter the Element to be deleted from '" + input + "': ");
				Scanner an = new Scanner(System.in);
				delChar = an.nextLine();
				checkValidity();
				deleteElement();
				System.out.println("After deleting " + delChar + " from '" + input + "' : " + output);
				
				recursion();
			}
		}
		else
		{
			System.out.println("Invalid input. Pleas enter 'Yes' or 'No': ");
			Scanner sn = new Scanner(System.in);
			answer = sn.next();
			recursion();
		}
			
	}

	private static void deleteElement()
	{
		char[] charArray = input.toCharArray();
		char[] delchar = delChar.toCharArray();
		for(int i=0; i<charArray.length; i++)
		{
			if(charArray[i]==delchar[0])
			{
				//do nothing
			}
			else
			{
				output = output + charArray[i];
			}
		}
		
		for(int i=0; i<nonrepeats.size(); i++)
		{
			if(nonrepeats.get(i)==delchar[0])
			{
				nonrepeats.remove(i);
				break;
			}
			else
			{
				//do nothing
			}
		}
	}

	private static void checkValidity()
	{
		char[] charArray = delChar.toCharArray();
		if(charArray.length>1)
		{
			System.out.println("Please enter only one character.");
			System.out.println("Please enter a single character that is to be deleted from the input: ");
			Scanner an = new Scanner(System.in);
			delChar = an.nextLine();
			checkValidity();
		}
		else
		{
			for(int i=0; i<nonrepeats.size(); i++)
			{
				if(charArray[0]==nonrepeats.get(i))
				{
					break;
				}
				else
				{
					if(i==(nonrepeats.size()-1))
					{
						System.out.println("Character entered has no occurence in the input.");
						System.out.println("Please enter a new character that is to be deleted from the input: ");
						Scanner an = new Scanner(System.in);
						delChar = an.next();
						checkValidity();
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

	private static void allChars()
	{
		char[] charArray = input.toCharArray();
		for(int i=0; i<charArray.length; i++)
		{
			if(i==0)
			{
				nonrepeats.add(charArray[i]);
			}
			else
			{
				for(int j=0; j<nonrepeats.size(); j++)
				{
					if(charArray[i]==nonrepeats.get(j))
					{
						break;
					}
					else
					{
						if(j==(nonrepeats.size()-1))
						{
							nonrepeats.add(charArray[i]);
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
