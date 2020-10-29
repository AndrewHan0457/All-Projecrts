/*
 * @author: 		Yeda Han
 * @author ID:	16515800
 * 
 * */
package Insertion_Sort;// if this line cause, please get it in comment.

public class Insertsort {

	public int[] A; // The array to store original array to access.
	public long startTime;
	public long endTime;
	// Constructor
	public Insertsort(int[] A) {
		this.A = A;
		int length = A.length;
		insertion_sort(A, length);
	}

	/*
	 * Reference: alan_forever (2012) provided the resource code that is available at
	 * https://www.cnblogs.com/alan-forever/p/3294511.html
	 * Accessed: 5 November 2018
	*/
	public void insertion_sort(int A[], int length){
		System.out.println("Sorting...");
		startTime=System.nanoTime();

	    int i, j;
	    int key;
	    for(j = 1; j < length; j++)
	    {
	        key = A[j];
	        i = j - 1;
	        while(i >= 0 && A[i] > key){
//	        	System.out.println("Comparing... "+A[i]+", "+key+". "+(A.length-j)+" numbers left");

	            A[i+1] = A[i];
	            i--;
	        }
	        A[i+1] = key;
	    }
		endTime=System.nanoTime();

	}
	
	//Output this Class using toString() method below.
	@Override
	public String toString() { //The format that the instance of Insertsort should be print in.
		String str = "";
		for(int i=0;i<this.A.length;i++) {
			str = str +" "+ new Integer(A[i]).toString();
		}
		return this.getClass()+" [" +str.trim()+ "]";
	}
}
