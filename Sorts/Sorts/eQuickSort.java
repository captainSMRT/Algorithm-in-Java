package Sorts;
import java.util.Arrays;

public class eQuickSort {
	public static void main(String[] args) {
		//int[] x = {86,16,82,91,60,02,38,45,07,32,78,83,12,16,56,64,78,80,95,94 };
		int[] x = {5,4,3,2,1};
		System.out.println(Arrays.toString(x));
 
		int low = 0;
		int high = x.length - 1;
 
		quickSort(x, low, high);
		System.out.println(Arrays.toString(x));
	}
 
	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0){
			return;
		}
		
		if (low >= high){
			return;
		}
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
		// make left < pivot and right > pivot
		int i = low, j = high;
		
		while (i < j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}
}