package realization;

/**
 * 
 * 
 * m[i,j] = min( m[i,k] + m[k+1,j] + p[i-1]p[k]p[j]  )  i<=k<j ��
 *  m[k,k] = 0
 * ���ù�ʽ�𲽵����̾������ĳ��ȣ�ֱ������Ϊ1
 */

public class MatrixMultipleProblem {
	
	int[] p;
	/** m[i][j] ΪAiAj��������˵���С����*/
	int[][] m;
	/** r[i][j] Ϊm[i][j]ȡ��ʱ�ķָ��*/
	int[][] r;
	
	/**
	 * �ݹ�ⷨ
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
	 * �Զ�����, ������¼�ĵݹ��㷨
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
	 * �Ե����ϵ�dp�ⷨ
	 * @param n
	 * @return
	 */
	public int MultipleMatrixChainOrder(int n){
		for(int l=2;l<=n;l++){//����������
			for(int i=1;i<n-l+1;i++) { // ����Ϊl,i�����ֵΪn-l+1
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
