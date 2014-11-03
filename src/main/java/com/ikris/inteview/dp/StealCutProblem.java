package com.ikris.inteview.dp;


public class StealCutProblem {
	int len;
	/** 钢条价格*/
	public int[] p;
	/** 结果集备忘录 */
	public int[] r;
	/** 分割点*/
	public int[] s;
	
	public StealCutProblem(){
		
	}
	
	
	public StealCutProblem(int len) {
		this.len = len;
		this.p = new int[len+1];
		this.r = new int[len+1];
		this.s = new int[len+1];
	}

	/**
	 * R(n) = max(P(i) + R(n-i)) 1<=i<=n
	 */
	public int cutRecursion(int n){
		
		if (n == 0) return 0;
		if (r[n] > 0) return r[n];
		int Rmax = -1;
		for(int i=1; i<=n; i++){
			int Ri = p[i] + cutRecursion(n - i);
			if (Ri > Rmax) {
				Rmax = Ri;
				r[i]  = Ri;
				s[i]  = i;
			}
		}
		return Rmax;
	}
	
	public int cutBottomToHead(){
		
		
		for(int j=1; j<=len; j++) {
			int q = -1;
			for(int i=1; i<=j; i++){
				int tem = p[i] + r[j-i];
				if(tem > q) {
					q = tem;
					r[j] = q;
					s[j] = i;
				}
			}
		}
		return r[len];	
		
	}
	
	public void print(int n){
		int position = 0;
		while(n > 0 ) {
			int i = s[n];
			position+=i;
			System.out.print(position + " ");
			n-=i;
		}
	}
	
	
	
	public static void main(String[] args) {
		int len = 8;
		
		int[] p = {0,1,5,8,9,10,17,17,20,24,30,31,32,33,35};
		
		StealCutProblem cutp = new StealCutProblem();
		cutp.p = p;
		System.out.println(cutp.cutRecursion(len));
		
		StealCutProblem luckup = new StealCutProblem(len);
		luckup.p = p;
		System.out.println(luckup.cutBottomToHead());
		luckup.print(len);
	}
}
