package datastruct.sort;

import datastruct.Util;

public class OddEvenRsort {
	
	public static void sort(int[] l){
		int low = 0;
		int hight = l.length -1;
		int tmp = 0;
		while(low < hight){
			
			while(low < hight && isOdd(l[low])) low++;
			while(low < hight && isEven(l[hight])) hight--;
			tmp = l[low];
			l[low] = l[hight];
			l[hight] = tmp;
			Util.printList(l);
		}
		
		System.out.println("low:"+low+",hight:"+hight);
		
	}
	
	private static boolean isOdd(int i) {
		return !isEven(i);
	}

	private static boolean isEven(int i){
		return i%2 == 0;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] l = Util.RandomIntList(10);
		Util.printList(l);
		OddEvenRsort.sort(l);
		Util.printList(l);
	}

}
