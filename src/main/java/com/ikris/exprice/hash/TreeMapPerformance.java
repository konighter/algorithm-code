package com.ikris.exprice.hash;

import java.util.TreeMap;

import com.ikris.exprice.datastrct.Util;

public class TreeMapPerformance {
	static final String MD5_PREFIX = "$MD5";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeMap<Integer,String> tm = new TreeMap<Integer,String>();
		for(String s : new String[]{"A","B","C"}){
			for(int i=0;i<2;i++){
				tm.put(Util.MD5(MD5_PREFIX+i+s).hashCode(), s);
			}
		}
		System.out.println(tm.tailMap(100));;
	}

}
