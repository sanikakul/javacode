package randomproblems;

/*
 * 
 * Given an unsorted int array which may or may not have repeated elements in it,
 * write a method to return all the most frequently occurring element.
 * 
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MostFrequent
{
	private static ArrayList<HashSet<Integer>> frequency = new ArrayList<HashSet<Integer>>();
	private static HashSet<Integer> temp = new HashSet<Integer>();
	public static void main(String[] args)
	{	
		int[] intArray = {1, 2, 3, 4, 5, 6};
		
		for(int i=0; i<intArray.length; i++)
		{
			if(frequency.isEmpty())
			{
				populateHS(i, intArray);
				frequency.get(0).addAll(temp);
			}
			else
			{
				int temp = 0;
				populateAL(temp, i, intArray);
			}
		}
		
		System.out.println(frequency);
	}
	private static void populateHS(int i, int[] intArray)
	{
		temp.add(intArray[i]);
	}
	
	private static void populateAL(int temp, int i, int[] intArray)
	{
		for(int j=temp; j<frequency.size(); j++)
		{
			if(frequency.get(j).contains(intArray[i]))
			{
				if(j==(frequency.size()-1))
				{
					frequency.get(j+1).add(intArray[i]);
				}
				else
				{
					populateAL(temp + 1, i, intArray);
				}
			}
			else
			{
				frequency.get(j).add(intArray[i]);
			}
		}
	}
}
