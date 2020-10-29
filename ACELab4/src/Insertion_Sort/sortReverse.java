package Insertion_Sort;

public class sortReverse {
	public long startTime;
	public long endTime;
	public void reverse(int[] arr) {
		System.out.println("Reversing...");
		startTime=System.currentTimeMillis();

		int i, j;
	    int key;
	    for(j = 1; j < arr.length; j++)
	    {
	        key = arr[j];
	        i = j - 1;
	        while(i >= 0 && arr[i] < key)
	        {
//	        	System.out.println("Comparing... "+arr[i]+", "+key+". "+(arr.length-j)+" numbers left");
	            arr[i+1] = arr[i];
	            i--;
	        } 
	        arr[i+1] = key;
	    }
		endTime=System.currentTimeMillis();

	}
}
