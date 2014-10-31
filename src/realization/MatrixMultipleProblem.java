package realization;

/**
 * 
 * 
 * m[i,j] = min( m[i,k] + m[k+1,j] + p[i-1]p[k]p[j]  )  i<=k<j ；
 *  m[k,k] = 0
 * 利用公式逐步的缩短矩阵链的长度，直至长度为1
 */

public class MatrixMultipleProblem {
	
	int[] p;
	/** m[i][j] 为AiAj矩阵链相乘的最小代价*/
	int[][] m;
	/** r[i][j] 为m[i][j]取得时的分割点*/
	int[][] r;
	
	/**
	 * 递归解法
	 * @param i
	 * @param j
	 * @return
	 */
	public int recursiveMultipleMatrix(int i,int j){
		if(i==j) return 0;
		int max = -1;
		
		for(int k=i;k<j;k++){
			int tmp = recursiveMultipleMatrix(i,k) + recursiveMultipleMatrix(k+1,j) + p[i-1]*p[k]*p[j];
			max = Math.max(max, tmp);
		}
		
		return max;
	}
	
	/**
	 * 自顶向下, 带备忘录的递归算法
	 * @param i
	 * @param j
	 * @return
	 */
	public int recursiveMakeupMultipleMatrix(int i,int j){
		if(i==j) return 0;
		if(m[i][j] > 0) return m[i][j];
		int min = Integer.MAX_VALUE;
		
		for(int k=i;k<j;k++){
			int tmp = recursiveMultipleMatrix(i,k) + recursiveMultipleMatrix(k+1,j) + p[i-1]*p[k]*p[j];
			if(tmp < min) {
				min = tmp;
				m[i][j] = min;
				r[i][j] = k;
			}
		}
		
		return min;
	}
	
	/**
	 * 自底向上的dp解法
	 * @param n
	 * @return
	 */
	public int MultipleMatrixChainOrder(int n){
		for(int l=2;l<=n;l++){//矩阵链长度
			for(int i=1;i<n-l+1;i++) { // 长度为l,i的最大值为n-l+1
				int j = i+l-1;
				int min = Integer.MAX_VALUE;
				for(int k=i;k<j;k++) {
					int tmp = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
					if(tmp < min){
						min = tmp;
						m[i][j] = min;
						r[i][j] = k;
					}
				}
			}
		}
		
		return m[1][n];
	}
	
	
	public static void main(String[] args) {
		
	}
}
