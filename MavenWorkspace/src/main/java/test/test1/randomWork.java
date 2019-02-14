package test.test1;

import java.util.Random;

public class randomWork {
	public static void main (String[]args) {
		int[]n= {1,3,6,9,11,18,20,27,39,50,78,4,1,2,3,4,4,2,45,2,3,23,2,32,3,23,2,3,23,23,23,2,3,4,4,2,3,34,1,2,3,3,54,6,7,3,3,2,3,4,2,3,3,3,3,3,3,3,3,3
				,3,4,467,3453,453,45,3,445,4,53,45,3};
		Random rnd = new Random();
		int count=0;
		while(count<3) {
			int gamble=rnd.nextInt(n.length);
			if(n[gamble]==4) {
				count++;
			}
		}
		System.out.println("done");
		//System.out.println(binarySearch(n, 18));
		
		
	}
	public static int binarySearch(int[]n,int x) {
		int start=0;
		int end = n.length-1;
		int q=0;
		while((int)Math.sqrt((double)n.length)+1>q) {
			int mid = ((end-start)/2)+start;
			
			if(n[mid]==x) {
				return mid;
			}else if(n[mid]>x) {
				end=mid-1;
				
			}else if(n[mid]<x) {
				start=mid+1;
			}
			q++;
		}
		
		System.out.println("Element is not present");
		return -1;
	}
	public static void mergeSort(int[]n,int start, int end) {
		
		
		if(start<end) {
			
			int mid = ((end-start)/2)+start;
			
			mergeSort(n,start, mid);
			mergeSort(n,mid+1,end);
			
			
		}
		
	}

	public static int[] merge(int[]n, int start, int mid, int end){
		
		
		
		return null;
	}
	
	
}
