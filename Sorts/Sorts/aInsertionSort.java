package Sorts;

import java.util.Arrays;

public class aInsertionSort {
	public static void main(String[] args) {
	    int [] array = {8,21,32,34,51,64}; // 0 0 2 4 5 5 7 8 8 
	    System.out.println("Before: " + Arrays.toString(array));
	    insertionSort(array);
	    System.out.println("After:  " + Arrays.toString(array));
	  }
	
	public static void insertionSort(int[] array){
		int index,indexValue;
		for (int i = 1; i < array.length; i++){
			index = i;
			//												System.out.print("index: " + index);
			indexValue = array[i]; // first value of unsorted
				//											System.out.print("	|	indexValue: " + indexValue);
					//										System.out.println();
			while(index>0 && indexValue<array[index-1]){
															System.out.println("Test Before: " + Arrays.toString(array));
				array[index] = array[index-1];
				//										System.out.println("Test After Change: " + Arrays.toString(array));
				index--;
			}
			array[index] = indexValue;
															System.out.println("Test Final: " + Arrays.toString(array));
		}
	}
}
