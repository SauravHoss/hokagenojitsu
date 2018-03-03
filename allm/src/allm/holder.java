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
				mergeSort(test);
				long end = System.nanoTime();
				long time = end - start;
				System.out.println("Final: "+Arrays.toString(mergeSort(test)));
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
				long time = end - start;
				System.out.println("Final: " + Arrays.toString(test));
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
				long time = end - start;
				System.out.println("Final: " + Arrays.toString(test));
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
				long time = end - start;
				System.out.println("Final: " + Arrays.toString(test));
				System.out.println("Time Taken: "+ time + " nanoseconds");			
				System.out.print("Fully Sorted? ");
				checker(test);
	*/
				
	/*
	 			//Quicksort Test
				System.out.println("Original: "+Arrays.toString(test));
				long start = System.nanoTime();
				holder.quickSort(test, 0, test.length-1); 
				long end = System.nanoTime();
				long time = end - start;
				System.out.println("Final : " +Arrays.toString(test));
				System.out.println("Time Taken: "+ time + " nanoseconds");
				checker(test);
	*/
	
	/*			
				//Quicksort Test
				System.out.println("Original: "+Arrays.toString(test));
				long start = System.nanoTime();
				quickSortd(test, 0, test.length-1);
				medf(test);
				long end = System.nanoTime();
				long time = end - start;
				System.out.println("Final : " +Arrays.toString(test));
				System.out.println("Median: "+medf(test));
				System.out.println("Time Taken: "+ time + " nanoseconds");
				checker(test);
				System.out.println(mc(test));
	*/			
				
				System.out.println("Original: "+Arrays.toString(test));
				long start = System.nanoTime();
				countingSortattempt(test, 100000);
				long end = System.nanoTime();
				long time = end - start;
				System.out.println("Final : " +Arrays.toString(countingSortattempt(test, 100000)));
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
	//QUICKSORT
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
	//QUICKSORT (DANIEL)
		public static void quickSortd(int[] list1, int front, int back)
		{
			if(front<back)
			{
				int pivotPos = partition(list1, front, back);
				quickSort(list1, front, pivotPos-1);
				quickSort(list1, pivotPos+1, back);
			}
		}

		public static int partitiond(int[] a, int l, int r) 
		{
		    int tmp;
		    int pivot = a[l];
		    tmp = a[r];
		    a[r] = a[l];
		    a[l]=tmp;

		    int wall=l;
		    int pcount=1;
		    for (int i=l;i<r;i++) 
		    {
		        if (a[i]<pivot) 
		        {
		            tmp = a[i];
		            a[i]=a[wall];
		            a[wall]=tmp;
		            wall++;
		        }
		        if (a[i]==pivot)
		            pcount++;
		    }
		    // now copy over all the pivots
		    int rwall=wall;
		    tmp = a[rwall];
		    a[wall]=a[r];
		    a[r]=tmp;
		    rwall++;
		    for (int i=rwall+1;i<=r;i++) 
		    {
		        if (a[i]==pivot) 
		        {
		            tmp = a[rwall];
		            a[rwall]=a[i];
		            a[i]=tmp;
		            rwall++;
		        }
		    }
		    return (wall+rwall)/2;
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Counting Sort
		public static int [] countingSortattempt(int [] arr, int full)
		{
			
			int [] hope = new int [full + 1];
			int [] please = new int [arr.length];
			int x = 0;
			
			
			for(int i = 0; i <= full; i++)
			{
				hope [i] = 0;
			}
			
			for(int i = 0; i < arr.length; i++) 
			{
				hope[arr[i]]++;
			}
		
			for(int i = 0; i <= full; i++) 
			{
				for(int j = 0; j < hope[i]; j++)
				{
					please[x++] = i;
				}	
			}
			
			return please;
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
		
		//median finder
		public static int medf(int [] arr)
		{
			int ans;
			if(arr.length%2==0)
			{
				ans = ((arr[(arr.length/2) - 1] + arr[(arr.length/2)])/2) ; 
			}
			else
				ans = arr[(arr.length/2)];
			return ans;
		}
		
		//medianchecker
		public static int mc(int [] arr)
		{
			
			int a = ((arr[4999] + arr[5000])/2);
			return a;
		}
		
		
}
