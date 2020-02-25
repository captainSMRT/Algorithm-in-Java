package Sorts;

import java.util.Arrays;

public class bSelectionSort {
	
	public static void main(String[] args) {
	    int [] array = {7,6,5,4,3,2,1}; // 0 0 2 4 5 5 7 8 8 
	    System.out.println("Before: " + Arrays.toString(array));
	    selectionSort(array);
	    System.out.println("After:  " + Arrays.toString(array));
	  }
	
	public static int[] selectionSort (int[] array){
		int i, min;
		for(i = 1; i < array.length; i++){
			min = minKeyIndex(i-1, array.length-1, array);
			swap(min,i-1,array);
		}
		return array;
	}
	
	public static int minKeyIndex(int lowerbound, int upperbound, int[]array){
		int minIndex;
		minIndex = lowerbound;
		for(int i = lowerbound + 1; i <= upperbound; i++){
			if(array[minIndex]>array[i]){
				minIndex=i;
			}
		}
		return minIndex;
	}
	
	public static void swap(int i, int j, int[] array){
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
