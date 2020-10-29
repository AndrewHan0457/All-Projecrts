package Insertion_Sort;

import java.util.Random;

public class testInsertSort {
	public static void main(String[] args) {
		int[] arr = new int[400000];
		
		Random ran = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(100000);
		}
		sortReverse sr = new sortReverse();
		sr.reverse(arr);
		System.out.println("Process reversesort running time: "+ (sr.endTime-sr.startTime)+"ms");
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		System.out.println();
//		long startTime=System.currentTimeMillis();
		Insertsort is = new Insertsort(arr);
//		long endTime=System.currentTimeMillis(); 
		Insertsort is2 = new Insertsort(arr);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(is.A[i]);
//		}
		System.out.println("Process worst-case insertsort running time: "+(long)(is.endTime-is.startTime)/1000000+"ms");;
		System.out.println("Process best-case insertsort running time: "+(long)(is2.endTime-is2.startTime)+"ns");;
	}
	
}
