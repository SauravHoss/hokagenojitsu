package allm;
import java.util.Arrays;
import java.util.Random;

public class holder 
{

	public static void main(String[] args) 
	{
				//Testing Array Generator
				Random rnd = new Random();
				int n = 10000;
				int test [] = new int[n];
				for (int i = 0; i < n; i++) 
				{
					test[i] = rnd.nextInt(100000);
				}
				
				//Mergesort Test
				System.out.println("Original: "+Arrays.toString((test)));
				long start = System.nanoTime();
				System.out.println("Final: "+Arrays.toString(mergeSort(test)));
				long end = System.nanoTime();
				long time = end - start;
				System.out.println("Time Taken: "+ time + " nanoseconds");			
				checker(mergeSort(test));
				
				
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//MERGE SORT
	
	//Case Sensitive Merge Sort (Caps go before lowercase)
		public static int [] mergeSort(int [] list) 
		{
			if(list.length == 1)
			{
			return list;
			}
			else
			{
			int [] l = Arrays.copyOfRange(list,0,list.length/2);
			int [] r = Arrays.copyOfRange(list,list.length/2, list.length);
			return(merge(mergeSort(l),mergeSort(r)));
			}
		}
		
		public static int [] merge(int [] list1, int [] list2) 
		{
			//Precondition : Both lists are sorted
			//Takes two arrays and merges them in ascending order
		
			int [] full = new int [(list1.length) + (list2.length)]; //i made it work but am confused about why its minus 1 and not 2
			
			int j = 0;
			int l = 0;
			int r = 0;
			
			while(l < list1.length && r < list2.length && j < full.length) 
			{
				if (list1[l]>=(list2[r]))
				{
					full[j] = list2[r];
					j++;
					r++;
				}			
				else
				{
					full[j] = list1[l];
					j++;
					l++;
				}
			}
			
			while(j < full.length && l < list1.length) 
			{
				full[j] = list1[l];
				j++;
				l++;
			}
			
			while(j < full.length && r < list2.length) 
			{
				full[j] = list2[r];
				j++;
				r++;
			}
			return full;
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//HELPERS
		 
		//Swaps two items in an array of integers
		public static void swapperi(int [] arr, int x, int y) 
		{
			int holder = arr[x];
			arr[x] = arr[y];
			arr[y] = holder;	
		}
		
		//Swaps two items in an array of doubles
		public static void swapperd(double [] arr, int x, int y) 
		{
			double holder = arr[x];
			arr[x] = arr[y];
			arr[y] = holder;	
		}
		
		//Swaps two items in an array of Strings
		public static void swappers(String[] test, int x, int y) 
		{
			String holder = test[x];
			test[x] = test[y];
			test[y] = holder;
		}
		
		public static void checker(int [] a) 
		{
			boolean poo = true;
			for (int i = 0; i < a.length - 1; i++) 
			{
				if (a[i] > a[i + 1]) 
			    {
					poo = false;
					break;
			    }
			}
			System.out.print(poo);
		}
}

	

