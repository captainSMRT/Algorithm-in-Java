package Sorts;

import java.util.Arrays;

public class zSortingPractice{
	
	public static void main(String[] args){
		   int [] array = {5,3,0,2,4,1,0,5,2,3,1,4}; 
		    System.out.println("Before: " + Arrays.toString(array));
		    shellSort(array);
		    System.out.println("After:  " + Arrays.toString(array));
		 
	}
	
	public static void shellSort(int[] array){
		int increment = 1;
		
		while(increment <= array.length/3){
			increment = 3 * increment + 1;
		}
		
		while(increment>0){
			for(int i = increment; i < array.length; i ++){
				insertionSort(i, increment, array);
			}
			increment = (increment -1 ) / 3;
		}
	}
	
	public static void insertionSort(int index, int increment, int[] array){
		int temp = array[index];
		int tempIndex = index;
		
		while(tempIndex > increment-1 && array[tempIndex-increment] >= temp){
			array[tempIndex] = array[tempIndex - increment];
			tempIndex = tempIndex - increment;
			
		}
		array[tempIndex] = temp;
	}
}



/*
		int temp = array[index];
			int inner = index;
			while (inner > increment - 1 && array[inner - increment] >= temp) {
				array[inner] = array[inner - increment];
				inner -= increment;
	        }
	        array[inner] = temp;


*/