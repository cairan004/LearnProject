package Basic;

import java.awt.image.AreaAveragingScaleFilter;

public class SelectionSort {
	public static void main(String args[]) {
		int []intArray = {4,6,2,1,8,10,5,7,9,3};
		int keyValue;
		int index;
		int temp;
		System.out.println("排序前的数组");
		for(int i=0;i<intArray.length;i++) {
			System.out.println(intArray[i]+" ");
		}
			for(int i=0;i<intArray.length;i++) {
			 index = i;
			 keyValue = intArray[i];
			 for(int j =i;j<intArray.length;j++) {
				 if(intArray[j]<keyValue) {
					 index = j;
					 keyValue = intArray[j];
				 }
				 temp = intArray[i];
				 intArray[i] = intArray[index];
				 intArray[index] = temp;
			 }
			}
			 System.out.println("排序后的数组：");
			 for(int i=0;i<intArray.length;i++) {
				 System.out.println(intArray[i]);
	}
}
}
