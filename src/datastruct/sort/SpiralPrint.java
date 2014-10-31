package datastruct.sort;

import datastruct.Util;

public class SpiralPrint {
	
	public static void print(int[][] l){
		for(int i=0;i<l.length;i++){
			if(i%2==0) Util.printList(l[i]);
			else Util.printListRevert(l[i]);
		}
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] l = Util.RandIntBinaryList(4, 5);
		Util.printList(l);
		System.out.println("#################");
		print(l);
	}

}
