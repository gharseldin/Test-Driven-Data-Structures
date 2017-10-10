import java.util.Arrays;

public class Sorting {
	
	public <T> T[] insertionSort(T[] input){
		T[] sortedArray = Arrays.copyOf(input, input.length);
		for(int i=1; i< sortedArray.length; i++){
			for(int j = 0; j<i ; j++){
				if((int)sortedArray[i] < (int)sortedArray[j]){ 
					// then we have an insertion point
					T temp = sortedArray[j];
					sortedArray[j] = sortedArray[i];
					for (int k = i; k> j; k--){
						sortedArray[k] = sortedArray[k-1];
					}
					sortedArray[j+1] = temp;
				}
			}
		}
		return  sortedArray;
	}
	
	public <T> T[] moreEfficientInsertionSort(T[] input){
		T[] sortedArray = Arrays.copyOf(input, input.length);
		int n = input.length;
		for(int i=1; i<n; i++){
			T temp = input[i];
			for(int j = i; j>0; j--){
				if((int)sortedArray[j-1] > (int)temp){
					sortedArray[j] = sortedArray[j-1];
					sortedArray[j-1] = temp;
				}
			}
		}
		return sortedArray;
	}
	
	public static void main (String args[]){
		Sorting sort = new Sorting();
		Integer[] testArray = {12, 14, 15, 1, 7};
		System.out.println(Arrays.toString(sort.insertionSort(testArray)));
		System.out.println(Arrays.toString(sort.moreEfficientInsertionSort(testArray)));
		
	}
	
	
}
