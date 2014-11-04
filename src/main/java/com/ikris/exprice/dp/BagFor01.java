package com.ikris.exprice.dp;

public class BagFor01 {
	
	/** 记录第i个商品是否选*/
	int[] r;
	/** 结果备忘录*/
	int[][] f;
	/** 物品重量*/
	int[] w;
	/** 物品价值*/
	int[] v;
	
	int recursiveBagChose(int i, int w){
		if(i<=0 || w<= 0) return 0;
		if(this.w[i] > w) return recursiveBagChose(i-1,w);
		
		int tmp  = Math.max(recursiveBagChose(i-1,w),( recursiveBagChose(i-1,w-this.w[i]) + this.v[i] ));
		
		this.f[i][w] = tmp;
		this.r[i] = 0 | 1;
		
		return tmp;
	}
	
	void bagChose(int I , int W){
		
		for(int i=1;i<=I;i++) {
			f[i][0] = 0;
			for(int w=1;w<=w;w++){
				if(this.w[i] > w) {
					f[i][w] = f[i-1][w];
				}
				else {
					int tmp = f[i-1][w-this.w[i]] + v[i];
					int tmp2 = f[i-1][w];
					if(tmp2 > tmp){
						f[i][w] = f[i-1][w];
					}else{
						f[i][w] = tmp;
						r[i] = 1;
					}
					
				}
				
				
				
			}
			
		}
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
