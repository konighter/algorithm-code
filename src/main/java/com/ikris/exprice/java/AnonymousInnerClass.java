package com.ikris.exprice.java;

public class AnonymousInnerClass {
	
	public static abstract class A  implements EXA{
		public void print(){
			System.out.println(this.getClass().getName());
		}
	}
	
	
	public static class B extends A{
		public void print(){
			super.print();
			System.out.println(this.getClass().getName());
		}

		@Override
		public void printEXA() {
			System.out.println("method in interface");
			
		}
	}
	
	public interface EXA{
		public void printEXA();
	}
	
	public void execute(A a){
		a.print();
		a.printEXA();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnonymousInnerClass clazz = new AnonymousInnerClass();
		clazz.execute(new B(){

			@Override
			public void print() {
				super.print();
				System.out.println("content in AnonymousInnerClass");
			}
			
		});
	}

}
