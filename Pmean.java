package practiceproblems;

public class Pmean {
	
	public static void main(String[] args){
		int[] input = {20, 30, 10, 5};
		int output = maxPMEAN(input);
		System.out.println(output);
	}

	private static int maxPMEAN(int[] input) {
		int pmean=0, best=0, k=0;
		for(int j=0; j<input.length; j++){
			for(int i=j; i<input.length+j; i++){
				if(i>input.length-1){
					k=input.length;
				}
				pmean = pmean+input[i-k]*(i-j+1);
			}
			System.out.println(pmean);
			if(best<pmean){
				best=pmean;
			}
			pmean=0;
			k=0;
		}
		return best;
	}
}
