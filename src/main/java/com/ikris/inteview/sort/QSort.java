package com.ikris.inteview.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QSort {
	
	
	public void sort(int[] lis,int l,int r){
		if(l<r){
			int q = partition(lis,l,r);
			sort(lis,l,q);
			sort(lis,q+1,r);
		}
	}
	
	
	public int partition(int[] l,int low,int hight){
		int guard = l[low];
		while(low < hight){
			while(low<hight && l[hight]>=guard) hight--;
			l[low] = l[hight];
			while(low<hight && l[low]< guard) low++;
			l[hight] = l[low];
		}
		l[low] = guard;
		return low;
	}
	
	private void swap(int[] l ,int a,int b){
		int tmp = l[a];
		l[a] = l[b];
		l[b] = tmp;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList();
		int n = 10;
		Random r = new Random();
		int[] l = new int[n];
		n--;
		while(n>0){
			l[n--] = r.nextInt(50);
		}
		System.out.println(Arrays.toString(l));
		new QSort().sort(l,0,l.length-1);
		System.out.println(Arrays.toString(l));
//		Arrays.sort(a);
		
	}

}
