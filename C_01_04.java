package javaprogramming;

import java.util.Arrays;

public class C_01_04
{
	private static char[] newArr;
	public static void main(String[] args)
	{
		String str = "abcdef"; 
		int fac = (6*5*4*3*2*1);
		//System.out.println(fac);
		
		newArr = str.toCharArray();
		//System.out.println(Arrays.toString(newArr));
		
		for(int i=0; i<newArr.length; i++)
		{
			System.out.println(newArr[i]);
		}
		
		for(int i=1; i<newArr.length; i++)
		{
			
		}
	}

}
