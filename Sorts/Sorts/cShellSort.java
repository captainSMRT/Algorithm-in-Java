package Sorts;

import java.util.Arrays;

public class cShellSort {
	 public static void sort(int[] array) {
		    int index;
		    int incre = 1;
		    while (incre <= array.length / 3) {
		      incre = incre * 3 + 1;
		    }
		    while (incre > 0) {
		      for (index = incre; index < array.length; index++) {
		    	  insertionSort(index, incre, array);
		      }
		      incre = (incre - 1) / 3;
		    }
	 }
	 
	public static void insertionSort(int index, int increment, int[] array){
			int temp = array[index];
			int inner = index;
			while (inner > increment - 1 && array[inner - increment] >= temp) {
				array[inner] = array[inner - increment];
				inner -= increment;
	        }
	        array[inner] = temp;
	}
	public static void main(String[] args) {
		  
		    int [] array = {5,3,0,2,4,1,0,5,2,3,1,4}; 
		    System.out.println("Before: " + Arrays.toString(array));
		    sort(array);
		    System.out.println("After:  " + Arrays.toString(array));
		 
		  }
}
