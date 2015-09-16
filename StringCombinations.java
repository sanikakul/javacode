package javarevisitedpackage;

import java.util.ArrayList;
import java.util.Scanner;

public class StringCombinations
{
	private static char[] inputArr;
	
	private static ArrayList<Character> stable = new ArrayList<Character>();
	private static ArrayList<Character> variable = new ArrayList<Character>();
	
	public static void main(String[] args)
	{
		String input = "12345";
		int temp;
		/*System.out.println("Enter a string: ");
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();*/
		
		inputArr = input.toCharArray();
		
		popStable();
		for(int i=2; i<6; i++)
		{
		temp = i;
		recursion(temp);
		}
	}

	private static void popStable()
	{
		for(int i=0; i<inputArr.length; i++)
		{
			stable.add(inputArr[i]);
		}
	}

	private static void recursion(int temp)
	{
		int original = temp;
		for(int i=(inputArr.length-temp); i<stable.size(); temp++)
		{
			stable.remove(i);
		}
		System.out.println(stable);
		popVariable(original);
	}

	private static void popVariable(int temp)
	{
		int original = temp;
		for(int i=(inputArr.length - temp); i<inputArr.length; i++)
		{
			variable.add(inputArr[i]);
		}
		System.out.println(variable);
		mix(original);
		variable.removeAll(variable);
	}

	private static void mix(int temp)
	{
		if(variable.size()==2)
		{
			join();
			char now = variable.get(0);
			variable.remove(0);
			variable.add(now);
			join();
		}
		else
		{
			for(int i=temp; i<inputArr.length; i++)
			{
				System.out.println(temp);
			}
		}
	}

	private static void join()
	{
		String output = "";
		for(int i=0; i<stable.size(); i++)
		{
			output = output + stable.get(i);
		}
		for(int i=0; i<variable.size(); i++)
		{
			output = output + variable.get(i);
		}
		System.out.println(output);
	}	
}
