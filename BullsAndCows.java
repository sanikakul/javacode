package practiceproblems;

import java.util.Arrays;
import java.util.Scanner;

public class BullsAndCows
{
	private static String answer, finalInput;
	private static int bulls=0, cows=0;
	public static void main(String[] args)
	{
		String input;
		char[] input_char;
		System.out.println("Enter a word: ");
		Scanner sc_input = new Scanner(System.in);
		input = sc_input.next();
		finalInput = input;
		input = input.toLowerCase();
		input_char = input.toCharArray();
		
		System.out.println("Guess (Not case sensitive): ");
		Scanner sc_answer = new Scanner(System.in);
		answer = sc_answer.next();
		answer = answer.toLowerCase();
		
		compareStrings(input_char, input);
		
	}
	private static void display(char[] input_char, String input, char[] answer_char)
	{
		if(bulls == input_char.length)
		{
			if(input_char.length != answer_char.length)
			{
				System.out.println("Bulls: " + bulls);
				System.out.println("Cows: " + cows);
				System.out.println("Guess again (Enter /x to exit): ");
				Scanner sc_guess = new Scanner(System.in);
				answer = sc_guess.next();
				answer = answer.toLowerCase();
				if(answer.equals("/x"))
				{
					System.out.println("The answer was: " + finalInput + ". You lose!");
					System.exit(0);;
				}
				else
				{
					bulls = 0;
					cows = 0;
					input_char = input.toCharArray();
					compareStrings(input_char, input);
				}
			}
			else
			{
				System.out.println("That's the answer! You won!");
			}
		}
		else
		{
			System.out.println("Bulls: " + bulls);
			System.out.println("Cows: " + cows);
			System.out.println("Guess again (Enter /x to exit): ");
			Scanner sc_guess = new Scanner(System.in);
			answer = sc_guess.next();
			answer = answer.toLowerCase();
			if(answer.equals("/x"))
			{
				System.out.println("The answer was: " + input + ". You lose!");
				System.exit(0);;
			}
			else
			{
				bulls = 0;
				cows = 0;
				input_char = input.toCharArray();
				compareStrings(input_char, input);
			}
		}
	}
	private static void compareStrings(char[] input_char, String input)
	{
		char[] answer_char = answer.toCharArray();
		if(input_char.length == answer_char.length)
		{
			similarity(input_char, answer_char);
		}
		else
		{
			if(input_char.length < answer_char.length)
			{
				similarity(input_char, answer_char);
			}
			else
			{
				similarity(answer_char, input_char);
			}
		}
		display(input_char, input, answer_char);
	}
	private static void similarity(char[] charArr1, char[] charArr2)
	{
		for(int i=0; i<charArr1.length; i++)
		{
			if(charArr1[i] == charArr2[i])
			{
				bulls = bulls + 1;
				charArr2[i] = ' ';
			}
		}
		for(int i=0; i<charArr1.length; i++)
		{
			for(int j=0; j<charArr2.length; j++)
			{
				if(charArr1[i] == charArr2[j])
				{
					cows = cows + 1;
					charArr2[j] = ' ';
					break;
				}
			}
		}
	}
}
