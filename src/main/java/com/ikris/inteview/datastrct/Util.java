package com.ikris.inteview.datastrct;

import java.io.IOException;
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
	
	public static LinkedNode RandomLinkedList(int l){
		if(l<=0) return null;
		LinkedNode head = new LinkedNode();
		LinkedNode cur  = head;
		head.value = r.nextInt(50);
		for(int i=0;i<l-1;i++){
			LinkedNode node = new LinkedNode();
			node.value = r.nextInt(50);
			cur.next = node;
			cur = node;
		}
		return head;
	}
	
	public static  LinkedNode RandomIncLinkedList(int l){
		if(l<=0) return null;
		int init = r.nextInt(50);
		LinkedNode head = new LinkedNode();
		head.value = init++;
		LinkedNode cur  = head;
		for(int i=0;i<l-1;i++){
			LinkedNode node = new LinkedNode();
			node.value = init++;
			cur.next = node;
			cur = node;
		}
		return head;
	}
	
	public static void printLinkedList(LinkedNode head){
		LinkedNode cur = head;
		while(cur != null){
			System.out.print(cur.value+"->");
			cur = cur.next;
		}
		System.out.println();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printLinkedList(RandomLinkedList(5));
		printLinkedList(RandomIncLinkedList(5));
		IOException e = new IOException();
	}

}
