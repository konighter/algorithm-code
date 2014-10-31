package datastruct;

public class TrieTree {
	
	TrieTreeNode root;
	
	public TrieTree(){
		root = new TrieTreeNode();
	}
	
	static class TrieTreeNode {
		/** �����ڵ�ĵ������� */
		int num;
		TrieTreeNode[] child;
		boolean isEnd;
		char value;
		
		public TrieTreeNode(){
			num = 1;
			child = new TrieTreeNode[26];
			isEnd = false;
		}
	}
	
	/**
	 * ������ȫƥ��ĵ��ʣ���һֱ��Ҷ�ӽڵ�
	 * @param str
	 * @return
	 */
	boolean search(String str){
		char[] chars = str.toCharArray();
		TrieTreeNode node = root;
		for(int i=0; i<chars.length; i++){
			int pos = chars[i] - 'a';
			if(node.child[pos] != null){
				node = node.child[pos];
			}else{
				return false;
			}
		}
		return node.isEnd;
	}
	
	/**
	 * ����һ���ַ���
	 * @param str
	 */
	void insert(String str){
		char[] chars = str.toCharArray();
		TrieTreeNode node = root;
		for(char c : chars){
			int pos = c - 'a';
			if(node.child[pos] != null) {
				node = node.child[pos];
				node.num++;
			}else{
				node.child[pos] = new TrieTreeNode();
				node = node.child[pos];
				node.value = c;
				node.isEnd = false;
				node.num = 1;
			}
		}
		node.isEnd = true;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
