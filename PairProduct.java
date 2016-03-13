/* PairProduct.java
   CSC 225 - Fall 2015
   Adar Guy - V00768164
*/

import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;

//Do not change the name of the PairUp class
public class PairProduct{
	/* PairProduct225()
		The input array A will contain non-negative integers. The function
		will search the array A for a pair of elements which sum to 225.
		If such a pair is found, return true. Otherwise, return false.
		The function may modify the array A.
		Do not change the function signature (name/parameters).
	*/
	public static boolean PairProduct225(int[] a){
		int n = a.length;
		int[] holder = new int[8];
		int[] values = {1, 3, 5, 9, 25, 45, 75, 225};
		for(int x=0; x<n; x++){
			for(int y=1; y<=values.length; y++){
				if(a[x] == values[values.length-y]){
					if(holder[y-1] == values[y-1]){
						return true;
					}
					holder[values.length-y] = a[x];
				}
			}
		}
		return false;
	}
	/*
		int spot = 0;
		for(int x=0; x<n; x++){
			if(a[x] == 225 || a[x] == 1 || a[x] == 25 || a[x] == 9
			|| a[x] == 5 || a[x] == 45 || a[x] == 75 || a[x] == 3){
				if (spot != 0){
					for(int y=0; y<(spot+1); y++){
						if(holder[spot-1]*a[x] == 225){
							return true;
						}
					}
					holder[spot++] = a[x];
				}
				holder[spot] = a[x];
				spot = spot + 1;
			}
		}
		*/
	/* main()
	   Contains code to test the PairProduct225 function. Nothing in this function 
	   will be marked. You are free to change the provided code to test your 
	   implementation, but only the contents of the PairProduct225() function above 
	   will be considered during marking.
	*/
	public static void main(String[] args){
		Scanner s;
		if (args.length > 0){
			try{
				s = new Scanner(new File(args[0]));
			} catch(java.io.FileNotFoundException e){
				System.out.printf("Unable to open %s\n",args[0]);
				return;
			}
			System.out.printf("Reading input values from %s.\n",args[0]);
		}else{
			s = new Scanner(System.in);
			System.out.printf("Enter a list of non-negative integers. Enter a negative value to end the list.\n");
		}
		Vector<Integer> inputVector = new Vector<Integer>();
		
		int v;
		while(s.hasNextInt() && (v = s.nextInt()) >= 0)
			inputVector.add(v);
		
		int[] array = new int[inputVector.size()];
		
		for (int i = 0; i < array.length; i++)
			array[i] = inputVector.get(i);

		System.out.printf("Read %d values.\n",array.length);
		
		
		long startTime = System.currentTimeMillis();
		
		boolean pairExists = PairProduct225(array);
		
		long endTime = System.currentTimeMillis();
		
		double totalTimeSeconds = (endTime-startTime)/1000.0;
		
		System.out.printf("Array %s a pair of values which multiply to 225.\n",pairExists? "contains":"does not contain");
		System.out.printf("Total Time (seconds): %.4f\n",totalTimeSeconds);
	}
}
