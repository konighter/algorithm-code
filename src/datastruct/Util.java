package datastruct;

import java.util.Arrays;
import java.util.Random;

public class Util {
	public static Random r = new Random();
	public static int[] RandomIntList(int n ){
		Random r = new Random();
		int[] l = new int[n];
		n--;
		while(n>0){
			l[n--] = r.nextInt(50);
		}
		return l;
	}
	
	public static void printList(int[] l){
		System.out.println(Arrays.toString(l));
	}
	
	public static void printListRevert(int[] l){
		int len = l.length - 1;
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i=len; i>=0; i--){
			sb.append(l[i]);
			if(i > 0) sb.append(", ");
		}
		
		sb.append("]");
		System.out.println(sb.toString());
	}
	
	public static void printList(int[][] l){
		for(int i=0; i<l.length; i++){
			printList(l[i]);
		}
	}
	
	public static int[][] RandIntBinaryList(int h,int l){
		int[][] lis = new int[h][l];
		for(int i=0; i<h; i++){
			lis[i] = RandomIntList(l);
		}
		return lis;
	}
	
	public static int randomInt(){
		return r.nextInt(100);
	}
	
	public static TreeNode RandomBinaryTree(int h){
		if(h > 0 ){
			TreeNode root = new TreeNode(randomInt());
			root.left = RandomBinaryTree(h-1);
			root.right = RandomBinaryTree(h-1);
			return root;
		}else
			return null;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
