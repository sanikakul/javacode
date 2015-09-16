package practiceproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SeedNumber {

	public static void main(String[] args)
	{
		int levels, input, output;
		System.out.println("Enter a number: ");
		Scanner sc_input = new Scanner(System.in);
		input = sc_input.nextInt();
		
		System.out.println("How many levels deep do you want to go? ");
		Scanner sc_levels = new Scanner(System.in);
		levels = sc_levels.nextInt();
		sc_input.close();
		sc_levels.close();
		
		for(int z=0; z<levels; z++)
		{
			output = getSeed(input);
			System.out.println("Level " + (z+1) + " Seed: " + output);
			input = output;
		}
		
	}

	private static int getSeed(int input)
	{
		int product, possible_seed;
		int[] all_digits = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		char[] chars = ("" + input).toCharArray();
		int length = chars.length;
		List<Integer> window = new ArrayList<>();
		List<Integer> numbers = new ArrayList<>();
		int counter;
		for(int i=1; i<=length; i++)
		{
			counter = i%9;
			if(i<9)
			{
				numbers.add(i);
			}
			else
			{
				if(counter==0)
				{
					numbers.add(9);
				}
				else
				{
					numbers.add(counter);
				}
			}
		}
		
		for(int m=0; m<numbers.size(); m++)
		{
			for(int i=(numbers.size()-1); i>=0; i--)
			{
				int window_length = (numbers.size() - i);
				for(int j=0; j<all_digits.length; j++)
				{
					if(numbers.get(i)==all_digits[j])
					{
						for(int k=0; k<window_length; k++)
						{
							if((j+k<9))
							{
								window.add(all_digits[j+k]);
							}
							else
							{
								window.add(all_digits[j+k-9]);
							}
						}
					}
					else
					{
						//do nothing
					}
				}
				for(int l=0; l<9; l++)
				{
					for(int k=0; k<window.size(); k++)
					{
						if((window.get(k)+1)>9)
						{
							window.set(k, (window.get(k)+1)-9);
						}
						else
						{
							window.set(k, (window.get(k)+1));
						}
					}
					
					for(int k=0; k<window.size(); k++)
					{
						numbers.remove((numbers.size()-1));
					}
					
					numbers.addAll(window);
					product = getProduct(numbers);
					possible_seed = getPossibleSeed(input, product);
					if(possible_seed == 0)
					{
						//do nothing
					}
					else
					{
						char[] newchar = ("" + possible_seed).toCharArray();
						boolean check = checkDigits(newchar, chars);
						if(!check)
						{
							if(product*possible_seed == input)
							{
								return possible_seed;
							}
						}
					}
				}
				window.removeAll(window);
			}
			numbers.remove((numbers.size() - 1));
		}
		
		return 0;
	}

	private static boolean checkDigits(char[] newchar, char[] chars)
	{
		if(newchar.length != chars.length)
		{
			return false;
		}
		else
		{
			for(int i=0; i<chars.length; i++)
			{
				for(int j=0; j<newchar.length; j++)
				{
					if(chars[i]==newchar[j])
					{
						chars[i]='0';
						newchar[j]='0';
						break;
					}
					else
					{
						//do nothing
					}
				}
			}
			
			for(int i=0; i<chars.length; i++)
			{
				if(chars[i]=='0')
				{
					if(newchar[i]=='0' || newchar[i]=='1')
					{
						//do nothing
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
			return true;
		}
	}

	private static int getPossibleSeed(int input, int product)
	{
		int possible_seed;
		if(input%product == 0)
		{
			possible_seed = input/product;
			return possible_seed;
		}
		else
		{
			return 0;
		}
	}

	private static int getProduct(List<Integer> numbers)
	{
		int product = 1;
		for(int i=0; i<numbers.size(); i++)
		{
			product = product*numbers.get(i);
		}
		return product;
	}

}
