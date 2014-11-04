package com.ikris.exprice.java;

public class ClazzLoader {
	public static class HelloWorld{
		static{
			System.out.println("static init here");
		}
	}
	
	public static void testThreeClazzLoader(){
		System.out.println("--------------- testThreeClazzLoader");
		ClassLoader cl = HelloWorld.class.getClassLoader();
		System.out.println(cl);
		System.out.println(cl.getParent());
		System.out.println(cl.getParent().getParent());
	}
	
	public static void testLoadClazzSequence() throws ClassNotFoundException{
		System.out.println("---------------- testLoadClazzSequence");
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		String clazzName = "com.ikris.exprice.java.ClazzLoader$HelloWorld";
		System.out.println(cl);
		System.out.println("@@@ use ClassLoader.loadClass ------");
		cl.loadClass(clazzName);
		System.out.println("@@@ use Class.forName------");
		Class.forName(clazzName);
		
		
	}
	
	public static void testLoaderTime(){
		System.out.println("---------------- testLoaderTime");
		HelloWorld h = new HelloWorld();
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		testThreeClazzLoader();
//		testLoadClazzSequence();
		testLoaderTime();
	}

}
