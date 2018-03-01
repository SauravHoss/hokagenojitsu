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
	/*			
				//Mergesort Test
				System.out.println("Original: "+Arrays.toString((test)));
				long start = System.nanoTime();
				System.out.println("Final: "+Arrays.toString(mergeSort(test)));
				long end = System.nanoTime();
				long time = end - start;
				System.out.println("Time Taken: "+ time + " nanoseconds");			
				System.out.print("Fully Sorted? ");
				checker(mergeSort(test));
	*/			
	
	/*
				//Bubble Test
				System.out.println("Original: "+Arrays.toString((test)));
				long start = System.nanoTime();
				bubble(test);
				long end = System.nanoTime();
				System.out.println("Final: " + Arrays.toString(test));
				long time = end - start;
				System.out.println("Time Taken: "+ time + " nanoseconds");			
				System.out.print("Fully Sorted? ");
				checker(test);
	*/			
				
	/*			
	 			//Selection Test
				System.out.println("Original: "+Arrays.toString((test)));
				long start = System.nanoTime();
				select(test);
				long end = System.nanoTime();
				System.out.println("Final: " + Arrays.toString(test));
				long time = end - start;
				System.out.println("Time Taken: "+ time + " nanoseconds");			
				System.out.print("Fully Sorted? ");
				checker(test);
	*/			
				
	/*			
	 			//Insertion Test
				System.out.println("Original: "+Arrays.toString((test)));
				long start = System.nanoTime();
				insert(test);
				long end = System.nanoTime();
				System.out.println("Final: " + Arrays.toString(test));
				long time = end - start;
				System.out.println("Time Taken: "+ time + " nanoseconds");			
				System.out.print("Fully Sorted? ");
				checker(test);
	*/
				
				//Quicksort Test
				long start = System.nanoTime();
				System.out.println("Original: "+Arrays.toString(test));
				holder.quickSort(test, 0, test.length-1); 
				System.out.println("Final : " +Arrays.toString(test));
				long end = System.nanoTime();
				long time = end - start;
				System.out.println("Time Taken: "+ time + " nanoseconds");
				checker(test);
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
	//BUBBLE SORT	
		public static void bubble(int [] test) 
		{
			int counter = 5;
			while(counter > 0) 		
			{
				counter = 0;
				for(int j = 0; j < test.length-1; j++) 
				{
					if(test[j] > test[j+1])
					{
						swapperi(test, j, j+1);
						counter++;
					}
				}
			}	
		}	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//SELECTION SORT
		public static void select(int[] test) 
		{
			for(int i = 0; i < test.length-1; i++) 
			{
				double min = test[i];
				int cf = i;
					for(int j = i; j < test.length; j++) 
					{
						if(test[j] < min) 
						{
							min = test[j];
							cf = j;
						}
					}
					if(min < test[i]) 
					{
						swapperi(test, i, cf);
					}
			} 	
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//INSERTION SORT
		public static void insert(int [] test) 
		{			
	        for (int i = 1; i < test.length; i++) 
	        {
	            for(int j = i ; j > 0 ; j--)
	            {
	                if(test[j] < test[j-1])
	                {
	                   swapperi(test,j,(j-1));
	                }
	            }
	        }
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Quick Sort
		//Takes an array of integers and sorts them to be chronological 
		public static void quickSort(int arr[], int low, int high)
		 {
		     if (low < high)
		     {
		         int pi = partition(arr, low, high);
		         
		         quickSort(arr, low, pi-1);
		         quickSort(arr, pi+1, high);
		     }
		 }
		
		public static int partition(int[] list, int front,int back) 
		 {
			 int low = front + 1;
		     int pivot = list[front];

		     while (back > low) 
		     {
		    	 while (low <= back && list[low] <= pivot) 
		    	 {
		    		 low++;
		    	 }
		         while (low <= back && list[back] > pivot) 
		         {
		        	 back--;
		         }
		         if (back > low) 
		         {
		        	 swapperi(list,back,low);
		         }
		     }

		     while (back >= low && list[back] >= pivot)
		     {
		    	 back--;   
		     }
		     if (back > front)
		     {
		    	 swapperi(list,back,front);
		    	 return back;
		     } 
		     else   
		     {
		    	 return front;
		     }
		 }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//HELPERS
		//Swaps two items in an array of integers
		public static void swapperi(int [] arr, int x, int y) 
		{
			int holder = arr[x];
			arr[x] = arr[y];
			arr[y] = holder;	
		}
		
		//Checks if array is sorted
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
			System.out.println(poo);
		}
}
