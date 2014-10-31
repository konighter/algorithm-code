package datastruct.sort;

import java.util.Arrays;

import datastruct.Util;

public class BinarySearch {
	
	
	public static int search(int[] lis,int t,int low,int high){
		while(low<=high){
			int mid = (low+high) >>> 1;
			int midV = lis[mid];
			if(midV > t){
				high = mid - 1;
			}else if(midV < t){
				low = mid + 1;
			}else return mid;
		}
		System.out.println(low + ":" + high +"-"+lis[low]);
		return -(low+1);
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] l = Util.RandomIntList(11);
		new QSort().sort(l, 0, l.length -1);
		Util.printList(l);
		System.out.println(BinarySearch.search(l, 5, 0, l.length -1));	
	}

}
